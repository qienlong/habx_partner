/**
 * 
 */
package cn.com.sinosafe.service.padb.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import cn.com.sinosafe.service.padb.PaPenaltyNoticeService;
import net.sf.json.JSONObject;

/**  
* <p>Title: PaPenaltyNoticeServiceImpl</p>  
* <p>Description: </p>  
* @author longxiaoqiang  
* @date 2019年10月8日  
*/
@Service
public class PaPenaltyNoticeServiceImpl implements PaPenaltyNoticeService {

	private static final Logger log = LoggerFactory.getLogger(PaPenaltyNoticeServiceImpl.class);
	@Override
	public String penaltyNotice() {
		try {
			//1、获取违约金率
			String penalty = SystemConfig.cacheMap.get("PAPH_PENALTY");
			log.info("PaPenaltyNoticeServiceImpl查询到要发送给平安的违约金率为={}",penalty);
			
			//2、组装待发送数据
			String sendData = assembleData(penalty);
			log.info("PaPenaltyNoticeServiceImpl组装待发送给平安的数据为={}",sendData);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("param", PaEncryptUtil.encryptByRSA(sendData));
			log.info("加密后发送给平安的数据为：{}",jsonObject.toString());
			//3、发送数据
			String resultData = HttpClientUtil.sendPosts(SystemConfig.cacheMap.get("PAPH_Penalty_Notice"), jsonObject.toString());;
			log.info("PaPenaltyNoticeServiceImpl平安返回的结果为={}",resultData);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("PaPenaltyNoticeServiceImpl发送给平安违约金率失败");
		}
		
		return null;
	}

private String assembleData(String penalty) throws JsonGenerationException, JsonMappingException, IOException {
		
		Map<String,Object> map = new HashMap<>();
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> dataMap = new HashMap<String,String>();
		dataMap.put("feeBase", "Claim _AMT");
		dataMap.put("feeRateUnit", "D");
		dataMap.put("feeRate", penalty);
		dataMap.put("feeCode", "LATE_FEE");
		dataMap.put("increaseCreditCode", "1020");
		dataMap.put("insuCompany", "HABX");
		dataMap.put("systemCode", "");
		list.add(dataMap);
		
		map.put("parentProductNo", "PH100010001");
		map.put("increaseCreditFeeRateList", list);
		
		String sendData = JSONUtils.getSingleInstance().toJSon(map);
		return sendData;
	}
}
