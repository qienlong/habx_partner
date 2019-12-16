package cn.com.sinosafe.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * MSXF_ACC_MTD_PLAN
 * @author 
 */
public class MsxfAccMtdPlan implements Serializable {
    /**
     * 主键
     */
    private String msxfAccMtdPlanId;

    /**
     * 业务日期
     */
    private String bizDate;

    /**
     * 新增日期
     */
    private String addDate;

    /**
     * 同步状态
     */
    private String syncStatus;

    /**
     * 资金方
     */
    private String copNo;

    /**
     * 合同号
     */
    private String contrNbr;

    /**
     * 产品编号
     */
    private String productCd;

    /**
     * 贷款编号
     */
    private String refNbr;

    /**
     * 还款期数
     */
    private String term;

    /**
     * 开始日期
     */
    private String beginDate;

    /**
     * 到期日期
     */
    private String stmtDate;

    /**
     * 宽限期到期日
     */
    private String graceDate;

    /**
     * 期数状态(N:正常 O:逾期 P:结清 F:非应计)
     */
    private String status;

    /**
     * 本金
     */
    private BigDecimal principal;

    /**
     * 已还本金
     */
    private BigDecimal principalPaid;

    /**
     * 逾期本金
     */
    private BigDecimal principalDue;

    /**
     * 非应计本金
     */
    private BigDecimal principalDue91;

    /**
     * 利息
     */
    private BigDecimal interest;

    /**
     * 已还利息
     */
    private BigDecimal interestPaid;

    /**
     * 逾期利息
     */
    private BigDecimal interestDue;

    /**
     * 表外利息
     */
    private BigDecimal interestDue91;

    /**
     * 罚息
     */
    private BigDecimal penaltyDue;

    /**
     * 已还罚息
     */
    private BigDecimal penaltyPaid;

    /**
     * 还款总期数
     */
    private String initTerm;

    /**
     * 华安业务时间
     */
    private String businessDate;

    private static final long serialVersionUID = 1L;

    public String getMsxfAccMtdPlanId() {
        return msxfAccMtdPlanId;
    }

    public void setMsxfAccMtdPlanId(String msxfAccMtdPlanId) {
        this.msxfAccMtdPlanId = msxfAccMtdPlanId;
    }

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getCopNo() {
        return copNo;
    }

    public void setCopNo(String copNo) {
        this.copNo = copNo;
    }

    public String getContrNbr() {
        return contrNbr;
    }

    public void setContrNbr(String contrNbr) {
        this.contrNbr = contrNbr;
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }

    public String getRefNbr() {
        return refNbr;
    }

    public void setRefNbr(String refNbr) {
        this.refNbr = refNbr;
    }

    public String getTerm() { return term; }

    public void setTerm(String term) { this.term = term; }

    public String getInitTerm() { return initTerm; }

    public void setInitTerm(String initTerm) { this.initTerm = initTerm; }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getStmtDate() {
        return stmtDate;
    }

    public void setStmtDate(String stmtDate) {
        this.stmtDate = stmtDate;
    }

    public String getGraceDate() {
        return graceDate;
    }

    public void setGraceDate(String graceDate) {
        this.graceDate = graceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getPrincipalPaid() {
        return principalPaid;
    }

    public void setPrincipalPaid(BigDecimal principalPaid) {
        this.principalPaid = principalPaid;
    }

    public BigDecimal getPrincipalDue() {
        return principalDue;
    }

    public void setPrincipalDue(BigDecimal principalDue) {
        this.principalDue = principalDue;
    }

    public BigDecimal getPrincipalDue91() {
        return principalDue91;
    }

    public void setPrincipalDue91(BigDecimal principalDue91) {
        this.principalDue91 = principalDue91;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(BigDecimal interestPaid) {
        this.interestPaid = interestPaid;
    }

    public BigDecimal getInterestDue() {
        return interestDue;
    }

    public void setInterestDue(BigDecimal interestDue) {
        this.interestDue = interestDue;
    }

    public BigDecimal getInterestDue91() {
        return interestDue91;
    }

    public void setInterestDue91(BigDecimal interestDue91) {
        this.interestDue91 = interestDue91;
    }

    public BigDecimal getPenaltyDue() {
        return penaltyDue;
    }

    public void setPenaltyDue(BigDecimal penaltyDue) {
        this.penaltyDue = penaltyDue;
    }

    public BigDecimal getPenaltyPaid() {
        return penaltyPaid;
    }

    public void setPenaltyPaid(BigDecimal penaltyPaid) {
        this.penaltyPaid = penaltyPaid;
    }

    public String getBusinessDate() { return businessDate; }

    public void setBusinessDate(String businessDate) { this.businessDate = businessDate; }
}