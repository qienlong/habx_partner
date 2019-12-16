package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class IqpMeLoanApp {
    /**
     * 业务流水号
     */
    private String serno;

    /**
     * 客户编号
     */
    private String cusId;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certCode;

    /**
     * 客户类型
     */
    private String cusType;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 申请日期
     */
    private String applyDate;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 所属商圈
     */
    private String geoLoc;

    /**
     * 方案类型
     */
    private String schemeType;

    /**
     * 贷款用途
     */
    private String loanUseType;

    /**
     * 用途说明
     */
    private String useDec;

    /**
     * 信息渠道
     */
    private String infoChannel;

    /**
     * 其它信息渠道
     */
    private String anotherInfoChannel;

    /**
     * 合作方编号
     */
    private String partnerNo;

    /**
     * 合作方名称
     */
    private String partnerName;

    /**
     * 是否联保
     */
    private String isAssure;

    /**
     * 联保协议编号
     */
    private String assureAgreeNo;

    /**
     * 联保协议名称
     */
    private String assureAgreeName;

    /**
     * 异地客户
     */
    private String isOtherPlace;

    /**
     * 贷款种类
     */
    private String bizTypeSub;

    /**
     * 需要审议的其它内容
     */
    private String otherRemark;

    /**
     * 贷款投向
     */
    private String loanDirection;

    /**
     * 贷款投向说明
     */
    private String directionName;

    /**
     * 分析日期
     */
    private String analysisDate;

    /**
     * 受理人编号
     */
    private String acceptId;

    /**
     * 受理人姓名
     */
    private String acceptName;

    /**
     * 录入人编号
     */
    private String inputId;

    /**
     * 录入人姓名
     */
    private String inputName;

    /**
     * 业务受理机构
     */
    private String mainBrId;

    /**
     * 主办人编号
     */
    private String mainUserId;

    /**
     * 主办人姓名
     */
    private String mainUserName;

    /**
     * 主办人分析权限
     */
    private BigDecimal competence;

    /**
     * 审批状态
     */
    private String approveStatus;

    /**
     * 结息周期
     */
    private String interestAccMode;

    /**
     * 还款方式
     */
    private String repaymentMode;

    /**
     * 贷款产品
     */
    private String bizType;

    /**
     * 产品名称
     */
    private String prdName;

    /**
     * 利率类型
     */
    private String irType;

    /**
     * 建议金额（元）
     */
    private BigDecimal applyAmount;

    /**
     * 申请期限(月)
     */
    private BigDecimal term;

    /**
     * 申请期限（月）
     */
    private Long applyTerm;

    /**
     * 基准利率(年)
     */
    private BigDecimal rulingIr;

    /**
     * 利差
     */
    private BigDecimal sprdRate;

    /**
     * 浮动类型
     */
    private String floatingType;

    /**
     * 浮动利率
     */
    private BigDecimal floatingRate;

    /**
     * 建议利率
     */
    private BigDecimal realityIrY;

    /**
     * 逾期加罚率
     */
    private BigDecimal overdueRate;

    /**
     * 逾期罚息利率（年）
     */
    private BigDecimal overdueIr;

    /**
     * 违约罚息利率
     */
    private BigDecimal defaultRate;

    /**
     * 违约利率
     */
    private BigDecimal defaultIr;

    /**
     * 罚息利率
     */
    private BigDecimal ciRate;

    /**
     * 复息利率
     */
    private BigDecimal ciIr;

    /**
     * 利率调整方式
     */
    private String irAdjustMode;

    /**
     * 还款周期
     */
    private String frequency;

    /**
     * 还款间隔
     */
    private String payDistance;

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
     * 申请流
     */
    private String appWorkflowId;

    /**
     * 申请表单
     */
    private String appForm;

    /**
     * 还款日
     */
    private Short dueDay;

    /**
     * 申请币种
     */
    private String applyCurType;

    /**
     * 宽限期天数
     */
    private BigDecimal daysOfGrace;

    /**
     * 支付方式
     */
    private String payType;

    /**
     * 业务归属机构
     */
    private String inputBrId;

    /**
     * 期限类型
     */
    private String termTimeType;

    /**
     * 拒绝原因
     */
    private String refuseReason;

    /**
     * 申请意见
     */
    private String applyAdvise;

    /**
     * 是否合作方
     */
    private String isFlag;

    /**
     * 合同名称
     */
    private String contName;

    /**
     * 首次还款日
     */
    private String dueFirstDay;

    /**
     * 合同是否公正
     */
    private String contPublic;

    /**
     * 是否办理抵押登记
     */
    private String isRecord;

    /**
     * REFUSE_TIME 暂时没使用
     */
    private String refuseTime;

    /**
     * REFUSE_CODE 暂时没使用
     */
    private String refuseCode;

    /**
     * 可能的担保人姓名
     */
    private String guarantor;

    /**
     * 职业
     */
    private String guarantorOcc;

    /**
     * 年收入
     */
    private BigDecimal guarantorIncm;

    /**
     * 担保人身份证号
     */
    private String guarantorCode;

    /**
     * 担保人电话
     */
    private String guarantorPhone;

    /**
     * 与申请人的关系
     */
    private String guarantorRelate;

    /**
     * 法人保证人
     */
    private String corpGuarName;

    /**
     * 保证人与申请人关系
     */
    private String corpRelate;

    /**
     * 法人保证人基本信息描述
     */
    private String corpDesc;

    /**
     * 可能的抵质押物
     */
    private String mayGrt;

    /**
     * 抵质押物预估价值
     */
    private BigDecimal grtValue;

    /**
     * 是否足值
     */
    private String isWorth;

    /**
     * 推广时间
     */
    private String spreadTime;

    /**
     * 推广地点
     */
    private String spreadPlace;

    /**
     * 推广人
     */
    private String spreadName;

    /**
     * 风险分析
     */
    private String riskAnalyse;

    /**
     * 客户经理建议
     */
    private String managerAdvice;

    /**
     * 性别
     */
    private String cusSex;

    /**
     * 贷款用途
     */
    private String loanUse;

    /**
     * READ_FLAG 暂时没使用
     */
    private String readFlag;

    /**
     * 申请贷款用途描述
     */
    private String loanUseDesc;

    /**
     * ASSI_ID 暂时没使用
     */
    private String assiId;

    /**
     * ASSI_NAME 暂时没使用
     */
    private String assiName;

    /**
     * 申请金额（元）
     */
    private BigDecimal amount;

    /**
     * 执行利率(年)
     */
    private BigDecimal usingIr;

    /**
     * 产品编号
     */
    private String prdId;

    /**
     * 申请机构名称
     */
    private String inputBrName;

    /**
     * 机构级别
     */
    private String inputLevel;

    /**
     * MAIN_LEVEL 暂时没使用
     */
    private String mainLevel;

    /**
     * PROP 暂时没使用
     */
    private String prop;

    /**
     * 是否多次放款
     */
    private String isMoreLoan;

    /**
     * 录入日期
     */
    private String inputDate;

    /**
     * 审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     */
    private String appStatus;

    /**
     * 合作方类型
     */
    private String partnerType;

    /**
     * 合作方证件号
     */
    private String partnerCertCode;

    /**
     * 合作方证件类型
     */
    private String partnerCertType;

    /**
     * 业务操作时间
     */
    private String updateDate;

    /**
     * 是否涉农:STD_ZX_YES_NO 1-是 2-否
     */
    private String isAgriculture;

    /**
     * 录入渠道[3:移动银行]
     */
    private String inputChannel;

    /**
     * 是否存量客户
     */
    private String isAddCus;

    /**
     * 审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     */
    private String newApproveStatus;

    /**
     * 商圈编号
     */
    private String channelNo;

    /**
     * 商圈名称
     */
    private String channelName;

    /**
     * 是否准备完成:STD_ZX_YES_NO 1-是 2-否
     */
    private String isAlready;

    /**
     * 是否预约成功:STD_ZX_YES_NO 1-是 2-否
     */
    private String isOrder;

    /**
     * 总项目成本
     */
    private BigDecimal prjCost;

    /**
     * 项目步骤
     */
    private String prjStep;

    /**
     * 贷款使用明细
     */
    private String useDetail;

    /**
     * 贷款原因
     */
    private String loanReason;

    /**
     * 建议的贷款金额（元）
     */
    private BigDecimal adviseAmt;

    /**
     * 建议的期限（月）
     */
    private String adviseDeadline;

    /**
     * 建议的还款方式:STD_ZB_REPAY_MODE 2-等额本金还款,3-按月等额本息,6-按月付息到期还本,7-到期一次还款
     */
    private String adviseRepaymentWay;

    /**
     * 建议保证人
     */
    private String adviseGuarPerson;

    /**
     * 特殊情况/其他条件（抵押等）
     */
    private String specialCase;

    /**
     * 客户经理
     */
    private String cusMgr;

    /**
     * 建议日期
     */
    private String adviseDate;

    /**
     * 核保打印流水号
     */
    private String guaranteeSerno;

    /**
     * 团队编号
     */
    private String teamno;

    /**
     * 团队长编号
     */
    private String teamLeader;

    /**
     * 小组编号
     */
    private String groupno;

    /**
     * 小组长编号
     */
    private String groupLeader;

    /**
     * 是否已注销:STD_ZX_YES_NO 1-是 2-否
     */
    private String isCancel;

    /**
     * 业务人员编号
     */
    private String businessPersionId;

    /**
     * 业务人员名称
     */
    private String businessPersionName;

    /**
     * 业务人员电话
     */
    private String businessPersionPhone;

    /**
     * 银行客户经理
     */
    private String bankCusMgr;

    /**
     * 银行客户经理手机号
     */
    private String bankMgrPhone;

    /**
     * 操作标识:STD_IQP_OPT_TYPE 1-新增,2-补录
     */
    private String optType;

    /**
     * 是否批量业务
     */
    private String isBatcBiz;

    /**
     * 还款方式说明
     */
    private String repaymentModeDesc;

    /**
     * 建议的还款方式说明
     */
    private String adviseRepaymentWayDesc;

    /**
     * 业务模式
     */
    private String bizMode;

    /**
     * 贷款形式
     */
    private String loanForm;

    /**
     * 还款来源
     */
    private String repaymentSrc;

    /**
     * 抵押物类型
     */
    private String guarantyType;

    /**
     * 抵押物名称
     */
    private String guarantyName;

    /**
     * 房产证号
     */
    private String houseCertNo;

    /**
     * 产权人
     */
    private String righterName;

    /**
     * 产权人证件类型
     */
    private String righterCertType;

    /**
     * 产权人证件号码
     */
    private String righterCertCode;

    /**
     * 是否抵押给第三方
     */
    private String isGrtThird;

    /**
     * 原借据编号
     */
    private String oBillNo;

    /**
     * 原合同编号
     */
    private String oContNo;

    /**
     * 贷款余额
     */
    private BigDecimal loanBalance;

    /**
     * 原贷款利率
     */
    private BigDecimal oUsingIr;

    /**
     * 原起贷日期
     */
    private String oLoanStartDate;

    /**
     * 原止贷日期
     */
    private String oLoanEndDate;

    /**
     * 业务人员所属机构
     */
    private String businessBrId;

    /**
     * 总抵(质)押率
     */
    private BigDecimal totalNessRate;

    /**
     * 注销失败原因
     */
    private String cancelFailCause;

    /**
     * 抵押物评估净值
     */
    private BigDecimal evalNetValue;

    /**
     * 反担保措施
     */
    private String unassureMeansActions;

    /**
     * 信贷记录说明
     */
    private String spreadPlaceDesc;

    /**
     * 备注
     */
    private String remark;

    /**
     * 费率(‰)
     */
    private BigDecimal costRate;

    /**
     * 承保贷款金额
     */
    private BigDecimal acceptLoanAmount;

    /**
     * 分公司机构号
     */
    private String suborganno;

    /**
     * 进件来源
     */
    private String impThiSrc;

    /**
     * 是否电子保单
     */
    private String isElecIns;

    /**
     * 是否允许修改
     */
    private String isUpdate;

    /**
     * 是否合格(FACO评分)
     */
    private String isPass;

    /**
     * 还本比例
     */
    private BigDecimal repayPercent;

    /**
     * 建议还本比例
     */
    private BigDecimal adviseRepayPercent;

    /**
     * 得分
     */
    private String ficoScore;

    /**
     * 不通过原因
     */
    private String notThroughReason;

    /**
     * fico评分最新记录id
     */
    private String ficoRecordId;

    /**
     * 推广时间
     */
    private String spreadDate;

    /**
     * 经办人
     */
    private String operName;

    /**
     * 经办人手机号
     */
    private String operPhone;

    /**
     * 经办人电话
     */
    private String operTelNo;

    /**
     * 业务归属机构
     */
    private String belongBrId;

    /**
     * p2p方的审核结果 
     */
    private String p2pApproveStatus;

    /**
     * 拒绝备注
     */
    private String refuseremark;

    /**
     * 贷款申请是否成功发送
     */
    private String isSendLoan;

    /**
     * 处理时间(个分险出结果时间)
     */
    private String handleTime;

    /**
     * THIRD_PLATFORM
     */
    private String thirdPlatform;

    /**
     * THIRD_PLATFORM_NAME
     */
    private String thirdPlatformName;

    /**
     * 能否出单1是，2否
     */
    private String canSingle;

    /**
     * 1已分配，2未分配
     */
    private String isDistribution;

    /**
     * 期限天
     */
    private BigDecimal termDay;

    /**
     * 建议的期限（天）
     */
    private String adviseTerm;

    /**
     * 贷款状态
     */
    private String loanStatus;

    /**
     * 影像资料上传状态
     */
    private String sendImageStatus;

    /**
     * 新增客户类别
     */
    private String cusTypeNew;

    /**
     * 借据协议编号
     */
    private String accAgreeNo;

    /**
     * 业务推送机构
     */
    private String pushBrId;

    /**
     * 期数
     */
    private BigDecimal period;

    /**
     * 自动审核
     */
    private String autoappr;

    /**
     * 取消贷款备注
     */
    private String caccelLoanRemarks;

    /**
     * 取消贷款原因
     */
    private String caccelLoanReason;

    /**
     * 被保险人客户编号
     */
    private String bidCusId;

    /**
     * 特别约定
     */
    private String cAppnt;

    /**
     * 银行卡号
     */
    private String bankCardNo;

    /**
     * 预审结果
     */
    private String validResult;

    /**
     * 是否自动审批
     */
    private String isAutoApprove;

    /**
     * 招标方客户编号
     */
    private String partnerCusId;

    /**
     * MODIFYREASON
     */
    private String modifyreason;

    /**
     * 特殊标识
     */
    private String specialFlag;

    /**
     * 签报号
     */
    private String jiraNo;

    /**
     * 规则金额
     */
    private BigDecimal ruleLoanAmt;

    /**
     * 特殊说明
     */
    private String specialRemark;

    /**
     * 00待上传影像 01 影像上传中 02 影像上传异常 03 待放款申请  04 放款申请中 05 放款申请异常 06 放款申请发送成功 07 放款失败 08待出单 09出单异常 10 待上传保单 11保单发送中 12保单发送失败 13 保单发送异常 14结束
     */
    private String busiStatus;

    /**
     * 还款人开户行
     */
    private String repayBank;

    /**
     * 还款人账户名
     */
    private String repayAccountName;

    /**
     * 还款人账户号
     */
    private String repayAccount;

    /**
     * 收款人开户行
     */
    private String payeeBank;

    /**
     * 收款人账户名
     */
    private String payeeAccountName;

    /**
     * 收款人账户号
     */
    private String payeeAccount;

    /**
     * 赎楼类型
     */
    private String ransomType;

    /**
     * 原房屋贷款余额
     */
    private BigDecimal oldHouseAmount;

    /**
     * 用款时间
     */
    private String useDate;

    /**
     * 买方客户编号
     */
    private String buyerCusId;

    /**
     * 卖方客户编号
     */
    private String sellerCusId;

    /**
     * 买方证件类型
     */
    private String buyerCertType;

    /**
     * 买方证件号码
     */
    private String buyerCertCode;

    /**
     * 买方客户类型
     */
    private String buyerCusType;

    /**
     * 买方客户名称
     */
    private String buyerCusName;

    /**
     * 买方联系电话
     */
    private String buyerPhone;

    /**
     * 卖方证件类型
     */
    private String sellerCertType;

    /**
     * 卖方证件号码
     */
    private String sellerCertCode;

    /**
     * 卖方客户类型
     */
    private String sellerCusType;

    /**
     * 卖方客户名称
     */
    private String sellerCusName;

    /**
     * 卖方联系电话
     */
    private String sellerPhone;

    /**
     * 首期款监管额
     */
    private BigDecimal buyerFirstAmount;

    /**
     * 买方贷款金额
     */
    private BigDecimal buyerAmount;

    /**
     * 买方贷款申请银行名称
     */
    private String buyerBankName;

    /**
     * 买方贷款申请银行卡号
     */
    private String buyerBankCode;

    /**
     * 风险揭示
     */
    private String riskResult;

    /**
     * 是否需赎楼
     */
    private String isMustRansom;

    /**
     * 面签位置信息
     */
    private String visaInterviewCoordinate;

    /**
     * 贷后位置信息
     */
    private String loanCoordinate;

    /**
     * 微贷申请位置信息
     */
    private String microCreditCoordinate;

    /**
     * 是否需要授信执行
     */
    private String isCreditImplementation;

    /**
     * 是否需要面签
     */
    private String isFaceSign;

    /**
     * 分期方案id
     */
    private String goodsDetailId;

    /**
     * 01- 客户端  02 -客户经理端  03 -PC 端
     */
    private String terminalSource;

    /**
     * 客户申请位置信息（区域代码）
     */
    private String countyCode;

    /**
     * 微贷申请位置信息
     */
    private String creditCoordinate;

    /**
     * 01- 安卓  02 -IOS  03 -PC 端
     */
    private String terminalType;

    /**
     * 首付比例
     */
    private BigDecimal downPayment;

    /**
     * 首付金额
     */
    private BigDecimal downAmount;

    /**
     * 分期数
     */
    private Integer monthlySupply;

    /**
     * 期供金额
     */
    private BigDecimal monthlyAmount;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 产品类型
     */
    private String prdType;

    /**
     * 支付宝帐号 为邮箱或手机
     */
    private String alipayAccount;

    /**
     * 用户在网商的会员编号
     */
    private String alipayRoleId;

    /**
     * 联行号 字典STD_BANK_NO
     */
    private String bankNo;

    /**
     * SIGN_AMOUNT
     */
    private BigDecimal signAmount;

    /**
     * 同盾设备指纹移动端
     */
    private String blackBox;

    /**
     * 是否续贷（0- 否  - 是）
     */
    private String isloaned;

    /**
     * 末笔银行贷款金额
     */
    private BigDecimal lastBankLoanAmount;

    /**
     * 是否公积金、社保授权 0- 手工录入 1- 同盾 2- 亚联盟
     */
    private String isAuthorize;

    /**
     * 是否加贷保费    true 加贷 false 不加贷
     */
    private String includeInsFee;

    /**
     * 出单员
     */
    private String handPoricyId;

    /**
     * LOAN_LX
     */
    private BigDecimal loanLx;

    /**
     * 预估用款月数
     */
    private Long estimationAmount;

    /**
     * 缴费途径
     */
    private String payWay;

    /**
     * 还款人支付宝账号
     */
    private String repayAilPayAccount;

    /**
     * 收款账户类型 STD_BANK_ACCOUNT_TYPE 1对私 2对公
     */
    private String payeeAccountType;

    /**
     * 是否承包附加险1是、2否
     */
    private String accessoryRisk;

    /**
     * 首笔贷款机构
     */
    private String fristLoanPartnerName;

    /**
     * 末笔贷款机构
     */
    private String lastLoanPartnerName;

    /**
     * 首笔贷款机构编码
     */
    private String fristLoanPartnerNo;

    /**
     * 末笔贷款机构编码
     */
    private String lastLoanPartnerNo;

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
     * 信托计划名+期次
     */
    private String trustPlan;

    /**
     * null
     */
    private String batchNo;

    /**
     * 业务推荐机构
     */
    private String businessRecomOrgname;

    /**
     * 业务推荐机构ID
     */
    private String businessRecomOrgid;

    /**
     * 业务地区
     */
    private String busiArea;

    /**
     * 是否有新贷款批复
     */
    private String newLoanApproval;

    /**
     * 新贷款银行
     */
    private String newLoanBank;

    /**
     * 还款账户开户行号
     */
    private String repayBankNo;

    /**
     * 受托支付账号
     */
    private String etLoanAcc;

    /**
     * 受托支付账户名
     */
    private String etLoanAccName;

    /**
     * 受托支付开户行号
     */
    private String etLoanAccBank;

    /**
     * 受托支付开户行名
     */
    private String etLoanAccBankNme;

    /**
     * null
     */
    private String loanDirectionCredit;
    
    /**
     * 平安保费费率码
     */
    private String insureRateCode;

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    private String paymentAccount;


    public String getInsureRateCode() {
		return insureRateCode;
	}

	public void setInsureRateCode(String insureRateCode) {
		this.insureRateCode = insureRateCode;
	}

	/**
     * 业务流水号
     * @return SERNO 业务流水号
     */
    public String getSerno() {
        return serno;
    }

    /**
     * 业务流水号
     * @param serno 业务流水号
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
     * 申请日期
     * @return APPLY_DATE 申请日期
     */
    public String getApplyDate() {
        return applyDate;
    }

    /**
     * 申请日期
     * @param applyDate 申请日期
     */
    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate == null ? null : applyDate.trim();
    }

    /**
     * 联系电话
     * @return PHONE 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系电话
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 所属商圈
     * @return GEO_LOC 所属商圈
     */
    public String getGeoLoc() {
        return geoLoc;
    }

    /**
     * 所属商圈
     * @param geoLoc 所属商圈
     */
    public void setGeoLoc(String geoLoc) {
        this.geoLoc = geoLoc == null ? null : geoLoc.trim();
    }

    /**
     * 方案类型
     * @return SCHEME_TYPE 方案类型
     */
    public String getSchemeType() {
        return schemeType;
    }

    /**
     * 方案类型
     * @param schemeType 方案类型
     */
    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType == null ? null : schemeType.trim();
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
     * 用途说明
     * @return USE_DEC 用途说明
     */
    public String getUseDec() {
        return useDec;
    }

    /**
     * 用途说明
     * @param useDec 用途说明
     */
    public void setUseDec(String useDec) {
        this.useDec = useDec == null ? null : useDec.trim();
    }

    /**
     * 信息渠道
     * @return INFO_CHANNEL 信息渠道
     */
    public String getInfoChannel() {
        return infoChannel;
    }

    /**
     * 信息渠道
     * @param infoChannel 信息渠道
     */
    public void setInfoChannel(String infoChannel) {
        this.infoChannel = infoChannel == null ? null : infoChannel.trim();
    }

    /**
     * 其它信息渠道
     * @return ANOTHER_INFO_CHANNEL 其它信息渠道
     */
    public String getAnotherInfoChannel() {
        return anotherInfoChannel;
    }

    /**
     * 其它信息渠道
     * @param anotherInfoChannel 其它信息渠道
     */
    public void setAnotherInfoChannel(String anotherInfoChannel) {
        this.anotherInfoChannel = anotherInfoChannel == null ? null : anotherInfoChannel.trim();
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
     * 是否联保
     * @return IS_ASSURE 是否联保
     */
    public String getIsAssure() {
        return isAssure;
    }

    /**
     * 是否联保
     * @param isAssure 是否联保
     */
    public void setIsAssure(String isAssure) {
        this.isAssure = isAssure == null ? null : isAssure.trim();
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
     * 联保协议名称
     * @return ASSURE_AGREE_NAME 联保协议名称
     */
    public String getAssureAgreeName() {
        return assureAgreeName;
    }

    /**
     * 联保协议名称
     * @param assureAgreeName 联保协议名称
     */
    public void setAssureAgreeName(String assureAgreeName) {
        this.assureAgreeName = assureAgreeName == null ? null : assureAgreeName.trim();
    }

    /**
     * 异地客户
     * @return IS_OTHER_PLACE 异地客户
     */
    public String getIsOtherPlace() {
        return isOtherPlace;
    }

    /**
     * 异地客户
     * @param isOtherPlace 异地客户
     */
    public void setIsOtherPlace(String isOtherPlace) {
        this.isOtherPlace = isOtherPlace == null ? null : isOtherPlace.trim();
    }

    /**
     * 贷款种类
     * @return BIZ_TYPE_SUB 贷款种类
     */
    public String getBizTypeSub() {
        return bizTypeSub;
    }

    /**
     * 贷款种类
     * @param bizTypeSub 贷款种类
     */
    public void setBizTypeSub(String bizTypeSub) {
        this.bizTypeSub = bizTypeSub == null ? null : bizTypeSub.trim();
    }

    /**
     * 需要审议的其它内容
     * @return OTHER_REMARK 需要审议的其它内容
     */
    public String getOtherRemark() {
        return otherRemark;
    }

    /**
     * 需要审议的其它内容
     * @param otherRemark 需要审议的其它内容
     */
    public void setOtherRemark(String otherRemark) {
        this.otherRemark = otherRemark == null ? null : otherRemark.trim();
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
     * 贷款投向说明
     * @return DIRECTION_NAME 贷款投向说明
     */
    public String getDirectionName() {
        return directionName;
    }

    /**
     * 贷款投向说明
     * @param directionName 贷款投向说明
     */
    public void setDirectionName(String directionName) {
        this.directionName = directionName == null ? null : directionName.trim();
    }

    /**
     * 分析日期
     * @return ANALYSIS_DATE 分析日期
     */
    public String getAnalysisDate() {
        return analysisDate;
    }

    /**
     * 分析日期
     * @param analysisDate 分析日期
     */
    public void setAnalysisDate(String analysisDate) {
        this.analysisDate = analysisDate == null ? null : analysisDate.trim();
    }

    /**
     * 受理人编号
     * @return ACCEPT_ID 受理人编号
     */
    public String getAcceptId() {
        return acceptId;
    }

    /**
     * 受理人编号
     * @param acceptId 受理人编号
     */
    public void setAcceptId(String acceptId) {
        this.acceptId = acceptId == null ? null : acceptId.trim();
    }

    /**
     * 受理人姓名
     * @return ACCEPT_NAME 受理人姓名
     */
    public String getAcceptName() {
        return acceptName;
    }

    /**
     * 受理人姓名
     * @param acceptName 受理人姓名
     */
    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName == null ? null : acceptName.trim();
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
     * 录入人姓名
     * @return INPUT_NAME 录入人姓名
     */
    public String getInputName() {
        return inputName;
    }

    /**
     * 录入人姓名
     * @param inputName 录入人姓名
     */
    public void setInputName(String inputName) {
        this.inputName = inputName == null ? null : inputName.trim();
    }

    /**
     * 业务受理机构
     * @return MAIN_BR_ID 业务受理机构
     */
    public String getMainBrId() {
        return mainBrId;
    }

    /**
     * 业务受理机构
     * @param mainBrId 业务受理机构
     */
    public void setMainBrId(String mainBrId) {
        this.mainBrId = mainBrId == null ? null : mainBrId.trim();
    }

    /**
     * 主办人编号
     * @return MAIN_USER_ID 主办人编号
     */
    public String getMainUserId() {
        return mainUserId;
    }

    /**
     * 主办人编号
     * @param mainUserId 主办人编号
     */
    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId == null ? null : mainUserId.trim();
    }

    /**
     * 主办人姓名
     * @return MAIN_USER_NAME 主办人姓名
     */
    public String getMainUserName() {
        return mainUserName;
    }

    /**
     * 主办人姓名
     * @param mainUserName 主办人姓名
     */
    public void setMainUserName(String mainUserName) {
        this.mainUserName = mainUserName == null ? null : mainUserName.trim();
    }

    /**
     * 主办人分析权限
     * @return COMPETENCE 主办人分析权限
     */
    public BigDecimal getCompetence() {
        return competence;
    }

    /**
     * 主办人分析权限
     * @param competence 主办人分析权限
     */
    public void setCompetence(BigDecimal competence) {
        this.competence = competence;
    }

    /**
     * 审批状态
     * @return APPROVE_STATUS 审批状态
     */
    public String getApproveStatus() {
        return approveStatus;
    }

    /**
     * 审批状态
     * @param approveStatus 审批状态
     */
    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus == null ? null : approveStatus.trim();
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
     * 贷款产品
     * @return BIZ_TYPE 贷款产品
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 贷款产品
     * @param bizType 贷款产品
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
     * 建议金额（元）
     * @return APPLY_AMOUNT 建议金额（元）
     */
    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    /**
     * 建议金额（元）
     * @param applyAmount 建议金额（元）
     */
    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    /**
     * 申请期限(月)
     * @return TERM 申请期限(月)
     */
    public BigDecimal getTerm() {
        return term;
    }

    /**
     * 申请期限(月)
     * @param term 申请期限(月)
     */
    public void setTerm(BigDecimal term) {
        this.term = term;
    }

    /**
     * 申请期限（月）
     * @return APPLY_TERM 申请期限（月）
     */
    public Long getApplyTerm() {
        return applyTerm;
    }

    /**
     * 申请期限（月）
     * @param applyTerm 申请期限（月）
     */
    public void setApplyTerm(Long applyTerm) {
        this.applyTerm = applyTerm;
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
     * 浮动类型
     * @return FLOATING_TYPE 浮动类型
     */
    public String getFloatingType() {
        return floatingType;
    }

    /**
     * 浮动类型
     * @param floatingType 浮动类型
     */
    public void setFloatingType(String floatingType) {
        this.floatingType = floatingType == null ? null : floatingType.trim();
    }

    /**
     * 浮动利率
     * @return FLOATING_RATE 浮动利率
     */
    public BigDecimal getFloatingRate() {
        return floatingRate;
    }

    /**
     * 浮动利率
     * @param floatingRate 浮动利率
     */
    public void setFloatingRate(BigDecimal floatingRate) {
        this.floatingRate = floatingRate;
    }

    /**
     * 建议利率
     * @return REALITY_IR_Y 建议利率
     */
    public BigDecimal getRealityIrY() {
        return realityIrY;
    }

    /**
     * 建议利率
     * @param realityIrY 建议利率
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
     * 逾期罚息利率（年）
     * @return OVERDUE_IR 逾期罚息利率（年）
     */
    public BigDecimal getOverdueIr() {
        return overdueIr;
    }

    /**
     * 逾期罚息利率（年）
     * @param overdueIr 逾期罚息利率（年）
     */
    public void setOverdueIr(BigDecimal overdueIr) {
        this.overdueIr = overdueIr;
    }

    /**
     * 违约罚息利率
     * @return DEFAULT_RATE 违约罚息利率
     */
    public BigDecimal getDefaultRate() {
        return defaultRate;
    }

    /**
     * 违约罚息利率
     * @param defaultRate 违约罚息利率
     */
    public void setDefaultRate(BigDecimal defaultRate) {
        this.defaultRate = defaultRate;
    }

    /**
     * 违约利率
     * @return DEFAULT_IR 违约利率
     */
    public BigDecimal getDefaultIr() {
        return defaultIr;
    }

    /**
     * 违约利率
     * @param defaultIr 违约利率
     */
    public void setDefaultIr(BigDecimal defaultIr) {
        this.defaultIr = defaultIr;
    }

    /**
     * 罚息利率
     * @return CI_RATE 罚息利率
     */
    public BigDecimal getCiRate() {
        return ciRate;
    }

    /**
     * 罚息利率
     * @param ciRate 罚息利率
     */
    public void setCiRate(BigDecimal ciRate) {
        this.ciRate = ciRate;
    }

    /**
     * 复息利率
     * @return CI_IR 复息利率
     */
    public BigDecimal getCiIr() {
        return ciIr;
    }

    /**
     * 复息利率
     * @param ciIr 复息利率
     */
    public void setCiIr(BigDecimal ciIr) {
        this.ciIr = ciIr;
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
    public String getPayDistance() {
        return payDistance;
    }

    /**
     * 还款间隔
     * @param payDistance 还款间隔
     */
    public void setPayDistance(String payDistance) {
        this.payDistance = payDistance == null ? null : payDistance.trim();
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
     * 申请流
     * @return APP_WORKFLOW_ID 申请流
     */
    public String getAppWorkflowId() {
        return appWorkflowId;
    }

    /**
     * 申请流
     * @param appWorkflowId 申请流
     */
    public void setAppWorkflowId(String appWorkflowId) {
        this.appWorkflowId = appWorkflowId == null ? null : appWorkflowId.trim();
    }

    /**
     * 申请表单
     * @return APP_FORM 申请表单
     */
    public String getAppForm() {
        return appForm;
    }

    /**
     * 申请表单
     * @param appForm 申请表单
     */
    public void setAppForm(String appForm) {
        this.appForm = appForm == null ? null : appForm.trim();
    }

    /**
     * 还款日
     * @return DUE_DAY 还款日
     */
    public Short getDueDay() {
        return dueDay;
    }

    /**
     * 还款日
     * @param dueDay 还款日
     */
    public void setDueDay(Short dueDay) {
        this.dueDay = dueDay;
    }

    /**
     * 申请币种
     * @return APPLY_CUR_TYPE 申请币种
     */
    public String getApplyCurType() {
        return applyCurType;
    }

    /**
     * 申请币种
     * @param applyCurType 申请币种
     */
    public void setApplyCurType(String applyCurType) {
        this.applyCurType = applyCurType == null ? null : applyCurType.trim();
    }

    /**
     * 宽限期天数
     * @return DAYS_OF_GRACE 宽限期天数
     */
    public BigDecimal getDaysOfGrace() {
        return daysOfGrace;
    }

    /**
     * 宽限期天数
     * @param daysOfGrace 宽限期天数
     */
    public void setDaysOfGrace(BigDecimal daysOfGrace) {
        this.daysOfGrace = daysOfGrace;
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
     * 业务归属机构
     * @return INPUT_BR_ID 业务归属机构
     */
    public String getInputBrId() {
        return inputBrId;
    }

    /**
     * 业务归属机构
     * @param inputBrId 业务归属机构
     */
    public void setInputBrId(String inputBrId) {
        this.inputBrId = inputBrId == null ? null : inputBrId.trim();
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
     * 申请意见
     * @return APPLY_ADVISE 申请意见
     */
    public String getApplyAdvise() {
        return applyAdvise;
    }

    /**
     * 申请意见
     * @param applyAdvise 申请意见
     */
    public void setApplyAdvise(String applyAdvise) {
        this.applyAdvise = applyAdvise == null ? null : applyAdvise.trim();
    }

    /**
     * 是否合作方
     * @return IS_FLAG 是否合作方
     */
    public String getIsFlag() {
        return isFlag;
    }

    /**
     * 是否合作方
     * @param isFlag 是否合作方
     */
    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag == null ? null : isFlag.trim();
    }

    /**
     * 合同名称
     * @return CONT_NAME 合同名称
     */
    public String getContName() {
        return contName;
    }

    /**
     * 合同名称
     * @param contName 合同名称
     */
    public void setContName(String contName) {
        this.contName = contName == null ? null : contName.trim();
    }

    /**
     * 首次还款日
     * @return DUE_FIRST_DAY 首次还款日
     */
    public String getDueFirstDay() {
        return dueFirstDay;
    }

    /**
     * 首次还款日
     * @param dueFirstDay 首次还款日
     */
    public void setDueFirstDay(String dueFirstDay) {
        this.dueFirstDay = dueFirstDay == null ? null : dueFirstDay.trim();
    }

    /**
     * 合同是否公正
     * @return CONT_PUBLIC 合同是否公正
     */
    public String getContPublic() {
        return contPublic;
    }

    /**
     * 合同是否公正
     * @param contPublic 合同是否公正
     */
    public void setContPublic(String contPublic) {
        this.contPublic = contPublic == null ? null : contPublic.trim();
    }

    /**
     * 是否办理抵押登记
     * @return IS_RECORD 是否办理抵押登记
     */
    public String getIsRecord() {
        return isRecord;
    }

    /**
     * 是否办理抵押登记
     * @param isRecord 是否办理抵押登记
     */
    public void setIsRecord(String isRecord) {
        this.isRecord = isRecord == null ? null : isRecord.trim();
    }

    /**
     * REFUSE_TIME 暂时没使用
     * @return REFUSE_TIME REFUSE_TIME 暂时没使用
     */
    public String getRefuseTime() {
        return refuseTime;
    }

    /**
     * REFUSE_TIME 暂时没使用
     * @param refuseTime REFUSE_TIME 暂时没使用
     */
    public void setRefuseTime(String refuseTime) {
        this.refuseTime = refuseTime == null ? null : refuseTime.trim();
    }

    /**
     * REFUSE_CODE 暂时没使用
     * @return REFUSE_CODE REFUSE_CODE 暂时没使用
     */
    public String getRefuseCode() {
        return refuseCode;
    }

    /**
     * REFUSE_CODE 暂时没使用
     * @param refuseCode REFUSE_CODE 暂时没使用
     */
    public void setRefuseCode(String refuseCode) {
        this.refuseCode = refuseCode == null ? null : refuseCode.trim();
    }

    /**
     * 可能的担保人姓名
     * @return GUARANTOR 可能的担保人姓名
     */
    public String getGuarantor() {
        return guarantor;
    }

    /**
     * 可能的担保人姓名
     * @param guarantor 可能的担保人姓名
     */
    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor == null ? null : guarantor.trim();
    }

    /**
     * 职业
     * @return GUARANTOR_OCC 职业
     */
    public String getGuarantorOcc() {
        return guarantorOcc;
    }

    /**
     * 职业
     * @param guarantorOcc 职业
     */
    public void setGuarantorOcc(String guarantorOcc) {
        this.guarantorOcc = guarantorOcc == null ? null : guarantorOcc.trim();
    }

    /**
     * 年收入
     * @return GUARANTOR_INCM 年收入
     */
    public BigDecimal getGuarantorIncm() {
        return guarantorIncm;
    }

    /**
     * 年收入
     * @param guarantorIncm 年收入
     */
    public void setGuarantorIncm(BigDecimal guarantorIncm) {
        this.guarantorIncm = guarantorIncm;
    }

    /**
     * 担保人身份证号
     * @return GUARANTOR_CODE 担保人身份证号
     */
    public String getGuarantorCode() {
        return guarantorCode;
    }

    /**
     * 担保人身份证号
     * @param guarantorCode 担保人身份证号
     */
    public void setGuarantorCode(String guarantorCode) {
        this.guarantorCode = guarantorCode == null ? null : guarantorCode.trim();
    }

    /**
     * 担保人电话
     * @return GUARANTOR_PHONE 担保人电话
     */
    public String getGuarantorPhone() {
        return guarantorPhone;
    }

    /**
     * 担保人电话
     * @param guarantorPhone 担保人电话
     */
    public void setGuarantorPhone(String guarantorPhone) {
        this.guarantorPhone = guarantorPhone == null ? null : guarantorPhone.trim();
    }

    /**
     * 与申请人的关系
     * @return GUARANTOR_RELATE 与申请人的关系
     */
    public String getGuarantorRelate() {
        return guarantorRelate;
    }

    /**
     * 与申请人的关系
     * @param guarantorRelate 与申请人的关系
     */
    public void setGuarantorRelate(String guarantorRelate) {
        this.guarantorRelate = guarantorRelate == null ? null : guarantorRelate.trim();
    }

    /**
     * 法人保证人
     * @return CORP_GUAR_NAME 法人保证人
     */
    public String getCorpGuarName() {
        return corpGuarName;
    }

    /**
     * 法人保证人
     * @param corpGuarName 法人保证人
     */
    public void setCorpGuarName(String corpGuarName) {
        this.corpGuarName = corpGuarName == null ? null : corpGuarName.trim();
    }

    /**
     * 保证人与申请人关系
     * @return CORP_RELATE 保证人与申请人关系
     */
    public String getCorpRelate() {
        return corpRelate;
    }

    /**
     * 保证人与申请人关系
     * @param corpRelate 保证人与申请人关系
     */
    public void setCorpRelate(String corpRelate) {
        this.corpRelate = corpRelate == null ? null : corpRelate.trim();
    }

    /**
     * 法人保证人基本信息描述
     * @return CORP_DESC 法人保证人基本信息描述
     */
    public String getCorpDesc() {
        return corpDesc;
    }

    /**
     * 法人保证人基本信息描述
     * @param corpDesc 法人保证人基本信息描述
     */
    public void setCorpDesc(String corpDesc) {
        this.corpDesc = corpDesc == null ? null : corpDesc.trim();
    }

    /**
     * 可能的抵质押物
     * @return MAY_GRT 可能的抵质押物
     */
    public String getMayGrt() {
        return mayGrt;
    }

    /**
     * 可能的抵质押物
     * @param mayGrt 可能的抵质押物
     */
    public void setMayGrt(String mayGrt) {
        this.mayGrt = mayGrt == null ? null : mayGrt.trim();
    }

    /**
     * 抵质押物预估价值
     * @return GRT_VALUE 抵质押物预估价值
     */
    public BigDecimal getGrtValue() {
        return grtValue;
    }

    /**
     * 抵质押物预估价值
     * @param grtValue 抵质押物预估价值
     */
    public void setGrtValue(BigDecimal grtValue) {
        this.grtValue = grtValue;
    }

    /**
     * 是否足值
     * @return IS_WORTH 是否足值
     */
    public String getIsWorth() {
        return isWorth;
    }

    /**
     * 是否足值
     * @param isWorth 是否足值
     */
    public void setIsWorth(String isWorth) {
        this.isWorth = isWorth == null ? null : isWorth.trim();
    }

    /**
     * 推广时间
     * @return SPREAD_TIME 推广时间
     */
    public String getSpreadTime() {
        return spreadTime;
    }

    /**
     * 推广时间
     * @param spreadTime 推广时间
     */
    public void setSpreadTime(String spreadTime) {
        this.spreadTime = spreadTime == null ? null : spreadTime.trim();
    }

    /**
     * 推广地点
     * @return SPREAD_PLACE 推广地点
     */
    public String getSpreadPlace() {
        return spreadPlace;
    }

    /**
     * 推广地点
     * @param spreadPlace 推广地点
     */
    public void setSpreadPlace(String spreadPlace) {
        this.spreadPlace = spreadPlace == null ? null : spreadPlace.trim();
    }

    /**
     * 推广人
     * @return SPREAD_NAME 推广人
     */
    public String getSpreadName() {
        return spreadName;
    }

    /**
     * 推广人
     * @param spreadName 推广人
     */
    public void setSpreadName(String spreadName) {
        this.spreadName = spreadName == null ? null : spreadName.trim();
    }

    /**
     * 风险分析
     * @return RISK_ANALYSE 风险分析
     */
    public String getRiskAnalyse() {
        return riskAnalyse;
    }

    /**
     * 风险分析
     * @param riskAnalyse 风险分析
     */
    public void setRiskAnalyse(String riskAnalyse) {
        this.riskAnalyse = riskAnalyse == null ? null : riskAnalyse.trim();
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
     * 性别
     * @return CUS_SEX 性别
     */
    public String getCusSex() {
        return cusSex;
    }

    /**
     * 性别
     * @param cusSex 性别
     */
    public void setCusSex(String cusSex) {
        this.cusSex = cusSex == null ? null : cusSex.trim();
    }

    /**
     * 贷款用途
     * @return LOAN_USE 贷款用途
     */
    public String getLoanUse() {
        return loanUse;
    }

    /**
     * 贷款用途
     * @param loanUse 贷款用途
     */
    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse == null ? null : loanUse.trim();
    }

    /**
     * READ_FLAG 暂时没使用
     * @return READ_FLAG READ_FLAG 暂时没使用
     */
    public String getReadFlag() {
        return readFlag;
    }

    /**
     * READ_FLAG 暂时没使用
     * @param readFlag READ_FLAG 暂时没使用
     */
    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag == null ? null : readFlag.trim();
    }

    /**
     * 申请贷款用途描述
     * @return LOAN_USE_DESC 申请贷款用途描述
     */
    public String getLoanUseDesc() {
        return loanUseDesc;
    }

    /**
     * 申请贷款用途描述
     * @param loanUseDesc 申请贷款用途描述
     */
    public void setLoanUseDesc(String loanUseDesc) {
        this.loanUseDesc = loanUseDesc == null ? null : loanUseDesc.trim();
    }

    /**
     * ASSI_ID 暂时没使用
     * @return ASSI_ID ASSI_ID 暂时没使用
     */
    public String getAssiId() {
        return assiId;
    }

    /**
     * ASSI_ID 暂时没使用
     * @param assiId ASSI_ID 暂时没使用
     */
    public void setAssiId(String assiId) {
        this.assiId = assiId == null ? null : assiId.trim();
    }

    /**
     * ASSI_NAME 暂时没使用
     * @return ASSI_NAME ASSI_NAME 暂时没使用
     */
    public String getAssiName() {
        return assiName;
    }

    /**
     * ASSI_NAME 暂时没使用
     * @param assiName ASSI_NAME 暂时没使用
     */
    public void setAssiName(String assiName) {
        this.assiName = assiName == null ? null : assiName.trim();
    }

    /**
     * 申请金额（元）
     * @return AMOUNT 申请金额（元）
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 申请金额（元）
     * @param amount 申请金额（元）
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 执行利率(年)
     * @return USING_IR 执行利率(年)
     */
    public BigDecimal getUsingIr() {
        return usingIr;
    }

    /**
     * 执行利率(年)
     * @param usingIr 执行利率(年)
     */
    public void setUsingIr(BigDecimal usingIr) {
        this.usingIr = usingIr;
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
     * 申请机构名称
     * @return INPUT_BR_NAME 申请机构名称
     */
    public String getInputBrName() {
        return inputBrName;
    }

    /**
     * 申请机构名称
     * @param inputBrName 申请机构名称
     */
    public void setInputBrName(String inputBrName) {
        this.inputBrName = inputBrName == null ? null : inputBrName.trim();
    }

    /**
     * 机构级别
     * @return INPUT_LEVEL 机构级别
     */
    public String getInputLevel() {
        return inputLevel;
    }

    /**
     * 机构级别
     * @param inputLevel 机构级别
     */
    public void setInputLevel(String inputLevel) {
        this.inputLevel = inputLevel == null ? null : inputLevel.trim();
    }

    /**
     * MAIN_LEVEL 暂时没使用
     * @return MAIN_LEVEL MAIN_LEVEL 暂时没使用
     */
    public String getMainLevel() {
        return mainLevel;
    }

    /**
     * MAIN_LEVEL 暂时没使用
     * @param mainLevel MAIN_LEVEL 暂时没使用
     */
    public void setMainLevel(String mainLevel) {
        this.mainLevel = mainLevel == null ? null : mainLevel.trim();
    }

    /**
     * PROP 暂时没使用
     * @return PROP PROP 暂时没使用
     */
    public String getProp() {
        return prop;
    }

    /**
     * PROP 暂时没使用
     * @param prop PROP 暂时没使用
     */
    public void setProp(String prop) {
        this.prop = prop == null ? null : prop.trim();
    }

    /**
     * 是否多次放款
     * @return IS_MORE_LOAN 是否多次放款
     */
    public String getIsMoreLoan() {
        return isMoreLoan;
    }

    /**
     * 是否多次放款
     * @param isMoreLoan 是否多次放款
     */
    public void setIsMoreLoan(String isMoreLoan) {
        this.isMoreLoan = isMoreLoan == null ? null : isMoreLoan.trim();
    }

    /**
     * 录入日期
     * @return INPUT_DATE 录入日期
     */
    public String getInputDate() {
        return inputDate;
    }

    /**
     * 录入日期
     * @param inputDate 录入日期
     */
    public void setInputDate(String inputDate) {
        this.inputDate = inputDate == null ? null : inputDate.trim();
    }

    /**
     * 审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     * @return APP_STATUS 审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     */
    public String getAppStatus() {
        return appStatus;
    }

    /**
     * 审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     * @param appStatus 审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     */
    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus == null ? null : appStatus.trim();
    }

    /**
     * 合作方类型
     * @return PARTNER_TYPE 合作方类型
     */
    public String getPartnerType() {
        return partnerType;
    }

    /**
     * 合作方类型
     * @param partnerType 合作方类型
     */
    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType == null ? null : partnerType.trim();
    }

    /**
     * 合作方证件号
     * @return PARTNER_CERT_CODE 合作方证件号
     */
    public String getPartnerCertCode() {
        return partnerCertCode;
    }

    /**
     * 合作方证件号
     * @param partnerCertCode 合作方证件号
     */
    public void setPartnerCertCode(String partnerCertCode) {
        this.partnerCertCode = partnerCertCode == null ? null : partnerCertCode.trim();
    }

    /**
     * 合作方证件类型
     * @return PARTNER_CERT_TYPE 合作方证件类型
     */
    public String getPartnerCertType() {
        return partnerCertType;
    }

    /**
     * 合作方证件类型
     * @param partnerCertType 合作方证件类型
     */
    public void setPartnerCertType(String partnerCertType) {
        this.partnerCertType = partnerCertType == null ? null : partnerCertType.trim();
    }

    /**
     * 业务操作时间
     * @return UPDATE_DATE 业务操作时间
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 业务操作时间
     * @param updateDate 业务操作时间
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }

    /**
     * 是否涉农:STD_ZX_YES_NO 1-是 2-否
     * @return IS_AGRICULTURE 是否涉农:STD_ZX_YES_NO 1-是 2-否
     */
    public String getIsAgriculture() {
        return isAgriculture;
    }

    /**
     * 是否涉农:STD_ZX_YES_NO 1-是 2-否
     * @param isAgriculture 是否涉农:STD_ZX_YES_NO 1-是 2-否
     */
    public void setIsAgriculture(String isAgriculture) {
        this.isAgriculture = isAgriculture == null ? null : isAgriculture.trim();
    }

    /**
     * 录入渠道[3:移动银行]
     * @return INPUT_CHANNEL 录入渠道[3:移动银行]
     */
    public String getInputChannel() {
        return inputChannel;
    }

    /**
     * 录入渠道[3:移动银行]
     * @param inputChannel 录入渠道[3:移动银行]
     */
    public void setInputChannel(String inputChannel) {
        this.inputChannel = inputChannel == null ? null : inputChannel.trim();
    }

    /**
     * 是否存量客户
     * @return IS_ADD_CUS 是否存量客户
     */
    public String getIsAddCus() {
        return isAddCus;
    }

    /**
     * 是否存量客户
     * @param isAddCus 是否存量客户
     */
    public void setIsAddCus(String isAddCus) {
        this.isAddCus = isAddCus == null ? null : isAddCus.trim();
    }

    /**
     * 审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     * @return NEW_APPROVE_STATUS 审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     */
    public String getNewApproveStatus() {
        return newApproveStatus;
    }

    /**
     * 审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     * @param newApproveStatus 审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     */
    public void setNewApproveStatus(String newApproveStatus) {
        this.newApproveStatus = newApproveStatus == null ? null : newApproveStatus.trim();
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
     * 是否准备完成:STD_ZX_YES_NO 1-是 2-否
     * @return IS_ALREADY 是否准备完成:STD_ZX_YES_NO 1-是 2-否
     */
    public String getIsAlready() {
        return isAlready;
    }

    /**
     * 是否准备完成:STD_ZX_YES_NO 1-是 2-否
     * @param isAlready 是否准备完成:STD_ZX_YES_NO 1-是 2-否
     */
    public void setIsAlready(String isAlready) {
        this.isAlready = isAlready == null ? null : isAlready.trim();
    }

    /**
     * 是否预约成功:STD_ZX_YES_NO 1-是 2-否
     * @return IS_ORDER 是否预约成功:STD_ZX_YES_NO 1-是 2-否
     */
    public String getIsOrder() {
        return isOrder;
    }

    /**
     * 是否预约成功:STD_ZX_YES_NO 1-是 2-否
     * @param isOrder 是否预约成功:STD_ZX_YES_NO 1-是 2-否
     */
    public void setIsOrder(String isOrder) {
        this.isOrder = isOrder == null ? null : isOrder.trim();
    }

    /**
     * 总项目成本
     * @return PRJ_COST 总项目成本
     */
    public BigDecimal getPrjCost() {
        return prjCost;
    }

    /**
     * 总项目成本
     * @param prjCost 总项目成本
     */
    public void setPrjCost(BigDecimal prjCost) {
        this.prjCost = prjCost;
    }

    /**
     * 项目步骤
     * @return PRJ_STEP 项目步骤
     */
    public String getPrjStep() {
        return prjStep;
    }

    /**
     * 项目步骤
     * @param prjStep 项目步骤
     */
    public void setPrjStep(String prjStep) {
        this.prjStep = prjStep == null ? null : prjStep.trim();
    }

    /**
     * 贷款使用明细
     * @return USE_DETAIL 贷款使用明细
     */
    public String getUseDetail() {
        return useDetail;
    }

    /**
     * 贷款使用明细
     * @param useDetail 贷款使用明细
     */
    public void setUseDetail(String useDetail) {
        this.useDetail = useDetail == null ? null : useDetail.trim();
    }

    /**
     * 贷款原因
     * @return LOAN_REASON 贷款原因
     */
    public String getLoanReason() {
        return loanReason;
    }

    /**
     * 贷款原因
     * @param loanReason 贷款原因
     */
    public void setLoanReason(String loanReason) {
        this.loanReason = loanReason == null ? null : loanReason.trim();
    }

    /**
     * 建议的贷款金额（元）
     * @return ADVISE_AMT 建议的贷款金额（元）
     */
    public BigDecimal getAdviseAmt() {
        return adviseAmt;
    }

    /**
     * 建议的贷款金额（元）
     * @param adviseAmt 建议的贷款金额（元）
     */
    public void setAdviseAmt(BigDecimal adviseAmt) {
        this.adviseAmt = adviseAmt;
    }

    /**
     * 建议的期限（月）
     * @return ADVISE_DEADLINE 建议的期限（月）
     */
    public String getAdviseDeadline() {
        return adviseDeadline;
    }

    /**
     * 建议的期限（月）
     * @param adviseDeadline 建议的期限（月）
     */
    public void setAdviseDeadline(String adviseDeadline) {
        this.adviseDeadline = adviseDeadline == null ? null : adviseDeadline.trim();
    }

    /**
     * 建议的还款方式:STD_ZB_REPAY_MODE 2-等额本金还款,3-按月等额本息,6-按月付息到期还本,7-到期一次还款
     * @return ADVISE_REPAYMENT_WAY 建议的还款方式:STD_ZB_REPAY_MODE 2-等额本金还款,3-按月等额本息,6-按月付息到期还本,7-到期一次还款
     */
    public String getAdviseRepaymentWay() {
        return adviseRepaymentWay;
    }

    /**
     * 建议的还款方式:STD_ZB_REPAY_MODE 2-等额本金还款,3-按月等额本息,6-按月付息到期还本,7-到期一次还款
     * @param adviseRepaymentWay 建议的还款方式:STD_ZB_REPAY_MODE 2-等额本金还款,3-按月等额本息,6-按月付息到期还本,7-到期一次还款
     */
    public void setAdviseRepaymentWay(String adviseRepaymentWay) {
        this.adviseRepaymentWay = adviseRepaymentWay == null ? null : adviseRepaymentWay.trim();
    }

    /**
     * 建议保证人
     * @return ADVISE_GUAR_PERSON 建议保证人
     */
    public String getAdviseGuarPerson() {
        return adviseGuarPerson;
    }

    /**
     * 建议保证人
     * @param adviseGuarPerson 建议保证人
     */
    public void setAdviseGuarPerson(String adviseGuarPerson) {
        this.adviseGuarPerson = adviseGuarPerson == null ? null : adviseGuarPerson.trim();
    }

    /**
     * 特殊情况/其他条件（抵押等）
     * @return SPECIAL_CASE 特殊情况/其他条件（抵押等）
     */
    public String getSpecialCase() {
        return specialCase;
    }

    /**
     * 特殊情况/其他条件（抵押等）
     * @param specialCase 特殊情况/其他条件（抵押等）
     */
    public void setSpecialCase(String specialCase) {
        this.specialCase = specialCase == null ? null : specialCase.trim();
    }

    /**
     * 客户经理
     * @return CUS_MGR 客户经理
     */
    public String getCusMgr() {
        return cusMgr;
    }

    /**
     * 客户经理
     * @param cusMgr 客户经理
     */
    public void setCusMgr(String cusMgr) {
        this.cusMgr = cusMgr == null ? null : cusMgr.trim();
    }

    /**
     * 建议日期
     * @return ADVISE_DATE 建议日期
     */
    public String getAdviseDate() {
        return adviseDate;
    }

    /**
     * 建议日期
     * @param adviseDate 建议日期
     */
    public void setAdviseDate(String adviseDate) {
        this.adviseDate = adviseDate == null ? null : adviseDate.trim();
    }

    /**
     * 核保打印流水号
     * @return GUARANTEE_SERNO 核保打印流水号
     */
    public String getGuaranteeSerno() {
        return guaranteeSerno;
    }

    /**
     * 核保打印流水号
     * @param guaranteeSerno 核保打印流水号
     */
    public void setGuaranteeSerno(String guaranteeSerno) {
        this.guaranteeSerno = guaranteeSerno == null ? null : guaranteeSerno.trim();
    }

    /**
     * 团队编号
     * @return TEAMNO 团队编号
     */
    public String getTeamno() {
        return teamno;
    }

    /**
     * 团队编号
     * @param teamno 团队编号
     */
    public void setTeamno(String teamno) {
        this.teamno = teamno == null ? null : teamno.trim();
    }

    /**
     * 团队长编号
     * @return TEAM_LEADER 团队长编号
     */
    public String getTeamLeader() {
        return teamLeader;
    }

    /**
     * 团队长编号
     * @param teamLeader 团队长编号
     */
    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader == null ? null : teamLeader.trim();
    }

    /**
     * 小组编号
     * @return GROUPNO 小组编号
     */
    public String getGroupno() {
        return groupno;
    }

    /**
     * 小组编号
     * @param groupno 小组编号
     */
    public void setGroupno(String groupno) {
        this.groupno = groupno == null ? null : groupno.trim();
    }

    /**
     * 小组长编号
     * @return GROUP_LEADER 小组长编号
     */
    public String getGroupLeader() {
        return groupLeader;
    }

    /**
     * 小组长编号
     * @param groupLeader 小组长编号
     */
    public void setGroupLeader(String groupLeader) {
        this.groupLeader = groupLeader == null ? null : groupLeader.trim();
    }

    /**
     * 是否已注销:STD_ZX_YES_NO 1-是 2-否
     * @return IS_CANCEL 是否已注销:STD_ZX_YES_NO 1-是 2-否
     */
    public String getIsCancel() {
        return isCancel;
    }

    /**
     * 是否已注销:STD_ZX_YES_NO 1-是 2-否
     * @param isCancel 是否已注销:STD_ZX_YES_NO 1-是 2-否
     */
    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel == null ? null : isCancel.trim();
    }

    /**
     * 业务人员编号
     * @return BUSINESS_PERSION_ID 业务人员编号
     */
    public String getBusinessPersionId() {
        return businessPersionId;
    }

    /**
     * 业务人员编号
     * @param businessPersionId 业务人员编号
     */
    public void setBusinessPersionId(String businessPersionId) {
        this.businessPersionId = businessPersionId == null ? null : businessPersionId.trim();
    }

    /**
     * 业务人员名称
     * @return BUSINESS_PERSION_NAME 业务人员名称
     */
    public String getBusinessPersionName() {
        return businessPersionName;
    }

    /**
     * 业务人员名称
     * @param businessPersionName 业务人员名称
     */
    public void setBusinessPersionName(String businessPersionName) {
        this.businessPersionName = businessPersionName == null ? null : businessPersionName.trim();
    }

    /**
     * 业务人员电话
     * @return BUSINESS_PERSION_PHONE 业务人员电话
     */
    public String getBusinessPersionPhone() {
        return businessPersionPhone;
    }

    /**
     * 业务人员电话
     * @param businessPersionPhone 业务人员电话
     */
    public void setBusinessPersionPhone(String businessPersionPhone) {
        this.businessPersionPhone = businessPersionPhone == null ? null : businessPersionPhone.trim();
    }

    /**
     * 银行客户经理
     * @return BANK_CUS_MGR 银行客户经理
     */
    public String getBankCusMgr() {
        return bankCusMgr;
    }

    /**
     * 银行客户经理
     * @param bankCusMgr 银行客户经理
     */
    public void setBankCusMgr(String bankCusMgr) {
        this.bankCusMgr = bankCusMgr == null ? null : bankCusMgr.trim();
    }

    /**
     * 银行客户经理手机号
     * @return BANK_MGR_PHONE 银行客户经理手机号
     */
    public String getBankMgrPhone() {
        return bankMgrPhone;
    }

    /**
     * 银行客户经理手机号
     * @param bankMgrPhone 银行客户经理手机号
     */
    public void setBankMgrPhone(String bankMgrPhone) {
        this.bankMgrPhone = bankMgrPhone == null ? null : bankMgrPhone.trim();
    }

    /**
     * 操作标识:STD_IQP_OPT_TYPE 1-新增,2-补录
     * @return OPT_TYPE 操作标识:STD_IQP_OPT_TYPE 1-新增,2-补录
     */
    public String getOptType() {
        return optType;
    }

    /**
     * 操作标识:STD_IQP_OPT_TYPE 1-新增,2-补录
     * @param optType 操作标识:STD_IQP_OPT_TYPE 1-新增,2-补录
     */
    public void setOptType(String optType) {
        this.optType = optType == null ? null : optType.trim();
    }

    /**
     * 是否批量业务
     * @return IS_BATC_BIZ 是否批量业务
     */
    public String getIsBatcBiz() {
        return isBatcBiz;
    }

    /**
     * 是否批量业务
     * @param isBatcBiz 是否批量业务
     */
    public void setIsBatcBiz(String isBatcBiz) {
        this.isBatcBiz = isBatcBiz == null ? null : isBatcBiz.trim();
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
     * 建议的还款方式说明
     * @return ADVISE_REPAYMENT_WAY_DESC 建议的还款方式说明
     */
    public String getAdviseRepaymentWayDesc() {
        return adviseRepaymentWayDesc;
    }

    /**
     * 建议的还款方式说明
     * @param adviseRepaymentWayDesc 建议的还款方式说明
     */
    public void setAdviseRepaymentWayDesc(String adviseRepaymentWayDesc) {
        this.adviseRepaymentWayDesc = adviseRepaymentWayDesc == null ? null : adviseRepaymentWayDesc.trim();
    }

    /**
     * 业务模式
     * @return BIZ_MODE 业务模式
     */
    public String getBizMode() {
        return bizMode;
    }

    /**
     * 业务模式
     * @param bizMode 业务模式
     */
    public void setBizMode(String bizMode) {
        this.bizMode = bizMode == null ? null : bizMode.trim();
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
     * 还款来源
     * @return REPAYMENT_SRC 还款来源
     */
    public String getRepaymentSrc() {
        return repaymentSrc;
    }

    /**
     * 还款来源
     * @param repaymentSrc 还款来源
     */
    public void setRepaymentSrc(String repaymentSrc) {
        this.repaymentSrc = repaymentSrc == null ? null : repaymentSrc.trim();
    }

    /**
     * 抵押物类型
     * @return GUARANTY_TYPE 抵押物类型
     */
    public String getGuarantyType() {
        return guarantyType;
    }

    /**
     * 抵押物类型
     * @param guarantyType 抵押物类型
     */
    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType == null ? null : guarantyType.trim();
    }

    /**
     * 抵押物名称
     * @return GUARANTY_NAME 抵押物名称
     */
    public String getGuarantyName() {
        return guarantyName;
    }

    /**
     * 抵押物名称
     * @param guarantyName 抵押物名称
     */
    public void setGuarantyName(String guarantyName) {
        this.guarantyName = guarantyName == null ? null : guarantyName.trim();
    }

    /**
     * 房产证号
     * @return HOUSE_CERT_NO 房产证号
     */
    public String getHouseCertNo() {
        return houseCertNo;
    }

    /**
     * 房产证号
     * @param houseCertNo 房产证号
     */
    public void setHouseCertNo(String houseCertNo) {
        this.houseCertNo = houseCertNo == null ? null : houseCertNo.trim();
    }

    /**
     * 产权人
     * @return RIGHTER_NAME 产权人
     */
    public String getRighterName() {
        return righterName;
    }

    /**
     * 产权人
     * @param righterName 产权人
     */
    public void setRighterName(String righterName) {
        this.righterName = righterName == null ? null : righterName.trim();
    }

    /**
     * 产权人证件类型
     * @return RIGHTER_CERT_TYPE 产权人证件类型
     */
    public String getRighterCertType() {
        return righterCertType;
    }

    /**
     * 产权人证件类型
     * @param righterCertType 产权人证件类型
     */
    public void setRighterCertType(String righterCertType) {
        this.righterCertType = righterCertType == null ? null : righterCertType.trim();
    }

    /**
     * 产权人证件号码
     * @return RIGHTER_CERT_CODE 产权人证件号码
     */
    public String getRighterCertCode() {
        return righterCertCode;
    }

    /**
     * 产权人证件号码
     * @param righterCertCode 产权人证件号码
     */
    public void setRighterCertCode(String righterCertCode) {
        this.righterCertCode = righterCertCode == null ? null : righterCertCode.trim();
    }

    /**
     * 是否抵押给第三方
     * @return IS_GRT_THIRD 是否抵押给第三方
     */
    public String getIsGrtThird() {
        return isGrtThird;
    }

    /**
     * 是否抵押给第三方
     * @param isGrtThird 是否抵押给第三方
     */
    public void setIsGrtThird(String isGrtThird) {
        this.isGrtThird = isGrtThird == null ? null : isGrtThird.trim();
    }

    /**
     * 原借据编号
     * @return O_BILL_NO 原借据编号
     */
    public String getoBillNo() {
        return oBillNo;
    }

    /**
     * 原借据编号
     * @param oBillNo 原借据编号
     */
    public void setoBillNo(String oBillNo) {
        this.oBillNo = oBillNo == null ? null : oBillNo.trim();
    }

    /**
     * 原合同编号
     * @return O_CONT_NO 原合同编号
     */
    public String getoContNo() {
        return oContNo;
    }

    /**
     * 原合同编号
     * @param oContNo 原合同编号
     */
    public void setoContNo(String oContNo) {
        this.oContNo = oContNo == null ? null : oContNo.trim();
    }

    /**
     * 贷款余额
     * @return LOAN_BALANCE 贷款余额
     */
    public BigDecimal getLoanBalance() {
        return loanBalance;
    }

    /**
     * 贷款余额
     * @param loanBalance 贷款余额
     */
    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
    }

    /**
     * 原贷款利率
     * @return O_USING_IR 原贷款利率
     */
    public BigDecimal getoUsingIr() {
        return oUsingIr;
    }

    /**
     * 原贷款利率
     * @param oUsingIr 原贷款利率
     */
    public void setoUsingIr(BigDecimal oUsingIr) {
        this.oUsingIr = oUsingIr;
    }

    /**
     * 原起贷日期
     * @return O_LOAN_START_DATE 原起贷日期
     */
    public String getoLoanStartDate() {
        return oLoanStartDate;
    }

    /**
     * 原起贷日期
     * @param oLoanStartDate 原起贷日期
     */
    public void setoLoanStartDate(String oLoanStartDate) {
        this.oLoanStartDate = oLoanStartDate == null ? null : oLoanStartDate.trim();
    }

    /**
     * 原止贷日期
     * @return O_LOAN_END_DATE 原止贷日期
     */
    public String getoLoanEndDate() {
        return oLoanEndDate;
    }

    /**
     * 原止贷日期
     * @param oLoanEndDate 原止贷日期
     */
    public void setoLoanEndDate(String oLoanEndDate) {
        this.oLoanEndDate = oLoanEndDate == null ? null : oLoanEndDate.trim();
    }

    /**
     * 业务人员所属机构
     * @return BUSINESS_BR_ID 业务人员所属机构
     */
    public String getBusinessBrId() {
        return businessBrId;
    }

    /**
     * 业务人员所属机构
     * @param businessBrId 业务人员所属机构
     */
    public void setBusinessBrId(String businessBrId) {
        this.businessBrId = businessBrId == null ? null : businessBrId.trim();
    }

    /**
     * 总抵(质)押率
     * @return TOTAL_NESS_RATE 总抵(质)押率
     */
    public BigDecimal getTotalNessRate() {
        return totalNessRate;
    }

    /**
     * 总抵(质)押率
     * @param totalNessRate 总抵(质)押率
     */
    public void setTotalNessRate(BigDecimal totalNessRate) {
        this.totalNessRate = totalNessRate;
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
     * 抵押物评估净值
     * @return EVAL_NET_VALUE 抵押物评估净值
     */
    public BigDecimal getEvalNetValue() {
        return evalNetValue;
    }

    /**
     * 抵押物评估净值
     * @param evalNetValue 抵押物评估净值
     */
    public void setEvalNetValue(BigDecimal evalNetValue) {
        this.evalNetValue = evalNetValue;
    }

    /**
     * 反担保措施
     * @return UNASSURE_MEANS_ACTIONS 反担保措施
     */
    public String getUnassureMeansActions() {
        return unassureMeansActions;
    }

    /**
     * 反担保措施
     * @param unassureMeansActions 反担保措施
     */
    public void setUnassureMeansActions(String unassureMeansActions) {
        this.unassureMeansActions = unassureMeansActions == null ? null : unassureMeansActions.trim();
    }

    /**
     * 信贷记录说明
     * @return SPREAD_PLACE_DESC 信贷记录说明
     */
    public String getSpreadPlaceDesc() {
        return spreadPlaceDesc;
    }

    /**
     * 信贷记录说明
     * @param spreadPlaceDesc 信贷记录说明
     */
    public void setSpreadPlaceDesc(String spreadPlaceDesc) {
        this.spreadPlaceDesc = spreadPlaceDesc == null ? null : spreadPlaceDesc.trim();
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
     * 承保贷款金额
     * @return ACCEPT_LOAN_AMOUNT 承保贷款金额
     */
    public BigDecimal getAcceptLoanAmount() {
        return acceptLoanAmount;
    }

    /**
     * 承保贷款金额
     * @param acceptLoanAmount 承保贷款金额
     */
    public void setAcceptLoanAmount(BigDecimal acceptLoanAmount) {
        this.acceptLoanAmount = acceptLoanAmount;
    }

    /**
     * 分公司机构号
     * @return SUBORGANNO 分公司机构号
     */
    public String getSuborganno() {
        return suborganno;
    }

    /**
     * 分公司机构号
     * @param suborganno 分公司机构号
     */
    public void setSuborganno(String suborganno) {
        this.suborganno = suborganno == null ? null : suborganno.trim();
    }

    /**
     * 进件来源
     * @return IMP_THI_SRC 进件来源
     */
    public String getImpThiSrc() {
        return impThiSrc;
    }

    /**
     * 进件来源
     * @param impThiSrc 进件来源
     */
    public void setImpThiSrc(String impThiSrc) {
        this.impThiSrc = impThiSrc == null ? null : impThiSrc.trim();
    }

    /**
     * 是否电子保单
     * @return IS_ELEC_INS 是否电子保单
     */
    public String getIsElecIns() {
        return isElecIns;
    }

    /**
     * 是否电子保单
     * @param isElecIns 是否电子保单
     */
    public void setIsElecIns(String isElecIns) {
        this.isElecIns = isElecIns == null ? null : isElecIns.trim();
    }

    /**
     * 是否允许修改
     * @return IS_UPDATE 是否允许修改
     */
    public String getIsUpdate() {
        return isUpdate;
    }

    /**
     * 是否允许修改
     * @param isUpdate 是否允许修改
     */
    public void setIsUpdate(String isUpdate) {
        this.isUpdate = isUpdate == null ? null : isUpdate.trim();
    }

    /**
     * 是否合格(FACO评分)
     * @return IS_PASS 是否合格(FACO评分)
     */
    public String getIsPass() {
        return isPass;
    }

    /**
     * 是否合格(FACO评分)
     * @param isPass 是否合格(FACO评分)
     */
    public void setIsPass(String isPass) {
        this.isPass = isPass == null ? null : isPass.trim();
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
     * 建议还本比例
     * @return ADVISE_REPAY_PERCENT 建议还本比例
     */
    public BigDecimal getAdviseRepayPercent() {
        return adviseRepayPercent;
    }

    /**
     * 建议还本比例
     * @param adviseRepayPercent 建议还本比例
     */
    public void setAdviseRepayPercent(BigDecimal adviseRepayPercent) {
        this.adviseRepayPercent = adviseRepayPercent;
    }

    /**
     * 得分
     * @return FICO_SCORE 得分
     */
    public String getFicoScore() {
        return ficoScore;
    }

    /**
     * 得分
     * @param ficoScore 得分
     */
    public void setFicoScore(String ficoScore) {
        this.ficoScore = ficoScore == null ? null : ficoScore.trim();
    }

    /**
     * 不通过原因
     * @return NOT_THROUGH_REASON 不通过原因
     */
    public String getNotThroughReason() {
        return notThroughReason;
    }

    /**
     * 不通过原因
     * @param notThroughReason 不通过原因
     */
    public void setNotThroughReason(String notThroughReason) {
        this.notThroughReason = notThroughReason == null ? null : notThroughReason.trim();
    }

    /**
     * fico评分最新记录id
     * @return FICO_RECORD_ID fico评分最新记录id
     */
    public String getFicoRecordId() {
        return ficoRecordId;
    }

    /**
     * fico评分最新记录id
     * @param ficoRecordId fico评分最新记录id
     */
    public void setFicoRecordId(String ficoRecordId) {
        this.ficoRecordId = ficoRecordId == null ? null : ficoRecordId.trim();
    }

    /**
     * 推广时间
     * @return SPREAD_DATE 推广时间
     */
    public String getSpreadDate() {
        return spreadDate;
    }

    /**
     * 推广时间
     * @param spreadDate 推广时间
     */
    public void setSpreadDate(String spreadDate) {
        this.spreadDate = spreadDate == null ? null : spreadDate.trim();
    }

    /**
     * 经办人
     * @return OPER_NAME 经办人
     */
    public String getOperName() {
        return operName;
    }

    /**
     * 经办人
     * @param operName 经办人
     */
    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    /**
     * 经办人手机号
     * @return OPER_PHONE 经办人手机号
     */
    public String getOperPhone() {
        return operPhone;
    }

    /**
     * 经办人手机号
     * @param operPhone 经办人手机号
     */
    public void setOperPhone(String operPhone) {
        this.operPhone = operPhone == null ? null : operPhone.trim();
    }

    /**
     * 经办人电话
     * @return OPER_TEL_NO 经办人电话
     */
    public String getOperTelNo() {
        return operTelNo;
    }

    /**
     * 经办人电话
     * @param operTelNo 经办人电话
     */
    public void setOperTelNo(String operTelNo) {
        this.operTelNo = operTelNo == null ? null : operTelNo.trim();
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
     * p2p方的审核结果 
     * @return P2P_APPROVE_STATUS p2p方的审核结果 
     */
    public String getP2pApproveStatus() {
        return p2pApproveStatus;
    }

    /**
     * p2p方的审核结果 
     * @param p2pApproveStatus p2p方的审核结果 
     */
    public void setP2pApproveStatus(String p2pApproveStatus) {
        this.p2pApproveStatus = p2pApproveStatus == null ? null : p2pApproveStatus.trim();
    }

    /**
     * 拒绝备注
     * @return REFUSEREMARK 拒绝备注
     */
    public String getRefuseremark() {
        return refuseremark;
    }

    /**
     * 拒绝备注
     * @param refuseremark 拒绝备注
     */
    public void setRefuseremark(String refuseremark) {
        this.refuseremark = refuseremark == null ? null : refuseremark.trim();
    }

    /**
     * 贷款申请是否成功发送
     * @return IS_SEND_LOAN 贷款申请是否成功发送
     */
    public String getIsSendLoan() {
        return isSendLoan;
    }

    /**
     * 贷款申请是否成功发送
     * @param isSendLoan 贷款申请是否成功发送
     */
    public void setIsSendLoan(String isSendLoan) {
        this.isSendLoan = isSendLoan == null ? null : isSendLoan.trim();
    }

    /**
     * 处理时间(个分险出结果时间)
     * @return HANDLE_TIME 处理时间(个分险出结果时间)
     */
    public String getHandleTime() {
        return handleTime;
    }

    /**
     * 处理时间(个分险出结果时间)
     * @param handleTime 处理时间(个分险出结果时间)
     */
    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime == null ? null : handleTime.trim();
    }

    /**
     * THIRD_PLATFORM
     * @return THIRD_PLATFORM THIRD_PLATFORM
     */
    public String getThirdPlatform() {
        return thirdPlatform;
    }

    /**
     * THIRD_PLATFORM
     * @param thirdPlatform THIRD_PLATFORM
     */
    public void setThirdPlatform(String thirdPlatform) {
        this.thirdPlatform = thirdPlatform == null ? null : thirdPlatform.trim();
    }

    /**
     * THIRD_PLATFORM_NAME
     * @return THIRD_PLATFORM_NAME THIRD_PLATFORM_NAME
     */
    public String getThirdPlatformName() {
        return thirdPlatformName;
    }

    /**
     * THIRD_PLATFORM_NAME
     * @param thirdPlatformName THIRD_PLATFORM_NAME
     */
    public void setThirdPlatformName(String thirdPlatformName) {
        this.thirdPlatformName = thirdPlatformName == null ? null : thirdPlatformName.trim();
    }

    /**
     * 能否出单1是，2否
     * @return CAN_SINGLE 能否出单1是，2否
     */
    public String getCanSingle() {
        return canSingle;
    }

    /**
     * 能否出单1是，2否
     * @param canSingle 能否出单1是，2否
     */
    public void setCanSingle(String canSingle) {
        this.canSingle = canSingle == null ? null : canSingle.trim();
    }

    /**
     * 1已分配，2未分配
     * @return IS_DISTRIBUTION 1已分配，2未分配
     */
    public String getIsDistribution() {
        return isDistribution;
    }

    /**
     * 1已分配，2未分配
     * @param isDistribution 1已分配，2未分配
     */
    public void setIsDistribution(String isDistribution) {
        this.isDistribution = isDistribution == null ? null : isDistribution.trim();
    }

    /**
     * 期限天
     * @return TERM_DAY 期限天
     */
    public BigDecimal getTermDay() {
        return termDay;
    }

    /**
     * 期限天
     * @param termDay 期限天
     */
    public void setTermDay(BigDecimal termDay) {
        this.termDay = termDay;
    }

    /**
     * 建议的期限（天）
     * @return ADVISE_TERM 建议的期限（天）
     */
    public String getAdviseTerm() {
        return adviseTerm;
    }

    /**
     * 建议的期限（天）
     * @param adviseTerm 建议的期限（天）
     */
    public void setAdviseTerm(String adviseTerm) {
        this.adviseTerm = adviseTerm == null ? null : adviseTerm.trim();
    }

    /**
     * 贷款状态
     * @return LOAN_STATUS 贷款状态
     */
    public String getLoanStatus() {
        return loanStatus;
    }

    /**
     * 贷款状态
     * @param loanStatus 贷款状态
     */
    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus == null ? null : loanStatus.trim();
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
     * 新增客户类别
     * @return CUS_TYPE_NEW 新增客户类别
     */
    public String getCusTypeNew() {
        return cusTypeNew;
    }

    /**
     * 新增客户类别
     * @param cusTypeNew 新增客户类别
     */
    public void setCusTypeNew(String cusTypeNew) {
        this.cusTypeNew = cusTypeNew == null ? null : cusTypeNew.trim();
    }

    /**
     * 借据协议编号
     * @return ACC_AGREE_NO 借据协议编号
     */
    public String getAccAgreeNo() {
        return accAgreeNo;
    }

    /**
     * 借据协议编号
     * @param accAgreeNo 借据协议编号
     */
    public void setAccAgreeNo(String accAgreeNo) {
        this.accAgreeNo = accAgreeNo == null ? null : accAgreeNo.trim();
    }

    /**
     * 业务推送机构
     * @return PUSH_BR_ID 业务推送机构
     */
    public String getPushBrId() {
        return pushBrId;
    }

    /**
     * 业务推送机构
     * @param pushBrId 业务推送机构
     */
    public void setPushBrId(String pushBrId) {
        this.pushBrId = pushBrId == null ? null : pushBrId.trim();
    }

    /**
     * 期数
     * @return PERIOD 期数
     */
    public BigDecimal getPeriod() {
        return period;
    }

    /**
     * 期数
     * @param period 期数
     */
    public void setPeriod(BigDecimal period) {
        this.period = period;
    }

    /**
     * 自动审核
     * @return AUTOAPPR 自动审核
     */
    public String getAutoappr() {
        return autoappr;
    }

    /**
     * 自动审核
     * @param autoappr 自动审核
     */
    public void setAutoappr(String autoappr) {
        this.autoappr = autoappr == null ? null : autoappr.trim();
    }

    /**
     * 取消贷款备注
     * @return CACCEL_LOAN_REMARKS 取消贷款备注
     */
    public String getCaccelLoanRemarks() {
        return caccelLoanRemarks;
    }

    /**
     * 取消贷款备注
     * @param caccelLoanRemarks 取消贷款备注
     */
    public void setCaccelLoanRemarks(String caccelLoanRemarks) {
        this.caccelLoanRemarks = caccelLoanRemarks == null ? null : caccelLoanRemarks.trim();
    }

    /**
     * 取消贷款原因
     * @return CACCEL_LOAN_REASON 取消贷款原因
     */
    public String getCaccelLoanReason() {
        return caccelLoanReason;
    }

    /**
     * 取消贷款原因
     * @param caccelLoanReason 取消贷款原因
     */
    public void setCaccelLoanReason(String caccelLoanReason) {
        this.caccelLoanReason = caccelLoanReason == null ? null : caccelLoanReason.trim();
    }

    /**
     * 被保险人客户编号
     * @return BID_CUS_ID 被保险人客户编号
     */
    public String getBidCusId() {
        return bidCusId;
    }

    /**
     * 被保险人客户编号
     * @param bidCusId 被保险人客户编号
     */
    public void setBidCusId(String bidCusId) {
        this.bidCusId = bidCusId == null ? null : bidCusId.trim();
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
     * 预审结果
     * @return VALID_RESULT 预审结果
     */
    public String getValidResult() {
        return validResult;
    }

    /**
     * 预审结果
     * @param validResult 预审结果
     */
    public void setValidResult(String validResult) {
        this.validResult = validResult == null ? null : validResult.trim();
    }

    /**
     * 是否自动审批
     * @return IS_AUTO_APPROVE 是否自动审批
     */
    public String getIsAutoApprove() {
        return isAutoApprove;
    }

    /**
     * 是否自动审批
     * @param isAutoApprove 是否自动审批
     */
    public void setIsAutoApprove(String isAutoApprove) {
        this.isAutoApprove = isAutoApprove == null ? null : isAutoApprove.trim();
    }

    /**
     * 招标方客户编号
     * @return PARTNER_CUS_ID 招标方客户编号
     */
    public String getPartnerCusId() {
        return partnerCusId;
    }

    /**
     * 招标方客户编号
     * @param partnerCusId 招标方客户编号
     */
    public void setPartnerCusId(String partnerCusId) {
        this.partnerCusId = partnerCusId == null ? null : partnerCusId.trim();
    }

    /**
     * MODIFYREASON
     * @return MODIFYREASON MODIFYREASON
     */
    public String getModifyreason() {
        return modifyreason;
    }

    /**
     * MODIFYREASON
     * @param modifyreason MODIFYREASON
     */
    public void setModifyreason(String modifyreason) {
        this.modifyreason = modifyreason == null ? null : modifyreason.trim();
    }

    /**
     * 特殊标识
     * @return SPECIAL_FLAG 特殊标识
     */
    public String getSpecialFlag() {
        return specialFlag;
    }

    /**
     * 特殊标识
     * @param specialFlag 特殊标识
     */
    public void setSpecialFlag(String specialFlag) {
        this.specialFlag = specialFlag == null ? null : specialFlag.trim();
    }

    /**
     * 签报号
     * @return JIRA_NO 签报号
     */
    public String getJiraNo() {
        return jiraNo;
    }

    /**
     * 签报号
     * @param jiraNo 签报号
     */
    public void setJiraNo(String jiraNo) {
        this.jiraNo = jiraNo == null ? null : jiraNo.trim();
    }

    /**
     * 规则金额
     * @return RULE_LOAN_AMT 规则金额
     */
    public BigDecimal getRuleLoanAmt() {
        return ruleLoanAmt;
    }

    /**
     * 规则金额
     * @param ruleLoanAmt 规则金额
     */
    public void setRuleLoanAmt(BigDecimal ruleLoanAmt) {
        this.ruleLoanAmt = ruleLoanAmt;
    }

    /**
     * 特殊说明
     * @return SPECIAL_REMARK 特殊说明
     */
    public String getSpecialRemark() {
        return specialRemark;
    }

    /**
     * 特殊说明
     * @param specialRemark 特殊说明
     */
    public void setSpecialRemark(String specialRemark) {
        this.specialRemark = specialRemark == null ? null : specialRemark.trim();
    }

    /**
     * 00待上传影像 01 影像上传中 02 影像上传异常 03 待放款申请  04 放款申请中 05 放款申请异常 06 放款申请发送成功 07 放款失败 08待出单 09出单异常 10 待上传保单 11保单发送中 12保单发送失败 13 保单发送异常 14结束
     * @return BUSI_STATUS 00待上传影像 01 影像上传中 02 影像上传异常 03 待放款申请  04 放款申请中 05 放款申请异常 06 放款申请发送成功 07 放款失败 08待出单 09出单异常 10 待上传保单 11保单发送中 12保单发送失败 13 保单发送异常 14结束
     */
    public String getBusiStatus() {
        return busiStatus;
    }

    /**
     * 00待上传影像 01 影像上传中 02 影像上传异常 03 待放款申请  04 放款申请中 05 放款申请异常 06 放款申请发送成功 07 放款失败 08待出单 09出单异常 10 待上传保单 11保单发送中 12保单发送失败 13 保单发送异常 14结束
     * @param busiStatus 00待上传影像 01 影像上传中 02 影像上传异常 03 待放款申请  04 放款申请中 05 放款申请异常 06 放款申请发送成功 07 放款失败 08待出单 09出单异常 10 待上传保单 11保单发送中 12保单发送失败 13 保单发送异常 14结束
     */
    public void setBusiStatus(String busiStatus) {
        this.busiStatus = busiStatus == null ? null : busiStatus.trim();
    }

    /**
     * 还款人开户行
     * @return REPAY_BANK 还款人开户行
     */
    public String getRepayBank() {
        return repayBank;
    }

    /**
     * 还款人开户行
     * @param repayBank 还款人开户行
     */
    public void setRepayBank(String repayBank) {
        this.repayBank = repayBank == null ? null : repayBank.trim();
    }

    /**
     * 还款人账户名
     * @return REPAY_ACCOUNT_NAME 还款人账户名
     */
    public String getRepayAccountName() {
        return repayAccountName;
    }

    /**
     * 还款人账户名
     * @param repayAccountName 还款人账户名
     */
    public void setRepayAccountName(String repayAccountName) {
        this.repayAccountName = repayAccountName == null ? null : repayAccountName.trim();
    }

    /**
     * 还款人账户号
     * @return REPAY_ACCOUNT 还款人账户号
     */
    public String getRepayAccount() {
        return repayAccount;
    }

    /**
     * 还款人账户号
     * @param repayAccount 还款人账户号
     */
    public void setRepayAccount(String repayAccount) {
        this.repayAccount = repayAccount == null ? null : repayAccount.trim();
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
     * 收款人账户名
     * @return PAYEE_ACCOUNT_NAME 收款人账户名
     */
    public String getPayeeAccountName() {
        return payeeAccountName;
    }

    /**
     * 收款人账户名
     * @param payeeAccountName 收款人账户名
     */
    public void setPayeeAccountName(String payeeAccountName) {
        this.payeeAccountName = payeeAccountName == null ? null : payeeAccountName.trim();
    }

    /**
     * 收款人账户号
     * @return PAYEE_ACCOUNT 收款人账户号
     */
    public String getPayeeAccount() {
        return payeeAccount;
    }

    /**
     * 收款人账户号
     * @param payeeAccount 收款人账户号
     */
    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount == null ? null : payeeAccount.trim();
    }

    /**
     * 赎楼类型
     * @return RANSOM_TYPE 赎楼类型
     */
    public String getRansomType() {
        return ransomType;
    }

    /**
     * 赎楼类型
     * @param ransomType 赎楼类型
     */
    public void setRansomType(String ransomType) {
        this.ransomType = ransomType == null ? null : ransomType.trim();
    }

    /**
     * 原房屋贷款余额
     * @return OLD_HOUSE_AMOUNT 原房屋贷款余额
     */
    public BigDecimal getOldHouseAmount() {
        return oldHouseAmount;
    }

    /**
     * 原房屋贷款余额
     * @param oldHouseAmount 原房屋贷款余额
     */
    public void setOldHouseAmount(BigDecimal oldHouseAmount) {
        this.oldHouseAmount = oldHouseAmount;
    }

    /**
     * 用款时间
     * @return USE_DATE 用款时间
     */
    public String getUseDate() {
        return useDate;
    }

    /**
     * 用款时间
     * @param useDate 用款时间
     */
    public void setUseDate(String useDate) {
        this.useDate = useDate == null ? null : useDate.trim();
    }

    /**
     * 买方客户编号
     * @return BUYER_CUS_ID 买方客户编号
     */
    public String getBuyerCusId() {
        return buyerCusId;
    }

    /**
     * 买方客户编号
     * @param buyerCusId 买方客户编号
     */
    public void setBuyerCusId(String buyerCusId) {
        this.buyerCusId = buyerCusId == null ? null : buyerCusId.trim();
    }

    /**
     * 卖方客户编号
     * @return SELLER_CUS_ID 卖方客户编号
     */
    public String getSellerCusId() {
        return sellerCusId;
    }

    /**
     * 卖方客户编号
     * @param sellerCusId 卖方客户编号
     */
    public void setSellerCusId(String sellerCusId) {
        this.sellerCusId = sellerCusId == null ? null : sellerCusId.trim();
    }

    /**
     * 买方证件类型
     * @return BUYER_CERT_TYPE 买方证件类型
     */
    public String getBuyerCertType() {
        return buyerCertType;
    }

    /**
     * 买方证件类型
     * @param buyerCertType 买方证件类型
     */
    public void setBuyerCertType(String buyerCertType) {
        this.buyerCertType = buyerCertType == null ? null : buyerCertType.trim();
    }

    /**
     * 买方证件号码
     * @return BUYER_CERT_CODE 买方证件号码
     */
    public String getBuyerCertCode() {
        return buyerCertCode;
    }

    /**
     * 买方证件号码
     * @param buyerCertCode 买方证件号码
     */
    public void setBuyerCertCode(String buyerCertCode) {
        this.buyerCertCode = buyerCertCode == null ? null : buyerCertCode.trim();
    }

    /**
     * 买方客户类型
     * @return BUYER_CUS_TYPE 买方客户类型
     */
    public String getBuyerCusType() {
        return buyerCusType;
    }

    /**
     * 买方客户类型
     * @param buyerCusType 买方客户类型
     */
    public void setBuyerCusType(String buyerCusType) {
        this.buyerCusType = buyerCusType == null ? null : buyerCusType.trim();
    }

    /**
     * 买方客户名称
     * @return BUYER_CUS_NAME 买方客户名称
     */
    public String getBuyerCusName() {
        return buyerCusName;
    }

    /**
     * 买方客户名称
     * @param buyerCusName 买方客户名称
     */
    public void setBuyerCusName(String buyerCusName) {
        this.buyerCusName = buyerCusName == null ? null : buyerCusName.trim();
    }

    /**
     * 买方联系电话
     * @return BUYER_PHONE 买方联系电话
     */
    public String getBuyerPhone() {
        return buyerPhone;
    }

    /**
     * 买方联系电话
     * @param buyerPhone 买方联系电话
     */
    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone == null ? null : buyerPhone.trim();
    }

    /**
     * 卖方证件类型
     * @return SELLER_CERT_TYPE 卖方证件类型
     */
    public String getSellerCertType() {
        return sellerCertType;
    }

    /**
     * 卖方证件类型
     * @param sellerCertType 卖方证件类型
     */
    public void setSellerCertType(String sellerCertType) {
        this.sellerCertType = sellerCertType == null ? null : sellerCertType.trim();
    }

    /**
     * 卖方证件号码
     * @return SELLER_CERT_CODE 卖方证件号码
     */
    public String getSellerCertCode() {
        return sellerCertCode;
    }

    /**
     * 卖方证件号码
     * @param sellerCertCode 卖方证件号码
     */
    public void setSellerCertCode(String sellerCertCode) {
        this.sellerCertCode = sellerCertCode == null ? null : sellerCertCode.trim();
    }

    /**
     * 卖方客户类型
     * @return SELLER_CUS_TYPE 卖方客户类型
     */
    public String getSellerCusType() {
        return sellerCusType;
    }

    /**
     * 卖方客户类型
     * @param sellerCusType 卖方客户类型
     */
    public void setSellerCusType(String sellerCusType) {
        this.sellerCusType = sellerCusType == null ? null : sellerCusType.trim();
    }

    /**
     * 卖方客户名称
     * @return SELLER_CUS_NAME 卖方客户名称
     */
    public String getSellerCusName() {
        return sellerCusName;
    }

    /**
     * 卖方客户名称
     * @param sellerCusName 卖方客户名称
     */
    public void setSellerCusName(String sellerCusName) {
        this.sellerCusName = sellerCusName == null ? null : sellerCusName.trim();
    }

    /**
     * 卖方联系电话
     * @return SELLER_PHONE 卖方联系电话
     */
    public String getSellerPhone() {
        return sellerPhone;
    }

    /**
     * 卖方联系电话
     * @param sellerPhone 卖方联系电话
     */
    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone == null ? null : sellerPhone.trim();
    }

    /**
     * 首期款监管额
     * @return BUYER_FIRST_AMOUNT 首期款监管额
     */
    public BigDecimal getBuyerFirstAmount() {
        return buyerFirstAmount;
    }

    /**
     * 首期款监管额
     * @param buyerFirstAmount 首期款监管额
     */
    public void setBuyerFirstAmount(BigDecimal buyerFirstAmount) {
        this.buyerFirstAmount = buyerFirstAmount;
    }

    /**
     * 买方贷款金额
     * @return BUYER_AMOUNT 买方贷款金额
     */
    public BigDecimal getBuyerAmount() {
        return buyerAmount;
    }

    /**
     * 买方贷款金额
     * @param buyerAmount 买方贷款金额
     */
    public void setBuyerAmount(BigDecimal buyerAmount) {
        this.buyerAmount = buyerAmount;
    }

    /**
     * 买方贷款申请银行名称
     * @return BUYER_BANK_NAME 买方贷款申请银行名称
     */
    public String getBuyerBankName() {
        return buyerBankName;
    }

    /**
     * 买方贷款申请银行名称
     * @param buyerBankName 买方贷款申请银行名称
     */
    public void setBuyerBankName(String buyerBankName) {
        this.buyerBankName = buyerBankName == null ? null : buyerBankName.trim();
    }

    /**
     * 买方贷款申请银行卡号
     * @return BUYER_BANK_CODE 买方贷款申请银行卡号
     */
    public String getBuyerBankCode() {
        return buyerBankCode;
    }

    /**
     * 买方贷款申请银行卡号
     * @param buyerBankCode 买方贷款申请银行卡号
     */
    public void setBuyerBankCode(String buyerBankCode) {
        this.buyerBankCode = buyerBankCode == null ? null : buyerBankCode.trim();
    }

    /**
     * 风险揭示
     * @return RISK_RESULT 风险揭示
     */
    public String getRiskResult() {
        return riskResult;
    }

    /**
     * 风险揭示
     * @param riskResult 风险揭示
     */
    public void setRiskResult(String riskResult) {
        this.riskResult = riskResult == null ? null : riskResult.trim();
    }

    /**
     * 是否需赎楼
     * @return IS_MUST_RANSOM 是否需赎楼
     */
    public String getIsMustRansom() {
        return isMustRansom;
    }

    /**
     * 是否需赎楼
     * @param isMustRansom 是否需赎楼
     */
    public void setIsMustRansom(String isMustRansom) {
        this.isMustRansom = isMustRansom == null ? null : isMustRansom.trim();
    }

    /**
     * 面签位置信息
     * @return VISA_INTERVIEW_COORDINATE 面签位置信息
     */
    public String getVisaInterviewCoordinate() {
        return visaInterviewCoordinate;
    }

    /**
     * 面签位置信息
     * @param visaInterviewCoordinate 面签位置信息
     */
    public void setVisaInterviewCoordinate(String visaInterviewCoordinate) {
        this.visaInterviewCoordinate = visaInterviewCoordinate == null ? null : visaInterviewCoordinate.trim();
    }

    /**
     * 贷后位置信息
     * @return LOAN_COORDINATE 贷后位置信息
     */
    public String getLoanCoordinate() {
        return loanCoordinate;
    }

    /**
     * 贷后位置信息
     * @param loanCoordinate 贷后位置信息
     */
    public void setLoanCoordinate(String loanCoordinate) {
        this.loanCoordinate = loanCoordinate == null ? null : loanCoordinate.trim();
    }

    /**
     * 微贷申请位置信息
     * @return MICRO_CREDIT_COORDINATE 微贷申请位置信息
     */
    public String getMicroCreditCoordinate() {
        return microCreditCoordinate;
    }

    /**
     * 微贷申请位置信息
     * @param microCreditCoordinate 微贷申请位置信息
     */
    public void setMicroCreditCoordinate(String microCreditCoordinate) {
        this.microCreditCoordinate = microCreditCoordinate == null ? null : microCreditCoordinate.trim();
    }

    /**
     * 是否需要授信执行
     * @return IS_CREDIT_IMPLEMENTATION 是否需要授信执行
     */
    public String getIsCreditImplementation() {
        return isCreditImplementation;
    }

    /**
     * 是否需要授信执行
     * @param isCreditImplementation 是否需要授信执行
     */
    public void setIsCreditImplementation(String isCreditImplementation) {
        this.isCreditImplementation = isCreditImplementation == null ? null : isCreditImplementation.trim();
    }

    /**
     * 是否需要面签
     * @return IS_FACE_SIGN 是否需要面签
     */
    public String getIsFaceSign() {
        return isFaceSign;
    }

    /**
     * 是否需要面签
     * @param isFaceSign 是否需要面签
     */
    public void setIsFaceSign(String isFaceSign) {
        this.isFaceSign = isFaceSign == null ? null : isFaceSign.trim();
    }

    /**
     * 分期方案id
     * @return GOODS_DETAIL_ID 分期方案id
     */
    public String getGoodsDetailId() {
        return goodsDetailId;
    }

    /**
     * 分期方案id
     * @param goodsDetailId 分期方案id
     */
    public void setGoodsDetailId(String goodsDetailId) {
        this.goodsDetailId = goodsDetailId == null ? null : goodsDetailId.trim();
    }

    /**
     * 01- 客户端  02 -客户经理端  03 -PC 端
     * @return TERMINAL_SOURCE 01- 客户端  02 -客户经理端  03 -PC 端
     */
    public String getTerminalSource() {
        return terminalSource;
    }

    /**
     * 01- 客户端  02 -客户经理端  03 -PC 端
     * @param terminalSource 01- 客户端  02 -客户经理端  03 -PC 端
     */
    public void setTerminalSource(String terminalSource) {
        this.terminalSource = terminalSource == null ? null : terminalSource.trim();
    }

    /**
     * 客户申请位置信息（区域代码）
     * @return COUNTY_CODE 客户申请位置信息（区域代码）
     */
    public String getCountyCode() {
        return countyCode;
    }

    /**
     * 客户申请位置信息（区域代码）
     * @param countyCode 客户申请位置信息（区域代码）
     */
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    /**
     * 微贷申请位置信息
     * @return CREDIT_COORDINATE 微贷申请位置信息
     */
    public String getCreditCoordinate() {
        return creditCoordinate;
    }

    /**
     * 微贷申请位置信息
     * @param creditCoordinate 微贷申请位置信息
     */
    public void setCreditCoordinate(String creditCoordinate) {
        this.creditCoordinate = creditCoordinate == null ? null : creditCoordinate.trim();
    }

    /**
     * 01- 安卓  02 -IOS  03 -PC 端
     * @return TERMINAL_TYPE 01- 安卓  02 -IOS  03 -PC 端
     */
    public String getTerminalType() {
        return terminalType;
    }

    /**
     * 01- 安卓  02 -IOS  03 -PC 端
     * @param terminalType 01- 安卓  02 -IOS  03 -PC 端
     */
    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType == null ? null : terminalType.trim();
    }

    /**
     * 首付比例
     * @return DOWN_PAYMENT 首付比例
     */
    public BigDecimal getDownPayment() {
        return downPayment;
    }

    /**
     * 首付比例
     * @param downPayment 首付比例
     */
    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    /**
     * 首付金额
     * @return DOWN_AMOUNT 首付金额
     */
    public BigDecimal getDownAmount() {
        return downAmount;
    }

    /**
     * 首付金额
     * @param downAmount 首付金额
     */
    public void setDownAmount(BigDecimal downAmount) {
        this.downAmount = downAmount;
    }

    /**
     * 分期数
     * @return MONTHLY_SUPPLY 分期数
     */
    public Integer getMonthlySupply() {
        return monthlySupply;
    }

    /**
     * 分期数
     * @param monthlySupply 分期数
     */
    public void setMonthlySupply(Integer monthlySupply) {
        this.monthlySupply = monthlySupply;
    }

    /**
     * 期供金额
     * @return MONTHLY_AMOUNT 期供金额
     */
    public BigDecimal getMonthlyAmount() {
        return monthlyAmount;
    }

    /**
     * 期供金额
     * @param monthlyAmount 期供金额
     */
    public void setMonthlyAmount(BigDecimal monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    /**
     * 商品id
     * @return GOODS_ID 商品id
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 商品id
     * @param goodsId 商品id
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * 产品类型
     * @return PRD_TYPE 产品类型
     */
    public String getPrdType() {
        return prdType;
    }

    /**
     * 产品类型
     * @param prdType 产品类型
     */
    public void setPrdType(String prdType) {
        this.prdType = prdType == null ? null : prdType.trim();
    }

    /**
     * 支付宝帐号 为邮箱或手机
     * @return ALIPAY_ACCOUNT 支付宝帐号 为邮箱或手机
     */
    public String getAlipayAccount() {
        return alipayAccount;
    }

    /**
     * 支付宝帐号 为邮箱或手机
     * @param alipayAccount 支付宝帐号 为邮箱或手机
     */
    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount == null ? null : alipayAccount.trim();
    }

    /**
     * 用户在网商的会员编号
     * @return ALIPAY_ROLE_ID 用户在网商的会员编号
     */
    public String getAlipayRoleId() {
        return alipayRoleId;
    }

    /**
     * 用户在网商的会员编号
     * @param alipayRoleId 用户在网商的会员编号
     */
    public void setAlipayRoleId(String alipayRoleId) {
        this.alipayRoleId = alipayRoleId == null ? null : alipayRoleId.trim();
    }

    /**
     * 联行号 字典STD_BANK_NO
     * @return BANK_NO 联行号 字典STD_BANK_NO
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 联行号 字典STD_BANK_NO
     * @param bankNo 联行号 字典STD_BANK_NO
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    /**
     * SIGN_AMOUNT
     * @return SIGN_AMOUNT SIGN_AMOUNT
     */
    public BigDecimal getSignAmount() {
        return signAmount;
    }

    /**
     * SIGN_AMOUNT
     * @param signAmount SIGN_AMOUNT
     */
    public void setSignAmount(BigDecimal signAmount) {
        this.signAmount = signAmount;
    }

    /**
     * 同盾设备指纹移动端
     * @return BLACK_BOX 同盾设备指纹移动端
     */
    public String getBlackBox() {
        return blackBox;
    }

    /**
     * 同盾设备指纹移动端
     * @param blackBox 同盾设备指纹移动端
     */
    public void setBlackBox(String blackBox) {
        this.blackBox = blackBox == null ? null : blackBox.trim();
    }

    /**
     * 是否续贷（0- 否  - 是）
     * @return ISLOANED 是否续贷（0- 否  - 是）
     */
    public String getIsloaned() {
        return isloaned;
    }

    /**
     * 是否续贷（0- 否  - 是）
     * @param isloaned 是否续贷（0- 否  - 是）
     */
    public void setIsloaned(String isloaned) {
        this.isloaned = isloaned == null ? null : isloaned.trim();
    }

    /**
     * 末笔银行贷款金额
     * @return LAST_BANK_LOAN_AMOUNT 末笔银行贷款金额
     */
    public BigDecimal getLastBankLoanAmount() {
        return lastBankLoanAmount;
    }

    /**
     * 末笔银行贷款金额
     * @param lastBankLoanAmount 末笔银行贷款金额
     */
    public void setLastBankLoanAmount(BigDecimal lastBankLoanAmount) {
        this.lastBankLoanAmount = lastBankLoanAmount;
    }

    /**
     * 是否公积金、社保授权 0- 手工录入 1- 同盾 2- 亚联盟
     * @return IS_AUTHORIZE 是否公积金、社保授权 0- 手工录入 1- 同盾 2- 亚联盟
     */
    public String getIsAuthorize() {
        return isAuthorize;
    }

    /**
     * 是否公积金、社保授权 0- 手工录入 1- 同盾 2- 亚联盟
     * @param isAuthorize 是否公积金、社保授权 0- 手工录入 1- 同盾 2- 亚联盟
     */
    public void setIsAuthorize(String isAuthorize) {
        this.isAuthorize = isAuthorize == null ? null : isAuthorize.trim();
    }

    /**
     * 是否加贷保费    true 加贷 false 不加贷
     * @return INCLUDE_INS_FEE 是否加贷保费    true 加贷 false 不加贷
     */
    public String getIncludeInsFee() {
        return includeInsFee;
    }

    /**
     * 是否加贷保费    true 加贷 false 不加贷
     * @param includeInsFee 是否加贷保费    true 加贷 false 不加贷
     */
    public void setIncludeInsFee(String includeInsFee) {
        this.includeInsFee = includeInsFee == null ? null : includeInsFee.trim();
    }

    /**
     * 出单员
     * @return HAND_PORICY_ID 出单员
     */
    public String getHandPoricyId() {
        return handPoricyId;
    }

    /**
     * 出单员
     * @param handPoricyId 出单员
     */
    public void setHandPoricyId(String handPoricyId) {
        this.handPoricyId = handPoricyId == null ? null : handPoricyId.trim();
    }

    /**
     * LOAN_LX
     * @return LOAN_LX LOAN_LX
     */
    public BigDecimal getLoanLx() {
        return loanLx;
    }

    /**
     * LOAN_LX
     * @param loanLx LOAN_LX
     */
    public void setLoanLx(BigDecimal loanLx) {
        this.loanLx = loanLx;
    }

    /**
     * 预估用款月数
     * @return ESTIMATION_AMOUNT 预估用款月数
     */
    public Long getEstimationAmount() {
        return estimationAmount;
    }

    /**
     * 预估用款月数
     * @param estimationAmount 预估用款月数
     */
    public void setEstimationAmount(Long estimationAmount) {
        this.estimationAmount = estimationAmount;
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
     * 还款人支付宝账号
     * @return REPAY_AIL_PAY_ACCOUNT 还款人支付宝账号
     */
    public String getRepayAilPayAccount() {
        return repayAilPayAccount;
    }

    /**
     * 还款人支付宝账号
     * @param repayAilPayAccount 还款人支付宝账号
     */
    public void setRepayAilPayAccount(String repayAilPayAccount) {
        this.repayAilPayAccount = repayAilPayAccount == null ? null : repayAilPayAccount.trim();
    }

    /**
     * 收款账户类型 STD_BANK_ACCOUNT_TYPE 1对私 2对公
     * @return PAYEE_ACCOUNT_TYPE 收款账户类型 STD_BANK_ACCOUNT_TYPE 1对私 2对公
     */
    public String getPayeeAccountType() {
        return payeeAccountType;
    }

    /**
     * 收款账户类型 STD_BANK_ACCOUNT_TYPE 1对私 2对公
     * @param payeeAccountType 收款账户类型 STD_BANK_ACCOUNT_TYPE 1对私 2对公
     */
    public void setPayeeAccountType(String payeeAccountType) {
        this.payeeAccountType = payeeAccountType == null ? null : payeeAccountType.trim();
    }

    /**
     * 是否承包附加险1是、2否
     * @return ACCESSORY_RISK 是否承包附加险1是、2否
     */
    public String getAccessoryRisk() {
        return accessoryRisk;
    }

    /**
     * 是否承包附加险1是、2否
     * @param accessoryRisk 是否承包附加险1是、2否
     */
    public void setAccessoryRisk(String accessoryRisk) {
        this.accessoryRisk = accessoryRisk == null ? null : accessoryRisk.trim();
    }

    /**
     * 首笔贷款机构
     * @return FRIST_LOAN_PARTNER_NAME 首笔贷款机构
     */
    public String getFristLoanPartnerName() {
        return fristLoanPartnerName;
    }

    /**
     * 首笔贷款机构
     * @param fristLoanPartnerName 首笔贷款机构
     */
    public void setFristLoanPartnerName(String fristLoanPartnerName) {
        this.fristLoanPartnerName = fristLoanPartnerName == null ? null : fristLoanPartnerName.trim();
    }

    /**
     * 末笔贷款机构
     * @return LAST_LOAN_PARTNER_NAME 末笔贷款机构
     */
    public String getLastLoanPartnerName() {
        return lastLoanPartnerName;
    }

    /**
     * 末笔贷款机构
     * @param lastLoanPartnerName 末笔贷款机构
     */
    public void setLastLoanPartnerName(String lastLoanPartnerName) {
        this.lastLoanPartnerName = lastLoanPartnerName == null ? null : lastLoanPartnerName.trim();
    }

    /**
     * 首笔贷款机构编码
     * @return FRIST_LOAN_PARTNER_NO 首笔贷款机构编码
     */
    public String getFristLoanPartnerNo() {
        return fristLoanPartnerNo;
    }

    /**
     * 首笔贷款机构编码
     * @param fristLoanPartnerNo 首笔贷款机构编码
     */
    public void setFristLoanPartnerNo(String fristLoanPartnerNo) {
        this.fristLoanPartnerNo = fristLoanPartnerNo == null ? null : fristLoanPartnerNo.trim();
    }

    /**
     * 末笔贷款机构编码
     * @return LAST_LOAN_PARTNER_NO 末笔贷款机构编码
     */
    public String getLastLoanPartnerNo() {
        return lastLoanPartnerNo;
    }

    /**
     * 末笔贷款机构编码
     * @param lastLoanPartnerNo 末笔贷款机构编码
     */
    public void setLastLoanPartnerNo(String lastLoanPartnerNo) {
        this.lastLoanPartnerNo = lastLoanPartnerNo == null ? null : lastLoanPartnerNo.trim();
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
     * 信托计划名+期次
     * @return TRUST_PLAN 信托计划名+期次
     */
    public String getTrustPlan() {
        return trustPlan;
    }

    /**
     * 信托计划名+期次
     * @param trustPlan 信托计划名+期次
     */
    public void setTrustPlan(String trustPlan) {
        this.trustPlan = trustPlan == null ? null : trustPlan.trim();
    }

    /**
     * null
     * @return BATCH_NO null
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * null
     * @param batchNo null
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * 业务推荐机构
     * @return BUSINESS_RECOM_ORGNAME 业务推荐机构
     */
    public String getBusinessRecomOrgname() {
        return businessRecomOrgname;
    }

    /**
     * 业务推荐机构
     * @param businessRecomOrgname 业务推荐机构
     */
    public void setBusinessRecomOrgname(String businessRecomOrgname) {
        this.businessRecomOrgname = businessRecomOrgname == null ? null : businessRecomOrgname.trim();
    }

    /**
     * 业务推荐机构ID
     * @return BUSINESS_RECOM_ORGID 业务推荐机构ID
     */
    public String getBusinessRecomOrgid() {
        return businessRecomOrgid;
    }

    /**
     * 业务推荐机构ID
     * @param businessRecomOrgid 业务推荐机构ID
     */
    public void setBusinessRecomOrgid(String businessRecomOrgid) {
        this.businessRecomOrgid = businessRecomOrgid == null ? null : businessRecomOrgid.trim();
    }

    /**
     * 业务地区
     * @return BUSI_AREA 业务地区
     */
    public String getBusiArea() {
        return busiArea;
    }

    /**
     * 业务地区
     * @param busiArea 业务地区
     */
    public void setBusiArea(String busiArea) {
        this.busiArea = busiArea == null ? null : busiArea.trim();
    }

    /**
     * 是否有新贷款批复
     * @return NEW_LOAN_APPROVAL 是否有新贷款批复
     */
    public String getNewLoanApproval() {
        return newLoanApproval;
    }

    /**
     * 是否有新贷款批复
     * @param newLoanApproval 是否有新贷款批复
     */
    public void setNewLoanApproval(String newLoanApproval) {
        this.newLoanApproval = newLoanApproval == null ? null : newLoanApproval.trim();
    }

    /**
     * 新贷款银行
     * @return NEW_LOAN_BANK 新贷款银行
     */
    public String getNewLoanBank() {
        return newLoanBank;
    }

    /**
     * 新贷款银行
     * @param newLoanBank 新贷款银行
     */
    public void setNewLoanBank(String newLoanBank) {
        this.newLoanBank = newLoanBank == null ? null : newLoanBank.trim();
    }

    /**
     * 还款账户开户行号
     * @return REPAY_BANK_NO 还款账户开户行号
     */
    public String getRepayBankNo() {
        return repayBankNo;
    }

    /**
     * 还款账户开户行号
     * @param repayBankNo 还款账户开户行号
     */
    public void setRepayBankNo(String repayBankNo) {
        this.repayBankNo = repayBankNo == null ? null : repayBankNo.trim();
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
     * null
     * @return LOAN_DIRECTION_CREDIT null
     */
    public String getLoanDirectionCredit() {
        return loanDirectionCredit;
    }

    /**
     * null
     * @param loanDirectionCredit null
     */
    public void setLoanDirectionCredit(String loanDirectionCredit) {
        this.loanDirectionCredit = loanDirectionCredit == null ? null : loanDirectionCredit.trim();
    }
}