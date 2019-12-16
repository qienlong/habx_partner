/**   
* @Title:：LstIqpApplyConstant.java 
* @Package ：cn.com.sinosafe.common.config.constant 
* @Description： 投保申请常用变量
* @author：xiewei
* @date： 2019年6月4日 下午9:23:48 
* @version ： 1.0   
*/
package cn.com.sinosafe.common.config.constant;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import cn.com.sinosafe.common.util.CommonUtils;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.entity.AccImportRecords;
import cn.com.sinosafe.domain.entity.CusBase;
import cn.com.sinosafe.domain.entity.CusIndiv;
import cn.com.sinosafe.domain.entity.FeeRate;
import cn.com.sinosafe.domain.entity.IqpMeApiCop;
import cn.com.sinosafe.domain.entity.IqpMeAuditOpinion;
import cn.com.sinosafe.domain.entity.IqpMeCusApp;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.IqpMePaCreditCancel;
import cn.com.sinosafe.domain.entity.IqpMePrjCop;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PrjCopAcc;
import cn.com.sinosafe.lina.common.utils.UUIDUtils;

/** 
 * @ClassName:：LstIqpApplyConstant 
 * @Description： 投保申请常用工具类
 * @author ：xiewei
 * @date ：2019年6月4日 下午9:23:48  
 */
public class LstIqpApplyConstant {
	
	private static final Logger logger = LoggerFactory.getLogger(LstIqpApplyConstant.class);
	/**
	 * 数据重复：SUCCESS
	 */
	public static final String DATA_REPEAT_MSG = "数据重复";
	
	/**
	 * 客户类型
	 */
	public static final String CUS_TYPE="110";
	
	/**
	 * 客户类型
	 */
	public static final String CERT_TYPE="10";
	
	/**
	 * 已申請
	 */
	public static final String IS_PERMIT="1";
	
	/**
	 * h5页面
	 */
	public static final String h5Url="/static/#/PSignOnline";
	
	/**
	 * h5页面
	 */
	public static final String prdName="平安普贷";
	
