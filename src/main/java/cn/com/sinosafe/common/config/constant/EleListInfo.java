/**
 * 
 */
package cn.com.sinosafe.common.config.constant;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.domain.entity.FeeRate;
import cn.com.sinosafe.domain.entity.LstIqpInfo;

/**  
* <p>Title: GetEleListInfo</p>  
* <p>Description: 获取电子表单参数</p>  
* @author longxiaoqiang  
* @date 2019年7月5日  
*/
@Component
public class EleListInfo {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String getEleListInfo (LstIqpInfo lstIqpInfo,String opName,FeeRate feeRate) {
		
		Map<String, String> map = new HashMap<String,String>();
		String result = "";
		try {
			//保单号码
			String listSerno = lstIqpInfo.getListSerno();
			//投保人姓名
			String cusName = lstIqpInfo.getCusName();
			//投保人身份证号码
			String certCode = lstIqpInfo.getCertCode();
			//投保人联系电话
			String mobile = lstIqpInfo.getMobile();
			//投保人联系地址
			String address = lstIqpInfo.getAddress();
			//被保险人
			String receiveCusName = lstIqpInfo.getReceiveCusName();
			//贷款金额（人民币：元）
			String upAmount = Convert.digitUppercase(lstIqpInfo.getAmount().doubleValue());
			String amount = "人民币（大写） "+upAmount+"  "+"￥"+String.valueOf(lstIqpInfo.getAmount())+"元";
			//保险金额（人民币：元）
			String upCoverAmout = Convert.digitUppercase(lstIqpInfo.getCoverAmount().doubleValue());
			String coverAmount = "人民币（大写） "+upCoverAmout+"  "+"￥"+String.valueOf(lstIqpInfo.getCoverAmount())+"元";
			//每月保费费率
			String everyPremRate = String.valueOf(new BigDecimal(feeRate.getFeeRate()).setScale(3, BigDecimal.ROUND_HALF_UP))+"%";
			//每月保险费金额
			String upEveryPermFee = Convert.digitUppercase(lstIqpInfo.getAmount().multiply(new BigDecimal(0.99)).multiply(new BigDecimal(feeRate.getPaFeeRate())).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			String everyPremFee = "人民币（大写） "+upEveryPermFee+"  "+"￥"+String.valueOf(lstIqpInfo.getAmount().multiply(new BigDecimal(0.99)).multiply(new BigDecimal(feeRate.getPaFeeRate())).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP))+"元";
			//免赔率
			String excuseRate = String.valueOf(lstIqpInfo.getExcuseRate())+"%";
			//年
			String signYear = DateUtils.getYear();
			//月
			String signMonth = DateUtils.getMonth();
			//日
			String signDay = DateUtils.getDay();
			//经办人
			String inputName = opName;
			//经办人
			String serno = lstIqpInfo.getIqpLoanSerno();
			
			map.put("listSerno", listSerno);
			map.put("cusName", cusName);
			map.put("certCode", certCode);
			map.put("mobile", mobile);
			map.put("address", address);
			map.put("receiveCusName", receiveCusName);
			map.put("amount", amount);
			map.put("coverAmount", coverAmount);
			map.put("everyPremRate", everyPremRate);
			map.put("everyPremFee", everyPremFee);
			map.put("excuseRate", excuseRate);
			map.put("signYear", signYear);
			map.put("signMonth", signMonth);
			map.put("signDay", signDay);
			map.put("inputName", inputName);
			map.put("configId",SystemConfig.cacheMap.get("ELE_CONFIG_ID"));
			map.put("serno",serno);
			map.put("habxAddr",SystemConfig.cacheMap.get("HABX_ADDR"));
			map.put("resultCallBackUrl", SystemConfig.cacheMap.get("ELESTATUS_CALLBACK"));
		
			result = JSONUtils.getSingleInstance().toJSon(map);
		} catch (IOException e) {
			logger.error("error:{}",e.getMessage());
		}
		return result;
	}

}
