package cn.com.sinosafe.domain.gbcn.queryInvoice;

import cn.com.sinosafe.domain.gbcn.RequestHead;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 华安发起发票信息回执
 * @auther 林良
 * @Date 2019-09-01
 */
@XmlRootElement(name = "queryInvoiceRequest")
@XmlType(name = "queryInvoiceRequest",propOrder = {"requestHead","requestBody"})
public class QueryInvoiceRequest implements Serializable {

    private RequestHead requestHead;

    private QueryInvoiceRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public QueryInvoiceRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(QueryInvoiceRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public QueryInvoiceRequest() {
    }

    public QueryInvoiceRequest(RequestHead requestHead, QueryInvoiceRequestBody requestBody) {
        this.requestHead = requestHead;
        this.requestBody = requestBody;
    }
}
