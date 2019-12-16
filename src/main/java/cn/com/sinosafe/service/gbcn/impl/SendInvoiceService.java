package cn.com.sinosafe.service.gbcn.impl;

import java.util.List;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.ThreadLocalUtil;
import cn.com.sinosafe.common.util.XmlUtil;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.domain.gbcn.request.InvoiceRequest.InvoiceRequestBody;
import cn.com.sinosafe.domain.gbcn.request.QueryInvoiceRequest;
import cn.com.sinosafe.domain.gbcn.request.QueryInvoiceRequest.QueryInvoiceRequestBody;
import cn.com.sinosafe.domain.gbcn.request.RequestHead;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.lina.common.protocol.ResultCode;
import cn.com.sinosafe.service.gbcn.CommonService;
import cn.com.sinosafe.service.gbcn.GbcnService;

import com.alibaba.fastjson.JSONObject;

@Service(value = GBCNConstant.SEND_INVOICE)
public class SendInvoiceService extends CommonService implements GbcnService<JsonProtocol,JSONObject>{
	
    private static final Logger logger = LoggerFactory.getLogger(SendInvoiceService.class);

	@Override
	public JsonProtocol process(JSONObject param) throws Exception {
		JsonProtocol jsonProtocol = new JsonProtocol();
		String sessionID = "gbcn" + DateUtils.getMillisecond();
		MDC.put("sessionID", sessionID);
		logger.info("【请求自IP：{}】 ====>>>>【{}】请求参数：{}",ThreadLocalUtil.get("ip"), ThreadLocalUtil.get("url"), param);
		String expressName = param.getString("expressName");// 快递公司
		String expressNo = param.getString("expressNo");// 快递单号
		String policyNo = param.getString("policyNo");// 保险单号
		QueryInvoiceRequestBody requestBody = new QueryInvoiceRequestBody();
		//查询申请记录中有没有申请过得电子发票，没有则返回异常
		 //判断如果已经申请过了纸质发票，则不能再申请电子发票，如果申请成功也不能够再申请
	    List<InvoiceRequestBody> list = invoiceMapper.selectByPolicyNo(policyNo);
	    if(CollectionUtils.isEmpty(list)){
	    	jsonProtocol.setMessage("没有找到该保单发票申请记录！");
	    	jsonProtocol.setCode(1);
	    	return jsonProtocol;
	    }
	    for (InvoiceRequestBody obj:list) {
	    	if("1".equals(obj.getInvoiceStatus())){
	    		jsonProtocol.setMessage("该保单号已经申请成功发票！");
		    	jsonProtocol.setCode(1);
		    	return jsonProtocol;
	    	}
		}
		requestBody.setPolicyNo(policyNo);
		// 保险公司代码
		requestBody.setInsuranceCode("00013");
		// 快递单号、快递公司
		requestBody.setExpressName(expressName);
		requestBody.setExpressNo(expressNo);
		// 发票回执信息头
		RequestHead requestHead = new RequestHead(StringUtils.uuid(),tosign(requestBody));
		QueryInvoiceRequest request = new QueryInvoiceRequest(requestHead,requestBody);
		String invoiceUrl = XmlUtil.convertToXml(request, false);
		logger.info("发送给工保网-->方法-->纸质发票回执:"+invoiceUrl);
		String invoiceResponse = HttpClientUtil.doPostXML( SystemConfig.cacheMap.get("GBCN_QUERY_INVOICE_URL"), invoiceUrl);
		logger.info("工保返回-->方法-->纸质发票回执:" + invoiceResponse);
		if(!(invoiceResponse.contains("成功")&&invoiceResponse.contains("true"))){
			jsonProtocol.setMessage("发送纸质发票回执失败！");
	    	jsonProtocol.setCode(1);
	    	return jsonProtocol;
		} 
		//更新状态为已申请成功
    	InvoiceRequestBody invoiceStatu = new InvoiceRequestBody();
    	invoiceStatu.setPolicyno(policyNo);
    	invoiceStatu.setInvoiceStatus("1");
        invoiceMapper.updateInvoiceStatus(invoiceStatu);
		return jsonProtocol.setup(ResultCode.SUCCESS);
	}

}
