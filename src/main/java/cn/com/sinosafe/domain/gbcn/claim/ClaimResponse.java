package cn.com.sinosafe.domain.gbcn.claim;


import cn.com.sinosafe.domain.gbcn.ResponseBody;
import cn.com.sinosafe.domain.gbcn.ResponseHead;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 华安响应理赔请求
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "claimResponse")
@XmlType(name = "claimResponse",propOrder = {"responseHead","responseBody"})
public class ClaimResponse implements Serializable {

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

    public ClaimResponse() {
    }

    public ClaimResponse(ResponseHead responseHead, ResponseBody responseBody) {
        this.responseHead = responseHead;
        this.responseBody = responseBody;
    }
}
