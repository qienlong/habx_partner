package cn.com.sinosafe.domain.entity;

import java.io.Serializable;

/**
 * MSXF_FEE_REPAY_DETAILS
 * @author 
 */
public class MsxfFeeRepayDetails implements Serializable {
    /**
     * 主键
     */
    private String bfId;

    /**
     * 业务日期
     */
    private String bizDate;

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
    private Short repayTerm;

    /**
     * 应缴保费
     */
    private String premium;

    /**
     * 实缴保费
     */
    private String premiumPaid;

    /**
     * 还款类型
     */
    private String repayType;

    /**
     * 录入日期
     */
    private String inputDate;

    /**
     * 同步状态
     */
    private String syncStatus;

    /**
     * 资金方
     */
    private String copNo;

    /**
     * 华安业务日期
     */
    private String businessDate;

    private static final long serialVersionUID = 1L;

    public String getBfId() {
        return bfId;
    }

    public void setBfId(String bfId) {
        this.bfId = bfId;
    }

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
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

    public Short getRepayTerm() {
        return repayTerm;
    }

    public void setRepayTerm(Short repayTerm) {
        this.repayTerm = repayTerm;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getPremiumPaid() {
        return premiumPaid;
    }

    public void setPremiumPaid(String premiumPaid) {
        this.premiumPaid = premiumPaid;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
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

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }
}