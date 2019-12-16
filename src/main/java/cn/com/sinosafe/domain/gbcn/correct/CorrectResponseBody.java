package cn.com.sinosafe.domain.gbcn.correct;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "responseBody")
@XmlType(name = "responseBody",propOrder = {"responseTime","resultFlag","resultMessage","insurancePhone","downLoadUrl","guaranteeUrl","insuranceTime"})
public class CorrectResponseBody implements Serializable {

    /**
     * 处理时间
     */
    private String responseTime;

    /**
     * 处理状态 true成功 false失败
     */
    @NotNull
    private boolean resultFlag;

    /**
     * 处理结果
     */
    @NotNull
    private String resultMessage;

    /**
     * 保险公司联系方式
     */
    private String insurancePhone;

    /**
     * 电子保单下载地址
     */
    @NotNull
    private String downLoadUrl;

    /**
     * 电子保函下载地址
     */
    private String guaranteeUrl;

    /**
     * 保单起期和止期
     * 2019-04-01 00:00:00 至 2019-04-30 23:59:59
     */
    @NotNull
    private String insuranceTime;

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public boolean isResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(boolean resultFlag) {
        this.resultFlag = resultFlag;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @XmlElement(name = "InsurancePhone")
    public String getInsurancePhone() {
        return insurancePhone;
    }

    public void setInsurancePhone(String insurancePhone) {
        this.insurancePhone = insurancePhone;
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

    @XmlElement(name = "InsuranceTime")
    public String getInsuranceTime() {
        return insuranceTime;
    }

    public void setInsuranceTime(String insuranceTime) {
        this.insuranceTime = insuranceTime;
    }

    public CorrectResponseBody() {
    }

    public CorrectResponseBody(String responseTime, @NotNull boolean resultFlag, @NotNull String resultMessage, String insurancePhone, @NotNull String downLoadUrl, String guaranteeUrl, @NotNull String insuranceTime) {
        this.responseTime = responseTime;
        this.resultFlag = resultFlag;
        this.resultMessage = resultMessage;
        this.insurancePhone = insurancePhone;
        this.downLoadUrl = downLoadUrl;
        this.guaranteeUrl = guaranteeUrl;
        this.insuranceTime = insuranceTime;
    }

    public CorrectResponseBody(String responseTime, @NotNull boolean resultFlag, @NotNull String resultMessage) {
        this.responseTime = responseTime;
        this.resultFlag = resultFlag;
        this.resultMessage = resultMessage;
    }
}
