package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class IqpMeCusApp {
    /**
     * 业务流水号,界面隐藏
     */
    private String serno;

    /**
     * 客户编号
     */
    private String cusId;

    /**
     * 核心客户编号
     */
    private String transCusId;

    /**
     * 证件类型,STD_ZB_CERT_TYP
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certCode;

    /**
     * 客户类型，STD_ZB_CUS_TYPE
     */
    private String cusType;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 出生日期
     */
    private String indivDtOfBirth;

    /**
     * 性别，STD_ZX_SEX
     */
    private String indivSex;

    /**
     * 婚姻状况，STD_ZX_MARR_STATUS
     */
    private String indivMarSt;

    /**
     * 本地居住年限
     */
    private String localYear;

    /**
     * 申请人手机号
     */
    private String mobile;

    /**
     * 配偶姓名
     */
    private String indivSpsName;

    /**
     * 配偶年龄
     */
    private String indivSpsAge;

    /**
     * 配偶职业，STD_ZX_EMPLOYMET
     */
    private String indivSpsOcc;

    /**
     * 配偶工作单位
     */
    private String indivScomName;

    /**
     * 配偶证件类型，STD_ZB_CERT_TYP
     */
    private String indivSpsIdTyp;

    /**
     * 配偶证件号码
     */
    private String indivSpsIdCode;

    /**
     * 配偶手机号（配偶联系方式）
     */
    private String indivSpsMphn;

    /**
     * 居住住址
     */
    private String indivRsdAddr;

    /**
     * 居住地址邮编
     */
    private String indivZipCode;

    /**
     * 家庭人数
     */
    private String indivFamNum;

    /**
     * 紧急联系人
     */
    private String urgentPerson;

    /**
     * 紧急联系人联系方式
     */
    private String urgentContact;

    /**
     * 居住状况，STD_ZB_RESIDE_STATUS
     */
    private String indivRsdSt;

    /**
     * 居住状况其它说明，居住状况选择其它时填写
     */
    private String indivRsdStDetail;

    /**
     * 教育程度，STD_ZX_EDU
     */
    private String eduLevel;

    /**
     * 教育程度其它，教育程度选择其它时填写
     */
    private String eduLevelDetails;

    /**
     * 最高学历，STD_ZX_EDU
     */
    private String indivEdt;

    /**
     * 最高学位，STD_ZX_DEGREE
     */
    private String indivDgr;

    /**
     * 工作或经营单位（单位名称、企业名称）
     */
    private String indivComName;

    /**
     * 职业，STD_ZX_EMPLOYMET
     */
    private String indivOcc;

    /**
     * 职务，STD_ZX_DUTY
     */
    private String indivComJobTtl;

    /**
     * 企业（单位）所属行业名称
     */
    private String indivCllName;

    /**
     * 单位所属行业
     */
    private String indivCllId;

    /**
     * 企业（单位）地址
     */
    private String indivComAddr;

    /**
     * 企业（单位）地址邮编
     */
    private String indivComZipCode;

    /**
     * 开业时间
     */
    private String openDate;

    /**
     * 经营年限
     */
    private String operYears;

    /**
     * 雇员人数
     */
    private String employeeNum;

    /**
     * 经营场所
     */
    private String operPlace;

    /**
     * 经营场所面积
     */
    private String operArea;

    /**
     * 经营场所房租
     */
    private BigDecimal operRent;

    /**
     * 主银行卡开户机构，填写行名
     */
    private String mainBankName;

    /**
     * 有无贷款卡
     */
    private String loanCardFlg;

    /**
     * 贷款卡号
     */
    private String comInvLoanCard;

    /**
     * 最近一年销售额
     */
    private BigDecimal sellLimit;

    /**
     * 毛利率
     */
    private BigDecimal grossRate;

    /**
     * 最近一年除去所有开支净利
     */
    private BigDecimal retainedProfits;

    /**
     * 存货
     */
    private BigDecimal stock;

    /**
     * 应收账款
     */
    private BigDecimal receivableDebt;

    /**
     * 负债
     */
    private BigDecimal liabilities;

    /**
     * 总资产
     */
    private BigDecimal totalMeans;

    /**
     * 家庭收入
     */
    private BigDecimal famMeans;

    /**
     * 其他收入
     */
    private BigDecimal otherIncome;

    /**
     * 经营模式及上下游供应关系
     */
    private String operRelate;

    /**
     * 是否在本行申请贷款
     */
    private String isCdrcbLoan;

    /**
     * 存量贷款申请时间
     */
    private String cdrcbLoanDate;

    /**
     * 关联方是否在本行申请贷款
     */
    private String relateCdrcbLoan;

    /**
     * 关联方姓名
     */
    private String relateName;

    /**
     * 关系类型，STD_ZB_GRP_CO_TYPE
     */
    private String relateType;

    /**
     * 组织形式： 个体户，法律实体
     */
    private String orgType;

    /**
     * 联保协议编号
     */
    private String assureAgreeNo;

    /**
     * 是否联保小组组长
     */
    private String isHeadman;

    /**
     * 保证金缴存额度
     */
    private BigDecimal assureAmount;

    /**
     * 通讯地址邮编
     */
    private String postCode;

    /**
     * 通讯地址
     */
    private String postAddr;

    /**
     * 毛利润
     */
    private BigDecimal grossProfit;

    /**
     * 家庭电话
     */
    private String indivFamPhone;

    /**
     * 职称
     */
    private String indivComJobJb;

    /**
     * 营业执照
     */
    private String operNo;

    /**
     * 经营地址
     */
    private String operAddr;

    /**
     * 主营业务
     */
    private String operJob;

    /**
     * 所属行业
     */
    private String operName;

    /**
     * 经营历史
     */
    private String operHist;

    /**
     * 评价财务信息
     */
    private String desc1;

    /**
     * 行业资金需求
     */
    private String desc2;

    /**
     * 客户在家庭或在社会经济网中的状况
     */
    private String desc3;

    /**
     * 有无房产
     */
    private String isHouse;

    /**
     * 房产位置
     */
    private String houseAddr;

    /**
     * 房产面积
     */
    private String houseArea;

    /**
     * 房产原价
     */
    private BigDecimal houseOriValue;

    /**
     * 房产现值
     */
    private BigDecimal houseNowValue;

    /**
     * 购买时间
     */
    private String houseBuyDate;

    /**
     * 其它资产
     */
    private String descOtherPro;

    /**
     * IS_CENT_BANK_GZ
     */
    private String isCentBankGz;

    /**
     * JL
     */
    private String jl;

    /**
     * XDLS
     */
    private String xdls;

    /**
     * 配偶工作名称
     */
    private String indivSpsWorkName;

    /**
     * 配偶的经营地址或者工作地址
     */
    private String indivSpsWorkAddr;

    /**
     * indiv_sps_rst_st
     */
    private String indivSpsRstSt;

    /**
     * POST_SPS_CODE
     */
    private String postSpsCode;

    /**
     * 居住地址
     */
    private String indivSpsRsdAddr;

    /**
     * 家访情况
     */
    private String askStatus;

    /**
     * 评价经营组织和市场情况
     */
    private String desc0;

    /**
     * 房产类型
     */
    private String houseType;

    /**
     * 单户金额
     */
    private BigDecimal allAmount;

    /**
     * 户籍地址
     */
    private String indivBrtPlace;

    /**
     * 证件起始日期
     */
    private String indivSpsIdStartDate;

    /**
     * 证件到期日期
     */
    private String indivSpsIdEndDate;

    /**
     * 紧急联系人与申请人关系
     */
    private String urgentPersonCusRel;

    /**
     * 年龄
     */
    private String indivAge;

    /**
     * 是否本地户口
     */
    private String isNative;

    /**
     * 配偶具体信息
     */
    private String indivSpsSpcInfor;

    /**
     * 子女信息
     */
    private String childrenInfor;

    /**
     * 子女具体信息
     */
    private String childrenSpcInfor;

    /**
     * 企业/生意名称
     */
    private String businName;

    /**
     * 注册经营人/法人代表
     */
    private String legalName;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 其他经营
     */
    private String operOther;

    /**
     * 下游关系
     */
    private String operLowRelate;

    /**
     * 家庭资产所有人
     */
    private String assetsOwner;

    /**
     * 客户信息收集核实
     */
    private String cusInforVerify;

    /**
     * 表外项目
     */
    private String offItem;

    /**
     * 居住地址区划名称
     */
    private String indivRsdPle;

    /**
     * 居住地址行政区划
     */
    private String indivRsdPleId;

    /**
     * 管理结构图
     */
    private String managementStructure;

    /**
     * 生产加工流程图
     */
    private String workFlow;

    /**
     * 证件有效期
     */
    private String indivIdLong;

    /**
     * 经营年限(月)
     */
    private String operMonths;

    /**
     * 单位电话
     */
    private String indivComPhn;

    /**
     * 单位工作起始年
     */
    private String indivWorkJobY;

    /**
     * 单位所属行业
     */
    private String indivComFld;

    /**
     * 单位性质
     */
    private String indivComTyp;

    /**
     * 户籍地址区划名称
     */
    private String indivBrtPle;

    /**
     * 户籍地址行政区划
     */
    private String indivBrtPleId;

    /**
     * 户籍是否为申请所在地
     */
    private String isBrtLocal;

    /**
     * 国籍
     */
    private String comCountry;

    /**
     * 现住房面积
     */
    private String housingArea;

    /**
     * 现址入住时间
     */
    private String housingDate;

    /**
     * 信息来源
     */
    private String informationSource;

    /**
     * 社保卡卡号
     */
    private String socScrNo;

    /**
     * 居住省省会城市固话区号
     */
    private String provAreaCode;

    /**
     * 户口所属城市固话区号
     */
    private String regResAreaCode;

    /**
     * 手机号码归属地
     */
    private String mobileAttribution;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 单位地址区划名称
     */
    private String indivComPle;

    /**
     * 单位地址行政区划
     */
    private String indivComPleId;

    /**
     * 房产地址
     */
    private String houseAddress;

    /**
     * 房产权属人
     */
    private String houseOwnerName;

    /**
     * 权属人证件号码
     */
    private String houseOwnerCertCode;

    /**
     * 房地产权证号
     */
    private String houseNo;

    /**
     * 房屋规划用途(住宅、商住两用、商用房)
     */
    private String housePurpose;

    /**
     * 月均销售额
     */
    private String mthSaleAmt;

    /**
     * 评估起期
     */
    private String mthElvStrdate;

    /**
     * 评估止期
     */
    private String mthElvEnddate;

    /**
     * 客户号-注册银行返回
     */
    private String cifNo;

    /**
     * 二级电子账号
     */
    private String eAcNo;

    /**
     * 二级电子账号状态
     */
    private String eAcState;

    /**
     * 民泰H5开户地址
     */
    private String returnurl;

    /**
     * 职业名称
     */
    private String indivOccName;

    /**
     * 业务流水号,界面隐藏
     * @return SERNO 业务流水号,界面隐藏
     */
    public String getSerno() {
        return serno;
    }

    /**
     * 业务流水号,界面隐藏
     * @param serno 业务流水号,界面隐藏
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
     * 核心客户编号
     * @return TRANS_CUS_ID 核心客户编号
     */
    public String getTransCusId() {
        return transCusId;
    }

    /**
     * 核心客户编号
     * @param transCusId 核心客户编号
     */
    public void setTransCusId(String transCusId) {
        this.transCusId = transCusId == null ? null : transCusId.trim();
    }

    /**
     * 证件类型,STD_ZB_CERT_TYP
     * @return CERT_TYPE 证件类型,STD_ZB_CERT_TYP
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 证件类型,STD_ZB_CERT_TYP
     * @param certType 证件类型,STD_ZB_CERT_TYP
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
     * 客户类型，STD_ZB_CUS_TYPE
     * @return CUS_TYPE 客户类型，STD_ZB_CUS_TYPE
     */
    public String getCusType() {
        return cusType;
    }

    /**
     * 客户类型，STD_ZB_CUS_TYPE
     * @param cusType 客户类型，STD_ZB_CUS_TYPE
     */
    public void setCusType(String cusType) {
        this.cusType = cusType == null ? null : cusType.trim();
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
     * 出生日期
     * @return INDIV_DT_OF_BIRTH 出生日期
     */
    public String getIndivDtOfBirth() {
        return indivDtOfBirth;
    }

    /**
     * 出生日期
     * @param indivDtOfBirth 出生日期
     */
    public void setIndivDtOfBirth(String indivDtOfBirth) {
        this.indivDtOfBirth = indivDtOfBirth == null ? null : indivDtOfBirth.trim();
    }

    /**
     * 性别，STD_ZX_SEX
     * @return INDIV_SEX 性别，STD_ZX_SEX
     */
    public String getIndivSex() {
        return indivSex;
    }

    /**
     * 性别，STD_ZX_SEX
     * @param indivSex 性别，STD_ZX_SEX
     */
    public void setIndivSex(String indivSex) {
        this.indivSex = indivSex == null ? null : indivSex.trim();
    }

    /**
     * 婚姻状况，STD_ZX_MARR_STATUS
     * @return INDIV_MAR_ST 婚姻状况，STD_ZX_MARR_STATUS
     */
    public String getIndivMarSt() {
        return indivMarSt;
    }

    /**
     * 婚姻状况，STD_ZX_MARR_STATUS
     * @param indivMarSt 婚姻状况，STD_ZX_MARR_STATUS
     */
    public void setIndivMarSt(String indivMarSt) {
        this.indivMarSt = indivMarSt == null ? null : indivMarSt.trim();
    }

    /**
     * 本地居住年限
     * @return LOCAL_YEAR 本地居住年限
     */
    public String getLocalYear() {
        return localYear;
    }

    /**
     * 本地居住年限
     * @param localYear 本地居住年限
     */
    public void setLocalYear(String localYear) {
        this.localYear = localYear == null ? null : localYear.trim();
    }

    /**
     * 申请人手机号
     * @return MOBILE 申请人手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 申请人手机号
     * @param mobile 申请人手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 配偶姓名
     * @return INDIV_SPS_NAME 配偶姓名
     */
    public String getIndivSpsName() {
        return indivSpsName;
    }

    /**
     * 配偶姓名
     * @param indivSpsName 配偶姓名
     */
    public void setIndivSpsName(String indivSpsName) {
        this.indivSpsName = indivSpsName == null ? null : indivSpsName.trim();
    }

    /**
     * 配偶年龄
     * @return INDIV_SPS_AGE 配偶年龄
     */
    public String getIndivSpsAge() {
        return indivSpsAge;
    }

    /**
     * 配偶年龄
     * @param indivSpsAge 配偶年龄
     */
    public void setIndivSpsAge(String indivSpsAge) {
        this.indivSpsAge = indivSpsAge == null ? null : indivSpsAge.trim();
    }

    /**
     * 配偶职业，STD_ZX_EMPLOYMET
     * @return INDIV_SPS_OCC 配偶职业，STD_ZX_EMPLOYMET
     */
    public String getIndivSpsOcc() {
        return indivSpsOcc;
    }

    /**
     * 配偶职业，STD_ZX_EMPLOYMET
     * @param indivSpsOcc 配偶职业，STD_ZX_EMPLOYMET
     */
    public void setIndivSpsOcc(String indivSpsOcc) {
        this.indivSpsOcc = indivSpsOcc == null ? null : indivSpsOcc.trim();
    }

    /**
     * 配偶工作单位
     * @return INDIV_SCOM_NAME 配偶工作单位
     */
    public String getIndivScomName() {
        return indivScomName;
    }

    /**
     * 配偶工作单位
     * @param indivScomName 配偶工作单位
     */
    public void setIndivScomName(String indivScomName) {
        this.indivScomName = indivScomName == null ? null : indivScomName.trim();
    }

    /**
     * 配偶证件类型，STD_ZB_CERT_TYP
     * @return INDIV_SPS_ID_TYP 配偶证件类型，STD_ZB_CERT_TYP
     */
    public String getIndivSpsIdTyp() {
        return indivSpsIdTyp;
    }

    /**
     * 配偶证件类型，STD_ZB_CERT_TYP
     * @param indivSpsIdTyp 配偶证件类型，STD_ZB_CERT_TYP
     */
    public void setIndivSpsIdTyp(String indivSpsIdTyp) {
        this.indivSpsIdTyp = indivSpsIdTyp == null ? null : indivSpsIdTyp.trim();
    }

    /**
     * 配偶证件号码
     * @return INDIV_SPS_ID_CODE 配偶证件号码
     */
    public String getIndivSpsIdCode() {
        return indivSpsIdCode;
    }

    /**
     * 配偶证件号码
     * @param indivSpsIdCode 配偶证件号码
     */
    public void setIndivSpsIdCode(String indivSpsIdCode) {
        this.indivSpsIdCode = indivSpsIdCode == null ? null : indivSpsIdCode.trim();
    }

    /**
     * 配偶手机号（配偶联系方式）
     * @return INDIV_SPS_MPHN 配偶手机号（配偶联系方式）
     */
    public String getIndivSpsMphn() {
        return indivSpsMphn;
    }

    /**
     * 配偶手机号（配偶联系方式）
     * @param indivSpsMphn 配偶手机号（配偶联系方式）
     */
    public void setIndivSpsMphn(String indivSpsMphn) {
        this.indivSpsMphn = indivSpsMphn == null ? null : indivSpsMphn.trim();
    }

    /**
     * 居住住址
     * @return INDIV_RSD_ADDR 居住住址
     */
    public String getIndivRsdAddr() {
        return indivRsdAddr;
    }

    /**
     * 居住住址
     * @param indivRsdAddr 居住住址
     */
    public void setIndivRsdAddr(String indivRsdAddr) {
        this.indivRsdAddr = indivRsdAddr == null ? null : indivRsdAddr.trim();
    }

    /**
     * 居住地址邮编
     * @return INDIV_ZIP_CODE 居住地址邮编
     */
    public String getIndivZipCode() {
        return indivZipCode;
    }

    /**
     * 居住地址邮编
     * @param indivZipCode 居住地址邮编
     */
    public void setIndivZipCode(String indivZipCode) {
        this.indivZipCode = indivZipCode == null ? null : indivZipCode.trim();
    }

    /**
     * 家庭人数
     * @return INDIV_FAM_NUM 家庭人数
     */
    public String getIndivFamNum() {
        return indivFamNum;
    }

    /**
     * 家庭人数
     * @param indivFamNum 家庭人数
     */
    public void setIndivFamNum(String indivFamNum) {
        this.indivFamNum = indivFamNum == null ? null : indivFamNum.trim();
    }

    /**
     * 紧急联系人
     * @return URGENT_PERSON 紧急联系人
     */
    public String getUrgentPerson() {
        return urgentPerson;
    }

    /**
     * 紧急联系人
     * @param urgentPerson 紧急联系人
     */
    public void setUrgentPerson(String urgentPerson) {
        this.urgentPerson = urgentPerson == null ? null : urgentPerson.trim();
    }

    /**
     * 紧急联系人联系方式
     * @return URGENT_CONTACT 紧急联系人联系方式
     */
    public String getUrgentContact() {
        return urgentContact;
    }

    /**
     * 紧急联系人联系方式
     * @param urgentContact 紧急联系人联系方式
     */
    public void setUrgentContact(String urgentContact) {
        this.urgentContact = urgentContact == null ? null : urgentContact.trim();
    }

    /**
     * 居住状况，STD_ZB_RESIDE_STATUS
     * @return INDIV_RSD_ST 居住状况，STD_ZB_RESIDE_STATUS
     */
    public String getIndivRsdSt() {
        return indivRsdSt;
    }

    /**
     * 居住状况，STD_ZB_RESIDE_STATUS
     * @param indivRsdSt 居住状况，STD_ZB_RESIDE_STATUS
     */
    public void setIndivRsdSt(String indivRsdSt) {
        this.indivRsdSt = indivRsdSt == null ? null : indivRsdSt.trim();
    }

    /**
     * 居住状况其它说明，居住状况选择其它时填写
     * @return INDIV_RSD_ST_DETAIL 居住状况其它说明，居住状况选择其它时填写
     */
    public String getIndivRsdStDetail() {
        return indivRsdStDetail;
    }

    /**
     * 居住状况其它说明，居住状况选择其它时填写
     * @param indivRsdStDetail 居住状况其它说明，居住状况选择其它时填写
     */
    public void setIndivRsdStDetail(String indivRsdStDetail) {
        this.indivRsdStDetail = indivRsdStDetail == null ? null : indivRsdStDetail.trim();
    }

    /**
     * 教育程度，STD_ZX_EDU
     * @return EDU_LEVEL 教育程度，STD_ZX_EDU
     */
    public String getEduLevel() {
        return eduLevel;
    }

    /**
     * 教育程度，STD_ZX_EDU
     * @param eduLevel 教育程度，STD_ZX_EDU
     */
    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel == null ? null : eduLevel.trim();
    }

    /**
     * 教育程度其它，教育程度选择其它时填写
     * @return EDU_LEVEL_DETAILS 教育程度其它，教育程度选择其它时填写
     */
    public String getEduLevelDetails() {
        return eduLevelDetails;
    }

    /**
     * 教育程度其它，教育程度选择其它时填写
     * @param eduLevelDetails 教育程度其它，教育程度选择其它时填写
     */
    public void setEduLevelDetails(String eduLevelDetails) {
        this.eduLevelDetails = eduLevelDetails == null ? null : eduLevelDetails.trim();
    }

    /**
     * 最高学历，STD_ZX_EDU
     * @return INDIV_EDT 最高学历，STD_ZX_EDU
     */
    public String getIndivEdt() {
        return indivEdt;
    }

    /**
     * 最高学历，STD_ZX_EDU
     * @param indivEdt 最高学历，STD_ZX_EDU
     */
    public void setIndivEdt(String indivEdt) {
        this.indivEdt = indivEdt == null ? null : indivEdt.trim();
    }

    /**
     * 最高学位，STD_ZX_DEGREE
     * @return INDIV_DGR 最高学位，STD_ZX_DEGREE
     */
    public String getIndivDgr() {
        return indivDgr;
    }

    /**
     * 最高学位，STD_ZX_DEGREE
     * @param indivDgr 最高学位，STD_ZX_DEGREE
     */
    public void setIndivDgr(String indivDgr) {
        this.indivDgr = indivDgr == null ? null : indivDgr.trim();
    }

    /**
     * 工作或经营单位（单位名称、企业名称）
     * @return INDIV_COM_NAME 工作或经营单位（单位名称、企业名称）
     */
    public String getIndivComName() {
        return indivComName;
    }

    /**
     * 工作或经营单位（单位名称、企业名称）
     * @param indivComName 工作或经营单位（单位名称、企业名称）
     */
    public void setIndivComName(String indivComName) {
        this.indivComName = indivComName == null ? null : indivComName.trim();
    }

    /**
     * 职业，STD_ZX_EMPLOYMET
     * @return INDIV_OCC 职业，STD_ZX_EMPLOYMET
     */
    public String getIndivOcc() {
        return indivOcc;
    }

    /**
     * 职业，STD_ZX_EMPLOYMET
     * @param indivOcc 职业，STD_ZX_EMPLOYMET
     */
    public void setIndivOcc(String indivOcc) {
        this.indivOcc = indivOcc == null ? null : indivOcc.trim();
    }

    /**
     * 职务，STD_ZX_DUTY
     * @return INDIV_COM_JOB_TTL 职务，STD_ZX_DUTY
     */
    public String getIndivComJobTtl() {
        return indivComJobTtl;
    }

    /**
     * 职务，STD_ZX_DUTY
     * @param indivComJobTtl 职务，STD_ZX_DUTY
     */
    public void setIndivComJobTtl(String indivComJobTtl) {
        this.indivComJobTtl = indivComJobTtl == null ? null : indivComJobTtl.trim();
    }

    /**
     * 企业（单位）所属行业名称
     * @return INDIV_CLL_NAME 企业（单位）所属行业名称
     */
    public String getIndivCllName() {
        return indivCllName;
    }

    /**
     * 企业（单位）所属行业名称
     * @param indivCllName 企业（单位）所属行业名称
     */
    public void setIndivCllName(String indivCllName) {
        this.indivCllName = indivCllName == null ? null : indivCllName.trim();
    }

    /**
     * 单位所属行业
     * @return INDIV_CLL_ID 单位所属行业
     */
    public String getIndivCllId() {
        return indivCllId;
    }

    /**
     * 单位所属行业
     * @param indivCllId 单位所属行业
     */
    public void setIndivCllId(String indivCllId) {
        this.indivCllId = indivCllId == null ? null : indivCllId.trim();
    }

    /**
     * 企业（单位）地址
     * @return INDIV_COM_ADDR 企业（单位）地址
     */
    public String getIndivComAddr() {
        return indivComAddr;
    }

    /**
     * 企业（单位）地址
     * @param indivComAddr 企业（单位）地址
     */
    public void setIndivComAddr(String indivComAddr) {
        this.indivComAddr = indivComAddr == null ? null : indivComAddr.trim();
    }

    /**
     * 企业（单位）地址邮编
     * @return INDIV_COM_ZIP_CODE 企业（单位）地址邮编
     */
    public String getIndivComZipCode() {
        return indivComZipCode;
    }

    /**
     * 企业（单位）地址邮编
     * @param indivComZipCode 企业（单位）地址邮编
     */
    public void setIndivComZipCode(String indivComZipCode) {
        this.indivComZipCode = indivComZipCode == null ? null : indivComZipCode.trim();
    }

    /**
     * 开业时间
     * @return OPEN_DATE 开业时间
     */
    public String getOpenDate() {
        return openDate;
    }

    /**
     * 开业时间
     * @param openDate 开业时间
     */
    public void setOpenDate(String openDate) {
        this.openDate = openDate == null ? null : openDate.trim();
    }

    /**
     * 经营年限
     * @return OPER_YEARS 经营年限
     */
    public String getOperYears() {
        return operYears;
    }

    /**
     * 经营年限
     * @param operYears 经营年限
     */
    public void setOperYears(String operYears) {
        this.operYears = operYears == null ? null : operYears.trim();
    }

    /**
     * 雇员人数
     * @return EMPLOYEE_NUM 雇员人数
     */
    public String getEmployeeNum() {
        return employeeNum;
    }

    /**
     * 雇员人数
     * @param employeeNum 雇员人数
     */
    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum == null ? null : employeeNum.trim();
    }

    /**
     * 经营场所
     * @return OPER_PLACE 经营场所
     */
    public String getOperPlace() {
        return operPlace;
    }

    /**
     * 经营场所
     * @param operPlace 经营场所
     */
    public void setOperPlace(String operPlace) {
        this.operPlace = operPlace == null ? null : operPlace.trim();
    }

    /**
     * 经营场所面积
     * @return OPER_AREA 经营场所面积
     */
    public String getOperArea() {
        return operArea;
    }

    /**
     * 经营场所面积
     * @param operArea 经营场所面积
     */
    public void setOperArea(String operArea) {
        this.operArea = operArea == null ? null : operArea.trim();
    }

    /**
     * 经营场所房租
     * @return OPER_RENT 经营场所房租
     */
    public BigDecimal getOperRent() {
        return operRent;
    }

    /**
     * 经营场所房租
     * @param operRent 经营场所房租
     */
    public void setOperRent(BigDecimal operRent) {
        this.operRent = operRent;
    }

    /**
     * 主银行卡开户机构，填写行名
     * @return MAIN_BANK_NAME 主银行卡开户机构，填写行名
     */
    public String getMainBankName() {
        return mainBankName;
    }

    /**
     * 主银行卡开户机构，填写行名
     * @param mainBankName 主银行卡开户机构，填写行名
     */
    public void setMainBankName(String mainBankName) {
        this.mainBankName = mainBankName == null ? null : mainBankName.trim();
    }

    /**
     * 有无贷款卡
     * @return LOAN_CARD_FLG 有无贷款卡
     */
    public String getLoanCardFlg() {
        return loanCardFlg;
    }

    /**
     * 有无贷款卡
     * @param loanCardFlg 有无贷款卡
     */
    public void setLoanCardFlg(String loanCardFlg) {
        this.loanCardFlg = loanCardFlg == null ? null : loanCardFlg.trim();
    }

    /**
     * 贷款卡号
     * @return COM_INV_LOAN_CARD 贷款卡号
     */
    public String getComInvLoanCard() {
        return comInvLoanCard;
    }

    /**
     * 贷款卡号
     * @param comInvLoanCard 贷款卡号
     */
    public void setComInvLoanCard(String comInvLoanCard) {
        this.comInvLoanCard = comInvLoanCard == null ? null : comInvLoanCard.trim();
    }

    /**
     * 最近一年销售额
     * @return SELL_LIMIT 最近一年销售额
     */
    public BigDecimal getSellLimit() {
        return sellLimit;
    }

    /**
     * 最近一年销售额
     * @param sellLimit 最近一年销售额
     */
    public void setSellLimit(BigDecimal sellLimit) {
        this.sellLimit = sellLimit;
    }

    /**
     * 毛利率
     * @return GROSS_RATE 毛利率
     */
    public BigDecimal getGrossRate() {
        return grossRate;
    }

    /**
     * 毛利率
     * @param grossRate 毛利率
     */
    public void setGrossRate(BigDecimal grossRate) {
        this.grossRate = grossRate;
    }

    /**
     * 最近一年除去所有开支净利
     * @return RETAINED_PROFITS 最近一年除去所有开支净利
     */
    public BigDecimal getRetainedProfits() {
        return retainedProfits;
    }

    /**
     * 最近一年除去所有开支净利
     * @param retainedProfits 最近一年除去所有开支净利
     */
    public void setRetainedProfits(BigDecimal retainedProfits) {
        this.retainedProfits = retainedProfits;
    }

    /**
     * 存货
     * @return STOCK 存货
     */
    public BigDecimal getStock() {
        return stock;
    }

    /**
     * 存货
     * @param stock 存货
     */
    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    /**
     * 应收账款
     * @return RECEIVABLE_DEBT 应收账款
     */
    public BigDecimal getReceivableDebt() {
        return receivableDebt;
    }

    /**
     * 应收账款
     * @param receivableDebt 应收账款
     */
    public void setReceivableDebt(BigDecimal receivableDebt) {
        this.receivableDebt = receivableDebt;
    }

    /**
     * 负债
     * @return LIABILITIES 负债
     */
    public BigDecimal getLiabilities() {
        return liabilities;
    }

    /**
     * 负债
     * @param liabilities 负债
     */
    public void setLiabilities(BigDecimal liabilities) {
        this.liabilities = liabilities;
    }

    /**
     * 总资产
     * @return TOTAL_MEANS 总资产
     */
    public BigDecimal getTotalMeans() {
        return totalMeans;
    }

    /**
     * 总资产
     * @param totalMeans 总资产
     */
    public void setTotalMeans(BigDecimal totalMeans) {
        this.totalMeans = totalMeans;
    }

    /**
     * 家庭收入
     * @return FAM_MEANS 家庭收入
     */
    public BigDecimal getFamMeans() {
        return famMeans;
    }

    /**
     * 家庭收入
     * @param famMeans 家庭收入
     */
    public void setFamMeans(BigDecimal famMeans) {
        this.famMeans = famMeans;
    }

    /**
     * 其他收入
     * @return OTHER_INCOME 其他收入
     */
    public BigDecimal getOtherIncome() {
        return otherIncome;
    }

    /**
     * 其他收入
     * @param otherIncome 其他收入
     */
    public void setOtherIncome(BigDecimal otherIncome) {
        this.otherIncome = otherIncome;
    }

    /**
     * 经营模式及上下游供应关系
     * @return OPER_RELATE 经营模式及上下游供应关系
     */
    public String getOperRelate() {
        return operRelate;
    }

    /**
     * 经营模式及上下游供应关系
     * @param operRelate 经营模式及上下游供应关系
     */
    public void setOperRelate(String operRelate) {
        this.operRelate = operRelate == null ? null : operRelate.trim();
    }

    /**
     * 是否在本行申请贷款
     * @return IS_CDRCB_LOAN 是否在本行申请贷款
     */
    public String getIsCdrcbLoan() {
        return isCdrcbLoan;
    }

    /**
     * 是否在本行申请贷款
     * @param isCdrcbLoan 是否在本行申请贷款
     */
    public void setIsCdrcbLoan(String isCdrcbLoan) {
        this.isCdrcbLoan = isCdrcbLoan == null ? null : isCdrcbLoan.trim();
    }

    /**
     * 存量贷款申请时间
     * @return CDRCB_LOAN_DATE 存量贷款申请时间
     */
    public String getCdrcbLoanDate() {
        return cdrcbLoanDate;
    }

    /**
     * 存量贷款申请时间
     * @param cdrcbLoanDate 存量贷款申请时间
     */
    public void setCdrcbLoanDate(String cdrcbLoanDate) {
        this.cdrcbLoanDate = cdrcbLoanDate == null ? null : cdrcbLoanDate.trim();
    }

    /**
     * 关联方是否在本行申请贷款
     * @return RELATE_CDRCB_LOAN 关联方是否在本行申请贷款
     */
    public String getRelateCdrcbLoan() {
        return relateCdrcbLoan;
    }

    /**
     * 关联方是否在本行申请贷款
     * @param relateCdrcbLoan 关联方是否在本行申请贷款
     */
    public void setRelateCdrcbLoan(String relateCdrcbLoan) {
        this.relateCdrcbLoan = relateCdrcbLoan == null ? null : relateCdrcbLoan.trim();
    }

    /**
     * 关联方姓名
     * @return RELATE_NAME 关联方姓名
     */
    public String getRelateName() {
        return relateName;
    }

    /**
     * 关联方姓名
     * @param relateName 关联方姓名
     */
    public void setRelateName(String relateName) {
        this.relateName = relateName == null ? null : relateName.trim();
    }

    /**
     * 关系类型，STD_ZB_GRP_CO_TYPE
     * @return RELATE_TYPE 关系类型，STD_ZB_GRP_CO_TYPE
     */
    public String getRelateType() {
        return relateType;
    }

    /**
     * 关系类型，STD_ZB_GRP_CO_TYPE
     * @param relateType 关系类型，STD_ZB_GRP_CO_TYPE
     */
    public void setRelateType(String relateType) {
        this.relateType = relateType == null ? null : relateType.trim();
    }

    /**
     * 组织形式： 个体户，法律实体
     * @return ORG_TYPE 组织形式： 个体户，法律实体
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * 组织形式： 个体户，法律实体
     * @param orgType 组织形式： 个体户，法律实体
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    /**
     * 联保协议编号
     * @return ASSURE_AGREE_NO 联保协议编号
     */
    public String getAssureAgreeNo() {
        return assureAgreeNo;
    }

    /**
     * 联保协议编号
     * @param assureAgreeNo 联保协议编号
     */
    public void setAssureAgreeNo(String assureAgreeNo) {
        this.assureAgreeNo = assureAgreeNo == null ? null : assureAgreeNo.trim();
    }

    /**
     * 是否联保小组组长
     * @return IS_HEADMAN 是否联保小组组长
     */
    public String getIsHeadman() {
        return isHeadman;
    }

    /**
     * 是否联保小组组长
     * @param isHeadman 是否联保小组组长
     */
    public void setIsHeadman(String isHeadman) {
        this.isHeadman = isHeadman == null ? null : isHeadman.trim();
    }

    /**
     * 保证金缴存额度
     * @return ASSURE_AMOUNT 保证金缴存额度
     */
    public BigDecimal getAssureAmount() {
        return assureAmount;
    }

    /**
     * 保证金缴存额度
     * @param assureAmount 保证金缴存额度
     */
    public void setAssureAmount(BigDecimal assureAmount) {
        this.assureAmount = assureAmount;
    }

    /**
     * 通讯地址邮编
     * @return POST_CODE 通讯地址邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 通讯地址邮编
     * @param postCode 通讯地址邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * 通讯地址
     * @return POST_ADDR 通讯地址
     */
    public String getPostAddr() {
        return postAddr;
    }

    /**
     * 通讯地址
     * @param postAddr 通讯地址
     */
    public void setPostAddr(String postAddr) {
        this.postAddr = postAddr == null ? null : postAddr.trim();
    }

    /**
     * 毛利润
     * @return GROSS_PROFIT 毛利润
     */
    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    /**
     * 毛利润
     * @param grossProfit 毛利润
     */
    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    /**
     * 家庭电话
     * @return INDIV_FAM_PHONE 家庭电话
     */
    public String getIndivFamPhone() {
        return indivFamPhone;
    }

    /**
     * 家庭电话
     * @param indivFamPhone 家庭电话
     */
    public void setIndivFamPhone(String indivFamPhone) {
        this.indivFamPhone = indivFamPhone == null ? null : indivFamPhone.trim();
    }

    /**
     * 职称
     * @return INDIV_COM_JOB_JB 职称
     */
    public String getIndivComJobJb() {
        return indivComJobJb;
    }

    /**
     * 职称
     * @param indivComJobJb 职称
     */
    public void setIndivComJobJb(String indivComJobJb) {
        this.indivComJobJb = indivComJobJb == null ? null : indivComJobJb.trim();
    }

    /**
     * 营业执照
     * @return OPER_NO 营业执照
     */
    public String getOperNo() {
        return operNo;
    }

    /**
     * 营业执照
     * @param operNo 营业执照
     */
    public void setOperNo(String operNo) {
        this.operNo = operNo == null ? null : operNo.trim();
    }

    /**
     * 经营地址
     * @return OPER_ADDR 经营地址
     */
    public String getOperAddr() {
        return operAddr;
    }

    /**
     * 经营地址
     * @param operAddr 经营地址
     */
    public void setOperAddr(String operAddr) {
        this.operAddr = operAddr == null ? null : operAddr.trim();
    }

    /**
     * 主营业务
     * @return OPER_JOB 主营业务
     */
    public String getOperJob() {
        return operJob;
    }

    /**
     * 主营业务
     * @param operJob 主营业务
     */
    public void setOperJob(String operJob) {
        this.operJob = operJob == null ? null : operJob.trim();
    }

    /**
     * 所属行业
     * @return OPER_NAME 所属行业
     */
    public String getOperName() {
        return operName;
    }

    /**
     * 所属行业
     * @param operName 所属行业
     */
    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    /**
     * 经营历史
     * @return OPER_HIST 经营历史
     */
    public String getOperHist() {
        return operHist;
    }

    /**
     * 经营历史
     * @param operHist 经营历史
     */
    public void setOperHist(String operHist) {
        this.operHist = operHist == null ? null : operHist.trim();
    }

    /**
     * 评价财务信息
     * @return DESC1 评价财务信息
     */
    public String getDesc1() {
        return desc1;
    }

    /**
     * 评价财务信息
     * @param desc1 评价财务信息
     */
    public void setDesc1(String desc1) {
        this.desc1 = desc1 == null ? null : desc1.trim();
    }

    /**
     * 行业资金需求
     * @return DESC2 行业资金需求
     */
    public String getDesc2() {
        return desc2;
    }

    /**
     * 行业资金需求
     * @param desc2 行业资金需求
     */
    public void setDesc2(String desc2) {
        this.desc2 = desc2 == null ? null : desc2.trim();
    }

    /**
     * 客户在家庭或在社会经济网中的状况
     * @return DESC3 客户在家庭或在社会经济网中的状况
     */
    public String getDesc3() {
        return desc3;
    }

    /**
     * 客户在家庭或在社会经济网中的状况
     * @param desc3 客户在家庭或在社会经济网中的状况
     */
    public void setDesc3(String desc3) {
        this.desc3 = desc3 == null ? null : desc3.trim();
    }

    /**
     * 有无房产
     * @return IS_HOUSE 有无房产
     */
    public String getIsHouse() {
        return isHouse;
    }

    /**
     * 有无房产
     * @param isHouse 有无房产
     */
    public void setIsHouse(String isHouse) {
        this.isHouse = isHouse == null ? null : isHouse.trim();
    }

    /**
     * 房产位置
     * @return HOUSE_ADDR 房产位置
     */
    public String getHouseAddr() {
        return houseAddr;
    }

    /**
     * 房产位置
     * @param houseAddr 房产位置
     */
    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr == null ? null : houseAddr.trim();
    }

    /**
     * 房产面积
     * @return HOUSE_AREA 房产面积
     */
    public String getHouseArea() {
        return houseArea;
    }

    /**
     * 房产面积
     * @param houseArea 房产面积
     */
    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea == null ? null : houseArea.trim();
    }

    /**
     * 房产原价
     * @return HOUSE_ORI_VALUE 房产原价
     */
    public BigDecimal getHouseOriValue() {
        return houseOriValue;
    }

    /**
     * 房产原价
     * @param houseOriValue 房产原价
     */
    public void setHouseOriValue(BigDecimal houseOriValue) {
        this.houseOriValue = houseOriValue;
    }

    /**
     * 房产现值
     * @return HOUSE_NOW_VALUE 房产现值
     */
    public BigDecimal getHouseNowValue() {
        return houseNowValue;
    }

    /**
     * 房产现值
     * @param houseNowValue 房产现值
     */
    public void setHouseNowValue(BigDecimal houseNowValue) {
        this.houseNowValue = houseNowValue;
    }

    /**
     * 购买时间
     * @return HOUSE_BUY_DATE 购买时间
     */
    public String getHouseBuyDate() {
        return houseBuyDate;
    }

    /**
     * 购买时间
     * @param houseBuyDate 购买时间
     */
    public void setHouseBuyDate(String houseBuyDate) {
        this.houseBuyDate = houseBuyDate == null ? null : houseBuyDate.trim();
    }

    /**
     * 其它资产
     * @return DESC_OTHER_PRO 其它资产
     */
    public String getDescOtherPro() {
        return descOtherPro;
    }

    /**
     * 其它资产
     * @param descOtherPro 其它资产
     */
    public void setDescOtherPro(String descOtherPro) {
        this.descOtherPro = descOtherPro == null ? null : descOtherPro.trim();
    }

    /**
     * IS_CENT_BANK_GZ
     * @return IS_CENT_BANK_GZ IS_CENT_BANK_GZ
     */
    public String getIsCentBankGz() {
        return isCentBankGz;
    }

    /**
     * IS_CENT_BANK_GZ
     * @param isCentBankGz IS_CENT_BANK_GZ
     */
    public void setIsCentBankGz(String isCentBankGz) {
        this.isCentBankGz = isCentBankGz == null ? null : isCentBankGz.trim();
    }

    /**
     * JL
     * @return JL JL
     */
    public String getJl() {
        return jl;
    }

    /**
     * JL
     * @param jl JL
     */
    public void setJl(String jl) {
        this.jl = jl == null ? null : jl.trim();
    }

    /**
     * XDLS
     * @return XDLS XDLS
     */
    public String getXdls() {
        return xdls;
    }

    /**
     * XDLS
     * @param xdls XDLS
     */
    public void setXdls(String xdls) {
        this.xdls = xdls == null ? null : xdls.trim();
    }

    /**
     * 配偶工作名称
     * @return INDIV_SPS_WORK_NAME 配偶工作名称
     */
    public String getIndivSpsWorkName() {
        return indivSpsWorkName;
    }

    /**
     * 配偶工作名称
     * @param indivSpsWorkName 配偶工作名称
     */
    public void setIndivSpsWorkName(String indivSpsWorkName) {
        this.indivSpsWorkName = indivSpsWorkName == null ? null : indivSpsWorkName.trim();
    }

    /**
     * 配偶的经营地址或者工作地址
     * @return INDIV_SPS_WORK_ADDR 配偶的经营地址或者工作地址
     */
    public String getIndivSpsWorkAddr() {
        return indivSpsWorkAddr;
    }

    /**
     * 配偶的经营地址或者工作地址
     * @param indivSpsWorkAddr 配偶的经营地址或者工作地址
     */
    public void setIndivSpsWorkAddr(String indivSpsWorkAddr) {
        this.indivSpsWorkAddr = indivSpsWorkAddr == null ? null : indivSpsWorkAddr.trim();
    }

    /**
     * indiv_sps_rst_st
     * @return INDIV_SPS_RST_ST indiv_sps_rst_st
     */
    public String getIndivSpsRstSt() {
        return indivSpsRstSt;
    }

    /**
     * indiv_sps_rst_st
     * @param indivSpsRstSt indiv_sps_rst_st
     */
    public void setIndivSpsRstSt(String indivSpsRstSt) {
        this.indivSpsRstSt = indivSpsRstSt == null ? null : indivSpsRstSt.trim();
    }

    /**
     * POST_SPS_CODE
     * @return POST_SPS_CODE POST_SPS_CODE
     */
    public String getPostSpsCode() {
        return postSpsCode;
    }

    /**
     * POST_SPS_CODE
     * @param postSpsCode POST_SPS_CODE
     */
    public void setPostSpsCode(String postSpsCode) {
        this.postSpsCode = postSpsCode == null ? null : postSpsCode.trim();
    }

    /**
     * 居住地址
     * @return INDIV_SPS_RSD_ADDR 居住地址
     */
    public String getIndivSpsRsdAddr() {
        return indivSpsRsdAddr;
    }

    /**
     * 居住地址
     * @param indivSpsRsdAddr 居住地址
     */
    public void setIndivSpsRsdAddr(String indivSpsRsdAddr) {
        this.indivSpsRsdAddr = indivSpsRsdAddr == null ? null : indivSpsRsdAddr.trim();
    }

    /**
     * 家访情况
     * @return ASK_STATUS 家访情况
     */
    public String getAskStatus() {
        return askStatus;
    }

    /**
     * 家访情况
     * @param askStatus 家访情况
     */
    public void setAskStatus(String askStatus) {
        this.askStatus = askStatus == null ? null : askStatus.trim();
    }

    /**
     * 评价经营组织和市场情况
     * @return DESC0 评价经营组织和市场情况
     */
    public String getDesc0() {
        return desc0;
    }

    /**
     * 评价经营组织和市场情况
     * @param desc0 评价经营组织和市场情况
     */
    public void setDesc0(String desc0) {
        this.desc0 = desc0 == null ? null : desc0.trim();
    }

    /**
     * 房产类型
     * @return HOUSE_TYPE 房产类型
     */
    public String getHouseType() {
        return houseType;
    }

    /**
     * 房产类型
     * @param houseType 房产类型
     */
    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    /**
     * 单户金额
     * @return ALL_AMOUNT 单户金额
     */
    public BigDecimal getAllAmount() {
        return allAmount;
    }

    /**
     * 单户金额
     * @param allAmount 单户金额
     */
    public void setAllAmount(BigDecimal allAmount) {
        this.allAmount = allAmount;
    }

    /**
     * 户籍地址
     * @return INDIV_BRT_PLACE 户籍地址
     */
    public String getIndivBrtPlace() {
        return indivBrtPlace;
    }

    /**
     * 户籍地址
     * @param indivBrtPlace 户籍地址
     */
    public void setIndivBrtPlace(String indivBrtPlace) {
        this.indivBrtPlace = indivBrtPlace == null ? null : indivBrtPlace.trim();
    }

    /**
     * 证件起始日期
     * @return INDIV_SPS_ID_START_DATE 证件起始日期
     */
    public String getIndivSpsIdStartDate() {
        return indivSpsIdStartDate;
    }

    /**
     * 证件起始日期
     * @param indivSpsIdStartDate 证件起始日期
     */
    public void setIndivSpsIdStartDate(String indivSpsIdStartDate) {
        this.indivSpsIdStartDate = indivSpsIdStartDate == null ? null : indivSpsIdStartDate.trim();
    }

    /**
     * 证件到期日期
     * @return INDIV_SPS_ID_END_DATE 证件到期日期
     */
    public String getIndivSpsIdEndDate() {
        return indivSpsIdEndDate;
    }

    /**
     * 证件到期日期
     * @param indivSpsIdEndDate 证件到期日期
     */
    public void setIndivSpsIdEndDate(String indivSpsIdEndDate) {
        this.indivSpsIdEndDate = indivSpsIdEndDate == null ? null : indivSpsIdEndDate.trim();
    }

    /**
     * 紧急联系人与申请人关系
     * @return URGENT_PERSON_CUS_REL 紧急联系人与申请人关系
     */
    public String getUrgentPersonCusRel() {
        return urgentPersonCusRel;
    }

    /**
     * 紧急联系人与申请人关系
     * @param urgentPersonCusRel 紧急联系人与申请人关系
     */
    public void setUrgentPersonCusRel(String urgentPersonCusRel) {
        this.urgentPersonCusRel = urgentPersonCusRel == null ? null : urgentPersonCusRel.trim();
    }

    /**
     * 年龄
     * @return INDIV_AGE 年龄
     */
    public String getIndivAge() {
        return indivAge;
    }

    /**
     * 年龄
     * @param indivAge 年龄
     */
    public void setIndivAge(String indivAge) {
        this.indivAge = indivAge == null ? null : indivAge.trim();
    }

    /**
     * 是否本地户口
     * @return IS_NATIVE 是否本地户口
     */
    public String getIsNative() {
        return isNative;
    }

    /**
     * 是否本地户口
     * @param isNative 是否本地户口
     */
    public void setIsNative(String isNative) {
        this.isNative = isNative == null ? null : isNative.trim();
    }

    /**
     * 配偶具体信息
     * @return INDIV_SPS_SPC_INFOR 配偶具体信息
     */
    public String getIndivSpsSpcInfor() {
        return indivSpsSpcInfor;
    }

    /**
     * 配偶具体信息
     * @param indivSpsSpcInfor 配偶具体信息
     */
    public void setIndivSpsSpcInfor(String indivSpsSpcInfor) {
        this.indivSpsSpcInfor = indivSpsSpcInfor == null ? null : indivSpsSpcInfor.trim();
    }

    /**
     * 子女信息
     * @return CHILDREN_INFOR 子女信息
     */
    public String getChildrenInfor() {
        return childrenInfor;
    }

    /**
     * 子女信息
     * @param childrenInfor 子女信息
     */
    public void setChildrenInfor(String childrenInfor) {
        this.childrenInfor = childrenInfor == null ? null : childrenInfor.trim();
    }

    /**
     * 子女具体信息
     * @return CHILDREN_SPC_INFOR 子女具体信息
     */
    public String getChildrenSpcInfor() {
        return childrenSpcInfor;
    }

    /**
     * 子女具体信息
     * @param childrenSpcInfor 子女具体信息
     */
    public void setChildrenSpcInfor(String childrenSpcInfor) {
        this.childrenSpcInfor = childrenSpcInfor == null ? null : childrenSpcInfor.trim();
    }

    /**
     * 企业/生意名称
     * @return BUSIN_NAME 企业/生意名称
     */
    public String getBusinName() {
        return businName;
    }

    /**
     * 企业/生意名称
     * @param businName 企业/生意名称
     */
    public void setBusinName(String businName) {
        this.businName = businName == null ? null : businName.trim();
    }

    /**
     * 注册经营人/法人代表
     * @return LEGAL_NAME 注册经营人/法人代表
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * 注册经营人/法人代表
     * @param legalName 注册经营人/法人代表
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    /**
     * 固定电话
     * @return TELEPHONE 固定电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 固定电话
     * @param telephone 固定电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 其他经营
     * @return OPER_OTHER 其他经营
     */
    public String getOperOther() {
        return operOther;
    }

    /**
     * 其他经营
     * @param operOther 其他经营
     */
    public void setOperOther(String operOther) {
        this.operOther = operOther == null ? null : operOther.trim();
    }

    /**
     * 下游关系
     * @return OPER_LOW_RELATE 下游关系
     */
    public String getOperLowRelate() {
        return operLowRelate;
    }

    /**
     * 下游关系
     * @param operLowRelate 下游关系
     */
    public void setOperLowRelate(String operLowRelate) {
        this.operLowRelate = operLowRelate == null ? null : operLowRelate.trim();
    }

    /**
     * 家庭资产所有人
     * @return ASSETS_OWNER 家庭资产所有人
     */
    public String getAssetsOwner() {
        return assetsOwner;
    }

    /**
     * 家庭资产所有人
     * @param assetsOwner 家庭资产所有人
     */
    public void setAssetsOwner(String assetsOwner) {
        this.assetsOwner = assetsOwner == null ? null : assetsOwner.trim();
    }

    /**
     * 客户信息收集核实
     * @return CUS_INFOR_VERIFY 客户信息收集核实
     */
    public String getCusInforVerify() {
        return cusInforVerify;
    }

    /**
     * 客户信息收集核实
     * @param cusInforVerify 客户信息收集核实
     */
    public void setCusInforVerify(String cusInforVerify) {
        this.cusInforVerify = cusInforVerify == null ? null : cusInforVerify.trim();
    }

    /**
     * 表外项目
     * @return OFF_ITEM 表外项目
     */
    public String getOffItem() {
        return offItem;
    }

    /**
     * 表外项目
     * @param offItem 表外项目
     */
    public void setOffItem(String offItem) {
        this.offItem = offItem == null ? null : offItem.trim();
    }

    /**
     * 居住地址区划名称
     * @return INDIV_RSD_PLE 居住地址区划名称
     */
    public String getIndivRsdPle() {
        return indivRsdPle;
    }

    /**
     * 居住地址区划名称
     * @param indivRsdPle 居住地址区划名称
     */
    public void setIndivRsdPle(String indivRsdPle) {
        this.indivRsdPle = indivRsdPle == null ? null : indivRsdPle.trim();
    }

    /**
     * 居住地址行政区划
     * @return INDIV_RSD_PLE_ID 居住地址行政区划
     */
    public String getIndivRsdPleId() {
        return indivRsdPleId;
    }

    /**
     * 居住地址行政区划
     * @param indivRsdPleId 居住地址行政区划
     */
    public void setIndivRsdPleId(String indivRsdPleId) {
        this.indivRsdPleId = indivRsdPleId == null ? null : indivRsdPleId.trim();
    }

    /**
     * 管理结构图
     * @return MANAGEMENT_STRUCTURE 管理结构图
     */
    public String getManagementStructure() {
        return managementStructure;
    }

    /**
     * 管理结构图
     * @param managementStructure 管理结构图
     */
    public void setManagementStructure(String managementStructure) {
        this.managementStructure = managementStructure == null ? null : managementStructure.trim();
    }

    /**
     * 生产加工流程图
     * @return WORK_FLOW 生产加工流程图
     */
    public String getWorkFlow() {
        return workFlow;
    }

    /**
     * 生产加工流程图
     * @param workFlow 生产加工流程图
     */
    public void setWorkFlow(String workFlow) {
        this.workFlow = workFlow == null ? null : workFlow.trim();
    }

    /**
     * 证件有效期
     * @return INDIV_ID_LONG 证件有效期
     */
    public String getIndivIdLong() {
        return indivIdLong;
    }

    /**
     * 证件有效期
     * @param indivIdLong 证件有效期
     */
    public void setIndivIdLong(String indivIdLong) {
        this.indivIdLong = indivIdLong == null ? null : indivIdLong.trim();
    }

    /**
     * 经营年限(月)
     * @return OPER_MONTHS 经营年限(月)
     */
    public String getOperMonths() {
        return operMonths;
    }

    /**
     * 经营年限(月)
     * @param operMonths 经营年限(月)
     */
    public void setOperMonths(String operMonths) {
        this.operMonths = operMonths == null ? null : operMonths.trim();
    }

    /**
     * 单位电话
     * @return INDIV_COM_PHN 单位电话
     */
    public String getIndivComPhn() {
        return indivComPhn;
    }

    /**
     * 单位电话
     * @param indivComPhn 单位电话
     */
    public void setIndivComPhn(String indivComPhn) {
        this.indivComPhn = indivComPhn == null ? null : indivComPhn.trim();
    }

    /**
     * 单位工作起始年
     * @return INDIV_WORK_JOB_Y 单位工作起始年
     */
    public String getIndivWorkJobY() {
        return indivWorkJobY;
    }

    /**
     * 单位工作起始年
     * @param indivWorkJobY 单位工作起始年
     */
    public void setIndivWorkJobY(String indivWorkJobY) {
        this.indivWorkJobY = indivWorkJobY == null ? null : indivWorkJobY.trim();
    }

    /**
     * 单位所属行业
     * @return INDIV_COM_FLD 单位所属行业
     */
    public String getIndivComFld() {
        return indivComFld;
    }

    /**
     * 单位所属行业
     * @param indivComFld 单位所属行业
     */
    public void setIndivComFld(String indivComFld) {
        this.indivComFld = indivComFld == null ? null : indivComFld.trim();
    }

    /**
     * 单位性质
     * @return INDIV_COM_TYP 单位性质
     */
    public String getIndivComTyp() {
        return indivComTyp;
    }

    /**
     * 单位性质
     * @param indivComTyp 单位性质
     */
    public void setIndivComTyp(String indivComTyp) {
        this.indivComTyp = indivComTyp == null ? null : indivComTyp.trim();
    }

    /**
     * 户籍地址区划名称
     * @return INDIV_BRT_PLE 户籍地址区划名称
     */
    public String getIndivBrtPle() {
        return indivBrtPle;
    }

    /**
     * 户籍地址区划名称
     * @param indivBrtPle 户籍地址区划名称
     */
    public void setIndivBrtPle(String indivBrtPle) {
        this.indivBrtPle = indivBrtPle == null ? null : indivBrtPle.trim();
    }

    /**
     * 户籍地址行政区划
     * @return INDIV_BRT_PLE_ID 户籍地址行政区划
     */
    public String getIndivBrtPleId() {
        return indivBrtPleId;
    }

    /**
     * 户籍地址行政区划
     * @param indivBrtPleId 户籍地址行政区划
     */
    public void setIndivBrtPleId(String indivBrtPleId) {
        this.indivBrtPleId = indivBrtPleId == null ? null : indivBrtPleId.trim();
    }

    /**
     * 户籍是否为申请所在地
     * @return IS_BRT_LOCAL 户籍是否为申请所在地
     */
    public String getIsBrtLocal() {
        return isBrtLocal;
    }

    /**
     * 户籍是否为申请所在地
     * @param isBrtLocal 户籍是否为申请所在地
     */
    public void setIsBrtLocal(String isBrtLocal) {
        this.isBrtLocal = isBrtLocal == null ? null : isBrtLocal.trim();
    }

    /**
     * 国籍
     * @return COM_COUNTRY 国籍
     */
    public String getComCountry() {
        return comCountry;
    }

    /**
     * 国籍
     * @param comCountry 国籍
     */
    public void setComCountry(String comCountry) {
        this.comCountry = comCountry == null ? null : comCountry.trim();
    }

    /**
     * 现住房面积
     * @return HOUSING_AREA 现住房面积
     */
    public String getHousingArea() {
        return housingArea;
    }

    /**
     * 现住房面积
     * @param housingArea 现住房面积
     */
    public void setHousingArea(String housingArea) {
        this.housingArea = housingArea == null ? null : housingArea.trim();
    }

    /**
     * 现址入住时间
     * @return HOUSING_DATE 现址入住时间
     */
    public String getHousingDate() {
        return housingDate;
    }

    /**
     * 现址入住时间
     * @param housingDate 现址入住时间
     */
    public void setHousingDate(String housingDate) {
        this.housingDate = housingDate == null ? null : housingDate.trim();
    }

    /**
     * 信息来源
     * @return INFORMATION_SOURCE 信息来源
     */
    public String getInformationSource() {
        return informationSource;
    }

    /**
     * 信息来源
     * @param informationSource 信息来源
     */
    public void setInformationSource(String informationSource) {
        this.informationSource = informationSource == null ? null : informationSource.trim();
    }

    /**
     * 社保卡卡号
     * @return SOC_SCR_NO 社保卡卡号
     */
    public String getSocScrNo() {
        return socScrNo;
    }

    /**
     * 社保卡卡号
     * @param socScrNo 社保卡卡号
     */
    public void setSocScrNo(String socScrNo) {
        this.socScrNo = socScrNo == null ? null : socScrNo.trim();
    }

    /**
     * 居住省省会城市固话区号
     * @return PROV_AREA_CODE 居住省省会城市固话区号
     */
    public String getProvAreaCode() {
        return provAreaCode;
    }

    /**
     * 居住省省会城市固话区号
     * @param provAreaCode 居住省省会城市固话区号
     */
    public void setProvAreaCode(String provAreaCode) {
        this.provAreaCode = provAreaCode == null ? null : provAreaCode.trim();
    }

    /**
     * 户口所属城市固话区号
     * @return REG_RES_AREA_CODE 户口所属城市固话区号
     */
    public String getRegResAreaCode() {
        return regResAreaCode;
    }

    /**
     * 户口所属城市固话区号
     * @param regResAreaCode 户口所属城市固话区号
     */
    public void setRegResAreaCode(String regResAreaCode) {
        this.regResAreaCode = regResAreaCode == null ? null : regResAreaCode.trim();
    }

    /**
     * 手机号码归属地
     * @return MOBILE_ATTRIBUTION 手机号码归属地
     */
    public String getMobileAttribution() {
        return mobileAttribution;
    }

    /**
     * 手机号码归属地
     * @param mobileAttribution 手机号码归属地
     */
    public void setMobileAttribution(String mobileAttribution) {
        this.mobileAttribution = mobileAttribution == null ? null : mobileAttribution.trim();
    }

    /**
     * 邮箱
     * @return EMAIL 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 单位地址区划名称
     * @return INDIV_COM_PLE 单位地址区划名称
     */
    public String getIndivComPle() {
        return indivComPle;
    }

    /**
     * 单位地址区划名称
     * @param indivComPle 单位地址区划名称
     */
    public void setIndivComPle(String indivComPle) {
        this.indivComPle = indivComPle == null ? null : indivComPle.trim();
    }

    /**
     * 单位地址行政区划
     * @return INDIV_COM_PLE_ID 单位地址行政区划
     */
    public String getIndivComPleId() {
        return indivComPleId;
    }

    /**
     * 单位地址行政区划
     * @param indivComPleId 单位地址行政区划
     */
    public void setIndivComPleId(String indivComPleId) {
        this.indivComPleId = indivComPleId == null ? null : indivComPleId.trim();
    }

    /**
     * 房产地址
     * @return HOUSE_ADDRESS 房产地址
     */
    public String getHouseAddress() {
        return houseAddress;
    }

    /**
     * 房产地址
     * @param houseAddress 房产地址
     */
    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress == null ? null : houseAddress.trim();
    }

    /**
     * 房产权属人
     * @return HOUSE_OWNER_NAME 房产权属人
     */
    public String getHouseOwnerName() {
        return houseOwnerName;
    }

    /**
     * 房产权属人
     * @param houseOwnerName 房产权属人
     */
    public void setHouseOwnerName(String houseOwnerName) {
        this.houseOwnerName = houseOwnerName == null ? null : houseOwnerName.trim();
    }

    /**
     * 权属人证件号码
     * @return HOUSE_OWNER_CERT_CODE 权属人证件号码
     */
    public String getHouseOwnerCertCode() {
        return houseOwnerCertCode;
    }

    /**
     * 权属人证件号码
     * @param houseOwnerCertCode 权属人证件号码
     */
    public void setHouseOwnerCertCode(String houseOwnerCertCode) {
        this.houseOwnerCertCode = houseOwnerCertCode == null ? null : houseOwnerCertCode.trim();
    }

    /**
     * 房地产权证号
     * @return HOUSE_NO 房地产权证号
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * 房地产权证号
     * @param houseNo 房地产权证号
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo == null ? null : houseNo.trim();
    }

    /**
     * 房屋规划用途(住宅、商住两用、商用房)
     * @return HOUSE_PURPOSE 房屋规划用途(住宅、商住两用、商用房)
     */
    public String getHousePurpose() {
        return housePurpose;
    }

    /**
     * 房屋规划用途(住宅、商住两用、商用房)
     * @param housePurpose 房屋规划用途(住宅、商住两用、商用房)
     */
    public void setHousePurpose(String housePurpose) {
        this.housePurpose = housePurpose == null ? null : housePurpose.trim();
    }

    /**
     * 月均销售额
     * @return MTH_SALE_AMT 月均销售额
     */
    public String getMthSaleAmt() {
        return mthSaleAmt;
    }

    /**
     * 月均销售额
     * @param mthSaleAmt 月均销售额
     */
    public void setMthSaleAmt(String mthSaleAmt) {
        this.mthSaleAmt = mthSaleAmt == null ? null : mthSaleAmt.trim();
    }

    /**
     * 评估起期
     * @return MTH_ELV_STRDATE 评估起期
     */
    public String getMthElvStrdate() {
        return mthElvStrdate;
    }

    /**
     * 评估起期
     * @param mthElvStrdate 评估起期
     */
    public void setMthElvStrdate(String mthElvStrdate) {
        this.mthElvStrdate = mthElvStrdate == null ? null : mthElvStrdate.trim();
    }

    /**
     * 评估止期
     * @return MTH_ELV_ENDDATE 评估止期
     */
    public String getMthElvEnddate() {
        return mthElvEnddate;
    }

    /**
     * 评估止期
     * @param mthElvEnddate 评估止期
     */
    public void setMthElvEnddate(String mthElvEnddate) {
        this.mthElvEnddate = mthElvEnddate == null ? null : mthElvEnddate.trim();
    }

    /**
     * 客户号-注册银行返回
     * @return CIF_NO 客户号-注册银行返回
     */
    public String getCifNo() {
        return cifNo;
    }

    /**
     * 客户号-注册银行返回
     * @param cifNo 客户号-注册银行返回
     */
    public void setCifNo(String cifNo) {
        this.cifNo = cifNo == null ? null : cifNo.trim();
    }

    /**
     * 二级电子账号
     * @return E_AC_NO 二级电子账号
     */
    public String geteAcNo() {
        return eAcNo;
    }

    /**
     * 二级电子账号
     * @param eAcNo 二级电子账号
     */
    public void seteAcNo(String eAcNo) {
        this.eAcNo = eAcNo == null ? null : eAcNo.trim();
    }

    /**
     * 二级电子账号状态
     * @return E_AC_STATE 二级电子账号状态
     */
    public String geteAcState() {
        return eAcState;
    }

    /**
     * 二级电子账号状态
     * @param eAcState 二级电子账号状态
     */
    public void seteAcState(String eAcState) {
        this.eAcState = eAcState == null ? null : eAcState.trim();
    }

    /**
     * 民泰H5开户地址
     * @return RETURNURL 民泰H5开户地址
     */
    public String getReturnurl() {
        return returnurl;
    }

    /**
     * 民泰H5开户地址
     * @param returnurl 民泰H5开户地址
     */
    public void setReturnurl(String returnurl) {
        this.returnurl = returnurl == null ? null : returnurl.trim();
    }

    /**
     * 职业名称
     * @return INDIV_OCC_NAME 职业名称
     */
    public String getIndivOccName() {
        return indivOccName;
    }

    /**
     * 职业名称
     * @param indivOccName 职业名称
     */
    public void setIndivOccName(String indivOccName) {
        this.indivOccName = indivOccName == null ? null : indivOccName.trim();
    }
}