package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class CqnsjbZcAccountList {
    private String accountMonth;

    private String recoveryNum;

    private BigDecimal recoveryAmount;

    private String status;

    private String operName;

    private String operDate;

    public String getAccountMonth() {
        return accountMonth;
    }

    public void setAccountMonth(String accountMonth) {
        this.accountMonth = accountMonth == null ? null : accountMonth.trim();
    }

    public String getRecoveryNum() {
        return recoveryNum;
    }

    public void setRecoveryNum(String recoveryNum) {
        this.recoveryNum = recoveryNum == null ? null : recoveryNum.trim();
    }

    public BigDecimal getRecoveryAmount() {
        return recoveryAmount;
    }

    public void setRecoveryAmount(BigDecimal recoveryAmount) {
        this.recoveryAmount = recoveryAmount;
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