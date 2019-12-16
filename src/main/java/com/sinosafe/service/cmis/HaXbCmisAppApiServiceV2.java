package com.sinosafe.service.cmis;

/***
 * ClassName: HaXbCmisAppApiService <br/>
 * Function: 华安信保（风险管理系统）系统对外接口 <br/>
 * date: 2017年5月26日 下午2:44:13 <br/>
 *
 * @author longmeihua
 * @version
 * @since JDK 1.6
 */
public interface HaXbCmisAppApiServiceV2 {

	/***
	 * 
	 * queryOrgs:机构查询<br/>
	 * 
	 * @author longmeihua
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryOrgs(String request, String json);

	/***
	 * 用户查询
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String querySUser(String request, String json);

	/***
	 * 实名认证
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String checkIdentity(String request, String json);

	/***
	 * 预审
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String checkApply(String request, String json);

	/***
	 * 贷款申请
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String applyLoan(String request, String json);
	
	

	/***
	 * 返回审批结果
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String noticeApprovalResult(String request, String json);

	/***
	 * 签署投保单
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String signInsuranceApplication(String request, String json);

	/***
	 * 保费支付
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String payInsuranceFee(String request, String json);

	/***
	 * 还款计划和明细查询
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String queryRepayInfo(String request, String json);

	/***
	 * 交易明细查询
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String queryTradeDetail(String request, String json);

	/***
	 * 登录校验
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String checkUser(String request, String json);

	/***
	 * 获取申请贷款数据
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String queryAppLoanDetail(String request, String json);

	/***
	 * 查看申请详情
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String queryLoanDetail(String request, String json);

	/***
	 * 获取业务流水号
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @return
	 */
	String queryIqpLoanSerNo(String request);

	/***
	 * 获取客户开户编号
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @return
	 */
	String queryCustomerIdNo(String request);

	/***
	 * 锁定任务流程
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String lockAppLoanTask(String request, String json);

	/***
	 * 获取任务
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String queryAppLoanTask(String request, String json);

	/***
	 * 获取客户贷款数据（我的贷款、我的分期）
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String queryCusLoanAppInfo(String request, String json);

	/***
	 * 校验客户银行卡是否能换绑
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String checkBankAccountToChange(String request, String json);

	/***
	 * 影像资料上传回执
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String imageDocUploadReceipt(String request, String json);

	/***
	 * 查询电子保单
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String queryElecPolicy(String request, String json);


	/***
	 * 
	 * queryLstIqpInfo:返回投保单资料. <br/>
	 * 
	 * @author longmeihua
	 * @param request
	 *            {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *            appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 *            参数
	 * @return
	 * @since JDK 1.6
	 */
	String queryLstIqpInfo(String request, String json);

	/***
	 * 
	 * supplementApplyLoan:补充申请资料（配偶资料、单位信息、房/车信息）. <br/>
	 * 
	 * @author longmeihua
	 * @param request
	 *            {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *            appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 *            参数
	 * @return
	 * @since JDK 1.6
	 */
	String supplementApplyLoan(String request, String json);

