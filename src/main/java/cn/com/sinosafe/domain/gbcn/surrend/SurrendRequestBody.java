package cn.com.sinosafe.domain.gbcn.surrend;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description
 * @auther 林良
 * @Date 2019-09-01
 */
@XmlRootElement(name = "requestBody")
@XmlType(name = "requestBody",propOrder = {"policyno","policyReason","accountNo","bankName","bankNo"})
public class SurrendRequestBody implements Serializable {

    /**
     * 保单号
     */
    @NotBlank
    private String policyno;

    /**
     * 退保原因
     */
    @NotBlank
    private String policyReason;

    /**
     * 账户名
     */
    private String accountNo;

    /**
     * 退款账号开户行
     */
    private String bankName;

    /**
     * 退款账号
     */
    private String bankNo;

    public String getPolicyno() {
        return policyno;
    }

    public void setPolicyno(String policyno) {
        this.policyno = policyno;
    }

    public String getPolicyReason() {
        return policyReason;
    }

    public void setPolicyReason(String policyReason) {
        this.policyReason = policyReason;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }
}
