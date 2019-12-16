package cn.com.sinosafe.domain.gbcn.correct;


import cn.com.sinosafe.domain.gbcn.RequestHead;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 工保发起批改请求
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "correctRequest")
@XmlType(name = "correctRequest",propOrder = {"requestHead","requestBody"})
public class CorrectRequest implements Serializable {

    @Valid
    private RequestHead requestHead;

    @Valid
    private CorrectRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public CorrectRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(CorrectRequestBody requestBody) {
        this.requestBody = requestBody;
    }
}
