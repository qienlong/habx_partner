package cn.com.sinosafe.domain.gbcn.insure;

import cn.com.sinosafe.domain.gbcn.RequestHead;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 工保发起投保请求
 * @auther 林良
 * @Date 2019-08-30
 */
@XmlRootElement(name ="insureRequest")
@XmlType(name = "insureRequest",propOrder = {"requestHead","requestBody"})
public class InsureRequest implements Serializable {

    @Valid
    private RequestHead requestHead;

    @Valid
    private InsureRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public InsureRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(InsureRequestBody requestBody) {
        this.requestBody = requestBody;
    }
}
