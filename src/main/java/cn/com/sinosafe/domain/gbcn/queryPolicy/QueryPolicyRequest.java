package cn.com.sinosafe.domain.gbcn.queryPolicy;

import cn.com.sinosafe.domain.gbcn.RequestHead;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 华安发起保单缴纳情况回执
 * @auther 林良
 * @Date 2019-08-30
 */
@XmlRootElement(name = "queryPolicyRequest")
@XmlType(name = "queryPolicyRequest",propOrder = {"requestHead","requestBody"})
public class QueryPolicyRequest implements Serializable {

    /**
     * 回执头部
     */
    private RequestHead requestHead;

    /**
     * 回执信息体
     */
    private QueryPolicyRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public QueryPolicyRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(QueryPolicyRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public QueryPolicyRequest() {
    }

    public QueryPolicyRequest(RequestHead requestHead, QueryPolicyRequestBody requestBody) {
        this.requestHead = requestHead;
        this.requestBody = requestBody;
    }
}
