package cn.com.sinosafe.service.gbcn.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.SequenceUtil;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.XmlUtil;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.domain.entity.CusBase;
import cn.com.sinosafe.domain.entity.CusCom;
import cn.com.sinosafe.domain.entity.IqpMeApiCop;
import cn.com.sinosafe.domain.entity.IqpMeCusComApp;
import cn.com.sinosafe.domain.entity.IqpMeInsuranceInfo;
import cn.com.sinosafe.domain.entity.IqpMeInsured;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.IqpMePrjCop;
import cn.com.sinosafe.domain.entity.IqpMeProjectInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.gbcn.request.InsureRequest;
import cn.com.sinosafe.domain.gbcn.request.InsureRequest.InsureRequestBody;
import cn.com.sinosafe.domain.gbcn.request.InsureRequest.InsureRequestBody.InsureApplicantInfo;
import cn.com.sinosafe.domain.gbcn.request.InsureRequest.InsureRequestBody.InsurePolicyInfo;
import cn.com.sinosafe.domain.gbcn.request.Packet;
import cn.com.sinosafe.domain.gbcn.request.Packet.Body;
import cn.com.sinosafe.domain.gbcn.request.Packet.Head;
import cn.com.sinosafe.domain.gbcn.request.PacketResult;
import cn.com.sinosafe.domain.gbcn.response.BaseResponse.ResponseBody;
import cn.com.sinosafe.domain.gbcn.response.GBResponse;
import cn.com.sinosafe.domain.gbcn.response.GBResponse.InsureResponse;
import cn.com.sinosafe.service.gbcn.CommonService;
import cn.com.sinosafe.service.gbcn.GbcnService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Service(value = GBCNConstant.INSURE_REQUEST)
public class InsureRequestService extends CommonService implements GbcnService<ResponseBody,String>{

    private static final Logger logger = LoggerFactory.getLogger(InsureRequestService.class);
    
	public GBResponse<InsureResponse> getResultObj(){
    	return InsureResponse.getInstance();
    }
	
    
	@Override
	public ResponseBody process(String param) throws Exception {
		InsureRequest requestObj = (InsureRequest) XmlUtil.xml2Object(param, InsureRequest.class);
		InsureRequestBody requestBody = requestObj.getRequestBody();
		InsureApplicantInfo applicantInfo = requestBody.getApplicantInfo();
		InsurePolicyInfo insurePolicyInfo = requestBody.getPolicyInfo();
		//机构
		IqpMeApiCop iqpmeApiCop = iqpMeApiCopMapper.selectByAccid("PRJ20190904092934");
		//插入客户信息、对公客户
		CusBase base = insertCus(applicantInfo,iqpmeApiCop);
		//插入贷款申请信息表
    	Connection conn = dataSource.getConnection();
    	IqpMeLoanApp imLoan = insertIqpMeLoan(base,insurePolicyInfo,conn,iqpmeApiCop);
	    //插入对公客户信息申请表
	    insertIqpMeCus(base.getCusId(),imLoan);
	    //插入项目信息表
	    insertIqpMeProject(imLoan.getSerno(),applicantInfo.getProjectName(),applicantInfo.getBidSectionCode(),conn);
	    //插入被保险人表 iqp_me_insured
	    insertIqpMeInsured(imLoan.getSerno(),applicantInfo,conn);
	    //插入保险责任类别表
	    insertIqpMeInsurance(imLoan.getSerno(),insurePolicyInfo,conn);
	    //处理缴费链接
	    if(conn!=null){
		    conn.close();
	    }
	    //插入合作方
	    insertIqpMePrjCop(imLoan.getSerno());
        //插入投保单表
	    LstIqpInfo lstIqpInfo = insertLstIqpInfo(applicantInfo,insurePolicyInfo, base, imLoan,iqpmeApiCop);
	    //调用核心出投保单
	    sendCentre(lstIqpInfo.getSerno(), lstIqpInfo.getCoverageFee());
	    //获取缴费链接
	    String payResult = requestPayUrl(lstIqpInfo.getIqpLoanSerno());
	    return processPayResult(payResult,lstIqpInfo.getSerno());
	}