	/**
	 * 
	* @Title：mapConvertIqpMeLoan 
	* @Description：申请实体类转换
	* @param ：@param paramMap
	* @param ：@return 
	* @return ：IqpMeLoanApp 
	* @throws
	 */
	public static IqpMeLoanApp mapConvertIqpMeLoan(Map<String, Object> paramMap,CusBase cusBase,IqpMeApiCop iqpMeApiCop,PrjCopAcc prjCopAcc){
		IqpMeLoanApp iqpMeLoan=new IqpMeLoanApp();
		iqpMeLoan.setSerno(String.valueOf(paramMap.get("applNo")));
		iqpMeLoan.setCusType(LstIqpApplyConstant.CUS_TYPE);
		iqpMeLoan.setCusId(cusBase.getCusId());//客戶编号生成规则
		iqpMeLoan.setCertType(LstIqpApplyConstant.CERT_TYPE);
		iqpMeLoan.setCertCode(String.valueOf(paramMap.get("id")));
		iqpMeLoan.setCusName(String.valueOf(paramMap.get("custName")));
		iqpMeLoan.setApplyDate(String.valueOf(paramMap.get("applDate")));
		iqpMeLoan.setPhone(String.valueOf(paramMap.get("bnMobile")));
		iqpMeLoan.setAmount(new BigDecimal(StringUtils.isEmpty(String.valueOf(paramMap.get("applAmt")))?"0":String.valueOf(paramMap.get("applAmt"))));
		iqpMeLoan.setTerm(new BigDecimal(StringUtils.isEmpty(String.valueOf(paramMap.get("applNosInst")))?"0":String.valueOf(paramMap.get("applNosInst"))));
		iqpMeLoan.setBankCardNo(String.valueOf(paramMap.get("bankNo")));
		iqpMeLoan.setBusiArea(String.valueOf(paramMap.get("cityName")));
		
		// 资金方信息
		/*iqpMeLoan.setPartnerNo(partnerInfo.getCopNo());
		iqpMeLoan.setPartnerName(partnerInfo.getCopCusName());
		iqpMeLoan.setPartnerType(partnerInfo.getCopCusType());
		iqpMeLoan.setPartnerCertCode(partnerInfo.getCopCertCode());
		iqpMeLoan.setPartnerCertType(partnerInfo.getCopCertType());*/
		
		// 贷款信息
		iqpMeLoan.setPrdId(iqpMeApiCop.getPrdId());
		iqpMeLoan.setPrdName(LstIqpApplyConstant.prdName);
		iqpMeLoan.setUsingIr(new BigDecimal(0));// 利率 TODO
		iqpMeLoan.setCostRate(new BigDecimal(0));// 费率 TODO
		iqpMeLoan.setRepaymentMode("3");//3按月等额本息
		iqpMeLoan.setTermDay(new BigDecimal("0"));
		iqpMeLoan.setTermTimeType("02");
		iqpMeLoan.setIsAutoApprove("0");
		iqpMeLoan.setIsAssure("2");
		iqpMeLoan.setAssureMeansMain("00");
		//支付方式、缴费途径
		iqpMeLoan.setPayWay("1");//代扣
		iqpMeLoan.setPayType("1");//期缴
		iqpMeLoan.setCancelFailCause("00");
		iqpMeLoan.setOptType("1");
		iqpMeLoan.setIsCancel("2");
		iqpMeLoan.setIsAgriculture("2");
		iqpMeLoan.setApplyCurType("CNY");
		iqpMeLoan.setBizMode("26");//信用贷业务
		iqpMeLoan.setInfoChannel("PAPH");//信息来源
		
		/*iqpMeLoan.setAppStatus("997");
		iqpMeLoan.setApproveStatus("997");*/
		iqpMeLoan.setNewApproveStatus("01");
		
		// 账户 
		iqpMeLoan.setBankCardNo(String.valueOf(paramMap.get("bankNo")));
		iqpMeLoan.setPayeeAccount(String.valueOf(paramMap.get("bankNo")));
		//iqpMeLoan.setPayeeAccountName("");
		iqpMeLoan.setRepayAccount(String.valueOf(paramMap.get("bankNo")));
		//iqpMeLoan.setRepayAccountName(prjCopAcc.getAccountName(""));
		
		
		iqpMeLoan.setInputId(iqpMeApiCop.getInputId());
		iqpMeLoan.setInputDate(DateUtils.getDateTime());
		iqpMeLoan.setInputBrId(iqpMeApiCop.getBrId());
		iqpMeLoan.setBelongBrId(iqpMeApiCop.getBrId());
		iqpMeLoan.setMainBrId(iqpMeApiCop.getBrId());
		iqpMeLoan.setCusMgr(iqpMeApiCop.getCusMgr());
		iqpMeLoan.setMainUserId(iqpMeApiCop.getCusMgr());
		iqpMeLoan.setBusinessBrId(iqpMeApiCop.getBrId());
		iqpMeLoan.setBusinessPersionId(iqpMeApiCop.getCusMgr());
		iqpMeLoan.setBusinessPersionName(iqpMeApiCop.getMgrName());
		iqpMeLoan.setBusinessPersionPhone(iqpMeApiCop.getMgrPhone());
		iqpMeLoan.setAlipayRoleId(String.valueOf(paramMap.get("cidNo")));
		return iqpMeLoan;
	}
	/**
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 * @Title：mapConvertAccImportRecords 
	 * @Description：申请实体类转换
	 * @param ：@param paramMap
	 * @param ：@return 
	 * @return ：AccImportRecords 
	 * @throws
	 */
	public static AccImportRecords mapConvertAccImportRecords(Map<String, Object> paramMap,IqpMeApiCop iqpMeApiCop) throws JsonGenerationException, JsonMappingException, IOException{
		AccImportRecords accImportData=new AccImportRecords();
		accImportData.setSerno(String.valueOf(paramMap.get("applNo")));
		accImportData.setImportData(JSONUtils.getSingleInstance().toJSon(paramMap));
		accImportData.setImportDate(DateUtils.getDate("yyyy-MM-dd"));
		accImportData.setImportTime(DateUtils.getDate("HH:mm:ss"));
		accImportData.setMemo("平安普惠数据导入");
		accImportData.setImportUserId(iqpMeApiCop.getCusMgr());
		
		return accImportData;
	}
	
