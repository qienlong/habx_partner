package cn.com.sinosafe.domain.gbcn.queryPolicy;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 缴费成功，返回信息工保
 * @auther 林良
 * @Date 2019-08-30
 */
@XmlRootElement(name = "requestBody")
@XmlType(name = "requestBody",propOrder = {"policyNo","proposalNo","payType","payTime","insuranceCode","downLoadUrl","guaranteeUrl"})
public class QueryPolicyRequestBody implements Serializable {

    /**
     *保单号
     */
    @NotNull
    private String policyNo;

    /**
     *投保单号
     */
    @NotNull
    private String proposalNo;

    /**
     *支付方式 1微信 2支付宝 3网银
     */
    @NotNull
    private String payType;

    /**
     *支付时间 yyyy-MM-dd HH:mm:ss
     */
    @NotNull
    private String payTime;

    /**
     *保险公司代码
     */
    @NotNull
    private String insuranceCode;

    /**
     *电子保单下载地址
     */
    @NotNull
    private String downLoadUrl;

    /**
     *电子保函下载地址
     */
    private String guaranteeUrl;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    public String getDownLoadUrl() {
        return downLoadUrl;
    }

    public void setDownLoadUrl(String downLoadUrl) {
        this.downLoadUrl = downLoadUrl;
    }

    public String getGuaranteeUrl() {
        return guaranteeUrl;
    }

    public void setGuaranteeUrl(String guaranteeUrl) {
        this.guaranteeUrl = guaranteeUrl;
    }

    public QueryPolicyRequestBody() {
    }

    public QueryPolicyRequestBody(@NotNull String policyNo, @NotNull String proposalNo, @NotNull String payType, @NotNull String payTime, @NotNull String insuranceCode, @NotNull String downLoadUrl, String guaranteeUrl) {
        this.policyNo = policyNo;
        this.proposalNo = proposalNo;
        this.payType = payType;
        this.payTime = payTime;
        this.insuranceCode = insuranceCode;
        this.downLoadUrl = downLoadUrl;
        this.guaranteeUrl = guaranteeUrl;
    }
}
