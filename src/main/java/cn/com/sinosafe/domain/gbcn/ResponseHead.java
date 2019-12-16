package cn.com.sinosafe.domain.gbcn;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 返回头部
 * @auther 林良
 * @Date 2019-08-30
 */
@XmlRootElement(name ="responseHead")
@XmlType(name = "responseHead",propOrder = {"requestUUID","sign"})
public class ResponseHead implements Serializable {

    /**
     *请求UUID，唯一性约束
     */
    @NotBlank
    private String requestUUID;

    /**
     * 签名
     */
    @NotBlank
    private String sign;

    public String getRequestUUID() {
        return requestUUID;
    }

    public void setRequestUUID(String requestUUID) {
        this.requestUUID = requestUUID;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public ResponseHead() {
    }

    public ResponseHead(@NotBlank String requestUUID, @NotBlank String sign) {
        this.requestUUID = requestUUID;
        this.sign = sign;
    }
}
