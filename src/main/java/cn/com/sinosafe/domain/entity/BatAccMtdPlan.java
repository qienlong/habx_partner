package cn.com.sinosafe.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * BAT_ACC_MTD_PLAN
 * @author 
 */
public class BatAccMtdPlan implements Serializable {

    /**
     * 借据号
     */
    private String billNo;

    /**
     * 还款期次
     */
    private Short psPerdNo;

    /**
     * 应还日期
     */
    private String psDueDt;

    /**
     * 应还本金
     */
    private BigDecimal psPrcpAmt;

    /**
     * 应还利息
     */
    private BigDecimal psNormIntAmt;

    /**
     * 应还罚息
     */
    private BigDecimal psOdIntAmt;

    /**
     * 应还复利
     */
    private BigDecimal psCommOdInt;

    /**
     * 实还日期
     */
    private String psRealDt;

    /**
     * 实还本金
     */
    private BigDecimal psRealPrcpAmt;

    /**
     * 实还利息
     */
    private BigDecimal psRealIntAmt;

    /**
     * 实还罚息
     */
    private BigDecimal setlOdIncTaken;

    /**
     * 实还复利
     */
    private BigDecimal setlCommOdInt;

    /**
     * 数据来源
     */
    private String sources;

    /**
     * 同步状态
     */
    private String synStatus;

    private String businessDate;

    private String checkResult;

    private String checkReason;

    private String prePay;

    private static final long serialVersionUID = 1L;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Short getPsPerdNo() {
        return psPerdNo;
    }

    public void setPsPerdNo(Short psPerdNo) {
        this.psPerdNo = psPerdNo;
    }

    public String getPsDueDt() {
        return psDueDt;
    }

    public void setPsDueDt(String psDueDt) {
        this.psDueDt = psDueDt;
    }

    public BigDecimal getPsPrcpAmt() {
        return psPrcpAmt;
    }

    public void setPsPrcpAmt(BigDecimal psPrcpAmt) {
        this.psPrcpAmt = psPrcpAmt;
    }

    public BigDecimal getPsNormIntAmt() {
        return psNormIntAmt;
    }

    public void setPsNormIntAmt(BigDecimal psNormIntAmt) {
        this.psNormIntAmt = psNormIntAmt;
    }

    public BigDecimal getPsOdIntAmt() {
        return psOdIntAmt;
    }

    public void setPsOdIntAmt(BigDecimal psOdIntAmt) {
        this.psOdIntAmt = psOdIntAmt;
    }

    public BigDecimal getPsCommOdInt() {
        return psCommOdInt;
    }

    public void setPsCommOdInt(BigDecimal psCommOdInt) {
        this.psCommOdInt = psCommOdInt;
    }

    public String getPsRealDt() {
        return psRealDt;
    }

    public void setPsRealDt(String psRealDt) {
        this.psRealDt = psRealDt;
    }

    public BigDecimal getPsRealPrcpAmt() {
        return psRealPrcpAmt;
    }

    public void setPsRealPrcpAmt(BigDecimal psRealPrcpAmt) {
        this.psRealPrcpAmt = psRealPrcpAmt;
    }

    public BigDecimal getPsRealIntAmt() {
        return psRealIntAmt;
    }

    public void setPsRealIntAmt(BigDecimal psRealIntAmt) {
        this.psRealIntAmt = psRealIntAmt;
    }

    public BigDecimal getSetlOdIncTaken() {
        return setlOdIncTaken;
    }

    public void setSetlOdIncTaken(BigDecimal setlOdIncTaken) {
        this.setlOdIncTaken = setlOdIncTaken;
    }

    public BigDecimal getSetlCommOdInt() {
        return setlCommOdInt;
    }

    public void setSetlCommOdInt(BigDecimal setlCommOdInt) {
        this.setlCommOdInt = setlCommOdInt;
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

    public String getPrePay() {
        return prePay;
    }

    public void setPrePay(String prePay) {
        this.prePay = prePay;
    }
}