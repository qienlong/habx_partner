package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class CusIndiv {
    /**
     * 客户编号
     */
    private String cusId;

    /**
     * 核心客户编号
     */
    private String transCusId;

    /**
     * 客户类型
     */
    private String cusType;

    /**
     * 业务条线归属
     */
    private String belongTo;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 性别
     */
    private String indivSex;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certCode;

    /**
     * 证件起始日期
     */
    private String indivIdBegDt;

    /**
     * 证件是否长期有效
     */
    private String indivIdLong;

    /**
     * 证件到期日
     */
    private String indivIdExpDt;

    /**
     * 是否农户
     */
    private String agriFlg;

    /**
     * 与我行关系
     */
    private String cusBankRel;

    /**
     * 拥有我行股份金额(元)
     */
    private BigDecimal comHoldStkAmt;

    /**
     * 在我行职务
     */
    private String bankDuty;

    /**
     * 民族
     */
    private String indivNtn;

    /**
     * 户籍地址
     */
    private String indivBrtPlace;

    /**
     * 出生日期
     */
    private String indivDtOfBirth;

    /**
     * 政治面貌
     */
    private String indivPolSt;

    /**
     * 最高学历
     */
    private String indivEdt;

    /**
     * 最高学位
     */
    private String indivDgr;

    /**
     * 健康状况
     */
    private String indivHealSt;

    /**
     * 社会保障情况
     */
    private String indivSocScr;

    /**
     * 爱好
     */
    private String indivHobby;

    /**
     * 婚姻状况
     */
    private String indivMarSt;

    /**
     * 配偶证件类型
     */
    private String indivSpsIdTyp;

    /**
     * 配偶证件号码
     */
    private String indivSpsIdCode;

    /**
     * 配偶客户编号
     */
    private String cusIdRel;

    /**
     * 配偶姓名
     */
    private String indivSpsName;

    /**
     * 结婚证号(户口簿号)
     */
    private String indivSpsMarCode;

    /**
     * 配偶职业
     */
    private String indivSpsOcc;

    /**
     * 配偶工作单位
     */
    private String indivScomName;

    /**
     * 配偶职称
     */
    private String indivPspCrtfctn;

    /**
     * 配偶职称
     */
    private String indivSpsDuty;

    /**
     * 配偶手机号码
     */
    private String indivSpsMphn;

    /**
     * 配偶单位电话
     */
    private String indivSpsPhn;

    /**
     * 配偶年收入(元)
     */
    private BigDecimal indivSpsMincm;

    /**
     * 配偶参加工作年份
     */
    private String indivSpsJobDt;

    /**
     * 与我行合作关系
     */
    private String comRelDgr;

    /**
     * 建立信贷关系时间
     */
    private String comInitLoanDate;

    /**
     * 在我行开立账户情况
     */
    private String indivHldAcnt;

    /**
     * 持卡情况
     */
    private String holdCard;

    /**
     * 是否拥有外国护照或居住权
     */
    private String passportFlg;

    /**
     * 信用等级
     */
    private String crdGrade;

    /**
     * 信用评定日期
     */
    private String crdDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 通讯地址
     */
    private String postAddr;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 居住地址
     */
    private String indivRsdAddr;

    /**
     * 居住状况
     */
    private String indivRsdSt;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 居住地邮政编码
     */
    private String indivZipCode;

    /**
     * 家庭电话
     */
    private String fphone;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 短信通知号
     */
    private String phone;

    /**
     * 传真
     */
    private String faxCode;

    /**
     * Email地址
     */
    private String email;

    /**
     * 从事职业
     */
    private String indivOcc;

    /**
     * 工作单位
     */
    private String indivComName;

    /**
     * 单位性质
     */
    private String indivComTyp;

    /**
     * 单位所属行业
     */
    private String indivComFld;

    /**
     * 单位所属行业名称
     */
    private String indivComFldName;

    /**
     * 单位地址
     */
    private String indivComAddr;

    /**
     * 单位邮编
     */
    private String indivComZipCode;

    /**
     * 单位电话
     */
    private String indivComPhn;

    /**
     * 单位传真
     */
    private String indivComFax;

    /**
     * 单位联系人
     */
    private String indivComCntName;

    /**
     * 单位工作起始年
     */
    private String indivWorkJobY;

    /**
     * 职务
     */
    private String indivComJobTtl;

    /**
     * 职称
     */
    private String indivCrtfctn;

    /**
     * 年收入情况
     */
    private BigDecimal indivAnnIncm;

    /**
     * 收入来源
     */
    private String indivAnnIncmSrc;

    /**
     * 工资账户开户行
     */
    private String indivSalAccBank;

    /**
     * 工资账号
     */
    private String indivSalAccNo;

    /**
     * 个人简历
     */
    private String workResume;

    /**
     * vip标志
     */
    private String vipFlag;

    /**
     * vip等级
     */
    private String vipLevel;

    /**
     * 状态
     */
    private String cusStatus;

    /**
     * 主管机构
     */
    private String mainBrId;

    /**
     * 主管客户经理
     */
    private String custMgr;

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
     * 更新人
     */
    private String lastUpdId;

    /**
     * 更新日期
     */
    private String lastUpdDate;

    /**
     * 国别
     */
    private String comCountry;

    /**
     * 户籍地址行政区划编号
     */
    private String indivBrtPleId;

    /**
     * 户籍行政区划
     */
    private String indivBrtPle;

    /**
     * 通讯地址行政区划编号
     */
    private String postAddrPleId;

    /**
     * 通讯地址行政区划
     */
    private String postAddrPle;

    /**
     * 居住地址行政区划编号
     */
    private String indivRsdPleId;

    /**
     * 居住地址行政区划
     */
    private String indivRsdPle;

    /**
     * 单位地址行政区划编号
     */
    private String indivComAddrPleId;

    /**
     * 单位地址行政区划
     */
    private String indivComAddrPle;

    /**
     * INDIV_RSD_STATE_CD
     */
    private String indivRsdStateCd;

    /**
     * INDIV_RSD_PROVINCE_CD
     */
    private String indivRsdProvinceCd;

    /**
     * INDIV_RSD_CITY_CD
     */
    private String indivRsdCityCd;

    /**
     * INDIV_RSD_DISTRICT_CD
     */
    private String indivRsdDistrictCd;

    /**
     * POST_STATE_CD
     */
    private String postStateCd;

    /**
     * POST_PROVINCE_CD
     */
    private String postProvinceCd;

    /**
     * POST_CITY_CD
     */
    private String postCityCd;

    /**
     * POST_DISTRICT_CD
     */
    private String postDistrictCd;

    /**
     * 管理结构图
     */
    private String managementStructure;

    /**
     * 生产加工流程图
     */
    private String workFlow;

    /**
     * 企业/生意名称
     */
    private String businName;

    /**
     * 注册经营人/法人代表
     */
    private String legalName;

    /**
     * 主营业务
     */
    private String operJob;

    /**
     * 所属行业
     */
    private String operName;

    /**
     * 开业时间
     */
    private String openDate;

    /**
     * 经营年限
     */
    private String operYears;

    /**
     * 经营面积(㎡)
     */
    private String operArea;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 其他经营
     */
    private String operOther;

    /**
     * 经营地址
     */
    private String operAddr;

    /**
     * 经营场所
     */
    private String operPlace;

    /**
     * 营业执照编号
     */
    private String operNo;

    /**
     * 雇员人数
     */
    private String employeeNum;

    /**
     * 贷款卡号
     */
    private String comInvLoanCard;

    /**
     * 上游关系
     */
    private String operRelate;

    /**
     * 下游关系
     */
    private String operLowRelate;

    /**
     * 经营历史
     */
    private String operHist;

    /**
     * 评价经营组织和市场情况
     */
    private String desc0;

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
     * 经营年限(月)
     */
    private String operMonths;

    /**
     * 户籍是否为申请所在地
     */
    private String isBrtLocal;

    /**
     * 现住房面积
     */
    private String housingArea;

    /**
     * 现址入住时间
     */
    private String housingDate;

    /**
     * 家庭人数
     */
    private String indivFamNum;

    /**
     * 客户等级
     */
    private String cusLevel;

    /**
     * 社保卡号
     */
    private String socScrNo;

    /**
     * null
     */
    private String provAreaCode;

    /**
     * null
     */
    private String regResAreaCode;

    /**
     * 微信
     */
    private String weChat;

    /**
     * QQ
     */
    private String qq;

    /**
     * 银行卡号
     */
    private String bankCardNo;

    /**
     * null
     */
    private String mobileAttribution;

    /**
     * null
     */
    private String bankCardName;

    /**
     * null
     */
    private String houseFundAccount;

    /**
     * null
     */
    private String indivSpsIdcardObv;

    /**
     * 职业描述
     */
    private String indivOccName;
    
    /**
     * 安心签唯一标识
     */
    private String registerId;

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
     * 业务条线归属
     * @return BELONG_TO 业务条线归属
     */
    public String getBelongTo() {
        return belongTo;
    }

    /**
     * 业务条线归属
     * @param belongTo 业务条线归属
     */
    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo == null ? null : belongTo.trim();
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
     * 性别
     * @return INDIV_SEX 性别
     */
    public String getIndivSex() {
        return indivSex;
    }

    /**
     * 性别
     * @param indivSex 性别
     */
    public void setIndivSex(String indivSex) {
        this.indivSex = indivSex == null ? null : indivSex.trim();
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
     * 证件起始日期
     * @return INDIV_ID_BEG_DT 证件起始日期
     */
    public String getIndivIdBegDt() {
        return indivIdBegDt;
    }

    /**
     * 证件起始日期
     * @param indivIdBegDt 证件起始日期
     */
    public void setIndivIdBegDt(String indivIdBegDt) {
        this.indivIdBegDt = indivIdBegDt == null ? null : indivIdBegDt.trim();
    }

    /**
     * 证件是否长期有效
     * @return INDIV_ID_LONG 证件是否长期有效
     */
    public String getIndivIdLong() {
        return indivIdLong;
    }

    /**
     * 证件是否长期有效
     * @param indivIdLong 证件是否长期有效
     */
    public void setIndivIdLong(String indivIdLong) {
        this.indivIdLong = indivIdLong == null ? null : indivIdLong.trim();
    }

    /**
     * 证件到期日
     * @return INDIV_ID_EXP_DT 证件到期日
     */
    public String getIndivIdExpDt() {
        return indivIdExpDt;
    }

    /**
     * 证件到期日
     * @param indivIdExpDt 证件到期日
     */
    public void setIndivIdExpDt(String indivIdExpDt) {
        this.indivIdExpDt = indivIdExpDt == null ? null : indivIdExpDt.trim();
    }

    /**
     * 是否农户
     * @return AGRI_FLG 是否农户
     */
    public String getAgriFlg() {
        return agriFlg;
    }

    /**
     * 是否农户
     * @param agriFlg 是否农户
     */
    public void setAgriFlg(String agriFlg) {
        this.agriFlg = agriFlg == null ? null : agriFlg.trim();
    }

    /**
     * 与我行关系
     * @return CUS_BANK_REL 与我行关系
     */
    public String getCusBankRel() {
        return cusBankRel;
    }

    /**
     * 与我行关系
     * @param cusBankRel 与我行关系
     */
    public void setCusBankRel(String cusBankRel) {
        this.cusBankRel = cusBankRel == null ? null : cusBankRel.trim();
    }

    /**
     * 拥有我行股份金额(元)
     * @return COM_HOLD_STK_AMT 拥有我行股份金额(元)
     */
    public BigDecimal getComHoldStkAmt() {
        return comHoldStkAmt;
    }

    /**
     * 拥有我行股份金额(元)
     * @param comHoldStkAmt 拥有我行股份金额(元)
     */
    public void setComHoldStkAmt(BigDecimal comHoldStkAmt) {
        this.comHoldStkAmt = comHoldStkAmt;
    }

    /**
     * 在我行职务
     * @return BANK_DUTY 在我行职务
     */
    public String getBankDuty() {
        return bankDuty;
    }

    /**
     * 在我行职务
     * @param bankDuty 在我行职务
     */
    public void setBankDuty(String bankDuty) {
        this.bankDuty = bankDuty == null ? null : bankDuty.trim();
    }

    /**
     * 民族
     * @return INDIV_NTN 民族
     */
    public String getIndivNtn() {
        return indivNtn;
    }

    /**
     * 民族
     * @param indivNtn 民族
     */
    public void setIndivNtn(String indivNtn) {
        this.indivNtn = indivNtn == null ? null : indivNtn.trim();
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
     * 政治面貌
     * @return INDIV_POL_ST 政治面貌
     */
    public String getIndivPolSt() {
        return indivPolSt;
    }

    /**
     * 政治面貌
     * @param indivPolSt 政治面貌
     */
    public void setIndivPolSt(String indivPolSt) {
        this.indivPolSt = indivPolSt == null ? null : indivPolSt.trim();
    }

    /**
     * 最高学历
     * @return INDIV_EDT 最高学历
     */
    public String getIndivEdt() {
        return indivEdt;
    }

    /**
     * 最高学历
     * @param indivEdt 最高学历
     */
    public void setIndivEdt(String indivEdt) {
        this.indivEdt = indivEdt == null ? null : indivEdt.trim();
    }

    /**
     * 最高学位
     * @return INDIV_DGR 最高学位
     */
    public String getIndivDgr() {
        return indivDgr;
    }

    /**
     * 最高学位
     * @param indivDgr 最高学位
     */
    public void setIndivDgr(String indivDgr) {
        this.indivDgr = indivDgr == null ? null : indivDgr.trim();
    }

    /**
     * 健康状况
     * @return INDIV_HEAL_ST 健康状况
     */
    public String getIndivHealSt() {
        return indivHealSt;
    }

    /**
     * 健康状况
     * @param indivHealSt 健康状况
     */
    public void setIndivHealSt(String indivHealSt) {
        this.indivHealSt = indivHealSt == null ? null : indivHealSt.trim();
    }

    /**
     * 社会保障情况
     * @return INDIV_SOC_SCR 社会保障情况
     */
    public String getIndivSocScr() {
        return indivSocScr;
    }

    /**
     * 社会保障情况
     * @param indivSocScr 社会保障情况
     */
    public void setIndivSocScr(String indivSocScr) {
        this.indivSocScr = indivSocScr == null ? null : indivSocScr.trim();
    }

    /**
     * 爱好
     * @return INDIV_HOBBY 爱好
     */
    public String getIndivHobby() {
        return indivHobby;
    }

    /**
     * 爱好
     * @param indivHobby 爱好
     */
    public void setIndivHobby(String indivHobby) {
        this.indivHobby = indivHobby == null ? null : indivHobby.trim();
    }

    /**
     * 婚姻状况
     * @return INDIV_MAR_ST 婚姻状况
     */
    public String getIndivMarSt() {
        return indivMarSt;
    }

    /**
     * 婚姻状况
     * @param indivMarSt 婚姻状况
     */
    public void setIndivMarSt(String indivMarSt) {
        this.indivMarSt = indivMarSt == null ? null : indivMarSt.trim();
    }

    /**
     * 配偶证件类型
     * @return INDIV_SPS_ID_TYP 配偶证件类型
     */
    public String getIndivSpsIdTyp() {
        return indivSpsIdTyp;
    }

    /**
     * 配偶证件类型
     * @param indivSpsIdTyp 配偶证件类型
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
     * 配偶客户编号
     * @return CUS_ID_REL 配偶客户编号
     */
    public String getCusIdRel() {
        return cusIdRel;
    }

    /**
     * 配偶客户编号
     * @param cusIdRel 配偶客户编号
     */
    public void setCusIdRel(String cusIdRel) {
        this.cusIdRel = cusIdRel == null ? null : cusIdRel.trim();
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
     * 结婚证号(户口簿号)
     * @return INDIV_SPS_MAR_CODE 结婚证号(户口簿号)
     */
    public String getIndivSpsMarCode() {
        return indivSpsMarCode;
    }

    /**
     * 结婚证号(户口簿号)
     * @param indivSpsMarCode 结婚证号(户口簿号)
     */
    public void setIndivSpsMarCode(String indivSpsMarCode) {
        this.indivSpsMarCode = indivSpsMarCode == null ? null : indivSpsMarCode.trim();
    }

    /**
     * 配偶职业
     * @return INDIV_SPS_OCC 配偶职业
     */
    public String getIndivSpsOcc() {
        return indivSpsOcc;
    }

    /**
     * 配偶职业
     * @param indivSpsOcc 配偶职业
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
     * 配偶职称
     * @return INDIV_PSP_CRTFCTN 配偶职称
     */
    public String getIndivPspCrtfctn() {
        return indivPspCrtfctn;
    }

    /**
     * 配偶职称
     * @param indivPspCrtfctn 配偶职称
     */
    public void setIndivPspCrtfctn(String indivPspCrtfctn) {
        this.indivPspCrtfctn = indivPspCrtfctn == null ? null : indivPspCrtfctn.trim();
    }

    /**
     * 配偶职称
     * @return INDIV_SPS_DUTY 配偶职称
     */
    public String getIndivSpsDuty() {
        return indivSpsDuty;
    }

    /**
     * 配偶职称
     * @param indivSpsDuty 配偶职称
     */
    public void setIndivSpsDuty(String indivSpsDuty) {
        this.indivSpsDuty = indivSpsDuty == null ? null : indivSpsDuty.trim();
    }

    /**
     * 配偶手机号码
     * @return INDIV_SPS_MPHN 配偶手机号码
     */
    public String getIndivSpsMphn() {
        return indivSpsMphn;
    }

    /**
     * 配偶手机号码
     * @param indivSpsMphn 配偶手机号码
     */
    public void setIndivSpsMphn(String indivSpsMphn) {
        this.indivSpsMphn = indivSpsMphn == null ? null : indivSpsMphn.trim();
    }

    /**
     * 配偶单位电话
     * @return INDIV_SPS_PHN 配偶单位电话
     */
    public String getIndivSpsPhn() {
        return indivSpsPhn;
    }

    /**
     * 配偶单位电话
     * @param indivSpsPhn 配偶单位电话
     */
    public void setIndivSpsPhn(String indivSpsPhn) {
        this.indivSpsPhn = indivSpsPhn == null ? null : indivSpsPhn.trim();
    }

    /**
     * 配偶年收入(元)
     * @return INDIV_SPS_MINCM 配偶年收入(元)
     */
    public BigDecimal getIndivSpsMincm() {
        return indivSpsMincm;
    }

    /**
     * 配偶年收入(元)
     * @param indivSpsMincm 配偶年收入(元)
     */
    public void setIndivSpsMincm(BigDecimal indivSpsMincm) {
        this.indivSpsMincm = indivSpsMincm;
    }

    /**
     * 配偶参加工作年份
     * @return INDIV_SPS_JOB_DT 配偶参加工作年份
     */
    public String getIndivSpsJobDt() {
        return indivSpsJobDt;
    }

    /**
     * 配偶参加工作年份
     * @param indivSpsJobDt 配偶参加工作年份
     */
    public void setIndivSpsJobDt(String indivSpsJobDt) {
        this.indivSpsJobDt = indivSpsJobDt == null ? null : indivSpsJobDt.trim();
    }

    /**
     * 与我行合作关系
     * @return COM_REL_DGR 与我行合作关系
     */
    public String getComRelDgr() {
        return comRelDgr;
    }

    /**
     * 与我行合作关系
     * @param comRelDgr 与我行合作关系
     */
    public void setComRelDgr(String comRelDgr) {
        this.comRelDgr = comRelDgr == null ? null : comRelDgr.trim();
    }

    /**
     * 建立信贷关系时间
     * @return COM_INIT_LOAN_DATE 建立信贷关系时间
     */
    public String getComInitLoanDate() {
        return comInitLoanDate;
    }

    /**
     * 建立信贷关系时间
     * @param comInitLoanDate 建立信贷关系时间
     */
    public void setComInitLoanDate(String comInitLoanDate) {
        this.comInitLoanDate = comInitLoanDate == null ? null : comInitLoanDate.trim();
    }

    /**
     * 在我行开立账户情况
     * @return INDIV_HLD_ACNT 在我行开立账户情况
     */
    public String getIndivHldAcnt() {
        return indivHldAcnt;
    }

    /**
     * 在我行开立账户情况
     * @param indivHldAcnt 在我行开立账户情况
     */
    public void setIndivHldAcnt(String indivHldAcnt) {
        this.indivHldAcnt = indivHldAcnt == null ? null : indivHldAcnt.trim();
    }

    /**
     * 持卡情况
     * @return HOLD_CARD 持卡情况
     */
    public String getHoldCard() {
        return holdCard;
    }

    /**
     * 持卡情况
     * @param holdCard 持卡情况
     */
    public void setHoldCard(String holdCard) {
        this.holdCard = holdCard == null ? null : holdCard.trim();
    }

    /**
     * 是否拥有外国护照或居住权
     * @return PASSPORT_FLG 是否拥有外国护照或居住权
     */
    public String getPassportFlg() {
        return passportFlg;
    }

    /**
     * 是否拥有外国护照或居住权
     * @param passportFlg 是否拥有外国护照或居住权
     */
    public void setPassportFlg(String passportFlg) {
        this.passportFlg = passportFlg == null ? null : passportFlg.trim();
    }

    /**
     * 信用等级
     * @return CRD_GRADE 信用等级
     */
    public String getCrdGrade() {
        return crdGrade;
    }

    /**
     * 信用等级
     * @param crdGrade 信用等级
     */
    public void setCrdGrade(String crdGrade) {
        this.crdGrade = crdGrade == null ? null : crdGrade.trim();
    }

    /**
     * 信用评定日期
     * @return CRD_DATE 信用评定日期
     */
    public String getCrdDate() {
        return crdDate;
    }

    /**
     * 信用评定日期
     * @param crdDate 信用评定日期
     */
    public void setCrdDate(String crdDate) {
        this.crdDate = crdDate == null ? null : crdDate.trim();
    }

    /**
     * 备注
     * @return REMARK 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
     * 邮政编码
     * @return POST_CODE 邮政编码
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 邮政编码
     * @param postCode 邮政编码
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * 居住地址
     * @return INDIV_RSD_ADDR 居住地址
     */
    public String getIndivRsdAddr() {
        return indivRsdAddr;
    }

    /**
     * 居住地址
     * @param indivRsdAddr 居住地址
     */
    public void setIndivRsdAddr(String indivRsdAddr) {
        this.indivRsdAddr = indivRsdAddr == null ? null : indivRsdAddr.trim();
    }

    /**
     * 居住状况
     * @return INDIV_RSD_ST 居住状况
     */
    public String getIndivRsdSt() {
        return indivRsdSt;
    }

    /**
     * 居住状况
     * @param indivRsdSt 居住状况
     */
    public void setIndivRsdSt(String indivRsdSt) {
        this.indivRsdSt = indivRsdSt == null ? null : indivRsdSt.trim();
    }

    /**
     * 区域编码
     * @return AREA_CODE 区域编码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 区域编码
     * @param areaCode 区域编码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * 区域名称
     * @return AREA_NAME 区域名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 区域名称
     * @param areaName 区域名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * 居住地邮政编码
     * @return INDIV_ZIP_CODE 居住地邮政编码
     */
    public String getIndivZipCode() {
        return indivZipCode;
    }

    /**
     * 居住地邮政编码
     * @param indivZipCode 居住地邮政编码
     */
    public void setIndivZipCode(String indivZipCode) {
        this.indivZipCode = indivZipCode == null ? null : indivZipCode.trim();
    }

    /**
     * 家庭电话
     * @return FPHONE 家庭电话
     */
    public String getFphone() {
        return fphone;
    }

    /**
     * 家庭电话
     * @param fphone 家庭电话
     */
    public void setFphone(String fphone) {
        this.fphone = fphone == null ? null : fphone.trim();
    }

    /**
     * 手机号码
     * @return MOBILE 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号码
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 短信通知号
     * @return PHONE 短信通知号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 短信通知号
     * @param phone 短信通知号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 传真
     * @return FAX_CODE 传真
     */
    public String getFaxCode() {
        return faxCode;
    }

    /**
     * 传真
     * @param faxCode 传真
     */
    public void setFaxCode(String faxCode) {
        this.faxCode = faxCode == null ? null : faxCode.trim();
    }

    /**
     * Email地址
     * @return EMAIL Email地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * Email地址
     * @param email Email地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 从事职业
     * @return INDIV_OCC 从事职业
     */
    public String getIndivOcc() {
        return indivOcc;
    }

    /**
     * 从事职业
     * @param indivOcc 从事职业
     */
    public void setIndivOcc(String indivOcc) {
        this.indivOcc = indivOcc == null ? null : indivOcc.trim();
    }

    /**
     * 工作单位
     * @return INDIV_COM_NAME 工作单位
     */
    public String getIndivComName() {
        return indivComName;
    }

    /**
     * 工作单位
     * @param indivComName 工作单位
     */
    public void setIndivComName(String indivComName) {
        this.indivComName = indivComName == null ? null : indivComName.trim();
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
     * 单位所属行业名称
     * @return INDIV_COM_FLD_NAME 单位所属行业名称
     */
    public String getIndivComFldName() {
        return indivComFldName;
    }

    /**
     * 单位所属行业名称
     * @param indivComFldName 单位所属行业名称
     */
    public void setIndivComFldName(String indivComFldName) {
        this.indivComFldName = indivComFldName == null ? null : indivComFldName.trim();
    }

    /**
     * 单位地址
     * @return INDIV_COM_ADDR 单位地址
     */
    public String getIndivComAddr() {
        return indivComAddr;
    }

    /**
     * 单位地址
     * @param indivComAddr 单位地址
     */
    public void setIndivComAddr(String indivComAddr) {
        this.indivComAddr = indivComAddr == null ? null : indivComAddr.trim();
    }

    /**
     * 单位邮编
     * @return INDIV_COM_ZIP_CODE 单位邮编
     */
    public String getIndivComZipCode() {
        return indivComZipCode;
    }

    /**
     * 单位邮编
     * @param indivComZipCode 单位邮编
     */
    public void setIndivComZipCode(String indivComZipCode) {
        this.indivComZipCode = indivComZipCode == null ? null : indivComZipCode.trim();
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
     * 单位传真
     * @return INDIV_COM_FAX 单位传真
     */
    public String getIndivComFax() {
        return indivComFax;
    }

    /**
     * 单位传真
     * @param indivComFax 单位传真
     */
    public void setIndivComFax(String indivComFax) {
        this.indivComFax = indivComFax == null ? null : indivComFax.trim();
    }

    /**
     * 单位联系人
     * @return INDIV_COM_CNT_NAME 单位联系人
     */
    public String getIndivComCntName() {
        return indivComCntName;
    }

    /**
     * 单位联系人
     * @param indivComCntName 单位联系人
     */
    public void setIndivComCntName(String indivComCntName) {
        this.indivComCntName = indivComCntName == null ? null : indivComCntName.trim();
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
     * 职务
     * @return INDIV_COM_JOB_TTL 职务
     */
    public String getIndivComJobTtl() {
        return indivComJobTtl;
    }

    /**
     * 职务
     * @param indivComJobTtl 职务
     */
    public void setIndivComJobTtl(String indivComJobTtl) {
        this.indivComJobTtl = indivComJobTtl == null ? null : indivComJobTtl.trim();
    }

    /**
     * 职称
     * @return INDIV_CRTFCTN 职称
     */
    public String getIndivCrtfctn() {
        return indivCrtfctn;
    }

    /**
     * 职称
     * @param indivCrtfctn 职称
     */
    public void setIndivCrtfctn(String indivCrtfctn) {
        this.indivCrtfctn = indivCrtfctn == null ? null : indivCrtfctn.trim();
    }

    /**
     * 年收入情况
     * @return INDIV_ANN_INCM 年收入情况
     */
    public BigDecimal getIndivAnnIncm() {
        return indivAnnIncm;
    }

    /**
     * 年收入情况
     * @param indivAnnIncm 年收入情况
     */
    public void setIndivAnnIncm(BigDecimal indivAnnIncm) {
        this.indivAnnIncm = indivAnnIncm;
    }

    /**
     * 收入来源
     * @return INDIV_ANN_INCM_SRC 收入来源
     */
    public String getIndivAnnIncmSrc() {
        return indivAnnIncmSrc;
    }

    /**
     * 收入来源
     * @param indivAnnIncmSrc 收入来源
     */
    public void setIndivAnnIncmSrc(String indivAnnIncmSrc) {
        this.indivAnnIncmSrc = indivAnnIncmSrc == null ? null : indivAnnIncmSrc.trim();
    }

    /**
     * 工资账户开户行
     * @return INDIV_SAL_ACC_BANK 工资账户开户行
     */
    public String getIndivSalAccBank() {
        return indivSalAccBank;
    }

    /**
     * 工资账户开户行
     * @param indivSalAccBank 工资账户开户行
     */
    public void setIndivSalAccBank(String indivSalAccBank) {
        this.indivSalAccBank = indivSalAccBank == null ? null : indivSalAccBank.trim();
    }

    /**
     * 工资账号
     * @return INDIV_SAL_ACC_NO 工资账号
     */
    public String getIndivSalAccNo() {
        return indivSalAccNo;
    }

    /**
     * 工资账号
     * @param indivSalAccNo 工资账号
     */
    public void setIndivSalAccNo(String indivSalAccNo) {
        this.indivSalAccNo = indivSalAccNo == null ? null : indivSalAccNo.trim();
    }

    /**
     * 个人简历
     * @return WORK_RESUME 个人简历
     */
    public String getWorkResume() {
        return workResume;
    }

    /**
     * 个人简历
     * @param workResume 个人简历
     */
    public void setWorkResume(String workResume) {
        this.workResume = workResume == null ? null : workResume.trim();
    }

    /**
     * vip标志
     * @return VIP_FLAG vip标志
     */
    public String getVipFlag() {
        return vipFlag;
    }

    /**
     * vip标志
     * @param vipFlag vip标志
     */
    public void setVipFlag(String vipFlag) {
        this.vipFlag = vipFlag == null ? null : vipFlag.trim();
    }

    /**
     * vip等级
     * @return VIP_LEVEL vip等级
     */
    public String getVipLevel() {
        return vipLevel;
    }

    /**
     * vip等级
     * @param vipLevel vip等级
     */
    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel == null ? null : vipLevel.trim();
    }

    /**
     * 状态
     * @return CUS_STATUS 状态
     */
    public String getCusStatus() {
        return cusStatus;
    }

    /**
     * 状态
     * @param cusStatus 状态
     */
    public void setCusStatus(String cusStatus) {
        this.cusStatus = cusStatus == null ? null : cusStatus.trim();
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
     * 主管客户经理
     * @return CUST_MGR 主管客户经理
     */
    public String getCustMgr() {
        return custMgr;
    }

    /**
     * 主管客户经理
     * @param custMgr 主管客户经理
     */
    public void setCustMgr(String custMgr) {
        this.custMgr = custMgr == null ? null : custMgr.trim();
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
     * 更新人
     * @return LAST_UPD_ID 更新人
     */
    public String getLastUpdId() {
        return lastUpdId;
    }

    /**
     * 更新人
     * @param lastUpdId 更新人
     */
    public void setLastUpdId(String lastUpdId) {
        this.lastUpdId = lastUpdId == null ? null : lastUpdId.trim();
    }

    /**
     * 更新日期
     * @return LAST_UPD_DATE 更新日期
     */
    public String getLastUpdDate() {
        return lastUpdDate;
    }

    /**
     * 更新日期
     * @param lastUpdDate 更新日期
     */
    public void setLastUpdDate(String lastUpdDate) {
        this.lastUpdDate = lastUpdDate == null ? null : lastUpdDate.trim();
    }

    /**
     * 国别
     * @return COM_COUNTRY 国别
     */
    public String getComCountry() {
        return comCountry;
    }

    /**
     * 国别
     * @param comCountry 国别
     */
    public void setComCountry(String comCountry) {
        this.comCountry = comCountry == null ? null : comCountry.trim();
    }

    /**
     * 户籍地址行政区划编号
     * @return INDIV_BRT_PLE_ID 户籍地址行政区划编号
     */
    public String getIndivBrtPleId() {
        return indivBrtPleId;
    }

    /**
     * 户籍地址行政区划编号
     * @param indivBrtPleId 户籍地址行政区划编号
     */
    public void setIndivBrtPleId(String indivBrtPleId) {
        this.indivBrtPleId = indivBrtPleId == null ? null : indivBrtPleId.trim();
    }

    /**
     * 户籍行政区划
     * @return INDIV_BRT_PLE 户籍行政区划
     */
    public String getIndivBrtPle() {
        return indivBrtPle;
    }

    /**
     * 户籍行政区划
     * @param indivBrtPle 户籍行政区划
     */
    public void setIndivBrtPle(String indivBrtPle) {
        this.indivBrtPle = indivBrtPle == null ? null : indivBrtPle.trim();
    }

    /**
     * 通讯地址行政区划编号
     * @return POST_ADDR_PLE_ID 通讯地址行政区划编号
     */
    public String getPostAddrPleId() {
        return postAddrPleId;
    }

    /**
     * 通讯地址行政区划编号
     * @param postAddrPleId 通讯地址行政区划编号
     */
    public void setPostAddrPleId(String postAddrPleId) {
        this.postAddrPleId = postAddrPleId == null ? null : postAddrPleId.trim();
    }

    /**
     * 通讯地址行政区划
     * @return POST_ADDR_PLE 通讯地址行政区划
     */
    public String getPostAddrPle() {
        return postAddrPle;
    }

    /**
     * 通讯地址行政区划
     * @param postAddrPle 通讯地址行政区划
     */
    public void setPostAddrPle(String postAddrPle) {
        this.postAddrPle = postAddrPle == null ? null : postAddrPle.trim();
    }

    /**
     * 居住地址行政区划编号
     * @return INDIV_RSD_PLE_ID 居住地址行政区划编号
     */
    public String getIndivRsdPleId() {
        return indivRsdPleId;
    }

    /**
     * 居住地址行政区划编号
     * @param indivRsdPleId 居住地址行政区划编号
     */
    public void setIndivRsdPleId(String indivRsdPleId) {
        this.indivRsdPleId = indivRsdPleId == null ? null : indivRsdPleId.trim();
    }

    /**
     * 居住地址行政区划
     * @return INDIV_RSD_PLE 居住地址行政区划
     */
    public String getIndivRsdPle() {
        return indivRsdPle;
    }

    /**
     * 居住地址行政区划
     * @param indivRsdPle 居住地址行政区划
     */
    public void setIndivRsdPle(String indivRsdPle) {
        this.indivRsdPle = indivRsdPle == null ? null : indivRsdPle.trim();
    }

    /**
     * 单位地址行政区划编号
     * @return INDIV_COM_ADDR_PLE_ID 单位地址行政区划编号
     */
    public String getIndivComAddrPleId() {
        return indivComAddrPleId;
    }

    /**
     * 单位地址行政区划编号
     * @param indivComAddrPleId 单位地址行政区划编号
     */
    public void setIndivComAddrPleId(String indivComAddrPleId) {
        this.indivComAddrPleId = indivComAddrPleId == null ? null : indivComAddrPleId.trim();
    }

    /**
     * 单位地址行政区划
     * @return INDIV_COM_ADDR_PLE 单位地址行政区划
     */
    public String getIndivComAddrPle() {
        return indivComAddrPle;
    }

    /**
     * 单位地址行政区划
     * @param indivComAddrPle 单位地址行政区划
     */
    public void setIndivComAddrPle(String indivComAddrPle) {
        this.indivComAddrPle = indivComAddrPle == null ? null : indivComAddrPle.trim();
    }

    /**
     * INDIV_RSD_STATE_CD
     * @return INDIV_RSD_STATE_CD INDIV_RSD_STATE_CD
     */
    public String getIndivRsdStateCd() {
        return indivRsdStateCd;
    }

    /**
     * INDIV_RSD_STATE_CD
     * @param indivRsdStateCd INDIV_RSD_STATE_CD
     */
    public void setIndivRsdStateCd(String indivRsdStateCd) {
        this.indivRsdStateCd = indivRsdStateCd == null ? null : indivRsdStateCd.trim();
    }

    /**
     * INDIV_RSD_PROVINCE_CD
     * @return INDIV_RSD_PROVINCE_CD INDIV_RSD_PROVINCE_CD
     */
    public String getIndivRsdProvinceCd() {
        return indivRsdProvinceCd;
    }

    /**
     * INDIV_RSD_PROVINCE_CD
     * @param indivRsdProvinceCd INDIV_RSD_PROVINCE_CD
     */
    public void setIndivRsdProvinceCd(String indivRsdProvinceCd) {
        this.indivRsdProvinceCd = indivRsdProvinceCd == null ? null : indivRsdProvinceCd.trim();
    }

    /**
     * INDIV_RSD_CITY_CD
     * @return INDIV_RSD_CITY_CD INDIV_RSD_CITY_CD
     */
    public String getIndivRsdCityCd() {
        return indivRsdCityCd;
    }

    /**
     * INDIV_RSD_CITY_CD
     * @param indivRsdCityCd INDIV_RSD_CITY_CD
     */
    public void setIndivRsdCityCd(String indivRsdCityCd) {
        this.indivRsdCityCd = indivRsdCityCd == null ? null : indivRsdCityCd.trim();
    }

    /**
     * INDIV_RSD_DISTRICT_CD
     * @return INDIV_RSD_DISTRICT_CD INDIV_RSD_DISTRICT_CD
     */
    public String getIndivRsdDistrictCd() {
        return indivRsdDistrictCd;
    }

    /**
     * INDIV_RSD_DISTRICT_CD
     * @param indivRsdDistrictCd INDIV_RSD_DISTRICT_CD
     */
    public void setIndivRsdDistrictCd(String indivRsdDistrictCd) {
        this.indivRsdDistrictCd = indivRsdDistrictCd == null ? null : indivRsdDistrictCd.trim();
    }

    /**
     * POST_STATE_CD
     * @return POST_STATE_CD POST_STATE_CD
     */
    public String getPostStateCd() {
        return postStateCd;
    }

    /**
     * POST_STATE_CD
     * @param postStateCd POST_STATE_CD
     */
    public void setPostStateCd(String postStateCd) {
        this.postStateCd = postStateCd == null ? null : postStateCd.trim();
    }

    /**
     * POST_PROVINCE_CD
     * @return POST_PROVINCE_CD POST_PROVINCE_CD
     */
    public String getPostProvinceCd() {
        return postProvinceCd;
    }

    /**
     * POST_PROVINCE_CD
     * @param postProvinceCd POST_PROVINCE_CD
     */
    public void setPostProvinceCd(String postProvinceCd) {
        this.postProvinceCd = postProvinceCd == null ? null : postProvinceCd.trim();
    }

    /**
     * POST_CITY_CD
     * @return POST_CITY_CD POST_CITY_CD
     */
    public String getPostCityCd() {
        return postCityCd;
    }

    /**
     * POST_CITY_CD
     * @param postCityCd POST_CITY_CD
     */
    public void setPostCityCd(String postCityCd) {
        this.postCityCd = postCityCd == null ? null : postCityCd.trim();
    }

    /**
     * POST_DISTRICT_CD
     * @return POST_DISTRICT_CD POST_DISTRICT_CD
     */
    public String getPostDistrictCd() {
        return postDistrictCd;
    }

    /**
     * POST_DISTRICT_CD
     * @param postDistrictCd POST_DISTRICT_CD
     */
    public void setPostDistrictCd(String postDistrictCd) {
        this.postDistrictCd = postDistrictCd == null ? null : postDistrictCd.trim();
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
     * 经营面积(㎡)
     * @return OPER_AREA 经营面积(㎡)
     */
    public String getOperArea() {
        return operArea;
    }

    /**
     * 经营面积(㎡)
     * @param operArea 经营面积(㎡)
     */
    public void setOperArea(String operArea) {
        this.operArea = operArea == null ? null : operArea.trim();
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
     * 营业执照编号
     * @return OPER_NO 营业执照编号
     */
    public String getOperNo() {
        return operNo;
    }

    /**
     * 营业执照编号
     * @param operNo 营业执照编号
     */
    public void setOperNo(String operNo) {
        this.operNo = operNo == null ? null : operNo.trim();
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
     * 上游关系
     * @return OPER_RELATE 上游关系
     */
    public String getOperRelate() {
        return operRelate;
    }

    /**
     * 上游关系
     * @param operRelate 上游关系
     */
    public void setOperRelate(String operRelate) {
        this.operRelate = operRelate == null ? null : operRelate.trim();
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
     * 客户等级
     * @return CUS_LEVEL 客户等级
     */
    public String getCusLevel() {
        return cusLevel;
    }

    /**
     * 客户等级
     * @param cusLevel 客户等级
     */
    public void setCusLevel(String cusLevel) {
        this.cusLevel = cusLevel == null ? null : cusLevel.trim();
    }

    /**
     * 社保卡号
     * @return SOC_SCR_NO 社保卡号
     */
    public String getSocScrNo() {
        return socScrNo;
    }

    /**
     * 社保卡号
     * @param socScrNo 社保卡号
     */
    public void setSocScrNo(String socScrNo) {
        this.socScrNo = socScrNo == null ? null : socScrNo.trim();
    }

    /**
     * null
     * @return PROV_AREA_CODE null
     */
    public String getProvAreaCode() {
        return provAreaCode;
    }

    /**
     * null
     * @param provAreaCode null
     */
    public void setProvAreaCode(String provAreaCode) {
        this.provAreaCode = provAreaCode == null ? null : provAreaCode.trim();
    }

    /**
     * null
     * @return REG_RES_AREA_CODE null
     */
    public String getRegResAreaCode() {
        return regResAreaCode;
    }

    /**
     * null
     * @param regResAreaCode null
     */
    public void setRegResAreaCode(String regResAreaCode) {
        this.regResAreaCode = regResAreaCode == null ? null : regResAreaCode.trim();
    }

    /**
     * 微信
     * @return WE_CHAT 微信
     */
    public String getWeChat() {
        return weChat;
    }

    /**
     * 微信
     * @param weChat 微信
     */
    public void setWeChat(String weChat) {
        this.weChat = weChat == null ? null : weChat.trim();
    }

    /**
     * QQ
     * @return QQ QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * QQ
     * @param qq QQ
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * 银行卡号
     * @return BANK_CARD_NO 银行卡号
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * 银行卡号
     * @param bankCardNo 银行卡号
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    /**
     * null
     * @return MOBILE_ATTRIBUTION null
     */
    public String getMobileAttribution() {
        return mobileAttribution;
    }

    /**
     * null
     * @param mobileAttribution null
     */
    public void setMobileAttribution(String mobileAttribution) {
        this.mobileAttribution = mobileAttribution == null ? null : mobileAttribution.trim();
    }

    /**
     * null
     * @return BANK_CARD_NAME null
     */
    public String getBankCardName() {
        return bankCardName;
    }

    /**
     * null
     * @param bankCardName null
     */
    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName == null ? null : bankCardName.trim();
    }

    /**
     * null
     * @return HOUSE_FUND_ACCOUNT null
     */
    public String getHouseFundAccount() {
        return houseFundAccount;
    }

    /**
     * null
     * @param houseFundAccount null
     */
    public void setHouseFundAccount(String houseFundAccount) {
        this.houseFundAccount = houseFundAccount == null ? null : houseFundAccount.trim();
    }

    /**
     * null
     * @return INDIV_SPS_IDCARD_OBV null
     */
    public String getIndivSpsIdcardObv() {
        return indivSpsIdcardObv;
    }

    /**
     * null
     * @param indivSpsIdcardObv null
     */
    public void setIndivSpsIdcardObv(String indivSpsIdcardObv) {
        this.indivSpsIdcardObv = indivSpsIdcardObv == null ? null : indivSpsIdcardObv.trim();
    }

    /**
     * 职业描述
     * @return INDIV_OCC_NAME 职业描述
     */
    public String getIndivOccName() {
        return indivOccName;
    }

    /**
     * 职业描述
     * @param indivOccName 职业描述
     */
    public void setIndivOccName(String indivOccName) {
        this.indivOccName = indivOccName == null ? null : indivOccName.trim();
    }

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
    
    
}