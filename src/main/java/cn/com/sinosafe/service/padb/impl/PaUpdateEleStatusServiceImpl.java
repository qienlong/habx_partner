/**
 * 
 */
package cn.com.sinosafe.service.padb.impl;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.bean.SentStatusCode;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import cn.com.sinosafe.service.padb.PaUpdateEleStatusService;

/**  
* <p>Title: PaUpdateEleStatusServiceImpl</p>  
* <p>Description: </p>  
* @author longxiaoqiang  
* @date 2019年9月11日  
*/
@Service
public class PaUpdateEleStatusServiceImpl implements PaUpdateEleStatusService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private PaPhCommonService paPhCommonService;
	
	@Override
	public String updateEleStatus(Map<String, Object> paraMap) {
		
		logger.info("*****************************电子保单生成更新状态接口 start*****************************");
		String resultCode=PaResultCode.PA_SUCCESS.code();
		String resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			logger.info("param={}",JSONUtils.getSingleInstance().toJSon(paraMap));
			
			JSONObject jsonData = JSONObject.parseObject(JSONObject.toJSONString(paraMap));
			String listSerno = (String)JSONPath.eval(jsonData, "$.data.listSerno");
			logger.info("获取返回的电子保单保单号为={}",listSerno);
			LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(listSerno);
			
			if (StringUtils.isNotNull(lstIqpInfo)&&StringUtils.isNotBlank(lstIqpInfo.getIqpLoanSerno())) {
				paPhCommonService.statusUpdateService(lstIqpInfo.getIqpLoanSerno(), SentStatusCode.PA_11.code(), "已出单");
			} else {
				logger.info("{}该保单不存在！",listSerno);
				resultCode=PaResultCode.PA_FAIL.code();
				resultMsg=PaResultGenerator.DEFAULT_FAIL_MESSAGE;
			}
		} catch (Exception e) {
			resultCode=PaResultCode.PA_FAIL.code();
			resultMsg=PaResultGenerator.DEFAULT_FAIL_MESSAGE;
		}
		resultMap.put("resultCode",String.valueOf(resultCode));
		resultMap.put("resultMsg", resultMsg);
		logger.info("*****************************电子保单生成更新状态接口 end*****************************");
		return JSON.toJSONString(resultMap);
	}

}
