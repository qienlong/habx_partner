package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PaIndCrtRepayPlan {
    /**
     * 还款计划主键
     */
    private String id;

    /**
     * 申请号
     */
    private String applNo;

    /**
     * 借据号
     */
    private String lnAcct;

    /**
     * 期次
     */
    private Short period;

    /**
     * 应还款日(YYYY-MM-DD)
     */
    private String dueDate;

    /**
     * 应还保费
     */
    private BigDecimal dueInsAmt;

    /**
     * 实还保费
     */
    private BigDecimal realInsAmt;

    /**
     * 应还本金
     */
    private BigDecimal duePrinAmt;

    /**
     * 实还本金
     */
    private BigDecimal realPrinAmt;

    /**
     * 应还利息
     */
    private BigDecimal dueIntAmt;

    /**
     * 实还利息
     */
    private BigDecimal realIntAmt;

    /**
     * 应还罚息
     */
    private BigDecimal dueLcAmt;

    /**
     * 实还罚息
     */
    private BigDecimal realLcAmt;

    /**
     * 状态
     */
    private String status;

    /**
     * 保险公司合作方
     */
    private String insuCompany;

    /**
     * 来源方
     */
    private String source;

    /**
     * 同步状态
     */
    private String synStatus;

    /**
     * 业务日期
     */
    private String businessDate;

    /**
     * 录入时间(YYYY-MM-DD hh24:mi:ss)
     */
    private String inputDateTime;

    /**
     * 更新时间(YYYY-MM-DD hh24:mi:ss)
     */
    private String updateDateTime;

    /**
     * 还款计划主键
     * @return ID 还款计划主键
     */
    public String getId() {
        return id;
    }

    /**
     * 还款计划主键
     * @param id 还款计划主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 申请号
     * @return APPL_NO 申请号
     */
    public String getApplNo() {
        return applNo;
    }

    /**
     * 申请号
     * @param applNo 申请号
     */
    public void setApplNo(String applNo) {
        this.applNo = applNo == null ? null : applNo.trim();
    }

    /**
     * 借据号
     * @return LN_ACCT 借据号
     */
    public String getLnAcct() {
        return lnAcct;
    }

    /**
     * 借据号
     * @param lnAcct 借据号
     */
    public void setLnAcct(String lnAcct) {
        this.lnAcct = lnAcct == null ? null : lnAcct.trim();
    }

    /**
     * 期次
     * @return PERIOD 期次
     */
    public Short getPeriod() {
        return period;
    }

    /**
     * 期次
     * @param period 期次
     */
    public void setPeriod(Short period) {
        this.period = period;
    }

    /**
     * 应还款日(YYYY-MM-DD)
     * @return DUE_DATE 应还款日(YYYY-MM-DD)
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * 应还款日(YYYY-MM-DD)
     * @param dueDate 应还款日(YYYY-MM-DD)
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate == null ? null : dueDate.trim();
    }

    /**
     * 应还保费
     * @return DUE_INS_AMT 应还保费
     */
    public BigDecimal getDueInsAmt() {
        return dueInsAmt;
    }

    /**
     * 应还保费
     * @param dueInsAmt 应还保费
     */
    public void setDueInsAmt(BigDecimal dueInsAmt) {
        this.dueInsAmt = dueInsAmt;
    }

    /**
     * 实还保费
     * @return REAL_INS_AMT 实还保费
     */
    public BigDecimal getRealInsAmt() {
        return realInsAmt;
    }

    /**
     * 实还保费
     * @param realInsAmt 实还保费
     */
    public void setRealInsAmt(BigDecimal realInsAmt) {
        this.realInsAmt = realInsAmt;
    }

    /**
     * 应还本金
     * @return DUE_PRIN_AMT 应还本金
     */
    public BigDecimal getDuePrinAmt() {
        return duePrinAmt;
    }

    /**
     * 应还本金
     * @param duePrinAmt 应还本金
     */
    public void setDuePrinAmt(BigDecimal duePrinAmt) {
        this.duePrinAmt = duePrinAmt;
    }

    /**
     * 实还本金
     * @return REAL_PRIN_AMT 实还本金
     */
    public BigDecimal getRealPrinAmt() {
        return realPrinAmt;
    }

    /**
     * 实还本金
     * @param realPrinAmt 实还本金
     */
    public void setRealPrinAmt(BigDecimal realPrinAmt) {
        this.realPrinAmt = realPrinAmt;
    }

    /**
     * 应还利息
     * @return DUE_INT_AMT 应还利息
     */
    public BigDecimal getDueIntAmt() {
        return dueIntAmt;
    }

    /**
     * 应还利息
     * @param dueIntAmt 应还利息
     */
    public void setDueIntAmt(BigDecimal dueIntAmt) {
        this.dueIntAmt = dueIntAmt;
    }

    /**
     * 实还利息
     * @return REAL_INT_AMT 实还利息
     */
    public BigDecimal getRealIntAmt() {
        return realIntAmt;
    }

    /**
     * 实还利息
     * @param realIntAmt 实还利息
     */
    public void setRealIntAmt(BigDecimal realIntAmt) {
        this.realIntAmt = realIntAmt;
    }

    /**
     * 应还罚息
     * @return DUE_LC_AMT 应还罚息
     */
    public BigDecimal getDueLcAmt() {
        return dueLcAmt;
    }

    /**
     * 应还罚息
     * @param dueLcAmt 应还罚息
     */
    public void setDueLcAmt(BigDecimal dueLcAmt) {
        this.dueLcAmt = dueLcAmt;
    }

    /**
     * 实还罚息
     * @return REAL_LC_AMT 实还罚息
     */
    public BigDecimal getRealLcAmt() {
        return realLcAmt;
    }

    /**
     * 实还罚息
     * @param realLcAmt 实还罚息
     */
    public void setRealLcAmt(BigDecimal realLcAmt) {
        this.realLcAmt = realLcAmt;
    }

    /**
     * 状态
     * @return STATUS 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 保险公司合作方
     * @return INSU_COMPANY 保险公司合作方
     */
    public String getInsuCompany() {
        return insuCompany;
    }

    /**
     * 保险公司合作方
     * @param insuCompany 保险公司合作方
     */
    public void setInsuCompany(String insuCompany) {
        this.insuCompany = insuCompany == null ? null : insuCompany.trim();
    }

    /**
     * 来源方
     * @return SOURCE 来源方
     */
    public String getSource() {
        return source;
    }

    /**
     * 来源方
     * @param source 来源方
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 同步状态
     * @return SYN_STATUS 同步状态
     */
    public String getSynStatus() {
        return synStatus;
    }

    /**
     * 同步状态
     * @param synStatus 同步状态
     */
    public void setSynStatus(String synStatus) {
        this.synStatus = synStatus == null ? null : synStatus.trim();
    }

    /**
     * 业务日期
     * @return BUSINESS_DATE 业务日期
     */
    public String getBusinessDate() {
        return businessDate;
    }

    /**
     * 业务日期
     * @param businessDate 业务日期
     */
    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate == null ? null : businessDate.trim();
    }

    /**
     * 录入时间(YYYY-MM-DD hh24:mi:ss)
     * @return INPUT_DATE_TIME 录入时间(YYYY-MM-DD hh24:mi:ss)
     */
    public String getInputDateTime() {
        return inputDateTime;
    }

    /**
     * 录入时间(YYYY-MM-DD hh24:mi:ss)
     * @param inputDateTime 录入时间(YYYY-MM-DD hh24:mi:ss)
     */
    public void setInputDateTime(String inputDateTime) {
        this.inputDateTime = inputDateTime == null ? null : inputDateTime.trim();
    }

    /**
     * 更新时间(YYYY-MM-DD hh24:mi:ss)
     * @return UPDATE_DATE_TIME 更新时间(YYYY-MM-DD hh24:mi:ss)
     */
    public String getUpdateDateTime() {
        return updateDateTime;
    }

    /**
     * 更新时间(YYYY-MM-DD hh24:mi:ss)
     * @param updateDateTime 更新时间(YYYY-MM-DD hh24:mi:ss)
     */
    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime == null ? null : updateDateTime.trim();
    }
}