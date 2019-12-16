package cn.com.sinosafe.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * PRD_BASICINFO
 * @author 
 */
public class PrdBasicinfo implements Serializable {
    /**
     * 产品主键
     */
    private String prdPk;

    /**
     * 产品类别
     */
    private String prdType;

    /**
     * 用户自定义类型
     */
    private String prdUserdfType;

    /**
     * 是否循环
     */
    private String prdSeries;

    /**
     * 产品系列
     */
    private String useType;

    /**
     * 产品编号
     */
    private String prdCode;

    /**
     * 产品名称
     */
    private String prdName;

    /**
     * 产品版本
     */
    private String prdVersion;

    /**
     * 产品经理
     */
    private String prdManager;

    /**
     * 是否有效
     */
    private String availableInd;

    /**
     * 截止日期
     */
    private String deadline;

    /**
     * 可选担保方式
     */
    private String guarantyOpt;

    /**
     * 可选币种
     */
    private String currencyOpt;

    /**
     * 期限单位
     */
    private String termUnit;

    /**
     * 最小期限
     */
    private Integer termMin;

    /**
     * 最大期限
     */
    private Integer termMax;

    /**
     * 产品单笔申请金额最大限制
     */
    private BigDecimal amountMax;

    /**
     * 风险拦截方式
     */
    private String preventRiskId;

    /**
     * 申请资料清单
     */
    private String appDocList;

    /**
     * 申请流程
     */
    private String appWorkflowId;

    /**
     * 申请流程分配关系
     */
    private String appWfAssType;

    /**
     * 出账方式
     */
    private String ddType;

    /**
     * 放款流程
     */
    private String ddWorkflowId;

    /**
     * 放款流程分配关系
     */
    private String ddWfAssType;

    /**
     * 选还款方式
     */
    private String repayModeOpt;

    /**
     * 余额不足时扣款方式
     */
    private String delayDeductType;

    /**
     * 最小提前还款金额(元)
     */
    private BigDecimal advanceMin;

    /**
     * 最小提前还款期限
     */
    private BigDecimal advanceTermMin;

    /**
     * 贷款定价模板
     */
    private String rulePrice;

    /**
     * 利息计算方式
     */
    private String intCalType;

    /**
     * 利率调整方式
     */
    private String rateAdjustType;

    /**
     * 最小利率浮动比例
     */
    private BigDecimal rateFloatMin;

    /**
     * 最大利率浮动比例
     */
    private BigDecimal rateFloatMax;

    /**
     * 逾期宽限期(天)
     */
    private Integer daysOfGrace;

    /**
     * 最小逾期罚息金额(元)
     */
    private BigDecimal fineOfOdMin;

    /**
     * 是否计复利
     */
    private String cpdIntInd;

    /**
     * 最小罚息比例
     */
    private BigDecimal fineRateMin;

    /**
     * 最大罚息比例
     */
    private BigDecimal fineRateMax;

    /**
     * 是否贴息
     */
    private String subsidizedInd;

    /**
     * 贴息方式
     */
    private String subType;

    /**
     * 贴息入账方式
     */
    private String subEaType;

    /**
     * 贴息利率
     */
    private BigDecimal subIntRate;

    /**
     * 固定贴息金额(元)
     */
    private BigDecimal subAmtFixed;

    /**
     * 系列产品最高申请金额
     */
    private BigDecimal subAmtMax;

    /**
     * 申请对应表单
     */
    private String appForm;

    /**
     * 合同对应表单
     */
    private String contrForm;

    /**
     * 准贷证对应表单
     */
    private String eCertForm;

    /**
     * APP_FORM_CTTRL
     */
    private String appFormCttrl;

    /**
     * 最小利率
     */
    private BigDecimal rateMin;

    /**
     * 最大利率
     */
    private BigDecimal rateMax;

    /**
     * 固定利率列表
     */
    private String rateFixList;

    /**
     * 是否使用固定利率
     */
    private String rateFixInd;

    /**
     * 单笔贷款金额下限
     */
    private BigDecimal amountMin;

    /**
     * PVP_INNER_TYPE
     */
    private String pvpInnerType;

    /**
     * 最小费率
     */
    private BigDecimal minCostRate;

    /**
     * 最大费率
     */
    private BigDecimal maxCostRate;

    /**
     * 保险品种编号
     */
    private String insCode;

    /**
     * 保险品种名称
     */
    private String insName;

    /**
     * 保费系数
     */
    private BigDecimal insRatio;

    /**
     * 业务模式
     */
    private String bizMode;

    /**
     * 还本比例
     */
    private BigDecimal repayPercent;