	/**
	 * 
	* @Title：mapConvertIqpMeLoan 
	* @Description：申请实体类转换
	* @param ：@param paramMap
	* @param ：@return 
	* @return ：IqpMeLoanApp 
	* @throws
	 */
	public static CusBase mapConvertCusBase(Map<String, Object> paramMap,IqpMeApiCop iqpMeApiCop,String cusId){
		CusBase cusbase=new CusBase();
		cusbase.setCusId(cusId);
		cusbase.setCusName(String.valueOf(paramMap.get("custName")));
		cusbase.setCertType(LstIqpApplyConstant.CERT_TYPE);
		cusbase.setCertCode(String.valueOf(paramMap.get("id")));
		cusbase.setBelongTo("BL_ALL");
		cusbase.setMainBrId(iqpMeApiCop.getBrId());
		cusbase.setCustMgr(iqpMeApiCop.getCusMgr());
		return cusbase;
	}
	/**
	 * 
	 * @Title：mapConvertIqpPrj 
	 * @Description：申请实体类转换
	 * @param ：@param paramMap
	 * @param ：@return 
	 * @return ：IqpMePrjCop 
	 * @throws
	 */
	public static IqpMePrjCop mapConvertIqpPrj(Map<String, Object> paramMap,PrjCopAcc prjCopAcc){
		IqpMePrjCop iqpMePrjCop=new IqpMePrjCop();
		
		iqpMePrjCop.setPkId(StringUtils.uuid());
		iqpMePrjCop.setSerno(String.valueOf(paramMap.get("applNo")));
		iqpMePrjCop.setCopNo(prjCopAcc.getCopNo());
		iqpMePrjCop.setCopCertCode(prjCopAcc.getCopCertCode());
		iqpMePrjCop.setCopCertType(prjCopAcc.getCopCertType());
		iqpMePrjCop.setCopCusName(prjCopAcc.getCopCusName());
		iqpMePrjCop.setCopCusId(prjCopAcc.getCopCusId());
		iqpMePrjCop.setCopCusType(prjCopAcc.getCopCusType());
		iqpMePrjCop.setBizCopType(prjCopAcc.getCopCusType());
		
		return iqpMePrjCop;
	}
	
	/**
	 * 
	* @Title：mapConvertIqpMeLoan 
	* @Description：申请实体类转换
	* @param ：@param paramMap
	* @param ：@return 
	* @return ：IqpMeLoanApp 
	* @throws
	 */
	public static CusIndiv mapConvertCusIndiv(Map<String, Object> paramMap,CusBase cusBase,IqpMeApiCop iqpMeApiCop){
		CusIndiv cusIndiv=new CusIndiv();
		cusIndiv.setCusId(cusBase.getCusId());//客戶编号生成规则
		cusIndiv.setCusName(cusBase.getCusName());//String.valueOf(paramMap.get("custName"))
		cusIndiv.setCertType(cusBase.getCertType());//LstIqpApplyConstant.CERT_TYPE
		cusIndiv.setCertCode(cusBase.getCertCode());//String.valueOf(paramMap.get("id"))
		cusIndiv.setPhone(String.valueOf(paramMap.get("bnMobile")));//手机号码
		cusIndiv.setMobile(String.valueOf(paramMap.get("bnMobile")));//鉴权所预留手机号码
		cusIndiv.setBelongTo("BL_ALL");
		cusIndiv.setIndivSex(CommonUtils.getSexByCertNo(cusBase.getCertCode()));
		cusIndiv.setIndivDtOfBirth(CommonUtils.getBirthdayByCertNo(cusBase.getCertCode()));
		cusIndiv.setInputBrId(iqpMeApiCop.getBrId());
		cusIndiv.setInputId(iqpMeApiCop.getInputId());
		cusIndiv.setMainBrId(iqpMeApiCop.getBrId());
		cusIndiv.setCustMgr(iqpMeApiCop.getCusMgr());
		cusIndiv.setInputDate(DateUtils.getDate());
		cusIndiv.setComCountry("CDL");
		return cusIndiv;
	}
	
