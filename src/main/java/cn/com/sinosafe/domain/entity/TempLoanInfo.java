package cn.com.sinosafe.domain.entity;

public class TempLoanInfo {
    /**
     * 主键
     */
    private String uuid;

    /**
     * 保单号
     */
    private String policyNo;

    /**
     * 借据号
     */
    private String lnAcct;

    /**
     * 申请号
     */
    private String applNo;

    /**
     * 逾期天数
     */
    private String recoveryDate;

    /**
     * 借据状态
     */
    private String lnState;

    /**
     * 结清日期
     */
    private String lnOvDate;

    /**
     * M6账户日期
     */
    private String dueOvDate;

    /**
     * 来源方
     */
    private String source;

    /**
     * 业务类型：平安独保，平安共保等等
     */
    private String businessType;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private String datetimeCreated;

    /**
     * 主键
     * @return UUID 主键
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 主键
     * @param uuid 主键
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * 保单号
     * @return POLICY_NO 保单号
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 保单号
     * @param policyNo 保单号
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
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
     * 逾期天数
     * @return RECOVERY_DATE 逾期天数
     */
    public String getRecoveryDate() {
        return recoveryDate;
    }

    /**
     * 逾期天数
     * @param recoveryDate 逾期天数
     */
    public void setRecoveryDate(String recoveryDate) {
        this.recoveryDate = recoveryDate == null ? null : recoveryDate.trim();
    }

    /**
     * 借据状态
     * @return LN_STATE 借据状态
     */
    public String getLnState() {
        return lnState;
    }

    /**
     * 借据状态
     * @param lnState 借据状态
     */
    public void setLnState(String lnState) {
        this.lnState = lnState == null ? null : lnState.trim();
    }

    /**
     * 结清日期
     * @return LN_OV_DATE 结清日期
     */
    public String getLnOvDate() {
        return lnOvDate;
    }

    /**
     * 结清日期
     * @param lnOvDate 结清日期
     */
    public void setLnOvDate(String lnOvDate) {
        this.lnOvDate = lnOvDate == null ? null : lnOvDate.trim();
    }

    /**
     * M6账户日期
     * @return DUE_OV_DATE M6账户日期
     */
    public String getDueOvDate() {
        return dueOvDate;
    }

    /**
     * M6账户日期
     * @param dueOvDate M6账户日期
     */
    public void setDueOvDate(String dueOvDate) {
        this.dueOvDate = dueOvDate == null ? null : dueOvDate.trim();
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
     * 业务类型：平安独保，平安共保等等
     * @return BUSINESS_TYPE 业务类型：平安独保，平安共保等等
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 业务类型：平安独保，平安共保等等
     * @param businessType 业务类型：平安独保，平安共保等等
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    /**
     * 创建人
     * @return CREATED_BY 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 创建人
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 创建时间
     * @return DATETIME_CREATED 创建时间
     */
    public String getDatetimeCreated() {
        return datetimeCreated;
    }

    /**
     * 创建时间
     * @param datetimeCreated 创建时间
     */
    public void setDatetimeCreated(String datetimeCreated) {
        this.datetimeCreated = datetimeCreated == null ? null : datetimeCreated.trim();
    }
}