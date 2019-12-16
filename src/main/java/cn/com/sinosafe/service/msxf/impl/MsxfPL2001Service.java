package cn.com.sinosafe.service.msxf.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.exception.ParamException;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.SequenceUtil;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.IqpMeChannelPrdMapper;
import cn.com.sinosafe.dao.IqpMeCusAppMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.PartnerBusiImportDetailMapper;
import cn.com.sinosafe.dao.PrjCopAccMapper;
import cn.com.sinosafe.domain.bean.MsxfStatus;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.IqpMeChannelPrd;
import cn.com.sinosafe.domain.entity.IqpMeCusApp;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PartnerBusiImportDetail;
import cn.com.sinosafe.domain.entity.PrjCopAcc;
import cn.com.sinosafe.domain.msxf.RepayPlan;
import cn.com.sinosafe.domain.msxf.request.MsxfPL2001Request;
import cn.com.sinosafe.service.msxf.MsxfBaseService;

/**
 * 
 * 马上消费--放款结果通知（承保申请）<br>
 * 
 * @Author : ganyingying <br>
 * @Date : 2019年9月2日<br>
 */
@Service(MsxfConstant.MSXF_PL2001)
public class MsxfPL2001Service extends MsxfBaseService {
	@Autowired
	private PartnerBusiImportDetailMapper partnerBusiImportDetailMapper;
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private IqpMeCusAppMapper iqpMeCusAppMapper;
	@Autowired
	private IqpMeChannelPrdMapper iqpMeChannelPrdMapper;
	@Autowired
	private PrjCopAccMapper prjCopAccMapper;

//	@Transactional(rollbackFor = Exception.class)
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		
		// 解密
		String reqStr = decrypt(param);
		logger.info("[{}]请求参数解密后：{}",MsxfConstant.MSXF_PL2001, reqStr);
		//请求参数判空
        if (StringUtils.isEmpty(reqStr)) {
            throw new ParamException("请求参数不能为空!");
        }
		
		MsxfPL2001Request request = JSONObject.parseObject(reqStr, MsxfPL2001Request.class);
		if (StringUtils.isNull(request)) {
            throw new ParamException("请求参数不能为空!");
        }

		// 校验参数(非空)
		checkParams(request);
		
		// 校验渠道代码
		iqpMeApiCop = iqpMeApiCopMapper.selectByAccid(MsxfConstant.MSXF);
		if(!StringUtils.equals(request.getChannelCode(), iqpMeApiCop.getCopNo())) {
			throw new ParamException("渠道代码错误!");
		}
		
		// 1、校验业务流水号和外部订单号是否对应
		PartnerBusiImportDetail busiImportDetail = partnerBusiImportDetailMapper.selectByPrimaryKey(request.getPreInsuranceNo());
		if (StringUtils.isNull(busiImportDetail)) {
			throw new ParamException("投保单号/业务流水号不存在!");
		}
		//查询是否已存在保单表，已存在返回重复申请
		LstIqpInfo selectByIqpLoanSerno = lstIqpInfoMapper.selectByIqpLoanSerno1(busiImportDetail.getSerno());
		if (StringUtils.isNotNull(selectByIqpLoanSerno)) {
			throw new ParamException("投保单号重复申请！");
		}
		
		// 2、校验业务流水号状态是否为997成功
		IqpMeLoanApp iqpMeLoanApp = iqpMeLoanAppMapper.selectByPrimaryKey(busiImportDetail.getSerno());
		if (!StringUtils.equals(MsxfConstant.PASS, iqpMeLoanApp.getAppStatus())) {
			throw new ParamException("核保状态为拒绝!");
		}
		
		MsxfResponse msxfResponse = MsxfResponse.CODE_0000;
		// 3、判断放款状态,成功才向下执行
		if (!StringUtils.equals("LOAN_SUCCESS", request.getLoanResult())) {
			// 放款失败，更新业务状态为拒绝
			doFailure(busiImportDetail, iqpMeLoanApp);
			msxfResponse.setMsg("请求订单放款失败");
			return msxfResponse;
		}
		
		// 4、放款成功后必填参数校验
		checkPlan(request);
		//放款成功后数据校对
		checkValues(iqpMeLoanApp,request);
		
		//5、查询申请客户表 IqpMeCusApp,cus_indiv(客户信息表)
		IqpMeCusApp iqpMeCusApp = iqpMeCusAppMapper.selectByPrimaryKey(busiImportDetail.getSerno());
		//6、判断request.getRecognizeeName() 被保险人是否合法
		PrjCopAcc prjCopAcc = prjCopAccMapper.selectByPrimaryKey(request.getRecognizeeCode());
		if(StringUtils.isNull(prjCopAcc)) {
			throw new ParamException("被保险人不合法!");
		}
		
