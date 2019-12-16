package cn.com.sinosafe.domain.entity;

public class CusBlkList {
    /**
     * 登记流水号
     */
    private String serno;

    /**
     * 客户编号
     */
    private String cusId;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certCode;

    /**
     * 黑名单类型
     */
    private String blackType;

    /**
     * 黑名单级别
     */
    private String blackLevel;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 联系电话
     */
    private String legalPhone;

    /**
     * 通信地址
     */
    private String legalAddr;

    /**
     * 法定代表人
     */
    private String legalName;

    /**
     * 进入日期
     */
    private String blackDate;

    /**
     * 进入黑名单原因
     */
    private String blackReason;

    /**
     * 注销日期
     */
    private String logoutDate;

    /**
     * 注销原因
     */
    private String logoutReason;

    /**
     * 登记人
     */
    private String inputId;

    /**
     * 登记机构
     */
    private String inputBrId;

    /**
     * 登记日期
     */
    private String inputDate;

    /**
     * 注销人
     */
    private String logoutId;

    /**
     * 注销机构
     */
    private String logoutBrId;

    /**
     * 审批人
     */
    private String apprId;

    /**
     * 审批机构
     */
    private String apprBrId;

    /**
     * 状态
     */
    private String status;

    /**
     * 进入时长（月）
     */
    private String blackDuration;

    /**
     * 登记流水号
     * @return SERNO 登记流水号
     */
    public String getSerno() {
        return serno;
    }

    /**
     * 登记流水号
     * @param serno 登记流水号
     */
    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    /**
     * 客户编号
     * @return CUS_ID 客户编号
     */
    public String getCusId() {
        return cusId;
    }

    /**
     * 客户编号
     * @param cusId 客户编号
     */
    public void setCusId(String cusId) {
        this.cusId = cusId == null ? null : cusId.trim();
    }

    /**
     * 客户名称
     * @return CUS_NAME 客户名称
     */
    public String getCusName() {
        return cusName;
    }

    /**
     * 客户名称
     * @param cusName 客户名称
     */
    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    /**
     * 证件类型
     * @return CERT_TYPE 证件类型
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 证件类型
     * @param certType 证件类型
     */
    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    /**
     * 证件号码
     * @return CERT_CODE 证件号码
     */
    public String getCertCode() {
        return certCode;
    }

    /**
     * 证件号码
     * @param certCode 证件号码
     */
    public void setCertCode(String certCode) {
        this.certCode = certCode == null ? null : certCode.trim();
    }

    /**
     * 黑名单类型
     * @return BLACK_TYPE 黑名单类型
     */
    public String getBlackType() {
        return blackType;
    }

    /**
     * 黑名单类型
     * @param blackType 黑名单类型
     */
    public void setBlackType(String blackType) {
        this.blackType = blackType == null ? null : blackType.trim();
    }

    /**
     * 黑名单级别
     * @return BLACK_LEVEL 黑名单级别
     */
    public String getBlackLevel() {
        return blackLevel;
    }

    /**
     * 黑名单级别
     * @param blackLevel 黑名单级别
     */
    public void setBlackLevel(String blackLevel) {
        this.blackLevel = blackLevel == null ? null : blackLevel.trim();
    }

    /**
     * 数据来源
     * @return DATA_SOURCE 数据来源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 数据来源
     * @param dataSource 数据来源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    /**
     * 联系电话
     * @return LEGAL_PHONE 联系电话
     */
    public String getLegalPhone() {
        return legalPhone;
    }

    /**
     * 联系电话
     * @param legalPhone 联系电话
     */
    public void setLegalPhone(String legalPhone) {
        this.legalPhone = legalPhone == null ? null : legalPhone.trim();
    }

    /**
     * 通信地址
     * @return LEGAL_ADDR 通信地址
     */
    public String getLegalAddr() {
        return legalAddr;
    }

    /**
     * 通信地址
     * @param legalAddr 通信地址
     */
    public void setLegalAddr(String legalAddr) {
        this.legalAddr = legalAddr == null ? null : legalAddr.trim();
    }

