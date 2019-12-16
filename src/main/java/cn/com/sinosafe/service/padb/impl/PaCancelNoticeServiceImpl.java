/**   
* @Title:：CancelNoticeServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午8:10:47 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb.impl;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSON;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.dao.AccLoanMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.bean.SentStatusCode;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.service.padb.PaCancelNoticeService;
import cn.com.sinosafe.service.padb.PaPhCommonService;

/** 
 * @ClassName:：CancelNoticeServiceImpl 
 * @Description： 退汇取消通知接口			
 * @author ：xiewei
 * @date ：2019年6月8日 下午8:10:47  
 */
@Service
public class PaCancelNoticeServiceImpl implements PaCancelNoticeService{
	
	Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AccLoanMapper accLoanMapper;
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private PaPhCommonService paPhCommonService;
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String cancelRemitAll(Map<String, Object> paramMap) throws Exception{
		logger.info("*****************************退汇取消通知接口 start*****************************");
		logger.info("param={}",paramMap);
		String resultCode="";
		String resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
		Map<String, String> resultMap=new HashMap<String, String>();
		//字段校验
		if(LstIqpApplyConstant.checkFieldDefect(paramMap,new String[]{"applNo","lnAcct","baLoanDate","insuCompany","source"})){
			resultCode=PaResultCode.PA_FIELD_DELETION.code();
			resultMsg=PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
		}else{
			try {
				
				//更新申请信息状态
				logger.info("更新申请信息  ipMeLoan start");
				IqpMeLoanApp iqpMeLoanApp = getIqpCondition(paramMap);
				iqpMeLoanAppMapper.updateByPrimaryKeySelective(iqpMeLoanApp);
				logger.info("更新申请信息 ipMeLoan end");
				
				//更新台账信息
				logger.info("更新台账状态  accLoan start");
				accLoanMapper.updateStatusByPrimaryKey(String.valueOf(paramMap.get("lnAcct")));
				logger.info("更新台账状态  accLoan end");
				
				//查询已生成保单的投保单
				logger.info("更新保单状态  LstIqpInfo start");
				LstIqpInfo lstInfo=new LstIqpInfo();
				lstInfo.setIqpLoanSerno(String.valueOf(paramMap.get("applNo")));
				LstIqpInfo lstIqpInfo=lstIqpInfoMapper.selectBySernoAndStatus(lstInfo);
				if(null==lstIqpInfo){throw new BusinessException("lstIqpInfo is null");}
				
				if ("04".equals(lstIqpInfo.getCoverCreateStatus())) {
					
					//调接口注销保单
					Map<String,String> map = new HashMap<String,String>();
					map.put("applNo", String.valueOf(paramMap.get("applNo")));
					map.put("refuseTime", String.valueOf(DateUtils.format(DateUtils.parseDate(paramMap.get("baLoanDate")), "yyyy-MM-dd HH:mm:ss")));
					map.put("policyNo", "");
					map.put("requestType", "02");
					String params = JSONUtils.getSingleInstance().toJSon(map);
					logger.info("调接口注销保单参数为={}",map.toString());
					String result = HttpClientUtil.httpPost(SystemConfig.cacheMap.get("PAPH_CANCEL_IQP"), params);
					logger.info("调接口注销保单返回={}",result);
					Map<String, Object> resultParam = JSONUtils.getSingleInstance().readMapValue(result);
					String retCode = (String)resultParam.get("retCode");
					if ("S".equals(retCode)) {
						resultCode=PaResultCode.PA_SUCCESS.code();
						resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
						sendMsg(lstIqpInfo);
					} else {
						resultCode=PaResultCode.PA_FAIL.code();
						resultMsg=PaResultGenerator.DEFAULT_FAIL_MESSAGE;
					}
				} else {
					//注销投保单
					lstIqpInfo.setStatus("998");
					lstIqpInfo.setApplyStatus("998");
					lstIqpInfo.setCoverCreateStatus("03");
					lstIqpInfoMapper.updateByPrimaryKeySelective(lstIqpInfo);
					logger.info("更新保单状态  LstIqpInfo end");
					
					resultCode=PaResultCode.PA_SUCCESS.code();
					resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
				}
			} catch (Exception e) {
				logger.error("error:{}",e.getMessage());
				throw new BusinessException(e.getMessage());
			}
			//resultCode=PaResultCode.PA_SUCCESS.code();
		}
		if ("0000".equals(resultCode)) {
			paPhCommonService.statusUpdateService(String.valueOf(paramMap.get("applNo")), SentStatusCode.PA_15.code(), "已退票");
		}
		resultMap.put("resultCode",String.valueOf(resultCode));
		resultMap.put("resultMsg", resultMsg);
		logger.info("*****************************退汇取消通知接口 end*****************************");
		return JSON.toJSONString(resultMap);
	}
	
	private IqpMeLoanApp getIqpCondition (Map<String,Object> paramMap) {
		IqpMeLoanApp iqpMeLoanApp = new IqpMeLoanApp();
		iqpMeLoanApp.setSerno(String.valueOf(paramMap.get("applNo")));
		iqpMeLoanApp.setApproveStatus("998");
		iqpMeLoanApp.setNewApproveStatus("998");
		iqpMeLoanApp.setAppStatus("998");
		return iqpMeLoanApp;
	}
	
	private void sendMsg(LstIqpInfo lstIqpInfo) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("{0521险种名称}", lstIqpInfo.getPrdSubCode());
		map.put("${ply_no}", lstIqpInfo.getListSerno());
		paPhCommonService.pushSms(4, map, lstIqpInfo.getMobile());
	}
}