	/**
	 * 
	* @Title：mapConvertIqpMeCus 
	* @Description：小额贷实体类转换
	* @param ：@param paramMap
	* @param ：@return 
	* @return ：IqpMeCusApp 
	* @throws
	 */
	public static IqpMeCusApp mapConvertIqpMeCus(Map<String, Object> paramMap,CusBase cusBase){
		IqpMeCusApp iqpMeCus=new IqpMeCusApp();
		iqpMeCus.setSerno(String.valueOf(paramMap.get("applNo")));
		iqpMeCus.setCusType(LstIqpApplyConstant.CUS_TYPE);
		iqpMeCus.setCusId(cusBase.getCusId());//客戶编号生成规则
		iqpMeCus.setCertType(LstIqpApplyConstant.CERT_TYPE);
		iqpMeCus.setCertCode(String.valueOf(paramMap.get("id")));
		iqpMeCus.setCusName(String.valueOf(paramMap.get("custName")));
		iqpMeCus.setMobile(String.valueOf(paramMap.get("bnMobile")));
		iqpMeCus.setReturnurl(String.valueOf(paramMap.get("sucH5Url")));
		iqpMeCus.setInformationSource(String.valueOf(paramMap.get("facH5Url")));
		return iqpMeCus;
	}
	
	/**
	 * 
	* @Title：mapConvertIqpMeCus 
	* @Description：保单信息实体类转换
	* @param ：@param paramMap
	* @param ：@return 
	* @return ：IqpMeCusApp 
	* @throws
	 */
	public static LstIqpInfo mapConvertLstIqpInfo(Map<String, Object> paramMap,IqpMeLoanApp imLoan,PrjCopAcc prjCopAcc,IqpMeApiCop iqpMeApiCop,CusIndiv cusIndiv,IqpMeAuditOpinion iqpMeAuditOpinion,Map<String, Object> prdInfo){
		LstIqpInfo lstIqpInfo=new LstIqpInfo();
		lstIqpInfo.setCusId(imLoan.getCusId());
		lstIqpInfo.setCusName(imLoan.getCusName());
		lstIqpInfo.setCusType(imLoan.getCusType());
		lstIqpInfo.setCertCode(imLoan.getCertCode());
		lstIqpInfo.setCertType(imLoan.getCertType());
		lstIqpInfo.setPrdId(iqpMeApiCop.getPrdId());
		lstIqpInfo.setPrdName(imLoan.getPrdName());
		lstIqpInfo.setMobile(String.valueOf(paramMap.get("mobile")));
		String applyDateStr=null;
		try {
			Date applyDate=DateUtils.parseDate(imLoan.getApplyDate());
			applyDateStr=DateUtils.format(applyDate, "yyyy-MM-dd");
		} catch (Exception e) {
			applyDateStr=DateUtils.getDate("yyyy-MM-dd");
		}
		lstIqpInfo.setToubaoDate(applyDateStr);
		lstIqpInfo.setInputDate(applyDateStr);
		lstIqpInfo.setPrdSubCode((String)prdInfo.get("INS_NAME"));
		lstIqpInfo.setAmount(imLoan.getAmount());
		lstIqpInfo.setTerm(String.valueOf(imLoan.getTerm()));
		lstIqpInfo.setIspermit("0");
		//城市？
		
		
		lstIqpInfo.setIsCredit("1");
		lstIqpInfo.setBizMode("26");
		lstIqpInfo.setIndivSex(cusIndiv.getIndivSex());
		lstIqpInfo.setTelephone(imLoan.getPhone());
		lstIqpInfo.setCountry("193001");
		lstIqpInfo.setCoverAccountName(imLoan.getCusName());
		lstIqpInfo.setCoverAccount(String.valueOf(paramMap.get("bankNo")));
		lstIqpInfo.setServiceCharge(new BigDecimal("0"));
		lstIqpInfo.setInvoiceType("03");
		//lstIqpInfo.setLocTaxRegCode("123456");//TODO
		lstIqpInfo.setInvoiceContact(imLoan.getCusName());
		
		/*lstIqpInfo.setReceiverCusId(imLoan.getCusId());
		lstIqpInfo.setReceiveCusName(imLoan.getCusName());
		lstIqpInfo.setReceiveCusPhone(imLoan.getPhone());
		lstIqpInfo.setReceiveCusCertType("30");//TODO
		lstIqpInfo.setReceiveCusCertCode("");//TODO
*/		lstIqpInfo.setStatus("111");
		lstIqpInfo.setCoverCreateStatus("00");
		
		lstIqpInfo.setTermDay(String.valueOf(imLoan.getTermDay()));
		lstIqpInfo.setTermTimeType(imLoan.getTermTimeType());
		lstIqpInfo.setRepaymentMode(imLoan.getRepaymentMode());
		lstIqpInfo.setPeriod(String.valueOf(imLoan.getTerm()));
		lstIqpInfo.setContNo(imLoan.getAccAgreeNo());
		lstIqpInfo.setFlag("0");
		lstIqpInfo.setCoverAmount(iqpMeAuditOpinion.getInsurAmount());
		lstIqpInfo.setCoverCurrencyType("CNY");
		// 保费=贷款本金*费率
		//lstIqpInfo.setCoverageFee(batchLoanInfo.getAmount().multiply(iqpMeAuditOpinion.getCostRate()));
		
//		lstIqpInfo.setRate(iqpMeAuditOption.getCostRate().multiply(new BigDecimal("1000")));
		//lstIqpInfo.setRate((lstIqpInfo.getCoverageFee().multiply(new BigDecimal("1000"))).divide(lstIqpInfo.getCoverAmount(), 2, RoundingMode.HALF_UP));
		
		lstIqpInfo.setSinglePrem("1");//期缴
		lstIqpInfo.setFeeCurrencyType("CNY");
		//lstIqpInfo.setCoverStartDate("");//
		//lstIqpInfo.setCoverEndDate("");//
		lstIqpInfo.setSignDate(DateUtils.getDate("yyyy-MM-dd"));
		//lstIqpInfo.setcConinsrncCde("0");
		lstIqpInfo.setPayWay(imLoan.getPayWay());
		lstIqpInfo.setCreateType("0");
		lstIqpInfo.setInputId(iqpMeApiCop.getInsurInputId());
		lstIqpInfo.setActorno(iqpMeApiCop.getCusMgr());
		lstIqpInfo.setTelnum(iqpMeApiCop.getMgrPhone());
		lstIqpInfo.setcFeeFlag("0");
		lstIqpInfo.setMgrId(iqpMeApiCop.getCusMgr());
		lstIqpInfo.setMgrOrg(iqpMeApiCop.getBrId());
		lstIqpInfo.setPayeeAccount(String.valueOf(paramMap.get("bankNo")));
		lstIqpInfo.setPayeeAccountName(imLoan.getCusName());
		lstIqpInfo.setP2pFlag("00");
		lstIqpInfo.setBelongBrId(iqpMeApiCop.getBrId());
		lstIqpInfo.setMainBrId(iqpMeApiCop.getBrId());
		//lstIqpInfo.setIspermit("1");
		//lstIqpInfo.setLoanStartDate("");//
		//lstIqpInfo.setLoanEndDate("");//
		lstIqpInfo.setPrintWay("0");
		lstIqpInfo.setExchangeRate(new BigDecimal("0"));
		lstIqpInfo.setIsAgriculture("0");
		lstIqpInfo.setRiskLevel("928001");
		lstIqpInfo.setGrossRate(new BigDecimal(0));
		lstIqpInfo.setOptType("1");
		lstIqpInfo.setIqpLoanSerno(imLoan.getSerno());
		lstIqpInfo.setTradeSign("01");
		lstIqpInfo.setExcuseRate(new BigDecimal("1"));//免赔率华安数据库单位为%
		//lstIqpInfo.setCoverCreateStatus("04");
//		Map<String, Object> cAppnt = lstIqpInfo2Mapper.queryCAppnt(batchLoanInfo.getPrdId());
		lstIqpInfo.setcAppnt((String)prdInfo.get("C_APPNT"));
		lstIqpInfo.setInsRatio(new BigDecimal("1"));
		lstIqpInfo.setBusinessSource("PAPH");
		
		return lstIqpInfo;
	}
	
