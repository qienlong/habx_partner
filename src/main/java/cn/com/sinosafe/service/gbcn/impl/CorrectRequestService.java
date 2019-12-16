package cn.com.sinosafe.service.gbcn.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.SequenceUtil;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.ThreadLocalUtil;
import cn.com.sinosafe.common.util.XmlUtil;
import cn.com.sinosafe.domain.entity.IqpMeInsuranceInfo;
import cn.com.sinosafe.domain.entity.IqpMeInsured;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.IqpMeProjectInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PolicyModifyRecord;
import cn.com.sinosafe.domain.entity.SOrg;
import cn.com.sinosafe.domain.gbcn.request.CorrectRequest;
import cn.com.sinosafe.domain.gbcn.request.CorrectRequest.CorrectRequestBody;
import cn.com.sinosafe.domain.gbcn.response.BaseResponse.ResponseBody;
import cn.com.sinosafe.domain.gbcn.response.GBResponse;
import cn.com.sinosafe.domain.gbcn.response.GBResponse.CorrectResponse;
import cn.com.sinosafe.service.gbcn.CommonService;
import cn.com.sinosafe.service.gbcn.GbcnService;

import com.alibaba.fastjson.JSONObject;


@Service(value = GBCNConstant.CORRECT_REQUEST)
public class CorrectRequestService extends CommonService implements GbcnService<ResponseBody,String>{

    private static final Logger logger = LoggerFactory.getLogger(CorrectRequestService.class);

    public GBResponse<CorrectResponse> getResultObj(){
        return CorrectResponse.getInstance();
    }
    
