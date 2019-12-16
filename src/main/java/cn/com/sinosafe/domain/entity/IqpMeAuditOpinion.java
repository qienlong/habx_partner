package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class IqpMeAuditOpinion extends IqpMeAuditOpinionKey {
    /**
     * 业务流水号	界面隐藏
     */
    private String serno;

    /**
     * 客户经理建议
     */
    private String managerAdvice;

    /**
     * 客户经理其他建议
     */
    private String managerAdviceOther;

    /**
     * 放款金额
     */
    private BigDecimal amount;

    /**
     * 期限
     */
    private String term;

    /**
     * 审批人编号
     */
    private String approveId;

    /**
     * 审批人姓名
     */
    private String approveName;

    /**
     * 审批意见，STD_ZB_APPR_RESULT
     */
    private String approveOpinion;

    /**
     * 审批意见其他
     */
    private String approveOpinionDetails;

    /**
     * 批准金额
     */
    private BigDecimal approveAmount;

    /**
     * 批准期限（月）
     */
    private String approveTerm;

    /**
     * 批准利率
     */
    private BigDecimal approveRate;

    /**
     * 批准还款方式，STD_ZB_REPAY_MODE
     */
    private String approveRepaymode;

    /**
     * 贷款用途
     */
    private String loanUseType;

    /**
     * 贷款用途描述
     */
    private String useDec;

    /**
     * 组合审批决议，HQSPJL
     */
    private String groupOpinion;

    /**
     * 组合审批决议其他
     */
    private String groupOpinionDetails;

    /**
     * 放款条件
     */
    private String approveCondition;

    /**
     * 监控条件
     */
    private String monitorConditon;

    /**
     * 补充调查
     */
    private String supCondition;

    /**
     * 拒绝原因
     */
    private String refuseReason;

    /**
     * 其他事项
     */
    private String otherItem;

    /**
     * 最终审批结论
     */
    private String approveResult;

    /**
     * 还款方式
     */
    private String repaymode;

    /**
     * 执行利率
     */
    private BigDecimal rate;

    /**
     * 支付方式STD_ZB_PAY_TYPE
     */
    private String payType;

    /**
     * 批准支付方式STD_ZB_PAY_TYPE
     */
    private String approvePayType;

    /**
     * 申请还款日
     */
    private String appDueDay;

    /**
     * 批准还款日
     */
    private String approveDueDay;

    /**
     * 批准利率类型
     */
    private String approveIrType;

    /**
     * 批准利率浮动比
     */
    private BigDecimal approveFloatingRate;

    /**
     * 批准结息周期
     */
    private String approveInterestAccMode;

    /**
     * 批准基准利率
     */
    private BigDecimal approveRulingIr;

    /**
     * 批准还款周期
     */
    private String approveFrequency;

    /**
     * null
     */
    private String rejectedReason;

    /**
     * null
     */
    private String secondApproveId;

    /**
     * null
     */
    private BigDecimal secondApproveAmount;

    /**
     * null
     */
    private BigDecimal secondApproveRate;

    /**
     * null
     */
    private String callBackReason;

    /**
     * null
     */
    private String secondApproveTerm;

    /**
     * 保险金额
     */
    private BigDecimal insurAmount;

    /**
     * 批准日期(决议书日期)
     */
    private String approveDate;

    /**
     * 批准还款方式说明
     */
    private String approveRepaymodeDesc;

    /**
     * 拒绝原因代码
     */
    private String refuseCode;

    /**
     * 合作方
     */
    private String copNo;

    /**
     * 商圈
     */
    private String channelNo;

    /**
     * 协议
     */
    private String prdPk;

    /**
     * 费率(‰)
     */
    private BigDecimal costRate;

    /**
     * 业务模式为个人抵押增信、企业抵押增信时,决议书页面显示承保贷款金额
     */
    private BigDecimal acceptLoanAmount;

    /**
     * 是否允许修改费率
     */
    private String isUpdate;

    /**
     * 批准还本比例
     */
    private BigDecimal approveRepayPercent;

    /**
     * 是否承保罚息
     */
    private String penaltyInterest;

    /**
     * 批准期限（天）
     */
    private String approveTermday;

    /**
     * 批准期限类型
     */
    private String approveTermTimeType;

    /**
     * null
     */
    private BigDecimal underwritingRate;

    /**
     * null
     */
    private String telOpinion;

    /**
     * 是否分期/1-期缴 2-趸缴
     */
    private String singlePrem;

    /**
     * 首期费率
     */
    private Short firstPremRate;

    /**
     * 每期费率
     */
    private Short everyPremRate;

    /**
     * 拒绝类型ID
     */
    private String refuseTypeId;

    /**
     * 拒绝类型
     */
    private String refuseType;

    /**
     * null
     */
    private String cusLevel;

    /**
     * 是否电核（STD_ZX_YES_NO）
     */
    private String isTelApprove;

    /**
     * 审批操作 时间
     */
    private String approveOperaDate;

    /**
     * 流程等级 1、2、3级
     */
    private String flowLevel;

    /**
     * null
     */
    private String approveRemart;

    /**
     * null
     */
    private String approveNodeid;

    /**
     * null
     */
    private BigDecimal creditAmount;

    /**
     * null
     */
    private BigDecimal loanAmount;

    /**
     * 业务流水号	界面隐藏
     * @return SERNO 业务流水号	界面隐藏
     */
    public String getSerno() {
        return serno;
    }

    /**
     * 业务流水号	界面隐藏
     * @param serno 业务流水号	界面隐藏
     */
    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    /**
     * 客户经理建议
     * @return MANAGER_ADVICE 客户经理建议
     */
    public String getManagerAdvice() {
        return managerAdvice;
    }

    /**
     * 客户经理建议
     * @param managerAdvice 客户经理建议
     */
    public void setManagerAdvice(String managerAdvice) {
        this.managerAdvice = managerAdvice == null ? null : managerAdvice.trim();
    }

    /**
     * 客户经理其他建议
     * @return MANAGER_ADVICE_OTHER 客户经理其他建议
     */
    public String getManagerAdviceOther() {
        return managerAdviceOther;
    }

    /**
     * 客户经理其他建议
     * @param managerAdviceOther 客户经理其他建议
     */
    public void setManagerAdviceOther(String managerAdviceOther) {
        this.managerAdviceOther = managerAdviceOther == null ? null : managerAdviceOther.trim();
    }

    /**
     * 放款金额
     * @return AMOUNT 放款金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 放款金额
     * @param amount 放款金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 期限
     * @return TERM 期限
     */
    public String getTerm() {
        return term;
    }

    /**
     * 期限
     * @param term 期限
     */
    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    /**
     * 审批人编号
     * @return APPROVE_ID 审批人编号
     */
    public String getApproveId() {
        return approveId;
    }

    /**
     * 审批人编号
     * @param approveId 审批人编号
     */
    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    /**
     * 审批人姓名
     * @return APPROVE_NAME 审批人姓名
     */
    public String getApproveName() {
        return approveName;
    }

    /**
     * 审批人姓名
     * @param approveName 审批人姓名
     */
    public void setApproveName(String approveName) {
        this.approveName = approveName == null ? null : approveName.trim();
    }

    /**
     * 审批意见，STD_ZB_APPR_RESULT
     * @return APPROVE_OPINION 审批意见，STD_ZB_APPR_RESULT
     */
    public String getApproveOpinion() {
        return approveOpinion;
    }

    /**
     * 审批意见，STD_ZB_APPR_RESULT
     * @param approveOpinion 审批意见，STD_ZB_APPR_RESULT
     */
    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion == null ? null : approveOpinion.trim();
    }

    /**
     * 审批意见其他
     * @return APPROVE_OPINION_DETAILS 审批意见其他
     */
    public String getApproveOpinionDetails() {
        return approveOpinionDetails;
    }

    /**
     * 审批意见其他
     * @param approveOpinionDetails 审批意见其他
     */
    public void setApproveOpinionDetails(String approveOpinionDetails) {
        this.approveOpinionDetails = approveOpinionDetails == null ? null : approveOpinionDetails.trim();
    }

    /**
     * 批准金额
     * @return APPROVE_AMOUNT 批准金额
     */
    public BigDecimal getApproveAmount() {
        return approveAmount;
    }

    /**
     * 批准金额
     * @param approveAmount 批准金额
     */
    public void setApproveAmount(BigDecimal approveAmount) {
        this.approveAmount = approveAmount;
    }

    /**
     * 批准期限（月）
     * @return APPROVE_TERM 批准期限（月）
     */
    public String getApproveTerm() {
        return approveTerm;
    }

    /**
     * 批准期限（月）
     * @param approveTerm 批准期限（月）
     */
    public void setApproveTerm(String approveTerm) {
        this.approveTerm = approveTerm == null ? null : approveTerm.trim();
    }

    /**
     * 批准利率
     * @return APPROVE_RATE 批准利率
     */
    public BigDecimal getApproveRate() {
        return approveRate;
    }

    /**
     * 批准利率
     * @param approveRate 批准利率
     */
    public void setApproveRate(BigDecimal approveRate) {
        this.approveRate = approveRate;
    }

    /**
     * 批准还款方式，STD_ZB_REPAY_MODE
     * @return APPROVE_REPAYMODE 批准还款方式，STD_ZB_REPAY_MODE
     */
    public String getApproveRepaymode() {
        return approveRepaymode;
    }

    /**
     * 批准还款方式，STD_ZB_REPAY_MODE
     * @param approveRepaymode 批准还款方式，STD_ZB_REPAY_MODE
     */
    public void setApproveRepaymode(String approveRepaymode) {
        this.approveRepaymode = approveRepaymode == null ? null : approveRepaymode.trim();
    }

    /**
     * 贷款用途
     * @return LOAN_USE_TYPE 贷款用途
     */
    public String getLoanUseType() {
        return loanUseType;
    }

    /**
     * 贷款用途
     * @param loanUseType 贷款用途
     */
    public void setLoanUseType(String loanUseType) {
        this.loanUseType = loanUseType == null ? null : loanUseType.trim();
    }

    /**
     * 贷款用途描述
     * @return USE_DEC 贷款用途描述
     */
    public String getUseDec() {
        return useDec;
    }

    /**
     * 贷款用途描述
     * @param useDec 贷款用途描述
     */
    public void setUseDec(String useDec) {
        this.useDec = useDec == null ? null : useDec.trim();
    }

    /**
     * 组合审批决议，HQSPJL
     * @return GROUP_OPINION 组合审批决议，HQSPJL
     */
    public String getGroupOpinion() {
        return groupOpinion;
    }

    /**
     * 组合审批决议，HQSPJL
     * @param groupOpinion 组合审批决议，HQSPJL
     */
    public void setGroupOpinion(String groupOpinion) {
        this.groupOpinion = groupOpinion == null ? null : groupOpinion.trim();
    }

    /**
     * 组合审批决议其他
     * @return GROUP_OPINION_DETAILS 组合审批决议其他
     */
    public String getGroupOpinionDetails() {
        return groupOpinionDetails;
    }

    /**
     * 组合审批决议其他
     * @param groupOpinionDetails 组合审批决议其他
     */
    public void setGroupOpinionDetails(String groupOpinionDetails) {
        this.groupOpinionDetails = groupOpinionDetails == null ? null : groupOpinionDetails.trim();
    }

    /**
     * 放款条件
     * @return APPROVE_CONDITION 放款条件
     */
    public String getApproveCondition() {
        return approveCondition;
    }

    /**
     * 放款条件
     * @param approveCondition 放款条件
     */
    public void setApproveCondition(String approveCondition) {
        this.approveCondition = approveCondition == null ? null : approveCondition.trim();
    }

    /**
     * 监控条件
     * @return MONITOR_CONDITON 监控条件
     */
    public String getMonitorConditon() {
        return monitorConditon;
    }

    /**
     * 监控条件
     * @param monitorConditon 监控条件
     */
    public void setMonitorConditon(String monitorConditon) {
        this.monitorConditon = monitorConditon == null ? null : monitorConditon.trim();
    }

    /**
     * 补充调查
     * @return SUP_CONDITION 补充调查
     */
    public String getSupCondition() {
        return supCondition;
    }

    /**
     * 补充调查
     * @param supCondition 补充调查
     */
    public void setSupCondition(String supCondition) {
        this.supCondition = supCondition == null ? null : supCondition.trim();
    }

    /**
     * 拒绝原因
     * @return REFUSE_REASON 拒绝原因
     */
    public String getRefuseReason() {
        return refuseReason;
    }

    /**
     * 拒绝原因
     * @param refuseReason 拒绝原因
     */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
    }

    /**
     * 其他事项
     * @return OTHER_ITEM 其他事项
     */
    public String getOtherItem() {
        return otherItem;
    }

    /**
     * 其他事项
     * @param otherItem 其他事项
     */
    public void setOtherItem(String otherItem) {
        this.otherItem = otherItem == null ? null : otherItem.trim();
    }

    /**
     * 最终审批结论
     * @return APPROVE_RESULT 最终审批结论
     */
    public String getApproveResult() {
        return approveResult;
    }

    /**
     * 最终审批结论
     * @param approveResult 最终审批结论
     */
    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult == null ? null : approveResult.trim();
    }

    /**
     * 还款方式
     * @return REPAYMODE 还款方式
     */
    public String getRepaymode() {
        return repaymode;
    }

    /**
     * 还款方式
     * @param repaymode 还款方式
     */
    public void setRepaymode(String repaymode) {
        this.repaymode = repaymode == null ? null : repaymode.trim();
    }

    /**
     * 执行利率
     * @return RATE 执行利率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * 执行利率
     * @param rate 执行利率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * 支付方式STD_ZB_PAY_TYPE
     * @return PAY_TYPE 支付方式STD_ZB_PAY_TYPE
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 支付方式STD_ZB_PAY_TYPE
     * @param payType 支付方式STD_ZB_PAY_TYPE
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * 批准支付方式STD_ZB_PAY_TYPE
     * @return APPROVE_PAY_TYPE 批准支付方式STD_ZB_PAY_TYPE
     */
    public String getApprovePayType() {
        return approvePayType;
    }

    /**
     * 批准支付方式STD_ZB_PAY_TYPE
     * @param approvePayType 批准支付方式STD_ZB_PAY_TYPE
     */
    public void setApprovePayType(String approvePayType) {
        this.approvePayType = approvePayType == null ? null : approvePayType.trim();
    }

    /**
     * 申请还款日
     * @return APP_DUE_DAY 申请还款日
     */
    public String getAppDueDay() {
        return appDueDay;
    }

    /**
     * 申请还款日
     * @param appDueDay 申请还款日
     */
    public void setAppDueDay(String appDueDay) {
        this.appDueDay = appDueDay == null ? null : appDueDay.trim();
    }

    /**
     * 批准还款日
     * @return APPROVE_DUE_DAY 批准还款日
     */
    public String getApproveDueDay() {
        return approveDueDay;
    }

    /**
     * 批准还款日
     * @param approveDueDay 批准还款日
     */
    public void setApproveDueDay(String approveDueDay) {
        this.approveDueDay = approveDueDay == null ? null : approveDueDay.trim();
    }

    /**
     * 批准利率类型
     * @return APPROVE_IR_TYPE 批准利率类型
     */
    public String getApproveIrType() {
        return approveIrType;
    }

    /**
     * 批准利率类型
     * @param approveIrType 批准利率类型
     */
    public void setApproveIrType(String approveIrType) {
        this.approveIrType = approveIrType == null ? null : approveIrType.trim();
    }

    /**
     * 批准利率浮动比
     * @return APPROVE_FLOATING_RATE 批准利率浮动比
     */
    public BigDecimal getApproveFloatingRate() {
        return approveFloatingRate;
    }

    /**
     * 批准利率浮动比
     * @param approveFloatingRate 批准利率浮动比
     */
    public void setApproveFloatingRate(BigDecimal approveFloatingRate) {
        this.approveFloatingRate = approveFloatingRate;
    }

    /**
     * 批准结息周期
     * @return APPROVE_INTEREST_ACC_MODE 批准结息周期
     */
    public String getApproveInterestAccMode() {
        return approveInterestAccMode;
    }

    /**
     * 批准结息周期
     * @param approveInterestAccMode 批准结息周期
     */
    public void setApproveInterestAccMode(String approveInterestAccMode) {
        this.approveInterestAccMode = approveInterestAccMode == null ? null : approveInterestAccMode.trim();
    }

    /**
     * 批准基准利率
     * @return APPROVE_RULING_IR 批准基准利率
     */
    public BigDecimal getApproveRulingIr() {
        return approveRulingIr;
    }

    /**
     * 批准基准利率
     * @param approveRulingIr 批准基准利率
     */
    public void setApproveRulingIr(BigDecimal approveRulingIr) {
        this.approveRulingIr = approveRulingIr;
    }

    /**
     * 批准还款周期
     * @return APPROVE_FREQUENCY 批准还款周期
     */
    public String getApproveFrequency() {
        return approveFrequency;
    }

    /**
     * 批准还款周期
     * @param approveFrequency 批准还款周期
     */
    public void setApproveFrequency(String approveFrequency) {
        this.approveFrequency = approveFrequency == null ? null : approveFrequency.trim();
    }

    /**
     * null
     * @return REJECTED_REASON null
     */
    public String getRejectedReason() {
        return rejectedReason;
    }

    /**
     * null
     * @param rejectedReason null
     */
    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason == null ? null : rejectedReason.trim();
    }

    /**
     * null
     * @return SECOND_APPROVE_ID null
     */
    public String getSecondApproveId() {
        return secondApproveId;
    }

    /**
     * null
     * @param secondApproveId null
     */
    public void setSecondApproveId(String secondApproveId) {
        this.secondApproveId = secondApproveId == null ? null : secondApproveId.trim();
    }

    /**
     * null
     * @return SECOND_APPROVE_AMOUNT null
     */
    public BigDecimal getSecondApproveAmount() {
        return secondApproveAmount;
    }

    /**
     * null
     * @param secondApproveAmount null
     */
    public void setSecondApproveAmount(BigDecimal secondApproveAmount) {
        this.secondApproveAmount = secondApproveAmount;
    }

    /**
     * null
     * @return SECOND_APPROVE_RATE null
     */
    public BigDecimal getSecondApproveRate() {
        return secondApproveRate;
    }

    /**
     * null
     * @param secondApproveRate null
     */
    public void setSecondApproveRate(BigDecimal secondApproveRate) {
        this.secondApproveRate = secondApproveRate;
    }

    /**
     * null
     * @return CALL_BACK_REASON null
     */
    public String getCallBackReason() {
        return callBackReason;
    }

    /**
     * null
     * @param callBackReason null
     */
    public void setCallBackReason(String callBackReason) {
        this.callBackReason = callBackReason == null ? null : callBackReason.trim();
    }

    /**
     * null
     * @return SECOND_APPROVE_TERM null
     */
    public String getSecondApproveTerm() {
        return secondApproveTerm;
    }

    /**
     * null
     * @param secondApproveTerm null
     */
    public void setSecondApproveTerm(String secondApproveTerm) {
        this.secondApproveTerm = secondApproveTerm == null ? null : secondApproveTerm.trim();
    }

    /**
     * 保险金额
     * @return INSUR_AMOUNT 保险金额
     */
    public BigDecimal getInsurAmount() {
        return insurAmount;
    }

    /**
     * 保险金额
     * @param insurAmount 保险金额
     */
    public void setInsurAmount(BigDecimal insurAmount) {
        this.insurAmount = insurAmount;
    }

    /**
     * 批准日期(决议书日期)
     * @return APPROVE_DATE 批准日期(决议书日期)
     */
    public String getApproveDate() {
        return approveDate;
    }

    /**
     * 批准日期(决议书日期)
     * @param approveDate 批准日期(决议书日期)
     */
    public void setApproveDate(String approveDate) {
        this.approveDate = approveDate == null ? null : approveDate.trim();
    }

    /**
     * 批准还款方式说明
     * @return APPROVE_REPAYMODE_DESC 批准还款方式说明
     */
    public String getApproveRepaymodeDesc() {
        return approveRepaymodeDesc;
    }

    /**
     * 批准还款方式说明
     * @param approveRepaymodeDesc 批准还款方式说明
     */
    public void setApproveRepaymodeDesc(String approveRepaymodeDesc) {
        this.approveRepaymodeDesc = approveRepaymodeDesc == null ? null : approveRepaymodeDesc.trim();
    }

    /**
     * 拒绝原因代码
     * @return REFUSE_CODE 拒绝原因代码
     */
    public String getRefuseCode() {
        return refuseCode;
    }

    /**
     * 拒绝原因代码
     * @param refuseCode 拒绝原因代码
     */
    public void setRefuseCode(String refuseCode) {
        this.refuseCode = refuseCode == null ? null : refuseCode.trim();
    }

    /**
     * 合作方
     * @return COP_NO 合作方
     */
    public String getCopNo() {
        return copNo;
    }

    /**
     * 合作方
     * @param copNo 合作方
     */
    public void setCopNo(String copNo) {
        this.copNo = copNo == null ? null : copNo.trim();
    }

    /**
     * 商圈
     * @return CHANNEL_NO 商圈
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * 商圈
     * @param channelNo 商圈
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
    }

    /**
     * 协议
     * @return PRD_PK 协议
     */
    public String getPrdPk() {
        return prdPk;
    }

    /**
     * 协议
     * @param prdPk 协议
     */
    public void setPrdPk(String prdPk) {
        this.prdPk = prdPk == null ? null : prdPk.trim();
    }

    /**
     * 费率(‰)
     * @return COST_RATE 费率(‰)
     */
    public BigDecimal getCostRate() {
        return costRate;
    }

    /**
     * 费率(‰)
     * @param costRate 费率(‰)
     */
    public void setCostRate(BigDecimal costRate) {
        this.costRate = costRate;
    }

    /**
     * 业务模式为个人抵押增信、企业抵押增信时,决议书页面显示承保贷款金额
     * @return ACCEPT_LOAN_AMOUNT 业务模式为个人抵押增信、企业抵押增信时,决议书页面显示承保贷款金额
     */
    public BigDecimal getAcceptLoanAmount() {
        return acceptLoanAmount;
    }

    /**
     * 业务模式为个人抵押增信、企业抵押增信时,决议书页面显示承保贷款金额
     * @param acceptLoanAmount 业务模式为个人抵押增信、企业抵押增信时,决议书页面显示承保贷款金额
     */
    public void setAcceptLoanAmount(BigDecimal acceptLoanAmount) {
        this.acceptLoanAmount = acceptLoanAmount;
    }

    /**
     * 是否允许修改费率
     * @return IS_UPDATE 是否允许修改费率
     */
    public String getIsUpdate() {
        return isUpdate;
    }

    /**
     * 是否允许修改费率
     * @param isUpdate 是否允许修改费率
     */
    public void setIsUpdate(String isUpdate) {
        this.isUpdate = isUpdate == null ? null : isUpdate.trim();
    }

    /**
     * 批准还本比例
     * @return APPROVE_REPAY_PERCENT 批准还本比例
     */
    public BigDecimal getApproveRepayPercent() {
        return approveRepayPercent;
    }

    /**
     * 批准还本比例
     * @param approveRepayPercent 批准还本比例
     */
    public void setApproveRepayPercent(BigDecimal approveRepayPercent) {
        this.approveRepayPercent = approveRepayPercent;
    }

    /**
     * 是否承保罚息
     * @return PENALTY_INTEREST 是否承保罚息
     */
    public String getPenaltyInterest() {
        return penaltyInterest;
    }

    /**
     * 是否承保罚息
     * @param penaltyInterest 是否承保罚息
     */
    public void setPenaltyInterest(String penaltyInterest) {
        this.penaltyInterest = penaltyInterest == null ? null : penaltyInterest.trim();
    }

    /**
     * 批准期限（天）
     * @return APPROVE_TERMDAY 批准期限（天）
     */
    public String getApproveTermday() {
        return approveTermday;
    }

    /**
     * 批准期限（天）
     * @param approveTermday 批准期限（天）
     */
    public void setApproveTermday(String approveTermday) {
        this.approveTermday = approveTermday == null ? null : approveTermday.trim();
    }

    /**
     * 批准期限类型
     * @return APPROVE_TERM_TIME_TYPE 批准期限类型
     */
    public String getApproveTermTimeType() {
        return approveTermTimeType;
    }

    /**
     * 批准期限类型
     * @param approveTermTimeType 批准期限类型
     */
    public void setApproveTermTimeType(String approveTermTimeType) {
        this.approveTermTimeType = approveTermTimeType == null ? null : approveTermTimeType.trim();
    }

    /**
     * null
     * @return UNDERWRITING_RATE null
     */
    public BigDecimal getUnderwritingRate() {
        return underwritingRate;
    }

    /**
     * null
     * @param underwritingRate null
     */
    public void setUnderwritingRate(BigDecimal underwritingRate) {
        this.underwritingRate = underwritingRate;
    }

    /**
     * null
     * @return TEL_OPINION null
     */
    public String getTelOpinion() {
        return telOpinion;
    }

    /**
     * null
     * @param telOpinion null
     */
    public void setTelOpinion(String telOpinion) {
        this.telOpinion = telOpinion == null ? null : telOpinion.trim();
    }

    /**
     * 是否分期/1-期缴 2-趸缴
     * @return SINGLE_PREM 是否分期/1-期缴 2-趸缴
     */
    public String getSinglePrem() {
        return singlePrem;
    }

    /**
     * 是否分期/1-期缴 2-趸缴
     * @param singlePrem 是否分期/1-期缴 2-趸缴
     */
    public void setSinglePrem(String singlePrem) {
        this.singlePrem = singlePrem == null ? null : singlePrem.trim();
    }

    /**
     * 首期费率
     * @return FIRST_PREM_RATE 首期费率
     */
    public Short getFirstPremRate() {
        return firstPremRate;
    }

    /**
     * 首期费率
     * @param firstPremRate 首期费率
     */
    public void setFirstPremRate(Short firstPremRate) {
        this.firstPremRate = firstPremRate;
    }

    /**
     * 每期费率
     * @return EVERY_PREM_RATE 每期费率
     */
    public Short getEveryPremRate() {
        return everyPremRate;
    }

    /**
     * 每期费率
     * @param everyPremRate 每期费率
     */
    public void setEveryPremRate(Short everyPremRate) {
        this.everyPremRate = everyPremRate;
    }

    /**
     * 拒绝类型ID
     * @return REFUSE_TYPE_ID 拒绝类型ID
     */
    public String getRefuseTypeId() {
        return refuseTypeId;
    }

    /**
     * 拒绝类型ID
     * @param refuseTypeId 拒绝类型ID
     */
    public void setRefuseTypeId(String refuseTypeId) {
        this.refuseTypeId = refuseTypeId == null ? null : refuseTypeId.trim();
    }

    /**
     * 拒绝类型
     * @return REFUSE_TYPE 拒绝类型
     */
    public String getRefuseType() {
        return refuseType;
    }

    /**
     * 拒绝类型
     * @param refuseType 拒绝类型
     */
    public void setRefuseType(String refuseType) {
        this.refuseType = refuseType == null ? null : refuseType.trim();
    }

    /**
     * null
     * @return CUS_LEVEL null
     */
    public String getCusLevel() {
        return cusLevel;
    }

    /**
     * null
     * @param cusLevel null
     */
    public void setCusLevel(String cusLevel) {
        this.cusLevel = cusLevel == null ? null : cusLevel.trim();
    }

    /**
     * 是否电核（STD_ZX_YES_NO）
     * @return IS_TEL_APPROVE 是否电核（STD_ZX_YES_NO）
     */
    public String getIsTelApprove() {
        return isTelApprove;
    }

    /**
     * 是否电核（STD_ZX_YES_NO）
     * @param isTelApprove 是否电核（STD_ZX_YES_NO）
     */
    public void setIsTelApprove(String isTelApprove) {
        this.isTelApprove = isTelApprove == null ? null : isTelApprove.trim();
    }

    /**
     * 审批操作 时间
     * @return APPROVE_OPERA_DATE 审批操作 时间
     */
    public String getApproveOperaDate() {
        return approveOperaDate;
    }

    /**
     * 审批操作 时间
     * @param approveOperaDate 审批操作 时间
     */
    public void setApproveOperaDate(String approveOperaDate) {
        this.approveOperaDate = approveOperaDate == null ? null : approveOperaDate.trim();
    }

    /**
     * 流程等级 1、2、3级
     * @return FLOW_LEVEL 流程等级 1、2、3级
     */
    public String getFlowLevel() {
        return flowLevel;
    }

    /**
     * 流程等级 1、2、3级
     * @param flowLevel 流程等级 1、2、3级
     */
    public void setFlowLevel(String flowLevel) {
        this.flowLevel = flowLevel == null ? null : flowLevel.trim();
    }

    /**
     * null
     * @return APPROVE_REMART null
     */
    public String getApproveRemart() {
        return approveRemart;
    }

    /**
     * null
     * @param approveRemart null
     */
    public void setApproveRemart(String approveRemart) {
        this.approveRemart = approveRemart == null ? null : approveRemart.trim();
    }

    /**
     * null
     * @return APPROVE_NODEID null
     */
    public String getApproveNodeid() {
        return approveNodeid;
    }

    /**
     * null
     * @param approveNodeid null
     */
    public void setApproveNodeid(String approveNodeid) {
        this.approveNodeid = approveNodeid == null ? null : approveNodeid.trim();
    }

    /**
     * null
     * @return CREDIT_AMOUNT null
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * null
     * @param creditAmount null
     */
    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * null
     * @return LOAN_AMOUNT null
     */
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    /**
     * null
     * @param loanAmount null
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }
}