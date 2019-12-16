package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class CusBase {
    /**
     * 客户编码
     */
    private String cusId;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 核心客户号
     */
    private String transCusId;

    /**
     * 客户类型
     */
    private String cusType;

    /**
     * 外文名称
     */
    private String cusEnName;

    /**
     * 客户简称
     */
    private String cusShortName;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certCode;

    /**
     * 组织机构代码
     */
    private String comInsCode;

    /**
     * 客户归属条线
     */
    private String belongTo;

    /**
     * 客户性质
     */
    private String cusPro;

    /**
     * 贷款卡编号
     */
    private String loanCardId;

    /**
     * 注册登记类型
     */
    private String regType;

    /**
     * 登记注册号
     */
    private String regCode;

    /**
     * 注册资本币种
     */
    private String regCurType;

    /**
     * 注册资本（万元）
     */
    private BigDecimal regCapAmt;

    /**
     * 实际经营地址
     */
    private String comOptAddr;

    /**
     * 客户经理
     */
    private String custMgr;

    /**
     * 主管机构
     */
    private String mainBrId;

    /**
     * 机构代码类型
     */
    private String creditCertType;

    /**
     * 机构信用代码
     */
    private String creditCertCode;

    /**
     * 客户编码
     * @return CUS_ID 客户编码
     */
    public String getCusId() {
        return cusId;
    }

    /**
     * 客户编码
     * @param cusId 客户编码
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
     * 核心客户号
     * @return TRANS_CUS_ID 核心客户号
     */
    public String getTransCusId() {
        return transCusId;
    }

    /**
     * 核心客户号
     * @param transCusId 核心客户号
     */
    public void setTransCusId(String transCusId) {
        this.transCusId = transCusId == null ? null : transCusId.trim();
    }

    /**
     * 客户类型
     * @return CUS_TYPE 客户类型
     */
    public String getCusType() {
        return cusType;
    }

    /**
     * 客户类型
     * @param cusType 客户类型
     */
    public void setCusType(String cusType) {
        this.cusType = cusType == null ? null : cusType.trim();
    }

    /**
     * 外文名称
     * @return CUS_EN_NAME 外文名称
     */
    public String getCusEnName() {
        return cusEnName;
    }

    /**
     * 外文名称
     * @param cusEnName 外文名称
     */
    public void setCusEnName(String cusEnName) {
        this.cusEnName = cusEnName == null ? null : cusEnName.trim();
    }

    /**
     * 客户简称
     * @return CUS_SHORT_NAME 客户简称
     */
    public String getCusShortName() {
        return cusShortName;
    }

    /**
     * 客户简称
     * @param cusShortName 客户简称
     */
    public void setCusShortName(String cusShortName) {
        this.cusShortName = cusShortName == null ? null : cusShortName.trim();
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
     * 组织机构代码
     * @return COM_INS_CODE 组织机构代码
     */
    public String getComInsCode() {
        return comInsCode;
    }

    /**
     * 组织机构代码
     * @param comInsCode 组织机构代码
     */
    public void setComInsCode(String comInsCode) {
        this.comInsCode = comInsCode == null ? null : comInsCode.trim();
    }

    /**
     * 客户归属条线
     * @return BELONG_TO 客户归属条线
     */
    public String getBelongTo() {
        return belongTo;
    }

    /**
     * 客户归属条线
     * @param belongTo 客户归属条线
     */
    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo == null ? null : belongTo.trim();
    }

    /**
     * 客户性质
     * @return CUS_PRO 客户性质
     */
    public String getCusPro() {
        return cusPro;
    }

    /**
     * 客户性质
     * @param cusPro 客户性质
     */
    public void setCusPro(String cusPro) {
        this.cusPro = cusPro == null ? null : cusPro.trim();
    }

    /**
     * 贷款卡编号
     * @return LOAN_CARD_ID 贷款卡编号
     */
    public String getLoanCardId() {
        return loanCardId;
    }

    /**
     * 贷款卡编号
     * @param loanCardId 贷款卡编号
     */
    public void setLoanCardId(String loanCardId) {
        this.loanCardId = loanCardId == null ? null : loanCardId.trim();
    }

    /**
     * 注册登记类型
     * @return REG_TYPE 注册登记类型
     */
    public String getRegType() {
        return regType;
    }

    /**
     * 注册登记类型
     * @param regType 注册登记类型
     */
    public void setRegType(String regType) {
        this.regType = regType == null ? null : regType.trim();
    }

    /**
     * 登记注册号
     * @return REG_CODE 登记注册号
     */
    public String getRegCode() {
        return regCode;
    }

    /**
     * 登记注册号
     * @param regCode 登记注册号
     */
    public void setRegCode(String regCode) {
        this.regCode = regCode == null ? null : regCode.trim();
    }

    /**
     * 注册资本币种
     * @return REG_CUR_TYPE 注册资本币种
     */
    public String getRegCurType() {
        return regCurType;
    }

    /**
     * 注册资本币种
     * @param regCurType 注册资本币种
     */
    public void setRegCurType(String regCurType) {
        this.regCurType = regCurType == null ? null : regCurType.trim();
    }

    /**
     * 注册资本（万元）
     * @return REG_CAP_AMT 注册资本（万元）
     */
    public BigDecimal getRegCapAmt() {
        return regCapAmt;
    }

    /**
     * 注册资本（万元）
     * @param regCapAmt 注册资本（万元）
     */
    public void setRegCapAmt(BigDecimal regCapAmt) {
        this.regCapAmt = regCapAmt;
    }

    /**
     * 实际经营地址
     * @return COM_OPT_ADDR 实际经营地址
     */
    public String getComOptAddr() {
        return comOptAddr;
    }

    /**
     * 实际经营地址
     * @param comOptAddr 实际经营地址
     */
    public void setComOptAddr(String comOptAddr) {
        this.comOptAddr = comOptAddr == null ? null : comOptAddr.trim();
    }

    /**
     * 客户经理
     * @return CUST_MGR 客户经理
     */
    public String getCustMgr() {
        return custMgr;
    }

    /**
     * 客户经理
     * @param custMgr 客户经理
     */
    public void setCustMgr(String custMgr) {
        this.custMgr = custMgr == null ? null : custMgr.trim();
    }

    /**
     * 主管机构
     * @return MAIN_BR_ID 主管机构
     */
    public String getMainBrId() {
        return mainBrId;
    }

    /**
     * 主管机构
     * @param mainBrId 主管机构
     */
    public void setMainBrId(String mainBrId) {
        this.mainBrId = mainBrId == null ? null : mainBrId.trim();
    }

    /**
     * 机构代码类型
     * @return CREDIT_CERT_TYPE 机构代码类型
     */
    public String getCreditCertType() {
        return creditCertType;
    }

    /**
     * 机构代码类型
     * @param creditCertType 机构代码类型
     */
    public void setCreditCertType(String creditCertType) {
        this.creditCertType = creditCertType == null ? null : creditCertType.trim();
    }

    /**
     * 机构信用代码
     * @return CREDIT_CERT_CODE 机构信用代码
     */
    public String getCreditCertCode() {
        return creditCertCode;
    }

    /**
     * 机构信用代码
     * @param creditCertCode 机构信用代码
     */
    public void setCreditCertCode(String creditCertCode) {
        this.creditCertCode = creditCertCode == null ? null : creditCertCode.trim();
    }
}