    private void insertIqpMePrjCop(String serno) {
	    IqpMePrjCop iqpMePrjCop = new IqpMePrjCop();
	    iqpMePrjCop.setSerno(serno);
		iqpMePrjCop.setPkId(StringUtils.uuid());
		iqpMePrjCop.setCopNo("PRJ20190904092934");
		iqpMePrjCop.setCopCertCode("91330212MA2AECMD5B");
		iqpMePrjCop.setCopCertType("30");
		iqpMePrjCop.setCopCusName("工保科技（浙江）有限公司");
		iqpMePrjCop.setCopCusId("CUS20191382457");
		iqpMePrjCop.setCopCusType("Ab");
		iqpMePrjCop.setBizCopType("Ab");
    	iqpMePrjCopDao.insertSelective(iqpMePrjCop);
	}

	private void insertIqpMeInsured(String serno,InsureApplicantInfo applicantInfo, Connection conn) {
    	IqpMeInsured iqpMeInsured = new IqpMeInsured();
    	iqpMeInsured.setSerno(serno);
    	iqpMeInsured.setpNo(1L);
    	iqpMeInsured.setInsuredAddress(applicantInfo.getTendereeAddress());
    	iqpMeInsured.setInsuredCertCode(applicantInfo.getTendereeCode());
    	iqpMeInsured.setInsuredName(applicantInfo.getTendereeName());
    	iqpMeInsured.setInsuredPhone(applicantInfo.getTendereeContactPhoneNumber());
    	iqpMeInsuredMapper.insertSelective(iqpMeInsured);
	}


	private String requestPayUrl(String serno) {
	    JSONObject request = new JSONObject();
	    request.put("appRequestType", "1");
	    request.put("curPage", "1");
	    request.put("pageSize", "10");
	    request.put("terminal_type", "01");
	    JSONObject json = new JSONObject();
	    json.put("serno", serno);
	    String response = haXbCmisAppApiService.payInsuranceFee(request.toJSONString(), json.toJSONString());
	    logger.info("【工保支付url获取】" + response);
	    return response;
	}

	private IqpMeInsuranceInfo insertIqpMeInsurance(
			String serno, InsurePolicyInfo insurePolicyInfo, Connection conn) {
    	IqpMeInsuranceInfo insurance = new IqpMeInsuranceInfo();
	    insurance.setIqpSerno(serno);
	    insurance.setInsuranceId(SequenceUtil.getInsuranceNo(conn));
	    insurance.setInsuranceType("01");
	    insurance.setInsuranceTypeName("投标保证");
	    insurance.setInsuranceAmount(insurePolicyInfo.getSumAmount());
	    insurance.setInsuranceAmountSum(insurePolicyInfo.getSumAmount());
	    insurance.setInsuranceAmountDay(new Long(90L));
	    Date startDate = new Date();
        startDate = DateUtils.addDays(startDate, 30);
        Date endDate = DateUtils.addDays(startDate, 90);
	    insurance.setInsuranceStartTime(DateUtils.format(startDate, "yyyy-MM-dd"));
	    insurance.setInsuranceEndTime(DateUtils.format(endDate, "yyyy-MM-dd"));
	    insurance.setInsuranceRate(new BigDecimal(5));
	    insurance.setInsuranceStatus("1");
	    //保费=保额*保险费率 四舍五入
	 //   BigDecimal fee =   insurance.getInsuranceAmountSum().multiply(new BigDecimal(0.0005));
	    insurance.setInsuranceFee(insurePolicyInfo.getSumPremium());
	    insurance.setSourceType("1");
	    iqpMeInsuranceInfoMapper.insertSelective(insurance);
	    return insurance;
	}

	private IqpMeProjectInfo insertIqpMeProject(String serno, String projectSubject,String bidSectionCode,Connection conn) {
	    IqpMeProjectInfo project = new IqpMeProjectInfo();
	    project.setIqpSerno(serno);
	    projectSubject = projectSubject.replace("•", "·");
	    project.setProjectSubject(projectSubject);
	    project.setBidNoticeNumber(bidSectionCode);
	    project.setProjectId(SequenceUtil.getProjectNo(conn));
	    this.iqpMeProjectInfoMapper.insertSelective(project);
	    return project;
	}

	private IqpMeCusComApp insertIqpMeCus(String cusId, IqpMeLoanApp imLoan) throws Exception {
		IqpMeCusComApp cusComApp = new IqpMeCusComApp();
		BeanUtils.copyProperties(cusComApp,imLoan);
      //  cusComApp.setSerno(serno);
	    cusComApp.setCusId(cusId);
	    cusComApp.setBelongTo(GBCNConstant.CUST_BELONG);
	    cusComApp.setComCountry("CHN");
	    iqpMeCusComAppMapper.insertSelective(cusComApp);
	    return cusComApp;
	}

