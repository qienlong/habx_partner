package cn.com.sinosafe.domain.gbcn.invoice;


import cn.com.sinosafe.domain.gbcn.RequestHead;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 工保网发起申请发票请求
 * @auther 林良
 * @Date 2019-09-01
 */
@XmlRootElement(name = "invoiceRequest")
@XmlType(name = "invoiceRequest",propOrder = {"requestHead","requestBody"})
public class InvoiceRequest implements Serializable {

    @Valid
    private RequestHead requestHead;

    @Valid
    private InvoiceRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public InvoiceRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(InvoiceRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public InvoiceRequest() {
    }

    public InvoiceRequest(RequestHead requestHead, InvoiceRequestBody requestBody) {
        this.requestHead = requestHead;
        this.requestBody = requestBody;
    }
}
