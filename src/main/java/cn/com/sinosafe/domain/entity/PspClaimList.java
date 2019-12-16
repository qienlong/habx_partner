package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PspClaimList {
    private String billNo;

    private BigDecimal deIr;

    private BigDecimal unsetPsPrcpAmt;

    private BigDecimal unsetPsNormIntAmt;

    private BigDecimal unsetPsOdIntAmt;

    private BigDecimal unsetPsCommOdInt;

    private Integer overDays;

    private BigDecimal estOdCommAmt;

    private BigDecimal thisClaimAmount;

    private BigDecimal thisClaimAmountSum;

    private String perdStatus;

    private String overDate;

    private String initStatus;

    private String netPhone;

    private String appDate;

    private String shouldAlsoDate;

    private String serno;

    private Integer psPerdNo;

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    public Integer getPsPerdNo() {
        return psPerdNo;
    }

    public void setPsPerdNo(Integer psPerdNo) {
        this.psPerdNo = psPerdNo;
    }
    
    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public BigDecimal getDeIr() {
        return deIr;
    }

    public void setDeIr(BigDecimal deIr) {
        this.deIr = deIr;
    }

    public BigDecimal getUnsetPsPrcpAmt() {
        return unsetPsPrcpAmt;
    }

    public void setUnsetPsPrcpAmt(BigDecimal unsetPsPrcpAmt) {
        this.unsetPsPrcpAmt = unsetPsPrcpAmt;
    }

    public BigDecimal getUnsetPsNormIntAmt() {
        return unsetPsNormIntAmt;
    }

    public void setUnsetPsNormIntAmt(BigDecimal unsetPsNormIntAmt) {
        this.unsetPsNormIntAmt = unsetPsNormIntAmt;
    }

    public BigDecimal getUnsetPsOdIntAmt() {
        return unsetPsOdIntAmt;
    }

    public void setUnsetPsOdIntAmt(BigDecimal unsetPsOdIntAmt) {
        this.unsetPsOdIntAmt = unsetPsOdIntAmt;
    }

    public BigDecimal getUnsetPsCommOdInt() {
        return unsetPsCommOdInt;
    }

    public void setUnsetPsCommOdInt(BigDecimal unsetPsCommOdInt) {
        this.unsetPsCommOdInt = unsetPsCommOdInt;
    }

    public Integer getOverDays() {
        return overDays;
    }

    public void setOverDays(Integer overDays) {
        this.overDays = overDays;
    }

    public BigDecimal getEstOdCommAmt() {
        return estOdCommAmt;
    }

    public void setEstOdCommAmt(BigDecimal estOdCommAmt) {
        this.estOdCommAmt = estOdCommAmt;
    }

    public BigDecimal getThisClaimAmount() {
        return thisClaimAmount;
    }

    public void setThisClaimAmount(BigDecimal thisClaimAmount) {
        this.thisClaimAmount = thisClaimAmount;
    }

    public BigDecimal getThisClaimAmountSum() {
        return thisClaimAmountSum;
    }

    public void setThisClaimAmountSum(BigDecimal thisClaimAmountSum) {
        this.thisClaimAmountSum = thisClaimAmountSum;
    }

    public String getPerdStatus() {
        return perdStatus;
    }

    public void setPerdStatus(String perdStatus) {
        this.perdStatus = perdStatus == null ? null : perdStatus.trim();
    }

    public String getOverDate() {
        return overDate;
    }

    public void setOverDate(String overDate) {
        this.overDate = overDate == null ? null : overDate.trim();
    }

    public String getInitStatus() {
        return initStatus;
    }

    public void setInitStatus(String initStatus) {
        this.initStatus = initStatus == null ? null : initStatus.trim();
    }

    public String getNetPhone() {
        return netPhone;
    }

    public void setNetPhone(String netPhone) {
        this.netPhone = netPhone == null ? null : netPhone.trim();
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate == null ? null : appDate.trim();
    }

    public String getShouldAlsoDate() {
        return shouldAlsoDate;
    }

    public void setShouldAlsoDate(String shouldAlsoDate) {
        this.shouldAlsoDate = shouldAlsoDate == null ? null : shouldAlsoDate.trim();
    }
}