    /**
     * 法定代表人
     * @return LEGAL_NAME 法定代表人
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * 法定代表人
     * @param legalName 法定代表人
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    /**
     * 进入日期
     * @return BLACK_DATE 进入日期
     */
    public String getBlackDate() {
        return blackDate;
    }

    /**
     * 进入日期
     * @param blackDate 进入日期
     */
    public void setBlackDate(String blackDate) {
        this.blackDate = blackDate == null ? null : blackDate.trim();
    }

    /**
     * 进入黑名单原因
     * @return BLACK_REASON 进入黑名单原因
     */
    public String getBlackReason() {
        return blackReason;
    }

    /**
     * 进入黑名单原因
     * @param blackReason 进入黑名单原因
     */
    public void setBlackReason(String blackReason) {
        this.blackReason = blackReason == null ? null : blackReason.trim();
    }

    /**
     * 注销日期
     * @return LOGOUT_DATE 注销日期
     */
    public String getLogoutDate() {
        return logoutDate;
    }

    /**
     * 注销日期
     * @param logoutDate 注销日期
     */
    public void setLogoutDate(String logoutDate) {
        this.logoutDate = logoutDate == null ? null : logoutDate.trim();
    }

    /**
     * 注销原因
     * @return LOGOUT_REASON 注销原因
     */
    public String getLogoutReason() {
        return logoutReason;
    }

    /**
     * 注销原因
     * @param logoutReason 注销原因
     */
    public void setLogoutReason(String logoutReason) {
        this.logoutReason = logoutReason == null ? null : logoutReason.trim();
    }

    /**
     * 登记人
     * @return INPUT_ID 登记人
     */
    public String getInputId() {
        return inputId;
    }

    /**
     * 登记人
     * @param inputId 登记人
     */
    public void setInputId(String inputId) {
        this.inputId = inputId == null ? null : inputId.trim();
    }

    /**
     * 登记机构
     * @return INPUT_BR_ID 登记机构
     */
    public String getInputBrId() {
        return inputBrId;
    }

    /**
     * 登记机构
     * @param inputBrId 登记机构
     */
    public void setInputBrId(String inputBrId) {
        this.inputBrId = inputBrId == null ? null : inputBrId.trim();
    }

    /**
     * 登记日期
     * @return INPUT_DATE 登记日期
     */
    public String getInputDate() {
        return inputDate;
    }

    /**
     * 登记日期
     * @param inputDate 登记日期
     */
    public void setInputDate(String inputDate) {
        this.inputDate = inputDate == null ? null : inputDate.trim();
    }

    /**
     * 注销人
     * @return LOGOUT_ID 注销人
     */
    public String getLogoutId() {
        return logoutId;
    }

    /**
     * 注销人
     * @param logoutId 注销人
     */
    public void setLogoutId(String logoutId) {
        this.logoutId = logoutId == null ? null : logoutId.trim();
    }

    /**
     * 注销机构
     * @return LOGOUT_BR_ID 注销机构
     */
    public String getLogoutBrId() {
        return logoutBrId;
    }

    /**
     * 注销机构
     * @param logoutBrId 注销机构
     */
    public void setLogoutBrId(String logoutBrId) {
        this.logoutBrId = logoutBrId == null ? null : logoutBrId.trim();
    }

    /**
     * 审批人
     * @return APPR_ID 审批人
     */
    public String getApprId() {
        return apprId;
    }

    /**
     * 审批人
     * @param apprId 审批人
     */
    public void setApprId(String apprId) {
        this.apprId = apprId == null ? null : apprId.trim();
    }

    /**
     * 审批机构
     * @return APPR_BR_ID 审批机构
     */
    public String getApprBrId() {
        return apprBrId;
    }

    /**
     * 审批机构
     * @param apprBrId 审批机构
     */
    public void setApprBrId(String apprBrId) {
        this.apprBrId = apprBrId == null ? null : apprBrId.trim();
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
     * 进入时长（月）
     * @return BLACK_DURATION 进入时长（月）
     */
    public String getBlackDuration() {
        return blackDuration;
    }

    /**
     * 进入时长（月）
     * @param blackDuration 进入时长（月）
     */
    public void setBlackDuration(String blackDuration) {
        this.blackDuration = blackDuration == null ? null : blackDuration.trim();
    }
}