	/***
	 * syncPrjChnPrdInfo:同步合作方数据. <br/>
	 * @author longmeihua
	 * @param request
	 *            {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *            appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String syncPrjChnPrdInfo(String request, String json);
	
	/***
	 * 处理预审
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String dealPrejudication(String request, String json);
	
	/***
	 * 新增流程
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String addProcess(String request, String json);

	/***
	 * 授信执行处理
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String dealSXZX(String request, String json);
	
	/***
	 * 客户经理端资料修改
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String modifySUser(String request, String json);
	
	/***
	 * 收集位置定位数据
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String collectCoordinateInfo(String request, String json);
	
	
	/***
	 * queryReport00001:业务报表-整体情况. <br/>
	 * CUS_MGR VARCHAR2(20) Y 客户经理ID REPORT_TYPE Y 【整体情况】 ALL -整体所有概况统计 【当日情况 】
	 * 001- 当日T-1
	 * 
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryReport00001(String request, String json);

	/***
	 * 
	 * queryReport00002:业务报表-【整体情况-预计提成】. <br/>
	 * CUS_MGR 客户经理ID
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryReport00002(String request, String json);

	/***
	 * queryReport00003:业务报表-【整体情况-放款笔数】趋势图. <br/>
	 * CUS_MGR 客户经理ID 
	 * REPORT_TYPE  【日】 - 001 【周】 - 002 【月】 - 003  【年】 - 004 
	 * REQUEST_DATA 【日】 默认 [ T-1 ,T-7] 日 【周】[T-1,T-5] 周 【月】 默认本年度 【年】 所有年度
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryReport00003(String request, String json);

	/***
	 * queryReport00004:业务报表-【整体情况-保费收入】趋势图. <br/>
	 * CUS_MGR	 	客户经理ID 
	 * REPORT_TYPE	 	【日】   - 001   【周】 - 002 【月】  - 003 【年】  - 004
	 * REQUEST_DATA				【日】 默认  [ T-1 ,T-7] 日    【周】[T-1,T-5] 周    【月】 默认本年度    【年】 所有年度 
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryReport00004(String request, String json);
	
	/***
	 * queryReport00005:业务报表-逾期笔数、逾期金额. <br/>
	 * CUS_MGR	客户经理ID
	 * REPORT_TYPE	0001-逾期笔数 0002-逾期金额
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryReport00005(String request, String json);

	/***
	 * queryReport00006:业务报表-【保费收入】排名. <br/>
	 * CUS_MGR 客户经理ID
	 * DATE_TYPE		001-天 002-周 003-月 004- 年
	 * HISTORY_QUERY	003 -月 004-年
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryReport00006(String request, String json);

	/***
	 * queryReport00007:业务报表-【业绩提成】排名. <br/>
	 * CUS_MGR  客户经理ID
	 * DATE_TYPE   001-天 002-周  003-月  004- 年
	 * HISTORY_QUERY 003 -月  004-年
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryReport00007(String request, String json);
	
	/***
	 * queryReport00008:业务报表-【业绩提成】排名. <br/>
	 * CUS_MGR  客户经理ID
	 * DATE_TYPE   001-天 002-周  003-月  004- 年
	 * HISTORY_QUERY 003 -月  004-年
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryReport00008(String request, String json);

	/***
	 * queryReport00009:业务报表-【放款金额】排名. <br/>
	 * CUS_MGR  客户经理ID
	 * DATE_TYPE   001-天 002-周  003-月  004- 年
	 * HISTORY_QUERY 003 -月  004-年
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryReport00009(String request, String json);
	
	
	/***
	 * queryReport00010:业务报表-【客户回款率排行榜】排名. <br/>
	 * CUS_MGR  客户经理ID
	 * DATE_TYPE   001-天 002-周  003-月  004- 年
	 * HISTORY_QUERY 003 -月  004-年
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryReport00010(String request, String json);

	/***
	 * queryCusAccLoanList:我的还款. <br/>
	 * CUS_ID  客户ID
	 * PRD_ID  产品ID
	 * PS_DUE_DT YYYY-MM 2017-06
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryCusAccLoanList(String request, String json);

	
	/***
	 * queryLstInsuranceSlipUrl:获取投保单影像URL. <br/>
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryLstInsuranceSlipUrl(String request, String json);
	
	/***
	 * collectClientCallRecord:收集客户通讯录. <br/>
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String collectClientCallRecord(String request, String json);
	
	
	/***
	 * queryLstTemplateDetail:获取投保单模板数据. <br/>
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryLstTemplateDetail(String request, String json);
	
	
	/***
	 * backLstSignUrlRecord:回写投保单签署URL地址. <br/>
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String backLstSignUrlRecord(String request, String json);
	
	/***
	 * cusCompensatoryPspPayFlow:客户代偿还款负赔追偿流程. <br/>
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String cusCompensatoryPspPayFlow(String request, String json);
	
	
	/***
	 * senderPCResultToApp:PC端推送消息. <br/>
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String senderPCResultToApp(String json);
	
	/***
	 * queryApplyStatus:客户申请状态查询. <br/>
	 * @author longmeihua
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String queryApplyStatus(String request, String json);

	/***
	 * senderSMS:发送短信. <br/>
	 * @author longmeihua
	 * @param phone  手机号
	 * @param json   短信内容
	 * @return
	 * @since JDK 1.6
	 */
	String senderSMS(String phone,String json);
	
	/***
	 * senderNodejsMessage:风险管理系统消息推送. <br/>
	 * @author longmeihua
	 * @param userId  消息接受Id
	 * @param msg   消息内容
	 * @return
	 * @since JDK 1.6
	 */
	String senderNodejsMessage(String userId,String msg);
	
	
	/***
	 * 
	 * customerAutoRulePre:老友贷客户规则预审. <br/>
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String customerAutoRulePre(String request, String json);
	
	/***
	 * remoteDubboScheduleJob:远程定时调用Dubbo方法. <br/>
	 * @author longmeihua
	 * @param type  类型
	 * @param dubboName  dubbo服务名
	 * @return
	 * @since JDK 1.6
	 */
	String remoteDubboScheduleJob(String type, String dubboName);
	
	String senderElecMqMsg(String json);
	
	/***
	 * 贷款申请
	 * 
	 * @param {\"appRequestType\": \"01\",\"curPage\": 1,\"pageSize\": 10}
	 *        appRequestType 01- 客户端 02- 客户经理端 curPage- 分页起 pageSize- 分页止
	 * @param json
	 * @return
	 */
	String applyLoanWx(String request, String json);
	
	String selectCusInfo4GdBank(String cusId);
	/***
	 * 在线签署投保单
	 * @param cusName 客户名称
	 * @param certCode 证件号码
	 * @return
	 */
	String selectCusSignIqpInfo(String cusName, String certCode);
	/***
	 * 在线签署投保单
	 * @param serno 业务流水号
	 * @return
	 */
	String signLstIqpInfo(String serno);
	
	/***
	 * 获取投保单模板数据
	 * @param request
	 * @param json
	 * @return
	 */
	String queryIqpTemplateDetail(String request, String json);
	
	
	
	/***
	 * 更新绑定银行卡信息
	 * @param request
	 * @param json
	 * @return
	 */
	String updateBindBankCard(String request, String json);
	/***
	 * saveGuaranteeInfo:保存担保人. <br/>
	 * @author ex_gaoxiang
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String saveGuaranteeInfo(String request, String json);
	/***
	 * saveGuaranteeInfo:保存影像信息. <br/>
	 * @author ex_gaoxiang
	 * @param json
	 * @return
	 * @since JDK 1.6
	 */
	String saveImageRecord(String request, String json);
	/**
	 * 发起代扣
	 * @author ex_gaoxiang
	 * @param request
	 * @param json
	 * @return
	 */
	String  initiatedWithholding(String request, String json);
	
	
	/***
	 * 查询产品
	 * @param request
	 * @param json
	 * @return
	 */
	String  sysnPrdBasicinfo(String json);
	
	
	/***
	 * 保存商学贷申请数据
	 * @param json
	 * @return
	 */
	String  saveSxdApplyInfo(String json);
	
	/***
	 * 获取商学贷缴费 URL
	 * @param json
	 * @return
	 */
	String querySxdPaymentFeeUrl(String json);
	

}
