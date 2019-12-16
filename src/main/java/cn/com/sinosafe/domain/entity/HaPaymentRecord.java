package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class HaPaymentRecord {
    private String id;

    private String businessId;

    private String businessType;

    private String applyPerson;

    private String applyOrg;

    private String applyTime;

    private String transactionNumber;

    private String paymentAccount;

    private String paymentBankName;

    private BigDecimal paymentAmount;

    private String paymentCurrency;

    private String receivablesAccount;

    private String receivablesBank;

    private String receivablesOpeningbankname;

    private String receivablesAddr;

    private String transactionTime;

    private String paymentStatus;

    private String paymentStatusUpdateTime;

    private String paymentFailReason;

    private String returnTicketStatus;

    private String reconciliationcode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getApplyPerson() {
        return applyPerson;
    }

    public void setApplyPerson(String applyPerson) {
        this.applyPerson = applyPerson == null ? null : applyPerson.trim();
    }

    public String getApplyOrg() {
        return applyOrg;
    }

    public void setApplyOrg(String applyOrg) {
        this.applyOrg = applyOrg == null ? null : applyOrg.trim();
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime == null ? null : applyTime.trim();
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber == null ? null : transactionNumber.trim();
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount == null ? null : paymentAccount.trim();
    }

    public String getPaymentBankName() {
        return paymentBankName;
    }

    public void setPaymentBankName(String paymentBankName) {
        this.paymentBankName = paymentBankName == null ? null : paymentBankName.trim();
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency == null ? null : paymentCurrency.trim();
    }

    public String getReceivablesAccount() {
        return receivablesAccount;
    }

    public void setReceivablesAccount(String receivablesAccount) {
        this.receivablesAccount = receivablesAccount == null ? null : receivablesAccount.trim();
    }

    public String getReceivablesBank() {
        return receivablesBank;
    }

    public void setReceivablesBank(String receivablesBank) {
        this.receivablesBank = receivablesBank == null ? null : receivablesBank.trim();
    }

    public String getReceivablesOpeningbankname() {
        return receivablesOpeningbankname;
    }

    public void setReceivablesOpeningbankname(String receivablesOpeningbankname) {
        this.receivablesOpeningbankname = receivablesOpeningbankname == null ? null : receivablesOpeningbankname.trim();
    }

    public String getReceivablesAddr() {
        return receivablesAddr;
    }

    public void setReceivablesAddr(String receivablesAddr) {
        this.receivablesAddr = receivablesAddr == null ? null : receivablesAddr.trim();
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime == null ? null : transactionTime.trim();
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus == null ? null : paymentStatus.trim();
    }

    public String getPaymentStatusUpdateTime() {
        return paymentStatusUpdateTime;
    }

    public void setPaymentStatusUpdateTime(String paymentStatusUpdateTime) {
        this.paymentStatusUpdateTime = paymentStatusUpdateTime == null ? null : paymentStatusUpdateTime.trim();
    }

    public String getPaymentFailReason() {
        return paymentFailReason;
    }

    public void setPaymentFailReason(String paymentFailReason) {
        this.paymentFailReason = paymentFailReason == null ? null : paymentFailReason.trim();
    }

    public String getReturnTicketStatus() {
        return returnTicketStatus;
    }

    public void setReturnTicketStatus(String returnTicketStatus) {
        this.returnTicketStatus = returnTicketStatus == null ? null : returnTicketStatus.trim();
    }

    public String getReconciliationcode() {
        return reconciliationcode;
    }

    public void setReconciliationcode(String reconciliationcode) {
        this.reconciliationcode = reconciliationcode == null ? null : reconciliationcode.trim();
    }
}