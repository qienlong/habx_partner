package cn.com.sinosafe.domain.gbcn.invoice;


import cn.com.sinosafe.domain.gbcn.ResponseBody;
import cn.com.sinosafe.domain.gbcn.ResponseHead;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 华安响应申请发票
 * @auther 林良
 * @Date 2019-09-01
 */
@XmlRootElement(name = "invoiceResponse")
@XmlType(name = "invoiceResponse",propOrder = {"responseHead","responseBody"})
public class InvoiceResponse implements Serializable {

    private ResponseHead responseHead;

    private ResponseBody responseBody;

    public ResponseHead getResponseHead() {
        return responseHead;
    }

    public void setResponseHead(ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    public InvoiceResponse() {
    }

    public InvoiceResponse(ResponseHead responseHead, ResponseBody responseBody) {
        this.responseHead = responseHead;
        this.responseBody = responseBody;
    }
}
