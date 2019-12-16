package cn.com.sinosafe.service.gbcn.impl;

import java.util.Map;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.ThreadLocalUtil;
import cn.com.sinosafe.domain.entity.IqpMeProjectInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.lina.common.protocol.ResultCode;
import cn.com.sinosafe.service.gbcn.CommonService;
import cn.com.sinosafe.service.gbcn.GbcnService;

import com.alibaba.fastjson.JSONObject;

@Service(value = GBCNConstant.CORRECT_CALLBACK)
public class CorrectCallBackService extends CommonService implements GbcnService<JsonProtocol,JSONObject>{
	
    private static final Logger logger = LoggerFactory.getLogger(CorrectCallBackService.class);

	@Override
	@SuppressWarnings("unchecked")
	public JsonProtocol process(JSONObject param) throws Exception {
		JsonProtocol jsonProtocol = new JsonProtocol();
        JSONObject data=JSONObject.parseObject(JSONObject.toJSONString(param.get("data")),JSONObject.class);
        String listSerno = data.getString("listSerno");
        String redisKey = GBCNConstant.CORRECT_REQUEST + listSerno;
		Map<String, String> map = (Map<String, String>) redisUtils.getValue(redisKey);
    	MDC.put("sessionID", map.get("sessionID"));
		logger.info("【请求自IP：{}】 ====>>>>【{}】请求参数：{}", 	ThreadLocalUtil.get("ip"), ThreadLocalUtil.get("url"), param);
		String pdfUrl = data.getString("pdfUrl");
		pdfUrl = pdfUrl.replaceAll("http://(\\d+\\.\\d+\\.\\d+\\.\\d+)\\:(\\d+)", SystemConfig.cacheMap.get("GBCN_INSURE_DOWNLOAD_URL"));
		pdfUrl = getQueryUrl(pdfUrl);
        if("gcbd".equals(data.getString("projectType"))){//保单
        	 map.put("downLoadUrl", pdfUrl);
    		 redisUtils.setValue(data.getString("listSerno")+"bd", pdfUrl, 60 * 60 * 24 * 7);
             redisUtils.setValue(redisKey, map, 60 * 60 * 24 * 1);
             LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(listSerno);
             IqpMeProjectInfo iqpMeProjectInfo = iqpMeProjectInfoMapper.selectByIqpSerno(lstIqpInfo.getIqpLoanSerno());
             //请求保函
             sealAssure(lstIqpInfo,pdfUrl,GBCNConstant.getLocalIpPort() + GBCNConstant.CORRECT_CALLBACK,iqpMeProjectInfo.getProjectSubject(),true);
        }else {//保函
       	 map.put("guaranteeUrl", pdfUrl);
         redisUtils.setValue(data.getString("listSerno")+"bh", pdfUrl, 60 * 60 * 24 * 7);
         redisUtils.setValue(redisKey, map, 60 * 60 * 24 * 1);
		}
        return jsonProtocol.setup(ResultCode.SUCCESS);
	}

}
