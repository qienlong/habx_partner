/**   
* @Title:：PaCostSettlementDto.java 
* @Package ：cn.com.sinosafe.domain.dto 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午2:19:28 
* @version ： 1.0   
*/
package cn.com.sinosafe.domain.dto;

import cn.com.sinosafe.common.config.constant.PaCostSettlementConstant;
import cn.com.sinosafe.common.util.StringUtils;

/** 
 * @ClassName:：PaCostSettlementDto 
 * @Description： 用于对公费用结算接口接收平安过来的参数
 * @author ：xiewei
 * @date ：2019年6月8日 下午2:19:28  
 */
public class PaCostSettlementDto {
	/**
     * 追偿服务费月份
     */
	private String accountMonth;
	/**
     * 追偿服务费总额
     */
	private String accountTotal;
	 /**
     * 基础费单价
     */
	private String basePrice;
	/**
     * 活跃账户数总量
     */
	private String accountNum;
	/**
     * 基础费总额
     */
	private String basePriceTotal;
	/**
     * 浮动费资产包所属月份
     */
	private String floatingMonth;
	/**
     * 资产包净赔付
     */
	private String assetPoolPa;
	 /**
     * 资产包保费收入
     */
	private String assetPoolInsur;
	/**
     * 资产包理赔率
     */
	private String assetPoolOdds;
	/**
     * 浮动费单价
     */
	private String floatingPrice;
	/**
     * 浮动费资产包有效账龄
     */
	private String floatingAge;
	/**
     * 浮动费总额
     */
	private String floatingTotal;
	/**
     * 风控技术费月份
     */
	private String singlefeedate;
	/**
     * 风控技术费单价
     */
	private String singlefeerate;
	/**
     * 投保成功申请笔数
     */
	private String coverFiAmt;
	/**
     * 风控技术费总额
     */
	private String singlefeetotal;
	
	private String overdueTotal;
	
	private String overdueFeeList;
	
