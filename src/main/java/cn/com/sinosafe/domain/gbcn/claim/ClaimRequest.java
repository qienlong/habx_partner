package cn.com.sinosafe.domain.gbcn.claim;

import cn.com.sinosafe.domain.gbcn.RequestHead;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 工保发起理赔请求
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "claimRequest")
@XmlType(name = "claimRequest",propOrder = {"requestHead","requestBody"})
public class ClaimRequest implements Serializable {

    @Valid
    private RequestHead requestHead;

    @Valid
    private ClaimRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public ClaimRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(ClaimRequestBody requestBody) {
        this.requestBody = requestBody;
    }
}
