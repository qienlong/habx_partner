package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PspClaimPaphRecode {
	
	private String pkId;
	
    private String claimBatchNo;

    private Short claimCount;

    private String lnAcct;

    private String applNo;

    private BigDecimal claimAmt;

    private String claimDate;
   
	private String insuCompany;

    private String noticeResult;
    
    public String getPkId() {
    	return pkId;
    }
    
    public void setPkId(String pkId) {
    	this.pkId = pkId == null ? null : pkId.trim();
    }
    
   	public String getNoticeResult() {
   		return noticeResult;
   	}

   	public void setNoticeResult(String noticeResult) {
   		this.noticeResult = noticeResult == null ? null : noticeResult.trim();
   	}
   	
    public String getClaimBatchNo() {
        return claimBatchNo;
    }

    public void setClaimBatchNo(String claimBatchNo) {
        this.claimBatchNo = claimBatchNo == null ? null : claimBatchNo.trim();
    }

    public Short getClaimCount() {
        return claimCount;
    }

    public void setClaimCount(Short claimCount) {
        this.claimCount = claimCount;
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

    public BigDecimal getClaimAmt() {
        return claimAmt;
    }

    public void setClaimAmt(BigDecimal claimAmt) {
        this.claimAmt = claimAmt;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate == null ? null : claimDate.trim();
    }

    public String getInsuCompany() {
        return insuCompany;
    }

    public void setInsuCompany(String insuCompany) {
        this.insuCompany = insuCompany == null ? null : insuCompany.trim();
    }
}