	private IqpMeLoanApp insertIqpMeLoan(CusBase base,
			InsurePolicyInfo insurePolicyInfo, Connection conn,IqpMeApiCop iqpmeApiCop) {
		IqpMeLoanApp imLoan = new IqpMeLoanApp();
		String serno = SequenceUtil.getWXSerno(conn);
		imLoan.setSerno(serno);
		imLoan.setCusName(base.getCusName());
		imLoan.setCusId(base.getCusId());
		imLoan.setCertCode(base.getCertCode());
		imLoan.setPrdName(GBCNConstant.PRODUCT_NAME);
		imLoan.setPrdId(GBCNConstant.PRODUCT_ID);
		imLoan.setInputId(SystemConfig.cacheMap.get("GBCN_INPUT_ID"));
		imLoan.setBelongBrId(SystemConfig.cacheMap.get("GBCN_PT_ORG"));
		imLoan.setMainBrId(iqpmeApiCop.getBrId());
		imLoan.setBizMode("15");
		imLoan.setCusType("211");
		imLoan.setInputDate(DateUtils.getDate1());
		imLoan.setCertType(GBCNConstant.CRET_TYPE);
		imLoan.setApplyDate(DateUtils.getDate());
		imLoan.setMainUserId(iqpmeApiCop.getCusMgr());
		imLoan.setInputBrId(SystemConfig.cacheMap.get("GBCN_INPUT_ORG"));
		imLoan.setCusMgr(iqpmeApiCop.getCusMgr());
		imLoan.setBusinessBrId(iqpmeApiCop.getBrId());
		imLoan.setBusinessPersionId(iqpmeApiCop.getCusMgr());
		imLoan.setBusinessPersionName(iqpmeApiCop.getMgrName());
		imLoan.setBusinessPersionPhone(iqpmeApiCop.getMgrPhone());
		imLoan.setCostRate(new BigDecimal(0.05));
		imLoan.setcAppnt(insurePolicyInfo.getEndorseText());
		imLoan.setAmount(insurePolicyInfo.getSumAmount());
		//10.26
		imLoan.setPartnerName("工保科技（浙江）有限公司");
		imLoan.setPartnerCertType("30");
		imLoan.setPartnerCusId("CUS20191382457");
		imLoan.setPartnerNo("PRJ20190904092934");
		imLoan.setPartnerType("Ab");
		imLoan.setIsloaned("0");
		imLoan.setTermDay(new BigDecimal(90));
		imLoan.setPayWay("10");
		if(insureRoute(insurePolicyInfo.getSumAmount())){
			imLoan.setAppStatus("997");
		    imLoan.setApproveStatus("995");
		    imLoan.setNewApproveStatus("995");
		} else{
			imLoan.setAppStatus("998");
			imLoan.setApproveStatus("998");
			imLoan.setNewApproveStatus("998");
			iqpMeLoanAppMapper.insertSelective(imLoan);
			throw new BusinessException("不能超过200万");
		}
		iqpMeLoanAppMapper.insertSelective(imLoan);
		return imLoan;
	}

	private CusBase insertCus(InsureApplicantInfo applicantInfo,IqpMeApiCop iqpmeApiCop) {
		CusBase base = cusBaseMapper.selectCusInfoByNameId(applicantInfo.getName(),applicantInfo.getIdNumber());
		if(ObjectUtils.isEmpty(base)){
			  base = new CusBase();
//			  String cusId = cusBaseMapper.createCusId();
//			  base.setCusId(cusId);
			  base.setCusName(applicantInfo.getName());
			  base.setCertCode(applicantInfo.getIdNumber());
			  base.setCertType(GBCNConstant.CRET_TYPE);
			  base.setBelongTo(GBCNConstant.CUST_BELONG);
			  base.setCustMgr(iqpmeApiCop.getCusMgr());
			  base.setMainBrId(iqpmeApiCop.getBrId());
			  cusBaseMapper.insertSelective(base);
			  CusBase base1 =  cusBaseMapper.selectCusInfoByNameId(applicantInfo.getName(),applicantInfo.getIdNumber());
			  base.setCusId(base1.getCusId());
			  CusCom cusCom = new CusCom();
			  cusCom.setCusId(base1.getCusId());
			  cusCom.setCertType(GBCNConstant.CRET_TYPE);
			  cusCom.setMainBrId(iqpmeApiCop.getBrId());
			  cusCom.setCustMgr(iqpmeApiCop.getCusMgr());
			  cusCom.setInputId(iqpmeApiCop.getInputId());
			  cusCom.setInputDate(DateUtils.getDate1());
			  cusCom.setInputBrId(SystemConfig.cacheMap.get("GBCN_INPUT_ORG"));
			  cusCom.setLastUpdId(iqpmeApiCop.getCusMgr());
			  cusCom.setLastUpdDate(DateUtils.getDate1());
			  cusCom.setCusStatus("00");
			  cusCom.setBelongTo(GBCNConstant.CUST_BELONG);
			  cusCom.setCusName(applicantInfo.getName());
			  cusCom.setCertCode(applicantInfo.getIdNumber());
			  cusCom.setCusType("211");
			  cusCom.setComInsCode(applicantInfo.getIdNumber());
			  cusComMapper.insertSelective(cusCom);	
		}
		return base;
	}

