package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class CqnsjbBfCorrectInfo {
    private String pkId;

    private String serno;

    private String listSerno;

    private BigDecimal amountOrig;

    private BigDecimal amountCurr;

    private String status;
    
    private String correctDate;

    private String createDate;

    private String updateDate;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    public String getListSerno() {
        return listSerno;
    }

    public void setListSerno(String listSerno) {
        this.listSerno = listSerno == null ? null : listSerno.trim();
    }

    public BigDecimal getAmountOrig() {
        return amountOrig;
    }

    public void setAmountOrig(BigDecimal amountOrig) {
        this.amountOrig = amountOrig;
    }

    public BigDecimal getAmountCurr() {
        return amountCurr;
    }

    public void setAmountCurr(BigDecimal amountCurr) {
        this.amountCurr = amountCurr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }

	public String getCorrectDate() {
		return correctDate;
	}

	public void setCorrectDate(String correctDate) {
		this.correctDate = correctDate;
	}
    
    
}