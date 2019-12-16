/**   
* @Title:：PaBasicValue.java 
* @Package ：cn.com.sinosafe.domain.dto 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月3日 上午10:28:11 
* @version ： 1.0   
*/
package cn.com.sinosafe.domain.dto;

/** 
 * @ClassName:：PaBasicValue 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月3日 上午10:28:11  
 */
public class PaBasicValue {
	/**
	 * 投资人姓名
	 */
	private String investorName;
	/**
	 * 证件类型
	 */
	private String investorIdType;
	/**
	 * 证件号码
	 */
	private String investorId;
	/**
	 * 投资人陆金所ID
	 */
	private String investorLufaxId;
	/**
	 * 投资金额
	 */
	private int investedAmount;
	
	public String getInvestorName() {
		return investorName;
	}
	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}
	public String getInvestorIdType() {
		return investorIdType;
	}
	public void setInvestorIdType(String investorIdType) {
		this.investorIdType = investorIdType;
	}
	public String getInvestorId() {
		return investorId;
	}
	public void setInvestorId(String investorId) {
		this.investorId = investorId;
	}
	public String getInvestorLufaxId() {
		return investorLufaxId;
	}
	public void setInvestorLufaxId(String investorLufaxId) {
		this.investorLufaxId = investorLufaxId;
	}
	public int getInvestedAmount() {
		return investedAmount;
	}
	public void setInvestedAmount(int investedAmount) {
		this.investedAmount = investedAmount;
	}
	
}