	/**
	 * @return the overdueTotal
	 */
	public String getOverdueTotal() {
		return overdueTotal;
	}
	/**
	 * @param overdueTotal the overdueTotal to set
	 */
	public void setOverdueTotal(String overdueTotal) {
		this.overdueTotal = overdueTotal;
	}
	/**
	 * @return the overdueFeeList
	 */
	public String getOverdueFeeList() {
		return overdueFeeList;
	}
	/**
	 * @param overdueFeeList the overdueFeeList to set
	 */
	public void setOverdueFeeList(String overdueFeeList) {
		this.overdueFeeList = overdueFeeList;
	}
	public String getAccountMonth() {
		return accountMonth;
	}
	public void setAccountMonth(String accountMonth) {
		this.accountMonth = accountMonth;
	}
	public String getAccountTotal() {
		return accountTotal;
	}
	public void setAccountTotal(String accountTotal) {
		if(StringUtils.isEmpty(accountTotal)){
			accountTotal=PaCostSettlementConstant.DEFBIGDECIMAL;
		}
		this.accountTotal = accountTotal;
	}
	public String getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(String basePrice) {
		if(StringUtils.isEmpty(basePrice)){
			basePrice=PaCostSettlementConstant.DEFBIGDECIMAL;
		}
		this.basePrice = basePrice;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getBasePriceTotal() {
		return basePriceTotal;
	}
	public void setBasePriceTotal(String basePriceTotal) {
		if(StringUtils.isEmpty(basePriceTotal)){
			basePriceTotal=PaCostSettlementConstant.DEFBIGDECIMAL;
		}
		this.basePriceTotal = basePriceTotal;
	}
	public String getFloatingMonth() {
		return floatingMonth;
	}
	public void setFloatingMonth(String floatingMonth) {
		this.floatingMonth = floatingMonth;
	}
	public String getAssetPoolPa() {
		return assetPoolPa;
	}
	public void setAssetPoolPa(String assetPoolPa) {
		if(StringUtils.isEmpty(assetPoolPa)){
			assetPoolPa=PaCostSettlementConstant.DEFBIGDECIMAL;
		}
		this.assetPoolPa = assetPoolPa;
	}
	public String getAssetPoolInsur() {
		return assetPoolInsur;
	}
	public void setAssetPoolInsur(String assetPoolInsur) {
		if(StringUtils.isEmpty(assetPoolInsur)){
			assetPoolInsur=PaCostSettlementConstant.DEFBIGDECIMAL;
		}
		this.assetPoolInsur = assetPoolInsur;
	}
	public String getAssetPoolOdds() {
		return assetPoolOdds;
	}
	public void setAssetPoolOdds(String assetPoolOdds) {
		if(StringUtils.isEmpty(assetPoolOdds)){
			assetPoolOdds=PaCostSettlementConstant.DEFBIGDECIMAL;
		}
		this.assetPoolOdds = assetPoolOdds;
	}
	public String getFloatingPrice() {
		return floatingPrice;
	}
	public void setFloatingPrice(String floatingPrice) {
		if(StringUtils.isEmpty(floatingPrice)){
			floatingPrice=PaCostSettlementConstant.DEFBIGDECIMAL;
		}
		this.floatingPrice = floatingPrice;
	}
	public String getFloatingAge() {
		return floatingAge;
	}
	public void setFloatingAge(String floatingAge) {
		this.floatingAge = floatingAge;
	}
	public String getFloatingTotal() {
		return floatingTotal;
	}
	public void setFloatingTotal(String floatingTotal) {
		if(StringUtils.isEmpty(floatingTotal)){
			floatingTotal=PaCostSettlementConstant.DEFBIGDECIMAL;
		}
		this.floatingTotal = floatingTotal;
	}
	public String getSinglefeedate() {
		return singlefeedate;
	}
	public void setSinglefeedate(String singlefeedate) {
		this.singlefeedate = singlefeedate;
	}
	public String getSinglefeerate() {
		return singlefeerate;
	}
	public void setSinglefeerate(String singlefeerate) {
		if(StringUtils.isEmpty(singlefeerate)){
			singlefeerate=PaCostSettlementConstant.DEFBIGDECIMAL;
		}
		this.singlefeerate = singlefeerate;
	}
	public String getCoverFiAmt() {
		return coverFiAmt;
	}
	public void setCoverFiAmt(String coverFiAmt) {
		this.coverFiAmt = coverFiAmt;
	}
	public String getSinglefeetotal() {
		return singlefeetotal;
	}
	public void setSinglefeetotal(String singlefeetotal) {
		if(StringUtils.isEmpty(singlefeetotal)){
			singlefeetotal=PaCostSettlementConstant.DEFBIGDECIMAL;
		}
		this.singlefeetotal = singlefeetotal;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaCostSettlementDto [accountMonth=");
		builder.append(accountMonth);
		builder.append(", accountTotal=");
		builder.append(accountTotal);
		builder.append(", basePrice=");
		builder.append(basePrice);
		builder.append(", accountNum=");
		builder.append(accountNum);
		builder.append(", basePriceTotal=");
		builder.append(basePriceTotal);
		builder.append(", floatingMonth=");
		builder.append(floatingMonth);
		builder.append(", assetPoolPa=");
		builder.append(assetPoolPa);
		builder.append(", assetPoolInsur=");
		builder.append(assetPoolInsur);
		builder.append(", assetPoolOdds=");
		builder.append(assetPoolOdds);
		builder.append(", floatingPrice=");
		builder.append(floatingPrice);
		builder.append(", floatingAge=");
		builder.append(floatingAge);
		builder.append(", floatingTotal=");
		builder.append(floatingTotal);
		builder.append(", singlefeedate=");
		builder.append(singlefeedate);
		builder.append(", singlefeerate=");
		builder.append(singlefeerate);
		builder.append(", coverFiAmt=");
		builder.append(coverFiAmt);
		builder.append(", singlefeetotal=");
		builder.append(singlefeetotal);
		builder.append("]");
		return builder.toString();
	}
}