    /**
     * 业务类别
     */
    private String prdAttrib;

    /**
     * 快速理赔最小值
     */
    private BigDecimal quitSettleMin;

    /**
     * 快速理赔最大值
     */
    private BigDecimal quitSettleMax;

    /**
     * 滞纳金比例
     */
    private BigDecimal lateFeeRate;

    /**
     * 倒签天数
     */
    private Short signDays;

    /**
     * 特别约定
     */
    private String cAppnt;

    /**
     * 核心对应产品代码
     */
    private String corePrdCode;

    /**
     * 新产品8位代码
     */
    private String newPrdCode;

    /**
     * 见费出单标志(0  否,1  是)
     */
    private String cFeeFlag;

    /**
     * 是否预审 (0  否,1  是)
     */
    private String isPretrial;

    private String isAuto;

    /**
     * 授信执节时效
     */
    private String creditTimeout;

    /**
     * 是否分期
     */
    private String isTerm;

    private String imgType;

    /**
     * 是否平台产品  1- 是  0-否
     */
    private String isPlatform;

    /**
     * 开票类型
     */
    private String invoiceType;

    /**
     * 是否在线签署投保单：1、是  2、否
     */
    private String onlineStatus;

    /**
     * 面签时效
     */
    private BigDecimal interviewTimeout;

    /**
     * 补充资料时效时效
     */
    private BigDecimal supplementTimeout;

    /**
     * 在线签署时效时效
     */
    private BigDecimal signTimeout;

    /**
     * 缴费时效时效
     */
    private BigDecimal payTimeout;

    /**
     * 保险起止期计算规则
     */
    private String insurancesend;

    private static final long serialVersionUID = 1L;

    public String getPrdPk() {
        return prdPk;
    }

    public void setPrdPk(String prdPk) {
        this.prdPk = prdPk;
    }

    public String getPrdType() {
        return prdType;
    }

    public void setPrdType(String prdType) {
        this.prdType = prdType;
    }

    public String getPrdUserdfType() {
        return prdUserdfType;
    }

    public void setPrdUserdfType(String prdUserdfType) {
        this.prdUserdfType = prdUserdfType;
    }

    public String getPrdSeries() {
        return prdSeries;
    }

