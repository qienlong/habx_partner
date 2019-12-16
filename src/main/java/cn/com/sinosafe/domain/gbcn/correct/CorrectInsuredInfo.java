package cn.com.sinosafe.domain.gbcn.correct;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 批改被保险人信息
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "insuredInfo")
@XmlType(name = "insuredInfo",propOrder = {"name","idNumber","mobile"})
public class CorrectInsuredInfo implements Serializable {

    /**
     * 被保人姓名
     */
    @NotBlank
    private String name;

    /**
     * 被保人统一信用社会代码
     */
    @NotBlank
    private String idNumber;

    /**
     * 被保人手机号码
     */
    @NotBlank
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
