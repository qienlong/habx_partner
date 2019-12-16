/**
 * projectName: haxb_partner
 * fileName: PrjCopTrustPlan.java
 * packageName: cn.com.sinosafe.domain.entity
 * date: 2019-09-02 11:09
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: PrjCopTrustPlan
 * @packageName: cn.com.sinosafe.domain.entity
 * @description:  信托计划明细表
 * @data: 2019-09-02 11:09
 **/
public class PrjCopTrustPlan {
	private String pkId;

    private String copNo;

    private String planName;

    private String term;

    private String grossRate;

    private BigDecimal totalAmt;

    private String editBalance;

    private BigDecimal balance;

    private String startDate;

    private String endDate;

    private String operUserId;

    private String operDate;

    private String operTime;

    private String memo;

    private String isHis;

    private String firstEndDate;

    private String operType;

    private String amtSources;

    private String funderId;

    private String settleAtBankName;

    private String settleBankName;

    private String settleAcountNo;

    private String insuCompany;

    private String settleAcountName;

    private String settleBankCityCode;

    private String settleBankCity;

    private String settleAtBankCode;

    private String settleBankCode;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public String getCopNo() {
        return copNo;
    }

    public void setCopNo(String copNo) {
        this.copNo = copNo == null ? null : copNo.trim();
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public String getGrossRate() {
        return grossRate;
    }

    public void setGrossRate(String grossRate) {
        this.grossRate = grossRate == null ? null : grossRate.trim();
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getEditBalance() {
        return editBalance;
    }

    public void setEditBalance(String editBalance) {
        this.editBalance = editBalance == null ? null : editBalance.trim();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId == null ? null : operUserId.trim();
    }

    public String getOperDate() {
        return operDate;
    }

    public void setOperDate(String operDate) {
        this.operDate = operDate == null ? null : operDate.trim();
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime == null ? null : operTime.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getIsHis() {
        return isHis;
    }

    public void setIsHis(String isHis) {
        this.isHis = isHis == null ? null : isHis.trim();
    }

    public String getFirstEndDate() {
        return firstEndDate;
    }

    public void setFirstEndDate(String firstEndDate) {
        this.firstEndDate = firstEndDate == null ? null : firstEndDate.trim();
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    public String getAmtSources() {
        return amtSources;
    }

    public void setAmtSources(String amtSources) {
        this.amtSources = amtSources == null ? null : amtSources.trim();
    }

    public String getFunderId() {
        return funderId;
    }

    public void setFunderId(String funderId) {
        this.funderId = funderId == null ? null : funderId.trim();
    }

    public String getSettleAtBankName() {
        return settleAtBankName;
    }

    public void setSettleAtBankName(String settleAtBankName) {
        this.settleAtBankName = settleAtBankName == null ? null : settleAtBankName.trim();
    }

    public String getSettleBankName() {
        return settleBankName;
    }

    public void setSettleBankName(String settleBankName) {
        this.settleBankName = settleBankName == null ? null : settleBankName.trim();
    }

    public String getSettleAcountNo() {
        return settleAcountNo;
    }

    public void setSettleAcountNo(String settleAcountNo) {
        this.settleAcountNo = settleAcountNo == null ? null : settleAcountNo.trim();
    }

    public String getInsuCompany() {
        return insuCompany;
    }

    public void setInsuCompany(String insuCompany) {
        this.insuCompany = insuCompany == null ? null : insuCompany.trim();
    }

    public String getSettleAcountName() {
        return settleAcountName;
    }

    public void setSettleAcountName(String settleAcountName) {
        this.settleAcountName = settleAcountName == null ? null : settleAcountName.trim();
    }

    public String getSettleBankCityCode() {
        return settleBankCityCode;
    }

    public void setSettleBankCityCode(String settleBankCityCode) {
        this.settleBankCityCode = settleBankCityCode == null ? null : settleBankCityCode.trim();
    }

    public String getSettleBankCity() {
        return settleBankCity;
    }

    public void setSettleBankCity(String settleBankCity) {
        this.settleBankCity = settleBankCity == null ? null : settleBankCity.trim();
    }

    public String getSettleAtBankCode() {
        return settleAtBankCode;
    }

    public void setSettleAtBankCode(String settleAtBankCode) {
        this.settleAtBankCode = settleAtBankCode == null ? null : settleAtBankCode.trim();
    }

    public String getSettleBankCode() {
        return settleBankCode;
    }

    public void setSettleBankCode(String settleBankCode) {
        this.settleBankCode = settleBankCode == null ? null : settleBankCode.trim();
    }
}