	private ResponseBody processPayResult(String response,String serno) {
		ResponseBody result = new ResponseBody();
        result.setResponseTime(DateUtils.getDate());
        result.setResultFlag(false);
        if(StringUtils.isEmpty(response)){
            result.setResultMessage("获取支付url无响应，缴纳保费失败");
            return result;
        }
        JSONObject jsonObject = JSON.parseObject(response);
        if (jsonObject == null || !response.contains("STATUS")) {
             String errormessage = jsonObject.getString("ERRORMESSAGE");
             if (StringUtils.isEmpty(errormessage)) {
                 result.setResultMessage("获取支付链接url失败");
             } else {
                 result.setResultMessage(errormessage);
             }
             return result;
        }
        // 状态 成功失败标识 0- 成功 1- 失败
        String status = jsonObject.getString("STATUS");
        if("1".equals(status)){
            String errormessage = jsonObject.getString("ERRORMESSAGE");
            if (StringUtils.isEmpty(errormessage)) {
                result.setResultMessage("获取支付链接url为空");
            } else {
                if(errormessage.contains("请勿重复出单")) {
                    result.setResultMessage("请重新点击刷新状态");
                    logger.info("【已经缴费并出单，但未回调，通过返回失败设置出单状态】");
                } else {
                    result.setResultMessage(errormessage);
                }
            }
            return result;
        }
        JSONObject resut = jsonObject.getJSONObject("RESULT");
        if(CollectionUtils.isEmpty(resut)){
             String errormessage = jsonObject.getString("ERRORMESSAGE");
             if (StringUtils.isEmpty(errormessage)) {
                 result.setResultMessage("获取支付链接url为空");
             } else {
                 result.setResultMessage(errormessage);
             }
             return result;
        }
        //替换成pc端链接 https://m.sinosafe.com.cn/eb-web/pay/pc/index.html?sysCode=15&applyNo=199119532520
        String appPayUrl = resut.getString("url");
        String pcPayUrl = appPayUrl.replace("pay/m", "pay/pc").replace("sysCode=20", "sysCode=15");
        result.setYeepayurl(getQueryUrl(pcPayUrl));
        result.setResultMessage("投保成功");
        result.setResultFlag(true);
        LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectBySerno(serno);
        result.setProposalNo(lstIqpInfo.getCoverSerno());
        return result;
    }
	
	
	private String sendCentre(String serno, BigDecimal amount) throws Exception {
		Packet packet = new Packet();
		packet.setType("REQUEST");
		packet.setVersion("1.0");
		Head head = new Head();
		head.setRequestType("B04S010004");
		head.setRequestUser("xb_app");
		head.setTransactionCode(GBCNConstant.CENTRE_KEY);
		head.setBusinessNo(GBCNConstant.CENTRE_KEY);
		head.setTransDate(DateUtils.getDate1());
		String dateTime = DateUtils.getDate();
		head.setTransTime(dateTime);
		packet.setHead(head);
		Body body = new Body();
		body.setSend_type("01");
		body.setTrans_no(GBCNConstant.CENTRE_KEY);
		body.setTrans_time(dateTime);
		body.setSerno(serno);
		body.setIns_amount(String.valueOf(amount));
		packet.setBody(body);
		String xmlStr = XmlUtil.toXML(packet);
		xmlStr = xmlStr.replaceAll("standalone=\"yes\"", "");
		logger.info("【核心出单请求】 ：" + xmlStr);
		String centreResult = HttpClientUtil.doPostXML(SystemConfig.cacheMap.get("GBCN_CHUDAN_URL"), xmlStr);
	    logger.info("【核心出单返回】 ：" + XmlUtil.format(centreResult));
	    //出单不成功则 返回出单不成功原因
	    PacketResult resultObj = (PacketResult) XmlUtil.xml2Object(centreResult, PacketResult.class);
	    if(!"0000".equals(resultObj.getHead().getBusinessNo())){
	    	throw new BusinessException(resultObj.getHead().getErrorMessage());
	    }
	    return centreResult;
	}

