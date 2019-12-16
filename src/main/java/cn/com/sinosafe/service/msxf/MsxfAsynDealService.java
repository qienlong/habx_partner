package cn.com.sinosafe.service.msxf;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yzj.util.UUID32;

import cn.com.sinosafe.api.CommonService;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.config.properties.MsxfProperties;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.AccLoanMapper;
import cn.com.sinosafe.dao.AccMtdPlanMapper;
import cn.com.sinosafe.dao.BizLogMapper;
import cn.com.sinosafe.dao.IqpMeApiCopMapper;
import cn.com.sinosafe.dao.IqpMeAuditOpinionMapper;
import cn.com.sinosafe.dao.IqpMeCusAppMapper;
import cn.com.sinosafe.dao.IqpMeErrInfoMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.IqpMePrjCopDao;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.LstOperDetailsMapper;
import cn.com.sinosafe.dao.LstSettleInfoMapper;
import cn.com.sinosafe.dao.PartnerBusiImportDetailMapper;
import cn.com.sinosafe.dao.PrjCopAccMapper;
import cn.com.sinosafe.dao.TempLoanInfoMapper;
import cn.com.sinosafe.domain.bean.MsxfLoanStatus;
import cn.com.sinosafe.domain.bean.MsxfStatus;
import cn.com.sinosafe.domain.entity.AccLoan;
import cn.com.sinosafe.domain.entity.AccMtdPlan;
import cn.com.sinosafe.domain.entity.BizLogWithBLOBs;
import cn.com.sinosafe.domain.entity.IqpMeApiCop;
import cn.com.sinosafe.domain.entity.IqpMeAuditOpinion;
import cn.com.sinosafe.domain.entity.IqpMeCusApp;
import cn.com.sinosafe.domain.entity.IqpMeErrInfo;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.IqpMePrjCop;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.LstOperDetails;
import cn.com.sinosafe.domain.entity.LstSettleInfo;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.domain.entity.PartnerBusiImportDetail;
import cn.com.sinosafe.domain.entity.PrjCopAcc;
import cn.com.sinosafe.domain.entity.TempLoanInfo;
import cn.com.sinosafe.domain.msxf.RepayPlan;
import cn.com.sinosafe.domain.msxf.request.Msxf1001Request;
import cn.com.sinosafe.domain.msxf.request.MsxfPL2001Request;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.common.AutoLstService;
import cn.com.sinosafe.service.common.EmailPushService;

/**
 * 
 * 马上消费异步任务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月2日<br>
 */
@Service
public class MsxfAsynDealService{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SystemConfig systemConfig;
	@Autowired
	private BizLogMapper bizLogDao;
	@Autowired
	private LstOperDetailsMapper lstOperDetailsMapper;
	@Autowired
	private IqpMeCusAppMapper iqpMeCusAppMapper;
	@Autowired
	private PrjCopAccMapper prjCopAccMapper;
	@Autowired
	private IqpMePrjCopDao iqpMePrjCopDao;
	@Autowired
	private IqpMeAuditOpinionMapper iqpMeAuditOpinionMapper;
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;
	@Autowired
	private AccLoanMapper accLoanMapper;
	@Autowired
	private AutoLstService autoLstService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private EmailPushService emailPushService;
	@Autowired
	private MsxfProperties msxfProperties;
	@Autowired
	private IqpMeApiCopMapper iqpMeApiCopMapper;
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private AccMtdPlanMapper accMtdPlanMapper;
	@Autowired
	private PartnerBusiImportDetailMapper partnerBusiImportDetailMapper;
	@Autowired
	private IqpMeErrInfoMapper iqpMeErrInfoMapper;
	@Autowired
	private TempLoanInfoMapper tempLoanInfoMapper;
	@Autowired
	private LstSettleInfoMapper lstSettleInfoMapper;

	//职业类型
	private static Map<String,String> OccTypeMap = new HashMap<String,String>();
	static {
		OccTypeMap.put("01","5");
		OccTypeMap.put("02","4");
		OccTypeMap.put("03","X");
		OccTypeMap.put("04","1");
		OccTypeMap.put("05","Y");
		OccTypeMap.put("06","6");
		OccTypeMap.put("07","7");
		OccTypeMap.put("08","3");
		OccTypeMap.put("09","Z");
	}