	@SuppressWarnings("unchecked")
    public ResponseBody process(String param) throws Exception {
        CorrectRequest correctRequest = (CorrectRequest) XmlUtil.xml2Object(param, CorrectRequest.class);
        //通过保单号获取投保单信息
        CorrectRequestBody requestBody = correctRequest.getRequestBody();
        LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(requestBody.getPolicyno());
        if(lstIqpInfo == null){
            return new ResponseBody(DateUtils.getDateTime(), false,"无此保单号，请核验后再试");
        }
        //校验批改参数合法性
        if(!DateUtils.isDate(correctRequest.getRequestBody().getCorrectInfo().getDateInfo().getStratDate())||
        !DateUtils.isDate(correctRequest.getRequestBody().getCorrectInfo().getDateInfo().getEndDate())){
            return new ResponseBody(DateUtils.getDateTime(), false,"批改日期有误");
        }
        try {
            //调用电子签章系统，生成新保单
        	 Map<String, String> mapResult2 = new HashMap<String, String>();
             mapResult2.put("sessionID", ThreadLocalUtil.get("sessionID"));
             redisUtils.setValue(GBCNConstant.CORRECT_REQUEST + requestBody.getPolicyno(), mapResult2, 60 * 60 * 24 * 1);
            //调用批改dubbo接口,生成批单号
             // 不走核心系统 
             String center = SystemConfig.cacheMap.get("GBCN_CORRECT_CENT");
             if("1".equals(center)){ //1 就走核心
                 JSONObject correctResult = getEndor(lstIqpInfo,requestBody);
                 String status = (String) correctResult.get("status");
                 if (!"0".equals(status)) {
                     String errorMessage = (String) correctResult.get("errorMessage");
                     logger.info("失败原因--->"+errorMessage);
                     return new ResponseBody(DateUtils.getDateTime(), false,errorMessage);
                 }
                 //批改信息入库
                 insertPMRecord(lstIqpInfo, requestBody, correctResult); 
             }
            //更新原保单信息
            updateLstIqpInfo(lstIqpInfo, requestBody);
            //更新被保险人信息
            updateIqpMeInsured(lstIqpInfo.getIqpLoanSerno(), requestBody);
            //更新保险责任
            updateIqpMeInsurance(lstIqpInfo.getIqpLoanSerno(), requestBody);
            //更新项目信息
            IqpMeProjectInfo iqpMeProjectInfo = iqpMeProjectInfoMapper.selectByIqpSerno(lstIqpInfo.getIqpLoanSerno());
            String projectSubject = requestBody.getCorrectInfo().getBaqRequiredInfo().getProjectName();
            projectSubject = projectSubject.replace("•", "·");
            iqpMeProjectInfo.setProjectSubject(projectSubject);
            iqpMeProjectInfo.setBidNoticeNumber(requestBody.getCorrectInfo().getBaqRequiredInfo().getProjectNo());
            iqpMeProjectInfoMapper.updateByPrimaryKeySelective(iqpMeProjectInfo);
            sendSeal(lstIqpInfo,GBCNConstant.getLocalIpPort() + GBCNConstant.CORRECT_CALLBACK,null);
            SOrg sOrg = orgMapper.selectByOrganno(lstIqpInfo.getBelongBrId());
           int num = 1;
           String insurePdf = null;
           String assurePdf = null;
            Thread.sleep(6000);
            do {
              Map<String, String> mapResult = (Map<String, String>) redisUtils.getValue(GBCNConstant.CORRECT_REQUEST+requestBody.getPolicyno());
              String guaranteeUrl = mapResult.get("guaranteeUrl");
              if(StringUtils.isNotEmpty(guaranteeUrl)){
            	  insurePdf = mapResult.get("downLoadUrl");
            	  assurePdf	= guaranteeUrl; 
            	  redisUtils.remove(GBCNConstant.CORRECT_REQUEST + requestBody.getPolicyno());
            	  break;
              }
              num += 1;
              Thread.sleep(1000);
          }while (num < 50);
            //保单起期和止期
            StringBuilder insuranceTime = new StringBuilder();
            insuranceTime.append(requestBody.getCorrectInfo().getDateInfo().getStratDate()).append("至").append(requestBody.getCorrectInfo().getDateInfo().getEndDate());
            if(StringUtils.isEmpty(insurePdf)){
            	 return new ResponseBody(DateUtils.getDateTime(), false,"处理时间太久了");
              }
              insurePdf = SystemConfig.cacheMap.get("GBCN_GATEWAY_URL")+"/gbcn/download/"+lstIqpInfo.getListSerno()+"bd";
              assurePdf = SystemConfig.cacheMap.get("GBCN_GATEWAY_URL")+"/gbcn/download/"+lstIqpInfo.getListSerno()+"bh";
              insurePdf = getQueryUrl(insurePdf);
              assurePdf = getQueryUrl(assurePdf);
            return new ResponseBody(DateUtils.getDateTime(), true,"处理成功",insurePdf,assurePdf,insuranceTime.toString(),sOrg.getTelnum());
        }catch (Exception e){
            e.printStackTrace();
            logger.info("错误信息--->"+e.getMessage());
            return new ResponseBody(DateUtils.getDateTime(), false,"系统繁忙");
        }

	}

   
    private void updateIqpMeInsurance(String iqpSerno,CorrectRequestBody requestBody) {
    	IqpMeInsuranceInfo insurance = new IqpMeInsuranceInfo();
    	String stratDate = requestBody.getCorrectInfo().getDateInfo().getStratDate().substring(0,10); //起保日期
        String endDate = requestBody.getCorrectInfo().getDateInfo().getEndDate().substring(0,10); //终保日期
    	insurance.setInsuranceStartTime(stratDate);
 	    insurance.setInsuranceEndTime(endDate);
 	    Date startDate1 = DateUtils.strToDate("yyyy-MM-dd", stratDate);
 	    Date endDate1 = DateUtils.strToDate("yyyy-MM-dd", endDate);
 	    double amountDay = DateUtils.getDaysBetweenDate(startDate1, endDate1);
	    insurance.setInsuranceAmountDay(new Double(amountDay).longValue());
 	    insurance.setIqpSerno(iqpSerno);
    	iqpMeInsuranceInfoMapper.updateByPrimarySerno(insurance);		
    	//更新申请表中的信息
		IqpMeLoanApp imLoan = new IqpMeLoanApp();
		imLoan.setSerno(iqpSerno);
		imLoan.setTermDay(new BigDecimal(amountDay));
    	iqpMeLoanAppMapper.updateByPrimaryKeySelective(imLoan);
	}

