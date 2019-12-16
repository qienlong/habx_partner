/**   
* @Title:：PaLstIqpOptServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月10日 上午10:30:50 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.config.constant.PaLstIqpOptConstant;
import cn.com.sinosafe.common.config.properties.IssueMsgProperties;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.downUpContractListExecutor;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.dao.CusIndivMapper;
import cn.com.sinosafe.dao.IqpMeCusAppMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.bean.SentStatusCode;
import cn.com.sinosafe.domain.dto.ContractUpload;
import cn.com.sinosafe.domain.entity.CusIndiv;
import cn.com.sinosafe.domain.entity.IqpMeCusApp;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.other.axsign.AxSignService;
import cn.com.sinosafe.service.padb.PaLstIqpOptService;
import cn.com.sinosafe.service.padb.PaPhCommonService;

/** 
 * @ClassName:：PaLstIqpOptServiceImpl 
 * @Description： 投保申请业务流程
 * @author ：xiewei
 * @date ：2019年6月10日 上午10:30:50  
 */
@Service
public class PaLstIqpOptServiceImpl implements PaLstIqpOptService {
	private final static Logger logger = LoggerFactory.getLogger(AxSignService.class);
	
	@Autowired
	private IqpMeCusAppMapper iqpMeCusAppMapper;
	@Autowired
	private CusIndivMapper cusIndivMapper;
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private AsyncDealService asyncDealService;
	@Autowired
	private AxSignService axSignService;
	@Autowired
	private PaPhCommonService paPhCommonService;
	@Autowired 
	private IssueMsgProperties issueMsgPro;
	
	
	@Override
	public String queryLstInfoByApplNo(String applNo) {
		logger.info("********************************queryLstInfoByApplNo start********************************");
		logger.info("applNo:{}",applNo);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		Calendar calendar=Calendar.getInstance();
		try {
			//根据申请号查询申请信息
			IqpMeCusApp iqpMeCus=iqpMeCusAppMapper.selectByPrimaryKey(applNo);
			if(null==iqpMeCus||StringUtils.isEmpty(iqpMeCus.getCusId())){throw new BusinessException("不存在该笔数据、数据异常");}
			CusIndiv cusInfo=cusIndivMapper.selectByPrimaryKey(iqpMeCus.getCusId());
			if(null==cusInfo){throw new BusinessException("不存在该笔数据、数据异常");}
			LstIqpInfo lstIqpInfo=new LstIqpInfo();
			lstIqpInfo.setIqpLoanSerno(iqpMeCus.getSerno());
			lstIqpInfo=lstIqpInfoMapper.selectBySernoAndStatus(lstIqpInfo);
			if(null==lstIqpInfo){throw new BusinessException("不存在该笔数据、数据异常");}
			if(lstIqpInfo.getIspermit().equals(LstIqpApplyConstant.IS_PERMIT)){
				//平安成功h5
			}else{
				//华安投保页面
				if(StringUtils.isEmpty(cusInfo.getRegisterId())){
					//没有注册安心签用户，开户操作
					logger.info("************安心签开户接口  stat*************");
					logger.info("请求参数:cusName:{},id:{},phone:{}",iqpMeCus.getCusName(),iqpMeCus.getCertCode(),iqpMeCus.getMobile());
					String registerId=axSignService.registerOnAxSign(iqpMeCus.getCusName(), iqpMeCus.getCertCode(), iqpMeCus.getMobile());
					logger.info("响应结果：registerId:{}",registerId);
					logger.info("************安心签开户接口  end*************");
					if(StringUtils.isEmpty(registerId)){throw new BusinessException("安心签开户异常");}
					//安心签唯一标识保存到对私客户信息表中
					cusInfo.setRegisterId(registerId);
					cusIndivMapper.updateByPrimaryKeySelective(cusInfo);
				}
				resultMap.put("mobile", iqpMeCus.getMobile());
				Map<String, Object> infoMap=PaLstIqpOptConstant.getTempInfo(calendar, cusInfo, lstIqpInfo);
				resultMap.put("infoMap", infoMap.get("infoMap"));
				resultMap.put("lstInfoMap", infoMap.get("lstInfoMap"));
			}
			resultMap.put("cusId", cusInfo.getCusId());
			resultMap.put("resultCode", PaResultCode.PA_SUCCESS.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
			resultMap.put("paH5Url", iqpMeCus.getReturnurl());
			resultMap.put("isPermit", lstIqpInfo.getIspermit());
		} catch (Exception e) {
			resultMap.put("resultCode", PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", e.getMessage());
			logger.error("error:{}",e.getMessage());
		}
		logger.info("********************************queryLstInfoByApplNo end********************************");
		return JSON.toJSONString(resultMap);
	}

	@Override
	public String getSmsCode(String applNo, String cusId) {
		logger.info("********************************getSmsCode start********************************");
		logger.info("applNo:{},cusId{}",applNo,cusId);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		try {
			CusIndiv cusInfo=cusIndivMapper.selectByPrimaryKey(cusId);
			if(null==cusInfo||StringUtils.isEmpty(cusInfo.getRegisterId())){throw new BusinessException("不存在该笔数据、数据异常");}
			LstIqpInfo lstIqpInfo=new LstIqpInfo();
			lstIqpInfo.setIqpLoanSerno(applNo);
			lstIqpInfo=lstIqpInfoMapper.selectBySernoAndStatus(lstIqpInfo);
			applNo = lstIqpInfo.getSerno();
			//发送验证码操作
			logger.info("************安心签验证码发送  stat*************");
			logger.info("请求参数:applNo:{},registerId:{}",applNo,cusInfo.getRegisterId());
			boolean boo=axSignService.sendAuthorizedSms(cusInfo.getRegisterId(), applNo, lstIqpInfo.getPrdId());
			logger.info("响应结果：boo:{}",boo);
			logger.info("************安心签验证码发送  end*************");
			if(boo){
				resultMap.put("resultCode", PaResultCode.PA_SUCCESS.code());
				resultMap.put("resultMsg", PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
			}else{
				throw new BusinessException("验证授权码发送失败");
			}
		} catch (Exception e) {
			resultMap.put("resultCode", PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg",e.getMessage());
			logger.error("errorInfo:{}",e.getMessage());
		}
		logger.info("********************************getSmsCode error********************************");
		return JSON.toJSONString(resultMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String confirmSign(String applNo, String cusId, String code,String ipAddr) {
		logger.info("********************************getSmsCode start********************************");
		logger.info("applNo:{},cusId{},code{}",applNo,cusId,code);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		Calendar calendar=Calendar.getInstance();
		List<ContractUpload> uploads=null;
		try {
			CusIndiv cusInfo=cusIndivMapper.selectByPrimaryKey(cusId);
			if(null==cusInfo||StringUtils.isEmpty(cusInfo.getRegisterId())){throw new BusinessException("cusInfo 不存在该笔数据、数据异常");}
			//修改投保单信息为已签署
			LstIqpInfo lstIqpInfo=new LstIqpInfo();
			lstIqpInfo.setIqpLoanSerno(applNo);
			lstIqpInfo=lstIqpInfoMapper.selectBySernoAndStatus(lstIqpInfo);
			if(null==lstIqpInfo){throw new BusinessException("lstIqpInfo 不存在该笔数据、数据异常");}
			//确认安心签验证码是否正常
			logger.info("************安心签验证码确认  stat*************");
			logger.info("请求参数:applNo:{},registerId:{},code:{}",lstIqpInfo.getSerno(),cusInfo.getRegisterId(),code);
			boolean boo=axSignService.confirmAuthorizedSms(cusInfo.getRegisterId(), lstIqpInfo.getSerno(), code);
			logger.info("响应结果：boo:{}",boo);
			logger.info("************安心签验证码确认  end*************");
			if(boo){
				try {
					//获取模板
					Map<String, Object> infoMap=PaLstIqpOptConstant.getTempInfo(calendar, cusInfo, lstIqpInfo);
					//信息授权书模板SystemConfig.cacheMap.get("")
					JSONObject infoObj=axSignService.createContractVO(issueMsgPro.getWrittenboard(), cusInfo.getRegisterId(), ipAddr, "Signature", lstIqpInfo.getSerno(), (Map<String, String>)infoMap.get("infoMap"));
					// 签署信息授权书电子合同
					logger.info("************签署信息授权书电子合同  stat*************");
					logger.info("请求参数:infoObj:{},applNo:{}",lstIqpInfo.getSerno(),JSON.toJSONString(infoObj));
					String resultMsg = axSignService.createContractVOAndSign(JSON.toJSONString(infoObj), lstIqpInfo.getSerno());
					logger.info("响应结果：resultMsg:{}",resultMsg);
					logger.info("************签署信息授权书电子合同  end*************");
					int rspCode = (int) JSONPath.eval(JSONObject.parseObject(resultMsg), "$.code");
					if(rspCode != 1){throw new BusinessException("信息授权书模板签署异常");}
					uploads=new ArrayList<ContractUpload>();
					JSONObject obj=getUploadObj(resultMsg);
					ContractUpload contractUpload=new ContractUpload(obj.getString("contractNo"),obj.getString("contractName"),applNo,"XFD","XFD_00302","text_type_00");
					uploads.add(contractUpload);
					//投保单模板
					infoObj=axSignService.createContractVO(issueMsgPro.getLstboard(), cusInfo.getRegisterId(), ipAddr, "Signature", lstIqpInfo.getSerno(), (Map<String, String>)infoMap.get("lstInfoMap"));
					// 签署投保单电子合同
					logger.info("************签署投保单电子合同  stat*************");
					logger.info("请求参数:infoObj:{},applNo:{}",lstIqpInfo.getSerno(),JSON.toJSONString(infoObj));
					resultMsg = axSignService.createContractVOAndSign(JSON.toJSONString(infoObj), lstIqpInfo.getSerno());
					logger.info("响应结果：resultMsg:{}",resultMsg);
					logger.info("************签署投保单电子合同  end*************");
					rspCode = (int) JSONPath.eval(JSONObject.parseObject(resultMsg), "$.code");
					if(rspCode != 1){throw new BusinessException("投保单模板签署异常");}
					obj=getUploadObj(resultMsg);
					contractUpload=new ContractUpload(obj.getString("contractNo"),obj.getString("contractName"),applNo,"XFD","XFD_T170205","text_type_01");
					uploads.add(contractUpload);
					lstIqpInfo.setIspermit("1");
					lstIqpInfo.setSignDate(DateUtils.getDate("yyyy-MM-dd"));
					lstIqpInfoMapper.updateByPrimaryKeySelective(lstIqpInfo);
					//异步调用上传合同接口
					downUpContractListExecutor executor = new downUpContractListExecutor();
					executor.fun(JSON.toJSONString(uploads));
					
				} catch (Exception e) {
					throw new BusinessException("签署电子合同  error:"+e.getMessage());
				}
				//添加接口状态流程
				//paPhCommonService.statusUpdateService(applNo, SentStatusCode.PA_02.code(), "投保成功");
				
				resultMap.put("resultCode", PaResultCode.PA_SUCCESS.code());
				resultMap.put("resultMsg",PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
			}else{
				throw new BusinessException("验证码不正确或已失效");
			}
		} catch (Exception e) {
			paPhCommonService.statusUpdateService(applNo, SentStatusCode.PA_03.code(), "投保失败");
			resultMap.put("resultCode", PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg",e.getMessage());
			logger.error("errorInfo:{}",e.getMessage());
		}
		//获取Access_Token（get请求）
		String accToken = "";
		if (StringUtils.isEmpty(accToken)) {
			try {
				String accTokenRsp = HttpClientUtil.httpGet(SystemConfig.cacheMap.get("access_token"));
//				Map<String, Object> map = JSONUtils.getSingleInstance().readMapValue(accToken);
				JSONObject rspJson = JSONObject.parseObject(accTokenRsp);
				accToken = (String) JSONPath.eval(rspJson, "$.data.access_token");
			} catch (IOException e) {
				logger.error("errorInfo:{}","获取token失败！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("获取的token{}",accToken);
		//异步调用保单信息同步接口
		/*String reponseMsg = */
		asyncDealService.fcfpPolicyInfoSync(accToken,applNo,String.valueOf(resultMap.get("resultCode")));
//		System.out.println("异步调用保单信息同步接口返回报文"+reponseMsg);
		logger.info("********************************getSmsCode end********************************");
		return JSON.toJSONString(resultMap);
	}
	
	
	@Override
	public String confirmSignNo(String applNo, String cusId, String code,String ipAddr) {
		logger.info("********************************getSmsCode start********************************");
		logger.info("applNo:{},cusId{},code{}",applNo,cusId,code);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		try {
			LstIqpInfo lstIqpInfo=new LstIqpInfo();
			lstIqpInfo.setIqpLoanSerno(applNo);
			lstIqpInfo=lstIqpInfoMapper.selectBySernoAndStatus(lstIqpInfo);
			if(null==lstIqpInfo){throw new BusinessException("lstIqpInfo 不存在该笔数据、数据异常");}
			lstIqpInfo.setIspermit("1");
			lstIqpInfo.setSignDate(DateUtils.getDate("yyyy-MM-dd"));
			lstIqpInfoMapper.updateByPrimaryKeySelective(lstIqpInfo);
			
			resultMap.put("resultCode", PaResultCode.PA_SUCCESS.code());
			resultMap.put("resultMsg",PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
			
		} catch (Exception e) {
			resultMap.put("resultCode", PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg",e.getMessage());
			logger.error("errorInfo:{}",e.getMessage());
		}
		
		//获取Access_Token（get请求）
		String accToken = "";
		if (StringUtils.isEmpty(accToken)) {
			try {
				String token = SystemConfig.cacheMap.get("access_token");
				String accTokenRsp = HttpClientUtil.httpGet(token);
//				Map<String, Object> map = JSONUtils.getSingleInstance().readMapValue(accToken);
				JSONObject rspJson = JSONObject.parseObject(accTokenRsp);
				accToken = (String) JSONPath.eval(rspJson, "$.data.access_token");
			} catch (IOException e) {
				logger.error("errorInfo:{}","获取token失败！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("获取的token{}",accToken);
		
		//异步调用保单信息同步接口
		/*String reponseMsg = */
		asyncDealService.fcfpPolicyInfoSync(accToken,applNo,String.valueOf(resultMap.get("resultCode")));
//		System.out.println("异步调用保单信息同步接口返回报文"+reponseMsg);
		logger.info("********************************getSmsCode end********************************");
		return JSON.toJSONString(resultMap);
	}
	
	/**
	 * 
	* @Title：getUploadObj 
	* @Description：解析获取上传需要的数据
	* @param ：@param resultMsg
	* @param ：@return
	* @param ：@throws Exception 
	* @return ：JSONObject 
	* @throws
	 */
	private JSONObject getUploadObj(String resultMsg) throws Exception{
		JSONObject result=null;
		try {
			JSONObject json=JSONObject.parseObject(resultMsg);
			JSONObject dataJson=json.getJSONObject("data");
			result=dataJson.getJSONObject("contract");
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		return result;
		
	}
	
}
