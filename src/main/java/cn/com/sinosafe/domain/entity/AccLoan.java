package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class AccLoan {
    /**
     * 借据编号
     */
    private String billNo;

    /**
     * 合同编号
     */
    private String contNo;

    /**
     * 中文合同编号
     */
    private String cnContNo;

    /**
     * 产品主键
     */
    private String prdPk;

    /**
     * 产品编号
     */
    private String bizType;

    /**
     * 产品名称
     */
    private String prdName;

    /**
     * 产品类别
     */
    private String prdType;

    /**
     * 客户代码
     */
    private String cusId;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 业务品种分类
     */
    private String bizTypeSub;

    /**
     * 科目号
     */
    private String accountClass;

    /**
     * 贷款帐号
     */
    private String loanAccount;

    /**
     * 贷款形式
     */
    private String loanForm;

    /**
     * 贷款性质
     */
    private String loanNature;

    /**
     * 关联交易类型
     */
    private String loanTypeExt;

    /**
     * 主担保方式
     */
    private String assureMeansMain;

    /**
     * 担保方式1
     */
    private String assureMeans1;

    /**
     * 担保方式2
     */
    private String assureMeans2;

    /**
     * 币种
     */
    private String curType;

    /**
     * 借据金额
     */
    private BigDecimal loanAmount;

    /**
     * 借据余额
     */
    private BigDecimal loanBalance;

    /**
     * 贷款起始日
     */
    private String loanStartDate;

    /**
     * 贷款终止日
     */
    private String loanEndDate;

    /**
     * 期限类型
     */
    private String termType;

    /**
     * 原到期日期
     */
    private String origExpiDate;

    /**
     * 基准利率(年)
     */
    private BigDecimal rulingIr;

    /**
     * 利率浮动值
     */
    private BigDecimal floatingRate;

    /**
     * 执行利率(年)
     */
    private BigDecimal realityIrY;

    /**
     * 逾期加罚率
     */
    private BigDecimal overdueRate;

    /**
     * 逾期加月罚率
     */
    private BigDecimal overdueIr;

    /**
     * 违约加罚率
     */
    private BigDecimal defaultRate;

    /**
     * 违约月利率
     */
    private BigDecimal defaultIr;

    /**
     * 复利加罚率
     */
    private BigDecimal ciRate;

    /**
     * 复利月利率
     */
    private BigDecimal ciIr;

    /**
     * 应收利息累计
     */
    private BigDecimal receIntCumu;

    /**
     * 实收利息累计
     */
    private BigDecimal actualIntCumu;

    /**
     * 欠息累计
     */
    private BigDecimal delayIntCumu;

    /**
     * 表内欠息
     */
    private BigDecimal innerIntCumu;

    /**
     * 表外欠息
     */
    private BigDecimal offIntCumu;

    /**
     * 表内应收
     */
    private BigDecimal innerReceInt;

    /**
     * 逾期应收
     */
    private BigDecimal overdueReceInt;

    /**
     * 表外利息应收
     */
    private BigDecimal offReceInt;

    /**
     * 利息复息应收
     */
    private BigDecimal compoundReceInt;

    /**
     * 表内转表外利息应收
     */
    private BigDecimal innerOffReceInt;

    /**
     * 表内实收
     */
    private BigDecimal innerActlInt;

    /**
     * 逾期实收
     */
    private BigDecimal overdueActlInt;

    /**
     * 表外利息实收
     */
    private BigDecimal offActlInt;

    /**
     * 利息复息实收
     */
    private BigDecimal compoundActlInt;

    /**
     * 表内转表外利息实收
     */
    private BigDecimal innerOffActlInt;

    /**
     * 正常贷款余额(元)
     */
    private BigDecimal normalBalance;

    /**
     * 逾期贷款余额(元)
     */
    private BigDecimal overdueBalance;

    /**
     * 呆滞贷款余额(元)
     */
    private BigDecimal sluggishBalance;

    /**
     * 呆账贷款余额(元)
     */
    private BigDecimal doubtfulBalance;

    /**
     * 积数_年
     */
    private BigDecimal integralY;

    /**
     * 积数_季
     */
    private BigDecimal integralQ;

    /**
     * 积数_月
     */
    private BigDecimal integralM;

    /**
     * 正常回收累计
     */
    private BigDecimal norRecAccu;

    /**
     * 资产重组累计
     */
    private BigDecimal reoRecAccu;

    /**
     * 资产剥离累计
     */
    private BigDecimal peelRecAccu;

    /**
     * 以资抵债累计
     */
    private BigDecimal assetRecAccu;

    /**
     * 担保代偿累计
     */
    private BigDecimal assureRecAccu;

    /**
     * 核损核销累计
     */
    private BigDecimal cancelRecAccu;

    /**
     * 政策性还款累计
     */
    private BigDecimal policyRecAccu;

    /**
     * 债转股累计
     */
    private BigDecimal dteRecAccu;

    /**
     * 转出累计
     */
    private BigDecimal rollRecAccu;

    /**
     * 本年最高余额
     */
    private BigDecimal maxBalanceY;

    /**
     * 本季最高余额
     */
    private BigDecimal maxBalanceQ;

    /**
     * 本月最高余额
     */
    private BigDecimal maxBalanceM;

    /**
     * 按揭标识
     */
    private String mortgageFlg;

    /**
     * 还款方式
     */
    private String repaymentMode;

    /**
     * 首次放款日期
     */
    private String firstDisbDate;

    /**
     * 贷款投向
     */
    private String loanDirection;

    /**
     * 借新还旧次数
     */
    private Short revolvingTimes;

    /**
     * 展期次数
     */
    private Short extensionTimes;

    /**
     * 本金逾期起始日期
     */
    private String capOverdueDate;

    /**
     * 利息逾期起始日期
     */
    private String intOverdueDate;

    /**
     * 当前逾期期数
     */
    private Short overTimesCurrent;

    /**
     * 累计逾期期数
     */
    private Short overTimesTotal;

    /**
     * 最高逾期期数
     */
    private Short maxTimesTotal;

    /**
     * 转不良标志
     */
    private String badLoanFlag;

    /**
     * 违约标志
     */
    private String defaultFlag;

    /**
     * 授信额度使用标志
     */
    private String limitInd;

    /**
     * 四级分类标志
     */
    private String loanForm4;

    /**
     * 五级分类标志
     */
    private String cla;

    /**
     * 五级分类日期
     */
    private String claDate;

    /**
     * 上期五级分类标志
     */
    private String claPre;

    /**
     * 上期五级分类日期
     */
    private String claDatePre;

    /**
     * 最近还款日期
     */
    private String latestRepayDate;

    /**
     * 客户经理
     */
    private String cusManager;

    /**
     * 受理机构
     */
    private String inputBrId;

    /**
     * 账务机构
     */
    private String finaBrId;

    /**
     * 主管机构
     */
    private String mainBrId;

    /**
     * 结清日期
     */
    private String settlDate;

    /**
     * 最近修改日期
     */
    private String latestDate;

    /**
     * 台帐状态[STD_ZB_ACC_STATUS]
     */
    private String accountStatus;

    /**
     * 业务品种分类名称
     */
    private String bizTypeDetail;

    /**
     * 本期计提金额
     */
    private BigDecimal devAmt;

    /**
     * 上期计提金额
     */
    private BigDecimal devAmtPre;

    /**
     * 减值准备标志
     */
    private String devFlag;

    /**
     * 利率类型
     */
    private String irType;

    /**
     * 利差
     */
    private BigDecimal sprdRate;

    /**
     * 还款周期
     */
    private String frequency;

    /**
     * 还款间隔
     */
    private Short payDistance;

    /**
     * 还款日
     */
    private BigDecimal dueDay;

    /**
     * 利率调整方式
     */
    private String irAdjustMode;

    /**
     * 支付方式
     */
    private String payType;

    /**
     * null
     */
    private BigDecimal fineInt;

    /**
     * null
     */
    private BigDecimal comdInt;

    /**
     * 期限
     */
    private String term;

    /**
     * null
     */
    private String termExt;

    /**
     * null
     */
    private String prjCopNo;

    /**
     * null
     */
    private String newAccountClass;

    /**
     * 贷款种类编号
     */
    private String loanTypeNo;

    /**
     * 贷款种类名称
     */
    private String loanTypeName;

    /**
     * 初始化期限(原贷款期限)
     */
    private String ogrTerm;

    /**
     * 结息周期
     */
    private String interestAccMode;

    /**
     * 表外核销本金
     */
    private BigDecimal cancelSum;

    /**
     * 表外核销利息
     */
    private BigDecimal cancelInterest;

    /**
     * null
     */
    private String claNow;

    /**
     * null
     */
    private String claNowDate;

    /**
     * 保单编号
     */
    private String listSerno;

    /**
     * 业务流水号
     */
    private String iqpLoanSerno;

    /**
     * 合作方编号
     */
    private String partnerNo;

    /**
     * 商圈编号
     */
    private String channelNo;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certCode;

    /**
     * 投向名称
     */
    private String directionName;

    /**
     * 贷款用途
     */
    private String loanUseType;

    /**
     * 贷款用途说明
     */
    private String useDec;

    /**
     * 录入人编号
     */
    private String inputId;

    /**
     * 录入时间
     */
    private String inputTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 生效状态[STD_ZB_EFFECT_STATUS]
     */
    private String effectStatus;

    /**
     * 合作方名称
     */
    private String partnerName;

    /**
     * 商圈名称
     */
    private String channelName;

    /**
     * 复勘日期
     */
    private String reExploreDate;

    /**
     * 还款方式说明
     */
    private String repaymentModeDesc;

    /**
     * 还本比例
     */
    private BigDecimal repayPercent;

    /**
     * 理赔次数
     */
    private String claimSettlingFrequency;

    /**
     * 当前理赔期次
     */
    private String currentClaimTerm;

    /**
     * 协议编号
     */
    private String treatyPk;

    /**
     * 免赔率
     */
    private BigDecimal preventRate;

    /**
     * 还款帐号
     */
    private String payAccount;

    /**
     * 还款帐号名称
     */
    private String payAccountName;

    /**
     * 贴息方式
     */
    private String interestSubsidy;

    /**
     * 连续逾期天数
     */
    private Short overTimesDays;

    /**
     * 逾期利息
     */
    private BigDecimal overdueInt;

    /**
     * 逾期罚息
     */
    private BigDecimal overdueFineInt;

    /**
     * 贷后检查完成日期
     */
    private String checkDate;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 生效日期
     */
    private String effectDate;

    /**
     * 累计已决金额之和
     */
    private BigDecimal paidAmtTotal;

    /**
     * 已追回总金额
     */
    private BigDecimal recoveredAmtTotal;

    /**
     * 累计已决金额
     */
    private BigDecimal paidAmtSum;

    /**
     * 逾期开始日期
     */
    private String overdueStartDate;

    /**
     * 上次台账状态
     */
    private String preAccountStatus;

    /**
     * 入网号码
     */
    private String netPhone;

    /**
     * 产品实例
     */
    private String prdInstance;

    /**
     * 保单关联外键
     */
    private String lstForeignKey;

    /**
     * 承保清单关联主键
     */
    private String lstInnetKey;

    /**
     * null
     */
    private String riskGrade;

    /**
     * 提前还款标识--三湘银行(1-提前还款,默认空)
     */
    private String sxyhPrepayFlag;

    /**
     * null
     */
    private String secondAccounts;

    /**
     * 借据编号
     * @return BILL_NO 借据编号
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * 借据编号
     * @param billNo 借据编号
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    /**
     * 合同编号
     * @return CONT_NO 合同编号
     */
    public String getContNo() {
        return contNo;
    }

    /**
     * 合同编号
     * @param contNo 合同编号
     */
    public void setContNo(String contNo) {
        this.contNo = contNo == null ? null : contNo.trim();
    }

    /**
     * 中文合同编号
     * @return CN_CONT_NO 中文合同编号
     */
    public String getCnContNo() {
        return cnContNo;
    }

    /**
     * 中文合同编号
     * @param cnContNo 中文合同编号
     */
    public void setCnContNo(String cnContNo) {
        this.cnContNo = cnContNo == null ? null : cnContNo.trim();
    }

    /**
     * 产品主键
     * @return PRD_PK 产品主键
     */
    public String getPrdPk() {
        return prdPk;
    }

    /**
     * 产品主键
     * @param prdPk 产品主键
     */
    public void setPrdPk(String prdPk) {
        this.prdPk = prdPk == null ? null : prdPk.trim();
    }

    /**
     * 产品编号
     * @return BIZ_TYPE 产品编号
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 产品编号
     * @param bizType 产品编号
     */
    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
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
     * 产品类别
     * @return PRD_TYPE 产品类别
     */
    public String getPrdType() {
        return prdType;
    }

    /**
     * 产品类别
     * @param prdType 产品类别
     */
    public void setPrdType(String prdType) {
        this.prdType = prdType == null ? null : prdType.trim();
    }

    /**
     * 客户代码
     * @return CUS_ID 客户代码
     */
    public String getCusId() {
        return cusId;
    }

    /**
     * 客户代码
     * @param cusId 客户代码
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
     * 业务品种分类
     * @return BIZ_TYPE_SUB 业务品种分类
     */
    public String getBizTypeSub() {
        return bizTypeSub;
    }

    /**
     * 业务品种分类
     * @param bizTypeSub 业务品种分类
     */
    public void setBizTypeSub(String bizTypeSub) {
        this.bizTypeSub = bizTypeSub == null ? null : bizTypeSub.trim();
    }

    /**
     * 科目号
     * @return ACCOUNT_CLASS 科目号
     */
    public String getAccountClass() {
        return accountClass;
    }

    /**
     * 科目号
     * @param accountClass 科目号
     */
    public void setAccountClass(String accountClass) {
        this.accountClass = accountClass == null ? null : accountClass.trim();
    }

    /**
     * 贷款帐号
     * @return LOAN_ACCOUNT 贷款帐号
     */
    public String getLoanAccount() {
        return loanAccount;
    }

    /**
     * 贷款帐号
     * @param loanAccount 贷款帐号
     */
    public void setLoanAccount(String loanAccount) {
        this.loanAccount = loanAccount == null ? null : loanAccount.trim();
    }

    /**
     * 贷款形式
     * @return LOAN_FORM 贷款形式
     */
    public String getLoanForm() {
        return loanForm;
    }

    /**
     * 贷款形式
     * @param loanForm 贷款形式
     */
    public void setLoanForm(String loanForm) {
        this.loanForm = loanForm == null ? null : loanForm.trim();
    }

    /**
     * 贷款性质
     * @return LOAN_NATURE 贷款性质
     */
    public String getLoanNature() {
        return loanNature;
    }

    /**
     * 贷款性质
     * @param loanNature 贷款性质
     */
    public void setLoanNature(String loanNature) {
        this.loanNature = loanNature == null ? null : loanNature.trim();
    }

    /**
     * 关联交易类型
     * @return LOAN_TYPE_EXT 关联交易类型
     */
    public String getLoanTypeExt() {
        return loanTypeExt;
    }

    /**
     * 关联交易类型
     * @param loanTypeExt 关联交易类型
     */
    public void setLoanTypeExt(String loanTypeExt) {
        this.loanTypeExt = loanTypeExt == null ? null : loanTypeExt.trim();
    }

    /**
     * 主担保方式
     * @return ASSURE_MEANS_MAIN 主担保方式
     */
    public String getAssureMeansMain() {
        return assureMeansMain;
    }

    /**
     * 主担保方式
     * @param assureMeansMain 主担保方式
     */
    public void setAssureMeansMain(String assureMeansMain) {
        this.assureMeansMain = assureMeansMain == null ? null : assureMeansMain.trim();
    }

    /**
     * 担保方式1
     * @return ASSURE_MEANS1 担保方式1
     */
    public String getAssureMeans1() {
        return assureMeans1;
    }

    /**
     * 担保方式1
     * @param assureMeans1 担保方式1
     */
    public void setAssureMeans1(String assureMeans1) {
        this.assureMeans1 = assureMeans1 == null ? null : assureMeans1.trim();
    }

    /**
     * 担保方式2
     * @return ASSURE_MEANS2 担保方式2
     */
    public String getAssureMeans2() {
        return assureMeans2;
    }

    /**
     * 担保方式2
     * @param assureMeans2 担保方式2
     */
    public void setAssureMeans2(String assureMeans2) {
        this.assureMeans2 = assureMeans2 == null ? null : assureMeans2.trim();
    }

    /**
     * 币种
     * @return CUR_TYPE 币种
     */
    public String getCurType() {
        return curType;
    }

    /**
     * 币种
     * @param curType 币种
     */
    public void setCurType(String curType) {
        this.curType = curType == null ? null : curType.trim();
    }

    /**
     * 借据金额
     * @return LOAN_AMOUNT 借据金额
     */
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    /**
     * 借据金额
     * @param loanAmount 借据金额
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * 借据余额
     * @return LOAN_BALANCE 借据余额
     */
    public BigDecimal getLoanBalance() {
        return loanBalance;
    }

    /**
     * 借据余额
     * @param loanBalance 借据余额
     */
    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
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
     * 期限类型
     * @return TERM_TYPE 期限类型
     */
    public String getTermType() {
        return termType;
    }

    /**
     * 期限类型
     * @param termType 期限类型
     */
    public void setTermType(String termType) {
        this.termType = termType == null ? null : termType.trim();
    }

    /**
     * 原到期日期
     * @return ORIG_EXPI_DATE 原到期日期
     */
    public String getOrigExpiDate() {
        return origExpiDate;
    }

    /**
     * 原到期日期
     * @param origExpiDate 原到期日期
     */
    public void setOrigExpiDate(String origExpiDate) {
        this.origExpiDate = origExpiDate == null ? null : origExpiDate.trim();
    }

    /**
     * 基准利率(年)
     * @return RULING_IR 基准利率(年)
     */
    public BigDecimal getRulingIr() {
        return rulingIr;
    }

    /**
     * 基准利率(年)
     * @param rulingIr 基准利率(年)
     */
    public void setRulingIr(BigDecimal rulingIr) {
        this.rulingIr = rulingIr;
    }

    /**
     * 利率浮动值
     * @return FLOATING_RATE 利率浮动值
     */
    public BigDecimal getFloatingRate() {
        return floatingRate;
    }

    /**
     * 利率浮动值
     * @param floatingRate 利率浮动值
     */
    public void setFloatingRate(BigDecimal floatingRate) {
        this.floatingRate = floatingRate;
    }

    /**
     * 执行利率(年)
     * @return REALITY_IR_Y 执行利率(年)
     */
    public BigDecimal getRealityIrY() {
        return realityIrY;
    }

    /**
     * 执行利率(年)
     * @param realityIrY 执行利率(年)
     */
    public void setRealityIrY(BigDecimal realityIrY) {
        this.realityIrY = realityIrY;
    }

    /**
     * 逾期加罚率
     * @return OVERDUE_RATE 逾期加罚率
     */
    public BigDecimal getOverdueRate() {
        return overdueRate;
    }

    /**
     * 逾期加罚率
     * @param overdueRate 逾期加罚率
     */
    public void setOverdueRate(BigDecimal overdueRate) {
        this.overdueRate = overdueRate;
    }

    /**
     * 逾期加月罚率
     * @return OVERDUE_IR 逾期加月罚率
     */
    public BigDecimal getOverdueIr() {
        return overdueIr;
    }

    /**
     * 逾期加月罚率
     * @param overdueIr 逾期加月罚率
     */
    public void setOverdueIr(BigDecimal overdueIr) {
        this.overdueIr = overdueIr;
    }

    /**
     * 违约加罚率
     * @return DEFAULT_RATE 违约加罚率
     */
    public BigDecimal getDefaultRate() {
        return defaultRate;
    }

    /**
     * 违约加罚率
     * @param defaultRate 违约加罚率
     */
    public void setDefaultRate(BigDecimal defaultRate) {
        this.defaultRate = defaultRate;
    }

    /**
     * 违约月利率
     * @return DEFAULT_IR 违约月利率
     */
    public BigDecimal getDefaultIr() {
        return defaultIr;
    }

    /**
     * 违约月利率
     * @param defaultIr 违约月利率
     */
    public void setDefaultIr(BigDecimal defaultIr) {
        this.defaultIr = defaultIr;
    }

    /**
     * 复利加罚率
     * @return CI_RATE 复利加罚率
     */
    public BigDecimal getCiRate() {
        return ciRate;
    }

    /**
     * 复利加罚率
     * @param ciRate 复利加罚率
     */
    public void setCiRate(BigDecimal ciRate) {
        this.ciRate = ciRate;
    }

    /**
     * 复利月利率
     * @return CI_IR 复利月利率
     */
    public BigDecimal getCiIr() {
        return ciIr;
    }

    /**
     * 复利月利率
     * @param ciIr 复利月利率
     */
    public void setCiIr(BigDecimal ciIr) {
        this.ciIr = ciIr;
    }

    /**
     * 应收利息累计
     * @return RECE_INT_CUMU 应收利息累计
     */
    public BigDecimal getReceIntCumu() {
        return receIntCumu;
    }

    /**
     * 应收利息累计
     * @param receIntCumu 应收利息累计
     */
    public void setReceIntCumu(BigDecimal receIntCumu) {
        this.receIntCumu = receIntCumu;
    }

    /**
     * 实收利息累计
     * @return ACTUAL_INT_CUMU 实收利息累计
     */
    public BigDecimal getActualIntCumu() {
        return actualIntCumu;
    }

    /**
     * 实收利息累计
     * @param actualIntCumu 实收利息累计
     */
    public void setActualIntCumu(BigDecimal actualIntCumu) {
        this.actualIntCumu = actualIntCumu;
    }

    /**
     * 欠息累计
     * @return DELAY_INT_CUMU 欠息累计
     */
    public BigDecimal getDelayIntCumu() {
        return delayIntCumu;
    }

    /**
     * 欠息累计
     * @param delayIntCumu 欠息累计
     */
    public void setDelayIntCumu(BigDecimal delayIntCumu) {
        this.delayIntCumu = delayIntCumu;
    }

    /**
     * 表内欠息
     * @return INNER_INT_CUMU 表内欠息
     */
    public BigDecimal getInnerIntCumu() {
        return innerIntCumu;
    }

    /**
     * 表内欠息
     * @param innerIntCumu 表内欠息
     */
    public void setInnerIntCumu(BigDecimal innerIntCumu) {
        this.innerIntCumu = innerIntCumu;
    }

    /**
     * 表外欠息
     * @return OFF_INT_CUMU 表外欠息
     */
    public BigDecimal getOffIntCumu() {
        return offIntCumu;
    }

    /**
     * 表外欠息
     * @param offIntCumu 表外欠息
     */
    public void setOffIntCumu(BigDecimal offIntCumu) {
        this.offIntCumu = offIntCumu;
    }

    /**
     * 表内应收
     * @return INNER_RECE_INT 表内应收
     */
    public BigDecimal getInnerReceInt() {
        return innerReceInt;
    }

    /**
     * 表内应收
     * @param innerReceInt 表内应收
     */
    public void setInnerReceInt(BigDecimal innerReceInt) {
        this.innerReceInt = innerReceInt;
    }

    /**
     * 逾期应收
     * @return OVERDUE_RECE_INT 逾期应收
     */
    public BigDecimal getOverdueReceInt() {
        return overdueReceInt;
    }

    /**
     * 逾期应收
     * @param overdueReceInt 逾期应收
     */
    public void setOverdueReceInt(BigDecimal overdueReceInt) {
        this.overdueReceInt = overdueReceInt;
    }

    /**
     * 表外利息应收
     * @return OFF_RECE_INT 表外利息应收
     */
    public BigDecimal getOffReceInt() {
        return offReceInt;
    }

    /**
     * 表外利息应收
     * @param offReceInt 表外利息应收
     */
    public void setOffReceInt(BigDecimal offReceInt) {
        this.offReceInt = offReceInt;
    }

    /**
     * 利息复息应收
     * @return COMPOUND_RECE_INT 利息复息应收
     */
    public BigDecimal getCompoundReceInt() {
        return compoundReceInt;
    }

    /**
     * 利息复息应收
     * @param compoundReceInt 利息复息应收
     */
    public void setCompoundReceInt(BigDecimal compoundReceInt) {
        this.compoundReceInt = compoundReceInt;
    }

    /**
     * 表内转表外利息应收
     * @return INNER_OFF_RECE_INT 表内转表外利息应收
     */
    public BigDecimal getInnerOffReceInt() {
        return innerOffReceInt;
    }

    /**
     * 表内转表外利息应收
     * @param innerOffReceInt 表内转表外利息应收
     */
    public void setInnerOffReceInt(BigDecimal innerOffReceInt) {
        this.innerOffReceInt = innerOffReceInt;
    }

    /**
     * 表内实收
     * @return INNER_ACTL_INT 表内实收
     */
    public BigDecimal getInnerActlInt() {
        return innerActlInt;
    }

    /**
     * 表内实收
     * @param innerActlInt 表内实收
     */
    public void setInnerActlInt(BigDecimal innerActlInt) {
        this.innerActlInt = innerActlInt;
    }

    /**
     * 逾期实收
     * @return OVERDUE_ACTL_INT 逾期实收
     */
    public BigDecimal getOverdueActlInt() {
        return overdueActlInt;
    }

    /**
     * 逾期实收
     * @param overdueActlInt 逾期实收
     */
    public void setOverdueActlInt(BigDecimal overdueActlInt) {
        this.overdueActlInt = overdueActlInt;
    }

    /**
     * 表外利息实收
     * @return OFF_ACTL_INT 表外利息实收
     */
    public BigDecimal getOffActlInt() {
        return offActlInt;
    }

    /**
     * 表外利息实收
     * @param offActlInt 表外利息实收
     */
    public void setOffActlInt(BigDecimal offActlInt) {
        this.offActlInt = offActlInt;
    }

    /**
     * 利息复息实收
     * @return COMPOUND_ACTL_INT 利息复息实收
     */
    public BigDecimal getCompoundActlInt() {
        return compoundActlInt;
    }

    /**
     * 利息复息实收
     * @param compoundActlInt 利息复息实收
     */
    public void setCompoundActlInt(BigDecimal compoundActlInt) {
        this.compoundActlInt = compoundActlInt;
    }

    /**
     * 表内转表外利息实收
     * @return INNER_OFF_ACTL_INT 表内转表外利息实收
     */
    public BigDecimal getInnerOffActlInt() {
        return innerOffActlInt;
    }

    /**
     * 表内转表外利息实收
     * @param innerOffActlInt 表内转表外利息实收
     */
    public void setInnerOffActlInt(BigDecimal innerOffActlInt) {
        this.innerOffActlInt = innerOffActlInt;
    }

    /**
     * 正常贷款余额(元)
     * @return NORMAL_BALANCE 正常贷款余额(元)
     */
    public BigDecimal getNormalBalance() {
        return normalBalance;
    }

    /**
     * 正常贷款余额(元)
     * @param normalBalance 正常贷款余额(元)
     */
    public void setNormalBalance(BigDecimal normalBalance) {
        this.normalBalance = normalBalance;
    }

    /**
     * 逾期贷款余额(元)
     * @return OVERDUE_BALANCE 逾期贷款余额(元)
     */
    public BigDecimal getOverdueBalance() {
        return overdueBalance;
    }

    /**
     * 逾期贷款余额(元)
     * @param overdueBalance 逾期贷款余额(元)
     */
    public void setOverdueBalance(BigDecimal overdueBalance) {
        this.overdueBalance = overdueBalance;
    }

    /**
     * 呆滞贷款余额(元)
     * @return SLUGGISH_BALANCE 呆滞贷款余额(元)
     */
    public BigDecimal getSluggishBalance() {
        return sluggishBalance;
    }

    /**
     * 呆滞贷款余额(元)
     * @param sluggishBalance 呆滞贷款余额(元)
     */
    public void setSluggishBalance(BigDecimal sluggishBalance) {
        this.sluggishBalance = sluggishBalance;
    }

    /**
     * 呆账贷款余额(元)
     * @return DOUBTFUL_BALANCE 呆账贷款余额(元)
     */
    public BigDecimal getDoubtfulBalance() {
        return doubtfulBalance;
    }

    /**
     * 呆账贷款余额(元)
     * @param doubtfulBalance 呆账贷款余额(元)
     */
    public void setDoubtfulBalance(BigDecimal doubtfulBalance) {
        this.doubtfulBalance = doubtfulBalance;
    }

    /**
     * 积数_年
     * @return INTEGRAL_Y 积数_年
     */
    public BigDecimal getIntegralY() {
        return integralY;
    }

    /**
     * 积数_年
     * @param integralY 积数_年
     */
    public void setIntegralY(BigDecimal integralY) {
        this.integralY = integralY;
    }

    /**
     * 积数_季
     * @return INTEGRAL_Q 积数_季
     */
    public BigDecimal getIntegralQ() {
        return integralQ;
    }

    /**
     * 积数_季
     * @param integralQ 积数_季
     */
    public void setIntegralQ(BigDecimal integralQ) {
        this.integralQ = integralQ;
    }

    /**
     * 积数_月
     * @return INTEGRAL_M 积数_月
     */
    public BigDecimal getIntegralM() {
        return integralM;
    }

    /**
     * 积数_月
     * @param integralM 积数_月
     */
    public void setIntegralM(BigDecimal integralM) {
        this.integralM = integralM;
    }

    /**
     * 正常回收累计
     * @return NOR_REC_ACCU 正常回收累计
     */
    public BigDecimal getNorRecAccu() {
        return norRecAccu;
    }

    /**
     * 正常回收累计
     * @param norRecAccu 正常回收累计
     */
    public void setNorRecAccu(BigDecimal norRecAccu) {
        this.norRecAccu = norRecAccu;
    }

    /**
     * 资产重组累计
     * @return REO_REC_ACCU 资产重组累计
     */
    public BigDecimal getReoRecAccu() {
        return reoRecAccu;
    }

    /**
     * 资产重组累计
     * @param reoRecAccu 资产重组累计
     */
    public void setReoRecAccu(BigDecimal reoRecAccu) {
        this.reoRecAccu = reoRecAccu;
    }

    /**
     * 资产剥离累计
     * @return PEEL_REC_ACCU 资产剥离累计
     */
    public BigDecimal getPeelRecAccu() {
        return peelRecAccu;
    }

    /**
     * 资产剥离累计
     * @param peelRecAccu 资产剥离累计
     */
    public void setPeelRecAccu(BigDecimal peelRecAccu) {
        this.peelRecAccu = peelRecAccu;
    }

    /**
     * 以资抵债累计
     * @return ASSET_REC_ACCU 以资抵债累计
     */
    public BigDecimal getAssetRecAccu() {
        return assetRecAccu;
    }

    /**
     * 以资抵债累计
     * @param assetRecAccu 以资抵债累计
     */
    public void setAssetRecAccu(BigDecimal assetRecAccu) {
        this.assetRecAccu = assetRecAccu;
    }

    /**
     * 担保代偿累计
     * @return ASSURE_REC_ACCU 担保代偿累计
     */
    public BigDecimal getAssureRecAccu() {
        return assureRecAccu;
    }

    /**
     * 担保代偿累计
     * @param assureRecAccu 担保代偿累计
     */
    public void setAssureRecAccu(BigDecimal assureRecAccu) {
        this.assureRecAccu = assureRecAccu;
    }

    /**
     * 核损核销累计
     * @return CANCEL_REC_ACCU 核损核销累计
     */
    public BigDecimal getCancelRecAccu() {
        return cancelRecAccu;
    }

    /**
     * 核损核销累计
     * @param cancelRecAccu 核损核销累计
     */
    public void setCancelRecAccu(BigDecimal cancelRecAccu) {
        this.cancelRecAccu = cancelRecAccu;
    }

    /**
     * 政策性还款累计
     * @return POLICY_REC_ACCU 政策性还款累计
     */
    public BigDecimal getPolicyRecAccu() {
        return policyRecAccu;
    }

    /**
     * 政策性还款累计
     * @param policyRecAccu 政策性还款累计
     */
    public void setPolicyRecAccu(BigDecimal policyRecAccu) {
        this.policyRecAccu = policyRecAccu;
    }

    /**
     * 债转股累计
     * @return DTE_REC_ACCU 债转股累计
     */
    public BigDecimal getDteRecAccu() {
        return dteRecAccu;
    }

    /**
     * 债转股累计
     * @param dteRecAccu 债转股累计
     */
    public void setDteRecAccu(BigDecimal dteRecAccu) {
        this.dteRecAccu = dteRecAccu;
    }

    /**
     * 转出累计
     * @return ROLL_REC_ACCU 转出累计
     */
    public BigDecimal getRollRecAccu() {
        return rollRecAccu;
    }

    /**
     * 转出累计
     * @param rollRecAccu 转出累计
     */
    public void setRollRecAccu(BigDecimal rollRecAccu) {
        this.rollRecAccu = rollRecAccu;
    }

    /**
     * 本年最高余额
     * @return MAX_BALANCE_Y 本年最高余额
     */
    public BigDecimal getMaxBalanceY() {
        return maxBalanceY;
    }

    /**
     * 本年最高余额
     * @param maxBalanceY 本年最高余额
     */
    public void setMaxBalanceY(BigDecimal maxBalanceY) {
        this.maxBalanceY = maxBalanceY;
    }

    /**
     * 本季最高余额
     * @return MAX_BALANCE_Q 本季最高余额
     */
    public BigDecimal getMaxBalanceQ() {
        return maxBalanceQ;
    }

    /**
     * 本季最高余额
     * @param maxBalanceQ 本季最高余额
     */
    public void setMaxBalanceQ(BigDecimal maxBalanceQ) {
        this.maxBalanceQ = maxBalanceQ;
    }

    /**
     * 本月最高余额
     * @return MAX_BALANCE_M 本月最高余额
     */
    public BigDecimal getMaxBalanceM() {
        return maxBalanceM;
    }

    /**
     * 本月最高余额
     * @param maxBalanceM 本月最高余额
     */
    public void setMaxBalanceM(BigDecimal maxBalanceM) {
        this.maxBalanceM = maxBalanceM;
    }

    /**
     * 按揭标识
     * @return MORTGAGE_FLG 按揭标识
     */
    public String getMortgageFlg() {
        return mortgageFlg;
    }

    /**
     * 按揭标识
     * @param mortgageFlg 按揭标识
     */
    public void setMortgageFlg(String mortgageFlg) {
        this.mortgageFlg = mortgageFlg == null ? null : mortgageFlg.trim();
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
     * 首次放款日期
     * @return FIRST_DISB_DATE 首次放款日期
     */
    public String getFirstDisbDate() {
        return firstDisbDate;
    }

    /**
     * 首次放款日期
     * @param firstDisbDate 首次放款日期
     */
    public void setFirstDisbDate(String firstDisbDate) {
        this.firstDisbDate = firstDisbDate == null ? null : firstDisbDate.trim();
    }

    /**
     * 贷款投向
     * @return LOAN_DIRECTION 贷款投向
     */
    public String getLoanDirection() {
        return loanDirection;
    }

    /**
     * 贷款投向
     * @param loanDirection 贷款投向
     */
    public void setLoanDirection(String loanDirection) {
        this.loanDirection = loanDirection == null ? null : loanDirection.trim();
    }

    /**
     * 借新还旧次数
     * @return REVOLVING_TIMES 借新还旧次数
     */
    public Short getRevolvingTimes() {
        return revolvingTimes;
    }

    /**
     * 借新还旧次数
     * @param revolvingTimes 借新还旧次数
     */
    public void setRevolvingTimes(Short revolvingTimes) {
        this.revolvingTimes = revolvingTimes;
    }

    /**
     * 展期次数
     * @return EXTENSION_TIMES 展期次数
     */
    public Short getExtensionTimes() {
        return extensionTimes;
    }

    /**
     * 展期次数
     * @param extensionTimes 展期次数
     */
    public void setExtensionTimes(Short extensionTimes) {
        this.extensionTimes = extensionTimes;
    }

    /**
     * 本金逾期起始日期
     * @return CAP_OVERDUE_DATE 本金逾期起始日期
     */
    public String getCapOverdueDate() {
        return capOverdueDate;
    }

    /**
     * 本金逾期起始日期
     * @param capOverdueDate 本金逾期起始日期
     */
    public void setCapOverdueDate(String capOverdueDate) {
        this.capOverdueDate = capOverdueDate == null ? null : capOverdueDate.trim();
    }

    /**
     * 利息逾期起始日期
     * @return INT_OVERDUE_DATE 利息逾期起始日期
     */
    public String getIntOverdueDate() {
        return intOverdueDate;
    }

    /**
     * 利息逾期起始日期
     * @param intOverdueDate 利息逾期起始日期
     */
    public void setIntOverdueDate(String intOverdueDate) {
        this.intOverdueDate = intOverdueDate == null ? null : intOverdueDate.trim();
    }

    /**
     * 当前逾期期数
     * @return OVER_TIMES_CURRENT 当前逾期期数
     */
    public Short getOverTimesCurrent() {
        return overTimesCurrent;
    }

    /**
     * 当前逾期期数
     * @param overTimesCurrent 当前逾期期数
     */
    public void setOverTimesCurrent(Short overTimesCurrent) {
        this.overTimesCurrent = overTimesCurrent;
    }

    /**
     * 累计逾期期数
     * @return OVER_TIMES_TOTAL 累计逾期期数
     */
    public Short getOverTimesTotal() {
        return overTimesTotal;
    }

    /**
     * 累计逾期期数
     * @param overTimesTotal 累计逾期期数
     */
    public void setOverTimesTotal(Short overTimesTotal) {
        this.overTimesTotal = overTimesTotal;
    }

    /**
     * 最高逾期期数
     * @return MAX_TIMES_TOTAL 最高逾期期数
     */
    public Short getMaxTimesTotal() {
        return maxTimesTotal;
    }

    /**
     * 最高逾期期数
     * @param maxTimesTotal 最高逾期期数
     */
    public void setMaxTimesTotal(Short maxTimesTotal) {
        this.maxTimesTotal = maxTimesTotal;
    }

    /**
     * 转不良标志
     * @return BAD_LOAN_FLAG 转不良标志
     */
    public String getBadLoanFlag() {
        return badLoanFlag;
    }

    /**
     * 转不良标志
     * @param badLoanFlag 转不良标志
     */
    public void setBadLoanFlag(String badLoanFlag) {
        this.badLoanFlag = badLoanFlag == null ? null : badLoanFlag.trim();
    }

    /**
     * 违约标志
     * @return DEFAULT_FLAG 违约标志
     */
    public String getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 违约标志
     * @param defaultFlag 违约标志
     */
    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag == null ? null : defaultFlag.trim();
    }

    /**
     * 授信额度使用标志
     * @return LIMIT_IND 授信额度使用标志
     */
    public String getLimitInd() {
        return limitInd;
    }

    /**
     * 授信额度使用标志
     * @param limitInd 授信额度使用标志
     */
    public void setLimitInd(String limitInd) {
        this.limitInd = limitInd == null ? null : limitInd.trim();
    }

    /**
     * 四级分类标志
     * @return LOAN_FORM4 四级分类标志
     */
    public String getLoanForm4() {
        return loanForm4;
    }

    /**
     * 四级分类标志
     * @param loanForm4 四级分类标志
     */
    public void setLoanForm4(String loanForm4) {
        this.loanForm4 = loanForm4 == null ? null : loanForm4.trim();
    }

    /**
     * 五级分类标志
     * @return CLA 五级分类标志
     */
    public String getCla() {
        return cla;
    }

    /**
     * 五级分类标志
     * @param cla 五级分类标志
     */
    public void setCla(String cla) {
        this.cla = cla == null ? null : cla.trim();
    }

    /**
     * 五级分类日期
     * @return CLA_DATE 五级分类日期
     */
    public String getClaDate() {
        return claDate;
    }

    /**
     * 五级分类日期
     * @param claDate 五级分类日期
     */
    public void setClaDate(String claDate) {
        this.claDate = claDate == null ? null : claDate.trim();
    }

    /**
     * 上期五级分类标志
     * @return CLA_PRE 上期五级分类标志
     */
    public String getClaPre() {
        return claPre;
    }

    /**
     * 上期五级分类标志
     * @param claPre 上期五级分类标志
     */
    public void setClaPre(String claPre) {
        this.claPre = claPre == null ? null : claPre.trim();
    }

    /**
     * 上期五级分类日期
     * @return CLA_DATE_PRE 上期五级分类日期
     */
    public String getClaDatePre() {
        return claDatePre;
    }

    /**
     * 上期五级分类日期
     * @param claDatePre 上期五级分类日期
     */
    public void setClaDatePre(String claDatePre) {
        this.claDatePre = claDatePre == null ? null : claDatePre.trim();
    }

    /**
     * 最近还款日期
     * @return LATEST_REPAY_DATE 最近还款日期
     */
    public String getLatestRepayDate() {
        return latestRepayDate;
    }

    /**
     * 最近还款日期
     * @param latestRepayDate 最近还款日期
     */
    public void setLatestRepayDate(String latestRepayDate) {
        this.latestRepayDate = latestRepayDate == null ? null : latestRepayDate.trim();
    }

    /**
     * 客户经理
     * @return CUS_MANAGER 客户经理
     */
    public String getCusManager() {
        return cusManager;
    }

    /**
     * 客户经理
     * @param cusManager 客户经理
     */
    public void setCusManager(String cusManager) {
        this.cusManager = cusManager == null ? null : cusManager.trim();
    }

    /**
     * 受理机构
     * @return INPUT_BR_ID 受理机构
     */
    public String getInputBrId() {
        return inputBrId;
    }

    /**
     * 受理机构
     * @param inputBrId 受理机构
     */
    public void setInputBrId(String inputBrId) {
        this.inputBrId = inputBrId == null ? null : inputBrId.trim();
    }

    /**
     * 账务机构
     * @return FINA_BR_ID 账务机构
     */
    public String getFinaBrId() {
        return finaBrId;
    }

    /**
     * 账务机构
     * @param finaBrId 账务机构
     */
    public void setFinaBrId(String finaBrId) {
        this.finaBrId = finaBrId == null ? null : finaBrId.trim();
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
     * 结清日期
     * @return SETTL_DATE 结清日期
     */
    public String getSettlDate() {
        return settlDate;
    }

    /**
     * 结清日期
     * @param settlDate 结清日期
     */
    public void setSettlDate(String settlDate) {
        this.settlDate = settlDate == null ? null : settlDate.trim();
    }

    /**
     * 最近修改日期
     * @return LATEST_DATE 最近修改日期
     */
    public String getLatestDate() {
        return latestDate;
    }

    /**
     * 最近修改日期
     * @param latestDate 最近修改日期
     */
    public void setLatestDate(String latestDate) {
        this.latestDate = latestDate == null ? null : latestDate.trim();
    }

    /**
     * 台帐状态[STD_ZB_ACC_STATUS]
     * @return ACCOUNT_STATUS 台帐状态[STD_ZB_ACC_STATUS]
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * 台帐状态[STD_ZB_ACC_STATUS]
     * @param accountStatus 台帐状态[STD_ZB_ACC_STATUS]
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus == null ? null : accountStatus.trim();
    }

    /**
     * 业务品种分类名称
     * @return BIZ_TYPE_DETAIL 业务品种分类名称
     */
    public String getBizTypeDetail() {
        return bizTypeDetail;
    }

    /**
     * 业务品种分类名称
     * @param bizTypeDetail 业务品种分类名称
     */
    public void setBizTypeDetail(String bizTypeDetail) {
        this.bizTypeDetail = bizTypeDetail == null ? null : bizTypeDetail.trim();
    }

    /**
     * 本期计提金额
     * @return DEV_AMT 本期计提金额
     */
    public BigDecimal getDevAmt() {
        return devAmt;
    }

    /**
     * 本期计提金额
     * @param devAmt 本期计提金额
     */
    public void setDevAmt(BigDecimal devAmt) {
        this.devAmt = devAmt;
    }

    /**
     * 上期计提金额
     * @return DEV_AMT_PRE 上期计提金额
     */
    public BigDecimal getDevAmtPre() {
        return devAmtPre;
    }

    /**
     * 上期计提金额
     * @param devAmtPre 上期计提金额
     */
    public void setDevAmtPre(BigDecimal devAmtPre) {
        this.devAmtPre = devAmtPre;
    }

    /**
     * 减值准备标志
     * @return DEV_FLAG 减值准备标志
     */
    public String getDevFlag() {
        return devFlag;
    }

    /**
     * 减值准备标志
     * @param devFlag 减值准备标志
     */
    public void setDevFlag(String devFlag) {
        this.devFlag = devFlag == null ? null : devFlag.trim();
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
     * 利差
     * @return SPRD_RATE 利差
     */
    public BigDecimal getSprdRate() {
        return sprdRate;
    }

    /**
     * 利差
     * @param sprdRate 利差
     */
    public void setSprdRate(BigDecimal sprdRate) {
        this.sprdRate = sprdRate;
    }

    /**
     * 还款周期
     * @return FREQUENCY 还款周期
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * 还款周期
     * @param frequency 还款周期
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    /**
     * 还款间隔
     * @return PAY_DISTANCE 还款间隔
     */
    public Short getPayDistance() {
        return payDistance;
    }

    /**
     * 还款间隔
     * @param payDistance 还款间隔
     */
    public void setPayDistance(Short payDistance) {
        this.payDistance = payDistance;
    }

    /**
     * 还款日
     * @return DUE_DAY 还款日
     */
    public BigDecimal getDueDay() {
        return dueDay;
    }

    /**
     * 还款日
     * @param dueDay 还款日
     */
    public void setDueDay(BigDecimal dueDay) {
        this.dueDay = dueDay;
    }

    /**
     * 利率调整方式
     * @return IR_ADJUST_MODE 利率调整方式
     */
    public String getIrAdjustMode() {
        return irAdjustMode;
    }

    /**
     * 利率调整方式
     * @param irAdjustMode 利率调整方式
     */
    public void setIrAdjustMode(String irAdjustMode) {
        this.irAdjustMode = irAdjustMode == null ? null : irAdjustMode.trim();
    }

    /**
     * 支付方式
     * @return PAY_TYPE 支付方式
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 支付方式
     * @param payType 支付方式
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * null
     * @return FINE_INT null
     */
    public BigDecimal getFineInt() {
        return fineInt;
    }

    /**
     * null
     * @param fineInt null
     */
    public void setFineInt(BigDecimal fineInt) {
        this.fineInt = fineInt;
    }

    /**
     * null
     * @return COMD_INT null
     */
    public BigDecimal getComdInt() {
        return comdInt;
    }

    /**
     * null
     * @param comdInt null
     */
    public void setComdInt(BigDecimal comdInt) {
        this.comdInt = comdInt;
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
     * null
     * @return TERM_EXT null
     */
    public String getTermExt() {
        return termExt;
    }

    /**
     * null
     * @param termExt null
     */
    public void setTermExt(String termExt) {
        this.termExt = termExt == null ? null : termExt.trim();
    }

    /**
     * null
     * @return PRJ_COP_NO null
     */
    public String getPrjCopNo() {
        return prjCopNo;
    }

    /**
     * null
     * @param prjCopNo null
     */
    public void setPrjCopNo(String prjCopNo) {
        this.prjCopNo = prjCopNo == null ? null : prjCopNo.trim();
    }

    /**
     * null
     * @return NEW_ACCOUNT_CLASS null
     */
    public String getNewAccountClass() {
        return newAccountClass;
    }

    /**
     * null
     * @param newAccountClass null
     */
    public void setNewAccountClass(String newAccountClass) {
        this.newAccountClass = newAccountClass == null ? null : newAccountClass.trim();
    }

    /**
     * 贷款种类编号
     * @return LOAN_TYPE_NO 贷款种类编号
     */
    public String getLoanTypeNo() {
        return loanTypeNo;
    }

    /**
     * 贷款种类编号
     * @param loanTypeNo 贷款种类编号
     */
    public void setLoanTypeNo(String loanTypeNo) {
        this.loanTypeNo = loanTypeNo == null ? null : loanTypeNo.trim();
    }

    /**
     * 贷款种类名称
     * @return LOAN_TYPE_NAME 贷款种类名称
     */
    public String getLoanTypeName() {
        return loanTypeName;
    }

    /**
     * 贷款种类名称
     * @param loanTypeName 贷款种类名称
     */
    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName == null ? null : loanTypeName.trim();
    }

    /**
     * 初始化期限(原贷款期限)
     * @return OGR_TERM 初始化期限(原贷款期限)
     */
    public String getOgrTerm() {
        return ogrTerm;
    }

    /**
     * 初始化期限(原贷款期限)
     * @param ogrTerm 初始化期限(原贷款期限)
     */
    public void setOgrTerm(String ogrTerm) {
        this.ogrTerm = ogrTerm == null ? null : ogrTerm.trim();
    }

    /**
     * 结息周期
     * @return INTEREST_ACC_MODE 结息周期
     */
    public String getInterestAccMode() {
        return interestAccMode;
    }

    /**
     * 结息周期
     * @param interestAccMode 结息周期
     */
    public void setInterestAccMode(String interestAccMode) {
        this.interestAccMode = interestAccMode == null ? null : interestAccMode.trim();
    }

    /**
     * 表外核销本金
     * @return CANCEL_SUM 表外核销本金
     */
    public BigDecimal getCancelSum() {
        return cancelSum;
    }

    /**
     * 表外核销本金
     * @param cancelSum 表外核销本金
     */
    public void setCancelSum(BigDecimal cancelSum) {
        this.cancelSum = cancelSum;
    }

    /**
     * 表外核销利息
     * @return CANCEL_INTEREST 表外核销利息
     */
    public BigDecimal getCancelInterest() {
        return cancelInterest;
    }

    /**
     * 表外核销利息
     * @param cancelInterest 表外核销利息
     */
    public void setCancelInterest(BigDecimal cancelInterest) {
        this.cancelInterest = cancelInterest;
    }

    /**
     * null
     * @return CLA_NOW null
     */
    public String getClaNow() {
        return claNow;
    }

    /**
     * null
     * @param claNow null
     */
    public void setClaNow(String claNow) {
        this.claNow = claNow == null ? null : claNow.trim();
    }

    /**
     * null
     * @return CLA_NOW_DATE null
     */
    public String getClaNowDate() {
        return claNowDate;
    }

    /**
     * null
     * @param claNowDate null
     */
    public void setClaNowDate(String claNowDate) {
        this.claNowDate = claNowDate == null ? null : claNowDate.trim();
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
     * 业务流水号
     * @return IQP_LOAN_SERNO 业务流水号
     */
    public String getIqpLoanSerno() {
        return iqpLoanSerno;
    }

    /**
     * 业务流水号
     * @param iqpLoanSerno 业务流水号
     */
    public void setIqpLoanSerno(String iqpLoanSerno) {
        this.iqpLoanSerno = iqpLoanSerno == null ? null : iqpLoanSerno.trim();
    }

    /**
     * 合作方编号
     * @return PARTNER_NO 合作方编号
     */
    public String getPartnerNo() {
        return partnerNo;
    }

    /**
     * 合作方编号
     * @param partnerNo 合作方编号
     */
    public void setPartnerNo(String partnerNo) {
        this.partnerNo = partnerNo == null ? null : partnerNo.trim();
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
     * 投向名称
     * @return DIRECTION_NAME 投向名称
     */
    public String getDirectionName() {
        return directionName;
    }

    /**
     * 投向名称
     * @param directionName 投向名称
     */
    public void setDirectionName(String directionName) {
        this.directionName = directionName == null ? null : directionName.trim();
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
     * 贷款用途说明
     * @return USE_DEC 贷款用途说明
     */
    public String getUseDec() {
        return useDec;
    }

    /**
     * 贷款用途说明
     * @param useDec 贷款用途说明
     */
    public void setUseDec(String useDec) {
        this.useDec = useDec == null ? null : useDec.trim();
    }

    /**
     * 录入人编号
     * @return INPUT_ID 录入人编号
     */
    public String getInputId() {
        return inputId;
    }

    /**
     * 录入人编号
     * @param inputId 录入人编号
     */
    public void setInputId(String inputId) {
        this.inputId = inputId == null ? null : inputId.trim();
    }

    /**
     * 录入时间
     * @return INPUT_TIME 录入时间
     */
    public String getInputTime() {
        return inputTime;
    }

    /**
     * 录入时间
     * @param inputTime 录入时间
     */
    public void setInputTime(String inputTime) {
        this.inputTime = inputTime == null ? null : inputTime.trim();
    }

    /**
     * 修改时间
     * @return UPDATE_TIME 修改时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * 生效状态[STD_ZB_EFFECT_STATUS]
     * @return EFFECT_STATUS 生效状态[STD_ZB_EFFECT_STATUS]
     */
    public String getEffectStatus() {
        return effectStatus;
    }

    /**
     * 生效状态[STD_ZB_EFFECT_STATUS]
     * @param effectStatus 生效状态[STD_ZB_EFFECT_STATUS]
     */
    public void setEffectStatus(String effectStatus) {
        this.effectStatus = effectStatus == null ? null : effectStatus.trim();
    }

    /**
     * 合作方名称
     * @return PARTNER_NAME 合作方名称
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * 合作方名称
     * @param partnerName 合作方名称
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    /**
     * 商圈名称
     * @return CHANNEL_NAME 商圈名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 商圈名称
     * @param channelName 商圈名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    /**
     * 复勘日期
     * @return RE_EXPLORE_DATE 复勘日期
     */
    public String getReExploreDate() {
        return reExploreDate;
    }

    /**
     * 复勘日期
     * @param reExploreDate 复勘日期
     */
    public void setReExploreDate(String reExploreDate) {
        this.reExploreDate = reExploreDate == null ? null : reExploreDate.trim();
    }

    /**
     * 还款方式说明
     * @return REPAYMENT_MODE_DESC 还款方式说明
     */
    public String getRepaymentModeDesc() {
        return repaymentModeDesc;
    }

    /**
     * 还款方式说明
     * @param repaymentModeDesc 还款方式说明
     */
    public void setRepaymentModeDesc(String repaymentModeDesc) {
        this.repaymentModeDesc = repaymentModeDesc == null ? null : repaymentModeDesc.trim();
    }

    /**
     * 还本比例
     * @return REPAY_PERCENT 还本比例
     */
    public BigDecimal getRepayPercent() {
        return repayPercent;
    }

    /**
     * 还本比例
     * @param repayPercent 还本比例
     */
    public void setRepayPercent(BigDecimal repayPercent) {
        this.repayPercent = repayPercent;
    }

    /**
     * 理赔次数
     * @return CLAIM_SETTLING_FREQUENCY 理赔次数
     */
    public String getClaimSettlingFrequency() {
        return claimSettlingFrequency;
    }

    /**
     * 理赔次数
     * @param claimSettlingFrequency 理赔次数
     */
    public void setClaimSettlingFrequency(String claimSettlingFrequency) {
        this.claimSettlingFrequency = claimSettlingFrequency == null ? null : claimSettlingFrequency.trim();
    }

    /**
     * 当前理赔期次
     * @return CURRENT_CLAIM_TERM 当前理赔期次
     */
    public String getCurrentClaimTerm() {
        return currentClaimTerm;
    }

    /**
     * 当前理赔期次
     * @param currentClaimTerm 当前理赔期次
     */
    public void setCurrentClaimTerm(String currentClaimTerm) {
        this.currentClaimTerm = currentClaimTerm == null ? null : currentClaimTerm.trim();
    }

    /**
     * 协议编号
     * @return TREATY_PK 协议编号
     */
    public String getTreatyPk() {
        return treatyPk;
    }

    /**
     * 协议编号
     * @param treatyPk 协议编号
     */
    public void setTreatyPk(String treatyPk) {
        this.treatyPk = treatyPk == null ? null : treatyPk.trim();
    }

    /**
     * 免赔率
     * @return PREVENT_RATE 免赔率
     */
    public BigDecimal getPreventRate() {
        return preventRate;
    }

    /**
     * 免赔率
     * @param preventRate 免赔率
     */
    public void setPreventRate(BigDecimal preventRate) {
        this.preventRate = preventRate;
    }

    /**
     * 还款帐号
     * @return PAY_ACCOUNT 还款帐号
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * 还款帐号
     * @param payAccount 还款帐号
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
    }

    /**
     * 还款帐号名称
     * @return PAY_ACCOUNT_NAME 还款帐号名称
     */
    public String getPayAccountName() {
        return payAccountName;
    }

    /**
     * 还款帐号名称
     * @param payAccountName 还款帐号名称
     */
    public void setPayAccountName(String payAccountName) {
        this.payAccountName = payAccountName == null ? null : payAccountName.trim();
    }

    /**
     * 贴息方式
     * @return INTEREST_SUBSIDY 贴息方式
     */
    public String getInterestSubsidy() {
        return interestSubsidy;
    }

    /**
     * 贴息方式
     * @param interestSubsidy 贴息方式
     */
    public void setInterestSubsidy(String interestSubsidy) {
        this.interestSubsidy = interestSubsidy == null ? null : interestSubsidy.trim();
    }

    /**
     * 连续逾期天数
     * @return OVER_TIMES_DAYS 连续逾期天数
     */
    public Short getOverTimesDays() {
        return overTimesDays;
    }

    /**
     * 连续逾期天数
     * @param overTimesDays 连续逾期天数
     */
    public void setOverTimesDays(Short overTimesDays) {
        this.overTimesDays = overTimesDays;
    }

    /**
     * 逾期利息
     * @return OVERDUE_INT 逾期利息
     */
    public BigDecimal getOverdueInt() {
        return overdueInt;
    }

    /**
     * 逾期利息
     * @param overdueInt 逾期利息
     */
    public void setOverdueInt(BigDecimal overdueInt) {
        this.overdueInt = overdueInt;
    }

    /**
     * 逾期罚息
     * @return OVERDUE_FINE_INT 逾期罚息
     */
    public BigDecimal getOverdueFineInt() {
        return overdueFineInt;
    }

    /**
     * 逾期罚息
     * @param overdueFineInt 逾期罚息
     */
    public void setOverdueFineInt(BigDecimal overdueFineInt) {
        this.overdueFineInt = overdueFineInt;
    }

    /**
     * 贷后检查完成日期
     * @return CHECK_DATE 贷后检查完成日期
     */
    public String getCheckDate() {
        return checkDate;
    }

    /**
     * 贷后检查完成日期
     * @param checkDate 贷后检查完成日期
     */
    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate == null ? null : checkDate.trim();
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
     * 生效日期
     * @return EFFECT_DATE 生效日期
     */
    public String getEffectDate() {
        return effectDate;
    }

    /**
     * 生效日期
     * @param effectDate 生效日期
     */
    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate == null ? null : effectDate.trim();
    }

    /**
     * 累计已决金额之和
     * @return PAID_AMT_TOTAL 累计已决金额之和
     */
    public BigDecimal getPaidAmtTotal() {
        return paidAmtTotal;
    }

    /**
     * 累计已决金额之和
     * @param paidAmtTotal 累计已决金额之和
     */
    public void setPaidAmtTotal(BigDecimal paidAmtTotal) {
        this.paidAmtTotal = paidAmtTotal;
    }

    /**
     * 已追回总金额
     * @return RECOVERED_AMT_TOTAL 已追回总金额
     */
    public BigDecimal getRecoveredAmtTotal() {
        return recoveredAmtTotal;
    }

    /**
     * 已追回总金额
     * @param recoveredAmtTotal 已追回总金额
     */
    public void setRecoveredAmtTotal(BigDecimal recoveredAmtTotal) {
        this.recoveredAmtTotal = recoveredAmtTotal;
    }

    /**
     * 累计已决金额
     * @return PAID_AMT_SUM 累计已决金额
     */
    public BigDecimal getPaidAmtSum() {
        return paidAmtSum;
    }

    /**
     * 累计已决金额
     * @param paidAmtSum 累计已决金额
     */
    public void setPaidAmtSum(BigDecimal paidAmtSum) {
        this.paidAmtSum = paidAmtSum;
    }

    /**
     * 逾期开始日期
     * @return OVERDUE_START_DATE 逾期开始日期
     */
    public String getOverdueStartDate() {
        return overdueStartDate;
    }

    /**
     * 逾期开始日期
     * @param overdueStartDate 逾期开始日期
     */
    public void setOverdueStartDate(String overdueStartDate) {
        this.overdueStartDate = overdueStartDate == null ? null : overdueStartDate.trim();
    }

    /**
     * 上次台账状态
     * @return PRE_ACCOUNT_STATUS 上次台账状态
     */
    public String getPreAccountStatus() {
        return preAccountStatus;
    }

    /**
     * 上次台账状态
     * @param preAccountStatus 上次台账状态
     */
    public void setPreAccountStatus(String preAccountStatus) {
        this.preAccountStatus = preAccountStatus == null ? null : preAccountStatus.trim();
    }

    /**
     * 入网号码
     * @return NET_PHONE 入网号码
     */
    public String getNetPhone() {
        return netPhone;
    }

    /**
     * 入网号码
     * @param netPhone 入网号码
     */
    public void setNetPhone(String netPhone) {
        this.netPhone = netPhone == null ? null : netPhone.trim();
    }

    /**
     * 产品实例
     * @return PRD_INSTANCE 产品实例
     */
    public String getPrdInstance() {
        return prdInstance;
    }

    /**
     * 产品实例
     * @param prdInstance 产品实例
     */
    public void setPrdInstance(String prdInstance) {
        this.prdInstance = prdInstance == null ? null : prdInstance.trim();
    }

    /**
     * 保单关联外键
     * @return LST_FOREIGN_KEY 保单关联外键
     */
    public String getLstForeignKey() {
        return lstForeignKey;
    }

    /**
     * 保单关联外键
     * @param lstForeignKey 保单关联外键
     */
    public void setLstForeignKey(String lstForeignKey) {
        this.lstForeignKey = lstForeignKey == null ? null : lstForeignKey.trim();
    }

    /**
     * 承保清单关联主键
     * @return LST_INNET_KEY 承保清单关联主键
     */
    public String getLstInnetKey() {
        return lstInnetKey;
    }

    /**
     * 承保清单关联主键
     * @param lstInnetKey 承保清单关联主键
     */
    public void setLstInnetKey(String lstInnetKey) {
        this.lstInnetKey = lstInnetKey == null ? null : lstInnetKey.trim();
    }

    /**
     * null
     * @return RISK_GRADE null
     */
    public String getRiskGrade() {
        return riskGrade;
    }

    /**
     * null
     * @param riskGrade null
     */
    public void setRiskGrade(String riskGrade) {
        this.riskGrade = riskGrade == null ? null : riskGrade.trim();
    }

    /**
     * 提前还款标识--三湘银行(1-提前还款,默认空)
     * @return SXYH_PREPAY_FLAG 提前还款标识--三湘银行(1-提前还款,默认空)
     */
    public String getSxyhPrepayFlag() {
        return sxyhPrepayFlag;
    }

    /**
     * 提前还款标识--三湘银行(1-提前还款,默认空)
     * @param sxyhPrepayFlag 提前还款标识--三湘银行(1-提前还款,默认空)
     */
    public void setSxyhPrepayFlag(String sxyhPrepayFlag) {
        this.sxyhPrepayFlag = sxyhPrepayFlag == null ? null : sxyhPrepayFlag.trim();
    }

    /**
     * null
     * @return SECOND_ACCOUNTS null
     */
    public String getSecondAccounts() {
        return secondAccounts;
    }

    /**
     * null
     * @param secondAccounts null
     */
    public void setSecondAccounts(String secondAccounts) {
        this.secondAccounts = secondAccounts == null ? null : secondAccounts.trim();
    }
}