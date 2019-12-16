/**   
* @Title:：CheckCostSetResult.java 
* @Package ：cn.com.sinosafe.domain.dto 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 上午11:58:24 
* @version ： 1.0   
*/
package cn.com.sinosafe.domain.dto;

import cn.com.sinosafe.common.config.constant.LstIqpSyncConstant;
import cn.com.sinosafe.common.util.StringUtils;

/** 
 * @ClassName:：CheckCostSetResult 
 * @Description： 对公费用确认结果
 * @author ：xiewei
 * @date ：2019年6月8日 上午11:58:24  
 */
public class CheckCostSetResult {
	/**
	 * 描述追偿服务费月份(yyyymm)
	 */
	private String accountMonth;
	/**
	 * 追偿服务费结果
	 */
	private String accountResult;
	/**
	 * 风控技术费月份(yyyymm)
	 */
	private String singlefeedate;
	/**
	 * 风控技术费确认结果
	 */
	private String singlefeeresult;
	/**
	 * 保险公司合作方
	 */
	private String insuCompany;
	
	
	
	public CheckCostSetResult() {
		super();
	}
	
	
	
	public CheckCostSetResult(String accountMonth, String accountResult,
			String singlefeedate, String singlefeeresult) {
		super();
		this.accountMonth = accountMonth;
		this.accountResult = accountResult;
		this.singlefeedate = singlefeedate;
		this.singlefeeresult = singlefeeresult;
	}
	public String getAccountMonth() {
		return accountMonth;
	}
	public void setAccountMonth(String accountMonth) {
		this.accountMonth = accountMonth;
	}
	public String getAccountResult() {
		return accountResult;
	}
	public void setAccountResult(String accountResult) {
		this.accountResult = accountResult;
	}
	public String getSinglefeedate() {
		return singlefeedate;
	}
	public void setSinglefeedate(String singlefeedate) {
		this.singlefeedate = singlefeedate;
	}
	public String getSinglefeeresult() {
		return singlefeeresult;
	}
	public void setSinglefeeresult(String singlefeeresult) {
		this.singlefeeresult = singlefeeresult;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckCostSetResult [accountMonth=");
		builder.append(accountMonth);
		builder.append(", accountResult=");
		builder.append(accountResult);
		builder.append(", singlefeedate=");
		builder.append(singlefeedate);
		builder.append(", singlefeeresult=");
		builder.append(singlefeeresult);
		builder.append(", insuCompany=");
		builder.append(insuCompany);
		builder.append("]");
		return builder.toString();
	}

}