	/**
	 * 插入轨迹表
	 * @param serno		业务流水号
	 * @param
	 * @param remark	备注
	 * @return	:
	 */
	public void insertLstOperDetailsStatus(String serno, MsxfStatus msxfStatus, String remark) {
		LstOperDetails operDetails = new LstOperDetails();
		operDetails.setIqpSerno(serno);
		operDetails.setPkId(UUID32.getUUID());
		operDetails.setOperTime(DateUtils.getDateTime());

		// 获取当前状态描述
		operDetails.setNodename(msxfStatus.name());
		
		// 获取当前状态第二描述（下一状态描述）
		String newStatusEname = msxfStatus.getNext();
		if (StringUtils.isNotEmpty(newStatusEname)) {
			operDetails.setNodenameTwo(newStatusEname);
		}
		if (StringUtils.isNotEmpty(remark)) {
			operDetails.setRemark(remark);
		}
		
		lstOperDetailsMapper.insertSelective(operDetails);
	}
	
	/**
	 * 记录电子日志
	 * @param serno
	 * @param interfaceNo
	 * @param requestReport
	 * @param responseReport
	 */
	@Async
	public void insertBizLog(String serno, String interfaceNo, String requestReport, String responseReport) {
		BizLogWithBLOBs bizLog = new BizLogWithBLOBs();
		bizLog.setPkId(StringUtils.uuid());
		bizLog.setExtEnterpriseCode(MsxfConstant.MSXF);
		bizLog.setTransSerialNo(serno);
		bizLog.setProcessNo(interfaceNo);
		bizLog.setInputReport(requestReport);
		bizLog.setOutputReport(responseReport);
		bizLog.setCreatedBy(MsxfConstant.MSXF_SYSTEM);
		bizLog.setCreatedDate(DateUtils.getDateTime());
		bizLog.setUpdatedBy(MsxfConstant.MSXF_SYSTEM);
		bizLog.setUpdatedDate(DateUtils.getDateTime());
		bizLogDao.insertSelective(bizLog);
	}
	
	/**
	 * 记录异常信息
	 * @param interfaceType 接口类型
	 * @param msgType 消息类型
	 * @param info 内容
	 * @param errMsg 错误信息
	 */
	@Async
	public void insertErrorInfo(String interfaceType, String msgType, String info, String errMsg) {
		IqpMeErrInfo record = new IqpMeErrInfo();
		record.setPkId(UUID32.getUUID().toLowerCase());
		record.setModule(MsxfConstant.MSXF);
		record.setType(interfaceType);
		record.setInfo(info);
		record.setStatus("0");
		record.setMsgType(msgType);
		record.setMsg("原因：" + errMsg);
		record.setMsgDate(DateUtils.getDate());
		iqpMeErrInfoMapper.insertSelective(record );
	}
	
	/**
	 * 异步处理核保申请
	 * @param iqpMeLoanApp
	 */
	@Async
	public void approve(String param,String serno) {
		try {
			logger.info("开始核保申请异步处理，serno：{}，param：{}",serno,param);
			IqpMeLoanApp iqpMeLoanApp = iqpMeLoanAppMapper.selectByPrimaryKey(serno);
			IqpMeApiCop iqpMeApiCop = iqpMeApiCopMapper.selectByAccid(MsxfConstant.MSXF);
			Msxf1001Request request = JSON.parseObject(param, Msxf1001Request.class);
			approve(iqpMeLoanApp, iqpMeApiCop, request);
		}catch (Exception e){
			logger.error(serno + "==>approve",e);
			// 发送邮件
			pushEmail("approve", serno + "\n" + param, e);
		}
		logger.info("{}异步处理核保申请结束",serno);
	}

	/**
	 * 异步处理核保申请
	 * @param iqpMeLoanApp
	 * @throws Exception 
	 */
	private void approve(IqpMeLoanApp iqpMeLoanApp ,IqpMeApiCop iqpMeApiCop ,Msxf1001Request request) throws Exception {
			
		//插入申请客户表
		insertIqpMeCusApp(iqpMeLoanApp,request);
		logger.info("{}插入IqpMeCusApp完成",iqpMeLoanApp.getSerno());
		
		//查合作方信息
		PrjCopAcc prjCopAcc = prjCopAccMapper.selectByPrimaryKey(iqpMeApiCop.getCopNo());
		
		//插入申请机构表
		insertIqpMePrjCop(iqpMeLoanApp,prjCopAcc);
		logger.info("{}插入IqpMePrjCop完成",iqpMeLoanApp.getSerno());

	}