	/**
	 * 
	* @Title：checkFieldDefect 
	* @Description：校验字段缺失
	* @param ：@param keyStrs
	* @param ：@param paramMap
	* @param ：@return 
	* @return ：boolean 
	* @throws
	 */
	public static boolean checkFieldDefect(Map<String, Object> paramMap,String[] needField){
		boolean flag = false;//默认不缺失
		for(String string : needField) {
			if(paramMap.get(string)==null || "".equals(paramMap.get(string).toString())) {
				logger.info("{}字段缺失！",string);
				flag = true;//字段缺失
				break;
			}
		}
		return flag;
	}
	/**
	 * 
	 * @Title：checkFieldDefect 
	 * @Description：校验字段缺失
	 * @param ：@param keyStrs
	 * @param ：@param paramMap
	 * @param ：@return 
	 * @return ：boolean 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static boolean checkListFieldDefect(Map<String, Object> paramMap,String[] needField){
		boolean boo=false;
		//解析保单扩展信息
		List<Map<String, Object>> extendList=(List<Map<String, Object>>)paramMap.get("credit");
		if(null!=extendList){
			for(int i=0 ; i < extendList.size();i++){
			    //获取每一个JsonObject对象
				Map<String, Object> jsonObj = extendList.get(i);
			    if(LstIqpApplyConstant.checkFieldDefect(jsonObj, needField)){
			    	boo=true;
			    	break;
				}
			    if(boo){break;}
			}
		}
		return boo;
	}
	/**
	 * @Title：checkFieldDefect 
	 * @Description：校验字段缺失
	 * @param ：@param keyStrs
	 * @param ：@param paramMap
	 * @param ：@return 
	 * @return ：boolean 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static boolean checkListFieldDefectByStr(String condition,Map<String, Object> paramMap,String[] needField){
		boolean boo=false;
		//解析保单扩展信息
		List<Map<String, Object>> extendList=(List<Map<String, Object>>)paramMap.get(condition);
		if(null!=extendList){
			for(int i=0 ; i < extendList.size();i++){
				//获取每一个JsonObject对象
				Map<String, Object> jsonObj = extendList.get(i);
				if(LstIqpApplyConstant.checkFieldDefect(jsonObj, needField)){
					boo=true;
					break;
				}
				if(boo){break;}
			}
		}
		return boo;
	}
	
	/**
	 * 
	* @Title：mapConvertIqpMeAuditOpinion 
	* @Description：审批决议表实体类转换
	* @param ：@param paramMap
	* @param ：@return 
	* @return ：IqpMeAuditOpinion 
	* @throws
	 */
	public static IqpMeAuditOpinion mapConvertIqpMeAuditOpinion(IqpMeLoanApp imLoan,CusBase cusBase){
		IqpMeAuditOpinion lqpMeAuditOpinion=new IqpMeAuditOpinion();
		lqpMeAuditOpinion.setPkId(UUIDUtils.generate());
		lqpMeAuditOpinion.setCusId(cusBase.getCusId());
		lqpMeAuditOpinion.setSerno(imLoan.getSerno());
		lqpMeAuditOpinion.setApproveOpinion(CommonConstant.APPROVEING);
		
		//lqpMeAuditOpinion.setAmount(batchLoanInfo.getAmount());
		lqpMeAuditOpinion.setTerm(String.valueOf(imLoan.getTerm()));
		lqpMeAuditOpinion.setApproveTerm(String.valueOf(imLoan.getTerm()));
		//audit.setApproveAmount(batchLoanInfo.getAmount());
		lqpMeAuditOpinion.setRepaymode(imLoan.getRepaymentMode());
		lqpMeAuditOpinion.setApproveTermday(String.valueOf(imLoan.getTermDay()));
		lqpMeAuditOpinion.setApproveTermTimeType(imLoan.getTermTimeType());
		//lqpMeAuditOpinion.setInsurAmount(batchLoanInfo.getAmount().multiply(new BigDecimal("1.08")));
		//lqpMeAuditOpinion.setApproveRate(batchLoanInfo.getUsingIr());
		lqpMeAuditOpinion.setApproveRepaymode(imLoan.getRepaymentMode());
		//lqpMeAuditOpinion.setCostRate(batchLoanInfo.getCostRate());
		//lqpMeAuditOpinion.setLoanAmount(batchLoanInfo.getAmount());
		return lqpMeAuditOpinion;
	}
	/**
	 * @Title：lstInfoToFeePlan 
	 * @Description：将投保信息转换成保费分期计划参数
	 * @param ：@param paramMap
	 * @param ：@return 
	 * @return ：IqpMeAuditOpinion 
	 * @throws
	 */
	public static Map<String,Object> lstInfoToFeePlan(LstIqpInfo lstIqpInfo,FeeRate feeRate){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("LST_SERNO", lstIqpInfo.getSerno());//投保单业务流水号
		map.put("BILL_NO", "");//借据号
		map.put("RATE", lstIqpInfo.getRate());//总费率
		map.put("PS_COVERAGE_FEE", lstIqpInfo.getCoverageFee());//总保费 元
		map.put("PERD_TOTAL", lstIqpInfo.getTerm());//总分期数
		map.put("PS_DUE_DT", DateUtils.getDate("yyyy-MM-dd"));//放款日期 yyyy-MM-dd放款日期取当前日期
		map.put("INPUT_ID", lstIqpInfo.getInputId());//录入人
		map.put("INPUT_BR_ID", lstIqpInfo.getBelongBrId());//录入机构
		map.put("COVER_SERNO", "");//投保单编号
		map.put("LIST_SERNO", "");//保单编号
		map.put("IQP_LOAN_SERNO", lstIqpInfo.getIqpLoanSerno());//调查流水号
		map.put("REPAYMENT_MODE", lstIqpInfo.getRepaymentMode());//还款方式 STD_ZB_REPAY_MODE
		map.put("PAY_MODE", lstIqpInfo.getPayWay());//支付方式 STD_FEE_REPAY_WAY
		map.put("PRE_CAL_WAY", "3");//保费分期计算策略 1平摊2按权重3其它
		map.put("REPAYMENT_DAY", "");//指定每月还款日
		
		int termNum = Integer.parseInt(lstIqpInfo.getTerm());
		String perAmt = String.valueOf(lstIqpInfo.getAmount().multiply(new BigDecimal(0.99)).multiply(new BigDecimal(feeRate.getPaFeeRate())).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i=0;i<termNum;i++) {
			Map<String, Object> mapT = new HashMap<String, Object>();
			mapT.put("psCoverageFee", perAmt);
			mapT.put("psDueDate", "");
			list.add(mapT);
		}
		map.put("PS_FEE_INFO_ARR", list);
		return map;
	}
	
