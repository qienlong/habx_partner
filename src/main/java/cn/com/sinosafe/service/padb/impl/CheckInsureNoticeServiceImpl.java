package cn.com.sinosafe.service.padb.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.com.sinosafe.common.config.constant.FieldConversionUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.*;
import cn.com.sinosafe.domain.bean.*;
import cn.com.sinosafe.domain.entity.*;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosafe.common.config.constant.CheckIssueResultEnum;
import cn.com.sinosafe.common.config.constant.CommonConstant;
import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.CommonUtils;
import cn.com.sinosafe.service.padb.CheckInsureConFirmService;
import cn.com.sinosafe.service.padb.CheckInsureNoticeService;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import net.sf.json.JSONObject;

/**
 * @ClassName:：CheckInsureNoticeServiceImpl @Description： 平安核保通知
 * @author ：pengll
 * @date ：2019年6月3日 下午2:41:16
 */
@Service
public class CheckInsureNoticeServiceImpl implements CheckInsureNoticeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;

	@Autowired
	private IqpMeCusAppMapper iqpMeCusAppMapper;

	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;

	@Autowired
	private CusIndivMapper cusIndivMapper;

	@Autowired
	private CusBaseMapper cusBaseMapper;
	
	@Autowired
	private AsyncDealService asyncDealService;

	@Autowired
	private IqpMeAuditOpinionMapper iqpMeAuditOpinionMapper;

	@Autowired
	private FeeRateMapper feeRateMapper;

	@Autowired
	private CheckInsureConFirmService confirmService;

	@Autowired
	private PaPhCommonService paPhCommonService;

	@Autowired
	private PrjCopAccMapper prjCopAccMapper;

	/**
	 * 
	* @Title：CheckInsureNotice
	* @Description：核保通知
	* @param ：平安请求参数paramMap
	* @return ：String 
	* @throws
	*/

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String checkInsureNotice(Map<String, Object> paramMap) throws Exception {
		logger.info("-------开始调用核保通知接口--------");
		// 默认返回成功
//		PaResultCode code = PaResultCode.PA_SUCCESS;// 返回状态码
		String resultCode = PaResultCode.PA_SUCCESS.code();// 返回状态码
		String resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
		Map<String, String> resultMap=new HashMap<String, String>();
//		String message = "";
		String applNo = "";
		// 检验字段必输
		try {
			String[] needField = { "applNo", "coverNo", "custName", "idType", "id", "mobile", "endIdDate", "lnAmt",
					"nosInst", "maritalStatus", "highestEducation", "homeAddr", "basicSalary","riskLevel",
                    "loanPurpose", "paymentMethod", "policyHolderName", "policyHolderIdType",
					"policyHolderId", "insureOfName", "insureRateCode", "approveResult", "insuCompany",
					"source" };
			boolean flag = LstIqpApplyConstant.checkFieldDefect(paramMap, needField);
			BigDecimal bigdecimal0 = new BigDecimal("0.00");
			BigDecimal coverageAmonut = new BigDecimal("0.00");
			BigDecimal coverageFee = new BigDecimal("0.00");
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String status = "";// 审批状态
			String newApproveStatus=""; //
			if (flag == true) { // 字段缺失
//				code = PaResultCode.PA_FIELD_DELETION;
//				message = PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
				resultCode=PaResultCode.PA_FIELD_DELETION.code();
				resultMsg=PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
			} else {
				FeeRate feeRate1 = new FeeRate();
				String feeCode = paramMap.get("insureRateCode").toString();// 平安费率码值即为华安费率码值
				feeRate1.setFeeCode(feeCode);
				FeeRate feeRate2 = new FeeRate();
				feeRate2 = feeRateMapper.queryFeeRateInfo(feeRate1);// 查询费率信息
				BigDecimal feeRate = new BigDecimal("0.00");// 保费费率
				if(feeRate2!=null && !"".equals(feeRate2.getFeeRate())) {
					feeRate = new BigDecimal(feeRate2.getFeeRate());//华安保费费率
				}
				// 获取申请号
				applNo = paramMap.get("applNo").toString();
				logger.info("-------核保通知接口申请号为" + applNo);
				// 根据申请号校验存在该笔数据，且当前这笔数据是已完成签署投保单行为
				LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByIqpLoanSerno(applNo);
				if (lstIqpInfo == null) {
					logger.info("-------申请号为" + applNo + "保单信息不存在或未签署");
//					code = PaResultCode.PA_FAIL;
//					message = "该笔保单信息不存在或未签署";
					resultCode=PaResultCode.PA_FAIL.code();
					resultMsg ="该笔保单信息不存在或未签署";
				} else {
					String approveResult = paramMap.get("approveResult").toString();// 平安审批结果
	
					// 根据校验规则进行核保确认
					String checkResult = confirmService.checkIqpInfo(new BigDecimal(paramMap.get("lnAmt").toString()),
							paramMap.get("id").toString(), approveResult);
	
					String remark = "";// 备注
					String checkNo =  "PAPH"+CommonUtils.getDateTime();//核保单号
					boolean approveflag = true;// 默认核保成功
					if (CommonConstant.HUAAN_APPROVE.equals(checkResult)) { // 核保成功
						coverageAmonut = (new BigDecimal(paramMap.get("lnAmt").toString()).multiply(new BigDecimal("1.08"))).setScale(2, BigDecimal.ROUND_HALF_UP);// 保额合计保留两位小数
						coverageFee = (new BigDecimal(paramMap.get("lnAmt").toString()).multiply(new BigDecimal(feeRate2.getPaFeeRate())).multiply(new BigDecimal(0.99)).multiply(new BigDecimal(0.01))).setScale(2, BigDecimal.ROUND_HALF_UP);// 保额合计保留两位小数
						coverageFee = coverageFee.multiply(new BigDecimal(paramMap.get("nosInst").toString()));
						status = CommonConstant.APPROVAL_SUCCESS;
						newApproveStatus=CommonConstant.NEW_APPROVAL_SUCCESS;
					} else {
						approveflag = false;// 核保拒绝
						status = CommonConstant.APPROVAL_REJECT;
						newApproveStatus=CommonConstant.NEW_APPROVAL_REJECT;
						remark = CheckIssueResultEnum.getTemplate(checkResult);
					}
	
					// ----------------------------------------------------------------------------------start
					try {
						// 1、更新保单表
						logger.info("--------更新保单表--------");
						String highestEducation = null;
						String maritalStatus="";
						if("其他(未知)".equals(paramMap.get("highestEducation").toString())){
							highestEducation="99";
						}else {
							highestEducation = feeRateMapper.querySdicForEnname(paramMap.get("highestEducation").toString(),"STD_EDU_TYPE");
						}
						if("已婚".equals(paramMap.get("maritalStatus").toString()) || "再婚".equals(paramMap.get("maritalStatus").toString())){
							maritalStatus="20";
						}else {
							maritalStatus = feeRateMapper.querySdicForEnname(paramMap.get("maritalStatus").toString(),"STD_ZX_MARR_STATUS");
						}
						PrjCopAcc prjCopAcc = prjCopAccMapper.selectByCopCusName(paramMap.get("insureOfName").toString());
						LstIqpInfo lstIqpInfo2 = new LstIqpInfo();
						if(StringUtils.isNotNull(prjCopAcc)) {
							lstIqpInfo2.setReceiveCusName(prjCopAcc.getCopCusName());
							lstIqpInfo2.setReceiverCusId(prjCopAcc.getCopCusId());
							lstIqpInfo2.setReceiveCusPhone(prjCopAcc.getCopPhone());
							lstIqpInfo2.setReceiveCusCertType(prjCopAcc.getCopCertType());
							lstIqpInfo2.setReceiveCusCertCode(prjCopAcc.getCopCertCode());
							lstIqpInfo2.setReceiverCusAddress(prjCopAcc.getAddrPle());
						}
						lstIqpInfo2.setSerno(paramMap.get("coverNo").toString());// 信保业务流水号
//						lstIqpInfo2.setCoverSerno(paramMap.get("coverNo").toString());// 投保单编号
						lstIqpInfo2.setCusName(paramMap.get("custName").toString());//客户姓名
						lstIqpInfo2.setCertType(FieldConversionUtils.getIdType().get(paramMap.get("idType").toString()));// 客户证件类型
						lstIqpInfo2.setCertCode(paramMap.get("id").toString());//身份证号
//						lstIqpInfo2.setMobile(paramMap.get("mobile").toString());//手机号码
						lstIqpInfo2.setIndivMarSt(maritalStatus);// 婚姻状况
						lstIqpInfo2.setAddress(paramMap.get("homeAddr").toString());// 家庭地址
						lstIqpInfo2.setIndivComAddr(paramMap.get("workAddr") != null ? paramMap.get("workAddr").toString() : "");// 单位地址
                        lstIqpInfo2.setIspermit("1");//是否签署授权书
						lstIqpInfo2.setMtIndustryType(paramMap.get("companyIndustry") != null ? paramMap.get("companyIndustry").toString() : "");//单位所属行业
						lstIqpInfo2.setTelephone(paramMap.get("companyTel") != null ? paramMap.get("companyTel").toString() : "");// 单位电话
						lstIqpInfo2.setStatus(status);// 保单状态
						lstIqpInfo2.setApplyStatus(status);//投保单申请状态
						if (approveflag == true) { // 核保通过
							lstIqpInfo2.setContNo(checkNo);//核保单号
							lstIqpInfo2.setAmount(new BigDecimal(paramMap.get("lnAmt").toString()));// 审批贷款金额
							lstIqpInfo2.setTerm(paramMap.get("nosInst").toString());// 审批贷款期限
							lstIqpInfo2.setCoverAmount(coverageAmonut);//保额合计
							lstIqpInfo2.setCoverCurrencyType("CNY");//保额币种
							lstIqpInfo2.setCoverageFee(coverageFee);//保费合计
							lstIqpInfo2.setFeeCurrencyType("CNY");//保费币种
                            lstIqpInfo2.setEveryPremRate(String.valueOf(new BigDecimal(feeRate2.getFeeRate()).divide(new BigDecimal(100))));
                            lstIqpInfo2.setFirstPremRate(String.valueOf(new BigDecimal(feeRate2.getFeeRate()).divide(new BigDecimal(100))));
//                            lstIqpInfo2.setnProProp(feeRate);//华安保费费率 字段为项目系数 暂存华安保费费率
							lstIqpInfo2.setRate(coverageFee.divide(coverageAmonut,4, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)));//实际费率

						}
						lstIqpInfo2.setRepaymentMode(FieldConversionUtils.getPaymentMethod().get(paramMap.get("paymentMethod").toString()));//还款方式
						lstIqpInfo2.setcRiskLvlCde(paramMap.get("riskLevel") != null ? paramMap.get("riskLevel").toString() : "");//风险等级
						lstIqpInfo2.setLastUpdId("admin");//更新人
						lstIqpInfo2.setLastUpdDate(date);//更新时间
						lstIqpInfo2.setExcuseRate(new BigDecimal(1));//免赔率（华安数据库单位为%）
						lstIqpInfoMapper.updateByPrimaryKeySelective(lstIqpInfo2);
		
						// 2、更新客户申请信息表
						logger.info("--------更新客户申请信息表--------");
						IqpMeCusApp iqpMeCusApp = new IqpMeCusApp();
						iqpMeCusApp.setSerno(applNo);// 申请号
						iqpMeCusApp.setCusName(paramMap.get("custName").toString());//客户姓名
						iqpMeCusApp.setCertType(FieldConversionUtils.getIdType().get(paramMap.get("idType").toString()));// 客户证件类型
						iqpMeCusApp.setCertCode(paramMap.get("id").toString());//身份证号
//						iqpMeCusApp.setMobile(paramMap.get("mobile").toString());//手机号码
						iqpMeCusApp.setIndivSpsIdEndDate(paramMap.get("endIdDate").toString());// 身份证有效截至日期
						iqpMeCusApp.setIndivMarSt(maritalStatus);// 婚姻状况
						iqpMeCusApp.setIndivEdt(highestEducation);// 最高学历
						iqpMeCusApp.setIndivRsdAddr(paramMap.get("homeAddr").toString());// 家庭地址
						iqpMeCusApp.setIndivComAddr(paramMap.get("workAddr") != null ? paramMap.get("workAddr").toString() : "");// 工作地址
						iqpMeCusApp.setIndivBrtPlace(paramMap.get("hukouAddress") != null ? paramMap.get("hukouAddress").toString() : "");// 户籍地址
						iqpMeCusApp.setIndivComName(
								paramMap.get("companyName") != null ? paramMap.get("companyName").toString() : "");// 单位名称
						iqpMeCusApp.setIndivComTyp(
								paramMap.get("companyType") != null ? paramMap.get("companyType").toString() : "");// 单位性质
						iqpMeCusApp.setIndivCllId(
								paramMap.get("companyIndustry") != null ? paramMap.get("companyIndustry").toString() : "");// 单位所属行业
						iqpMeCusApp.setIndivComPhn(
								paramMap.get("companyTel") != null ? paramMap.get("companyTel").toString() : "");// 单位电话
						iqpMeCusApp.setHouseType(paramMap.get("houseRights") != null ? paramMap.get("houseRights").toString() : "");//房产类型
						iqpMeCusApp.setHouseAddr(paramMap.get("homeAddr") != null ? paramMap.get("homeAddr").toString() : "");// 房产地址
						iqpMeCusApp.setIndivSpsName(paramMap.get("spouseName") != null ? paramMap.get("spouseName").toString() : "");//配偶姓名
						iqpMeCusApp.setIndivSpsMphn(paramMap.get("spouseMobile") != null ? paramMap.get("spouseMobile").toString() : "");//配偶手机号
//						iqpMeCusApp.setLiabilities(paramMap.get("verifyLiab") != null ? new BigDecimal(paramMap.get("verifyLiab").toString()) : new BigDecimal(0.00));//核实负债
						if(paramMap.get("verifyLiab") == null || "".equals(paramMap.get("verifyLiab"))){
							iqpMeCusApp.setLiabilities(new BigDecimal(0.00));
						}else {
							iqpMeCusApp.setLiabilities(new BigDecimal(paramMap.get("verifyLiab").toString()));
						}
//						iqpMeCusApp.setFamMeans(paramMap.get("verifyIncome") != null ? new BigDecimal(paramMap.get("verifyIncome").toString()) : new BigDecimal(0.00));//核实收入
						if(paramMap.get("verifyIncome") == null || "".equals(paramMap.get("verifyIncome"))){
							iqpMeCusApp.setFamMeans(new BigDecimal(0.00));
						}else {
							iqpMeCusApp.setFamMeans(new BigDecimal(paramMap.get("verifyIncome").toString()));
						}
						iqpMeCusApp.setEmail(paramMap.get("email") != null ? paramMap.get("email").toString() : "");//电子邮箱
						iqpMeCusAppMapper.updateByPrimaryKeySelective(iqpMeCusApp);

						// 3、更新投保申请信息表
						logger.info("--------更新投保申请信息表--------");
						IqpMeLoanApp iqpMeLoanApp = new IqpMeLoanApp();
						iqpMeLoanApp.setSerno(applNo);// 申请号
						iqpMeLoanApp.setCusName(paramMap.get("custName").toString());//客户姓名
						iqpMeLoanApp.setCertType(FieldConversionUtils.getIdType().get(paramMap.get("idType").toString()));// 客户证件类型
						iqpMeLoanApp.setCertCode(paramMap.get("id").toString());//身份证号
//						iqpMeLoanApp.setPhone(paramMap.get("mobile").toString());//手机号码
						iqpMeLoanApp.setCostRate(feeRate);//费率
						iqpMeLoanApp.setLoanUse(FieldConversionUtils.getTempInfo().get(paramMap.get("loanPurpose").toString()));// 贷款用途
						iqpMeLoanApp.setRepaymentMode(FieldConversionUtils.getPaymentMethod().get(paramMap.get("paymentMethod").toString()));// 还款方式
						iqpMeLoanApp.setApproveStatus(status);// 审批状态
						iqpMeLoanApp.setRefuseReason(remark);// 拒绝原因
						iqpMeLoanApp.setApplyAmount(new BigDecimal(paramMap.get("lnAmt").toString()));
						iqpMeLoanApp.setInsureRateCode(paramMap.get("insureRateCode").toString());//费率码值
						//基本月薪x12=年收入 更新于2019/9/19/11:00:19
						iqpMeLoanApp.setGuarantorIncm(new BigDecimal(paramMap.get("basicSalary").toString()).multiply(new BigDecimal("12")));
						if(StringUtils.isNotNull(prjCopAcc)){
							iqpMeLoanApp.setPartnerNo(prjCopAcc.getCopNo());//合作方编号
							iqpMeLoanApp.setPartnerName(prjCopAcc.getCopCusName());//合作方名称
							iqpMeLoanApp.setPartnerType(prjCopAcc.getCopCusType());//合作方类型
							iqpMeLoanApp.setPartnerCertType(prjCopAcc.getCopCertType());//合作方证件类型
							iqpMeLoanApp.setPartnerCertCode(prjCopAcc.getCopCertCode());//合作方证件号
						}
						iqpMeLoanAppMapper.updateByPrimaryKeySelective(iqpMeLoanApp);
		
						// 4、更新对私客户信息表
						logger.info("--------更新对私客户信息表--------");
						CusIndiv cusIndiv = new CusIndiv();
						cusIndiv.setCusId(lstIqpInfo.getCusId());// 客户号
						cusIndiv.setCusName(paramMap.get("custName").toString());//客户姓名
						cusIndiv.setCertType(FieldConversionUtils.getIdType().get(paramMap.get("idType").toString()));// 客户证件类型
						cusIndiv.setCertCode(paramMap.get("id").toString());//身份证号
//						cusIndiv.setMobile(paramMap.get("mobile").toString());//手机号码
						cusIndiv.setIndivIdExpDt(paramMap.get("endIdDate").toString());// 身份证有效截止日期
						cusIndiv.setIndivEdt(highestEducation);// 最高学历
						cusIndiv.setIndivMarSt(maritalStatus);// 婚姻状况
//						cusIndiv.setIndivEdt(paramMap.get("highestEducation").toString());// 最高学历
						cusIndiv.setIndivRsdAddr(paramMap.get("homeAddr").toString());// 家庭地址
						cusIndiv.setIndivComAddr(paramMap.get("workAddr") != null ? paramMap.get("workAddr").toString() : "");// 工作地址
						cusIndiv.setIndivBrtPlace(paramMap.get("hukouAddress") != null ? paramMap.get("hukouAddress").toString() : "");// 户籍地址
						cusIndiv.setIndivComName(
								paramMap.get("companyName") != null ? paramMap.get("companyName").toString() : "");// 单位名称
						cusIndiv.setIndivComTyp(
								paramMap.get("companyType") != null ? paramMap.get("companyType").toString() : "");// 单位性质
						cusIndiv.setIndivComPhn(
								paramMap.get("companyTel") != null ? paramMap.get("companyTel").toString() : "");// 单位电话
						cusIndiv.setIndivSpsName(paramMap.get("spouseName") != null ? paramMap.get("spouseName").toString() : "");// 配偶姓名
						cusIndiv.setIndivSpsMphn(
								paramMap.get("spouseMobile") != null ? paramMap.get("spouseMobile").toString() : "");// 配偶手机号
						cusIndiv.setEmail(paramMap.get("email") != null ? paramMap.get("email").toString() : "");//电子邮箱
						cusIndivMapper.updateByPrimaryKeySelective(cusIndiv);
		
						// 5、 更新对私对公客户基表
						logger.info("--------更新对私对公客户基表--------");
						CusBase cusBase = new CusBase();
						cusBase.setCusId(lstIqpInfo.getCusId());// 客户号
						cusBase.setCusName(paramMap.get("custName").toString());//客户姓名
						cusBase.setCertType(FieldConversionUtils.getIdType().get(paramMap.get("idType").toString()));// 客户证件类型
						cusBase.setCertCode(paramMap.get("id").toString());//身份证号
						cusBaseMapper.updateByPrimaryKeySelective(cusBase);
		
						// 6、更新审批信息表
						logger.info("--------更新审批信息表--------");
						IqpMeAuditOpinion iqpMeAuditOpinion = new IqpMeAuditOpinion();
						iqpMeAuditOpinion.setSerno(applNo);// 申请号
						iqpMeAuditOpinion.setCusId(lstIqpInfo.getCusId());// 客户号
						iqpMeAuditOpinion.setApproveAmount(new BigDecimal(paramMap.get("lnAmt").toString()));// 审批贷款金额
						iqpMeAuditOpinion.setApproveTerm(paramMap.get("nosInst").toString());// 审批贷款期限
						iqpMeAuditOpinion.setInsurAmount(coverageAmonut);//保险金额
						iqpMeAuditOpinion.setCostRate(feeRate);//费率
						iqpMeAuditOpinion.setLoanUseType(FieldConversionUtils.getTempInfo().get(paramMap.get("loanPurpose").toString()));//贷款用途
						iqpMeAuditOpinion.setRepaymode(FieldConversionUtils.getPaymentMethod().get(paramMap.get("paymentMethod").toString()));//还款方式
						iqpMeAuditOpinion.setApproveOpinion(status);// 审批意见
						iqpMeAuditOpinion.setApproveOpinionDetails(remark);
						iqpMeAuditOpinion.setApproveId("admin");//审批人ID
						iqpMeAuditOpinion.setApproveName("admin");//审批人姓名
						iqpMeAuditOpinion.setApproveOperaDate(date);//审批日期
						iqpMeAuditOpinionMapper.updateBySernoAndCustIdSelective(iqpMeAuditOpinion);
		
						logger.info("-------------更新业务状态表和轨迹表------------");
						paPhCommonService.statusUpdateService(applNo, newApproveStatus, remark);
					}catch (Exception e) {
						logger.error("更新业务表失败"+e.getMessage());
						throw new BusinessException(e.getMessage());
					}
					// ----------------------------------------------------------------------------------end
	
					// 调用核保确认接口发送给平安普惠
					logger.info("------------调用核保确认接口发送给平安普惠---------start");
					Map<String, Object> hashmap = new HashMap<String, Object>();
					hashmap.put("applNo", applNo);// 申请号
					if (approveflag == true) { // 核保成功
						hashmap.put("checkNo",checkNo);// 核保单号
						hashmap.put("policyResult", CommonConstant.CHECK_SUCCESS);// 核保结果-通过
						hashmap.put("insuredTotalAmt", coverageAmonut);// 承保总金额
						hashmap.put("insureRate", feeRate);// 保费费率
						hashmap.put("insureRateCode", feeCode);// 保费费率码值
	
					} else {
						hashmap.put("policyResult", CommonConstant.CHECK_REJECT);// 核保结果-拒绝
						hashmap.put("failReason", checkResult);// 核保结果
					}
					hashmap.put("insuCompany", "HABX");// 保险公司合作方
	
					//发送核保拒绝短信给客户
					if (CommonConstant.CHECK_REJECT.equals(hashmap.get("policyResult"))) { // 核保拒绝
						// 发送核保拒绝短信给客户
						Map<String, String> paramMaps = new HashMap<String, String>();
						if(StringUtils.isNotEmpty(lstIqpInfo.getPrdSubCode())) {
							paramMaps.put("{0521险种名称}", lstIqpInfo.getPrdSubCode());// 险种名称
						}
						paPhCommonService.pushSms(SmsTemplateEnum.UNDERWRITING.code(), paramMaps,
								lstIqpInfo.getMobile());
	
					}
					//异步调用核保确认接口发送给平安普惠
					logger.info("-------异步调用核保确认接口发送给平安普惠-------");
					String resonseMessage = asyncDealService.sendCheckIssueResult(hashmap);
					logger.info("------核保确认接口平安返回报文"+resonseMessage);
				}
			}
		} catch (Exception e) {
			logger.error("errorInfo:"+e.getMessage());
			throw new BusinessException(e.getMessage());
		}
//		PaResult paResult = PaResultGenerator.getDefMsgByCode(code, message);
//		String result = JSONObject.fromObject(paResult).toString();
		resultMap.put("resultCode",resultCode);
		resultMap.put("resultMsg",resultMsg);
		String result=JSON.toJSONString(resultMap);
		// 插入请求响应日志
		paPhCommonService.insertBizLog(applNo, "FCFPBX1001B", JSONObject.fromObject(paramMap).toString(), result);
		return result;

	}

}
