/**   
* @Title:：PolicyGenerationMsgServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月3日 下午2:41:16 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cn.com.sinosafe.common.config.constant.IssuedMsgConstant;
import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.config.properties.IssueMsgProperties;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.bean.SentStatusCode;
import cn.com.sinosafe.domain.dto.PaPolicyInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.service.padb.IssuedMsgService;
import cn.com.sinosafe.service.padb.PaPhCommonService;

/** 
 * @ClassName:：PolicyGenerationMsgServiceImpl 
 * @Description： 保单生成通知
 * @author ：xiewei
 * @date ：2019年6月3日 下午2:41:16  
 */
@Service
public class IssuedMsgServiceImpl implements IssuedMsgService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	
	@Autowired IssueMsgProperties issueMsgPro;
	
	@Autowired
	private PaPhCommonService paPhCommonService;
	
	@Autowired
	private AsyncDealService asyncDealService;

	@Override
	public String issuePolicy(Map<String, Object> paramMap) throws Exception {
		logger.info("*****************************出单接口通知 start*****************************");
		logger.info("param:{}",paramMap);
		String resultCode=PaResultCode.PA_SUCCESS.code();
		PaPolicyInfo paPolicyInfo=null;
		String msg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
		Map<String, String> result=new HashMap<String, String>();
		//字段校验
		Map<String, Object> resultMap=checkField(paramMap);
		if((boolean) resultMap.get("result")){
			resultCode=PaResultCode.PA_FIELD_DELETION.code();
			msg=PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
		}else{
			try {
				paPolicyInfo=JSONObject.parseObject(JSON.toJSONString(resultMap.get("policyInfo")),PaPolicyInfo.class);
				//更新保单信息数据
				LstIqpInfo liInfo=new LstIqpInfo();
				liInfo.setIqpLoanSerno(StringUtils.trim(paPolicyInfo.getApplNo()));
				liInfo.setStatus(issueMsgPro.getStatus());
				logger.info("query LstIqpInfo IqpLoanSerno is {}",paPolicyInfo.getApplNo());
				//获取符合条件的投保单
				LstIqpInfo lstIqpInfo=lstIqpInfoMapper.selectBySernoAndStatus(liInfo);
				if(null==lstIqpInfo){
					throw new BusinessException("listIqpInfo is null");
				}
				logger.info("listIqpInfo before update info:"+lstIqpInfo.toString());
				//更新保单数据
				IssuedMsgConstant.dtoToBo(lstIqpInfo, paPolicyInfo);
				logger.info("listIqpInfo after update info:"+lstIqpInfo.toString());
				lstIqpInfoMapper.updateByPrimaryKeySelective(lstIqpInfo);
				//获取出单员
				String inputName = lstIqpInfoMapper.getInputNameById(lstIqpInfo.getInputId());
				//执行出单通知 调用电子保单接口
				asyncDealService.sendMsgToList(issueMsgPro.getAddr(),issueMsgPro.getPattern(),lstIqpInfo,inputName);
				//调用电子保单接口
				//asyncDealService.sendEleListParam(lstIqpInfo,inputName);
				
				//执行接口状态码更新已通知出单
				paPhCommonService.statusUpdateService(lstIqpInfo.getIqpLoanSerno(), SentStatusCode.PA_10.code(), "已通知出单");
			} catch (Exception e) {
				logger.error("error:{}",e.getMessage());
				throw new BusinessException(e.getMessage());
			}
		}
		result.put("resultCode",String.valueOf(resultCode));
		result.put("resultMsg",String.valueOf(msg));
		String jsonString = JSON.toJSONString(result);
		logger.info("要返回的結果為：{}",jsonString);
		logger.info("*****************************出单接口通知 end*****************************");
		return jsonString;
	}
	
	/* (non-Javadoc)
	 * @see cn.com.sinosafe.service.padb.IssueMsgService#getpolicyDataByTemplate(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> getpolicyDataByTemplate(String templateType,
			String serNo) throws Exception{
		LstIqpInfo liInfo=new LstIqpInfo();
		liInfo.setIqpLoanSerno(StringUtils.trim(serNo));
		liInfo.setStatus(issueMsgPro.getStatus());
		try {
			//获取符合条件的投保单
			LstIqpInfo lstIqpInfo=lstIqpInfoMapper.selectBySernoAndStatus(liInfo);
			if(null==lstIqpInfo){throw new BusinessException("lstIqpInfo is null");}
			logger.info("listIqpInfo info:"+String.valueOf(lstIqpInfo));
			
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * 
	* @Title：checkField 
	* @Description：字段校验
	* @param ：@param lstIqpInfo
	* @param ：@return 
	* @return ：boolean 
	* @throws
	 */
	public Map<String, Object> checkField(Map<String, Object> paramMap) {
		Map<String, Object> resultMap=new HashMap<String, Object>();
		Map<String, Object> policyInfo=null;
		List<Map<String, Object>> extendList=null;
		boolean boo=false;
		try {
			//解析paramMap
			if(LstIqpApplyConstant.checkFieldDefect(paramMap, new String[]{"policyInfo","insuCompany","source"})){
				boo=true;
			}else{
				//解析policyInfo
				policyInfo=(Map<String, Object>) paramMap.get("policyInfo");
				if(LstIqpApplyConstant.checkFieldDefect(policyInfo, new String[]{"checkNo", "applNo", "mobile", "lnAmt", "lnDate", "lnTerm"})){
					boo=true;
				}else{
					//解析保单扩展信息
					extendList=(List<Map<String, Object>>)paramMap.get("extendList");
					if(null!=extendList){
						for(int i=0 ; i < extendList.size();i++){
						    //获取每一个JsonObject对象
							Map<String, Object> jsonObj = extendList.get(i);
						    if(LstIqpApplyConstant.checkFieldDefect(jsonObj, new String[]{"valueType", "basicValue"})){
						    	boo=true;
						    	break;
							}
						    if(boo){break;}
						}
					}
				}
			}
		} catch (BusinessException e) {
			logger.error("checkField error "+e.getMessage());
			boo=true;
			e.printStackTrace();
		}
		resultMap.put("policyInfo", policyInfo);
		resultMap.put("extendList", extendList);
		resultMap.put("result", boo);
		return resultMap;
	}

}