    public void setPrdSeries(String prdSeries) {
        this.prdSeries = prdSeries;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getPrdCode() {
        return prdCode;
    }

    public void setPrdCode(String prdCode) {
        this.prdCode = prdCode;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public String getPrdVersion() {
        return prdVersion;
    }

    public void setPrdVersion(String prdVersion) {
        this.prdVersion = prdVersion;
    }

    public String getPrdManager() {
        return prdManager;
    }

    public void setPrdManager(String prdManager) {
        this.prdManager = prdManager;
    }

    public String getAvailableInd() {
        return availableInd;
    }

    public void setAvailableInd(String availableInd) {
        this.availableInd = availableInd;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getGuarantyOpt() {
        return guarantyOpt;
    }

    public void setGuarantyOpt(String guarantyOpt) {
        this.guarantyOpt = guarantyOpt;
    }

    public String getCurrencyOpt() {
        return currencyOpt;
    }

    public void setCurrencyOpt(String currencyOpt) {
        this.currencyOpt = currencyOpt;
    }

    public String getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(String termUnit) {
        this.termUnit = termUnit;
    }

    public Integer getTermMin() {
        return termMin;
    }

    public void setTermMin(Integer termMin) {
        this.termMin = termMin;
    }

    public Integer getTermMax() {
        return termMax;
    }

    public void setTermMax(Integer termMax) {
        this.termMax = termMax;
    }

    public BigDecimal getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(BigDecimal amountMax) {
        this.amountMax = amountMax;
    }

    public String getPreventRiskId() {
        return preventRiskId;
    }

    public void setPreventRiskId(String preventRiskId) {
        this.preventRiskId = preventRiskId;
    }

    public String getAppDocList() {
        return appDocList;
    }

    public void setAppDocList(String appDocList) {
        this.appDocList = appDocList;
    }

    public String getAppWorkflowId() {
        return appWorkflowId;
    }

    public void setAppWorkflowId(String appWorkflowId) {
        this.appWorkflowId = appWorkflowId;
    }

    public String getAppWfAssType() {
        return appWfAssType;
    }

    public void setAppWfAssType(String appWfAssType) {
        this.appWfAssType = appWfAssType;
    }

    public String getDdType() {
        return ddType;
    }

    public void setDdType(String ddType) {
        this.ddType = ddType;
    }

    public String getDdWorkflowId() {
        return ddWorkflowId;
    }

    public void setDdWorkflowId(String ddWorkflowId) {
        this.ddWorkflowId = ddWorkflowId;
    }

    public String getDdWfAssType() {
        return ddWfAssType;
    }

    public void setDdWfAssType(String ddWfAssType) {
        this.ddWfAssType = ddWfAssType;
    }

    public String getRepayModeOpt() {
        return repayModeOpt;
    }

    public void setRepayModeOpt(String repayModeOpt) {
        this.repayModeOpt = repayModeOpt;
    }

    public String getDelayDeductType() {
        return delayDeductType;
    }

    public void setDelayDeductType(String delayDeductType) {
        this.delayDeductType = delayDeductType;
    }

    public BigDecimal getAdvanceMin() {
        return advanceMin;
    }

    public void setAdvanceMin(BigDecimal advanceMin) {
        this.advanceMin = advanceMin;
    }

    public BigDecimal getAdvanceTermMin() {
        return advanceTermMin;
    }

    public void setAdvanceTermMin(BigDecimal advanceTermMin) {
        this.advanceTermMin = advanceTermMin;
    }

    public String getRulePrice() {
        return rulePrice;
    }

    public void setRulePrice(String rulePrice) {
        this.rulePrice = rulePrice;
    }

    public String getIntCalType() {
        return intCalType;
    }

    public void setIntCalType(String intCalType) {
        this.intCalType = intCalType;
    }

    public String getRateAdjustType() {
        return rateAdjustType;
    }

    public void setRateAdjustType(String rateAdjustType) {
        this.rateAdjustType = rateAdjustType;
    }

    public BigDecimal getRateFloatMin() {
        return rateFloatMin;
    }

    public void setRateFloatMin(BigDecimal rateFloatMin) {
        this.rateFloatMin = rateFloatMin;
    }

    public BigDecimal getRateFloatMax() {
        return rateFloatMax;
    }

    public void setRateFloatMax(BigDecimal rateFloatMax) {
        this.rateFloatMax = rateFloatMax;
    }

    public Integer getDaysOfGrace() {
        return daysOfGrace;
    }

    public void setDaysOfGrace(Integer daysOfGrace) {
        this.daysOfGrace = daysOfGrace;
    }

    public BigDecimal getFineOfOdMin() {
        return fineOfOdMin;
    }

    public void setFineOfOdMin(BigDecimal fineOfOdMin) {
        this.fineOfOdMin = fineOfOdMin;
    }

    public String getCpdIntInd() {
        return cpdIntInd;
    }

    public void setCpdIntInd(String cpdIntInd) {
        this.cpdIntInd = cpdIntInd;
    }

    public BigDecimal getFineRateMin() {
        return fineRateMin;
    }

    public void setFineRateMin(BigDecimal fineRateMin) {
        this.fineRateMin = fineRateMin;
    }

    public BigDecimal getFineRateMax() {
        return fineRateMax;
    }

    public void setFineRateMax(BigDecimal fineRateMax) {
        this.fineRateMax = fineRateMax;
    }

    public String getSubsidizedInd() {
        return subsidizedInd;
    }

    public void setSubsidizedInd(String subsidizedInd) {
        this.subsidizedInd = subsidizedInd;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSubEaType() {
        return subEaType;
    }

    public void setSubEaType(String subEaType) {
        this.subEaType = subEaType;
    }

    public BigDecimal getSubIntRate() {
        return subIntRate;
    }

    public void setSubIntRate(BigDecimal subIntRate) {
        this.subIntRate = subIntRate;
    }

    public BigDecimal getSubAmtFixed() {
        return subAmtFixed;
    }

    public void setSubAmtFixed(BigDecimal subAmtFixed) {
        this.subAmtFixed = subAmtFixed;
    }

    public BigDecimal getSubAmtMax() {
        return subAmtMax;
    }

    public void setSubAmtMax(BigDecimal subAmtMax) {
        this.subAmtMax = subAmtMax;
    }

    public String getAppForm() {
        return appForm;
    }

    public void setAppForm(String appForm) {
        this.appForm = appForm;
    }

    public String getContrForm() {
        return contrForm;
    }

    public void setContrForm(String contrForm) {
        this.contrForm = contrForm;
    }

    public String geteCertForm() {
        return eCertForm;
    }

    public void seteCertForm(String eCertForm) {
        this.eCertForm = eCertForm;
    }

    public String getAppFormCttrl() {
        return appFormCttrl;
    }

    public void setAppFormCttrl(String appFormCttrl) {
        this.appFormCttrl = appFormCttrl;
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

    public String getRateFixList() {
        return rateFixList;
    }

    public void setRateFixList(String rateFixList) {
        this.rateFixList = rateFixList;
    }

    public String getRateFixInd() {
        return rateFixInd;
    }

    public void setRateFixInd(String rateFixInd) {
        this.rateFixInd = rateFixInd;
    }

    public BigDecimal getAmountMin() {
        return amountMin;
    }

    public void setAmountMin(BigDecimal amountMin) {
        this.amountMin = amountMin;
    }

    public String getPvpInnerType() {
        return pvpInnerType;
    }

    public void setPvpInnerType(String pvpInnerType) {
        this.pvpInnerType = pvpInnerType;
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

    public String getInsCode() {
        return insCode;
    }

    public void setInsCode(String insCode) {
        this.insCode = insCode;
    }

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public BigDecimal getInsRatio() {
        return insRatio;
    }

    public void setInsRatio(BigDecimal insRatio) {
        this.insRatio = insRatio;
    }

    public String getBizMode() {
        return bizMode;
    }

    public void setBizMode(String bizMode) {
        this.bizMode = bizMode;
    }

    public BigDecimal getRepayPercent() {
        return repayPercent;
    }

    public void setRepayPercent(BigDecimal repayPercent) {
        this.repayPercent = repayPercent;
    }

    public String getPrdAttrib() {
        return prdAttrib;
    }

    public void setPrdAttrib(String prdAttrib) {
        this.prdAttrib = prdAttrib;
    }

    public BigDecimal getQuitSettleMin() {
        return quitSettleMin;
    }

    public void setQuitSettleMin(BigDecimal quitSettleMin) {
        this.quitSettleMin = quitSettleMin;
    }

    public BigDecimal getQuitSettleMax() {
        return quitSettleMax;
    }

    public void setQuitSettleMax(BigDecimal quitSettleMax) {
        this.quitSettleMax = quitSettleMax;
    }

    public BigDecimal getLateFeeRate() {
        return lateFeeRate;
    }

    public void setLateFeeRate(BigDecimal lateFeeRate) {
        this.lateFeeRate = lateFeeRate;
    }

    public Short getSignDays() {
        return signDays;
    }

    public void setSignDays(Short signDays) {
        this.signDays = signDays;
    }

    public String getcAppnt() {
        return cAppnt;
    }

    public void setcAppnt(String cAppnt) {
        this.cAppnt = cAppnt;
    }

    public String getCorePrdCode() {
        return corePrdCode;
    }

    public void setCorePrdCode(String corePrdCode) {
        this.corePrdCode = corePrdCode;
    }

    public String getNewPrdCode() {
        return newPrdCode;
    }

    public void setNewPrdCode(String newPrdCode) {
        this.newPrdCode = newPrdCode;
    }

    public String getcFeeFlag() {
        return cFeeFlag;
    }

    public void setcFeeFlag(String cFeeFlag) {
        this.cFeeFlag = cFeeFlag;
    }

    public String getIsPretrial() {
        return isPretrial;
    }

    public void setIsPretrial(String isPretrial) {
        this.isPretrial = isPretrial;
    }

    public String getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(String isAuto) {
        this.isAuto = isAuto;
    }

    public String getCreditTimeout() {
        return creditTimeout;
    }

    public void setCreditTimeout(String creditTimeout) {
        this.creditTimeout = creditTimeout;
    }

    public String getIsTerm() {
        return isTerm;
    }

    public void setIsTerm(String isTerm) {
        this.isTerm = isTerm;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public String getIsPlatform() {
        return isPlatform;
    }

    public void setIsPlatform(String isPlatform) {
        this.isPlatform = isPlatform;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public BigDecimal getInterviewTimeout() {
        return interviewTimeout;
    }

    public void setInterviewTimeout(BigDecimal interviewTimeout) {
        this.interviewTimeout = interviewTimeout;
    }

    public BigDecimal getSupplementTimeout() {
        return supplementTimeout;
    }

    public void setSupplementTimeout(BigDecimal supplementTimeout) {
        this.supplementTimeout = supplementTimeout;
    }

    public BigDecimal getSignTimeout() {
        return signTimeout;
    }

    public void setSignTimeout(BigDecimal signTimeout) {
        this.signTimeout = signTimeout;
    }

    public BigDecimal getPayTimeout() {
        return payTimeout;
    }

    public void setPayTimeout(BigDecimal payTimeout) {
        this.payTimeout = payTimeout;
    }

    public String getInsurancesend() {
        return insurancesend;
    }

    public void setInsurancesend(String insurancesend) {
        this.insurancesend = insurancesend;
    }
}