	/**
	 * <p>Title: mapConvertLstIqpInfo</p>  
	 * <p>Description: 重复进件重新生成一条投保单记录</p>  
	 * @param LstIqpInfoOld
	 * @return
	 */
	public static LstIqpInfo mapConvertLstIqpInfo(LstIqpInfo LstIqpInfoOld){
		LstIqpInfo lstIqpInfo=new LstIqpInfo();
		lstIqpInfo.setCusId(LstIqpInfoOld.getCusId());
		lstIqpInfo.setCusName(LstIqpInfoOld.getCusName());
		lstIqpInfo.setCusType(LstIqpInfoOld.getCusType());
		lstIqpInfo.setCertCode(LstIqpInfoOld.getCertCode());
		lstIqpInfo.setCertType(LstIqpInfoOld.getCertType());
		lstIqpInfo.setPrdId(LstIqpInfoOld.getPrdId());
		lstIqpInfo.setPrdName(LstIqpInfoOld.getPrdName());
		lstIqpInfo.setMobile(LstIqpInfoOld.getMobile());
		lstIqpInfo.setToubaoDate(DateUtils.getDate("yyyy-MM-dd"));
		lstIqpInfo.setInputDate(DateUtils.getDate("yyyy-MM-dd"));
		lstIqpInfo.setPrdSubCode(LstIqpInfoOld.getPrdSubCode());
		lstIqpInfo.setAmount(LstIqpInfoOld.getAmount());
		lstIqpInfo.setTerm(LstIqpInfoOld.getTerm());
		lstIqpInfo.setIspermit("0");
		lstIqpInfo.setIsCredit("1");
		lstIqpInfo.setBizMode("26");
		lstIqpInfo.setIndivSex(LstIqpInfoOld.getIndivSex());
		lstIqpInfo.setTelephone(LstIqpInfoOld.getTelephone());
		lstIqpInfo.setCountry("193001");
		lstIqpInfo.setCoverAccountName(LstIqpInfoOld.getCoverAccountName());
		lstIqpInfo.setCoverAccount(LstIqpInfoOld.getCoverAccount());
		lstIqpInfo.setServiceCharge(new BigDecimal("0"));
		lstIqpInfo.setInvoiceType("03");
		lstIqpInfo.setInvoiceContact(LstIqpInfoOld.getInvoiceContact());
		lstIqpInfo.setStatus("111");
		lstIqpInfo.setCoverCreateStatus("00");
		lstIqpInfo.setTermDay(LstIqpInfoOld.getTermDay());
		lstIqpInfo.setTermTimeType(LstIqpInfoOld.getTermTimeType());
		lstIqpInfo.setRepaymentMode(LstIqpInfoOld.getRepaymentMode());
		lstIqpInfo.setPeriod(LstIqpInfoOld.getPeriod());
		lstIqpInfo.setContNo(LstIqpInfoOld.getContNo());
		lstIqpInfo.setFlag("0");
		lstIqpInfo.setCoverAmount(LstIqpInfoOld.getCoverAmount());
		lstIqpInfo.setCoverCurrencyType("CNY");
		lstIqpInfo.setSinglePrem("1");//期缴
		lstIqpInfo.setFeeCurrencyType("CNY");
		lstIqpInfo.setSignDate(DateUtils.getDate("yyyy-MM-dd"));
		lstIqpInfo.setPayWay(LstIqpInfoOld.getPayWay());
		lstIqpInfo.setCreateType("0");
		lstIqpInfo.setInputId(LstIqpInfoOld.getInputId());
		lstIqpInfo.setActorno(LstIqpInfoOld.getActorno());
		lstIqpInfo.setTelnum(LstIqpInfoOld.getTelnum());
		lstIqpInfo.setcFeeFlag("0");
		lstIqpInfo.setMgrId(LstIqpInfoOld.getMgrId());
		lstIqpInfo.setMgrOrg(LstIqpInfoOld.getMgrOrg());
		lstIqpInfo.setPayeeAccount(LstIqpInfoOld.getPayeeAccount());
		lstIqpInfo.setPayeeAccountName(LstIqpInfoOld.getPayeeAccountName());
		lstIqpInfo.setP2pFlag("00");
		lstIqpInfo.setBelongBrId(LstIqpInfoOld.getBelongBrId());
		lstIqpInfo.setMainBrId(LstIqpInfoOld.getMainBrId());
		lstIqpInfo.setPrintWay("0");
		lstIqpInfo.setExchangeRate(new BigDecimal("0"));
		lstIqpInfo.setIsAgriculture("0");
		lstIqpInfo.setRiskLevel("928001");
		lstIqpInfo.setGrossRate(new BigDecimal(0));
		lstIqpInfo.setOptType("1");
		lstIqpInfo.setIqpLoanSerno(LstIqpInfoOld.getIqpLoanSerno());
		lstIqpInfo.setTradeSign("01");
		lstIqpInfo.setExcuseRate(new BigDecimal("1"));//免赔率华安数据库单位为%
		lstIqpInfo.setcAppnt(LstIqpInfoOld.getcAppnt());
		lstIqpInfo.setInsRatio(new BigDecimal("1"));
		
		return lstIqpInfo;
	}
	/**
	 * <p>Title: mapConvertPaCreditCancel</p>  
	 * <p>Description: 转换成授信制回退记录表</p>  
	 * @param jsonObj,paramMap
	 * @return
	 */
	public static IqpMePaCreditCancel mapConvertPaCreditCancel(Map<String, Object> jsonObj,Map<String, Object> paramMap){
		IqpMePaCreditCancel iqpMePaCreditCancel = new IqpMePaCreditCancel();
		iqpMePaCreditCancel.setPkId(UUIDUtils.generate());
		iqpMePaCreditCancel.setDateMsg(String.valueOf(paramMap.get("dateMsg")));
		iqpMePaCreditCancel.setInsuCompany(String.valueOf(paramMap.get("insuCompany")));
		iqpMePaCreditCancel.setSource(String.valueOf(paramMap.get("source")));
		iqpMePaCreditCancel.setApplNo(String.valueOf(jsonObj.get("applNo")));
		iqpMePaCreditCancel.setRejectDate(StringUtils.isEmpty(String.valueOf(jsonObj.get("rejectDate")))?DateUtils.getDate("yyyy-MM-dd"):DateUtils.format(DateUtils.parseDate(jsonObj.get("rejectDate")), "yyyy-MM-dd"));
		iqpMePaCreditCancel.setStatus(String.valueOf(jsonObj.get("status")));
		
		return iqpMePaCreditCancel;
	}

	
}