		//渠道产品特别约定配置表
		IqpMeChannelPrd iqpMeChannelPrd = iqpMeChannelPrdMapper.selectByFields(iqpMeApiCop.getCopNo(), request.getProductCode(),prjCopAcc.getCopNo());
		if(StringUtils.isNull(iqpMeChannelPrd)) {
			throw new ParamException("特别约定配置不存在!");
		}
		
		// 放款成功处理，生成投保单、保费计划、出单、台账
		request.setLoanNoExt(busiImportDetail.getReqListSerno());
		doLoanSuccess(reqStr,request, iqpMeLoanApp, iqpMeCusApp,prjCopAcc,iqpMeChannelPrd);
		
		return msxfResponse;
	}


	private void checkValues(IqpMeLoanApp iqpMeLoanApp, MsxfPL2001Request request) throws Exception{
		if(request.getPremiumRate().compareTo(BigDecimal.ZERO)!=1) {
			throw new ParamException("保费费率必须大于0");
		}
		if(iqpMeLoanApp.getAmount().compareTo(request.getLoanAmount())!=0) {
			throw new ParamException("贷款金额不一致");
		}
		BigDecimal coverAmount = iqpMeLoanApp.getAmount().multiply(new BigDecimal("1.08"));
		if(coverAmount.compareTo(request.getApplyAmount())!=0) {
			throw new ParamException("保额不一致");
		}
		//总保费=保费费率*保额;保留2位小数，四舍五入
		BigDecimal coverageFee = request.getPremiumRate().multiply(request.getApplyAmount()).setScale(2, BigDecimal.ROUND_HALF_UP);
		if(coverageFee.compareTo(request.getPremium())!=0) {
			throw new ParamException("总保费不一致");
		}
		BigDecimal total=BigDecimal.ZERO;
		List<RepayPlan> repayPlanList = request.getRepayPlanList();
		for (RepayPlan repayPlan : repayPlanList) {
			total=total.add(repayPlan.getPremium());
		}
		if(total.compareTo(request.getPremium())!=0) {
			throw new ParamException("分期保费相加后与总保费不一致");
		}
		BigDecimal value = BigDecimal.valueOf(repayPlanList.size());//期数
		BigDecimal monFee = request.getPremium().divide(value, 2, BigDecimal.ROUND_HALF_UP);//月保费=总保费/期数。非第一期：保留2位小数，四舍五入。第一期：总保费-sum（非第一期）
		if(monFee.compareTo(repayPlanList.get(1).getPremium())!=0) {
			throw new ParamException("月保费不正确");
		}
		BigDecimal firstFee = coverageFee.subtract(monFee.multiply(BigDecimal.valueOf(repayPlanList.size()-1)));//第一个月保费
		if(firstFee.compareTo(repayPlanList.get(0).getPremium())!=0) {
			throw new ParamException("首月保费不正确");
		}
		//if(!StringUtils.equals(request.getRepaymentMode(), iqpMeLoanApp.getRepaymentMode())) {
		//	throw new ParamException("还款方式不一致");
		//}
	}

	/**
	 * 放款成功处理
	 * @param reqStr 
	 * @param request
	 * @param iqpMeLoanApp
	 * @param iqpMeCusApp
	 * @param prjCopAcc
	 * @param iqpMeChannelPrd
	 * @param cusIndiv 
	 * @throws Exception 
	 */
	private void doLoanSuccess(String reqStr, MsxfPL2001Request request, IqpMeLoanApp iqpMeLoanApp, IqpMeCusApp iqpMeCusApp,PrjCopAcc partnerPrj, IqpMeChannelPrd iqpMeChannelPrd) throws Exception {
		LstIqpInfo lstIqpInfo = insertLstIqpInfo(request, iqpMeLoanApp, iqpMeCusApp,partnerPrj,iqpMeChannelPrd);
		// 异步出单
		msxfAsynDealService.lstInfo(reqStr,lstIqpInfo.getSerno());
	}

	/**
	 * 放款失败处理
	 * @param busiImportDetail
	 * @param iqpMeLoanApp
	 */
	public void doFailure(PartnerBusiImportDetail busiImportDetail, IqpMeLoanApp iqpMeLoanApp) {
		msxfAsynDealService.insertLstOperDetailsStatus(busiImportDetail.getSerno(), MsxfStatus.放款结果通知, "");
		iqpMeLoanApp.setAppStatus(MsxfConstant.NO_PASS);
		iqpMeLoanApp.setApproveStatus(MsxfConstant.NO_PASS);
		iqpMeLoanApp.setNewApproveStatus(MsxfConstant.NO_PASS);
		busiImportDetail.setApprResult(MsxfConstant.NO_PASS);
		busiImportDetail.setNoPassReason("渠道合作方审批拒绝");
		iqpMeLoanAppMapper.updateByPrimaryKeySelective(iqpMeLoanApp);
		partnerBusiImportDetailMapper.updateByPrimaryKeySelective(busiImportDetail);
		msxfAsynDealService.insertLstOperDetailsStatus(busiImportDetail.getSerno(), MsxfStatus.已取消, "");
	}


	/**
	 * 校验还款计划必填参数
	 * @param request
	 * @throws Exception
	 */
	public void checkPlan(MsxfPL2001Request request) throws Exception {
		String[] check = new String[] {"applyAmount","loanAmount","repayPlanList","premium","premiumRate","repaymentFrequency","loanEffectiveTime","loanExpiryTime"};
		checkDatas(request,check);
		check = new String[] {"totalInstallment","installment","startDate","dueDate","principal","interest","premium"};
		for (RepayPlan repayPlan : request.getRepayPlanList()) {
			checkDatas(repayPlan,check);
		}
	}


	/**
	 * 校验必填参数
	 * @param request
	 * @throws Exception
	 */
	public void checkParams(MsxfPL2001Request request) throws Exception {
		String[] check = new String[] {"bizRequestNo","preInsuranceNo","loanResult","channelCode","productCode",
				"recognizeeCode","guaranteeMethod","borrowerType","repaymentMode"};
		checkDatas(request,check);
	}

	/**
	 * 生成投保单 
	 * @param request
	 * @param iqpMeLoanApp
	 * @param cusInfo
	 * @param partnerPrj 
	 * @param iqpMeChannelPrd
	 * @param cusIndiv 
	 * @return
	 * @throws Exception
	 */
	private LstIqpInfo insertLstIqpInfo(MsxfPL2001Request request, IqpMeLoanApp iqpMeLoanApp,IqpMeCusApp cusInfo, 
							PrjCopAcc partnerPrj, IqpMeChannelPrd iqpMeChannelPrd) throws Exception {
		
		LstIqpInfo lstIqpInfo = new LstIqpInfo();
		Connection conn = getConnection();
		// 投保单业务流水号
		String serno = SequenceUtil.getLSTSerno(conn);
		conn.close();
		lstIqpInfo.setSerno(serno);
		lstIqpInfo.setIqpLoanSerno(iqpMeLoanApp.getSerno());
		lstIqpInfo.setIsCredit("0");
		lstIqpInfo.setBizMode(iqpMeLoanApp.getBizMode());
		lstIqpInfo.setPrdId(iqpMeLoanApp.getPrdId());
		lstIqpInfo.setPrdName(iqpMeLoanApp.getPrdName());
		lstIqpInfo.setCusId(iqpMeLoanApp.getCusId());
		lstIqpInfo.setCusName(iqpMeLoanApp.getCusName());
		lstIqpInfo.setCusType(iqpMeLoanApp.getCusType());
		lstIqpInfo.setIndivSex(iqpMeLoanApp.getCusSex());
		lstIqpInfo.setCertType(iqpMeLoanApp.getCertType());
		lstIqpInfo.setCertCode(iqpMeLoanApp.getCertCode());
		lstIqpInfo.setIndivMarSt(cusInfo.getIndivMarSt());
		lstIqpInfo.setAddress(cusInfo.getIndivRsdAddr());
		lstIqpInfo.setTelephone(iqpMeLoanApp.getPhone());
		lstIqpInfo.setCountry(cusInfo.getComCountry());
		lstIqpInfo.setMobile(iqpMeLoanApp.getPhone());
		lstIqpInfo.setIspermit("1");
		lstIqpInfo.setServiceCharge(new BigDecimal("0"));
		lstIqpInfo.setInvoiceType("02");
		lstIqpInfo.setCoverAccountName(iqpMeLoanApp.getRepayAccountName());
		lstIqpInfo.setCoverAccount(iqpMeLoanApp.getRepayAccount());
		lstIqpInfo.setCoverAccountBank(iqpMeLoanApp.getRepayBank());
		lstIqpInfo.setPayeeAccount(iqpMeLoanApp.getPayeeAccount());
		lstIqpInfo.setPayeeAccountName(iqpMeLoanApp.getPayeeAccountName());
		lstIqpInfo.setPayeeBank(iqpMeLoanApp.getPayeeBank());
		lstIqpInfo.setReceiverCusId(partnerPrj.getCopNo());//被保险人编号
		lstIqpInfo.setReceiveCusName(partnerPrj.getCopCusName());
		lstIqpInfo.setReceiverCusAddress(partnerPrj.getCopAddress());
		lstIqpInfo.setReceiveCusPhone(partnerPrj.getCopPhone());
		lstIqpInfo.setReceiveCusCertType(partnerPrj.getCopCertType());
		lstIqpInfo.setReceiveCusCertCode(partnerPrj.getCopCertCode());//被保险人证件号码
		lstIqpInfo.setStatus(MsxfConstant.PASS);//审批状态
		lstIqpInfo.setAmount(request.getLoanAmount());//贷款金额
		lstIqpInfo.setTerm(Convert.toStr(iqpMeLoanApp.getTerm()));//贷款期限月
		lstIqpInfo.setTermDay(Convert.toStr(iqpMeLoanApp.getTermDay(),"0"));//贷款期限天
		lstIqpInfo.setTermTimeType(iqpMeLoanApp.getTermTimeType());//期限类型  01：天，
		lstIqpInfo.setRepaymentMode(iqpMeLoanApp.getRepaymentMode());//还款方式
		// 期数
		int totalInstallment = request.getRepayPlanList().get(0).getTotalInstallment();
		lstIqpInfo.setPeriod(Convert.toStr(totalInstallment));//期数
		lstIqpInfo.setContNo(iqpMeLoanApp.getAccAgreeNo());//借款合同编号
		lstIqpInfo.setFlag("0");//是否微贷
		lstIqpInfo.setCoverAmount(request.getApplyAmount());//保额
		lstIqpInfo.setCoverCurrencyType("CNY");//保额币种
		lstIqpInfo.setRate(request.getPremiumRate().multiply(new BigDecimal("1000")));//保费费率（‰）
		lstIqpInfo.setCoverageFee(request.getPremium());//总保费
		lstIqpInfo.setFeeCurrencyType("CNY");//保额币种(默认人民币)
		lstIqpInfo.setCoverStartDate(request.getLoanEffectiveTime());//保险起期
		lstIqpInfo.setCoverEndDate(request.getLoanExpiryTime());//保险止期
		lstIqpInfo.setToubaoDate(DateUtils.getDate1());//投保日期
		lstIqpInfo.setSignDate(DateUtils.getDate1());//签单日期
		lstIqpInfo.setInputDate(DateUtils.getDate1());//录单日期
		lstIqpInfo.setcConinsrncCde("0");
		lstIqpInfo.setPayWay(iqpMeLoanApp.getPayWay());
		lstIqpInfo.setCreateType("0");
		lstIqpInfo.setInputId(iqpMeApiCop.getInsurInputId());
		lstIqpInfo.setActorno(iqpMeLoanApp.getCusMgr());
		lstIqpInfo.setTelnum(iqpMeLoanApp.getBusinessPersionPhone());
		lstIqpInfo.setcFeeFlag("0");
		lstIqpInfo.setMgrId(iqpMeLoanApp.getCusMgr());
		lstIqpInfo.setMgrOrg(iqpMeLoanApp.getInputBrId());
		lstIqpInfo.setPayeeAccount(iqpMeLoanApp.getBankCardNo());
		lstIqpInfo.setP2pFlag("00");
		lstIqpInfo.setBelongBrId(iqpMeLoanApp.getInputBrId());
		lstIqpInfo.setMainBrId(iqpMeLoanApp.getInputBrId());
		lstIqpInfo.setLoanStartDate(request.getLoanEffectiveTime());//贷款起始日
		lstIqpInfo.setLoanEndDate(request.getLoanExpiryTime());//贷款终止日
		lstIqpInfo.setPrintWay("0");//打印方式(0中文,1英文)
		lstIqpInfo.setExchangeRate(new BigDecimal("0"));//汇率
		lstIqpInfo.setIsAgriculture("0");//是否涉农
		lstIqpInfo.setRiskLevel("928001");//洗钱风险等级
		lstIqpInfo.setGrossRate(iqpMeLoanApp.getUsingIr());//执行年利率
		lstIqpInfo.setOptType("1");//操作标识
		lstIqpInfo.setTradeSign("01");//交易标识
		lstIqpInfo.setExcuseRate(new BigDecimal("0"));//免赔额（率）
		lstIqpInfo.setCoverCreateStatus("00");//保单状态
		lstIqpInfo.setcAppnt(iqpMeChannelPrd.getcAppnt());//特别约定
		lstIqpInfo.setInsRatio(new BigDecimal("1"));//费率系数
		lstIqpInfo.setWithHoldKind("2");// 还款日 1固定日 2对日
		lstIqpInfo.setSinglePrem(iqpMeLoanApp.getSinglePrem());// 1期缴，2趸缴
		lstIqpInfo.setIrType("1");// 固定利率
		lstIqpInfo.setPayWay(iqpMeLoanApp.getPayWay());// 自主保费
		lstIqpInfoMapper.insertSelective(lstIqpInfo);
		return lstIqpInfo;

	}

}
