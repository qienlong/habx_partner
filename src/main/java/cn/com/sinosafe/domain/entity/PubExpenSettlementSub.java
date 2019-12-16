package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PubExpenSettlementSub {
	private String pkId;
	
    private String uuid;

    private String overdueStage;

    private BigDecimal overdueRate;

    private BigDecimal overdueAmount;

    private BigDecimal overdueFee;

    /**
	 * @return the pkId
	 */
	public String getPkId() {
		return pkId;
	}

	/**
	 * @param pkId the pkId to set
	 */
	public void setPkId(String pkId) {
		this.pkId = pkId;
	}

	public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getOverdueStage() {
        return overdueStage;
    }

    public void setOverdueStage(String overdueStage) {
        this.overdueStage = overdueStage;
    }

    public BigDecimal getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(BigDecimal overdueRate) {
        this.overdueRate = overdueRate;
    }

    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public BigDecimal getOverdueFee() {
        return overdueFee;
    }

    public void setOverdueFee(BigDecimal overdueFee) {
        this.overdueFee = overdueFee;
    }
}