	private void updateIqpMeInsured(String iqpLoanSerno,
			CorrectRequestBody requestBody) {
    	IqpMeInsured iqpMeInsured = new IqpMeInsured();
    	iqpMeInsured.setSerno(iqpLoanSerno);
    	//iqpMeInsured.setInsuredAddress(requestBody.getCorrectInfo().getBaqRequiredInfo().getTendereeAddress());
    	iqpMeInsured.setInsuredCertCode(requestBody.getCorrectInfo().getInsuredInfo().getIdNumber());
    	iqpMeInsured.setInsuredName(requestBody.getCorrectInfo().getInsuredInfo().getName());
    	iqpMeInsured.setInsuredPhone(requestBody.getCorrectInfo().getInsuredInfo().getMobile());
    	iqpMeInsuredMapper.updateByPrimaryKey(iqpMeInsured);
	}

	/**
     * @Description 调用批改dubbo接口,生成批单号
     * @Date 2019/9/11 14:20
     * @return com.alibaba.fastjson.JSONObject
     */
    private JSONObject getEndor(LstIqpInfo lstIqpInfo, CorrectRequestBody requestBody) throws Exception {
        JSONObject insuredList = new JSONObject();
        insuredList.put("RiskCode",lstIqpInfo.getPrdId());
        insuredList.put("InsuredName",requestBody.getCorrectInfo().getInsuredInfo().getName());
        insuredList.put("InsuredType","2");
        insuredList.put("IdentifyNumber",requestBody.getCorrectInfo().getInsuredInfo().getIdNumber());
        insuredList.put("IdentifyType",lstIqpInfo.getReceiveCusCertType());
        insuredList.put("InsuredAddress",requestBody.getCorrectInfo().getBaqRequiredInfo().getTendereeAddress());
        insuredList.put("Phone",requestBody.getCorrectInfo().getInsuredInfo().getMobile());
        JSONObject main = new JSONObject();
        main.put("EndorType","03");
        String endDate = requestBody.getCorrectInfo().getDateInfo().getEndDate().substring(0,10); //终保日期
        main.put("ValidDate",endDate);
        main.put("PolicyNo",requestBody.getPolicyno());
        main.put("EndorDate", DateUtils.getDate1());
        main.put("OuterSysTransMode","2");
        main.put("InsuredList",insuredList);
        JSONObject json = new JSONObject();
        json.put("InfCode","cmis");
        json.put("RequestTime",DateUtils.getDateTime());
        json.put("Main",main);
        logger.info("调用dubbo批改接口发送信息"+json.toJSONString());
        byte[] bytes = infOutSystemService.endorExecute(json.toJSONString().getBytes("utf-8"));
        String result = new String(bytes, "utf-8");
        logger.info("调用dubbo批改接口返回信息"+result);
        return JSONObject.parseObject(result);
    }

