package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

/**
 * RULE_RESULT_INFO
 * @author 
 */
public class RuleResultInfo {
    /**
     * 主键
     */
    private String pkId;

    /**
     * 业务流水号
     */
    private String serno;

    /**
     * 返回码
     */
    private String rtnCode;

    /**
     * 贷款金额
     */
    private BigDecimal loanAmt;

    /**
     * 交易时间
     */
    private String operTime;

    /**
     * 标志
     */
    private String flag;

    /**
     * 是否返回客户
     */
    private String isBlackCus;

    /**
     * 规则真实返回码
     */
    private String ruleRtnCode;

    /**
     * 期限
     */
    private BigDecimal term;

    /**
     * 费率
     */
    private BigDecimal rate;

    /**
     * 是否代扣保费  0-代扣  1-在线缴费 
     */
    private String isPayFee;

    /**
     * 资金方ID
     */
    private String copNo;

    /**
     * 批准还款方式
     */
    private String approveRepaymode;

    /**
     * 批准期限类型
     */
    private String approveTermTimeType;

    /**
     * 费率(‰)
     */
    private BigDecimal costRate;

    /**
     * 利率(‰)
     */
    private BigDecimal grossRate;

    private String cusLevel;

    /**
     * 流程等级
     */
    private String flowLevel;
    
    /**
     * 错误信息即命中信息
     */
    private String errMsg;

    /**
     * 详细信息
     */
    private String detailMsg;

    /**
     * 错误信息
     */
    private String personMsg;

    /**
     * 返回结论
     */
    private String blackReason;

    /**
     * 审批完成返回的json数据
     */
    private String passMsg;

    /**
     * 合作方名称集合
     */
    private String copNameList;

    /**
     * mode集合
     */
    private String repaymentModeList;

    /**
     * 返回json数据
     */
    private String ruleJson;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno;
    }

    public String getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getIsBlackCus() {
        return isBlackCus;
    }

    public void setIsBlackCus(String isBlackCus) {
        this.isBlackCus = isBlackCus;
    }

    public String getRuleRtnCode() {
        return ruleRtnCode;
    }

    public void setRuleRtnCode(String ruleRtnCode) {
        this.ruleRtnCode = ruleRtnCode;
    }

    public BigDecimal getTerm() {
        return term;
    }

    public void setTerm(BigDecimal term) {
        this.term = term;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getIsPayFee() {
        return isPayFee;
    }

    public void setIsPayFee(String isPayFee) {
        this.isPayFee = isPayFee;
    }

    public String getCopNo() {
        return copNo;
    }

    public void setCopNo(String copNo) {
        this.copNo = copNo;
    }

    public String getApproveRepaymode() {
        return approveRepaymode;
    }

    public void setApproveRepaymode(String approveRepaymode) {
        this.approveRepaymode = approveRepaymode;
    }

    public String getApproveTermTimeType() {
        return approveTermTimeType;
    }

    public void setApproveTermTimeType(String approveTermTimeType) {
        this.approveTermTimeType = approveTermTimeType;
    }

    public BigDecimal getCostRate() {
        return costRate;
    }

    public void setCostRate(BigDecimal costRate) {
        this.costRate = costRate;
    }

    public BigDecimal getGrossRate() {
        return grossRate;
    }

    public void setGrossRate(BigDecimal grossRate) {
        this.grossRate = grossRate;
    }

    public String getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(String cusLevel) {
        this.cusLevel = cusLevel;
    }

    public String getFlowLevel() {
        return flowLevel;
    }

    public void setFlowLevel(String flowLevel) {
        this.flowLevel = flowLevel;
    }
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public String getPersonMsg() {
        return personMsg;
    }

    public void setPersonMsg(String personMsg) {
        this.personMsg = personMsg;
    }

    public String getBlackReason() {
        return blackReason;
    }

    public void setBlackReason(String blackReason) {
        this.blackReason = blackReason;
    }

    public String getPassMsg() {
        return passMsg;
    }

    public void setPassMsg(String passMsg) {
        this.passMsg = passMsg;
    }

    public String getCopNameList() {
        return copNameList;
    }

    public void setCopNameList(String copNameList) {
        this.copNameList = copNameList;
    }

    public String getRepaymentModeList() {
        return repaymentModeList;
    }

    public void setRepaymentModeList(String repaymentModeList) {
        this.repaymentModeList = repaymentModeList;
    }

    public String getRuleJson() {
        return ruleJson;
    }

    public void setRuleJson(String ruleJson) {
        this.ruleJson = ruleJson;
    }
}