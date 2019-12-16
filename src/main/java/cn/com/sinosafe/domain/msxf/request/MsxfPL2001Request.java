package cn.com.sinosafe.domain.msxf.request;

import java.math.BigDecimal;
import java.util.List;

import cn.com.sinosafe.domain.msxf.RepayPlan;

/**
 * @author 
 *	放款结果通知（承保申请）请求实体			
 */
public class MsxfPL2001Request extends MsxfRequest {
	private String bizRequestNo;		//请求流水号
	private String loanNoExt;			//外部订单号
	private String preInsuranceNo;		//投保单号
	private String loanResult;			//响应码
	private BigDecimal applyAmount;		//保额
	private BigDecimal loanAmount;		//放款金额
	private String channelCode;			//渠道代码
	private String productCode;			//产品编号
	private List<RepayPlan> repayPlanList;		//还款计划
	private BigDecimal premium;			//保费
	private BigDecimal premiumRate;		//保费费率
	private String recognizeeCode;		//被保人编号
	private String guaranteeMethod;		//担保方式
	private String borrowerType;		//借款人类型
	private String loanEffectiveTime;	//借款开始时间
	private String loanExpiryTime;		//借款截止时间
	private String repaymentMode;		//还款方式
	private String repaymentFrequency;	//还款频率
	public String getBizRequestNo() {
		return bizRequestNo;
	}
	public void setBizRequestNo(String bizRequestNo) {
		this.bizRequestNo = bizRequestNo;
	}
	public String getLoanNoExt() {
		return loanNoExt;
	}
	public void setLoanNoExt(String loanNoExt) {
		this.loanNoExt = loanNoExt;
	}
	public String getPreInsuranceNo() {
		return preInsuranceNo;
	}
	public void setPreInsuranceNo(String preInsuranceNo) {
		this.preInsuranceNo = preInsuranceNo;
	}
	public String getLoanResult() {
		return loanResult;
	}
	public void setLoanResult(String loanResult) {
		this.loanResult = loanResult;
	}
	public BigDecimal getApplyAmount() {
		return applyAmount;
	}
	public void setApplyAmount(BigDecimal applyAmount) {
		this.applyAmount = applyAmount;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public List<RepayPlan> getRepayPlanList() {
		return repayPlanList;
	}
	public void setRepayPlanList(List<RepayPlan> repayPlanList) {
		this.repayPlanList = repayPlanList;
	}
	public BigDecimal getPremium() {
		return premium;
	}
	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}
	public BigDecimal getPremiumRate() {
		return premiumRate;
	}
	public void setPremiumRate(BigDecimal premiumRate) {
		this.premiumRate = premiumRate;
	}

	public String getRecognizeeCode() {
		return recognizeeCode;
	}

	public void setRecognizeeCode(String recognizeeCode) {
		this.recognizeeCode = recognizeeCode;
	}

	public String getGuaranteeMethod() {
		return guaranteeMethod;
	}
	public void setGuaranteeMethod(String guaranteeMethod) {
		this.guaranteeMethod = guaranteeMethod;
	}
	public String getBorrowerType() {
		return borrowerType;
	}
	public void setBorrowerType(String borrowerType) {
		this.borrowerType = borrowerType;
	}
	public String getLoanEffectiveTime() {
		return loanEffectiveTime;
	}
	public void setLoanEffectiveTime(String loanEffectiveTime) {
		this.loanEffectiveTime = loanEffectiveTime;
	}
	public String getLoanExpiryTime() {
		return loanExpiryTime;
	}
	public void setLoanExpiryTime(String loanExpiryTime) {
		this.loanExpiryTime = loanExpiryTime;
	}
	public String getRepaymentMode() {
		return repaymentMode;
	}
	public void setRepaymentMode(String repaymentMode) {
		this.repaymentMode = repaymentMode;
	}
	public String getRepaymentFrequency() {
		return repaymentFrequency;
	}
	public void setRepaymentFrequency(String repaymentFrequency) {
		this.repaymentFrequency = repaymentFrequency;
	}
	
}