    /**
     * @Description 批改信息入库
     * @Date 2019/9/11 14:56
     * @return void
     */
    private void insertPMRecord(LstIqpInfo lstIqpInfo, CorrectRequestBody requestBody, JSONObject correctResult) {
        PolicyModifyRecord record = new PolicyModifyRecord();
        String endorNo = (String) correctResult.get("endorNo"); //批改申请单号
        String policyEndorNo = (String) correctResult.get("policyEndorNo"); //批单号
        //原保单信息
        oldPolicyModify(lstIqpInfo, record);
        //批改信息
        //record.setPrdName(requestBody.getCorrectInfo().getBaqRequiredInfo().getProjectName()); //产品名称
        //record.setPrdId(requestBody.getCorrectInfo().getBaqRequiredInfo().getProjectNo()); //产品编号
        record.setModfReceiveCusName(requestBody.getCorrectInfo().getInsuredInfo().getName()); //批改后被保险人名称
        record.setModfReceiveCusCertCode(requestBody.getCorrectInfo().getInsuredInfo().getIdNumber()); //批改后被保险人证件号码
        record.setModfReceiveCusPhone(requestBody.getCorrectInfo().getInsuredInfo().getMobile()); //批改后被保险人联系电话
        record.setModfReceiverCusAddress(requestBody.getCorrectInfo().getBaqRequiredInfo().getTendereeAddress()); //批改后被保险人地址
        String stratDate = requestBody.getCorrectInfo().getDateInfo().getStratDate().substring(0,10); //起保日期
        String endDate = requestBody.getCorrectInfo().getDateInfo().getEndDate().substring(0,10); //终保日期
        record.setCoverStartDate(stratDate); //起保日期
        record.setModfCoverEndDate(endDate); //批改后保险止期
        record.setEndorsementSerno(policyEndorNo); //批单号
        record.setEndorNo(endorNo); //批单申请号
        record.setCoreAppSerno(endorNo); //核心返回批改申请单号
        record.setModType("03"); //批改类型 03批改标的信息
        record.setApproveStatus("000"); //审批状态
        record.setBizMode("15");
        String isPtextFlag = requestBody.getIsPtextFlag(); //自定义特别约定标识
        String endorseText = requestBody.getEndorseText(); //现特别约定内容
        if ("1".equals(isPtextFlag)) {
            record.setcAppntCurr(endorseText);
        }
        logger.info("批改入库信息--->"+JSONObject.toJSONString(record));
        pmRecordMapper.insertSelective(record);
    }


    /**
     * @Description 更新原保单信息
     * @Date 2019/9/11 14:49
     * @return void
     */
    private void updateLstIqpInfo(LstIqpInfo lstIqpInfo, CorrectRequestBody requestBody) throws Exception {
        String stratDate = requestBody.getCorrectInfo().getDateInfo().getStratDate().substring(0,10); //起保日期
        String endDate = requestBody.getCorrectInfo().getDateInfo().getEndDate().substring(0,10); //终保日期
        String isPtextFlag = requestBody.getIsPtextFlag(); //自定义特别约定标识
        String endorseText = requestBody.getEndorseText(); //现特别约定内容
        Connection connection = dataSource.getConnection();
        //lstIqpInfo.setPrdId(requestBody.getCorrectInfo().getBaqRequiredInfo().getProjectNo()); //产品编号
        //lstIqpInfo.setPrdName(requestBody.getCorrectInfo().getBaqRequiredInfo().getProjectName()); //产品名称
        lstIqpInfo.setReceiveCusName(requestBody.getCorrectInfo().getInsuredInfo().getName()); //被保险人姓名
        lstIqpInfo.setReceiverCusId(SequenceUtil.getPrjCopNo(connection)); //被保险人编号
        if(connection != null){
        	connection.close();
        }
        lstIqpInfo.setReceiveCusPhone(requestBody.getCorrectInfo().getInsuredInfo().getMobile()); //被保险人联系电话
        lstIqpInfo.setReceiverCusAddress(requestBody.getCorrectInfo().getBaqRequiredInfo().getTendereeAddress()); //被保险人地址
        lstIqpInfo.setReceiveCusCertCode(requestBody.getCorrectInfo().getInsuredInfo().getIdNumber()); //被保险人证件号码
        lstIqpInfo.setCoverStartDate(stratDate); //保险起期
        lstIqpInfo.setToubaoDate(stratDate);
        lstIqpInfo.setCoverEndDate(endDate); //保险止期
        if ("1".equals(isPtextFlag)) {
            lstIqpInfo.setcAppnt(endorseText); //现特别约定内容
        }
        logger.info("投保单更新信息为--->"+JSONObject.toJSONString(lstIqpInfo));
       
        lstIqpInfoMapper.updateByPrimaryKeySelective(lstIqpInfo);
    }
    
    
}
