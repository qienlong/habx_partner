package cn.com.sinosafe.domain.gbcn.querySurrend;

import javax.validation.constraints.NotNull;
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
@XmlType(name = "requestBody",propOrder = {"policyNo","resultFlag","resultMessage","insuranceCode"})
public class QuerySurrendRequestBody implements Serializable {

    /**
     * 保单号
     */
    @NotNull
    private String policyNo;

    /**
     * true成功 false失败
     */
    @NotNull
    private boolean resultFlag;

    /**
     * 已退款至原账户/失败原因
     */
    @NotNull
    private String resultMessage;

    /**
     * 保险公司代码
     */
    @NotNull
    private String insuranceCode;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
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

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    public QuerySurrendRequestBody() {
    }

    public QuerySurrendRequestBody(@NotNull String policyNo, @NotNull boolean resultFlag, @NotNull String resultMessage, @NotNull String insuranceCode) {
        this.policyNo = policyNo;
        this.resultFlag = resultFlag;
        this.resultMessage = resultMessage;
        this.insuranceCode = insuranceCode;
    }
}