    private LstIqpInfo insertLstIqpInfo(InsureApplicantInfo applicantInfo,InsurePolicyInfo insurePolicyInfo,
			CusBase base, IqpMeLoanApp imLoan,IqpMeApiCop iqpmeApiCop) throws Exception {
		LstIqpInfo lstIqpInfo = new LstIqpInfo();
		lstIqpInfo.setCusId(imLoan.getCusId());
		lstIqpInfo.setCusName(imLoan.getCusName());
		lstIqpInfo.setMobile(applicantInfo.getMobile());
		lstIqpInfo.setCusType(imLoan.getCusType());
		lstIqpInfo.setCertCode(imLoan.getCertCode());
		lstIqpInfo.setCertType(GBCNConstant.CRET_TYPE);
		
		lstIqpInfo.setPrdName(GBCNConstant.PRODUCT_NAME);
		lstIqpInfo.setPrdId(GBCNConstant.PRODUCT_ID);
		//设置特殊分保特殊标识为1
		lstIqpInfo.setReSpecialInd("1");
		
		lstIqpInfo.setMgrId(iqpmeApiCop.getCusMgr()); 
		lstIqpInfo.setMgrOrg(iqpmeApiCop.getBrId());
		lstIqpInfo.setInputId(iqpmeApiCop.getInputId());
		lstIqpInfo.setBelongBrId(SystemConfig.cacheMap.get("GBCN_PT_ORG"));
		lstIqpInfo.setMainBrId(iqpmeApiCop.getBrId());
		lstIqpInfo.setMgrOrg(iqpmeApiCop.getBrId());
		lstIqpInfo.setTradeSign("02");
		lstIqpInfo.setInsuranceType("01");
       // Date payDate =  new Date();
        Date startDate = new Date();//DateUtils.addDays(payDate, 30);
        String addday = SystemConfig.cacheMap.get("GBCN_END_DATE");
        Date endDate = DateUtils.addDays(startDate, Integer.valueOf(addday));
		lstIqpInfo.setCoverStartDate(DateUtils.format(startDate, "yyyy-MM-dd"));
		lstIqpInfo.setCoverEndDate(DateUtils.format(endDate, "yyyy-MM-dd"));
		lstIqpInfo.setInputDate(DateUtils.getDate1());
        lstIqpInfo.setToubaoDate(DateUtils.getDate1());
        lstIqpInfo.setP2pFlag("01");
        lstIqpInfo.setStatus("997");
		lstIqpInfo.setInvoiceType("03"); //开电子发票
		Connection conn = dataSource.getConnection();
		lstIqpInfo.setReceiverCusId(SequenceUtil.getPrjCopNo(conn));
		if(conn!=null){
			conn.close();
		}
		lstIqpInfo.setReceiveCusPhone(applicantInfo.getTendereeContactPhoneNumber());
		lstIqpInfo.setReceiveCusCertCode(applicantInfo.getTendereeCode());
		lstIqpInfo.setReceiverCusAddress(applicantInfo.getTendereeAddress());
		lstIqpInfo.setReceiveLegalCertCode(applicantInfo.getTendereeCode());
		lstIqpInfo.setReceiveCusName(applicantInfo.getTendereeName());
		lstIqpInfo.setCoverageFee(insurePolicyInfo.getSumPremium());
		lstIqpInfo.setCoverAmount(insurePolicyInfo.getSumAmount());
		lstIqpInfo.setCoverCurrencyType(GBCNConstant.CURRENCY_TYPE);
		lstIqpInfo.setFeeCurrencyType(GBCNConstant.CURRENCY_TYPE);
		lstIqpInfo.setExcuseRate(new BigDecimal(0));
		lstIqpInfo.setRate(new BigDecimal(0.05));
		lstIqpInfo.setIqpLoanSerno(imLoan.getSerno());
		lstIqpInfo.setcAppnt(insurePolicyInfo.getEndorseText());
		lstIqpInfo.setBizMode("15");
		lstIqpInfoMapper.insertSelective(lstIqpInfo);
		return lstIqpInfo;
	}
    
    //担保金额小于等于200万
  	private  boolean insureRoute(BigDecimal sumAmount){
  		if(sumAmount== null){
  			return false;
  		}
  		if(sumAmount.compareTo(new BigDecimal("2000000"))>-1){
  			return false;
  		}
  		return true;
  	}
  	
  	



}
