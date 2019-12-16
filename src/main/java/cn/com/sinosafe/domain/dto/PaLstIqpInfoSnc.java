/**   
* @Title:：PaLstIqpInfoSnc.java 
* @Package ：cn.com.sinosafe.domain.dto 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月5日 下午5:14:35 
* @version ： 1.0   
*/
package cn.com.sinosafe.domain.dto;

import java.math.BigDecimal;

import cn.com.sinosafe.common.config.constant.LstIqpSyncConstant;
import cn.com.sinosafe.common.util.StringUtils;

/** 
 * @ClassName:：PaLstIqpInfoSnc 
 * @Description： 保单信息同步响应类
 * @author ：xiewei
 * @date ：2019年6月5日 下午5:14:35  
 */
public class PaLstIqpInfoSnc {
	/**
	 * 申请号
	 */
	private String applNo;
	/**
	 * 保单号
	 */
	private String policyNo;
	/**
	 * 投保人姓名
	 */
	private String custName;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 身份证号
	 */
	private String id;
	/**
	 * 被保险人名称
	 */
	private String insureOfName;
	/**
	 * 保险金额
	 */
	private BigDecimal insuredAmt;
	/**
	 * 保险金额
	 */
	private BigDecimal insuredAmtMax;
	/**
	 * 保险期限
	 */
	private String insuredTerm;
	/**
	 * 保险缴纳方式
	 */
	private String payTypeAmt;
	/**
	 * 保费缴费日期
	 */
	private String payDate;
	/**
	 * 每月保费费率
	 */
	private BigDecimal insureRateMonth;
	/**
	 * 每月保费金额
	 */
	private BigDecimal  insureAmtMonth;
	/**
	 * 免赔率
	 */
	private BigDecimal abatementRate;
	/**
	 * 保险人公司地址
	 */
	private String insuAddr;
	/**
	 * 签发日期
	 */
	private String signDate;
	/**
	 * 保险公司合作方
	 */
	private String insuCompany;
	/**
	 * 来源方
	 */
	private String source;
	
	/**
	 * @return the insuredAmtMax
	 */
	public BigDecimal getInsuredAmtMax() {
		return insuredAmtMax;
	}

	/**
	 * @param insuredAmtMax the insuredAmtMax to set
	 */
	public void setInsuredAmtMax(BigDecimal insuredAmtMax) {
		this.insuredAmtMax = insuredAmtMax;
	}

	public String getApplNo() {
		return applNo;
	}
	
	public void setApplNo(String applNo) {
		this.applNo = applNo;
	}
	
	public String getPolicyNo() {
		return policyNo;
	}
	
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getInsureOfName() {
		return insureOfName;
	}
	
	public void setInsureOfName(String insureOfName) {
		this.insureOfName = insureOfName;
	}
	
	public BigDecimal getInsuredAmt() {
		return insuredAmt;
	}
	
	public void setInsuredAmt(BigDecimal insuredAmt) {
		this.insuredAmt = insuredAmt;
	}
	
	public String getInsuredTerm() {
		return insuredTerm;
	}
	
	public void setInsuredTerm(String insuredTerm) {
		this.insuredTerm = insuredTerm;
	}
	
	public String getPayTypeAmt() {
		return payTypeAmt;
	}
	
	public void setPayTypeAmt(String payTypeAmt) {
		this.payTypeAmt = payTypeAmt;
	}
	
	public String getPayDate() {
		return payDate;
	}
	
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	
	public BigDecimal getInsureRateMonth() {
		return insureRateMonth;
	}

	public void setInsureRateMonth(BigDecimal insureRateMonth) {
		this.insureRateMonth = insureRateMonth;
	}

	public BigDecimal getInsureAmtMonth() {
		return insureAmtMonth;
	}
	
	public void setInsureAmtMonth(BigDecimal insureAmtMonth) {
		this.insureAmtMonth = insureAmtMonth;
	}
	
	public BigDecimal getAbatementRate() {
		return abatementRate;
	}
	
	public void setAbatementRate(BigDecimal abatementRate) {
		this.abatementRate = abatementRate;
	}
	
	public String getInsuAddr() {
		return insuAddr;
	}
	
	public void setInsuAddr(String insuAddr) {
		this.insuAddr = insuAddr;
	}
	
	public String getSignDate() {
		return signDate;
	}
	
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	
	public String getInsuCompany() {
		return insuCompany;
	}
	
	public void setInsuCompany(String insuCompany) {
		if(StringUtils.isEmpty(insuCompany)){
			insuCompany=LstIqpSyncConstant.insuCompany;
		}
		this.insuCompany = insuCompany;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		if(StringUtils.isEmpty(source)){
			source=LstIqpSyncConstant.source;
		}
		this.source = source;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaLstIqpInfoSnc [applNo=" + applNo + ", policyNo=" + policyNo + ", custName=" + custName + ", mobile="
				+ mobile + ", id=" + id + ", insureOfName=" + insureOfName + ", insuredAmt=" + insuredAmt
				+ ", insuredAmtMax=" + insuredAmtMax + ", insuredTerm=" + insuredTerm + ", payTypeAmt=" + payTypeAmt
				+ ", payDate=" + payDate + ", insureRateMonth=" + insureRateMonth + ", insureAmtMonth=" + insureAmtMonth
				+ ", abatementRate=" + abatementRate + ", insuAddr=" + insuAddr + ", signDate=" + signDate
				+ ", insuCompany=" + insuCompany + ", source=" + source + "]";
	}

	

	
}
