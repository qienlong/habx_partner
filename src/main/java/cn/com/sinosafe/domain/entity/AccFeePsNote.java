package cn.com.sinosafe.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ACC_FEE_PS_NOTE
 * @author 
 */
public class AccFeePsNote implements Serializable {
    /**
     * 投保单业务流水号
     */
    private String lstSerno;

    /**
     * 实还日期
     */
    private String psRealDt;

    /**
     * 实收保费
     */
    private BigDecimal psRealFeeAmt;

    /**
     * 还款状态
     */
    private String repaymentState;

    /**
     * 还款来源
     */
    private String psRealSource;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 录入时间
     */
    private String inputDate;

    private String updateDate;

    /**
     * 期号
     */
    private Short psPerdNo;

    /**
     * 银行还款流水号
     */
    private String bankSerno;

    /**
     * 录入人
     */
    private String inputId;

    /**
     * 录入机构
     */
    private String inputBrId;

    /**
     * 保费来源方
     */
    private String feeSource;

    /**
     * 保费还款类型
     */
    private String premiumRepayType;

    private String inputDateTime;

    private String pkId;

    private static final long serialVersionUID = 1L;

    public String getLstSerno() {
        return lstSerno;
    }

    public void setLstSerno(String lstSerno) {
        this.lstSerno = lstSerno;
    }

    public String getPsRealDt() {
        return psRealDt;
    }

    public void setPsRealDt(String psRealDt) {
        this.psRealDt = psRealDt;
    }

    public BigDecimal getPsRealFeeAmt() {
        return psRealFeeAmt;
    }

    public void setPsRealFeeAmt(BigDecimal psRealFeeAmt) {
        this.psRealFeeAmt = psRealFeeAmt;
    }

    public String getRepaymentState() {
        return repaymentState;
    }

    public void setRepaymentState(String repaymentState) {
        this.repaymentState = repaymentState;
    }

    public String getPsRealSource() {
        return psRealSource;
    }

    public void setPsRealSource(String psRealSource) {
        this.psRealSource = psRealSource;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Short getPsPerdNo() {
        return psPerdNo;
    }

    public void setPsPerdNo(Short psPerdNo) {
        this.psPerdNo = psPerdNo;
    }

    public String getBankSerno() {
        return bankSerno;
    }

    public void setBankSerno(String bankSerno) {
        this.bankSerno = bankSerno;
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId;
    }

    public String getInputBrId() {
        return inputBrId;
    }

    public void setInputBrId(String inputBrId) {
        this.inputBrId = inputBrId;
    }

    public String getFeeSource() {
        return feeSource;
    }

    public void setFeeSource(String feeSource) {
        this.feeSource = feeSource;
    }

    public String getPremiumRepayType() {
        return premiumRepayType;
    }

    public void setPremiumRepayType(String premiumRepayType) {
        this.premiumRepayType = premiumRepayType;
    }

    public String getInputDateTime() {
        return inputDateTime;
    }

    public void setInputDateTime(String inputDateTime) {
        this.inputDateTime = inputDateTime;
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }
}