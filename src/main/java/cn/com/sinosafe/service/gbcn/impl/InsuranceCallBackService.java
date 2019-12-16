package cn.com.sinosafe.service.gbcn.impl;

import java.util.Map;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.ThreadLocalUtil;
import cn.com.sinosafe.common.util.XmlUtil;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.domain.entity.IqpMeProjectInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.gbcn.request.QueryPolicyRequest;
import cn.com.sinosafe.domain.gbcn.request.RequestHead;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.lina.common.protocol.ResultCode;
import cn.com.sinosafe.service.gbcn.CommonService;
import cn.com.sinosafe.service.gbcn.GbcnService;

import com.alibaba.fastjson.JSONObject;

@Service(value = GBCNConstant.INSURANCE_CALLBACK)
public class InsuranceCallBackService extends CommonService implements GbcnService<JsonProtocol,JSONObject>{
	
    private static final Logger logger = LoggerFactory.getLogger(InsuranceCallBackService.class);

	@SuppressWarnings("unchecked")
	@Override
	public JsonProtocol process(JSONObject param) throws Exception {
		JsonProtocol jsonProtocol = new JsonProtocol();
        //收到回调地址再httpclient 发送给工保网
        JSONObject data=JSONObject.parseObject(JSONObject.toJSONString(param.get("data")),JSONObject.class);
        String pdfUrl = data.getString("pdfUrl");
    	Map<String, String> sernoMap = (Map<String, String>) redisUtils.getValue(GBCNConstant.INSURANCE_CALLBACK+data.getString("listSerno"));
    	MDC.put("sessionID", "gbcn" + sernoMap.get("sessionID"));
		logger.info("【请求自IP：{}】 ====>>>>【{}】请求参数：{}", 	ThreadLocalUtil.get("ip"), ThreadLocalUtil.get("url"), param);
        pdfUrl = pdfUrl.replaceAll("http://(\\d+\\.\\d+\\.\\d+\\.\\d+)\\:(\\d+)", SystemConfig.cacheMap.get("GBCN_INSURE_DOWNLOAD_URL"));
     //   pdfUrl = gbcnProperties.getInsureDownloadUrl2() + pdfUrl;
        pdfUrl = getQueryUrl(pdfUrl);
        LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(data.getString("listSerno"));
        if("gcbd".equals(data.getString("projectType"))){ //发送保单
            sernoMap.put("pdfUrl", pdfUrl);
            IqpMeProjectInfo iqpMeProjectInfo = iqpMeProjectInfoMapper.selectByIqpSerno(lstIqpInfo.getIqpLoanSerno());
            //调获取工保保函
            sealAssure(lstIqpInfo,pdfUrl,GBCNConstant.getLocalIpPort()+GBCNConstant.INSURANCE_CALLBACK,
            		iqpMeProjectInfo.getProjectSubject(),false);
            redisUtils.setValue(GBCNConstant.INSURANCE_CALLBACK+data.getString("listSerno"), sernoMap, 60 * 60 * 24 * 1);
        }else {//保函
            String payTime = sernoMap.get("payTime");
            String proposalNo = sernoMap.get("proposalNo");
            String policyNo = sernoMap.get("policyNo");
            String xml = "";
            redisUtils.setValue(data.getString("listSerno")+"bd", sernoMap.get("pdfUrl"), 60 * 60 * 24 * 7);
            redisUtils.setValue(data.getString("listSerno")+"bh", pdfUrl, 60 * 60 * 24 * 7);
            QueryPolicyRequest callBackResp = new QueryPolicyRequest();
            String bdurl = SystemConfig.cacheMap.get("GBCN_GATEWAY_URL")+"/gbcn/download/"+data.getString("listSerno")+"bd";
            String bhurl = SystemConfig.cacheMap.get("GBCN_GATEWAY_URL")+"/gbcn/download/"+data.getString("listSerno")+"bh";
            callBackResp.getRequestBody().setDownLoadUrl(getQueryUrl(bdurl));
            callBackResp.getRequestBody().setInsuranceCode("00013"); //保险公司代码 00013
            callBackResp.getRequestBody().setPayTime(payTime);
            callBackResp.getRequestBody().setPayType("3"); //网银支付 写死
            callBackResp.getRequestBody().setPolicyNo(policyNo);
            callBackResp.getRequestBody().setProposalNo(proposalNo);
            callBackResp.getRequestBody().setGuaranteeUrl(getQueryUrl(bhurl));
            callBackResp.setRequestHead(new RequestHead(StringUtils.uuid(), 
            		tosign(callBackResp.getRequestBody())));
            xml= XmlUtil.toXML(callBackResp);
            xml = xml.replaceAll("standalone=\"yes\"", "").replaceAll("&amp;", "&")
            		.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            logger.info("发送给工保网-->方法-->缴费回执:" + xml);
            String resultCallBack = HttpClientUtil.doPostXML(SystemConfig.cacheMap.get("GBCN_INSURANCE_CALLBACK_URL"), xml);
            logger.info("工保返回-->方法-->缴费回执:" + resultCallBack);
        }
        return jsonProtocol.setup(ResultCode.SUCCESS);
	}
	
}
