package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PaIndPublicRepaymentDetail {
    private String pkId;

    private String batchNo;

    private String sreNo;

    private String policyNo;

    private String applNo;

    private String custName;

    private BigDecimal reBurAmt;

    private String reBurDate;

    private String reBurFromName;

    private String insuCompany;

    private String reBurStatus;

    private String noticeResult;

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

    public String getSreNo() {
        return sreNo;
    }

    public void setSreNo(String sreNo) {
        this.sreNo = sreNo == null ? null : sreNo.trim();
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
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

    public String getNoticeResult() {
        return noticeResult;
    }

    public void setNoticeResult(String noticeResult) {
        this.noticeResult = noticeResult == null ? null : noticeResult.trim();
    }
}