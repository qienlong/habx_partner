package cn.com.sinosafe.domain.msxf;

import java.math.BigDecimal;

public class RepayPlan {
	private int totalInstallment;	//总期数
	private int installment;		//当前期数
	private String startDate;		//当期起始日
	private String dueDate;			//当期到期日
	private BigDecimal principal;	//本期应还本金
	private BigDecimal interest;	//本期应还利息
	private BigDecimal premium;		//每期应还保费金额
	private String extraInfo;		//扩展信息
	public int getTotalInstallment() {
		return totalInstallment;
	}
	public void setTotalInstallment(int totalInstallment) {
		this.totalInstallment = totalInstallment;
	}
	public int getInstallment() {
		return installment;
	}
	public void setInstallment(int installment) {
		this.installment = installment;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getPrincipal() {
		return principal;
	}
	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}
	public BigDecimal getInterest() {
		return interest;
	}
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}
	public BigDecimal getPremium() {
		return premium;
	}
	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}
	public String getExtraInfo() {
		return extraInfo;
	}
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

}
