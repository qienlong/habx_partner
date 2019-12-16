package cn.com.sinosafe.domain.gbcn.correct;

import cn.com.sinosafe.domain.gbcn.ResponseHead;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 华安响应批改请求
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "correctResponse")
@XmlType(name = "correctResponse",propOrder = {"responseHead","responseBody"})
public class CorrectResponse implements Serializable {

    private ResponseHead responseHead;

    private CorrectResponseBody responseBody;

    public ResponseHead getResponseHead() {
        return responseHead;
    }

    public void setResponseHead(ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    public CorrectResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(CorrectResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    public CorrectResponse() {
    }

    public CorrectResponse(ResponseHead responseHead, CorrectResponseBody responseBody) {
        this.responseHead = responseHead;
        this.responseBody = responseBody;
    }
}
