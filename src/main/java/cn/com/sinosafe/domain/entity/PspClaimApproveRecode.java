package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PspClaimApproveRecode {
	
	private String pkId;
	
    private String batchNo;

    private Short count;

    private String policyNo;

    private String claimType;

    private String lnAcct;

    private String applNo;

    private BigDecimal lnAmt;

    private Short lnTerm;

    private BigDecimal claimAmt;

    private BigDecimal prinAmt;

    private BigDecimal intAmt;

    private BigDecimal lcAmt;

    private String premDate;

    private String insuCompany;

    private String approveStatus;
    
    private String isHoliday;
    
    

    /**
	 * @return the isHoliday
	 */
	public String getIsHoliday() {
		return isHoliday;
	}

	/**
	 * @param isHoliday the isHoliday to set
	 */
	public void setIsHoliday(String isHoliday) {
		this.isHoliday = isHoliday;
	}

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

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType == null ? null : claimType.trim();
    }

    public String getLnAcct() {
        return lnAcct;
    }

    public void setLnAcct(String lnAcct) {
        this.lnAcct = lnAcct == null ? null : lnAcct.trim();
    }

    public String getApplNo() {
        return applNo;
    }

    public void setApplNo(String applNo) {
        this.applNo = applNo == null ? null : applNo.trim();
    }

    public BigDecimal getLnAmt() {
        return lnAmt;
    }

    public void setLnAmt(BigDecimal lnAmt) {
        this.lnAmt = lnAmt;
    }

    public Short getLnTerm() {
        return lnTerm;
    }

    public void setLnTerm(Short lnTerm) {
        this.lnTerm = lnTerm;
    }

    public BigDecimal getClaimAmt() {
        return claimAmt;
    }

    public void setClaimAmt(BigDecimal claimAmt) {
        this.claimAmt = claimAmt;
    }

    public BigDecimal getPrinAmt() {
        return prinAmt;
    }

    public void setPrinAmt(BigDecimal prinAmt) {
        this.prinAmt = prinAmt;
    }

    public BigDecimal getIntAmt() {
        return intAmt;
    }

    public void setIntAmt(BigDecimal intAmt) {
        this.intAmt = intAmt;
    }

    public BigDecimal getLcAmt() {
        return lcAmt;
    }

    public void setLcAmt(BigDecimal lcAmt) {
        this.lcAmt = lcAmt;
    }

    public String getPremDate() {
        return premDate;
    }

    public void setPremDate(String premDate) {
        this.premDate = premDate == null ? null : premDate.trim();
    }

    public String getInsuCompany() {
        return insuCompany;
    }

    public void setInsuCompany(String insuCompany) {
        this.insuCompany = insuCompany == null ? null : insuCompany.trim();
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus == null ? null : approveStatus.trim();
    }
}