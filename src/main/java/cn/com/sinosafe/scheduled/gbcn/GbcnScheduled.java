package cn.com.sinosafe.scheduled.gbcn;

import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.SignVerifyUtil;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.XMLUtil;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.dao.GbcnInvoiceMapper;
import cn.com.sinosafe.dao.InvoiceInfoMapper;
import cn.com.sinosafe.domain.gbcn.GbcnLog;
import cn.com.sinosafe.domain.gbcn.RequestHead;
import cn.com.sinosafe.domain.gbcn.invoice.InvoiceRequestBody;
import cn.com.sinosafe.domain.gbcn.queryInvoice.InvoiceInfo;
import cn.com.sinosafe.domain.gbcn.queryInvoice.QueryInvoiceRequest;
import cn.com.sinosafe.domain.gbcn.queryInvoice.QueryInvoiceRequestBody;
import cn.com.sinosafe.service.gbcn.impl.GbcnServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @Description
 * @auther 林良
 * @Date 2019-09-06
 */
@Component
public class GbcnScheduled {

    private static final Logger logger = LoggerFactory.getLogger(GbcnServiceImpl.class);

    @Autowired
    private GbcnInvoiceMapper invoiceMapper;

    @Autowired
    private InvoiceInfoMapper invoiceInfoMapper;

    @Value("${gbcn.queryInvoiceUrl}")
    private String queryInvoiceUrl;

    @Value("${gbcn.invoiceDownloadUrl}")
    private String invoiceDownloadUrl;

    /**
     * @Description 每天早上9点扫描发票申请表，状态为0，2的，将查询SENT_STATUS表找到发票下载地址通知工保
     * @Date 2019/9/6 9:42
     * @param
     * @return void
     */
    @Scheduled(cron = "0 0 9 * * ?")
    //@Scheduled(cron = "0 0/2 * * * ?")
    public void SendInvoice(){
        //未回执给工保的信息
        List<InvoiceRequestBody> invoices = invoiceMapper.queryWithoutSend();
        if (invoices != null && !invoices.isEmpty()) {
            for (InvoiceRequestBody invoice : invoices) {
                //获取未回执发票下载fieid
                InvoiceInfo invoiceInfo = invoiceInfoMapper.selectByPolicyNo(invoice.getPolicyno());
                if (invoiceInfo != null) {
                    //日志表记录
                    GbcnLog gbcnLog = new GbcnLog();
                    //发票回执信息体
                    QueryInvoiceRequestBody requestBody = new QueryInvoiceRequestBody();
                    requestBody.setPolicyNo(invoiceInfo.getPolicyNo());
                    //保险公司代码
                    requestBody.setInsuranceCode("123");
                    //下载地址
                    String url = invoiceDownloadUrl + invoiceInfo.getImgId();
                    requestBody.setDownLoadUrl(url);
                    String requestUUID = StringUtils.uuid();
                    gbcnLog.setPkId(requestUUID);
                    //发票回执信息头
                    RequestHead requestHead = new RequestHead(requestUUID, SignVerifyUtil.tosign(requestBody));
                    //发票回执信息
                    QueryInvoiceRequest request = new QueryInvoiceRequest(requestHead,requestBody);
                    String invoiceRequest = XMLUtil.convertToXml(request, false);
                    logger.info("华安发送发票回执--->\n"+invoiceRequest);
                    gbcnLog.setInputXml("华安发送发票回执--->"+invoiceRequest);
                    for (int i = 0; i < 3; i++) {
                        try {
                            String invoiceResponse = HttpClientUtil.doPostXML(queryInvoiceUrl, invoiceRequest);
                            logger.info("工保响应发票回执信息-->\n"+invoiceRequest);
                            gbcnLog.setOutputXml("工保响应发票回执信息-->"+invoiceRequest);
                            if (invoiceResponse.contains("true")) {
                                invoice.setInvoiceStatus("1");
                                invoiceMapper.updateByPrimaryKeySelective(invoice);
                                gbcnLog.setResultMsg("成功");
                                break;
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                            logger.error("发票回执失败--->\n"+e.getMessage());
                            gbcnLog.setResultMsg("失败");
                        }
                        try {
                            Thread.sleep(1000*15);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    gbcnLog.setMethod("queryInvoice");
                    gbcnLog.setCreateTime(DateUtils.getDateTime());
                }
            }
        }
    }
}
