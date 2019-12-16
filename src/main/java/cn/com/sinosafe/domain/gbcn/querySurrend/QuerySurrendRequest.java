package cn.com.sinosafe.domain.gbcn.querySurrend;

import cn.com.sinosafe.domain.gbcn.RequestHead;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 华安发起退保状态回执
 * @auther 林良
 * @Date 2019-09-01
 */
@XmlRootElement(name = "querySurrendRequest")
@XmlType(name = "querySurrendRequest",propOrder = {"requestHead","requestBody"})
public class QuerySurrendRequest implements Serializable {

    private RequestHead requestHead;

    private QuerySurrendRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public QuerySurrendRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(QuerySurrendRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public QuerySurrendRequest() {
    }

    public QuerySurrendRequest(RequestHead requestHead, QuerySurrendRequestBody requestBody) {
        this.requestHead = requestHead;
        this.requestBody = requestBody;
    }
}
