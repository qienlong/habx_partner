package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class AccMtdPlan extends AccMtdPlanKey {
    /**
     * 还款日期
     */
    private String psDueDt;

    /**
     * 本金
     */
    private BigDecimal psPrcpAmt;

    /**
     * 利息
     */
    private BigDecimal psNormIntAmt;

    /**
     * 期供
     */
    private BigDecimal psInstmAmt;

    /**
     * 利率
     */
    private BigDecimal psIntRate;

    /**
     * 调整类型
     */
    private String fxTyp;

    /**
     * 实际还款日期
     */
    private String psRealDt;

    /**
     * 实际还款本金
     */
    private BigDecimal psRealPrcpAmt;

    /**
     * 实际还款利息
     */
    private BigDecimal psRealIntAmt;

    /**
     * 状态(STD_ZB_REPAYPLAN_ST)
     */
    private String repayFlag;

    /**
     * 应还罚息
     */
    private BigDecimal psOdIntAmt;

    /**
     * 应还复利
     */
    private BigDecimal psCommOdInt;

    /**
     * 已还罚息
     */
    private BigDecimal setlOdIncTaken;

    /**
     * 已还复利
     */
    private BigDecimal setlCommOdInt;

    /**
     * 逾期起始日期
     */
    private String overdueDate;

    /**
     * 登记时间
     */
    private String inputTime;

    /**
     * 理赔日期
     */
    private String claimInputDate;

    /**
     * 可理赔金额
     */
    private BigDecimal claimedAmount;

    /**
     * 更新方式
     */
    private String updateWay;

    /**
     * 录入时间
     */
    private String inputDate;

    /**
     * 录入人
     */
    private String inputId;

    /**
     * 录入机构
     */
    private String inputBrId;

    /**
     * 最后更新时间
     */
    private String updateDate;

    /**
     * 最后更新人
     */
    private String updateId;

    /**
     * 最后更新机构
     */
    private String updateBrId;

    /**
     * 冲账成功日期
     */
    private String strikeSucDate;

    /**
     * 冲账登记人
     */
    private String strikeOper;

    /**
     * 摘要
     */
    private String abstract_;

    /**
     * 已决本金
     */
    private BigDecimal paidCapital;

    /**
     * 已决利息
     */
    private BigDecimal paidIntAmt;

    /**
     * 已决罚息
     */
    private BigDecimal paidIncTaken;

    /**
     * 已决复利
     */
    private BigDecimal paidCommOdInt;

    /**
     * 已决预估罚息
     */
    private BigDecimal paidEstimIncTaken;

    /**
     * 计算滞纳金日期
     */
    private String calcuLatefeeDate;

    /**
     * 滞纳金
     */
    private BigDecimal lateFee;

    /**
     * null
     */
    private String remark;

    /**
     * null
     */
    private BigDecimal overDays;

    /**
     * null
     */
    private BigDecimal overAmount;

    /**
     * 还款日期
     * @return PS_DUE_DT 还款日期
     */
    public String getPsDueDt() {
        return psDueDt;
    }

    /**
     * 还款日期
     * @param psDueDt 还款日期
     */
    public void setPsDueDt(String psDueDt) {
        this.psDueDt = psDueDt == null ? null : psDueDt.trim();
    }

    /**
     * 本金
     * @return PS_PRCP_AMT 本金
     */
    public BigDecimal getPsPrcpAmt() {
        return psPrcpAmt;
    }

    /**
     * 本金
     * @param psPrcpAmt 本金
     */
    public void setPsPrcpAmt(BigDecimal psPrcpAmt) {
        this.psPrcpAmt = psPrcpAmt;
    }

    /**
     * 利息
     * @return PS_NORM_INT_AMT 利息
     */
    public BigDecimal getPsNormIntAmt() {
        return psNormIntAmt;
    }

    /**
     * 利息
     * @param psNormIntAmt 利息
     */
    public void setPsNormIntAmt(BigDecimal psNormIntAmt) {
        this.psNormIntAmt = psNormIntAmt;
    }

    /**
     * 期供
     * @return PS_INSTM_AMT 期供
     */
    public BigDecimal getPsInstmAmt() {
        return psInstmAmt;
    }

    /**
     * 期供
     * @param psInstmAmt 期供
     */
    public void setPsInstmAmt(BigDecimal psInstmAmt) {
        this.psInstmAmt = psInstmAmt;
    }

    /**
     * 利率
     * @return PS_INT_RATE 利率
     */
    public BigDecimal getPsIntRate() {
        return psIntRate;
    }

    /**
     * 利率
     * @param psIntRate 利率
     */
    public void setPsIntRate(BigDecimal psIntRate) {
        this.psIntRate = psIntRate;
    }

    /**
     * 调整类型
     * @return FX_TYP 调整类型
     */
    public String getFxTyp() {
        return fxTyp;
    }

    /**
     * 调整类型
     * @param fxTyp 调整类型
     */
    public void setFxTyp(String fxTyp) {
        this.fxTyp = fxTyp == null ? null : fxTyp.trim();
    }

    /**
     * 实际还款日期
     * @return PS_REAL_DT 实际还款日期
     */
    public String getPsRealDt() {
        return psRealDt;
    }

    /**
     * 实际还款日期
     * @param psRealDt 实际还款日期
     */
    public void setPsRealDt(String psRealDt) {
        this.psRealDt = psRealDt == null ? null : psRealDt.trim();
    }

    /**
     * 实际还款本金
     * @return PS_REAL_PRCP_AMT 实际还款本金
     */
    public BigDecimal getPsRealPrcpAmt() {
        return psRealPrcpAmt;
    }

    /**
     * 实际还款本金
     * @param psRealPrcpAmt 实际还款本金
     */
    public void setPsRealPrcpAmt(BigDecimal psRealPrcpAmt) {
        this.psRealPrcpAmt = psRealPrcpAmt;
    }

    /**
     * 实际还款利息
     * @return PS_REAL_INT_AMT 实际还款利息
     */
    public BigDecimal getPsRealIntAmt() {
        return psRealIntAmt;
    }

    /**
     * 实际还款利息
     * @param psRealIntAmt 实际还款利息
     */
    public void setPsRealIntAmt(BigDecimal psRealIntAmt) {
        this.psRealIntAmt = psRealIntAmt;
    }

    /**
     * 状态(STD_ZB_REPAYPLAN_ST)
     * @return REPAY_FLAG 状态(STD_ZB_REPAYPLAN_ST)
     */
    public String getRepayFlag() {
        return repayFlag;
    }

    /**
     * 状态(STD_ZB_REPAYPLAN_ST)
     * @param repayFlag 状态(STD_ZB_REPAYPLAN_ST)
     */
    public void setRepayFlag(String repayFlag) {
        this.repayFlag = repayFlag == null ? null : repayFlag.trim();
    }

    /**
     * 应还罚息
     * @return PS_OD_INT_AMT 应还罚息
     */
    public BigDecimal getPsOdIntAmt() {
        return psOdIntAmt;
    }

    /**
     * 应还罚息
     * @param psOdIntAmt 应还罚息
     */
    public void setPsOdIntAmt(BigDecimal psOdIntAmt) {
        this.psOdIntAmt = psOdIntAmt;
    }

    /**
     * 应还复利
     * @return PS_COMM_OD_INT 应还复利
     */
    public BigDecimal getPsCommOdInt() {
        return psCommOdInt;
    }

    /**
     * 应还复利
     * @param psCommOdInt 应还复利
     */
    public void setPsCommOdInt(BigDecimal psCommOdInt) {
        this.psCommOdInt = psCommOdInt;
    }

    /**
     * 已还罚息
     * @return SETL_OD_INC_TAKEN 已还罚息
     */
    public BigDecimal getSetlOdIncTaken() {
        return setlOdIncTaken;
    }

    /**
     * 已还罚息
     * @param setlOdIncTaken 已还罚息
     */
    public void setSetlOdIncTaken(BigDecimal setlOdIncTaken) {
        this.setlOdIncTaken = setlOdIncTaken;
    }

    /**
     * 已还复利
     * @return SETL_COMM_OD_INT 已还复利
     */
    public BigDecimal getSetlCommOdInt() {
        return setlCommOdInt;
    }

    /**
     * 已还复利
     * @param setlCommOdInt 已还复利
     */
    public void setSetlCommOdInt(BigDecimal setlCommOdInt) {
        this.setlCommOdInt = setlCommOdInt;
    }

    /**
     * 逾期起始日期
     * @return OVERDUE_DATE 逾期起始日期
     */
    public String getOverdueDate() {
        return overdueDate;
    }

    /**
     * 逾期起始日期
     * @param overdueDate 逾期起始日期
     */
    public void setOverdueDate(String overdueDate) {
        this.overdueDate = overdueDate == null ? null : overdueDate.trim();
    }

    /**
     * 登记时间
     * @return INPUT_TIME 登记时间
     */
    public String getInputTime() {
        return inputTime;
    }

    /**
     * 登记时间
     * @param inputTime 登记时间
     */
    public void setInputTime(String inputTime) {
        this.inputTime = inputTime == null ? null : inputTime.trim();
    }

    /**
     * 理赔日期
     * @return CLAIM_INPUT_DATE 理赔日期
     */
    public String getClaimInputDate() {
        return claimInputDate;
    }

    /**
     * 理赔日期
     * @param claimInputDate 理赔日期
     */
    public void setClaimInputDate(String claimInputDate) {
        this.claimInputDate = claimInputDate == null ? null : claimInputDate.trim();
    }

    /**
     * 可理赔金额
     * @return CLAIMED_AMOUNT 可理赔金额
     */
    public BigDecimal getClaimedAmount() {
        return claimedAmount;
    }

    /**
     * 可理赔金额
     * @param claimedAmount 可理赔金额
     */
    public void setClaimedAmount(BigDecimal claimedAmount) {
        this.claimedAmount = claimedAmount;
    }

    /**
     * 更新方式
     * @return UPDATE_WAY 更新方式
     */
    public String getUpdateWay() {
        return updateWay;
    }

    /**
     * 更新方式
     * @param updateWay 更新方式
     */
    public void setUpdateWay(String updateWay) {
        this.updateWay = updateWay == null ? null : updateWay.trim();
    }

    /**
     * 录入时间
     * @return INPUT_DATE 录入时间
     */
    public String getInputDate() {
        return inputDate;
    }

    /**
     * 录入时间
     * @param inputDate 录入时间
     */
    public void setInputDate(String inputDate) {
        this.inputDate = inputDate == null ? null : inputDate.trim();
    }

    /**
     * 录入人
     * @return INPUT_ID 录入人
     */
    public String getInputId() {
        return inputId;
    }

    /**
     * 录入人
     * @param inputId 录入人
     */
    public void setInputId(String inputId) {
        this.inputId = inputId == null ? null : inputId.trim();
    }

    /**
     * 录入机构
     * @return INPUT_BR_ID 录入机构
     */
    public String getInputBrId() {
        return inputBrId;
    }

    /**
     * 录入机构
     * @param inputBrId 录入机构
     */
    public void setInputBrId(String inputBrId) {
        this.inputBrId = inputBrId == null ? null : inputBrId.trim();
    }

    /**
     * 最后更新时间
     * @return UPDATE_DATE 最后更新时间
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 最后更新时间
     * @param updateDate 最后更新时间
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }

    /**
     * 最后更新人
     * @return UPDATE_ID 最后更新人
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 最后更新人
     * @param updateId 最后更新人
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * 最后更新机构
     * @return UPDATE_BR_ID 最后更新机构
     */
    public String getUpdateBrId() {
        return updateBrId;
    }

    /**
     * 最后更新机构
     * @param updateBrId 最后更新机构
     */
    public void setUpdateBrId(String updateBrId) {
        this.updateBrId = updateBrId == null ? null : updateBrId.trim();
    }

    /**
     * 冲账成功日期
     * @return STRIKE_SUC_DATE 冲账成功日期
     */
    public String getStrikeSucDate() {
        return strikeSucDate;
    }

    /**
     * 冲账成功日期
     * @param strikeSucDate 冲账成功日期
     */
    public void setStrikeSucDate(String strikeSucDate) {
        this.strikeSucDate = strikeSucDate == null ? null : strikeSucDate.trim();
    }

    /**
     * 冲账登记人
     * @return STRIKE_OPER 冲账登记人
     */
    public String getStrikeOper() {
        return strikeOper;
    }

    /**
     * 冲账登记人
     * @param strikeOper 冲账登记人
     */
    public void setStrikeOper(String strikeOper) {
        this.strikeOper = strikeOper == null ? null : strikeOper.trim();
    }

    /**
     * 摘要
     * @return ABSTRACT 摘要
     */
    public String getAbstract_() {
        return abstract_;
    }

    /**
     * 摘要
     * @param abstract 摘要
     */
    public void setAbstract_(String abstract_) {
        this.abstract_ = abstract_;
    }

    /**
     * 已决本金
     * @return PAID_CAPITAL 已决本金
     */
    public BigDecimal getPaidCapital() {
        return paidCapital;
    }

    /**
     * 已决本金
     * @param paidCapital 已决本金
     */
    public void setPaidCapital(BigDecimal paidCapital) {
        this.paidCapital = paidCapital;
    }

    /**
     * 已决利息
     * @return PAID_INT_AMT 已决利息
     */
    public BigDecimal getPaidIntAmt() {
        return paidIntAmt;
    }

    /**
     * 已决利息
     * @param paidIntAmt 已决利息
     */
    public void setPaidIntAmt(BigDecimal paidIntAmt) {
        this.paidIntAmt = paidIntAmt;
    }

    /**
     * 已决罚息
     * @return PAID_INC_TAKEN 已决罚息
     */
    public BigDecimal getPaidIncTaken() {
        return paidIncTaken;
    }

    /**
     * 已决罚息
     * @param paidIncTaken 已决罚息
     */
    public void setPaidIncTaken(BigDecimal paidIncTaken) {
        this.paidIncTaken = paidIncTaken;
    }

    /**
     * 已决复利
     * @return PAID_COMM_OD_INT 已决复利
     */
    public BigDecimal getPaidCommOdInt() {
        return paidCommOdInt;
    }

    /**
     * 已决复利
     * @param paidCommOdInt 已决复利
     */
    public void setPaidCommOdInt(BigDecimal paidCommOdInt) {
        this.paidCommOdInt = paidCommOdInt;
    }

    /**
     * 已决预估罚息
     * @return PAID_ESTIM_INC_TAKEN 已决预估罚息
     */
    public BigDecimal getPaidEstimIncTaken() {
        return paidEstimIncTaken;
    }

    /**
     * 已决预估罚息
     * @param paidEstimIncTaken 已决预估罚息
     */
    public void setPaidEstimIncTaken(BigDecimal paidEstimIncTaken) {
        this.paidEstimIncTaken = paidEstimIncTaken;
    }

    /**
     * 计算滞纳金日期
     * @return CALCU_LATEFEE_DATE 计算滞纳金日期
     */
    public String getCalcuLatefeeDate() {
        return calcuLatefeeDate;
    }

    /**
     * 计算滞纳金日期
     * @param calcuLatefeeDate 计算滞纳金日期
     */
    public void setCalcuLatefeeDate(String calcuLatefeeDate) {
        this.calcuLatefeeDate = calcuLatefeeDate == null ? null : calcuLatefeeDate.trim();
    }

    /**
     * 滞纳金
     * @return LATE_FEE 滞纳金
     */
    public BigDecimal getLateFee() {
        return lateFee;
    }

    /**
     * 滞纳金
     * @param lateFee 滞纳金
     */
    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }

    /**
     * null
     * @return REMARK null
     */
    public String getRemark() {
        return remark;
    }

    /**
     * null
     * @param remark null
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * null
     * @return OVER_DAYS null
     */
    public BigDecimal getOverDays() {
        return overDays;
    }

    /**
     * null
     * @param overDays null
     */
    public void setOverDays(BigDecimal overDays) {
        this.overDays = overDays;
    }

    /**
     * null
     * @return OVER_AMOUNT null
     */
    public BigDecimal getOverAmount() {
        return overAmount;
    }

    /**
     * null
     * @param overAmount null
     */
    public void setOverAmount(BigDecimal overAmount) {
        this.overAmount = overAmount;
    }
}