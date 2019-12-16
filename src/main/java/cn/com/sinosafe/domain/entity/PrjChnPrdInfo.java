package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PrjChnPrdInfo {
    private String pkId;

    private String prdPk;

    private String prdCode;

    private String prdName;

    private String relNo;

    private String relType;

    private BigDecimal rateMin;

    private BigDecimal rateMax;

    private BigDecimal minCostRate;

    private BigDecimal maxCostRate;

    private BigDecimal insRatio;

    private String contStartDate;

    private String contEndDate;

    private BigDecimal preventRate;

    private String settleScope;

    private String settleType;

    private String settleRule;

    private BigDecimal amountMax;

    private Integer term;

    private String repaymentMode;

    private BigDecimal lmtTotalAmt;

    private String isUserd;

    private String applyBrId;

    private String applyBrName;

    private String valueCtr;

    private String isUpdate;

    private BigDecimal fixCostRate;

    private BigDecimal fixRate;

    private Integer minTerm;

    private Integer maxTerm;

    private BigDecimal repayPercent;

    private String cusType;

    private String departType;

    private String overdueType;

    private String isSettle;

    private BigDecimal thresholdA;

    private BigDecimal thresholdB;

    private BigDecimal costStartPoint;

    private BigDecimal costRate;

    private BigDecimal floatCostRate;

    private String signNo;

    private String speAgreeStarDate;

    private String speAgreeEndDate;

    private String speAgree;

    private String lastUpdId;

    private String lastUpdBrId;

    private String lastUpdDate;

    private String inputId;

    private String inputBrId;

    private String inputDate;

    private String claimCond;

    private Short claimCondDay;

    private Short settlePeriod;

    private String bankName;

    private String accountName;

    private String accountNo;

    private BigDecimal totalOverdueAmt;

    private Short disLoanendMonth;

    private Short compensateTimes;

    private Short overdueTimes;

    private Short dueDay;

    private String newPrdCode;

    private String isCredit;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public String getPrdPk() {
        return prdPk;
    }

    public void setPrdPk(String prdPk) {
        this.prdPk = prdPk == null ? null : prdPk.trim();
    }

    public String getPrdCode() {
        return prdCode;
    }

    public void setPrdCode(String prdCode) {
        this.prdCode = prdCode == null ? null : prdCode.trim();
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName == null ? null : prdName.trim();
    }

    public String getRelNo() {
        return relNo;
    }

    public void setRelNo(String relNo) {
        this.relNo = relNo == null ? null : relNo.trim();
    }

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType == null ? null : relType.trim();
    }

    public BigDecimal getRateMin() {
        return rateMin;
    }

    public void setRateMin(BigDecimal rateMin) {
        this.rateMin = rateMin;
    }

    public BigDecimal getRateMax() {
        return rateMax;
    }

    public void setRateMax(BigDecimal rateMax) {
        this.rateMax = rateMax;
    }

    public BigDecimal getMinCostRate() {
        return minCostRate;
    }

    public void setMinCostRate(BigDecimal minCostRate) {
        this.minCostRate = minCostRate;
    }

    public BigDecimal getMaxCostRate() {
        return maxCostRate;
    }

    public void setMaxCostRate(BigDecimal maxCostRate) {
        this.maxCostRate = maxCostRate;
    }

    public BigDecimal getInsRatio() {
        return insRatio;
    }

    public void setInsRatio(BigDecimal insRatio) {
        this.insRatio = insRatio;
    }

    public String getContStartDate() {
        return contStartDate;
    }

    public void setContStartDate(String contStartDate) {
        this.contStartDate = contStartDate == null ? null : contStartDate.trim();
    }

    public String getContEndDate() {
        return contEndDate;
    }

    public void setContEndDate(String contEndDate) {
        this.contEndDate = contEndDate == null ? null : contEndDate.trim();
    }

    public BigDecimal getPreventRate() {
        return preventRate;
    }

    public void setPreventRate(BigDecimal preventRate) {
        this.preventRate = preventRate;
    }

    public String getSettleScope() {
        return settleScope;
    }

    public void setSettleScope(String settleScope) {
        this.settleScope = settleScope == null ? null : settleScope.trim();
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType == null ? null : settleType.trim();
    }

    public String getSettleRule() {
        return settleRule;
    }

    public void setSettleRule(String settleRule) {
        this.settleRule = settleRule == null ? null : settleRule.trim();
    }

    public BigDecimal getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(BigDecimal amountMax) {
        this.amountMax = amountMax;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getRepaymentMode() {
        return repaymentMode;
    }

    public void setRepaymentMode(String repaymentMode) {
        this.repaymentMode = repaymentMode == null ? null : repaymentMode.trim();
    }

    public BigDecimal getLmtTotalAmt() {
        return lmtTotalAmt;
    }

    public void setLmtTotalAmt(BigDecimal lmtTotalAmt) {
        this.lmtTotalAmt = lmtTotalAmt;
    }

    public String getIsUserd() {
        return isUserd;
    }

    public void setIsUserd(String isUserd) {
        this.isUserd = isUserd == null ? null : isUserd.trim();
    }

    public String getApplyBrId() {
        return applyBrId;
    }

    public void setApplyBrId(String applyBrId) {
        this.applyBrId = applyBrId == null ? null : applyBrId.trim();
    }

    public String getApplyBrName() {
        return applyBrName;
    }

    public void setApplyBrName(String applyBrName) {
        this.applyBrName = applyBrName == null ? null : applyBrName.trim();
    }

    public String getValueCtr() {
        return valueCtr;
    }

    public void setValueCtr(String valueCtr) {
        this.valueCtr = valueCtr == null ? null : valueCtr.trim();
    }

    public String getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(String isUpdate) {
        this.isUpdate = isUpdate == null ? null : isUpdate.trim();
    }

    public BigDecimal getFixCostRate() {
        return fixCostRate;
    }

    public void setFixCostRate(BigDecimal fixCostRate) {
        this.fixCostRate = fixCostRate;
    }

    public BigDecimal getFixRate() {
        return fixRate;
    }

    public void setFixRate(BigDecimal fixRate) {
        this.fixRate = fixRate;
    }

    public Integer getMinTerm() {
        return minTerm;
    }

    public void setMinTerm(Integer minTerm) {
        this.minTerm = minTerm;
    }

    public Integer getMaxTerm() {
        return maxTerm;
    }

    public void setMaxTerm(Integer maxTerm) {
        this.maxTerm = maxTerm;
    }

    public BigDecimal getRepayPercent() {
        return repayPercent;
    }

    public void setRepayPercent(BigDecimal repayPercent) {
        this.repayPercent = repayPercent;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType == null ? null : cusType.trim();
    }

    public String getDepartType() {
        return departType;
    }

    public void setDepartType(String departType) {
        this.departType = departType == null ? null : departType.trim();
    }

    public String getOverdueType() {
        return overdueType;
    }

    public void setOverdueType(String overdueType) {
        this.overdueType = overdueType == null ? null : overdueType.trim();
    }

    public String getIsSettle() {
        return isSettle;
    }

    public void setIsSettle(String isSettle) {
        this.isSettle = isSettle == null ? null : isSettle.trim();
    }

    public BigDecimal getThresholdA() {
        return thresholdA;
    }

    public void setThresholdA(BigDecimal thresholdA) {
        this.thresholdA = thresholdA;
    }

    public BigDecimal getThresholdB() {
        return thresholdB;
    }

    public void setThresholdB(BigDecimal thresholdB) {
        this.thresholdB = thresholdB;
    }

    public BigDecimal getCostStartPoint() {
        return costStartPoint;
    }

    public void setCostStartPoint(BigDecimal costStartPoint) {
        this.costStartPoint = costStartPoint;
    }

    public BigDecimal getCostRate() {
        return costRate;
    }

    public void setCostRate(BigDecimal costRate) {
        this.costRate = costRate;
    }

    public BigDecimal getFloatCostRate() {
        return floatCostRate;
    }

    public void setFloatCostRate(BigDecimal floatCostRate) {
        this.floatCostRate = floatCostRate;
    }

    public String getSignNo() {
        return signNo;
    }

    public void setSignNo(String signNo) {
        this.signNo = signNo == null ? null : signNo.trim();
    }

    public String getSpeAgreeStarDate() {
        return speAgreeStarDate;
    }

    public void setSpeAgreeStarDate(String speAgreeStarDate) {
        this.speAgreeStarDate = speAgreeStarDate == null ? null : speAgreeStarDate.trim();
    }

    public String getSpeAgreeEndDate() {
        return speAgreeEndDate;
    }

    public void setSpeAgreeEndDate(String speAgreeEndDate) {
        this.speAgreeEndDate = speAgreeEndDate == null ? null : speAgreeEndDate.trim();
    }

    public String getSpeAgree() {
        return speAgree;
    }

    public void setSpeAgree(String speAgree) {
        this.speAgree = speAgree == null ? null : speAgree.trim();
    }

    public String getLastUpdId() {
        return lastUpdId;
    }

    public void setLastUpdId(String lastUpdId) {
        this.lastUpdId = lastUpdId == null ? null : lastUpdId.trim();
    }

    public String getLastUpdBrId() {
        return lastUpdBrId;
    }

    public void setLastUpdBrId(String lastUpdBrId) {
        this.lastUpdBrId = lastUpdBrId == null ? null : lastUpdBrId.trim();
    }

    public String getLastUpdDate() {
        return lastUpdDate;
    }

    public void setLastUpdDate(String lastUpdDate) {
        this.lastUpdDate = lastUpdDate == null ? null : lastUpdDate.trim();
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId == null ? null : inputId.trim();
    }

    public String getInputBrId() {
        return inputBrId;
    }

    public void setInputBrId(String inputBrId) {
        this.inputBrId = inputBrId == null ? null : inputBrId.trim();
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate == null ? null : inputDate.trim();
    }

    public String getClaimCond() {
        return claimCond;
    }

    public void setClaimCond(String claimCond) {
        this.claimCond = claimCond == null ? null : claimCond.trim();
    }

    public Short getClaimCondDay() {
        return claimCondDay;
    }

    public void setClaimCondDay(Short claimCondDay) {
        this.claimCondDay = claimCondDay;
    }

    public Short getSettlePeriod() {
        return settlePeriod;
    }

    public void setSettlePeriod(Short settlePeriod) {
        this.settlePeriod = settlePeriod;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public BigDecimal getTotalOverdueAmt() {
        return totalOverdueAmt;
    }

    public void setTotalOverdueAmt(BigDecimal totalOverdueAmt) {
        this.totalOverdueAmt = totalOverdueAmt;
    }

    public Short getDisLoanendMonth() {
        return disLoanendMonth;
    }

    public void setDisLoanendMonth(Short disLoanendMonth) {
        this.disLoanendMonth = disLoanendMonth;
    }

    public Short getCompensateTimes() {
        return compensateTimes;
    }

    public void setCompensateTimes(Short compensateTimes) {
        this.compensateTimes = compensateTimes;
    }

    public Short getOverdueTimes() {
        return overdueTimes;
    }

    public void setOverdueTimes(Short overdueTimes) {
        this.overdueTimes = overdueTimes;
    }

    public Short getDueDay() {
        return dueDay;
    }

    public void setDueDay(Short dueDay) {
        this.dueDay = dueDay;
    }

    public String getNewPrdCode() {
        return newPrdCode;
    }

    public void setNewPrdCode(String newPrdCode) {
        this.newPrdCode = newPrdCode == null ? null : newPrdCode.trim();
    }

    public String getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(String isCredit) {
        this.isCredit = isCredit == null ? null : isCredit.trim();
    }
}