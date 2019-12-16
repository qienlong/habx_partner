package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class CqnsjbBfAccountList {
    private String accountMonth;

    private BigDecimal realTotalInt;

    private BigDecimal cusRealInt;

    private String cusRealNum;

    private BigDecimal claimInt;

    private String claimNum;

    private BigDecimal insureInt;

    private BigDecimal insureAmount;

    private String status;

    private String operName;

    private String operDate;

    public String getAccountMonth() {
        return accountMonth;
    }

    public void setAccountMonth(String accountMonth) {
        this.accountMonth = accountMonth == null ? null : accountMonth.trim();
    }

    public BigDecimal getRealTotalInt() {
        return realTotalInt;
    }

    public void setRealTotalInt(BigDecimal realTotalInt) {
        this.realTotalInt = realTotalInt;
    }

    public BigDecimal getCusRealInt() {
        return cusRealInt;
    }

    public void setCusRealInt(BigDecimal cusRealInt) {
        this.cusRealInt = cusRealInt;
    }

    public String getCusRealNum() {
        return cusRealNum;
    }

    public void setCusRealNum(String cusRealNum) {
        this.cusRealNum = cusRealNum == null ? null : cusRealNum.trim();
    }

    public BigDecimal getClaimInt() {
        return claimInt;
    }

    public void setClaimInt(BigDecimal claimInt) {
        this.claimInt = claimInt;
    }

    public String getClaimNum() {
        return claimNum;
    }

    public void setClaimNum(String claimNum) {
        this.claimNum = claimNum == null ? null : claimNum.trim();
    }

    public BigDecimal getInsureInt() {
        return insureInt;
    }

    public void setInsureInt(BigDecimal insureInt) {
        this.insureInt = insureInt;
    }

    public BigDecimal getInsureAmount() {
        return insureAmount;
    }

    public void setInsureAmount(BigDecimal insureAmount) {
        this.insureAmount = insureAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public String getOperDate() {
        return operDate;
    }

    public void setOperDate(String operDate) {
        this.operDate = operDate == null ? null : operDate.trim();
    }
}