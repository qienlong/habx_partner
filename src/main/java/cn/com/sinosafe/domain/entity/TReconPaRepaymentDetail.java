package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TReconPaRepaymentDetail {
    private String pkId;

    private String batchNo;

    private String policyNo;

    private String sreNo;

    private String applNo;

    private String custName;

    private String cardNo;

    private BigDecimal reBurAmt;

    private String reBurDate;

    private String reBurFromName;

    private String insuCompany;

    private String reBurStatus;

    private String handleBy;

    private String handleTime;

    private String noticeResult;

    private String noticeTime;

    private String tradingFlowNo;

    private Date trandingTime;

    private String batchCount;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getSreNo() {
        return sreNo;
    }

    public void setSreNo(String sreNo) {
        this.sreNo = sreNo == null ? null : sreNo.trim();
    }

    public String getApplNo() {
        return applNo;
    }

    public void setApplNo(String applNo) {
        this.applNo = applNo == null ? null : applNo.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public BigDecimal getReBurAmt() {
        return reBurAmt;
    }

    public void setReBurAmt(BigDecimal reBurAmt) {
        this.reBurAmt = reBurAmt;
    }

    public String getReBurDate() {
        return reBurDate;
    }

    public void setReBurDate(String reBurDate) {
        this.reBurDate = reBurDate == null ? null : reBurDate.trim();
    }

    public String getReBurFromName() {
        return reBurFromName;
    }

    public void setReBurFromName(String reBurFromName) {
        this.reBurFromName = reBurFromName == null ? null : reBurFromName.trim();
    }

    public String getInsuCompany() {
        return insuCompany;
    }

    public void setInsuCompany(String insuCompany) {
        this.insuCompany = insuCompany == null ? null : insuCompany.trim();
    }

    public String getReBurStatus() {
        return reBurStatus;
    }

    public void setReBurStatus(String reBurStatus) {
        this.reBurStatus = reBurStatus == null ? null : reBurStatus.trim();
    }

    public String getHandleBy() {
        return handleBy;
    }

    public void setHandleBy(String handleBy) {
        this.handleBy = handleBy == null ? null : handleBy.trim();
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime == null ? null : handleTime.trim();
    }

    public String getNoticeResult() {
        return noticeResult;
    }

    public void setNoticeResult(String noticeResult) {
        this.noticeResult = noticeResult == null ? null : noticeResult.trim();
    }

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime == null ? null : noticeTime.trim();
    }

    public String getTradingFlowNo() {
        return tradingFlowNo;
    }

    public void setTradingFlowNo(String tradingFlowNo) {
        this.tradingFlowNo = tradingFlowNo == null ? null : tradingFlowNo.trim();
    }

    public Date getTrandingTime() {
        return trandingTime;
    }

    public void setTrandingTime(Date trandingTime) {
        this.trandingTime = trandingTime;
    }

    public String getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(String batchCount) {
        this.batchCount = batchCount == null ? null : batchCount.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}