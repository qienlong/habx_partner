package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PspClaimApprove {
    private String pkId;

    private String claimType;

    private BigDecimal claimApplyAmount;

    private String isGuar;

    private String claimDate;

    private String claimOrg;

    private String approver;

    private String claimApplyType;

    private BigDecimal claimEndAmount;

    private String claimOpinion;

    private String claimResult;

    private String serno;

    private BigDecimal overdueAmount;

    private String isManual;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType == null ? null : claimType.trim();
    }

    public BigDecimal getClaimApplyAmount() {
        return claimApplyAmount;
    }

    public void setClaimApplyAmount(BigDecimal claimApplyAmount) {
        this.claimApplyAmount = claimApplyAmount;
    }

    public String getIsGuar() {
        return isGuar;
    }

    public void setIsGuar(String isGuar) {
        this.isGuar = isGuar == null ? null : isGuar.trim();
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate == null ? null : claimDate.trim();
    }

    public String getClaimOrg() {
        return claimOrg;
    }

    public void setClaimOrg(String claimOrg) {
        this.claimOrg = claimOrg == null ? null : claimOrg.trim();
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver == null ? null : approver.trim();
    }

    public String getClaimApplyType() {
        return claimApplyType;
    }

    public void setClaimApplyType(String claimApplyType) {
        this.claimApplyType = claimApplyType == null ? null : claimApplyType.trim();
    }

    public BigDecimal getClaimEndAmount() {
        return claimEndAmount;
    }

    public void setClaimEndAmount(BigDecimal claimEndAmount) {
        this.claimEndAmount = claimEndAmount;
    }

    public String getClaimOpinion() {
        return claimOpinion;
    }

    public void setClaimOpinion(String claimOpinion) {
        this.claimOpinion = claimOpinion == null ? null : claimOpinion.trim();
    }

    public String getClaimResult() {
        return claimResult;
    }

    public void setClaimResult(String claimResult) {
        this.claimResult = claimResult == null ? null : claimResult.trim();
    }

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public String getIsManual() {
        return isManual;
    }

    public void setIsManual(String isManual) {
        this.isManual = isManual == null ? null : isManual.trim();
    }
}