	/**
	 * 插入申请机构表
	 * @param
	 * @throws Exception
	 */
	private void insertIqpMePrjCop(IqpMeLoanApp iqpMeLoanApp ,PrjCopAcc prjCopAcc) throws Exception{
		IqpMePrjCop iqpMePrjCop = new IqpMePrjCop();
		iqpMePrjCop.setPkId(StringUtils.uuid());
		iqpMePrjCop.setSerno(iqpMeLoanApp.getSerno());
		iqpMePrjCop.setCopNo(prjCopAcc.getCopNo());
		iqpMePrjCop.setCopCertCode(prjCopAcc.getCopCertCode());
		iqpMePrjCop.setCopCertType(prjCopAcc.getCopCertType());
		iqpMePrjCop.setCopCusName(prjCopAcc.getCopCusName());
		iqpMePrjCop.setCopCusId(prjCopAcc.getCopCusId());
		iqpMePrjCop.setCopCusType(prjCopAcc.getCopCusType());
		iqpMePrjCop.setBizCopType(prjCopAcc.getCopCusType()); //TODO   业务合作机构类型  合作方类型
		iqpMePrjCopDao.insertSelective(iqpMePrjCop);
	}
	/**
	 * 插入申请客户表
	 * @param
	 * @throws Exception
	 */
	private void insertIqpMeCusApp(IqpMeLoanApp iqpMeLoanApp,Msxf1001Request request) throws Exception{
		IqpMeCusApp iqpMeCus = new IqpMeCusApp();
		iqpMeCus.setSerno(iqpMeLoanApp.getSerno()); //业务流水号
		iqpMeCus.setCusType(iqpMeLoanApp.getCusType()); //客户类型
		iqpMeCus.setCusId(iqpMeLoanApp.getCusId());//客戶编号
		iqpMeCus.setCertType(iqpMeLoanApp.getCertType()); //证件类型
		iqpMeCus.setCertCode(iqpMeLoanApp.getCertCode()); //证件号码
		iqpMeCus.setCusName(iqpMeLoanApp.getCusName());//客户名称
		iqpMeCus.setMobile(iqpMeLoanApp.getPhone());//申请人手机号
		iqpMeCus.setIndivDtOfBirth(getBirthdayByCertNo(request.getBizParams().getIdNo()));  //出生日期
		iqpMeCus.setIndivSex(request.getBizParams().getSex()); //性别
		iqpMeCus.setIndivMarSt("26"); //婚姻状况  默认其他
		iqpMeCus.setIndivRsdAddr(request.getBizParams().getHomeAddress()); //居住住址
		iqpMeCus.setIndivEdt("99"); //最高学历  默认未知  STD_ZX_EDU
		iqpMeCus.setEduLevel("99"); //教育程度，默认未知 STD_ZX_EDU
		iqpMeCus.setIndivRsdSt("9"); //居住状况， 默认未知 STD_ZB_RESIDE_STATUS
		iqpMeCus.setIndivOcc(OccTypeMap.get(request.getBizParams().getOccupation()));  //职业，STD_ZX_EMPLOYMET
		iqpMeCus.setIndivIdLong(request.getBizParams().getDueDate()); //证件有效期
		iqpMeCus.setIndivSpsIdEndDate(request.getBizParams().getDueDate());
		iqpMeCus.setComCountry("CDL");//国籍
		iqpMeCusAppMapper.insertSelective(iqpMeCus);
	}


