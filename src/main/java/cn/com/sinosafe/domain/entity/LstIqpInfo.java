package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class LstIqpInfo {
    /**
     * 信保业务流水号
     */
    private String serno;

    /**
     * 产品编号
     */
    private String prdId;

    /**
     * 产品名称
     */
    private String prdName;

    /**
     * 投保单编号
     */
    private String coverSerno;

    /**
     * 保单编号
     */
    private String listSerno;

    /**
     * 投保人客户编号（投保人代码）
     */
    private String cusId;

    /**
     * 投保人姓名
     */
    private String cusName;

    /**
     * 客户类型
     */
    private String cusType;

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
     * 婚姻状况
     */
    private String indivMarSt;

    /**
     * 家庭地址
     */
    private String address;

    /**
     * 工作单位
     */
    private String indivComName;

    /**
     * 单位电话
     */
    private String telephone;

    /**
     * 单位地址
     */
    private String indivComAddr;

    /**
     * 投保人国籍
     */
    private String country;

    /**
     * 投保人联系人电话
     */
    private String mobile;

    /**
     * 投保人账户名称
     */
    private String coverAccountName;

    /**
     * 投保人账号
     */
    private String coverAccount;

    /**
     * 被保险人姓名
     */
    private String receiveCusName;

    /**
     * 被保险人编号
     */
    private String receiverCusId;

    /**
     * 被保险人联系电话
     */
    private String receiveCusPhone;

    /**
     * 被保险人地址
     */
    private String receiverCusAddress;

    /**
     * 被保险人证件类型
     */
    private String receiveCusCertType;

    /**
     * 被保险人证件号码
     */
    private String receiveCusCertCode;

    /**
     * 贷款金额
     */
    private BigDecimal amount;

    /**
     * 贷款期限
     */
    private String term;

    /**
     * 还款方式
     */
    private String repaymentMode;

    /**
     * 还款期数
     */
    private String period;

    /**
     * 每期还款额
     */
    private BigDecimal periodMoney;

    /**
     * 借款合同编号
     */
    private String contNo;

    /**
     * 是否微贷
     */
    private String flag;

    /**
     * 利率类型
     */
    private String irType;

    /**
     * 执行年利率
     */
    private BigDecimal grossRate;

    /**
     * 抵押物
     */
    private String guarantyName;

    /**
     * 抵押物编号
     */
    private String guarantyNo;

    /**
     * 抵押物(评估)总价值
     */
    private BigDecimal bankAssessedValue;

    /**
     * 抵押登记证明及编号
     */
    private String certiNo;

    /**
     * 质押物名称
     */
    private String gageName;

    /**
     * 其他担保方式
     */
    private String assureMeansMain;

    /**
     * 序号
     */
    private String numNo;

    /**
     * 续保标志
     */
    private String xubaoFlag;

    /**
     * 续保单号
     */
    private String cOrigPlyNo;

    /**
     * 单证号
     */
    private String cPrnNo;

    /**
     * 险种名称
     */
    private String prdSubCode;

    /**
     * 保额合计
     */
    private BigDecimal coverAmount;

    /**
     * 保额币种(默认人民币)
     */
    private String coverCurrencyType;

    /**
     * 保费合计
     */
    private BigDecimal coverageFee;

    /**
     * 保费币种
     */
    private String feeCurrencyType;

    /**
     * 汇率
     */
    private BigDecimal exchangeRate;

    /**
     * 费率（‰）
     */
    private BigDecimal rate;

    /**
     * 手续费比例
     */
    private BigDecimal serviceCharge;

    /**
     * 保险起期
     */
    private String coverStartDate;

    /**
     * 保险止期
     */
    private String coverEndDate;

    /**
     * 批改生效起期
     */
    private String tEdrBgnTm;

    /**
     * 批改生效止期
     */
    private String tEdrEndTm;

    /**
     * 投保日期
     */
    private String toubaoDate;

    /**
     * 签单日期
     */
    private String signDate;

    /**
     * 录单日期
     */
    private String inputDate;

    /**
     * 共保标志
     */
    private String togetherFlag;

    /**
     * 共保方式
     */
    private String cConinsrncCde;

    /**
     * 争议解决方式
     */
    private String resolveWay;

    /**
     * 法定申报
     */
    private String cDecFlg;

    /**
     * 分入标志
     */
    private String cInward;

    /**
     * 风险系数
     */
    private BigDecimal nRetProp;

    /**
     * 风险等级
     */
    private String cRiskLvlCde;

    /**
     * 仲裁机构
     */
    private String cSttlDpt;

    /**
     * 免赔额（率）
     */
    private BigDecimal excuseRate;

    /**
     * 短期系数
     */
    private String shortRate;

    /**
     * 是否涉农
     */
    private String isAgriculture;

    /**
     * 洗钱风险等级
     */
    private String riskLevel;

    /**
     * 缴费途径
     */
    private String payWay;

    /**
     * 保单生成（0自动，1手工）
     */
    private String createType;

    /**
     * 打印方式(0中文,1英文)
     */
    private String printWay;

    /**
     * 业务来源
     */
    private String businessSource;

    /**
     * 机构部门
     */
    private String mainBrId;

    /**
     * 业务线
     */
    private String cBuisType;

    /**
     * 录入人
     */
    private String inputId;

    /**
     * 业务员代码
     */
    private String actorno;

    /**
     * 业务员联系电话
     */
    private String telnum;

    /**
     * 销售团队
     */
    private String cSalegrpCde;

    /**
     * 代理人
     */
    private String cCmpnyAgtCde;

    /**
     * 预约协议
     */
    private String cAgtAgrNo1;

    /**
     * 告知
     */
    private String cRemark;

    /**
     * 临分标志
     */
    private String cReinsrcFlg;

    /**
     * 协作人
     */
    private String cTrueAgtCde;

    /**
     * 项目系数
     */
    private BigDecimal nProProp;

    /**
     * 渠道系数
     */
    private BigDecimal nAgtProp;

    /**
     * 渠道类型
     */
    private String cQdlx;

    /**
     * 提奖系数
     */
    private String cTjxs;

    /**
     * 其中
     */
    private String cNyqz;

    /**
     * 分散性业务标志
     */
    private String cFsywFlag;

    /**
     * 业务类型
     */
    private String cOprtType;

    /**
     * 业务等级
     */
    private String cOprtLvl;

    /**
     * 销售员
     */
    private String cSlsPer;

    /**
     * 执业证号
     */
    private String cWorkCertif;

    /**
     * 联系方式
     */
    private String cRelatTel;

    /**
     * 销售员电话
     */
    private String cSalesTel;

    /**
     * 上门业务
     */
    private String cVisitService;

    /**
     * 招投标业务
     */
    private String cInviteTitle;

    /**
     * 远程出单点销售团队
     */
    private String cTelewrtSalegrp;

    /**
     * 补传标志
     */
    private String cIsImage;

    /**
     * 影像ID
     */
    private String cImageId;

    /**
     * 补传标志(批改)
     */
    private String cIsImage2;

    /**
     * 补传状态(批改)
     */
    private String cImageState2;

    /**
     * 影像ID（批改）
     */
    private String cImageId2;

    /**
     * 是否不见费(0  否,1  是)
     */
    private String cIsNofee;

    /**
     * 不见费原因
     */
    private String cNofeeReason;

    /**
     * 见费出单标志(0  否,1  是)
     */
    private String cFeeFlag;

    /**
     * 退保费方式
     */
    private String cRetprmType;

    /**
     * 业务绩效比例
     */
    private BigDecimal nPerformance;

    /**
     * 金融保险业务类别
     */
    private String cFinanceYwtyp;

    /**
     * 来源渠道
     */
    private String cBsnsAgent;

    /**
     * 金融机构
     */
    private String cFinanceDpt;

    /**
     * 保单所用再保合同年度
     */
    private String coverYear;

    /**
     * 特别约定
     */
    private String cAppnt;

    /**
     * 合作协议
     */
    private String cAgtAgrNo;

    /**
     * 投保单申请
     */
    private String applyStatus;

    /**
     * 保单状态
     */
    private String coverCreateStatus;

    /**
     * 最后更新人ID
     */
    private String lastUpdId;

    /**
     * 最后更新日期
     */
    private String lastUpdDate;

    /**
     * 调查流水号
     */
    private String iqpLoanSerno;

    /**
     * 客户经理
     */
    private String mgrId;

    /**
     * 客户经理机构
     */
    private String mgrOrg;

    /**
     * 被保险人邮编
     */
    private String zipCode;

    /**
     * 费率系数
     */
    private BigDecimal insRatio;

    /**
     * 商圈编号
     */
    private String channelNo;

    /**
     * 操作标识
     */
    private String optType;

    /**
     * 法定代表人性别
     */
    private String legalSex;

    /**
     * 法定代表人姓名
     */
    private String legalName;

    /**
     * 法定代表人身份证号码
     */
    private String legalCertCode;

    /**
     * 法定代表人家庭住址
     */
    private String legalHomeAddr;

    /**
     * 法定代表人邮编
     */
    private String legalPostCode;

    /**
     * 组织机构代码
     */
    private String comInsCode;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 组织机构证件有效期
     */
    private String comInsExpDate;

    /**
     * 税务登记证号
     */
    private String locTaxRegCode;

    /**
     * 营业执照注册号
     */
    private String regCode;

    /**
     * 营业执照证件有效期
     */
    private String regEndDate;

    /**
     * 法定代表人电话
     */
    private String legalPhone;

    /**
     * null
     */
    private String bizMode;

    /**
     * 注销失败原因
     */
    private String cancelFailCause;

    /**
     * 交易标识
     */
    private String tradeSign;

    /**
     * 收款人账户
     */
    private String payeeAccount;

    /**
     * 收款人开户行
     */
    private String payeeBank;

    /**
     * 保费账户名称
     */
    private String insName;

    /**
     * 保费账户账号
     */
    private String insAccount;

    /**
     * 保费账户开户行
     */
    private String insBank;

    /**
     * 保证金账号
     */
    private String bailAccount;

    /**
     * 是否电子保单
     */
    private String p2pFlag;

    /**
     * p2p平台名称
     */
    private String p2pPlatform;

    /**
     * 审批状态
     */
    private String status;

    /**
     * 业务归属机构
     */
    private String belongBrId;

    /**
     * 协议编号
     */
    private String prdPk;

    /**
     * 是否签署授权书
     */
    private String ispermit;

    /**
     * null
     */
    private String reportStatus;

    /**
     * 放款申请是否成功发送
     */
    private String isMakeLoan;

    /**
     * null
     */
    private String operType;

    /**
     * null
     */
    private String cEdrVersion;

    /**
     * null
     */
    private String isCredit;

    /**
     * 影像资料上传状态
     */
    private String sendImageStatus;

    /**
     * null
     */
    private String termDay;

    /**
     * 期限类型
     */
    private String termTimeType;

    /**
     * 争议处理
     */
    private String disputeDeal;

    /**
     * 处理地址
     */
    private String dealAddress;

    /**
     * 拆分外键
     */
    private String foreignKey;

    /**
     * 出单频率
     */
    private String issuingFreq;

    /**
     * 是否见费出单
     */
    private String isIssueCost;

    /**
     * 批改次数
     */
    private Short mdfTime;

    /**
     * 是否成功上报证监会
     */
    private String isReport;

    /**
     * 开票类型
     */
    private String invoiceType;

    /**
     * 开户行名称
     */
    private String coverAccountBank;

    /**
     * 专票联系人
     */
    private String invoiceContact;

    /**
     * 联系人手机号
     */
    private String invoiceContactMob;

    /**
     * 联系人固定电话
     */
    private String invoiceContactTel;

    /**
     * 电子账单接收邮箱
     */
    private String billSentMail;

    /**
     * 承保比例
     */
    private BigDecimal underwritingRate;

    /**
     * null
     */
    private BigDecimal coinsuranceRate;

    /**
     * null
     */
    private String tempAppNo;

    /**
     * 是否缴费
     */
    private String isPayed;

    /**
     * 支付号  1-已申请支付号 ,2- 申请支付号失败 3- 缴费成功 4- 缴费失败
     */
    private String payAppNo;

    /**
     * null
     */
    private String tUdrDate;

    /**
     * 保险责任类别
     */
    private String insuranceType;

    /**
     * 保险责任类别中文显示
     */
    private String insuranceTypeName;

    /**
     * null
     */
    private String operateId;

    /**
     * null
     */
    private String isSendSmss;

    /**
     * 投保人法定代表人证件类型
     */
    private String legalCertType;

    /**
     * 被保险人法定代表人姓名
     */
    private String receiveLegalName;

    /**
     * 贷款总人数
     */
    private Short personCount;

    /**
     * 被保险人法定代表人联系电话
     */
    private String receiveLegalPhone;

    /**
     * 被保险人法定代表人证件号码
     */
    private String receiveLegalCertCode;

    /**
     * 被保险人法定代表人证件类型
     */
    private String receiveLegalCertType;

    /**
     * 支付完成时间
     */
    private String payTime;

    /**
     * 纳税人识别号
     */
    private String coverNo;

    /**
     * null
     */
    private BigDecimal ruleLoanAmt;

    /**
     * 银行卡关联手机号
     */
    private String bankPhone;

    /**
     * null
     */
    private String payeeAccountName;

    /**
     * 贷款起始日
     */
    private String loanStartDate;

    /**
     * 贷款终止日
     */
    private String loanEndDate;

    /**
     * 五级分类标志 (STD_CLA_TYPE)
     */
    private String cla;

    /**
     * 渠道协议
     */
    private String agreementNo;

    /**
     * 渠道代码
     */
    private String intermediaryCode;

    /**
     * 批改状态 (STD_LST_MOD_TYPE)
     */
    private String modStatus;

    /**
     * 是否加贷保费INCLUDE_INS_FEE
     */
    private String includeInsFee;

    /**
     * null
     */
    private BigDecimal oldCoverAmount;

    /**
     * null
     */
    private BigDecimal oldLoanAmount;

    /**
     * null
     */
    private BigDecimal oldFeeRatio;

    /**
     * 抵扣券ID
     */
    private String couponId;

    /**
     * 抵扣券金额
     */
    private BigDecimal premiumPrice;

    /**
     * 投保单URL
     */
    private String insuranceSlipUrl;

    /**
     * null
     */
    private String applyPayDate;

    /**
     * null
     */
    private String applyAppNoTime;

    /**
     * null
     */
    private String subrogationUrl;

    /**
     * null
     */
    private Long estimationAmount;

    /**
     * 流水号--三湘银行
     */
    private String sxyhSerno;

    /**
     * 审批结果--三湘银行
     */
    private String sxyhStatus;

    /**
     * 上传标识--三湘银行(1-审批文件已上传 2-放款文件已上传 默认空)
     */
    private String sxyhUploadFlag;

    /**
     * 审批意见--三湘银行
     */
    private String sxyhStatusMsg;

    /**
     * null
     */
    private String lastPayTime;

    /**
     * null
     */
    private String payFailCause;

    /**
     * 是否承保附加险1是、2否
     */
    private String accessoryRisk;

    /**
     * 是否分期/1-期缴 2-趸缴
     */
    private String singlePrem;

    /**
     * 首期费率
     */
    private String firstPremRate;

    /**
     * 每期费率
     */
    private String everyPremRate;

    /**
     * null
     */
    private String withHoldKind;

    /**
     * null
     */
    private String coinsuranceListSerno;

    /**
     * 原始核保日期
     */
    private String underwriteenddate;

    /**
     * 条款
     */
    private String provision;

    /**
     * 自主收款开户行号
     */
    private String payeeBankNo;

    /**
     * 受托支付开户行名
     */
    private String etLoanAccBankNme;

    /**
     * 受托支付开户行号
     */
    private String etLoanAccBank;

    /**
     * 受托支付账户名
     */
    private String etLoanAccName;

    /**
     * 受托支付账号
     */
    private String etLoanAcc;

    /**
     * 支付方式
     */
    private String etPayType;

    /**
     * null
     */
    private String coverAccountBankNme;

    /**
     * 经营主体全称
     */
    private String mtReceiveCusName;

    /**
     * 客户类型
     */
    private String mtCusType;

    /**
     * 证件类型
     */
    private String mtCertType;

    /**
     * 证件号码
     */
    private String mtCertCode;

    /**
     * 单位所属行业
     */
    private String mtIndustryType;
    
    /**
     * 特殊分保标识
     */
    private String reSpecialInd;

    /**
     * 信保业务流水号
     * @return SERNO 信保业务流水号
     */
    public String getSerno() {
        return serno;
    }

    /**
     * 信保业务流水号
     * @param serno 信保业务流水号
     */
    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    /**
     * 产品编号
     * @return PRD_ID 产品编号
     */
    public String getPrdId() {
        return prdId;
    }

    /**
     * 产品编号
     * @param prdId 产品编号
     */
    public void setPrdId(String prdId) {
        this.prdId = prdId == null ? null : prdId.trim();
    }

    /**
     * 产品名称
     * @return PRD_NAME 产品名称
     */
    public String getPrdName() {
        return prdName;
    }

    /**
     * 产品名称
     * @param prdName 产品名称
     */
    public void setPrdName(String prdName) {
        this.prdName = prdName == null ? null : prdName.trim();
    }

    /**
     * 投保单编号
     * @return COVER_SERNO 投保单编号
     */
    public String getCoverSerno() {
        return coverSerno;
    }

    /**
     * 投保单编号
     * @param coverSerno 投保单编号
     */
    public void setCoverSerno(String coverSerno) {
        this.coverSerno = coverSerno == null ? null : coverSerno.trim();
    }

    /**
     * 保单编号
     * @return LIST_SERNO 保单编号
     */
    public String getListSerno() {
        return listSerno;
    }

    /**
     * 保单编号
     * @param listSerno 保单编号
     */
    public void setListSerno(String listSerno) {
        this.listSerno = listSerno == null ? null : listSerno.trim();
    }

    /**
     * 投保人客户编号（投保人代码）
     * @return CUS_ID 投保人客户编号（投保人代码）
     */
    public String getCusId() {
        return cusId;
    }

    /**
     * 投保人客户编号（投保人代码）
     * @param cusId 投保人客户编号（投保人代码）
     */
    public void setCusId(String cusId) {
        this.cusId = cusId == null ? null : cusId.trim();
    }

    /**
     * 投保人姓名
     * @return CUS_NAME 投保人姓名
     */
    public String getCusName() {
        return cusName;
    }

    /**
     * 投保人姓名
     * @param cusName 投保人姓名
     */
    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
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
     * 家庭地址
     * @return ADDRESS 家庭地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 家庭地址
     * @param address 家庭地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
     * 单位电话
     * @return TELEPHONE 单位电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 单位电话
     * @param telephone 单位电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
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
     * 投保人国籍
     * @return COUNTRY 投保人国籍
     */
    public String getCountry() {
        return country;
    }

    /**
     * 投保人国籍
     * @param country 投保人国籍
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 投保人联系人电话
     * @return MOBILE 投保人联系人电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 投保人联系人电话
     * @param mobile 投保人联系人电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 投保人账户名称
     * @return COVER_ACCOUNT_NAME 投保人账户名称
     */
    public String getCoverAccountName() {
        return coverAccountName;
    }

    /**
     * 投保人账户名称
     * @param coverAccountName 投保人账户名称
     */
    public void setCoverAccountName(String coverAccountName) {
        this.coverAccountName = coverAccountName == null ? null : coverAccountName.trim();
    }

    /**
     * 投保人账号
     * @return COVER_ACCOUNT 投保人账号
     */
    public String getCoverAccount() {
        return coverAccount;
    }

    /**
     * 投保人账号
     * @param coverAccount 投保人账号
     */
    public void setCoverAccount(String coverAccount) {
        this.coverAccount = coverAccount == null ? null : coverAccount.trim();
    }

    /**
     * 被保险人姓名
     * @return RECEIVE_CUS_NAME 被保险人姓名
     */
    public String getReceiveCusName() {
        return receiveCusName;
    }

    /**
     * 被保险人姓名
     * @param receiveCusName 被保险人姓名
     */
    public void setReceiveCusName(String receiveCusName) {
        this.receiveCusName = receiveCusName == null ? null : receiveCusName.trim();
    }

    /**
     * 被保险人编号
     * @return RECEIVER_CUS_ID 被保险人编号
     */
    public String getReceiverCusId() {
        return receiverCusId;
    }

    /**
     * 被保险人编号
     * @param receiverCusId 被保险人编号
     */
    public void setReceiverCusId(String receiverCusId) {
        this.receiverCusId = receiverCusId == null ? null : receiverCusId.trim();
    }

    /**
     * 被保险人联系电话
     * @return RECEIVE_CUS_PHONE 被保险人联系电话
     */
    public String getReceiveCusPhone() {
        return receiveCusPhone;
    }

    /**
     * 被保险人联系电话
     * @param receiveCusPhone 被保险人联系电话
     */
    public void setReceiveCusPhone(String receiveCusPhone) {
        this.receiveCusPhone = receiveCusPhone == null ? null : receiveCusPhone.trim();
    }

    /**
     * 被保险人地址
     * @return RECEIVER_CUS_ADDRESS 被保险人地址
     */
    public String getReceiverCusAddress() {
        return receiverCusAddress;
    }

    /**
     * 被保险人地址
     * @param receiverCusAddress 被保险人地址
     */
    public void setReceiverCusAddress(String receiverCusAddress) {
        this.receiverCusAddress = receiverCusAddress == null ? null : receiverCusAddress.trim();
    }

    /**
     * 被保险人证件类型
     * @return RECEIVE_CUS_CERT_TYPE 被保险人证件类型
     */
    public String getReceiveCusCertType() {
        return receiveCusCertType;
    }

    /**
     * 被保险人证件类型
     * @param receiveCusCertType 被保险人证件类型
     */
    public void setReceiveCusCertType(String receiveCusCertType) {
        this.receiveCusCertType = receiveCusCertType == null ? null : receiveCusCertType.trim();
    }

    /**
     * 被保险人证件号码
     * @return RECEIVE_CUS_CERT_CODE 被保险人证件号码
     */
    public String getReceiveCusCertCode() {
        return receiveCusCertCode;
    }

    /**
     * 被保险人证件号码
     * @param receiveCusCertCode 被保险人证件号码
     */
    public void setReceiveCusCertCode(String receiveCusCertCode) {
        this.receiveCusCertCode = receiveCusCertCode == null ? null : receiveCusCertCode.trim();
    }

    /**
     * 贷款金额
     * @return AMOUNT 贷款金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 贷款金额
     * @param amount 贷款金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 贷款期限
     * @return TERM 贷款期限
     */
    public String getTerm() {
        return term;
    }

    /**
     * 贷款期限
     * @param term 贷款期限
     */
    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    /**
     * 还款方式
     * @return REPAYMENT_MODE 还款方式
     */
    public String getRepaymentMode() {
        return repaymentMode;
    }

    /**
     * 还款方式
     * @param repaymentMode 还款方式
     */
    public void setRepaymentMode(String repaymentMode) {
        this.repaymentMode = repaymentMode == null ? null : repaymentMode.trim();
    }

    /**
     * 还款期数
     * @return PERIOD 还款期数
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 还款期数
     * @param period 还款期数
     */
    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    /**
     * 每期还款额
     * @return PERIOD_MONEY 每期还款额
     */
    public BigDecimal getPeriodMoney() {
        return periodMoney;
    }

    /**
     * 每期还款额
     * @param periodMoney 每期还款额
     */
    public void setPeriodMoney(BigDecimal periodMoney) {
        this.periodMoney = periodMoney;
    }

    /**
     * 借款合同编号
     * @return CONT_NO 借款合同编号
     */
    public String getContNo() {
        return contNo;
    }

    /**
     * 借款合同编号
     * @param contNo 借款合同编号
     */
    public void setContNo(String contNo) {
        this.contNo = contNo == null ? null : contNo.trim();
    }

    /**
     * 是否微贷
     * @return FLAG 是否微贷
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 是否微贷
     * @param flag 是否微贷
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * 利率类型
     * @return IR_TYPE 利率类型
     */
    public String getIrType() {
        return irType;
    }

    /**
     * 利率类型
     * @param irType 利率类型
     */
    public void setIrType(String irType) {
        this.irType = irType == null ? null : irType.trim();
    }

    /**
     * 执行年利率
     * @return GROSS_RATE 执行年利率
     */
    public BigDecimal getGrossRate() {
        return grossRate;
    }

    /**
     * 执行年利率
     * @param grossRate 执行年利率
     */
    public void setGrossRate(BigDecimal grossRate) {
        this.grossRate = grossRate;
    }

    /**
     * 抵押物
     * @return GUARANTY_NAME 抵押物
     */
    public String getGuarantyName() {
        return guarantyName;
    }

    /**
     * 抵押物
     * @param guarantyName 抵押物
     */
    public void setGuarantyName(String guarantyName) {
        this.guarantyName = guarantyName == null ? null : guarantyName.trim();
    }

    /**
     * 抵押物编号
     * @return GUARANTY_NO 抵押物编号
     */
    public String getGuarantyNo() {
        return guarantyNo;
    }

    /**
     * 抵押物编号
     * @param guarantyNo 抵押物编号
     */
    public void setGuarantyNo(String guarantyNo) {
        this.guarantyNo = guarantyNo == null ? null : guarantyNo.trim();
    }

    /**
     * 抵押物(评估)总价值
     * @return BANK_ASSESSED_VALUE 抵押物(评估)总价值
     */
    public BigDecimal getBankAssessedValue() {
        return bankAssessedValue;
    }

    /**
     * 抵押物(评估)总价值
     * @param bankAssessedValue 抵押物(评估)总价值
     */
    public void setBankAssessedValue(BigDecimal bankAssessedValue) {
        this.bankAssessedValue = bankAssessedValue;
    }

    /**
     * 抵押登记证明及编号
     * @return CERTI_NO 抵押登记证明及编号
     */
    public String getCertiNo() {
        return certiNo;
    }

    /**
     * 抵押登记证明及编号
     * @param certiNo 抵押登记证明及编号
     */
    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo == null ? null : certiNo.trim();
    }

    /**
     * 质押物名称
     * @return GAGE_NAME 质押物名称
     */
    public String getGageName() {
        return gageName;
    }

    /**
     * 质押物名称
     * @param gageName 质押物名称
     */
    public void setGageName(String gageName) {
        this.gageName = gageName == null ? null : gageName.trim();
    }

    /**
     * 其他担保方式
     * @return ASSURE_MEANS_MAIN 其他担保方式
     */
    public String getAssureMeansMain() {
        return assureMeansMain;
    }

    /**
     * 其他担保方式
     * @param assureMeansMain 其他担保方式
     */
    public void setAssureMeansMain(String assureMeansMain) {
        this.assureMeansMain = assureMeansMain == null ? null : assureMeansMain.trim();
    }

    /**
     * 序号
     * @return NUM_NO 序号
     */
    public String getNumNo() {
        return numNo;
    }

    /**
     * 序号
     * @param numNo 序号
     */
    public void setNumNo(String numNo) {
        this.numNo = numNo == null ? null : numNo.trim();
    }

    /**
     * 续保标志
     * @return XUBAO_FLAG 续保标志
     */
    public String getXubaoFlag() {
        return xubaoFlag;
    }

    /**
     * 续保标志
     * @param xubaoFlag 续保标志
     */
    public void setXubaoFlag(String xubaoFlag) {
        this.xubaoFlag = xubaoFlag == null ? null : xubaoFlag.trim();
    }

    /**
     * 续保单号
     * @return C_ORIG_PLY_NO 续保单号
     */
    public String getcOrigPlyNo() {
        return cOrigPlyNo;
    }

    /**
     * 续保单号
     * @param cOrigPlyNo 续保单号
     */
    public void setcOrigPlyNo(String cOrigPlyNo) {
        this.cOrigPlyNo = cOrigPlyNo == null ? null : cOrigPlyNo.trim();
    }

    /**
     * 单证号
     * @return C_PRN_NO 单证号
     */
    public String getcPrnNo() {
        return cPrnNo;
    }

    /**
     * 单证号
     * @param cPrnNo 单证号
     */
    public void setcPrnNo(String cPrnNo) {
        this.cPrnNo = cPrnNo == null ? null : cPrnNo.trim();
    }

    /**
     * 险种名称
     * @return PRD_SUB_CODE 险种名称
     */
    public String getPrdSubCode() {
        return prdSubCode;
    }

    /**
     * 险种名称
     * @param prdSubCode 险种名称
     */
    public void setPrdSubCode(String prdSubCode) {
        this.prdSubCode = prdSubCode == null ? null : prdSubCode.trim();
    }

    /**
     * 保额合计
     * @return COVER_AMOUNT 保额合计
     */
    public BigDecimal getCoverAmount() {
        return coverAmount;
    }

    /**
     * 保额合计
     * @param coverAmount 保额合计
     */
    public void setCoverAmount(BigDecimal coverAmount) {
        this.coverAmount = coverAmount;
    }

    /**
     * 保额币种(默认人民币)
     * @return COVER_CURRENCY_TYPE 保额币种(默认人民币)
     */
    public String getCoverCurrencyType() {
        return coverCurrencyType;
    }

    /**
     * 保额币种(默认人民币)
     * @param coverCurrencyType 保额币种(默认人民币)
     */
    public void setCoverCurrencyType(String coverCurrencyType) {
        this.coverCurrencyType = coverCurrencyType == null ? null : coverCurrencyType.trim();
    }

    /**
     * 保费合计
     * @return COVERAGE_FEE 保费合计
     */
    public BigDecimal getCoverageFee() {
        return coverageFee;
    }

    /**
     * 保费合计
     * @param coverageFee 保费合计
     */
    public void setCoverageFee(BigDecimal coverageFee) {
        this.coverageFee = coverageFee;
    }

    /**
     * 保费币种
     * @return FEE_CURRENCY_TYPE 保费币种
     */
    public String getFeeCurrencyType() {
        return feeCurrencyType;
    }

    /**
     * 保费币种
     * @param feeCurrencyType 保费币种
     */
    public void setFeeCurrencyType(String feeCurrencyType) {
        this.feeCurrencyType = feeCurrencyType == null ? null : feeCurrencyType.trim();
    }

    /**
     * 汇率
     * @return EXCHANGE_RATE 汇率
     */
    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    /**
     * 汇率
     * @param exchangeRate 汇率
     */
    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * 费率（‰）
     * @return RATE 费率（‰）
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * 费率（‰）
     * @param rate 费率（‰）
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * 手续费比例
     * @return SERVICE_CHARGE 手续费比例
     */
    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    /**
     * 手续费比例
     * @param serviceCharge 手续费比例
     */
    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    /**
     * 保险起期
     * @return COVER_START_DATE 保险起期
     */
    public String getCoverStartDate() {
        return coverStartDate;
    }

    /**
     * 保险起期
     * @param coverStartDate 保险起期
     */
    public void setCoverStartDate(String coverStartDate) {
        this.coverStartDate = coverStartDate == null ? null : coverStartDate.trim();
    }

    /**
     * 保险止期
     * @return COVER_END_DATE 保险止期
     */
    public String getCoverEndDate() {
        return coverEndDate;
    }

    /**
     * 保险止期
     * @param coverEndDate 保险止期
     */
    public void setCoverEndDate(String coverEndDate) {
        this.coverEndDate = coverEndDate == null ? null : coverEndDate.trim();
    }

    /**
     * 批改生效起期
     * @return T_EDR_BGN_TM 批改生效起期
     */
    public String gettEdrBgnTm() {
        return tEdrBgnTm;
    }

    /**
     * 批改生效起期
     * @param tEdrBgnTm 批改生效起期
     */
    public void settEdrBgnTm(String tEdrBgnTm) {
        this.tEdrBgnTm = tEdrBgnTm == null ? null : tEdrBgnTm.trim();
    }

    /**
     * 批改生效止期
     * @return T_EDR_END_TM 批改生效止期
     */
    public String gettEdrEndTm() {
        return tEdrEndTm;
    }

    /**
     * 批改生效止期
     * @param tEdrEndTm 批改生效止期
     */
    public void settEdrEndTm(String tEdrEndTm) {
        this.tEdrEndTm = tEdrEndTm == null ? null : tEdrEndTm.trim();
    }

    /**
     * 投保日期
     * @return TOUBAO_DATE 投保日期
     */
    public String getToubaoDate() {
        return toubaoDate;
    }

    /**
     * 投保日期
     * @param toubaoDate 投保日期
     */
    public void setToubaoDate(String toubaoDate) {
        this.toubaoDate = toubaoDate == null ? null : toubaoDate.trim();
    }

    /**
     * 签单日期
     * @return SIGN_DATE 签单日期
     */
    public String getSignDate() {
        return signDate;
    }

    /**
     * 签单日期
     * @param signDate 签单日期
     */
    public void setSignDate(String signDate) {
        this.signDate = signDate == null ? null : signDate.trim();
    }

    /**
     * 录单日期
     * @return INPUT_DATE 录单日期
     */
    public String getInputDate() {
        return inputDate;
    }

    /**
     * 录单日期
     * @param inputDate 录单日期
     */
    public void setInputDate(String inputDate) {
        this.inputDate = inputDate == null ? null : inputDate.trim();
    }

    /**
     * 共保标志
     * @return TOGETHER_FLAG 共保标志
     */
    public String getTogetherFlag() {
        return togetherFlag;
    }

    /**
     * 共保标志
     * @param togetherFlag 共保标志
     */
    public void setTogetherFlag(String togetherFlag) {
        this.togetherFlag = togetherFlag == null ? null : togetherFlag.trim();
    }

    /**
     * 共保方式
     * @return C_CONINSRNC_CDE 共保方式
     */
    public String getcConinsrncCde() {
        return cConinsrncCde;
    }

    /**
     * 共保方式
     * @param cConinsrncCde 共保方式
     */
    public void setcConinsrncCde(String cConinsrncCde) {
        this.cConinsrncCde = cConinsrncCde == null ? null : cConinsrncCde.trim();
    }

    /**
     * 争议解决方式
     * @return RESOLVE_WAY 争议解决方式
     */
    public String getResolveWay() {
        return resolveWay;
    }

    /**
     * 争议解决方式
     * @param resolveWay 争议解决方式
     */
    public void setResolveWay(String resolveWay) {
        this.resolveWay = resolveWay == null ? null : resolveWay.trim();
    }

    /**
     * 法定申报
     * @return C_DEC_FLG 法定申报
     */
    public String getcDecFlg() {
        return cDecFlg;
    }

    /**
     * 法定申报
     * @param cDecFlg 法定申报
     */
    public void setcDecFlg(String cDecFlg) {
        this.cDecFlg = cDecFlg == null ? null : cDecFlg.trim();
    }

    /**
     * 分入标志
     * @return C_INWARD 分入标志
     */
    public String getcInward() {
        return cInward;
    }

    /**
     * 分入标志
     * @param cInward 分入标志
     */
    public void setcInward(String cInward) {
        this.cInward = cInward == null ? null : cInward.trim();
    }

    /**
     * 风险系数
     * @return N_RET_PROP 风险系数
     */
    public BigDecimal getnRetProp() {
        return nRetProp;
    }

    /**
     * 风险系数
     * @param nRetProp 风险系数
     */
    public void setnRetProp(BigDecimal nRetProp) {
        this.nRetProp = nRetProp;
    }

    /**
     * 风险等级
     * @return C_RISK_LVL_CDE 风险等级
     */
    public String getcRiskLvlCde() {
        return cRiskLvlCde;
    }

    /**
     * 风险等级
     * @param cRiskLvlCde 风险等级
     */
    public void setcRiskLvlCde(String cRiskLvlCde) {
        this.cRiskLvlCde = cRiskLvlCde == null ? null : cRiskLvlCde.trim();
    }

    /**
     * 仲裁机构
     * @return C_STTL_DPT 仲裁机构
     */
    public String getcSttlDpt() {
        return cSttlDpt;
    }

    /**
     * 仲裁机构
     * @param cSttlDpt 仲裁机构
     */
    public void setcSttlDpt(String cSttlDpt) {
        this.cSttlDpt = cSttlDpt == null ? null : cSttlDpt.trim();
    }

    /**
     * 免赔额（率）
     * @return EXCUSE_RATE 免赔额（率）
     */
    public BigDecimal getExcuseRate() {
        return excuseRate;
    }

    /**
     * 免赔额（率）
     * @param excuseRate 免赔额（率）
     */
    public void setExcuseRate(BigDecimal excuseRate) {
        this.excuseRate = excuseRate;
    }

    /**
     * 短期系数
     * @return SHORT_RATE 短期系数
     */
    public String getShortRate() {
        return shortRate;
    }

    /**
     * 短期系数
     * @param shortRate 短期系数
     */
    public void setShortRate(String shortRate) {
        this.shortRate = shortRate == null ? null : shortRate.trim();
    }

    /**
     * 是否涉农
     * @return IS_AGRICULTURE 是否涉农
     */
    public String getIsAgriculture() {
        return isAgriculture;
    }

    /**
     * 是否涉农
     * @param isAgriculture 是否涉农
     */
    public void setIsAgriculture(String isAgriculture) {
        this.isAgriculture = isAgriculture == null ? null : isAgriculture.trim();
    }

    /**
     * 洗钱风险等级
     * @return RISK_LEVEL 洗钱风险等级
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * 洗钱风险等级
     * @param riskLevel 洗钱风险等级
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    /**
     * 缴费途径
     * @return PAY_WAY 缴费途径
     */
    public String getPayWay() {
        return payWay;
    }

    /**
     * 缴费途径
     * @param payWay 缴费途径
     */
    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    /**
     * 保单生成（0自动，1手工）
     * @return CREATE_TYPE 保单生成（0自动，1手工）
     */
    public String getCreateType() {
        return createType;
    }

    /**
     * 保单生成（0自动，1手工）
     * @param createType 保单生成（0自动，1手工）
     */
    public void setCreateType(String createType) {
        this.createType = createType == null ? null : createType.trim();
    }

    /**
     * 打印方式(0中文,1英文)
     * @return PRINT_WAY 打印方式(0中文,1英文)
     */
    public String getPrintWay() {
        return printWay;
    }

    /**
     * 打印方式(0中文,1英文)
     * @param printWay 打印方式(0中文,1英文)
     */
    public void setPrintWay(String printWay) {
        this.printWay = printWay == null ? null : printWay.trim();
    }

    /**
     * 业务来源
     * @return BUSINESS_SOURCE 业务来源
     */
    public String getBusinessSource() {
        return businessSource;
    }

    /**
     * 业务来源
     * @param businessSource 业务来源
     */
    public void setBusinessSource(String businessSource) {
        this.businessSource = businessSource == null ? null : businessSource.trim();
    }

    /**
     * 机构部门
     * @return MAIN_BR_ID 机构部门
     */
    public String getMainBrId() {
        return mainBrId;
    }

    /**
     * 机构部门
     * @param mainBrId 机构部门
     */
    public void setMainBrId(String mainBrId) {
        this.mainBrId = mainBrId == null ? null : mainBrId.trim();
    }

    /**
     * 业务线
     * @return C_BUIS_TYPE 业务线
     */
    public String getcBuisType() {
        return cBuisType;
    }

    /**
     * 业务线
     * @param cBuisType 业务线
     */
    public void setcBuisType(String cBuisType) {
        this.cBuisType = cBuisType == null ? null : cBuisType.trim();
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
     * 业务员代码
     * @return ACTORNO 业务员代码
     */
    public String getActorno() {
        return actorno;
    }

    /**
     * 业务员代码
     * @param actorno 业务员代码
     */
    public void setActorno(String actorno) {
        this.actorno = actorno == null ? null : actorno.trim();
    }

    /**
     * 业务员联系电话
     * @return TELNUM 业务员联系电话
     */
    public String getTelnum() {
        return telnum;
    }

    /**
     * 业务员联系电话
     * @param telnum 业务员联系电话
     */
    public void setTelnum(String telnum) {
        this.telnum = telnum == null ? null : telnum.trim();
    }

    /**
     * 销售团队
     * @return C_SALEGRP_CDE 销售团队
     */
    public String getcSalegrpCde() {
        return cSalegrpCde;
    }

    /**
     * 销售团队
     * @param cSalegrpCde 销售团队
     */
    public void setcSalegrpCde(String cSalegrpCde) {
        this.cSalegrpCde = cSalegrpCde == null ? null : cSalegrpCde.trim();
    }

    /**
     * 代理人
     * @return C_CMPNY_AGT_CDE 代理人
     */
    public String getcCmpnyAgtCde() {
        return cCmpnyAgtCde;
    }

    /**
     * 代理人
     * @param cCmpnyAgtCde 代理人
     */
    public void setcCmpnyAgtCde(String cCmpnyAgtCde) {
        this.cCmpnyAgtCde = cCmpnyAgtCde == null ? null : cCmpnyAgtCde.trim();
    }

    /**
     * 预约协议
     * @return C_AGT_AGR_NO1 预约协议
     */
    public String getcAgtAgrNo1() {
        return cAgtAgrNo1;
    }

    /**
     * 预约协议
     * @param cAgtAgrNo1 预约协议
     */
    public void setcAgtAgrNo1(String cAgtAgrNo1) {
        this.cAgtAgrNo1 = cAgtAgrNo1 == null ? null : cAgtAgrNo1.trim();
    }

    /**
     * 告知
     * @return C_REMARK 告知
     */
    public String getcRemark() {
        return cRemark;
    }

    /**
     * 告知
     * @param cRemark 告知
     */
    public void setcRemark(String cRemark) {
        this.cRemark = cRemark == null ? null : cRemark.trim();
    }

    /**
     * 临分标志
     * @return C_REINSRC_FLG 临分标志
     */
    public String getcReinsrcFlg() {
        return cReinsrcFlg;
    }

    /**
     * 临分标志
     * @param cReinsrcFlg 临分标志
     */
    public void setcReinsrcFlg(String cReinsrcFlg) {
        this.cReinsrcFlg = cReinsrcFlg == null ? null : cReinsrcFlg.trim();
    }

    /**
     * 协作人
     * @return C_TRUE_AGT_CDE 协作人
     */
    public String getcTrueAgtCde() {
        return cTrueAgtCde;
    }

    /**
     * 协作人
     * @param cTrueAgtCde 协作人
     */
    public void setcTrueAgtCde(String cTrueAgtCde) {
        this.cTrueAgtCde = cTrueAgtCde == null ? null : cTrueAgtCde.trim();
    }

    /**
     * 项目系数
     * @return N_PRO_PROP 项目系数
     */
    public BigDecimal getnProProp() {
        return nProProp;
    }

    /**
     * 项目系数
     * @param nProProp 项目系数
     */
    public void setnProProp(BigDecimal nProProp) {
        this.nProProp = nProProp;
    }

    /**
     * 渠道系数
     * @return N_AGT_PROP 渠道系数
     */
    public BigDecimal getnAgtProp() {
        return nAgtProp;
    }

    /**
     * 渠道系数
     * @param nAgtProp 渠道系数
     */
    public void setnAgtProp(BigDecimal nAgtProp) {
        this.nAgtProp = nAgtProp;
    }

    /**
     * 渠道类型
     * @return C_QDLX 渠道类型
     */
    public String getcQdlx() {
        return cQdlx;
    }

    /**
     * 渠道类型
     * @param cQdlx 渠道类型
     */
    public void setcQdlx(String cQdlx) {
        this.cQdlx = cQdlx == null ? null : cQdlx.trim();
    }

    /**
     * 提奖系数
     * @return C_TJXS 提奖系数
     */
    public String getcTjxs() {
        return cTjxs;
    }

    /**
     * 提奖系数
     * @param cTjxs 提奖系数
     */
    public void setcTjxs(String cTjxs) {
        this.cTjxs = cTjxs == null ? null : cTjxs.trim();
    }

    /**
     * 其中
     * @return C_NYQZ 其中
     */
    public String getcNyqz() {
        return cNyqz;
    }

    /**
     * 其中
     * @param cNyqz 其中
     */
    public void setcNyqz(String cNyqz) {
        this.cNyqz = cNyqz == null ? null : cNyqz.trim();
    }

    /**
     * 分散性业务标志
     * @return C_FSYW_FLAG 分散性业务标志
     */
    public String getcFsywFlag() {
        return cFsywFlag;
    }

    /**
     * 分散性业务标志
     * @param cFsywFlag 分散性业务标志
     */
    public void setcFsywFlag(String cFsywFlag) {
        this.cFsywFlag = cFsywFlag == null ? null : cFsywFlag.trim();
    }

    /**
     * 业务类型
     * @return C_OPRT_TYPE 业务类型
     */
    public String getcOprtType() {
        return cOprtType;
    }

    /**
     * 业务类型
     * @param cOprtType 业务类型
     */
    public void setcOprtType(String cOprtType) {
        this.cOprtType = cOprtType == null ? null : cOprtType.trim();
    }

    /**
     * 业务等级
     * @return C_OPRT_LVL 业务等级
     */
    public String getcOprtLvl() {
        return cOprtLvl;
    }

    /**
     * 业务等级
     * @param cOprtLvl 业务等级
     */
    public void setcOprtLvl(String cOprtLvl) {
        this.cOprtLvl = cOprtLvl == null ? null : cOprtLvl.trim();
    }

    /**
     * 销售员
     * @return C_SLS_PER 销售员
     */
    public String getcSlsPer() {
        return cSlsPer;
    }

    /**
     * 销售员
     * @param cSlsPer 销售员
     */
    public void setcSlsPer(String cSlsPer) {
        this.cSlsPer = cSlsPer == null ? null : cSlsPer.trim();
    }

    /**
     * 执业证号
     * @return C_WORK_CERTIF 执业证号
     */
    public String getcWorkCertif() {
        return cWorkCertif;
    }

    /**
     * 执业证号
     * @param cWorkCertif 执业证号
     */
    public void setcWorkCertif(String cWorkCertif) {
        this.cWorkCertif = cWorkCertif == null ? null : cWorkCertif.trim();
    }

    /**
     * 联系方式
     * @return C_RELAT_TEL 联系方式
     */
    public String getcRelatTel() {
        return cRelatTel;
    }

    /**
     * 联系方式
     * @param cRelatTel 联系方式
     */
    public void setcRelatTel(String cRelatTel) {
        this.cRelatTel = cRelatTel == null ? null : cRelatTel.trim();
    }

    /**
     * 销售员电话
     * @return C_SALES_TEL 销售员电话
     */
    public String getcSalesTel() {
        return cSalesTel;
    }

    /**
     * 销售员电话
     * @param cSalesTel 销售员电话
     */
    public void setcSalesTel(String cSalesTel) {
        this.cSalesTel = cSalesTel == null ? null : cSalesTel.trim();
    }

    /**
     * 上门业务
     * @return C_VISIT_SERVICE 上门业务
     */
    public String getcVisitService() {
        return cVisitService;
    }

    /**
     * 上门业务
     * @param cVisitService 上门业务
     */
    public void setcVisitService(String cVisitService) {
        this.cVisitService = cVisitService == null ? null : cVisitService.trim();
    }

    /**
     * 招投标业务
     * @return C_INVITE_TITLE 招投标业务
     */
    public String getcInviteTitle() {
        return cInviteTitle;
    }

    /**
     * 招投标业务
     * @param cInviteTitle 招投标业务
     */
    public void setcInviteTitle(String cInviteTitle) {
        this.cInviteTitle = cInviteTitle == null ? null : cInviteTitle.trim();
    }

    /**
     * 远程出单点销售团队
     * @return C_TELEWRT_SALEGRP 远程出单点销售团队
     */
    public String getcTelewrtSalegrp() {
        return cTelewrtSalegrp;
    }

    /**
     * 远程出单点销售团队
     * @param cTelewrtSalegrp 远程出单点销售团队
     */
    public void setcTelewrtSalegrp(String cTelewrtSalegrp) {
        this.cTelewrtSalegrp = cTelewrtSalegrp == null ? null : cTelewrtSalegrp.trim();
    }

    /**
     * 补传标志
     * @return C_IS_IMAGE 补传标志
     */
    public String getcIsImage() {
        return cIsImage;
    }

    /**
     * 补传标志
     * @param cIsImage 补传标志
     */
    public void setcIsImage(String cIsImage) {
        this.cIsImage = cIsImage == null ? null : cIsImage.trim();
    }

    /**
     * 影像ID
     * @return C_IMAGE_ID 影像ID
     */
    public String getcImageId() {
        return cImageId;
    }

    /**
     * 影像ID
     * @param cImageId 影像ID
     */
    public void setcImageId(String cImageId) {
        this.cImageId = cImageId == null ? null : cImageId.trim();
    }

    /**
     * 补传标志(批改)
     * @return C_IS_IMAGE2 补传标志(批改)
     */
    public String getcIsImage2() {
        return cIsImage2;
    }

    /**
     * 补传标志(批改)
     * @param cIsImage2 补传标志(批改)
     */
    public void setcIsImage2(String cIsImage2) {
        this.cIsImage2 = cIsImage2 == null ? null : cIsImage2.trim();
    }

    /**
     * 补传状态(批改)
     * @return C_IMAGE_STATE2 补传状态(批改)
     */
    public String getcImageState2() {
        return cImageState2;
    }

    /**
     * 补传状态(批改)
     * @param cImageState2 补传状态(批改)
     */
    public void setcImageState2(String cImageState2) {
        this.cImageState2 = cImageState2 == null ? null : cImageState2.trim();
    }

    /**
     * 影像ID（批改）
     * @return C_IMAGE_ID2 影像ID（批改）
     */
    public String getcImageId2() {
        return cImageId2;
    }

    /**
     * 影像ID（批改）
     * @param cImageId2 影像ID（批改）
     */
    public void setcImageId2(String cImageId2) {
        this.cImageId2 = cImageId2 == null ? null : cImageId2.trim();
    }

    /**
     * 是否不见费(0  否,1  是)
     * @return C_IS_NOFEE 是否不见费(0  否,1  是)
     */
    public String getcIsNofee() {
        return cIsNofee;
    }

    /**
     * 是否不见费(0  否,1  是)
     * @param cIsNofee 是否不见费(0  否,1  是)
     */
    public void setcIsNofee(String cIsNofee) {
        this.cIsNofee = cIsNofee == null ? null : cIsNofee.trim();
    }

    /**
     * 不见费原因
     * @return C_NOFEE_REASON 不见费原因
     */
    public String getcNofeeReason() {
        return cNofeeReason;
    }

    /**
     * 不见费原因
     * @param cNofeeReason 不见费原因
     */
    public void setcNofeeReason(String cNofeeReason) {
        this.cNofeeReason = cNofeeReason == null ? null : cNofeeReason.trim();
    }

    /**
     * 见费出单标志(0  否,1  是)
     * @return C_FEE_FLAG 见费出单标志(0  否,1  是)
     */
    public String getcFeeFlag() {
        return cFeeFlag;
    }

    /**
     * 见费出单标志(0  否,1  是)
     * @param cFeeFlag 见费出单标志(0  否,1  是)
     */
    public void setcFeeFlag(String cFeeFlag) {
        this.cFeeFlag = cFeeFlag == null ? null : cFeeFlag.trim();
    }

    /**
     * 退保费方式
     * @return C_RETPRM_TYPE 退保费方式
     */
    public String getcRetprmType() {
        return cRetprmType;
    }

    /**
     * 退保费方式
     * @param cRetprmType 退保费方式
     */
    public void setcRetprmType(String cRetprmType) {
        this.cRetprmType = cRetprmType == null ? null : cRetprmType.trim();
    }

    /**
     * 业务绩效比例
     * @return N_PERFORMANCE 业务绩效比例
     */
    public BigDecimal getnPerformance() {
        return nPerformance;
    }

    /**
     * 业务绩效比例
     * @param nPerformance 业务绩效比例
     */
    public void setnPerformance(BigDecimal nPerformance) {
        this.nPerformance = nPerformance;
    }

    /**
     * 金融保险业务类别
     * @return C_FINANCE_YWTYP 金融保险业务类别
     */
    public String getcFinanceYwtyp() {
        return cFinanceYwtyp;
    }

    /**
     * 金融保险业务类别
     * @param cFinanceYwtyp 金融保险业务类别
     */
    public void setcFinanceYwtyp(String cFinanceYwtyp) {
        this.cFinanceYwtyp = cFinanceYwtyp == null ? null : cFinanceYwtyp.trim();
    }

    /**
     * 来源渠道
     * @return C_BSNS_AGENT 来源渠道
     */
    public String getcBsnsAgent() {
        return cBsnsAgent;
    }

    /**
     * 来源渠道
     * @param cBsnsAgent 来源渠道
     */
    public void setcBsnsAgent(String cBsnsAgent) {
        this.cBsnsAgent = cBsnsAgent == null ? null : cBsnsAgent.trim();
    }

    /**
     * 金融机构
     * @return C_FINANCE_DPT 金融机构
     */
    public String getcFinanceDpt() {
        return cFinanceDpt;
    }

    /**
     * 金融机构
     * @param cFinanceDpt 金融机构
     */
    public void setcFinanceDpt(String cFinanceDpt) {
        this.cFinanceDpt = cFinanceDpt == null ? null : cFinanceDpt.trim();
    }

    /**
     * 保单所用再保合同年度
     * @return COVER_YEAR 保单所用再保合同年度
     */
    public String getCoverYear() {
        return coverYear;
    }

    /**
     * 保单所用再保合同年度
     * @param coverYear 保单所用再保合同年度
     */
    public void setCoverYear(String coverYear) {
        this.coverYear = coverYear == null ? null : coverYear.trim();
    }

    /**
     * 特别约定
     * @return C_APPNT 特别约定
     */
    public String getcAppnt() {
        return cAppnt;
    }

    /**
     * 特别约定
     * @param cAppnt 特别约定
     */
    public void setcAppnt(String cAppnt) {
        this.cAppnt = cAppnt == null ? null : cAppnt.trim();
    }

    /**
     * 合作协议
     * @return C_AGT_AGR_NO 合作协议
     */
    public String getcAgtAgrNo() {
        return cAgtAgrNo;
    }

    /**
     * 合作协议
     * @param cAgtAgrNo 合作协议
     */
    public void setcAgtAgrNo(String cAgtAgrNo) {
        this.cAgtAgrNo = cAgtAgrNo == null ? null : cAgtAgrNo.trim();
    }

    /**
     * 投保单申请
     * @return APPLY_STATUS 投保单申请
     */
    public String getApplyStatus() {
        return applyStatus;
    }

    /**
     * 投保单申请
     * @param applyStatus 投保单申请
     */
    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    /**
     * 保单状态
     * @return COVER_CREATE_STATUS 保单状态
     */
    public String getCoverCreateStatus() {
        return coverCreateStatus;
    }

    /**
     * 保单状态
     * @param coverCreateStatus 保单状态
     */
    public void setCoverCreateStatus(String coverCreateStatus) {
        this.coverCreateStatus = coverCreateStatus == null ? null : coverCreateStatus.trim();
    }

    /**
     * 最后更新人ID
     * @return LAST_UPD_ID 最后更新人ID
     */
    public String getLastUpdId() {
        return lastUpdId;
    }

    /**
     * 最后更新人ID
     * @param lastUpdId 最后更新人ID
     */
    public void setLastUpdId(String lastUpdId) {
        this.lastUpdId = lastUpdId == null ? null : lastUpdId.trim();
    }

    /**
     * 最后更新日期
     * @return LAST_UPD_DATE 最后更新日期
     */
    public String getLastUpdDate() {
        return lastUpdDate;
    }

    /**
     * 最后更新日期
     * @param lastUpdDate 最后更新日期
     */
    public void setLastUpdDate(String lastUpdDate) {
        this.lastUpdDate = lastUpdDate == null ? null : lastUpdDate.trim();
    }

    /**
     * 调查流水号
     * @return IQP_LOAN_SERNO 调查流水号
     */
    public String getIqpLoanSerno() {
        return iqpLoanSerno;
    }

    /**
     * 调查流水号
     * @param iqpLoanSerno 调查流水号
     */
    public void setIqpLoanSerno(String iqpLoanSerno) {
        this.iqpLoanSerno = iqpLoanSerno == null ? null : iqpLoanSerno.trim();
    }

    /**
     * 客户经理
     * @return MGR_ID 客户经理
     */
    public String getMgrId() {
        return mgrId;
    }

    /**
     * 客户经理
     * @param mgrId 客户经理
     */
    public void setMgrId(String mgrId) {
        this.mgrId = mgrId == null ? null : mgrId.trim();
    }

    /**
     * 客户经理机构
     * @return MGR_ORG 客户经理机构
     */
    public String getMgrOrg() {
        return mgrOrg;
    }

    /**
     * 客户经理机构
     * @param mgrOrg 客户经理机构
     */
    public void setMgrOrg(String mgrOrg) {
        this.mgrOrg = mgrOrg == null ? null : mgrOrg.trim();
    }

    /**
     * 被保险人邮编
     * @return ZIP_CODE 被保险人邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 被保险人邮编
     * @param zipCode 被保险人邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * 费率系数
     * @return INS_RATIO 费率系数
     */
    public BigDecimal getInsRatio() {
        return insRatio;
    }

    /**
     * 费率系数
     * @param insRatio 费率系数
     */
    public void setInsRatio(BigDecimal insRatio) {
        this.insRatio = insRatio;
    }

    /**
     * 商圈编号
     * @return CHANNEL_NO 商圈编号
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * 商圈编号
     * @param channelNo 商圈编号
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo == null ? null : channelNo.trim();
    }

    /**
     * 操作标识
     * @return OPT_TYPE 操作标识
     */
    public String getOptType() {
        return optType;
    }

    /**
     * 操作标识
     * @param optType 操作标识
     */
    public void setOptType(String optType) {
        this.optType = optType == null ? null : optType.trim();
    }

    /**
     * 法定代表人性别
     * @return LEGAL_SEX 法定代表人性别
     */
    public String getLegalSex() {
        return legalSex;
    }

    /**
     * 法定代表人性别
     * @param legalSex 法定代表人性别
     */
    public void setLegalSex(String legalSex) {
        this.legalSex = legalSex == null ? null : legalSex.trim();
    }

    /**
     * 法定代表人姓名
     * @return LEGAL_NAME 法定代表人姓名
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * 法定代表人姓名
     * @param legalName 法定代表人姓名
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    /**
     * 法定代表人身份证号码
     * @return LEGAL_CERT_CODE 法定代表人身份证号码
     */
    public String getLegalCertCode() {
        return legalCertCode;
    }

    /**
     * 法定代表人身份证号码
     * @param legalCertCode 法定代表人身份证号码
     */
    public void setLegalCertCode(String legalCertCode) {
        this.legalCertCode = legalCertCode == null ? null : legalCertCode.trim();
    }

    /**
     * 法定代表人家庭住址
     * @return LEGAL_HOME_ADDR 法定代表人家庭住址
     */
    public String getLegalHomeAddr() {
        return legalHomeAddr;
    }

    /**
     * 法定代表人家庭住址
     * @param legalHomeAddr 法定代表人家庭住址
     */
    public void setLegalHomeAddr(String legalHomeAddr) {
        this.legalHomeAddr = legalHomeAddr == null ? null : legalHomeAddr.trim();
    }

    /**
     * 法定代表人邮编
     * @return LEGAL_POST_CODE 法定代表人邮编
     */
    public String getLegalPostCode() {
        return legalPostCode;
    }

    /**
     * 法定代表人邮编
     * @param legalPostCode 法定代表人邮编
     */
    public void setLegalPostCode(String legalPostCode) {
        this.legalPostCode = legalPostCode == null ? null : legalPostCode.trim();
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
     * 邮编
     * @return POST_CODE 邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 邮编
     * @param postCode 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * 组织机构证件有效期
     * @return COM_INS_EXP_DATE 组织机构证件有效期
     */
    public String getComInsExpDate() {
        return comInsExpDate;
    }

    /**
     * 组织机构证件有效期
     * @param comInsExpDate 组织机构证件有效期
     */
    public void setComInsExpDate(String comInsExpDate) {
        this.comInsExpDate = comInsExpDate == null ? null : comInsExpDate.trim();
    }

    /**
     * 税务登记证号
     * @return LOC_TAX_REG_CODE 税务登记证号
     */
    public String getLocTaxRegCode() {
        return locTaxRegCode;
    }

    /**
     * 税务登记证号
     * @param locTaxRegCode 税务登记证号
     */
    public void setLocTaxRegCode(String locTaxRegCode) {
        this.locTaxRegCode = locTaxRegCode == null ? null : locTaxRegCode.trim();
    }

    /**
     * 营业执照注册号
     * @return REG_CODE 营业执照注册号
     */
    public String getRegCode() {
        return regCode;
    }

    /**
     * 营业执照注册号
     * @param regCode 营业执照注册号
     */
    public void setRegCode(String regCode) {
        this.regCode = regCode == null ? null : regCode.trim();
    }

    /**
     * 营业执照证件有效期
     * @return REG_END_DATE 营业执照证件有效期
     */
    public String getRegEndDate() {
        return regEndDate;
    }

    /**
     * 营业执照证件有效期
     * @param regEndDate 营业执照证件有效期
     */
    public void setRegEndDate(String regEndDate) {
        this.regEndDate = regEndDate == null ? null : regEndDate.trim();
    }

    /**
     * 法定代表人电话
     * @return LEGAL_PHONE 法定代表人电话
     */
    public String getLegalPhone() {
        return legalPhone;
    }

    /**
     * 法定代表人电话
     * @param legalPhone 法定代表人电话
     */
    public void setLegalPhone(String legalPhone) {
        this.legalPhone = legalPhone == null ? null : legalPhone.trim();
    }

    /**
     * null
     * @return BIZ_MODE null
     */
    public String getBizMode() {
        return bizMode;
    }

    /**
     * null
     * @param bizMode null
     */
    public void setBizMode(String bizMode) {
        this.bizMode = bizMode == null ? null : bizMode.trim();
    }

    /**
     * 注销失败原因
     * @return CANCEL_FAIL_CAUSE 注销失败原因
     */
    public String getCancelFailCause() {
        return cancelFailCause;
    }

    /**
     * 注销失败原因
     * @param cancelFailCause 注销失败原因
     */
    public void setCancelFailCause(String cancelFailCause) {
        this.cancelFailCause = cancelFailCause == null ? null : cancelFailCause.trim();
    }

    /**
     * 交易标识
     * @return TRADE_SIGN 交易标识
     */
    public String getTradeSign() {
        return tradeSign;
    }

    /**
     * 交易标识
     * @param tradeSign 交易标识
     */
    public void setTradeSign(String tradeSign) {
        this.tradeSign = tradeSign == null ? null : tradeSign.trim();
    }

    /**
     * 收款人账户
     * @return PAYEE_ACCOUNT 收款人账户
     */
    public String getPayeeAccount() {
        return payeeAccount;
    }

    /**
     * 收款人账户
     * @param payeeAccount 收款人账户
     */
    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount == null ? null : payeeAccount.trim();
    }

    /**
     * 收款人开户行
     * @return PAYEE_BANK 收款人开户行
     */
    public String getPayeeBank() {
        return payeeBank;
    }

    /**
     * 收款人开户行
     * @param payeeBank 收款人开户行
     */
    public void setPayeeBank(String payeeBank) {
        this.payeeBank = payeeBank == null ? null : payeeBank.trim();
    }

    /**
     * 保费账户名称
     * @return INS_NAME 保费账户名称
     */
    public String getInsName() {
        return insName;
    }

    /**
     * 保费账户名称
     * @param insName 保费账户名称
     */
    public void setInsName(String insName) {
        this.insName = insName == null ? null : insName.trim();
    }

    /**
     * 保费账户账号
     * @return INS_ACCOUNT 保费账户账号
     */
    public String getInsAccount() {
        return insAccount;
    }

    /**
     * 保费账户账号
     * @param insAccount 保费账户账号
     */
    public void setInsAccount(String insAccount) {
        this.insAccount = insAccount == null ? null : insAccount.trim();
    }

    /**
     * 保费账户开户行
     * @return INS_BANK 保费账户开户行
     */
    public String getInsBank() {
        return insBank;
    }

    /**
     * 保费账户开户行
     * @param insBank 保费账户开户行
     */
    public void setInsBank(String insBank) {
        this.insBank = insBank == null ? null : insBank.trim();
    }

    /**
     * 保证金账号
     * @return BAIL_ACCOUNT 保证金账号
     */
    public String getBailAccount() {
        return bailAccount;
    }

    /**
     * 保证金账号
     * @param bailAccount 保证金账号
     */
    public void setBailAccount(String bailAccount) {
        this.bailAccount = bailAccount == null ? null : bailAccount.trim();
    }

    /**
     * 是否电子保单
     * @return P2P_FLAG 是否电子保单
     */
    public String getP2pFlag() {
        return p2pFlag;
    }

    /**
     * 是否电子保单
     * @param p2pFlag 是否电子保单
     */
    public void setP2pFlag(String p2pFlag) {
        this.p2pFlag = p2pFlag == null ? null : p2pFlag.trim();
    }

    /**
     * p2p平台名称
     * @return P2P_PLATFORM p2p平台名称
     */
    public String getP2pPlatform() {
        return p2pPlatform;
    }

    /**
     * p2p平台名称
     * @param p2pPlatform p2p平台名称
     */
    public void setP2pPlatform(String p2pPlatform) {
        this.p2pPlatform = p2pPlatform == null ? null : p2pPlatform.trim();
    }

    /**
     * 审批状态
     * @return STATUS 审批状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 审批状态
     * @param status 审批状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 业务归属机构
     * @return BELONG_BR_ID 业务归属机构
     */
    public String getBelongBrId() {
        return belongBrId;
    }

    /**
     * 业务归属机构
     * @param belongBrId 业务归属机构
     */
    public void setBelongBrId(String belongBrId) {
        this.belongBrId = belongBrId == null ? null : belongBrId.trim();
    }

    /**
     * 协议编号
     * @return PRD_PK 协议编号
     */
    public String getPrdPk() {
        return prdPk;
    }

    /**
     * 协议编号
     * @param prdPk 协议编号
     */
    public void setPrdPk(String prdPk) {
        this.prdPk = prdPk == null ? null : prdPk.trim();
    }

    /**
     * 是否签署授权书
     * @return ISPERMIT 是否签署授权书
     */
    public String getIspermit() {
        return ispermit;
    }

    /**
     * 是否签署授权书
     * @param ispermit 是否签署授权书
     */
    public void setIspermit(String ispermit) {
        this.ispermit = ispermit == null ? null : ispermit.trim();
    }

    /**
     * null
     * @return REPORT_STATUS null
     */
    public String getReportStatus() {
        return reportStatus;
    }

    /**
     * null
     * @param reportStatus null
     */
    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus == null ? null : reportStatus.trim();
    }

    /**
     * 放款申请是否成功发送
     * @return IS_MAKE_LOAN 放款申请是否成功发送
     */
    public String getIsMakeLoan() {
        return isMakeLoan;
    }

    /**
     * 放款申请是否成功发送
     * @param isMakeLoan 放款申请是否成功发送
     */
    public void setIsMakeLoan(String isMakeLoan) {
        this.isMakeLoan = isMakeLoan == null ? null : isMakeLoan.trim();
    }

    /**
     * null
     * @return OPER_TYPE null
     */
    public String getOperType() {
        return operType;
    }

    /**
     * null
     * @param operType null
     */
    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    /**
     * null
     * @return C_EDR_VERSION null
     */
    public String getcEdrVersion() {
        return cEdrVersion;
    }

    /**
     * null
     * @param cEdrVersion null
     */
    public void setcEdrVersion(String cEdrVersion) {
        this.cEdrVersion = cEdrVersion == null ? null : cEdrVersion.trim();
    }

    /**
     * null
     * @return IS_CREDIT null
     */
    public String getIsCredit() {
        return isCredit;
    }

    /**
     * null
     * @param isCredit null
     */
    public void setIsCredit(String isCredit) {
        this.isCredit = isCredit == null ? null : isCredit.trim();
    }

    /**
     * 影像资料上传状态
     * @return SEND_IMAGE_STATUS 影像资料上传状态
     */
    public String getSendImageStatus() {
        return sendImageStatus;
    }

    /**
     * 影像资料上传状态
     * @param sendImageStatus 影像资料上传状态
     */
    public void setSendImageStatus(String sendImageStatus) {
        this.sendImageStatus = sendImageStatus == null ? null : sendImageStatus.trim();
    }

    /**
     * null
     * @return TERM_DAY null
     */
    public String getTermDay() {
        return termDay;
    }

    /**
     * null
     * @param termDay null
     */
    public void setTermDay(String termDay) {
        this.termDay = termDay == null ? null : termDay.trim();
    }

    /**
     * 期限类型
     * @return TERM_TIME_TYPE 期限类型
     */
    public String getTermTimeType() {
        return termTimeType;
    }

    /**
     * 期限类型
     * @param termTimeType 期限类型
     */
    public void setTermTimeType(String termTimeType) {
        this.termTimeType = termTimeType == null ? null : termTimeType.trim();
    }

    /**
     * 争议处理
     * @return DISPUTE_DEAL 争议处理
     */
    public String getDisputeDeal() {
        return disputeDeal;
    }

    /**
     * 争议处理
     * @param disputeDeal 争议处理
     */
    public void setDisputeDeal(String disputeDeal) {
        this.disputeDeal = disputeDeal == null ? null : disputeDeal.trim();
    }

    /**
     * 处理地址
     * @return DEAL_ADDRESS 处理地址
     */
    public String getDealAddress() {
        return dealAddress;
    }

    /**
     * 处理地址
     * @param dealAddress 处理地址
     */
    public void setDealAddress(String dealAddress) {
        this.dealAddress = dealAddress == null ? null : dealAddress.trim();
    }

    /**
     * 拆分外键
     * @return FOREIGN_KEY 拆分外键
     */
    public String getForeignKey() {
        return foreignKey;
    }

    /**
     * 拆分外键
     * @param foreignKey 拆分外键
     */
    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey == null ? null : foreignKey.trim();
    }

    /**
     * 出单频率
     * @return ISSUING_FREQ 出单频率
     */
    public String getIssuingFreq() {
        return issuingFreq;
    }

    /**
     * 出单频率
     * @param issuingFreq 出单频率
     */
    public void setIssuingFreq(String issuingFreq) {
        this.issuingFreq = issuingFreq == null ? null : issuingFreq.trim();
    }

    /**
     * 是否见费出单
     * @return IS_ISSUE_COST 是否见费出单
     */
    public String getIsIssueCost() {
        return isIssueCost;
    }

    /**
     * 是否见费出单
     * @param isIssueCost 是否见费出单
     */
    public void setIsIssueCost(String isIssueCost) {
        this.isIssueCost = isIssueCost == null ? null : isIssueCost.trim();
    }

    /**
     * 批改次数
     * @return MDF_TIME 批改次数
     */
    public Short getMdfTime() {
        return mdfTime;
    }

    /**
     * 批改次数
     * @param mdfTime 批改次数
     */
    public void setMdfTime(Short mdfTime) {
        this.mdfTime = mdfTime;
    }

    /**
     * 是否成功上报证监会
     * @return IS_REPORT 是否成功上报证监会
     */
    public String getIsReport() {
        return isReport;
    }

    /**
     * 是否成功上报证监会
     * @param isReport 是否成功上报证监会
     */
    public void setIsReport(String isReport) {
        this.isReport = isReport == null ? null : isReport.trim();
    }

    /**
     * 开票类型
     * @return INVOICE_TYPE 开票类型
     */
    public String getInvoiceType() {
        return invoiceType;
    }

    /**
     * 开票类型
     * @param invoiceType 开票类型
     */
    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    /**
     * 开户行名称
     * @return COVER_ACCOUNT_BANK 开户行名称
     */
    public String getCoverAccountBank() {
        return coverAccountBank;
    }

    /**
     * 开户行名称
     * @param coverAccountBank 开户行名称
     */
    public void setCoverAccountBank(String coverAccountBank) {
        this.coverAccountBank = coverAccountBank == null ? null : coverAccountBank.trim();
    }

    /**
     * 专票联系人
     * @return INVOICE_CONTACT 专票联系人
     */
    public String getInvoiceContact() {
        return invoiceContact;
    }

    /**
     * 专票联系人
     * @param invoiceContact 专票联系人
     */
    public void setInvoiceContact(String invoiceContact) {
        this.invoiceContact = invoiceContact == null ? null : invoiceContact.trim();
    }

    /**
     * 联系人手机号
     * @return INVOICE_CONTACT_MOB 联系人手机号
     */
    public String getInvoiceContactMob() {
        return invoiceContactMob;
    }

    /**
     * 联系人手机号
     * @param invoiceContactMob 联系人手机号
     */
    public void setInvoiceContactMob(String invoiceContactMob) {
        this.invoiceContactMob = invoiceContactMob == null ? null : invoiceContactMob.trim();
    }

    /**
     * 联系人固定电话
     * @return INVOICE_CONTACT_TEL 联系人固定电话
     */
    public String getInvoiceContactTel() {
        return invoiceContactTel;
    }

    /**
     * 联系人固定电话
     * @param invoiceContactTel 联系人固定电话
     */
    public void setInvoiceContactTel(String invoiceContactTel) {
        this.invoiceContactTel = invoiceContactTel == null ? null : invoiceContactTel.trim();
    }

    /**
     * 电子账单接收邮箱
     * @return BILL_SENT_MAIL 电子账单接收邮箱
     */
    public String getBillSentMail() {
        return billSentMail;
    }

    /**
     * 电子账单接收邮箱
     * @param billSentMail 电子账单接收邮箱
     */
    public void setBillSentMail(String billSentMail) {
        this.billSentMail = billSentMail == null ? null : billSentMail.trim();
    }

    /**
     * 承保比例
     * @return UNDERWRITING_RATE 承保比例
     */
    public BigDecimal getUnderwritingRate() {
        return underwritingRate;
    }

    /**
     * 承保比例
     * @param underwritingRate 承保比例
     */
    public void setUnderwritingRate(BigDecimal underwritingRate) {
        this.underwritingRate = underwritingRate;
    }

    /**
     * null
     * @return COINSURANCE_RATE null
     */
    public BigDecimal getCoinsuranceRate() {
        return coinsuranceRate;
    }

    /**
     * null
     * @param coinsuranceRate null
     */
    public void setCoinsuranceRate(BigDecimal coinsuranceRate) {
        this.coinsuranceRate = coinsuranceRate;
    }

    /**
     * null
     * @return TEMP_APP_NO null
     */
    public String getTempAppNo() {
        return tempAppNo;
    }

    /**
     * null
     * @param tempAppNo null
     */
    public void setTempAppNo(String tempAppNo) {
        this.tempAppNo = tempAppNo == null ? null : tempAppNo.trim();
    }

    /**
     * 是否缴费
     * @return IS_PAYED 是否缴费
     */
    public String getIsPayed() {
        return isPayed;
    }

    /**
     * 是否缴费
     * @param isPayed 是否缴费
     */
    public void setIsPayed(String isPayed) {
        this.isPayed = isPayed == null ? null : isPayed.trim();
    }

    /**
     * 支付号  1-已申请支付号 ,2- 申请支付号失败 3- 缴费成功 4- 缴费失败
     * @return PAY_APP_NO 支付号  1-已申请支付号 ,2- 申请支付号失败 3- 缴费成功 4- 缴费失败
     */
    public String getPayAppNo() {
        return payAppNo;
    }

    /**
     * 支付号  1-已申请支付号 ,2- 申请支付号失败 3- 缴费成功 4- 缴费失败
     * @param payAppNo 支付号  1-已申请支付号 ,2- 申请支付号失败 3- 缴费成功 4- 缴费失败
     */
    public void setPayAppNo(String payAppNo) {
        this.payAppNo = payAppNo == null ? null : payAppNo.trim();
    }

    /**
     * null
     * @return T_UDR_DATE null
     */
    public String gettUdrDate() {
        return tUdrDate;
    }

    /**
     * null
     * @param tUdrDate null
     */
    public void settUdrDate(String tUdrDate) {
        this.tUdrDate = tUdrDate == null ? null : tUdrDate.trim();
    }

    /**
     * 保险责任类别
     * @return INSURANCE_TYPE 保险责任类别
     */
    public String getInsuranceType() {
        return insuranceType;
    }

    /**
     * 保险责任类别
     * @param insuranceType 保险责任类别
     */
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    /**
     * 保险责任类别中文显示
     * @return INSURANCE_TYPE_NAME 保险责任类别中文显示
     */
    public String getInsuranceTypeName() {
        return insuranceTypeName;
    }

    /**
     * 保险责任类别中文显示
     * @param insuranceTypeName 保险责任类别中文显示
     */
    public void setInsuranceTypeName(String insuranceTypeName) {
        this.insuranceTypeName = insuranceTypeName == null ? null : insuranceTypeName.trim();
    }

    /**
     * null
     * @return OPERATE_ID null
     */
    public String getOperateId() {
        return operateId;
    }

    /**
     * null
     * @param operateId null
     */
    public void setOperateId(String operateId) {
        this.operateId = operateId == null ? null : operateId.trim();
    }

    /**
     * null
     * @return IS_SEND_SMSS null
     */
    public String getIsSendSmss() {
        return isSendSmss;
    }

    /**
     * null
     * @param isSendSmss null
     */
    public void setIsSendSmss(String isSendSmss) {
        this.isSendSmss = isSendSmss == null ? null : isSendSmss.trim();
    }

    /**
     * 投保人法定代表人证件类型
     * @return LEGAL_CERT_TYPE 投保人法定代表人证件类型
     */
    public String getLegalCertType() {
        return legalCertType;
    }

    /**
     * 投保人法定代表人证件类型
     * @param legalCertType 投保人法定代表人证件类型
     */
    public void setLegalCertType(String legalCertType) {
        this.legalCertType = legalCertType == null ? null : legalCertType.trim();
    }

    /**
     * 被保险人法定代表人姓名
     * @return RECEIVE_LEGAL_NAME 被保险人法定代表人姓名
     */
    public String getReceiveLegalName() {
        return receiveLegalName;
    }

    /**
     * 被保险人法定代表人姓名
     * @param receiveLegalName 被保险人法定代表人姓名
     */
    public void setReceiveLegalName(String receiveLegalName) {
        this.receiveLegalName = receiveLegalName == null ? null : receiveLegalName.trim();
    }

    /**
     * 贷款总人数
     * @return PERSON_COUNT 贷款总人数
     */
    public Short getPersonCount() {
        return personCount;
    }

    /**
     * 贷款总人数
     * @param personCount 贷款总人数
     */
    public void setPersonCount(Short personCount) {
        this.personCount = personCount;
    }

    /**
     * 被保险人法定代表人联系电话
     * @return RECEIVE_LEGAL_PHONE 被保险人法定代表人联系电话
     */
    public String getReceiveLegalPhone() {
        return receiveLegalPhone;
    }

    /**
     * 被保险人法定代表人联系电话
     * @param receiveLegalPhone 被保险人法定代表人联系电话
     */
    public void setReceiveLegalPhone(String receiveLegalPhone) {
        this.receiveLegalPhone = receiveLegalPhone == null ? null : receiveLegalPhone.trim();
    }

    /**
     * 被保险人法定代表人证件号码
     * @return RECEIVE_LEGAL_CERT_CODE 被保险人法定代表人证件号码
     */
    public String getReceiveLegalCertCode() {
        return receiveLegalCertCode;
    }

    /**
     * 被保险人法定代表人证件号码
     * @param receiveLegalCertCode 被保险人法定代表人证件号码
     */
    public void setReceiveLegalCertCode(String receiveLegalCertCode) {
        this.receiveLegalCertCode = receiveLegalCertCode == null ? null : receiveLegalCertCode.trim();
    }

    /**
     * 被保险人法定代表人证件类型
     * @return RECEIVE_LEGAL_CERT_TYPE 被保险人法定代表人证件类型
     */
    public String getReceiveLegalCertType() {
        return receiveLegalCertType;
    }

    /**
     * 被保险人法定代表人证件类型
     * @param receiveLegalCertType 被保险人法定代表人证件类型
     */
    public void setReceiveLegalCertType(String receiveLegalCertType) {
        this.receiveLegalCertType = receiveLegalCertType == null ? null : receiveLegalCertType.trim();
    }

    /**
     * 支付完成时间
     * @return PAY_TIME 支付完成时间
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * 支付完成时间
     * @param payTime 支付完成时间
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }

    /**
     * 纳税人识别号
     * @return COVER_NO 纳税人识别号
     */
    public String getCoverNo() {
        return coverNo;
    }

    /**
     * 纳税人识别号
     * @param coverNo 纳税人识别号
     */
    public void setCoverNo(String coverNo) {
        this.coverNo = coverNo == null ? null : coverNo.trim();
    }

    /**
     * null
     * @return RULE_LOAN_AMT null
     */
    public BigDecimal getRuleLoanAmt() {
        return ruleLoanAmt;
    }

    /**
     * null
     * @param ruleLoanAmt null
     */
    public void setRuleLoanAmt(BigDecimal ruleLoanAmt) {
        this.ruleLoanAmt = ruleLoanAmt;
    }

    /**
     * 银行卡关联手机号
     * @return BANK_PHONE 银行卡关联手机号
     */
    public String getBankPhone() {
        return bankPhone;
    }

    /**
     * 银行卡关联手机号
     * @param bankPhone 银行卡关联手机号
     */
    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone == null ? null : bankPhone.trim();
    }

    /**
     * null
     * @return PAYEE_ACCOUNT_NAME null
     */
    public String getPayeeAccountName() {
        return payeeAccountName;
    }

    /**
     * null
     * @param payeeAccountName null
     */
    public void setPayeeAccountName(String payeeAccountName) {
        this.payeeAccountName = payeeAccountName == null ? null : payeeAccountName.trim();
    }

    /**
     * 贷款起始日
     * @return LOAN_START_DATE 贷款起始日
     */
    public String getLoanStartDate() {
        return loanStartDate;
    }

    /**
     * 贷款起始日
     * @param loanStartDate 贷款起始日
     */
    public void setLoanStartDate(String loanStartDate) {
        this.loanStartDate = loanStartDate == null ? null : loanStartDate.trim();
    }

    /**
     * 贷款终止日
     * @return LOAN_END_DATE 贷款终止日
     */
    public String getLoanEndDate() {
        return loanEndDate;
    }

    /**
     * 贷款终止日
     * @param loanEndDate 贷款终止日
     */
    public void setLoanEndDate(String loanEndDate) {
        this.loanEndDate = loanEndDate == null ? null : loanEndDate.trim();
    }

    /**
     * 五级分类标志 (STD_CLA_TYPE)
     * @return CLA 五级分类标志 (STD_CLA_TYPE)
     */
    public String getCla() {
        return cla;
    }

    /**
     * 五级分类标志 (STD_CLA_TYPE)
     * @param cla 五级分类标志 (STD_CLA_TYPE)
     */
    public void setCla(String cla) {
        this.cla = cla == null ? null : cla.trim();
    }

    /**
     * 渠道协议
     * @return AGREEMENT_NO 渠道协议
     */
    public String getAgreementNo() {
        return agreementNo;
    }

    /**
     * 渠道协议
     * @param agreementNo 渠道协议
     */
    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo == null ? null : agreementNo.trim();
    }

    /**
     * 渠道代码
     * @return INTERMEDIARY_CODE 渠道代码
     */
    public String getIntermediaryCode() {
        return intermediaryCode;
    }

    /**
     * 渠道代码
     * @param intermediaryCode 渠道代码
     */
    public void setIntermediaryCode(String intermediaryCode) {
        this.intermediaryCode = intermediaryCode == null ? null : intermediaryCode.trim();
    }

    /**
     * 批改状态 (STD_LST_MOD_TYPE)
     * @return MOD_STATUS 批改状态 (STD_LST_MOD_TYPE)
     */
    public String getModStatus() {
        return modStatus;
    }

    /**
     * 批改状态 (STD_LST_MOD_TYPE)
     * @param modStatus 批改状态 (STD_LST_MOD_TYPE)
     */
    public void setModStatus(String modStatus) {
        this.modStatus = modStatus == null ? null : modStatus.trim();
    }

    /**
     * 是否加贷保费INCLUDE_INS_FEE
     * @return INCLUDE_INS_FEE 是否加贷保费INCLUDE_INS_FEE
     */
    public String getIncludeInsFee() {
        return includeInsFee;
    }

    /**
     * 是否加贷保费INCLUDE_INS_FEE
     * @param includeInsFee 是否加贷保费INCLUDE_INS_FEE
     */
    public void setIncludeInsFee(String includeInsFee) {
        this.includeInsFee = includeInsFee == null ? null : includeInsFee.trim();
    }

    /**
     * null
     * @return OLD_COVER_AMOUNT null
     */
    public BigDecimal getOldCoverAmount() {
        return oldCoverAmount;
    }

    /**
     * null
     * @param oldCoverAmount null
     */
    public void setOldCoverAmount(BigDecimal oldCoverAmount) {
        this.oldCoverAmount = oldCoverAmount;
    }

    /**
     * null
     * @return OLD_LOAN_AMOUNT null
     */
    public BigDecimal getOldLoanAmount() {
        return oldLoanAmount;
    }

    /**
     * null
     * @param oldLoanAmount null
     */
    public void setOldLoanAmount(BigDecimal oldLoanAmount) {
        this.oldLoanAmount = oldLoanAmount;
    }

    /**
     * null
     * @return OLD_FEE_RATIO null
     */
    public BigDecimal getOldFeeRatio() {
        return oldFeeRatio;
    }

    /**
     * null
     * @param oldFeeRatio null
     */
    public void setOldFeeRatio(BigDecimal oldFeeRatio) {
        this.oldFeeRatio = oldFeeRatio;
    }

    /**
     * 抵扣券ID
     * @return COUPON_ID 抵扣券ID
     */
    public String getCouponId() {
        return couponId;
    }

    /**
     * 抵扣券ID
     * @param couponId 抵扣券ID
     */
    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    /**
     * 抵扣券金额
     * @return PREMIUM_PRICE 抵扣券金额
     */
    public BigDecimal getPremiumPrice() {
        return premiumPrice;
    }

    /**
     * 抵扣券金额
     * @param premiumPrice 抵扣券金额
     */
    public void setPremiumPrice(BigDecimal premiumPrice) {
        this.premiumPrice = premiumPrice;
    }

    /**
     * 投保单URL
     * @return INSURANCE_SLIP_URL 投保单URL
     */
    public String getInsuranceSlipUrl() {
        return insuranceSlipUrl;
    }

    /**
     * 投保单URL
     * @param insuranceSlipUrl 投保单URL
     */
    public void setInsuranceSlipUrl(String insuranceSlipUrl) {
        this.insuranceSlipUrl = insuranceSlipUrl == null ? null : insuranceSlipUrl.trim();
    }

    /**
     * null
     * @return APPLY_PAY_DATE null
     */
    public String getApplyPayDate() {
        return applyPayDate;
    }

    /**
     * null
     * @param applyPayDate null
     */
    public void setApplyPayDate(String applyPayDate) {
        this.applyPayDate = applyPayDate == null ? null : applyPayDate.trim();
    }

    /**
     * null
     * @return APPLY_APP_NO_TIME null
     */
    public String getApplyAppNoTime() {
        return applyAppNoTime;
    }

    /**
     * null
     * @param applyAppNoTime null
     */
    public void setApplyAppNoTime(String applyAppNoTime) {
        this.applyAppNoTime = applyAppNoTime == null ? null : applyAppNoTime.trim();
    }

    /**
     * null
     * @return SUBROGATION_URL null
     */
    public String getSubrogationUrl() {
        return subrogationUrl;
    }

    /**
     * null
     * @param subrogationUrl null
     */
    public void setSubrogationUrl(String subrogationUrl) {
        this.subrogationUrl = subrogationUrl == null ? null : subrogationUrl.trim();
    }

    /**
     * null
     * @return ESTIMATION_AMOUNT null
     */
    public Long getEstimationAmount() {
        return estimationAmount;
    }

    /**
     * null
     * @param estimationAmount null
     */
    public void setEstimationAmount(Long estimationAmount) {
        this.estimationAmount = estimationAmount;
    }

    /**
     * 流水号--三湘银行
     * @return SXYH_SERNO 流水号--三湘银行
     */
    public String getSxyhSerno() {
        return sxyhSerno;
    }

    /**
     * 流水号--三湘银行
     * @param sxyhSerno 流水号--三湘银行
     */
    public void setSxyhSerno(String sxyhSerno) {
        this.sxyhSerno = sxyhSerno == null ? null : sxyhSerno.trim();
    }

    /**
     * 审批结果--三湘银行
     * @return SXYH_STATUS 审批结果--三湘银行
     */
    public String getSxyhStatus() {
        return sxyhStatus;
    }

    /**
     * 审批结果--三湘银行
     * @param sxyhStatus 审批结果--三湘银行
     */
    public void setSxyhStatus(String sxyhStatus) {
        this.sxyhStatus = sxyhStatus == null ? null : sxyhStatus.trim();
    }

    /**
     * 上传标识--三湘银行(1-审批文件已上传 2-放款文件已上传 默认空)
     * @return SXYH_UPLOAD_FLAG 上传标识--三湘银行(1-审批文件已上传 2-放款文件已上传 默认空)
     */
    public String getSxyhUploadFlag() {
        return sxyhUploadFlag;
    }

    /**
     * 上传标识--三湘银行(1-审批文件已上传 2-放款文件已上传 默认空)
     * @param sxyhUploadFlag 上传标识--三湘银行(1-审批文件已上传 2-放款文件已上传 默认空)
     */
    public void setSxyhUploadFlag(String sxyhUploadFlag) {
        this.sxyhUploadFlag = sxyhUploadFlag == null ? null : sxyhUploadFlag.trim();
    }

    /**
     * 审批意见--三湘银行
     * @return SXYH_STATUS_MSG 审批意见--三湘银行
     */
    public String getSxyhStatusMsg() {
        return sxyhStatusMsg;
    }

    /**
     * 审批意见--三湘银行
     * @param sxyhStatusMsg 审批意见--三湘银行
     */
    public void setSxyhStatusMsg(String sxyhStatusMsg) {
        this.sxyhStatusMsg = sxyhStatusMsg == null ? null : sxyhStatusMsg.trim();
    }

    /**
     * null
     * @return LAST_PAY_TIME null
     */
    public String getLastPayTime() {
        return lastPayTime;
    }

    /**
     * null
     * @param lastPayTime null
     */
    public void setLastPayTime(String lastPayTime) {
        this.lastPayTime = lastPayTime == null ? null : lastPayTime.trim();
    }

    /**
     * null
     * @return PAY_FAIL_CAUSE null
     */
    public String getPayFailCause() {
        return payFailCause;
    }

    /**
     * null
     * @param payFailCause null
     */
    public void setPayFailCause(String payFailCause) {
        this.payFailCause = payFailCause == null ? null : payFailCause.trim();
    }

    /**
     * 是否承保附加险1是、2否
     * @return ACCESSORY_RISK 是否承保附加险1是、2否
     */
    public String getAccessoryRisk() {
        return accessoryRisk;
    }

    /**
     * 是否承保附加险1是、2否
     * @param accessoryRisk 是否承保附加险1是、2否
     */
    public void setAccessoryRisk(String accessoryRisk) {
        this.accessoryRisk = accessoryRisk == null ? null : accessoryRisk.trim();
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
    public String getFirstPremRate() {
        return firstPremRate;
    }

    /**
     * 首期费率
     * @param firstPremRate 首期费率
     */
    public void setFirstPremRate(String firstPremRate) {
        this.firstPremRate = firstPremRate;
    }

    /**
     * 每期费率
     * @return EVERY_PREM_RATE 每期费率
     */
    public String getEveryPremRate() {
        return everyPremRate;
    }

    /**
     * 每期费率
     * @param everyPremRate 每期费率
     */
    public void setEveryPremRate(String everyPremRate) {
        this.everyPremRate = everyPremRate;
    }

    /**
     * null
     * @return WITH_HOLD_KIND null
     */
    public String getWithHoldKind() {
        return withHoldKind;
    }

    /**
     * null
     * @param withHoldKind null
     */
    public void setWithHoldKind(String withHoldKind) {
        this.withHoldKind = withHoldKind == null ? null : withHoldKind.trim();
    }

    /**
     * null
     * @return COINSURANCE_LIST_SERNO null
     */
    public String getCoinsuranceListSerno() {
        return coinsuranceListSerno;
    }

    /**
     * null
     * @param coinsuranceListSerno null
     */
    public void setCoinsuranceListSerno(String coinsuranceListSerno) {
        this.coinsuranceListSerno = coinsuranceListSerno == null ? null : coinsuranceListSerno.trim();
    }

    /**
     * 原始核保日期
     * @return UNDERWRITEENDDATE 原始核保日期
     */
    public String getUnderwriteenddate() {
        return underwriteenddate;
    }

    /**
     * 原始核保日期
     * @param underwriteenddate 原始核保日期
     */
    public void setUnderwriteenddate(String underwriteenddate) {
        this.underwriteenddate = underwriteenddate == null ? null : underwriteenddate.trim();
    }

    /**
     * 条款
     * @return PROVISION 条款
     */
    public String getProvision() {
        return provision;
    }

    /**
     * 条款
     * @param provision 条款
     */
    public void setProvision(String provision) {
        this.provision = provision == null ? null : provision.trim();
    }

    /**
     * 自主收款开户行号
     * @return PAYEE_BANK_NO 自主收款开户行号
     */
    public String getPayeeBankNo() {
        return payeeBankNo;
    }

    /**
     * 自主收款开户行号
     * @param payeeBankNo 自主收款开户行号
     */
    public void setPayeeBankNo(String payeeBankNo) {
        this.payeeBankNo = payeeBankNo == null ? null : payeeBankNo.trim();
    }

    /**
     * 受托支付开户行名
     * @return ET_LOAN_ACC_BANK_NME 受托支付开户行名
     */
    public String getEtLoanAccBankNme() {
        return etLoanAccBankNme;
    }

    /**
     * 受托支付开户行名
     * @param etLoanAccBankNme 受托支付开户行名
     */
    public void setEtLoanAccBankNme(String etLoanAccBankNme) {
        this.etLoanAccBankNme = etLoanAccBankNme == null ? null : etLoanAccBankNme.trim();
    }

    /**
     * 受托支付开户行号
     * @return ET_LOAN_ACC_BANK 受托支付开户行号
     */
    public String getEtLoanAccBank() {
        return etLoanAccBank;
    }

    /**
     * 受托支付开户行号
     * @param etLoanAccBank 受托支付开户行号
     */
    public void setEtLoanAccBank(String etLoanAccBank) {
        this.etLoanAccBank = etLoanAccBank == null ? null : etLoanAccBank.trim();
    }

    /**
     * 受托支付账户名
     * @return ET_LOAN_ACC_NAME 受托支付账户名
     */
    public String getEtLoanAccName() {
        return etLoanAccName;
    }

    /**
     * 受托支付账户名
     * @param etLoanAccName 受托支付账户名
     */
    public void setEtLoanAccName(String etLoanAccName) {
        this.etLoanAccName = etLoanAccName == null ? null : etLoanAccName.trim();
    }

    /**
     * 受托支付账号
     * @return ET_LOAN_ACC 受托支付账号
     */
    public String getEtLoanAcc() {
        return etLoanAcc;
    }

    /**
     * 受托支付账号
     * @param etLoanAcc 受托支付账号
     */
    public void setEtLoanAcc(String etLoanAcc) {
        this.etLoanAcc = etLoanAcc == null ? null : etLoanAcc.trim();
    }

    /**
     * 支付方式
     * @return ET_PAY_TYPE 支付方式
     */
    public String getEtPayType() {
        return etPayType;
    }

    /**
     * 支付方式
     * @param etPayType 支付方式
     */
    public void setEtPayType(String etPayType) {
        this.etPayType = etPayType == null ? null : etPayType.trim();
    }

    /**
     * null
     * @return COVER_ACCOUNT_BANK_NME null
     */
    public String getCoverAccountBankNme() {
        return coverAccountBankNme;
    }

    /**
     * null
     * @param coverAccountBankNme null
     */
    public void setCoverAccountBankNme(String coverAccountBankNme) {
        this.coverAccountBankNme = coverAccountBankNme == null ? null : coverAccountBankNme.trim();
    }

    /**
     * 经营主体全称
     * @return MT_RECEIVE_CUS_NAME 经营主体全称
     */
    public String getMtReceiveCusName() {
        return mtReceiveCusName;
    }

    /**
     * 经营主体全称
     * @param mtReceiveCusName 经营主体全称
     */
    public void setMtReceiveCusName(String mtReceiveCusName) {
        this.mtReceiveCusName = mtReceiveCusName == null ? null : mtReceiveCusName.trim();
    }

    /**
     * 客户类型
     * @return MT_CUS_TYPE 客户类型
     */
    public String getMtCusType() {
        return mtCusType;
    }

    /**
     * 客户类型
     * @param mtCusType 客户类型
     */
    public void setMtCusType(String mtCusType) {
        this.mtCusType = mtCusType == null ? null : mtCusType.trim();
    }

    /**
     * 证件类型
     * @return MT_CERT_TYPE 证件类型
     */
    public String getMtCertType() {
        return mtCertType;
    }

    /**
     * 证件类型
     * @param mtCertType 证件类型
     */
    public void setMtCertType(String mtCertType) {
        this.mtCertType = mtCertType == null ? null : mtCertType.trim();
    }

    /**
     * 证件号码
     * @return MT_CERT_CODE 证件号码
     */
    public String getMtCertCode() {
        return mtCertCode;
    }

    /**
     * 证件号码
     * @param mtCertCode 证件号码
     */
    public void setMtCertCode(String mtCertCode) {
        this.mtCertCode = mtCertCode == null ? null : mtCertCode.trim();
    }

    /**
     * 单位所属行业
     * @return MT_INDUSTRY_TYPE 单位所属行业
     */
    public String getMtIndustryType() {
        return mtIndustryType;
    }

    /**
     * 单位所属行业
     * @param mtIndustryType 单位所属行业
     */
    public void setMtIndustryType(String mtIndustryType) {
        this.mtIndustryType = mtIndustryType == null ? null : mtIndustryType.trim();
    }
    

	public String getReSpecialInd() {
		return reSpecialInd;
	}

	public void setReSpecialInd(String reSpecialInd) {
		this.reSpecialInd = reSpecialInd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LstIqpInfo [serno=");
		builder.append(serno);
		builder.append(", prdId=");
		builder.append(prdId);
		builder.append(", prdName=");
		builder.append(prdName);
		builder.append(", coverSerno=");
		builder.append(coverSerno);
		builder.append(", listSerno=");
		builder.append(listSerno);
		builder.append(", cusId=");
		builder.append(cusId);
		builder.append(", cusName=");
		builder.append(cusName);
		builder.append(", cusType=");
		builder.append(cusType);
		builder.append(", indivSex=");
		builder.append(indivSex);
		builder.append(", certType=");
		builder.append(certType);
		builder.append(", certCode=");
		builder.append(certCode);
		builder.append(", indivMarSt=");
		builder.append(indivMarSt);
		builder.append(", address=");
		builder.append(address);
		builder.append(", indivComName=");
		builder.append(indivComName);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", indivComAddr=");
		builder.append(indivComAddr);
		builder.append(", country=");
		builder.append(country);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", coverAccountName=");
		builder.append(coverAccountName);
		builder.append(", coverAccount=");
		builder.append(coverAccount);
		builder.append(", receiveCusName=");
		builder.append(receiveCusName);
		builder.append(", receiverCusId=");
		builder.append(receiverCusId);
		builder.append(", receiveCusPhone=");
		builder.append(receiveCusPhone);
		builder.append(", receiverCusAddress=");
		builder.append(receiverCusAddress);
		builder.append(", receiveCusCertType=");
		builder.append(receiveCusCertType);
		builder.append(", receiveCusCertCode=");
		builder.append(receiveCusCertCode);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", term=");
		builder.append(term);
		builder.append(", repaymentMode=");
		builder.append(repaymentMode);
		builder.append(", period=");
		builder.append(period);
		builder.append(", periodMoney=");
		builder.append(periodMoney);
		builder.append(", contNo=");
		builder.append(contNo);
		builder.append(", flag=");
		builder.append(flag);
		builder.append(", irType=");
		builder.append(irType);
		builder.append(", grossRate=");
		builder.append(grossRate);
		builder.append(", guarantyName=");
		builder.append(guarantyName);
		builder.append(", guarantyNo=");
		builder.append(guarantyNo);
		builder.append(", bankAssessedValue=");
		builder.append(bankAssessedValue);
		builder.append(", certiNo=");
		builder.append(certiNo);
		builder.append(", gageName=");
		builder.append(gageName);
		builder.append(", assureMeansMain=");
		builder.append(assureMeansMain);
		builder.append(", numNo=");
		builder.append(numNo);
		builder.append(", xubaoFlag=");
		builder.append(xubaoFlag);
		builder.append(", cOrigPlyNo=");
		builder.append(cOrigPlyNo);
		builder.append(", cPrnNo=");
		builder.append(cPrnNo);
		builder.append(", prdSubCode=");
		builder.append(prdSubCode);
		builder.append(", coverAmount=");
		builder.append(coverAmount);
		builder.append(", coverCurrencyType=");
		builder.append(coverCurrencyType);
		builder.append(", coverageFee=");
		builder.append(coverageFee);
		builder.append(", feeCurrencyType=");
		builder.append(feeCurrencyType);
		builder.append(", exchangeRate=");
		builder.append(exchangeRate);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", serviceCharge=");
		builder.append(serviceCharge);
		builder.append(", coverStartDate=");
		builder.append(coverStartDate);
		builder.append(", coverEndDate=");
		builder.append(coverEndDate);
		builder.append(", tEdrBgnTm=");
		builder.append(tEdrBgnTm);
		builder.append(", tEdrEndTm=");
		builder.append(tEdrEndTm);
		builder.append(", toubaoDate=");
		builder.append(toubaoDate);
		builder.append(", signDate=");
		builder.append(signDate);
		builder.append(", inputDate=");
		builder.append(inputDate);
		builder.append(", togetherFlag=");
		builder.append(togetherFlag);
		builder.append(", cConinsrncCde=");
		builder.append(cConinsrncCde);
		builder.append(", resolveWay=");
		builder.append(resolveWay);
		builder.append(", cDecFlg=");
		builder.append(cDecFlg);
		builder.append(", cInward=");
		builder.append(cInward);
		builder.append(", nRetProp=");
		builder.append(nRetProp);
		builder.append(", cRiskLvlCde=");
		builder.append(cRiskLvlCde);
		builder.append(", cSttlDpt=");
		builder.append(cSttlDpt);
		builder.append(", excuseRate=");
		builder.append(excuseRate);
		builder.append(", shortRate=");
		builder.append(shortRate);
		builder.append(", isAgriculture=");
		builder.append(isAgriculture);
		builder.append(", riskLevel=");
		builder.append(riskLevel);
		builder.append(", payWay=");
		builder.append(payWay);
		builder.append(", createType=");
		builder.append(createType);
		builder.append(", printWay=");
		builder.append(printWay);
		builder.append(", businessSource=");
		builder.append(businessSource);
		builder.append(", mainBrId=");
		builder.append(mainBrId);
		builder.append(", cBuisType=");
		builder.append(cBuisType);
		builder.append(", inputId=");
		builder.append(inputId);
		builder.append(", actorno=");
		builder.append(actorno);
		builder.append(", telnum=");
		builder.append(telnum);
		builder.append(", cSalegrpCde=");
		builder.append(cSalegrpCde);
		builder.append(", cCmpnyAgtCde=");
		builder.append(cCmpnyAgtCde);
		builder.append(", cAgtAgrNo1=");
		builder.append(cAgtAgrNo1);
		builder.append(", cRemark=");
		builder.append(cRemark);
		builder.append(", cReinsrcFlg=");
		builder.append(cReinsrcFlg);
		builder.append(", cTrueAgtCde=");
		builder.append(cTrueAgtCde);
		builder.append(", nProProp=");
		builder.append(nProProp);
		builder.append(", nAgtProp=");
		builder.append(nAgtProp);
		builder.append(", cQdlx=");
		builder.append(cQdlx);
		builder.append(", cTjxs=");
		builder.append(cTjxs);
		builder.append(", cNyqz=");
		builder.append(cNyqz);
		builder.append(", cFsywFlag=");
		builder.append(cFsywFlag);
		builder.append(", cOprtType=");
		builder.append(cOprtType);
		builder.append(", cOprtLvl=");
		builder.append(cOprtLvl);
		builder.append(", cSlsPer=");
		builder.append(cSlsPer);
		builder.append(", cWorkCertif=");
		builder.append(cWorkCertif);
		builder.append(", cRelatTel=");
		builder.append(cRelatTel);
		builder.append(", cSalesTel=");
		builder.append(cSalesTel);
		builder.append(", cVisitService=");
		builder.append(cVisitService);
		builder.append(", cInviteTitle=");
		builder.append(cInviteTitle);
		builder.append(", cTelewrtSalegrp=");
		builder.append(cTelewrtSalegrp);
		builder.append(", cIsImage=");
		builder.append(cIsImage);
		builder.append(", cImageId=");
		builder.append(cImageId);
		builder.append(", cIsImage2=");
		builder.append(cIsImage2);
		builder.append(", cImageState2=");
		builder.append(cImageState2);
		builder.append(", cImageId2=");
		builder.append(cImageId2);
		builder.append(", cIsNofee=");
		builder.append(cIsNofee);
		builder.append(", cNofeeReason=");
		builder.append(cNofeeReason);
		builder.append(", cFeeFlag=");
		builder.append(cFeeFlag);
		builder.append(", cRetprmType=");
		builder.append(cRetprmType);
		builder.append(", nPerformance=");
		builder.append(nPerformance);
		builder.append(", cFinanceYwtyp=");
		builder.append(cFinanceYwtyp);
		builder.append(", cBsnsAgent=");
		builder.append(cBsnsAgent);
		builder.append(", cFinanceDpt=");
		builder.append(cFinanceDpt);
		builder.append(", coverYear=");
		builder.append(coverYear);
		builder.append(", cAppnt=");
		builder.append(cAppnt);
		builder.append(", cAgtAgrNo=");
		builder.append(cAgtAgrNo);
		builder.append(", applyStatus=");
		builder.append(applyStatus);
		builder.append(", coverCreateStatus=");
		builder.append(coverCreateStatus);
		builder.append(", lastUpdId=");
		builder.append(lastUpdId);
		builder.append(", lastUpdDate=");
		builder.append(lastUpdDate);
		builder.append(", iqpLoanSerno=");
		builder.append(iqpLoanSerno);
		builder.append(", mgrId=");
		builder.append(mgrId);
		builder.append(", mgrOrg=");
		builder.append(mgrOrg);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", insRatio=");
		builder.append(insRatio);
		builder.append(", channelNo=");
		builder.append(channelNo);
		builder.append(", optType=");
		builder.append(optType);
		builder.append(", legalSex=");
		builder.append(legalSex);
		builder.append(", legalName=");
		builder.append(legalName);
		builder.append(", legalCertCode=");
		builder.append(legalCertCode);
		builder.append(", legalHomeAddr=");
		builder.append(legalHomeAddr);
		builder.append(", legalPostCode=");
		builder.append(legalPostCode);
		builder.append(", comInsCode=");
		builder.append(comInsCode);
		builder.append(", postCode=");
		builder.append(postCode);
		builder.append(", comInsExpDate=");
		builder.append(comInsExpDate);
		builder.append(", locTaxRegCode=");
		builder.append(locTaxRegCode);
		builder.append(", regCode=");
		builder.append(regCode);
		builder.append(", regEndDate=");
		builder.append(regEndDate);
		builder.append(", legalPhone=");
		builder.append(legalPhone);
		builder.append(", bizMode=");
		builder.append(bizMode);
		builder.append(", cancelFailCause=");
		builder.append(cancelFailCause);
		builder.append(", tradeSign=");
		builder.append(tradeSign);
		builder.append(", payeeAccount=");
		builder.append(payeeAccount);
		builder.append(", payeeBank=");
		builder.append(payeeBank);
		builder.append(", insName=");
		builder.append(insName);
		builder.append(", insAccount=");
		builder.append(insAccount);
		builder.append(", insBank=");
		builder.append(insBank);
		builder.append(", bailAccount=");
		builder.append(bailAccount);
		builder.append(", p2pFlag=");
		builder.append(p2pFlag);
		builder.append(", p2pPlatform=");
		builder.append(p2pPlatform);
		builder.append(", status=");
		builder.append(status);
		builder.append(", belongBrId=");
		builder.append(belongBrId);
		builder.append(", prdPk=");
		builder.append(prdPk);
		builder.append(", ispermit=");
		builder.append(ispermit);
		builder.append(", reportStatus=");
		builder.append(reportStatus);
		builder.append(", isMakeLoan=");
		builder.append(isMakeLoan);
		builder.append(", operType=");
		builder.append(operType);
		builder.append(", cEdrVersion=");
		builder.append(cEdrVersion);
		builder.append(", isCredit=");
		builder.append(isCredit);
		builder.append(", sendImageStatus=");
		builder.append(sendImageStatus);
		builder.append(", termDay=");
		builder.append(termDay);
		builder.append(", termTimeType=");
		builder.append(termTimeType);
		builder.append(", disputeDeal=");
		builder.append(disputeDeal);
		builder.append(", dealAddress=");
		builder.append(dealAddress);
		builder.append(", foreignKey=");
		builder.append(foreignKey);
		builder.append(", issuingFreq=");
		builder.append(issuingFreq);
		builder.append(", isIssueCost=");
		builder.append(isIssueCost);
		builder.append(", mdfTime=");
		builder.append(mdfTime);
		builder.append(", isReport=");
		builder.append(isReport);
		builder.append(", invoiceType=");
		builder.append(invoiceType);
		builder.append(", coverAccountBank=");
		builder.append(coverAccountBank);
		builder.append(", invoiceContact=");
		builder.append(invoiceContact);
		builder.append(", invoiceContactMob=");
		builder.append(invoiceContactMob);
		builder.append(", invoiceContactTel=");
		builder.append(invoiceContactTel);
		builder.append(", billSentMail=");
		builder.append(billSentMail);
		builder.append(", underwritingRate=");
		builder.append(underwritingRate);
		builder.append(", coinsuranceRate=");
		builder.append(coinsuranceRate);
		builder.append(", tempAppNo=");
		builder.append(tempAppNo);
		builder.append(", isPayed=");
		builder.append(isPayed);
		builder.append(", payAppNo=");
		builder.append(payAppNo);
		builder.append(", tUdrDate=");
		builder.append(tUdrDate);
		builder.append(", insuranceType=");
		builder.append(insuranceType);
		builder.append(", insuranceTypeName=");
		builder.append(insuranceTypeName);
		builder.append(", operateId=");
		builder.append(operateId);
		builder.append(", isSendSmss=");
		builder.append(isSendSmss);
		builder.append(", legalCertType=");
		builder.append(legalCertType);
		builder.append(", receiveLegalName=");
		builder.append(receiveLegalName);
		builder.append(", personCount=");
		builder.append(personCount);
		builder.append(", receiveLegalPhone=");
		builder.append(receiveLegalPhone);
		builder.append(", receiveLegalCertCode=");
		builder.append(receiveLegalCertCode);
		builder.append(", receiveLegalCertType=");
		builder.append(receiveLegalCertType);
		builder.append(", payTime=");
		builder.append(payTime);
		builder.append(", coverNo=");
		builder.append(coverNo);
		builder.append(", ruleLoanAmt=");
		builder.append(ruleLoanAmt);
		builder.append(", bankPhone=");
		builder.append(bankPhone);
		builder.append(", payeeAccountName=");
		builder.append(payeeAccountName);
		builder.append(", loanStartDate=");
		builder.append(loanStartDate);
		builder.append(", loanEndDate=");
		builder.append(loanEndDate);
		builder.append(", cla=");
		builder.append(cla);
		builder.append(", agreementNo=");
		builder.append(agreementNo);
		builder.append(", intermediaryCode=");
		builder.append(intermediaryCode);
		builder.append(", modStatus=");
		builder.append(modStatus);
		builder.append(", includeInsFee=");
		builder.append(includeInsFee);
		builder.append(", oldCoverAmount=");
		builder.append(oldCoverAmount);
		builder.append(", oldLoanAmount=");
		builder.append(oldLoanAmount);
		builder.append(", oldFeeRatio=");
		builder.append(oldFeeRatio);
		builder.append(", couponId=");
		builder.append(couponId);
		builder.append(", premiumPrice=");
		builder.append(premiumPrice);
		builder.append(", insuranceSlipUrl=");
		builder.append(insuranceSlipUrl);
		builder.append(", applyPayDate=");
		builder.append(applyPayDate);
		builder.append(", applyAppNoTime=");
		builder.append(applyAppNoTime);
		builder.append(", subrogationUrl=");
		builder.append(subrogationUrl);
		builder.append(", estimationAmount=");
		builder.append(estimationAmount);
		builder.append(", sxyhSerno=");
		builder.append(sxyhSerno);
		builder.append(", sxyhStatus=");
		builder.append(sxyhStatus);
		builder.append(", sxyhUploadFlag=");
		builder.append(sxyhUploadFlag);
		builder.append(", sxyhStatusMsg=");
		builder.append(sxyhStatusMsg);
		builder.append(", lastPayTime=");
		builder.append(lastPayTime);
		builder.append(", payFailCause=");
		builder.append(payFailCause);
		builder.append(", accessoryRisk=");
		builder.append(accessoryRisk);
		builder.append(", singlePrem=");
		builder.append(singlePrem);
		builder.append(", firstPremRate=");
		builder.append(firstPremRate);
		builder.append(", everyPremRate=");
		builder.append(everyPremRate);
		builder.append(", withHoldKind=");
		builder.append(withHoldKind);
		builder.append(", coinsuranceListSerno=");
		builder.append(coinsuranceListSerno);
		builder.append(", underwriteenddate=");
		builder.append(underwriteenddate);
		builder.append(", provision=");
		builder.append(provision);
		builder.append(", payeeBankNo=");
		builder.append(payeeBankNo);
		builder.append(", etLoanAccBankNme=");
		builder.append(etLoanAccBankNme);
		builder.append(", etLoanAccBank=");
		builder.append(etLoanAccBank);
		builder.append(", etLoanAccName=");
		builder.append(etLoanAccName);
		builder.append(", etLoanAcc=");
		builder.append(etLoanAcc);
		builder.append(", etPayType=");
		builder.append(etPayType);
		builder.append(", coverAccountBankNme=");
		builder.append(coverAccountBankNme);
		builder.append(", mtReceiveCusName=");
		builder.append(mtReceiveCusName);
		builder.append(", mtCusType=");
		builder.append(mtCusType);
		builder.append(", mtCertType=");
		builder.append(mtCertType);
		builder.append(", mtCertCode=");
		builder.append(mtCertCode);
		builder.append(", mtIndustryType=");
		builder.append(mtIndustryType);
		builder.append("]");
		return builder.toString();
	}
    
    
}