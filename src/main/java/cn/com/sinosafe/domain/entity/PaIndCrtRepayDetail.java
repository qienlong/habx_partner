package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PaIndCrtRepayDetail {
    private String id;

    private String applNo;

    private String lnAcct;

    private String trxNo;

    private String rpyType;

    private String trxDate;

    private String trxStDate;

    private BigDecimal insureAmt;

    private Short instNo;

    private String insuCompany;

    private String source;

    private String synStatus;

    private String businessDate;

    private String inputDateTime;

    private String updateDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApplNo() {
        return applNo;
    }

    public void setApplNo(String applNo) {
        this.applNo = applNo == null ? null : applNo.trim();
    }

    public String getLnAcct() {
        return lnAcct;
    }

    public void setLnAcct(String lnAcct) {
        this.lnAcct = lnAcct == null ? null : lnAcct.trim();
    }

    public String getTrxNo() {
        return trxNo;
    }

    public void setTrxNo(String trxNo) {
        this.trxNo = trxNo == null ? null : trxNo.trim();
    }

    public String getRpyType() {
        return rpyType;
    }

    public void setRpyType(String rpyType) {
        this.rpyType = rpyType == null ? null : rpyType.trim();
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate == null ? null : trxDate.trim();
    }

    public String getTrxStDate() {
        return trxStDate;
    }

    public void setTrxStDate(String trxStDate) {
        this.trxStDate = trxStDate == null ? null : trxStDate.trim();
    }

    public BigDecimal getInsureAmt() {
        return insureAmt;
    }

    public void setInsureAmt(BigDecimal insureAmt) {
        this.insureAmt = insureAmt;
    }

    public Short getInstNo() {
        return instNo;
    }

    public void setInstNo(Short instNo) {
        this.instNo = instNo;
    }

    public String getInsuCompany() {
        return insuCompany;
    }

    public void setInsuCompany(String insuCompany) {
        this.insuCompany = insuCompany == null ? null : insuCompany.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getSynStatus() {
        return synStatus;
    }

    public void setSynStatus(String synStatus) {
        this.synStatus = synStatus == null ? null : synStatus.trim();
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate == null ? null : businessDate.trim();
    }

    public String getInputDateTime() {
        return inputDateTime;
    }

    public void setInputDateTime(String inputDateTime) {
        this.inputDateTime = inputDateTime == null ? null : inputDateTime.trim();
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime == null ? null : updateDateTime.trim();
    }
}