package cn.com.sinosafe.domain.gbcn.insure;

import cn.com.sinosafe.domain.gbcn.ResponseHead;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 华安响应投保请求
 * @auther 林良
 * @Date 2019-08-30
 */
@XmlRootElement(name ="insureResponse")
@XmlType(name = "insureResponse",propOrder = {"responseHead","responseBody"})
public class InsureResponse implements Serializable {

    private ResponseHead responseHead;

    private InsureResponseBody responseBody;

    public ResponseHead getResponseHead() {
        return responseHead;
    }

    public void setResponseHead(ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    public InsureResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(InsureResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    public InsureResponse() {
    }

    public InsureResponse(ResponseHead responseHead,InsureResponseBody responseBody) {
        this.responseHead = responseHead;
        this.responseBody = responseBody;
    }
}
