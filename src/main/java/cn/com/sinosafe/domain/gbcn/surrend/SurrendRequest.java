package cn.com.sinosafe.domain.gbcn.surrend;

import cn.com.sinosafe.domain.gbcn.RequestHead;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 工保发起退保请求
 * @auther 林良
 * @Date 2019-09-01
 */
@XmlRootElement(name = "surrendRequest")
@XmlType(name = "surrendRequest",propOrder = {"requestHead","requestBody"})
public class SurrendRequest implements Serializable {

    @Valid
    private RequestHead requestHead;

    @Valid
    private SurrendRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public SurrendRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(SurrendRequestBody requestBody) {
        this.requestBody = requestBody;
    }
}
