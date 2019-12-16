package cn.com.sinosafe.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * MSXF_ACC_MTD_PS_NOTE
 * @author 
 */
public class MsxfAccMtdPsNote implements Serializable {
    /**
     * 主键
     */
    private String msxfAccMtdPsNoteId;

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
     * 还款日期
     */
    private String repayDate;

    /**
     * 流水号
     */
    private String repayRefNbr;

    /**
     * 本期应还本金
     */
    private BigDecimal principalDue;

    /**
     * 本金金额
     */
    private BigDecimal principalAmt;

    /**
     * 本期应还利息
     */
    private BigDecimal interestDue;

    /**
     * 利息金额
     */
    private BigDecimal interestAmt;

    /**
     * 本期应还罚息金额
     */
    private BigDecimal penaltyDue;

    /**
     * 罚息金额
     */
    private BigDecimal penaltyAmt;

    /**
     * 还款期数
     */
    private String repayTerm;

    /**
     * 还款类型(01:按期还款 02:提前还款 03"逾期还款 04:非应计还款)
     */
    private String repayType;

    /**
     * 还款银行卡号
     */
    private String repayCardNo;

    /**
     * 华安业务时间
     */
    private String businessDate;

    private static final long serialVersionUID = 1L;

    public String getMsxfAccMtdPsNoteId() {
        return msxfAccMtdPsNoteId;
    }

    public void setMsxfAccMtdPsNoteId(String msxfAccMtdPsNoteId) {
        this.msxfAccMtdPsNoteId = msxfAccMtdPsNoteId;
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

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public String getRepayRefNbr() {
        return repayRefNbr;
    }

    public void setRepayRefNbr(String repayRefNbr) {
        this.repayRefNbr = repayRefNbr;
    }

    public BigDecimal getPrincipalDue() {
        return principalDue;
    }

    public void setPrincipalDue(BigDecimal principalDue) {
        this.principalDue = principalDue;
    }

    public BigDecimal getPrincipalAmt() { return principalAmt; }

    public void setPrincipalAmt(BigDecimal principalAmt) { this.principalAmt = principalAmt; }

    public BigDecimal getInterestDue() {
        return interestDue;
    }

    public void setInterestDue(BigDecimal interestDue) {
        this.interestDue = interestDue;
    }

    public BigDecimal getInterestAmt() {
        return interestAmt;
    }

    public void setInterestAmt(BigDecimal interestAmt) {
        this.interestAmt = interestAmt;
    }

    public BigDecimal getPenaltyDue() {
        return penaltyDue;
    }

    public void setPenaltyDue(BigDecimal penaltyDue) {
        this.penaltyDue = penaltyDue;
    }

    public BigDecimal getPenaltyAmt() {
        return penaltyAmt;
    }

    public void setPenaltyAmt(BigDecimal penaltyAmt) {
        this.penaltyAmt = penaltyAmt;
    }

    public String getRepayTerm() { return repayTerm; }

    public void setRepayTerm(String repayTerm) { this.repayTerm = repayTerm; }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getRepayCardNo() {
        return repayCardNo;
    }

    public void setRepayCardNo(String repayCardNo) {
        this.repayCardNo = repayCardNo;
    }

    public String getBusinessDate() { return businessDate; }

    public void setBusinessDate(String businessDate) { this.businessDate = businessDate; }
}