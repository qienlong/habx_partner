package cn.com.sinosafe.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * BAT_REPAY_DETAILS
 * @author 
 */
public class BatRepayDetails implements Serializable {
    /**
     * 还款流水号
     */
    private String repaySerialNo;

    /**
     * 借据号
     */
    private String billNo;

    /**
     * 还款期次
     */
    private BigDecimal repayTimesNo;

    /**
     * 还款日期
     */
    private String repayDate;

    /**
     * 还款本金
     */
    private BigDecimal repayCap;

    /**
     * 还款利息
     */
    private BigDecimal repayInt;

    /**
     * 还款罚息
     */
    private BigDecimal repayFineInt;

    /**
     * 还款复利
     */
    private BigDecimal repayCompInt;

    /**
     * 数据来源
     */
    private String sources;

    /**
     * 同步状态
     */
    private String synStatus;

    private String businessDate;

    private BigDecimal dueRepayCap;

    private BigDecimal dueRepayInt;

    private BigDecimal dueFineInt;

    private BigDecimal dueCompInt;

    private String paySourceType;

    private String paySourceAccount;

    private String checkResult;

    private String checkReason;

    private String accountName;

    private String accountNo;

    private String prePay;

    private String paymentNo;

    private static final long serialVersionUID = 1L;

    public String getRepaySerialNo() {
        return repaySerialNo;
    }

    public void setRepaySerialNo(String repaySerialNo) {
        this.repaySerialNo = repaySerialNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public BigDecimal getRepayTimesNo() {
        return repayTimesNo;
    }

    public void setRepayTimesNo(BigDecimal repayTimesNo) {
        this.repayTimesNo = repayTimesNo;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public BigDecimal getRepayCap() {
        return repayCap;
    }

    public void setRepayCap(BigDecimal repayCap) {
        this.repayCap = repayCap;
    }

    public BigDecimal getRepayInt() {
        return repayInt;
    }

    public void setRepayInt(BigDecimal repayInt) {
        this.repayInt = repayInt;
    }

    public BigDecimal getRepayFineInt() {
        return repayFineInt;
    }

    public void setRepayFineInt(BigDecimal repayFineInt) {
        this.repayFineInt = repayFineInt;
    }

    public BigDecimal getRepayCompInt() {
        return repayCompInt;
    }

    public void setRepayCompInt(BigDecimal repayCompInt) {
        this.repayCompInt = repayCompInt;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getSynStatus() {
        return synStatus;
    }

    public void setSynStatus(String synStatus) {
        this.synStatus = synStatus;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public BigDecimal getDueRepayCap() {
        return dueRepayCap;
    }

    public void setDueRepayCap(BigDecimal dueRepayCap) {
        this.dueRepayCap = dueRepayCap;
    }

    public BigDecimal getDueRepayInt() {
        return dueRepayInt;
    }

    public void setDueRepayInt(BigDecimal dueRepayInt) {
        this.dueRepayInt = dueRepayInt;
    }

    public BigDecimal getDueFineInt() {
        return dueFineInt;
    }

    public void setDueFineInt(BigDecimal dueFineInt) {
        this.dueFineInt = dueFineInt;
    }

    public BigDecimal getDueCompInt() {
        return dueCompInt;
    }

    public void setDueCompInt(BigDecimal dueCompInt) {
        this.dueCompInt = dueCompInt;
    }

    public String getPaySourceType() {
        return paySourceType;
    }

    public void setPaySourceType(String paySourceType) {
        this.paySourceType = paySourceType;
    }

    public String getPaySourceAccount() {
        return paySourceAccount;
    }

    public void setPaySourceAccount(String paySourceAccount) {
        this.paySourceAccount = paySourceAccount;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckReason() {
        return checkReason;
    }

    public void setCheckReason(String checkReason) {
        this.checkReason = checkReason;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPrePay() {
        return prePay;
    }

    public void setPrePay(String prePay) {
        this.prePay = prePay;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }
}