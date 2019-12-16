package cn.com.sinosafe.service.gbcn.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.XmlUtil;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.TElecPolicyInfo;
import cn.com.sinosafe.domain.gbcn.request.InvoiceRequest;
import cn.com.sinosafe.domain.gbcn.request.InvoiceRequest.InvoiceRequestBody;
import cn.com.sinosafe.domain.gbcn.request.QueryInvoiceRequest;
import cn.com.sinosafe.domain.gbcn.request.QueryInvoiceRequest.QueryInvoiceRequestBody;
import cn.com.sinosafe.domain.gbcn.request.RequestHead;
import cn.com.sinosafe.domain.gbcn.response.BaseResponse.ResponseBody;
import cn.com.sinosafe.domain.gbcn.response.GBResponse;
import cn.com.sinosafe.domain.gbcn.response.GBResponse.InvoiceResponse;
import cn.com.sinosafe.lina.common.utils.UUIDUtils;
import cn.com.sinosafe.service.gbcn.CommonService;
import cn.com.sinosafe.service.gbcn.GbcnService;

/**
 * 申请发票 付款后10分钟没有发票信息则
 */
@Service(value = GBCNConstant.INVOICE_REQUEST)
public class InvoiceRequestService extends CommonService implements GbcnService<ResponseBody,String>{

    private static final Logger logger = LoggerFactory.getLogger(InvoiceRequestService.class);

	public GBResponse<InvoiceResponse> getResultObj(){
		return InvoiceResponse.getInstance();
	}
    
	public ResponseBody process(String param) throws Exception {
    	InvoiceRequest invoiceRequest = (InvoiceRequest) XmlUtil.xml2Object(param, InvoiceRequest.class);
    	InvoiceRequestBody requestBody = invoiceRequest.getRequestBody();
    	LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(requestBody.getPolicyno());
    	if(ObjectUtils.isEmpty(lstIqpInfo)){
    	    return new ResponseBody(DateUtils.getDateTime(), false,"保单号有误，请查询！");
    	}
    	if(!"3".equals(lstIqpInfo.getIsPayed())||StringUtils.isEmpty(lstIqpInfo.getPayAppNo())){
    	    return new ResponseBody(DateUtils.getDateTime(), false,"请先支付成功再申请发票！");
    	}
    	 //判断如果已经申请过了纸质发票，则不能再申请电子发票，如果申请成功也不能够再申请
	    List<InvoiceRequestBody> list = invoiceMapper.selectByPolicyNo(requestBody.getPolicyno());
	    //查询支付成功的单
	    if(!CollectionUtils.isEmpty(list)){
	    	for (InvoiceRequestBody invoice:list) {
	    		if("1".equals(invoice.getInvoiceStatus())){
            	    return new ResponseBody(DateUtils.getDateTime(), false,"你已成功申请过发票，请不要重复申请！");
	    		}
	    		if("0".equals(invoice.getInvoiceStatus())&&!"1".equals(invoice.getInvoiceType())){
            	    return new ResponseBody(DateUtils.getDateTime(), false,"你的发票正在代办中，请不要重复申请！");
	    		}
			}
	    }
	    //纸质普通、纸质专票
	    if("2".equals(invoiceRequest.getRequestBody().getInvoiceType())){
	    	if(StringUtils.isEmpty(invoiceRequest.getRequestBody().getAddressee())
	    			||StringUtils.isEmpty(invoiceRequest.getRequestBody().getAddresseePhone())
	    			||StringUtils.isEmpty(invoiceRequest.getRequestBody().getAddress())){
        	    return new ResponseBody(DateUtils.getDateTime(), false,"纸质普票必填字段为空！");
	    	}
	    }else if("3".equals(invoiceRequest.getRequestBody().getInvoiceType())){
	    	if(StringUtils.isEmpty(invoiceRequest.getRequestBody().getAddInfo())
	    			||StringUtils.isEmpty(invoiceRequest.getRequestBody().getBankInfo())
	    			||StringUtils.isEmpty(invoiceRequest.getRequestBody().getBankAcc())
    			||StringUtils.isEmpty(invoiceRequest.getRequestBody().getPhoneNo())){
        	    return new ResponseBody(DateUtils.getDateTime(), false,"纸质专票必填字段为空！");
	    	}
	    }
	    requestBody.setPkId(UUIDUtils.generate());
	    requestBody.setCreateTime(DateUtils.getDateTime());
	    requestBody.setInvoiceStatus("0");
	    invoiceMapper.insertSelective(requestBody);
    	if (!"1".equals(requestBody.getInvoiceType())) {//申请不是电子发票，立刻返回成功！
    	    return new ResponseBody(DateUtils.getDateTime(), true,"处理成功");
    	}
    	try {
    	    //查询表有没有数据
    	    TElecPolicyInfo elecPolicyInfo = tElecPolicyInfoMapper.selectByPolicyNo(requestBody.getPolicyno());
            if(elecPolicyInfo==null||StringUtils.isEmpty(elecPolicyInfo.getShortUrl())){
            	//查询付款时间有没有超过10分钟
            	LstIqpInfo lstiqpInfo = lstIqpInfoMapper.selectByListSerno(requestBody.getPolicyno());
            	if(lstiqpInfo==null||StringUtils.isEmpty(lstiqpInfo.getPayTime())){
            	    return new ResponseBody(DateUtils.getDateTime(), false,"请先支付完成再申请发票");
            	}else{
            	    return new ResponseBody(DateUtils.getDateTime(), false,"发票已经申请，请再过10分钟再申请！");
            	}
            }
            QueryInvoiceRequestBody requestBody2 = new QueryInvoiceRequestBody();
            requestBody2.setPolicyNo(elecPolicyInfo.getPolicyNo());
            //保险公司代码
            requestBody2.setInsuranceCode("00013");
            //下载地址
            //String url = "www.huaan.com" + elecPolicyInfo.getImgId();
            requestBody2.setDownLoadUrl(elecPolicyInfo.getShortUrl());
            //发票回执信息头
            RequestHead requestHead = new RequestHead(UUIDUtils.generate(), tosign(requestBody2));
            QueryInvoiceRequest request = new QueryInvoiceRequest(requestHead,requestBody2);
    	    String invoiceUrl = XmlUtil.convertToXml(request, false);
            logger.info("发送给工保网-->方法-->电子发票回执:"+invoiceUrl);
            String invoiceResponse = HttpClientUtil.doPostXML( SystemConfig.cacheMap.get("GBCN_QUERY_INVOICE_URL"), invoiceUrl);
            logger.info("工保返回-->方法-->电子发票回执:" + invoiceResponse);
            //更新状态为已申请成功
            requestBody.setInvoiceStatus("1");
            invoiceMapper.updateInvoiceStatus(requestBody);
    	    return new ResponseBody(DateUtils.getDateTime(), true,"处理成功");
    	}catch (Exception e){
    	    e.printStackTrace();
            logger.info("发票申请失败--->"+e.getMessage());
    	    return new ResponseBody(DateUtils.getDateTime(), false,"系统繁忙");
    	}
	}
}
