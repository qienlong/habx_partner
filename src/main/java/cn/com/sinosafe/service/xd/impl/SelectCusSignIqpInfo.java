package cn.com.sinosafe.service.xd.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.api.BigDataService;
import cn.com.sinosafe.bigdata.other.ylm.YlmRequest;
import cn.com.sinosafe.common.config.constant.PadbConstant;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.xd.XdService;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service("selectCusSignIqpInfo")
public class SelectCusSignIqpInfo implements XdService<String,JSONObject>{
	
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;
	
	@Autowired
	private BigDataService bigDataService;
	
	public  String process(JSONObject jsonObject) throws Exception{
		JSONObject result = new JSONObject();
    	JSONObject jsonData = new JSONObject();
		String  cusName = jsonObject.getString("cusName");
		String  certCode =  jsonObject.getString("certCode");
		if(StringUtils.isEmpty(cusName)||StringUtils.isEmpty(certCode)){
			result.put("returnCode", "9999");
    		result.put("data", jsonData);
    		result.put("errorMsg", "姓名或证件号不能为空");
    		return result.toJSONString(); 
		}
		List<HashMap<String,Object>> list = iqpMeLoanAppMapper.selectCusSignIqpInfo(
				cusName,certCode);
    	if(CollectionUtils.isEmpty(list)){
    		result.put("returnCode", "9999");
    		result.put("data", jsonData);
    		result.put("errorMsg", "华安保险暂时没有需要您签署的申请");
    		return result.toJSONString();
    	}
		List<HashMap<String,Object>> list2 = new ArrayList<HashMap<String,Object>>();
    	for (HashMap<String,Object> map : list) {
    		//将大写变成小写
    		HashMap<String,Object> resultMap = new HashMap<String, Object>();
          for (String key : map.keySet()) { 
				 String newKey = key.toLowerCase(); 
				 resultMap.put(newKey, map.get(key)); 
           }
			String term = String.valueOf(resultMap.get("term"));
			if (StringUtils.isEmpty(term) || (StringUtils.isNotBlank(term)&&"0".equals(term))) {
				term = String.valueOf(resultMap.get("term_day")) + "天";
			} else {
				term = term + "个月";
			}
			resultMap.put("term", term);
			String payee_bank = String.valueOf(resultMap.get("payee_bank"));
			payee_bank = "null".equals(payee_bank)?"":payee_bank;
			String payee_account = String.valueOf(resultMap.get("payee_account"));
			if(StringUtils.isEmpty(payee_bank)&&!StringUtils.isEmpty(payee_account)){
				payee_bank = getBankName(payee_account);
				//更新申请表
				IqpMeLoanApp iqpMeloadApp  = new IqpMeLoanApp();
				iqpMeloadApp.setSerno(String.valueOf(resultMap.get("serno")));
				iqpMeloadApp.setPayeeBank(payee_bank);
				iqpMeLoanAppMapper.updateByPrimaryKeySelective(iqpMeloadApp);
			}
			list2.add(resultMap);
		}
		result.put("returnCode", "0000");
		result.put("data", JSONArray.parseArray(JSONObject.toJSONString(list2)));
		result.put("errorMsg", "");
		return result.toJSONString();
	}
	
	
	public String getBankName(String payee_account) throws Exception {
		YlmRequest request = new YlmRequest();
		request.setBankcard(payee_account);
		request.setSerno(PadbConstant.PADB_SYSTEM);
		request.setType("1359");
		JsonProtocol json = bigDataService.ylmPyQuery(request);
		JSONObject json1 = JSONObject.parseObject(
				JSONObject.toJSONString(json), JSONObject.class);
		if ("0".equals(json1.getString("code"))) {
			JSONObject data = (JSONObject) JSONObject.toJSON(json1.get("data"));
			if ("0000".equals(data.getString("result"))) {
				JSONObject data2 = (JSONObject) JSONObject.toJSON(data
						.get("data"));
				String payee_bank = data2.getString("bank_description");
				return payee_bank;
			}
		}
		return null;
	}

}
