/**
 * 
 */
package cn.com.sinosafe.service.padb.impl;


import java.util.ArrayList;
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

import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.config.constant.PspClaimConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.dao.PspClaimApproveRecodeMapper;
import cn.com.sinosafe.dao.PspClaimPaphRecodeMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.entity.PspClaimApproveRecode;
import cn.com.sinosafe.domain.entity.PspClaimPaphRecode;
import cn.com.sinosafe.service.padb.PspClaimApproveService;

/**  
* <p>Title: PspClaimApproveServiceImpl</p>  
* <p>Description: 核赔申请实现类</p>  
* @author longxiaoqiang  
* @date 2019年8月27日  
*/
@Service
public class PspClaimApproveServiceImpl implements PspClaimApproveService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PspClaimApproveRecodeMapper pspClaimApproveRecodeMapper;
	@Autowired
	private AsyncDealService asyncDealService;
	@Autowired
	private PspClaimPaphRecodeMapper pspClaimPaphRecodeMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public String pspClaimApprove(Map<String, Object> paramMap) throws Exception {
		logger.info("*****************************核赔申请接口 start*****************************");
		logger.info("param={}",paramMap);
		String resultCode=PaResultCode.PA_SUCCESS.code();
		String resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
		Map<String, String> resultMap=new HashMap<String, String>();
		
		/*List<Map<String, Object>> map = pspClaimApproveRecodeMapper.getPaphData();
		
		for (Map dateMap:map) {
			logger.info(JSONUtils.getSingleInstance().toJSon(dateMap));
			Map<String, Object> perAmt = JSONUtils.getSingleInstance().readMapValue(String.valueOf(dateMap.get("TRANSFER_REQ")));
			logger.info(String.valueOf(dateMap.get("TRANSFER_REQ")));
			String amt = String.valueOf(dateMap.get("TRANSFER_REQ"));
			JSONUtils.getSingleInstance().readMapValue(amt);
			JSONObject jsonObject = JSONObject.parseObject(amt);
			String aaa = (String) JSONPath.eval(jsonObject, "$.tasks[0].data.everyPremFee");
			logger.info((String) JSONPath.eval(jsonObject, "$.tasks[0].data.everyPremFee"));
			int a = aaa.indexOf("￥")+1;
			int b = aaa.lastIndexOf("元");
			aaa = aaa.substring(a, b);
			dateMap.put("TRANSFER_REQ", aaa);
		}
		String jstrings = JSONUtils.getSingleInstance().toJSon(map);
		System.out.println(jstrings);
		for (Map bbb:map) {
			PspClaimPaphRecode pspClaimPaphRecode = new PspClaimPaphRecode();
			pspClaimPaphRecode.setApplNo((String)bbb.get("TRANSFER_REQ"));
			pspClaimPaphRecode.setClaimBatchNo((String)bbb.get("LIST_SERNO"));
			pspClaimPaphRecode.setClaimDate((String)bbb.get("COVER_END_DATE"));
			pspClaimPaphRecode.setLnAcct((String)bbb.get("TERM"));
			pspClaimPaphRecodeMapper.insertSelective(pspClaimPaphRecode);
		}*/
		//字段校验
		if(LstIqpApplyConstant.checkFieldDefect(paramMap,new String[]{"premBatchNo","premCount","IsHoliday","claimsApplyList","insuCompany"})){
			resultCode=PaResultCode.PA_FIELD_DELETION.code();
			resultMsg=PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
		}else{
			if (LstIqpApplyConstant.checkListFieldDefectByStr(String.valueOf("claimsApplyList"),paramMap,new String[] {"lnAcct","applNo","claimType","lnAmt","lnTerm","claimAmt","prinAmt","intAmt","lcAmt","premDate"})) {
				resultCode=PaResultCode.PA_FIELD_DELETION.code();
				resultMsg=PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
			} else {
				try {
					//记录核赔数据
					List<PspClaimApproveRecode> importData=PspClaimConstant.convertPspClaimApproveRecode(paramMap);
					insetPspClaimApprove(importData);
					logger.info("核赔申请批次号：{}数据入库成功",String.valueOf(paramMap.get("premBatchNo")));
					
					//获取节假日Y-是，N-否;
					String iSHoliday = String.valueOf(paramMap.get("IsHoliday"));
					logger.info("核赔申请批次号：{} 是否节假日{}",String.valueOf(paramMap.get("premBatchNo")),iSHoliday);
					
					//节假日无需处理直接返回
					if ("Y".equals(iSHoliday)) {
						resultCode=PaResultCode.PA_SUCCESS.code();
						resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
					} else {
						//异步核赔
						asyncDealService.pspClaimAsynDeal(paramMap);
					}
				} catch (Exception e) {
					logger.error("error:{}",e.getMessage());
					throw new BusinessException(e.getMessage());
				}
			}
		}
		resultMap.put("resultCode",String.valueOf(resultCode));
		resultMap.put("resultMsg", resultMsg);
		logger.info("*****************************核赔申请接口 end*****************************");
		return JSON.toJSONString(resultMap);
	}
	
	/**  
	 * <p>Title: insetPspClaimApprove</p>  
	 * <p>Description: 核保申请入库</p>  
	 * @param importData  
	 */
	private void insetPspClaimApprove(List<PspClaimApproveRecode> importData) {
		for (PspClaimApproveRecode psp:importData) {
			pspClaimApproveRecodeMapper.insertSelective(psp);
		}
		
	}

}