	/**
	 * 决议表
	 * @param
	 * @throws Exception
	 */
	private void insertIqpMeAuditOpinion(LstIqpInfo lstIqpInfo) throws Exception {
		IqpMeAuditOpinion option = new IqpMeAuditOpinion();
		// 新增决议
		option.setSerno(lstIqpInfo.getIqpLoanSerno());
		option.setPkId("JY" + StringUtils.getRandomNumeric(10));
		option.setCusId(lstIqpInfo.getCusId());
		option.setAmount(lstIqpInfo.getAmount());
		option.setApproveTermTimeType(lstIqpInfo.getTermTimeType());
		option.setApproveRate(lstIqpInfo.getGrossRate());
		option.setTerm("02".equals(lstIqpInfo.getTermTimeType())?lstIqpInfo.getTerm().toString():null);
		option.setApproveTermday("01".equals(lstIqpInfo.getTermTimeType())?lstIqpInfo.getTerm().toString():null);
		option.setApproveAmount(lstIqpInfo.getAmount());
		option.setApproveTerm(lstIqpInfo.getTerm());
		option.setApproveRepaymode(lstIqpInfo.getRepaymentMode());
		option.setRepaymode(lstIqpInfo.getRepaymentMode());
		option.setInsurAmount(lstIqpInfo.getCoverAmount());
		option.setCostRate(lstIqpInfo.getRate().divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP));
		iqpMeAuditOpinionMapper.insertSelective(option);
	}

	/**
	 * 根据身份证获取生日
	 *
	 * @param certNo
	 * @return
	 */
	private String getBirthdayByCertNo(String certNo) {
		String birthdayYear = certNo.substring(6, 10);
		String birthdayMonth = certNo.substring(10, 12);
		String birthdayDay = certNo.substring(12, 14);
		return birthdayYear + "-" + birthdayMonth + "-" + birthdayDay;
	}
	
	/**
	 * 发送异常邮件
	 */
	@Async
	public void pushEmail(String title, String remark, Exception e) {
		// 判断是否发送邮件
		if(!msxfProperties.isMailSend()) {
			logger.info("该环境不发送异常邮件");
			return;
		}
		StringBuffer content = new StringBuffer();
        content.append("============>接口:")
        	   .append("\n")
        	   .append(title)
        	   .append("\n")
        	   .append("============>业务数据:")
               .append("\n")
               .append(remark)
               .append("\n")
               .append("============>异常信息:")
               .append("\n")
               .append(ExceptionUtils.getStackTrace(e));
        emailPushService.pushMessage(msxfProperties.getMailTitle(), 
											content.toString(), 
											systemConfig.getValue("Error_Notice_Emails") , 
											null, 
											null);
	}
	
	/**
	 * 出单处理
	 * @param param 请求参数
	 * @param lstSerno 投保单流水号
	 */
	@Async
	public void lstInfo(String param,String lstSerno) {
		try {
			logger.info("开始出单异步处理，serno：{}，param：{}",lstSerno,param);
			MsxfPL2001Request request = JSONObject.parseObject(param, MsxfPL2001Request.class);
			LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectBySerno(lstSerno);
			lstInfo(request, lstIqpInfo);
		}catch (Exception e){
			logger.error(lstSerno + "==>lstInfo",e);
			// 发送邮件
			pushEmail("lstInfo", lstSerno + "\n" + param, e);
		}
		logger.info("{}完成出单异步处理",lstSerno);
		
	}
	
	/**
	 * 出单处理
	 * @param request
	 * @param lstIqpInfo
	 * @throws Exception 
	 */
	private void lstInfo(MsxfPL2001Request request, LstIqpInfo lstIqpInfo) throws Exception {
		
		insertLstOperDetailsStatus(lstIqpInfo.getIqpLoanSerno(), MsxfStatus.放款结果通知, "");
		
		// 插入决议表
		insertIqpMeAuditOpinion(lstIqpInfo);
		logger.info("{}插入决议表完成",lstIqpInfo.getSerno());
		
		// 7、组装生成分期保费计划数据
		Map<String, Object> map = getFeePlanMap(lstIqpInfo,request);
		logger.info("{}组装生成分期保费计划数据完成：{}",lstIqpInfo.getSerno(),JSON.toJSONString(map));
		//调用接口，生成分期保费计划
		JsonProtocol plan = commonService.installmentPlan(JSONObject.parseObject(JSON.toJSONString(map)));
		if(0 !=plan.getCode()) {
			throw new Exception(plan.getMessage());
		}
				
		// 8、调用接口,出保单号,出电子保单
		boolean listSerno = autoLstService.autoListSerno(lstIqpInfo.getSerno(), lstIqpInfo.getCoverageFee());
		logger.info("{}调用接口，出保单号，结果：{}",lstIqpInfo.getSerno(),listSerno);
		if(!listSerno) {
			throw new Exception("出保单号失败");
		}
		
		// 插入轨迹
		insertLstOperDetailsStatus(lstIqpInfo.getIqpLoanSerno(), MsxfStatus.已出单, "");

		// 9、生成台账 异步
		lstIqpInfo = lstIqpInfoMapper.selectBySerno(lstIqpInfo.getSerno());
		insertAccLoan(lstIqpInfo,request.getLoanNoExt(),request.getRepayPlanList().get(0).getDueDate());
		logger.info("{}完成生成台账 异步",lstIqpInfo.getSerno());
		
		// 10、生成还款计划
		insertAccMtdPlan(request.getLoanNoExt(),request.getRepayPlanList());
		logger.info("{}完成生成还款计划",lstIqpInfo.getSerno());
	}
	
	/**
	 * 生成还款计划
	 * @param loanNoExt
	 * @param repayPlanList
	 */
	private void insertAccMtdPlan(String loanNoExt, List<RepayPlan> repayPlanList) {
		List<AccMtdPlan> accMtdPlans = new ArrayList<>();
		for (RepayPlan repayPlan : repayPlanList) {
			AccMtdPlan accMtdPlan = new AccMtdPlan();
			accMtdPlan.setBillNo(loanNoExt); //借据号
			accMtdPlan.setPsPerdNo(Convert.toShort(repayPlan.getInstallment())); //期次号
			//还款日期 贷款起始日+贷款期限
			accMtdPlan.setPsDueDt(repayPlan.getDueDate());
			//本金
			accMtdPlan.setPsPrcpAmt(repayPlan.getPrincipal());
			//状态
			accMtdPlan.setRepayFlag("00");
			// 利息
			accMtdPlan.setPsNormIntAmt(repayPlan.getInterest());
			accMtdPlan.setInputId(MsxfConstant.MSXF_SYSTEM);
			accMtdPlan.setInputBrId(MsxfConstant.MSXF_ORG);
			//期供 = 本金+利息
			accMtdPlan.setPsInstmAmt(accMtdPlan.getPsPrcpAmt().add(accMtdPlan.getPsNormIntAmt()));
			accMtdPlan.setInputDate(DateUtils.getDate1());  // getDate
			
			accMtdPlans.add(accMtdPlan);
		}
		accMtdPlanMapper.insertBatch(accMtdPlans);
	}

	/**
	 * 组装生成分期保费计划数据
	 * @param request
	 * @param lstIqpInfo
	 * @return
	 */
	private Map<String, Object> getFeePlanMap(LstIqpInfo lstIqpInfo, MsxfPL2001Request request) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("LST_SERNO", lstIqpInfo.getSerno());//投保单业务流水号
		map.put("BILL_NO", request.getLoanNoExt());//借据号
		map.put("RATE", lstIqpInfo.getRate());//总费率
		map.put("PS_COVERAGE_FEE", lstIqpInfo.getCoverageFee());//总保费 元
		map.put("PERD_TOTAL", lstIqpInfo.getPeriod());//总分期数
		map.put("PS_DUE_DT", request.getLoanEffectiveTime());//放款日期 yyyy-MM-dd
		map.put("INPUT_ID", lstIqpInfo.getInputId());//录入人
		map.put("INPUT_BR_ID", lstIqpInfo.getMainBrId());//录入机构 //getMainBrId()
		map.put("COVER_SERNO", "");//投保单编号
		map.put("LIST_SERNO", "");//保单编号
		map.put("IQP_LOAN_SERNO", lstIqpInfo.getIqpLoanSerno());//调查流水号
		map.put("REPAYMENT_MODE", lstIqpInfo.getRepaymentMode());//还款方式 STD_ZB_REPAY_MODE
		map.put("PAY_MODE", lstIqpInfo.getPayWay());//支付方式 STD_FEE_REPAY_WAY
		map.put("PRE_CAL_WAY", "3");//保费分期计算策略 1平摊2按权重3按传入分期保费 99其它
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<RepayPlan> repayPlanList = request.getRepayPlanList();
		for (RepayPlan repayPlan : repayPlanList) {
			Map<String, Object> mapT = new HashMap<String, Object>();
			mapT.put("psCoverageFee", repayPlan.getPremium());
			mapT.put("psDueDate", repayPlan.getDueDate());
			list.add(mapT);
		}
		String dueDate = repayPlanList.get(0).getDueDate();
		map.put("REPAYMENT_DAY", dueDate.substring(dueDate.length()-2, dueDate.length()));//指定每月还款日
		map.put("PS_FEE_INFO_ARR", list);
		return map;
	}

	/**
	 * 生成台账
	 * @param lstIqpInfo
	 * @param dueDate
	 * @param dueDate 
	 */
	private void insertAccLoan(LstIqpInfo lstIqpInfo, String billNo, String dueDate) {
		AccLoan accLoan = new AccLoan();
		accLoan.setBillNo(billNo);
		accLoan.setContNo(lstIqpInfo.getContNo());
		accLoan.setCnContNo(lstIqpInfo.getContNo());
		accLoan.setBizType(lstIqpInfo.getPrdId());
		accLoan.setPrdName(lstIqpInfo.getPrdName());
		accLoan.setCusId(lstIqpInfo.getCusId());
		accLoan.setCusName(lstIqpInfo.getCusName());
		accLoan.setAssureMeansMain(lstIqpInfo.getAssureMeansMain());
		accLoan.setCurType(lstIqpInfo.getCoverCurrencyType());
		accLoan.setLoanAmount(lstIqpInfo.getAmount());
		accLoan.setLoanBalance(lstIqpInfo.getAmount());
		accLoan.setRulingIr(lstIqpInfo.getGrossRate());
		accLoan.setFloatingRate(new BigDecimal(0));
		accLoan.setRealityIrY(lstIqpInfo.getGrossRate());
		accLoan.setRepaymentMode(lstIqpInfo.getRepaymentMode());
		accLoan.setCusManager(lstIqpInfo.getMgrId());
		accLoan.setInputBrId(lstIqpInfo.getMainBrId());
		accLoan.setMainBrId(lstIqpInfo.getMainBrId());
		accLoan.setAccountStatus("1");
		accLoan.setFrequency("M");
		accLoan.setLoanStartDate(lstIqpInfo.getLoanStartDate());
		
		String dueDay = dueDate.substring(dueDate.length()-2, dueDate.length());
		accLoan.setDueDay(Convert.toBigDecimal(dueDay));//还款日
		accLoan.setLoanEndDate(lstIqpInfo.getLoanEndDate());
		accLoan.setListSerno(lstIqpInfo.getListSerno());
		accLoan.setIqpLoanSerno(lstIqpInfo.getIqpLoanSerno());
		accLoan.setPartnerNo(lstIqpInfo.getReceiverCusId());
		accLoan.setPartnerName(lstIqpInfo.getReceiveCusName());
		accLoan.setCertType(lstIqpInfo.getCertType());
		accLoan.setCertCode(lstIqpInfo.getCertCode());
		accLoan.setInputId(lstIqpInfo.getInputId());
		accLoan.setInputTime(DateUtils.getDate());
		accLoan.setEffectStatus("1");
		accLoan.setEffectDate(DateUtils.getDate1());
		accLoan.setReExploreDate(DateUtils.getDate1());
		accLoan.setPreventRate(lstIqpInfo.getExcuseRate());
		accLoan.setTerm(lstIqpInfo.getTerm());
		accLoan.setTermType(lstIqpInfo.getTermTimeType());
		accLoanMapper.insertSelective(accLoan);
	}
	
	/**
	 * 逻辑为马上金融贷款状态和华安贷款状态不一致或者马上金融逾期天数和华安逾期天数不一致
	 * @param accLoan
	 * @param msxfAccLoanInfo
	 */
	@Async
	public void compareStatus(AccLoan accLoan, MsxfAccLoanInfo msxfAccLoanInfo) {
		try {
			boolean flag = Convert.toShort(accLoan.getOverTimesDays(),Short.valueOf("0")).compareTo(msxfAccLoanInfo.getOverdueDays()) == 0
					&& StringUtils.equals(accLoan.getAccountStatus(), MsxfLoanStatus.getHaStatue(msxfAccLoanInfo.getTxnStatus()));
			if(!flag) {
				
				PartnerBusiImportDetail busiImportDetail = partnerBusiImportDetailMapper.selectByReqListSerno(accLoan.getBillNo());
				
				TempLoanInfo record = new TempLoanInfo();
				record.setUuid(UUID32.getUUID());
				record.setPolicyNo(accLoan.getListSerno());
				record.setLnAcct(accLoan.getBillNo());
				record.setApplNo(busiImportDetail.getReqSeqNo());
				record.setRecoveryDate(Convert.toStr(msxfAccLoanInfo.getOverdueDays()));
				record.setLnState(MsxfConstant.MSXF + msxfAccLoanInfo.getTxnStatus());
				// 结清日期
				if(StringUtils.equals(msxfAccLoanInfo.getTxnStatus(), MsxfLoanStatus.提前结清.getMsStatus())
						|| StringUtils.equals(msxfAccLoanInfo.getTxnStatus(), MsxfLoanStatus.结清.getMsStatus())
						|| StringUtils.equals(msxfAccLoanInfo.getTxnStatus(), MsxfLoanStatus.理赔结清.getMsStatus())) {
					record.setLnOvDate(msxfAccLoanInfo.getBusinessDate());
				}
//			record.setDueOvDate(dueOvDate);
				record.setSource(MsxfConstant.MSXF);
				record.setBusinessType(MsxfConstant.MSXF);
				record.setCreatedBy(MsxfConstant.MSXF_SYSTEM);
				tempLoanInfoMapper.insertSelective(record );
			}
		} catch (Exception e) {
			logger.error(accLoan.getBillNo() + "==>compareStatus",e);
		}
	}
	
	/**
	 * 插入退保记录
	 * @param billNo 借据号
	 * @param listSerno 保单号
	 * @param txStatus 马上借据状态
	 */
	@Async
	public void insertLstSettleInfo(String billNo,String listSerno,String txStatus) {
		LstSettleInfo record = new LstSettleInfo();
		record.setBillNo(billNo);
		record.setListSerno(listSerno);
		record.setAccStatus(txStatus);
		record.setSources(MsxfConstant.MSXF);
		record.setInputDate(DateUtils.getDate());
		lstSettleInfoMapper.insertSelective(record );
	}
	
	/**
	 * 退保
	 * @param listSerno 保单
	 * @param fee 退保后的总保费
	 */
	public void settleLst(String listSerno,BigDecimal fee) {
		try {
			// 先等待前面的事务提交
			Thread.sleep(1000l);
			
			//调退保接口
			JSONObject jsonReq = new JSONObject();
			jsonReq.put("surrenderType", "0"); // 3-提前还款,(信保平安共保使用）
//			jsonReq.put("cmisFlag", "2"); // 1-共保  2-独保
			jsonReq.put("sumGrossPremium", fee);// 总保险费(退保后)
			jsonReq.put("requestType", "0");// 请求类型: 0 表示还没有批改保费计算，保费计算由服务器负责； 1 表示已保费计算
			jsonReq.put("policyNo", listSerno);
//			jsonReq.put("surrenderNo", listSerno);// 期次

			JSONObject bankInfo = new JSONObject();
			bankInfo.put("accountName","马上消费金融股份有限公司");//帐户名称
			bankInfo.put("accountNo","699986325"); //银行账号
			bankInfo.put("payeeBankCityCode","6530");//开户银行省市代码
			bankInfo.put("payeeBankCity","重庆市_重庆市");//开户银行省市
			bankInfo.put("payeeBankCode","305");//收款方银行编码
			bankInfo.put("payeeBankName","中国民生银行");//收款方银行名称
			bankInfo.put("bankCode","305653011017");//开户银行名称代码
			bankInfo.put("bankBranchName","中国民生银行股份有限公司重庆分行营业部");//收款人开户银行名称
			jsonReq.put("bankInfo",bankInfo);

			logger.info("{}保单进行退保，请求参数：{}",listSerno,jsonReq.toJSONString());
			JsonProtocol protocol = commonService.policySurrender(jsonReq);
			logger.info("{}保单进行退保，返回结果：{}",listSerno,JSON.toJSON(protocol));
			
			if(0 != protocol.getCode()) {
				throw new Exception(protocol.getMessage());
			}
		} catch (Exception e) {
			logger.error(listSerno + "保单进行退保异常",e);
			pushEmail(MsxfConstant.MSXF + "退保", listSerno, e);
		}
	}
}
