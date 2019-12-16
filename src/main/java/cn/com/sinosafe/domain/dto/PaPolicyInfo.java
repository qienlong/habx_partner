/**   
* @Title:：PaPolicyInfo.java 
* @Package ：cn.com.sinosafe.domain.dto 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月3日 上午10:30:03 
* @version ： 1.0   
*/
package cn.com.sinosafe.domain.dto;

import java.math.BigDecimal;

/** 
 * @ClassName:：PaPolicyInfo 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月3日 上午10:30:03  
 */
public class PaPolicyInfo {
	/**
	 * 核保单号
	 */
	private String checkNo;
	/**
	 * 申请号
	 */
	private String applNo;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 申请金额
	 */
	private BigDecimal lnAmt;
	/**
	 * 申请日期
	 */
	private String lnDate;
	/**
	 * 期数
	 */
	private BigDecimal lnTerm;
	/**
	 * 业务类型
	 */
	private String productType;
	/**
	 * 借款人陆金所ID
	 */
	private String lufaxId;
	/**
	 * 安硕贷款受理号
	 */
	private String anshuoLoanAcceptId;
	/**
	 * 投保人抵押房产地址
	 */
	private String mortgageAddr;
	/**
	 * 保险人公司
	 */
	private String guaranteeCompany;
	/**
	 * 保险人公司地址
	 */
	private String guaranteeCompanyAddr;
	/**
	 * 住址
	 */
	private String holderAddr;
	/**
	 * 征信授权书影像编码
	 */
	private String barCode;
	/**
	 * 免赔比率
	 */
	private BigDecimal abatementRate;
	
	
	/**
	 * @return the lnAmt
	 */
	public BigDecimal getLnAmt() {
		return lnAmt;
	}
	/**
	 * @param lnAmt the lnAmt to set
	 */
	public void setLnAmt(BigDecimal lnAmt) {
		this.lnAmt = lnAmt;
	}
	/**
	 * @return the lnDate
	 */
	public String getLnDate() {
		return lnDate;
	}
	/**
	 * @param lnDate the lnDate to set
	 */
	public void setLnDate(String lnDate) {
		this.lnDate = lnDate;
	}
	/**
	 * @return the lnTerm
	 */
	public BigDecimal getLnTerm() {
		return lnTerm;
	}
	/**
	 * @param lnTerm the lnTerm to set
	 */
	public void setLnTerm(BigDecimal lnTerm) {
		this.lnTerm = lnTerm;
	}
	/**
	 * @return the lufaxId
	 */
	public String getLufaxId() {
		return lufaxId;
	}
	/**
	 * @param lufaxId the lufaxId to set
	 */
	public void setLufaxId(String lufaxId) {
		this.lufaxId = lufaxId;
	}
	public String getCheckNo() {
		return checkNo;
	}
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}
	public String getApplNo() {
		return applNo;
	}
	public void setApplNo(String applNo) {
		this.applNo = applNo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getAnshuoLoanAcceptId() {
		return anshuoLoanAcceptId;
	}
	public void setAnshuoLoanAcceptId(String anshuoLoanAcceptId) {
		this.anshuoLoanAcceptId = anshuoLoanAcceptId;
	}
	public String getMortgageAddr() {
		return mortgageAddr;
	}
	public void setMortgageAddr(String mortgageAddr) {
		this.mortgageAddr = mortgageAddr;
	}
	public String getGuaranteeCompany() {
		return guaranteeCompany;
	}
	public void setGuaranteeCompany(String guaranteeCompany) {
		this.guaranteeCompany = guaranteeCompany;
	}
	public String getGuaranteeCompanyAddr() {
		return guaranteeCompanyAddr;
	}
	public void setGuaranteeCompanyAddr(String guaranteeCompanyAddr) {
		this.guaranteeCompanyAddr = guaranteeCompanyAddr;
	}
	public String getHolderAddr() {
		return holderAddr;
	}
	public void setHolderAddr(String holderAddr) {
		this.holderAddr = holderAddr;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public BigDecimal getAbatementRate() {
		return abatementRate;
	}
	public void setAbatementRate(BigDecimal abatementRate) {
		if(null==abatementRate){
			abatementRate=new BigDecimal("0.0");
		}
		this.abatementRate = abatementRate;
	}
	
}
