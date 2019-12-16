package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PartnerBusiImportList {
    private String batchNo;

    private String batchName;

    private BigDecimal totalCount;

    private BigDecimal passCount;

    private BigDecimal noPassCount;

    private String importDate;

    private String insurNo;

    private String insurAddNo;

    private String inputUserId;

    private String inputBrId;

    private String status;

    private String copNo;

    private String prdCode;

    private String busiCopNo;

    private String isBatchInsur;

    private String bizMode;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName == null ? null : batchName.trim();
    }

    public BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getPassCount() {
        return passCount;
    }

    public void setPassCount(BigDecimal passCount) {
        this.passCount = passCount;
    }

    public BigDecimal getNoPassCount() {
        return noPassCount;
    }

    public void setNoPassCount(BigDecimal noPassCount) {
        this.noPassCount = noPassCount;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate == null ? null : importDate.trim();
    }

    public String getInsurNo() {
        return insurNo;
    }

    public void setInsurNo(String insurNo) {
        this.insurNo = insurNo == null ? null : insurNo.trim();
    }

    public String getInsurAddNo() {
        return insurAddNo;
    }

    public void setInsurAddNo(String insurAddNo) {
        this.insurAddNo = insurAddNo == null ? null : insurAddNo.trim();
    }

    public String getInputUserId() {
        return inputUserId;
    }

    public void setInputUserId(String inputUserId) {
        this.inputUserId = inputUserId == null ? null : inputUserId.trim();
    }

    public String getInputBrId() {
        return inputBrId;
    }

    public void setInputBrId(String inputBrId) {
        this.inputBrId = inputBrId == null ? null : inputBrId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCopNo() {
        return copNo;
    }

    public void setCopNo(String copNo) {
        this.copNo = copNo == null ? null : copNo.trim();
    }

    public String getPrdCode() {
        return prdCode;
    }

    public void setPrdCode(String prdCode) {
        this.prdCode = prdCode == null ? null : prdCode.trim();
    }

    public String getBusiCopNo() {
        return busiCopNo;
    }

    public void setBusiCopNo(String busiCopNo) {
        this.busiCopNo = busiCopNo == null ? null : busiCopNo.trim();
    }

    public String getIsBatchInsur() {
        return isBatchInsur;
    }

    public void setIsBatchInsur(String isBatchInsur) {
        this.isBatchInsur = isBatchInsur == null ? null : isBatchInsur.trim();
    }

    public String getBizMode() {
        return bizMode;
    }

    public void setBizMode(String bizMode) {
        this.bizMode = bizMode == null ? null : bizMode.trim();
    }
}