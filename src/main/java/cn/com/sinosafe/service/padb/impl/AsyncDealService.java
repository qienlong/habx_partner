/**
 * 
 */
package cn.com.sinosafe.service.padb.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import cn.com.sinosafe.common.util.httpclient.ApiStringEncrypt;
import cn.com.sinosafe.common.util.httpclient.SignForRevOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import cn.com.sinosafe.api.BigDataService;
import cn.com.sinosafe.bigdata.other.ylm.YlmRequest;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.constant.EleListInfo;
import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.config.constant.PadbConstant;
import cn.com.sinosafe.common.config.constant.PspClaimConstant;
import cn.com.sinosafe.common.config.properties.ClaimProperties;
import cn.com.sinosafe.common.config.properties.MailProperties;
import cn.com.sinosafe.common.config.properties.SftpProperties;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.CommonUtils;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.FileUtils;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.RedisUtils;
import cn.com.sinosafe.common.util.SequenceUtil;
import cn.com.sinosafe.common.util.SftpUtil;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.dao.AccImportRecordsMapper;
import cn.com.sinosafe.dao.AccLoanMapper;
import cn.com.sinosafe.dao.FeeRateMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.IqpMePaCreditCancelMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.PrjChnPrdInfoMapper;
import cn.com.sinosafe.dao.PrjCopAccMapper;
import cn.com.sinosafe.dao.PrjCopTrustPlanMapper;
import cn.com.sinosafe.dao.PspClaimApproveMapper;
import cn.com.sinosafe.dao.PspClaimListMapper;
import cn.com.sinosafe.dao.PspClaimLoanMapper;
import cn.com.sinosafe.domain.bean.ClaimResultEnum;
import cn.com.sinosafe.domain.bean.EmailTemplateEnum;
import cn.com.sinosafe.domain.bean.SentStatusCode;
import cn.com.sinosafe.domain.dto.PaLstDownloadMsg;
import cn.com.sinosafe.domain.entity.AccImportRecords;
import cn.com.sinosafe.domain.entity.AccLoan;
import cn.com.sinosafe.domain.entity.FeeRate;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.IqpMePaCreditCancel;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PrjChnPrdInfo;
import cn.com.sinosafe.domain.entity.PrjCopAcc;
import cn.com.sinosafe.domain.entity.PrjCopTrustPlan;
import cn.com.sinosafe.domain.entity.PspClaimApprove;
import cn.com.sinosafe.domain.entity.PspClaimList;
import cn.com.sinosafe.domain.entity.PspClaimLoan;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.common.AutoClaimService;
import cn.com.sinosafe.service.padb.CheckInsureConFirmService;
import cn.com.sinosafe.service.padb.NoticeInsureIqpResultService;
import cn.com.sinosafe.service.padb.PaLstIqpInfoSyncService;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import net.sf.json.JSONObject;

/**  
* <p>Title: AsyncDealService</p>  
* <p>Description: 异步处理方法 </p>  
* @author longxiaoqiang  
* @date 2019年6月28日  
*/
@Service
@Async
public class AsyncDealService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CheckInsureConFirmService confirmService;
	@Autowired
	private PaPhCommonService paPhCommonService;
	@Autowired
	private BigDataService bigDataService;
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private PaLstIqpInfoSyncService paLstIqpInfoSyncService;
	@Autowired
	private SftpProperties sftpProperties;
	@Autowired
	private EleListInfo eleListInfo;
	@Autowired
	private FeeRateMapper feeRateMapper;
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;
	@Autowired
	private NoticeInsureIqpResultService noticeInsureIqpResultService;
	@Autowired
    private CommonUtils commonUtils;
	@Autowired
	private MailProperties mailProperties;
	@Autowired
	private ClaimProperties claimProperties;
	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private AccImportRecordsMapper accImportRecordsDao;
	@Autowired
	private IqpMePaCreditCancelMapper iqpMePaCreditCancelMapper;
	@Autowired
	private AccLoanMapper accLoanMapper;
	@Autowired
	private PspClaimListMapper pspClaimListMapper;
	@Autowired
	private PspClaimLoanMapper pspClaimLoanMapper;
	@Autowired
	private PspClaimApproveMapper pspClaimApproveMapper;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private PrjCopAccMapper prjCopAccMapper;
	@Autowired
	private AutoClaimService autoClaimService;
	@Autowired
	private PrjCopTrustPlanMapper prjCopTrustPlanMapper;
	@Autowired
	private PrjChnPrdInfoMapper prjChnPrdInfoMapper;

	//调用核保确认接口
	public String sendCheckIssueResult(Map<String, Object> paramMap) {
		boolean flag = false;
		String resultMsg = "";
		Map<String, Object> resultMap = null;
		try {
			for (int i=0;i<3;i++) {//调用失败的情况重复调3次
				if (!flag) {
					logger.info("------核保确认接口第【"+i+"】次发送");
					resultMsg = confirmService.sendInsureConfirmInfo(paramMap);
					logger.info("------核保确认接口平安返回报文"+resultMsg);
					resultMap = JSONUtils.getSingleInstance().readMapValue(resultMsg);
					String resultCode = (String)resultMap.get("resultCode");
					if ("9999".equals(resultCode)) {
						Thread.sleep(10000);
						continue;
					} else {
						flag = true;
						break;
					}
				}
			}
			if (!flag) {//三次调用都返回失败后发送邮件
				// 发送警报邮件
				commonUtils.commomMail("华安-普惠核保确认失败！", JSONUtils.getSingleInstance().toJSon(paramMap), mailProperties.getReciverAddress(), mailProperties.getCcAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "";
	}
	
	public void statusUpdateService(String serno,String code ,String name){
		try {
			//业务轨迹
			paPhCommonService.statusUpdateService(serno, code, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertBizLog(String serno,String interfaceNo ,Map<String, Object> paramMap,String resultMsg){
		try {
			paPhCommonService.insertBizLog(serno, interfaceNo, JSON.toJSONString(paramMap), resultMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkCard4Param(String applNo,String custName,String id,String bankNo,String bnMobile){
		logger.info("*****************************feign 接口 checkCard4Param start*****************************");
		logger.info("applNo:{},id:{},custName:{},bankNo:{},bnMobile:{}",applNo,id,custName,bankNo,bnMobile);
		try {
			YlmRequest request = new YlmRequest();
			request.setName(custName);
			request.setBankcard(bankNo);
			request.setIdcard(id);
			request.setMobile(bnMobile);
			request.setSerno(PadbConstant.PADB_SYSTEM);
			JsonProtocol jsonProtocol = bigDataService.ylmPy1362Query(request);
			logger.info("申请号{},四要素校验返回结果：{}",applNo,JSON.toJSONString(jsonProtocol));
//			commonService.checkCard4Param(custName,id,bankNo,bnMobile);
		} catch (Exception e) {
			logger.error("error:{}",e.getMessage());
		}
		logger.info("*****************************feign 接口 checkCard4Param end*****************************");
	}

	/**
	 * 平安付接口
	 * @param applNo
	 * @param custName
	 * @param id
	 * @param bankNo
	 * @param bnMobile
	 * @param cidNo
	 */
	public void paCheckCard4Param(String applNo, String custName, String id, String bankNo, String bnMobile,String cidNo) throws Exception {
		logger.info("*****************************平安付接口 paCheckCard4Param start*****************************");
		logger.info("applNo:{},id:{},custName:{},bankNo:{},bnMobile:{},cidNo:{}",applNo,id,custName,bankNo,bnMobile,cidNo);
		Map<String, String> requestmap = new HashMap<String, String>();
        requestmap.put("version", "1.0.0"); // 消息版本号
        requestmap.put("charset","UTF-8"); //字符编码
        requestmap.put("signMethod","SHA-256"); //签名方法
        requestmap.put("transType","089"); //交易类型
        requestmap.put("platMerchantId",SystemConfig.cacheMap.get("PLAT_MERCHANT_ID")); //平台商户号
        requestmap.put("merchantSeqNo",applNo); //商户订单号
        requestmap.put("customerId",cidNo); //平安付会员号
        requestmap.put("bankEnc",ApiStringEncrypt.encrypt(bankNo,SystemConfig.cacheMap.get("MERCHANT_ID_KEY"))); //卡号
        requestmap.put("identityType","I"); //证件类型
        requestmap.put("identityNumber",id); //证件号码
        requestmap.put("accountName",custName); //姓名
        requestmap.put("telephone",bnMobile); //手机号
        // merchantId
        requestmap.put("merchantId", SystemConfig.cacheMap.get("MERCHANT_ID"));
        Map<String, String> merReservedMap = new HashMap<String, String>();
        merReservedMap.put("signType", "0");// 0为快捷签约
        merReservedMap.put("PAFMember", "0");// 0为不是平安付会员 1为是平安付会员
        merReservedMap.put("customerPAFId", "");// 当PAFMember为1时，customerPAFId平安付会员号必传，平安付会员号由域账号注册接口获取
        // merReserved
        requestmap.put("merReserved", JSON.toJSONString(merReservedMap));

        // 签名
        // signature
        requestmap.put("signature", SignForRevOrder.sign(requestmap, SystemConfig.cacheMap.get("MERCHANT_ID_KEY")));
		boolean flag = false;
		String resultMsg = "";
		try {
			for (int i=0;i<3;i++) {//调用失败的情况重复调3次
				if (!flag) {
					logger.info("------平安付接口第【"+i+"】次发送");
					resultMsg = confirmService.sendPaCheckCard4Param(requestmap);
					if (resultMsg==null || resultMsg=="") {
						Thread.sleep(5000);
						continue;
					} else {
						flag = true;
						break;
					}
				}
			}
			logger.info("------平安付接口返回报文"+resultMsg);
			if (!flag) {//三次调用都返回失败后发送邮件
				// 发送警报邮件
				commonUtils.commomMail("华安-平安付接口调用失败！", JSONUtils.getSingleInstance().toJSon(requestmap), mailProperties.getReciverAddress(), mailProperties.getCcAddress());
			}
		} catch (Exception e) {
			logger.error("error:{}",e.getMessage());
		}
		logger.info("*****************************平安付接口 paCheckCard4Param end*****************************");
	}

	/*
	 * 执行出单
	 */
	public void sendMsgToList(String addr,String pattern,LstIqpInfo lstIqpInfo,String inputName){
		logger.info("*****************************feign 接口 sendMsgToList start*****************************");
		logger.info("addr:{},pattern:{}",addr,pattern);
		try {
			IqpMeLoanApp iqpMeLoanApp=iqpMeLoanAppMapper.selectByPrimaryKey(lstIqpInfo.getIqpLoanSerno());
			FeeRate feeRate=new FeeRate();
			feeRate = feeRateMapper.queryFeeRateInfoByIqp(iqpMeLoanApp);
			
			//生成保费分期计划
			String code = createCoverFeePlan(lstIqpInfo,feeRate);
			
			if (!"0".equals(code)) {
				return;
			}
			
			//报文格式 调出单
			String reqXml=String.valueOf(reqXml(lstIqpInfo.getSerno(),lstIqpInfo.getCoverageFee()));
			String resultMsg=HttpClientUtil.httpSend(addr, reqXml, pattern);
			if(resultMsg.indexOf("ErrorCode")!=-1) {
				resultMsg = resultMsg.split("<ErrorMessage>")[1];
				String failDesc = resultMsg.split("</ErrorMessage>")[0];
			    if("成功".equals(failDesc)) {
			    	logger.info(lstIqpInfo.getIqpLoanSerno()+"\n出单成功");
			    	//调电子保单
			    	sendEleListParam(lstIqpInfo,inputName,feeRate);
			    }else {
			        logger.info(lstIqpInfo.getIqpLoanSerno()+"\n出单失败,原因：" + failDesc); 
			        insertBizLog(lstIqpInfo.getIqpLoanSerno(), "FO004002", new HashMap<String,Object>(), lstIqpInfo.getIqpLoanSerno()+"\n出单失败,原因：" + failDesc);
			    }      
		    }else {
		    	logger.info(lstIqpInfo.getIqpLoanSerno()+"\n出单成功");
		    	sendEleListParam(lstIqpInfo,inputName,feeRate);
		    }
		} catch (Exception e) {
			logger.error("error:{}",e.getMessage());
		}
		logger.info("*****************************feign 接口 sendMsgToList end*****************************");
	}
	/*
	 * 调电子保单生成接口
	 */
	public void sendEleListParam(LstIqpInfo lstIqpInfo,String inputName,FeeRate feeRate){
		logger.info("*****************************feign 接口 sendEleListParam start*****************************");
		logger.info("lstIqpInfo:{},pattern:{},feeRate{}",lstIqpInfo,inputName,feeRate);
		try {
			LstIqpInfo liInfo=lstIqpInfoMapper.selectBySernoAndStatus(lstIqpInfo);
			String jsonData = eleListInfo.getEleListInfo(liInfo, inputName,feeRate);
			logger.info("电子保单生成参数={}",jsonData);
			HttpClientUtil.httpPostPh(SystemConfig.cacheMap.get("PAPH_ELE_URL"), jsonData);
//			Thread.sleep(60000);
//			Map<String,Object> eleStatus = lstIqpInfoMapper.selectEleStatus(liInfo.getListSerno());
//			if ("2".equals((String)eleStatus.get("SEAL_STATUS"))) {
//				//接口状态码更新已出单
//				paPhCommonService.statusUpdateService(lstIqpInfo.getIqpLoanSerno(), SentStatusCode.PA_11.code(), "已出单");
//			}
		} catch (Exception e) {
			logger.error("error:{}",e.getMessage());
		}
		logger.info("*****************************feign 接口 sendEleListParam end*****************************");
	}
	/*
	 * 调电子保单生成接口
	 */
	public String createCoverFeePlan(LstIqpInfo lstIqpInfo,FeeRate feeRate){
		logger.info("*****************************生成保费分期计划 start*****************************");
		String code = "";
		try {
			Map<String, Object> map = new HashMap<String,Object>();
			map = LstIqpApplyConstant.lstInfoToFeePlan(lstIqpInfo,feeRate);
			if (map!=null && map.size()>0) {
				String sendParams = JSONUtils.getSingleInstance().toJSon(map);
				logger.info("param={}", sendParams);
				
				//JsonProtocol installmentPlan = commonService.installmentPlan(JSON.parseObject(sendParams));
				//String result = JSONUtils.getSingleInstance().toJSon(installmentPlan);

				String result = HttpClientUtil.httpPostPh(SystemConfig.cacheMap.get("PAPH_COVERFEE_PLAN"), sendParams);
				logger.info("result={}", result);
				Map<String, Object> resultMap = JSONUtils.getSingleInstance().readMapValue(result);
				code = String.valueOf(resultMap.get("code"));
			}
		} catch (Exception e) {
			logger.error("error:{}",e.getMessage());
		}
		logger.info("*****************************生成保费分期计划 end*****************************");
		return code;
	}
	
	/**
	 * 
	* @Title：asyncInfoMsg 
	* @Description：异步推送保单信息到平安
	* @param ：@param sernos 保单流水号
	* @return ：void 
	* @throws
	 */
	public void asyncInfoMsg(List<String> sernos){
		for (String map : sernos) {
			String resultCode = "";
			try {
				if(!StringUtils.isEmpty(map)){
					LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByPrimaryKey(map);
					if(null==lstIqpInfo){throw new BusinessException("lstiqpInfo is null");}
					//首先发送请求推送保单信息同步
					resultCode = paLstIqpInfoSyncService.infoSync(lstIqpInfo);
					//异步上传文件到sftp并通知平安
					asyncDownUpMsg(lstIqpInfo);
					//调用保单批单通知服务同步发短信通知客户出单
					//sendMsg(lstIqpInfo);
					
				}
			} catch (Exception e) {
				logger.error("map{},error:{}",map,e.getMessage());
				continue;
			}
			if ("0000".equals(resultCode)) {
				paPhCommonService.statusUpdateService(map, SentStatusCode.PA_12.code(), "保单已推送");
			}
		}
	}
	
	/**
	 * 
	* @Title：fcfpPolicyInfoSync 
	* @Description：异步发送保单信息同步给平安
	* @param ：@param applNo
	* @param ：@param resultCode
	* @param ：@return 
	* @return ：String 
	* @throws
	 */
	public String fcfpPolicyInfoSync(String accToken, String applNo,String resultCode){
		String resultMsg = noticeInsureIqpResultService.queryInsureIqpResult(accToken,applNo,resultCode);
		logger.info("报文：{}",resultMsg);
		return resultMsg;
	}
	
	/**  
	 * <p>Title: sendMsg</p>  
	 * <p>Description: 用保单批单通知服务同步发短信通知客户出单</p>  
	 * @param lstIqpInfo  
	 */
	private void sendMsg(LstIqpInfo lstIqpInfo) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("{0521险种名称}", lstIqpInfo.getPrdSubCode());
		map.put("${ply_no}", lstIqpInfo.getListSerno());
		paPhCommonService.pushSms(2, map, lstIqpInfo.getMobile());
	}
	
	private void asyncDownUpMsg(LstIqpInfo lstIqpInfo){
		logger.info("*****************************保单下载通知 start*****************************");
		try {
			//電子保單路徑 PAHA_申请号_POLICY_年月日_5位唯一流水号.pdf
			String policyUrl = "";//SystemConfig.cacheMap.get("ELE_POLICY_URL");	
			//下載路徑
			String downLoad = SystemConfig.cacheMap.get("PAPH_DOWNLOAD_PATH");
			File saveDir = new File(downLoad);
			if(!saveDir.exists()){
				saveDir.mkdirs();
			}  
			String ranNum = CommonUtils.randomNumbers(5);
			//加文件名的完整路徑
			downLoad += "PAHA_"+lstIqpInfo.getIqpLoanSerno()+"_POLICY_"+DateUtils.getDate("yyyyMMdd")+"_"+ranNum+".pdf";
			
			Map<String,Object> eleStatus = lstIqpInfoMapper.selectEleStatus(lstIqpInfo.getListSerno());
			if ("2".equals((String)eleStatus.get("SEAL_STATUS"))) {
				//获取电子保单、并放置到缓存中
				policyUrl = (String)eleStatus.get("SIGNED_PDF_URL");
				redisUtils.setValue(lstIqpInfo.getIqpLoanSerno(), policyUrl, 60 * 60 * 24 * 7);
				
				//policyUrl = policyUrl + "&BusinessCode=" + lstIqpInfo.getIqpLoanSerno() + "&FileId=ECONTRACTPDFUPTOIMAGESYSTEM_" + lstIqpInfo.getIqpLoanSerno()+".pdf";
				//將電子保單下載到指定路徑下
				FileUtils.httpClientGetMethod(policyUrl,downLoad);
				//上传保单pdf至sftp对应目录
				uploadPdfToPasftp(downLoad);
				//封装响应结果
				PaLstDownloadMsg pdm=new PaLstDownloadMsg(lstIqpInfo.getIqpLoanSerno(), lstIqpInfo.getListSerno(), "PAHA_"+lstIqpInfo.getIqpLoanSerno()+"_POLICY_"+DateUtils.getDate("yyyyMMdd")+"_"+ranNum+".pdf","1","ZHX","HABX");
				//PaLstDownloadMsg pdm = new PaLstDownloadMsg(lstIqpInfo.getIqpLoanSerno(),lstIqpInfo.getListSerno(),"ccc.pdf","1","ZHX","HABX");
				logger.info("*************** 发起http通知平安下载请求  start **************");
				logger.info("请求报文:{}",pdm.toString());
				//发送http请求到平安下载该文件
				String responsemessage = JSON.toJSONString(pdm);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("param", PaEncryptUtil.encryptByRSA(responsemessage));
				String resultMsg = HttpClientUtil.sendPosts(SystemConfig.cacheMap.get("FCFPBX1004"),jsonObject.toString());
				
				//發送之後刪除文件
				File file = new File(downLoad);
				file.delete();
				//String resultMsg=HttpClientUtil.sendPost(PadbConstant.FCFPBX1004, PaEncryptUtil.encryptByRSA(JSON.toJSONString(pdm)));
				logger.info("响应报文:{}",resultMsg);
				logger.info("************** 发起http通知平安下载请求  end **************");
				//请求响应日志
				paPhCommonService.insertBizLog(lstIqpInfo.getIqpLoanSerno(), "FCFPBX1004", JSON.toJSONString(pdm), resultMsg);
			}
			
		} catch (Exception e) {
			logger.error("threadId:{},error:{}",Thread.currentThread().getId(),e.getMessage());
		}
		logger.info("*****************************保单下载通知 end*****************************");
	}
	
	/**
	 * 
	* @Title：getLstIqpSteam 
	* @Description：获取保单pdf文件流
	* @param ：@param paramMap
	* @param ：@return 
	* @return ：File 
	* @throws
	 */
	private File getLstIqpSteam(String url,String fileName) throws Exception{
		File dir = new File(sftpProperties.localFileLocation);
		if(!dir.exists()){dir.mkdir();}
		dir=new File(sftpProperties.localFileLocation+File.separator+fileName);
		if(!dir.exists()){
			try {
				dir.createNewFile();
			} catch (IOException e) {
				new BusinessException("文件创建失败");
			}
		}
		return dir;
	}
	
	/**
	 * 
	* @Title：uploadPdfToPasftp 
	* @Description：上传文件至平安sftp并返回相关信息
	* @param ：@param file 
	* @return ：void 
	* @throws
	 */
	private void uploadPdfToPasftp(String localLoaction){
		try {
			//初始化sftp
			SftpUtil sftpUtil=new SftpUtil(sftpProperties.host, sftpProperties.port, sftpProperties.account, sftpProperties.pwd);
			logger.info("connect sftp star info:{}",sftpProperties.toString());
			//连接sftp
			sftpUtil.connect();
			//开始上传
			sftpUtil.upload(sftpProperties.uploadSftpLocation, localLoaction);
			//关闭连接
			sftpUtil.disconnect();
		} catch (Exception e) {
			logger.error("sftp connect error:{}",e.getMessage());
		}
	}
	/**
	 * 
	* @Title：reqXml 
	* @Description:出单报文
	* @param ：@param lstSerno 保单交易流水号
	* @param ：@param assureAmount 保费
	* @param ：@return 
	* @return ：StringBuilder 
	* @throws
	 */
	public StringBuilder reqXml(String lstSerno,BigDecimal assureAmount) {
		  StringBuilder reqXml = new StringBuilder();
		  SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		  Date now = new Date();
		  String date = df.format(now);
		  reqXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		  reqXml.append("<Packet type=\"REQUEST\" version=\"1.0\">");
		  reqXml.append("<Head>");
		  reqXml.append("<RequestType>B04S010004</RequestType>");
		  reqXml.append("<RequestUser>xb_app</RequestUser>");
		  reqXml.append("<TransactionCode>AHA2018071609200000001</TransactionCode>");
		  reqXml.append("<TransDate>"+DateUtils.formatDate(now, "yyyy-MM-dd")+"</TransDate>");
		  reqXml.append("<TransTime>"+DateUtils.formatDate(now, "HH:mm:ss")+"</TransTime>");
		  reqXml.append("</Head>");
		  reqXml.append("<Body>");
		  reqXml.append("<trans_no>"+date+"</trans_no>");
		  reqXml.append("<trans_time>"+date+"</trans_time>");
		  reqXml.append("<serno>"+lstSerno+"</serno>");
		  reqXml.append("<out_account>2015041000000020</out_account>");
		  reqXml.append("<ins_amount>"+assureAmount+"</ins_amount>");
		  reqXml.append("<send_type>02</send_type>");
		  reqXml.append("</Body>");
		  reqXml.append("</Packet>");
		  return reqXml;
	}
	public void cancelIqpInfo (List<Map<String, Object>> extendList,Map<String, Object> paramMap) {
		logger.info("*****************************feign 接口 cancelIqpInfo start*****************************");
		if (extendList!=null) {
			Map<String, Object> errorDate = null;
			for(int i=0 ; i < extendList.size();i++){
				errorDate =new HashMap<>();
				Map<String, Object> jsonObj = extendList.get(i);
				//记录授信制回退
				IqpMePaCreditCancel iqpMePaCreditCancel = LstIqpApplyConstant.mapConvertPaCreditCancel(jsonObj,paramMap);
				iqpMePaCreditCancelMapper.insertSelective(iqpMePaCreditCancel);
				//更新申请信息状态
				logger.info("更新申请信息  ipMeLoan start");
				IqpMeLoanApp iqpMeLoanApp = getIqpCondition(jsonObj);
				iqpMeLoanAppMapper.updateByPrimaryKeySelective(iqpMeLoanApp);
				logger.info("更新申请信息 ipMeLoan end");
				
				//查询已生成保单的投保单
				logger.info("更新保单状态  LstIqpInfo start");
				LstIqpInfo lstInfo=new LstIqpInfo();
				lstInfo.setIqpLoanSerno(String.valueOf(jsonObj.get("applNo")));
				LstIqpInfo lstIqpInfo=lstIqpInfoMapper.selectBySernoAndStatus(lstInfo);
				
				if(null==lstIqpInfo||!"04".equals(lstIqpInfo.getCoverCreateStatus())){
					if (lstIqpInfo!=null) {
						//注销投保单
						updateLstIqpInfo(lstIqpInfo);
						statusUpdateService(String.valueOf(jsonObj.get("applNo")), SentStatusCode.PA_13.code(), "授信制回退");
						logger.info("申请号{}还没生成保单或已注销,继续处理下一条！",String.valueOf(jsonObj.get("applNo")));
						continue;
					} else {
						continue;
					}
				} else {
					updateLstIqpInfo(lstIqpInfo);
				}
				
				//调接口注销保单
				Map<String,String> map = new HashMap<String,String>();
				map.put("applNo", String.valueOf(jsonObj.get("applNo")));
				String cancelDate = StringUtils.isEmpty(String.valueOf(jsonObj.get("rejectDate")))?DateUtils.getDate("yyyy-MM-dd HH:mm:ss"):DateUtils.format(DateUtils.parseDate(jsonObj.get("rejectDate")), "yyyy-MM-dd HH:mm:ss");
				map.put("refuseTime", cancelDate);
				map.put("policyNo", "");
				map.put("requestType", "02");
				String params;
				try {
					params = JSONUtils.getSingleInstance().toJSon(map);
					logger.info("调接口注销保单参数为={}",map.toString());
					String result = HttpClientUtil.httpPost(SystemConfig.cacheMap.get("PAPH_CANCEL_IQP"), params);
					logger.info("调接口注销保单返回={}",result);
					Map<String, Object> resultParam = JSONUtils.getSingleInstance().readMapValue(result);
					String retCode = (String)resultParam.get("retCode");
					if ("S".equals(retCode)) {
						statusUpdateService(String.valueOf(jsonObj.get("applNo")), SentStatusCode.PA_13.code(), "授信制回退");
					} else {
						errorDate.put(String.valueOf(jsonObj.get("applNo")), jsonObj);
						//记录申请信息
						insertErrorDate(errorDate);
					}
				} catch (Exception e) {
					logger.error("申请号{}调注销接口失败！", String.valueOf(jsonObj.get("applNo")));
					e.printStackTrace();
				} 
			}
		}
		logger.info("*****************************feign 接口 cancelIqpInfo end*****************************");
	}

	/**  
	 * <p>Title: updateLstIqpInfo</p>  
	 * <p>Description: </p>  
	 * @param lstIqpInfo  
	 */
	private void updateLstIqpInfo(LstIqpInfo lstIqpInfo) {
		lstIqpInfo.setStatus("998");
		lstIqpInfo.setApplyStatus("998");
		lstIqpInfo.setCoverCreateStatus("03");
		lstIqpInfoMapper.updateByPrimaryKeySelective(lstIqpInfo);
		logger.info("更新保单状态  LstIqpInfo end");
	}
	private IqpMeLoanApp getIqpCondition (Map<String,Object> paramMap) {
		IqpMeLoanApp iqpMeLoanApp = new IqpMeLoanApp();
		iqpMeLoanApp.setSerno(String.valueOf(paramMap.get("applNo")));
		iqpMeLoanApp.setApproveStatus("998");
		iqpMeLoanApp.setNewApproveStatus("998");
		iqpMeLoanApp.setAppStatus("998");
		return iqpMeLoanApp;
	}
	private void insertErrorDate (Map<String,Object> paramMap) throws JsonGenerationException, JsonMappingException, IOException {
		AccImportRecords accImportData=new AccImportRecords();
		accImportData.setSerno(String.valueOf(paramMap.get("applNo")));
		accImportData.setImportData(JSONUtils.getSingleInstance().toJSon(paramMap));
		accImportData.setImportDate(DateUtils.getDate("yyyy-MM-dd"));
		accImportData.setImportTime(DateUtils.getDate("HH:mm:ss"));
		accImportData.setMemo("平安普惠授信制回退注销失败记录");
		accImportData.setImportUserId("xwadmin");
		
		accImportRecordsDao.insert(accImportData);
	}
	
	@SuppressWarnings("unchecked")
	public void pspClaimAsynDeal (Map<String,Object> paramMap) {
		
		logger.info("*****************************feign 接口 pspClaimAsynDeal start***************************");
		
		List<Map<String, Object>> list = (List<Map<String, Object>>)paramMap.get("claimsApplyList");
		for (Map<String, Object> map : list) {
			try {
				//状态日志记录
				paPhCommonService.statusUpdateService(String.valueOf(map.get("applNo")), SentStatusCode.PA_17.code(), "核赔申请");
				
				PspClaimLoan pspClaimLoan = new PspClaimLoan(); //储存批量理赔数据
				PspClaimList pspClaimList = new PspClaimList(); //储存批量理赔清单数据
				PspClaimApprove pspClaimApprove = new PspClaimApprove(); //储存批量核赔数据
				
				Connection conn = dataSource.getConnection();
				String serno = SequenceUtil.getPspClaimSerialNo(conn);
				String pkid = SequenceUtil.getPspClaimSerialNo(conn);
				conn.close();
				
				//初步判断借据信息是否已存在
				AccLoan accLoan = accLoanMapper.selectByPrimaryKey(String.valueOf(map.get("lnAcct")));
				if (StringUtils.isNull(accLoan)) {
					
					//插入理赔审批表
					insertPspApprove(map,pkid,serno);
					map.put("pkid", pkid);
					continue;
				}
				//1、判断是否存在核赔记录
				boolean approveHis = pspClaimApproveHis(map);
				logger.info("借据号:{}存在核赔记录={}",String.valueOf(map.get("lnAcct")),String.valueOf(approveHis));
				if (approveHis) {//存在
					
					//获取相关金额
					getRelateAmt(map);
				}
				//2、新增核赔申请记录
				pspClaimLoan = addClaimRecorde(map,pspClaimLoan,pspClaimList,pspClaimApprove,approveHis,serno,pkid);
				
				//3、核赔校验
				String checkResult = checkClaimIqp(map,approveHis);
				logger.info("00通过，借据号={}的核赔结果为：{}",String.valueOf(map.get("lnAcct")),checkResult);
				
				map.put("pkid", pkid);
				
				if ("00".equals(checkResult)) {
					//状态日志记录
					paPhCommonService.statusUpdateService(String.valueOf(map.get("applNo")), SentStatusCode.PA_18.code(), "核赔通过");
					
					//4、调核心产生正赔案
					logger.info("正赔案申请流水号为："+pspClaimLoan.getSerno());
					boolean flag = autoClaimService.autoClaimLoanSerno(pspClaimLoan.getSerno());
					logger.info("调用生成正赔案接口结束，flag :"+flag);
					
					if(flag){
						logger.info("正赔案申请流水号为={}的正赔案生成成功",pspClaimLoan.getSerno());
					}else{
						// 发送警报邮件
						commonUtils.commomMail("平安普惠正赔案生成失败！", JSONUtils.getSingleInstance().toJSon(map), mailProperties.getReciverAddress(), mailProperties.getCcAddress());
					}
				} else {
					//更新核赔结果
					String content = ClaimResultEnum.getContent(checkResult);
					updateClaimLoan(pspClaimLoan);
					updateClaimApprove(pspClaimApprove,content,pkid);
					
					//状态日志记录
					paPhCommonService.statusUpdateService(String.valueOf(map.get("applNo")), SentStatusCode.PA_18.code(), content);
					
					//核赔不通过发送邮件保后手动处理
					String emailmsg = EmailTemplateEnum.getTemplate(2);
					emailmsg = emailmsg.replace("{appno}", String.valueOf(map.get("applNo"))).replace("{pkid}", pspClaimApprove.getPkId()).replace("{content}", content);
					commonUtils.commomMail("平安独立承保核赔不通过通知", emailmsg, claimProperties.getReciverAddress(), claimProperties.getCcAddress());
				}
			} catch (Exception e) {
				try {
					logger.error("借据号={}核赔异常", String.valueOf(map.get("lnAcct")));
					logger.error(e.getMessage());
					commonUtils.commomMail("平安普惠核赔异常！", JSONUtils.getSingleInstance().toJSon(map), mailProperties.getReciverAddress(), mailProperties.getCcAddress());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		try {
			//5、核赔结果通知
			String sendClaimResult = getClaimResult(paramMap);	
			
			logger.info("批次号={}发送的核赔结果为:{}",String.valueOf(paramMap.get("premBatchNo")),sendClaimResult);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("param", PaEncryptUtil.encryptByRSA(sendClaimResult));
			logger.info("加密后发送给平安的数据为：{}",jsonObject.toString());
			
			String result = HttpClientUtil.sendPosts(SystemConfig.cacheMap.get("FCFPBX4002"), jsonObject.toString());
			logger.info("批次号={}核赔响应结果为:{}",String.valueOf(paramMap.get("premBatchNo")),result);
			
			Map<String, Object> resultMap = JSONUtils.getSingleInstance().readMapValue(result);
			if (!"0000".equals(String.valueOf(resultMap.get("resultCode")))) {
				//邮件通知
				commonUtils.commomMail("平安普惠核赔结果通知响应异常！", sendClaimResult, mailProperties.getReciverAddress(), mailProperties.getCcAddress());
			}
			logger.info("*****************************feign 接口 pspClaimAsynDeal end*****************************");
		} catch (Exception e) {
			logger.error("-------------核赔批次号"+paramMap.get("premBatchNo")+"核赔结果通知异常-----------");
		}
		
		
	}

	/**  
	 * <p>Title: insertPspApprove</p>  
	 * <p>Description: </p>  
	 * @param paramMap
	 * @param pkid
	 * @param serno  
	 */
	private void insertPspApprove(Map<String, Object> paramMap, String pkid, String serno) {
		
		//理赔申请表
		PspClaimLoan pspClaimLoan = new PspClaimLoan();
		pspClaimLoan.setSerno(serno);
		pspClaimLoan.setBillNo(String.valueOf(paramMap.get("lnAcct")));
		String shortVal = String.valueOf(paramMap.get("lnTerm"));
		pspClaimLoan.setPsPerdNo(Short.parseShort(shortVal));
		
		pspClaimLoan.setClaimCond("02");//赔付方式 STD_ZB_CLAIM_COND
		pspClaimLoan.setClaimStatus("02");
		pspClaimLoan.setApproveStatus("998");
		pspClaimLoan.setApplyType("01");//预付
		pspClaimLoan.setSettleType("02");//理赔方式
		pspClaimLoan.setRepayplanSt("4"); //还款状态
		pspClaimLoan.setLossType("compen"); //损失类型：代偿
		
		pspClaimLoan.setClaimReason("borrower");//理赔原因
		
		pspClaimLoan.setClaimInputDate(DateUtils.getDate("yyyy-MM-dd"));
		
		pspClaimLoanMapper.insertSelective(pspClaimLoan);
		
		//核赔审批表
		String content = ClaimResultEnum.getContent("01");
		PspClaimApprove pspClaimApprove = new PspClaimApprove();
		
		pspClaimApprove.setPkId(pkid);
		pspClaimApprove.setClaimType("01");//STD_ZB_CLAIM_TYPE
		pspClaimApprove.setClaimApplyAmount(pspClaimLoan.getClaimAmount());
		pspClaimApprove.setIsGuar("0");//STD_HA_YES_NO
		pspClaimApprove.setClaimDate(DateUtils.getDate());
		pspClaimApprove.setClaimOrg("00");
		pspClaimApprove.setApprover("xwadmin");
		pspClaimApprove.setClaimApplyType("02");//STD_ZB_CLAIM_APPLY_TYPE
		pspClaimApprove.setClaimEndAmount(pspClaimLoan.getClaimAmount());
		pspClaimApprove.setClaimOpinion(content);
		pspClaimApprove.setClaimResult("02");//ZB_WFI_APPR_RSLT
		pspClaimApprove.setSerno(serno);
		
		pspClaimApproveMapper.insertSelective(pspClaimApprove);
		
		//索赔清单表
		PspClaimList pspClaimList = new PspClaimList();
		pspClaimList.setBillNo(String.valueOf(paramMap.get("lnAcct")));
		pspClaimList.setPsPerdNo(Integer.parseInt(String.valueOf(paramMap.get("lnTerm"))));
		
		//理赔金额
		pspClaimList.setUnsetPsCommOdInt(new BigDecimal("0"));
		pspClaimList.setEstOdCommAmt(new BigDecimal("0"));
		
		pspClaimList.setPerdStatus("0");//STD_ZB_STATUS
		pspClaimList.setSerno(serno);
		
		pspClaimListMapper.insertSelective(pspClaimList);
	}

	/**  
	 * <p>Title: getRelateAmt</p>  
	 * <p>Description: </p>  
	 * @param map  
	 */
	private void getRelateAmt(Map<String, Object> map) {
		//拆分得到本次理赔相关金额
		Map<String, BigDecimal> amtMap = getSplitAmt(map);
		map.put("thisprinAmt", amtMap.get("prinAmt"));
		map.put("thisintAmt", amtMap.get("intAmt"));
		map.put("thislcAmt", amtMap.get("lcAmt"));
		logger.info("本次理赔的金额分别为：本金={}，利息={}，罚息={}",map.get("thisprinAmt"),map.get("thisintAmt"),map.get("thislcAmt"));
		
		//历史成功+进行中的相关金额
		map.put("hisprinAmt", amtMap.get("hisprinAmt"));
		map.put("hisintAmt", amtMap.get("hisintAmt"));
		map.put("hislcAmt", amtMap.get("hislcAmt"));
		logger.info("历史理赔的金额分别为包括成功和失败：本金={}，利息={}，罚息={}",map.get("hisprinAmt"),map.get("hisintAmt"),map.get("hislcAmt"));
	}
	/**  
	 * <p>Title: getClaimResult</p>  
	 * <p>Description: 组装返回核赔结果数据</p>  
	 * @param paramMap
	 * @return  
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@SuppressWarnings("unchecked")
	private String getClaimResult(Map<String, Object> paramMap) throws JsonGenerationException, JsonMappingException, IOException {
		
		Map<String, Object> returnMap = new HashMap<String,Object>();
		returnMap.put("premBatchNo", String.valueOf(paramMap.get("premBatchNo")));
		returnMap.put("premCount", String.valueOf(paramMap.get("premCount")));
		returnMap.put("insuCompany", String.valueOf(paramMap.get("insuCompany")));

		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		List<Map<String, Object>> listMap = (List<Map<String, Object>>)paramMap.get("claimsApplyList");
		for (Map<String, Object> map:listMap) {
			Map<String, Object> claimMap = new HashMap<String,Object>();
			PspClaimApprove pspClaimApprove =  pspClaimApproveMapper.selectByPrimaryKey(String.valueOf(map.get("pkid")));
			claimMap.put("lnAcct", String.valueOf(map.get("lnAcct")));
			claimMap.put("applNo", String.valueOf(map.get("applNo")));
			claimMap.put("claimType", String.valueOf(map.get("claimType")));
			claimMap.put("indemnityNo", pspClaimApprove.getPkId());
			claimMap.put("clmAmtResult", "02".equals(pspClaimApprove.getClaimResult())?"20":"10");
			claimMap.put("failReason", pspClaimApprove.getClaimOpinion().subSequence(0, 2));
			claimMap.put("premResDate", DateUtils.getDate());
			
			list.add(claimMap);
		}
		returnMap.put("claimsApplyList", list);
		
		return JSONUtils.getSingleInstance().toJSon(returnMap);
	}

	/**  
	 * <p>Title: updateClaimApprove</p>  
	 * <p>Description: </p>  
	 * @param pspClaimApprove  
	 */
	private void updateClaimApprove(PspClaimApprove pspClaimApprove,String opinion,String pkid) {

		pspClaimApprove.setClaimResult("02");
		pspClaimApprove.setClaimOpinion(opinion);
		pspClaimApprove.setPkId(pkid);
		
		pspClaimApproveMapper.updateByPrimaryKeySelective(pspClaimApprove);
	}

	/**  
	 * <p>Title: updateClaimLoan</p>  
	 * <p>Description: </p>    
	 */
	private void updateClaimLoan(PspClaimLoan pspClaimLoan) {
		
		pspClaimLoan.setClaimStatus("02");
		pspClaimLoan.setApproveStatus("998");
		
		pspClaimLoanMapper.updateByPrimaryKeySelective(pspClaimLoan);
		
	}

	/**  
	 * <p>Title: checkClaimIqp</p>  
	 * <p>Description: 核赔校验</p>  
	 * @param map  
	 */
	private String checkClaimIqp(Map<String, Object> map,boolean approveHis) {
		String returnCode = "00";
		
		//1）借据不存在或者借据状态错误或者理赔账号不存在，则返回01-借据信息有误；
		AccLoan accLoan = accLoanMapper.selectByPrimaryKey(String.valueOf(map.get("lnAcct")));
		LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByPrimaryKey(accLoan.getIqpLoanSerno());
		PrjCopAcc prjCopAcc = prjCopAccMapper.selectByCopCusName(lstIqpInfo.getReceiveCusName());
		PrjCopTrustPlan prjCopTrustPlan = prjCopTrustPlanMapper.selectAcountByFunderId(String.valueOf(map.get("lnAcct")),prjCopAcc.getCopNo());
		PrjChnPrdInfo prjChnPrdInfo = prjChnPrdInfoMapper.selectByPrjAndPrd(prjCopAcc.getCopNo(), lstIqpInfo.getPrdId());
		BigDecimal oweRate = new BigDecimal("1").subtract(prjChnPrdInfo.getPreventRate());
		
		if (StringUtils.isNull(accLoan)) {
			returnCode = "01";
			return returnCode;
		}
		if (!"4".equals(accLoan.getAccountStatus())) {
			returnCode = "01";
			return returnCode;
		}
		if (StringUtils.isNull(prjCopTrustPlan)||StringUtils.isEmpty(prjCopTrustPlan.getSettleAcountNo())) {
			returnCode = "01";
			return returnCode;
		}
		//2）借据的理赔本金错误，则返回02-校验本金不通过；
		//校验本次理赔本金+成功理赔本金+进行中理赔本金=剩余贷款金*（1-免赔率）
		BigDecimal aa = new BigDecimal("0");
		BigDecimal ee = new BigDecimal("0");
		//BigDecimal bb = new BigDecimal(String.valueOf(map.get("lnAmt"))).multiply(oweRate);
		BigDecimal bb = accLoan.getLoanBalance().multiply(oweRate).setScale(2, BigDecimal.ROUND_HALF_UP);
		if (approveHis) {
			aa = new BigDecimal(String.valueOf(map.get("thisprinAmt"))).add(new BigDecimal(String.valueOf(map.get("hisprinAmt"))));
			ee = new BigDecimal(String.valueOf(map.get("thisprinAmt")));
			if (ee.compareTo(new BigDecimal("0"))==-1) {
				returnCode = "02";
				return returnCode;
			}
		} else {
			aa = new BigDecimal(String.valueOf(map.get("prinAmt")));
		}
		
		if ((aa.compareTo(bb))!=0) {
			returnCode = "02";
			return returnCode;
		}
		
		//3）借据的理赔总金额错误，则返回03-校验保额不通过；	
		//本次理赔总金额+成功理赔总金额+进行中理赔总金额<=保额*（1-免赔率）；
		Map<String, Object> lstInfo = accLoanMapper.getLstInfoByBillNo(String.valueOf(map.get("lnAcct")));
		BigDecimal cc = new BigDecimal("0");
		cc = new BigDecimal(String.valueOf(map.get("claimAmt")));
		
		BigDecimal dd = new BigDecimal(String.valueOf(lstInfo.get("COVERAMOUNT"))).multiply(oweRate).setScale(2, BigDecimal.ROUND_HALF_UP);
		if ((cc.compareTo(dd))==1) {
			returnCode = "03";	
			return returnCode;
		}
		
		return returnCode;
	}

	/**  
	 * <p>Title: addClaimRecorde</p>  
	 * <p>Description: </p>  
	 * @param map  
	 * @throws Exception 
	 */
	@Transactional(rollbackFor=Exception.class)
	private PspClaimLoan addClaimRecorde(Map<String, Object> map,PspClaimLoan pspClaimLoan,PspClaimList pspClaimList,PspClaimApprove pspClaimApprove,boolean approveHis,String serno, String pkid) throws Exception {
		AccLoan accLoan = accLoanMapper.selectByPrimaryKey(String.valueOf(map.get("lnAcct")));
		LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByPrimaryKey(accLoan.getIqpLoanSerno());
		PrjCopAcc prjCopAcc = prjCopAccMapper.selectByCopCusName(lstIqpInfo.getReceiveCusName());
		PrjChnPrdInfo prjChnPrdInfo = prjChnPrdInfoMapper.selectByPrjAndPrd(prjCopAcc.getCopNo(), lstIqpInfo.getPrdId());
		PrjCopTrustPlan prjCopTrustPlan = prjCopTrustPlanMapper.selectAcountByFunderId(String.valueOf(map.get("lnAcct")),prjCopAcc.getCopNo());
		
		if (StringUtils.isNull(prjCopAcc)) {
			logger.info("借据号：{}的合作方信息为空",String.valueOf(map.get("lnAcct")));
			throw new Exception("借据号："+String.valueOf(map.get("lnAcct"))+"的合作方信息为空");
		}else if (StringUtils.isNull(prjChnPrdInfo)) {
			logger.info("借据号：{}的合作方协议信息为空",String.valueOf(map.get("lnAcct")));
			throw new Exception("借据号："+String.valueOf(map.get("lnAcct"))+"的合作方协议信息为空");
		} else if (StringUtils.isNull(prjCopTrustPlan)) {
			logger.info("借据号：{}的合作方信托计划为空",String.valueOf(map.get("lnAcct")));
			throw new Exception("借据号："+String.valueOf(map.get("lnAcct"))+"的信托计划信息为空");
		}
		//新增核赔数据
		pspClaimLoan = PspClaimConstant.convertPspClaimLoan(map,serno,accLoan,lstIqpInfo,prjCopAcc,approveHis,prjCopTrustPlan,prjChnPrdInfo);
		pspClaimLoanMapper.insertSelective(pspClaimLoan);
		
		//新增理赔清单
		pspClaimList = PspClaimConstant.converPspClaimList(map,serno,approveHis,prjChnPrdInfo);
		pspClaimListMapper.insertSelective(pspClaimList);
		
		//新增核赔审批记录表
		pspClaimApprove = PspClaimConstant.convertPspClaimApprove(map,serno,pkid,pspClaimLoan);
		pspClaimApproveMapper.insertSelective(pspClaimApprove);
		
		return pspClaimLoan;
	}

	/**  
	 * <p>Title: getSplitAmt</p>  
	 * <p>Description: 核赔拆分得到本次理赔相关金额</p>  
	 * @param map
	 * @return  
	 */
	private Map<String, BigDecimal> getSplitAmt(Map<String, Object> map) {
		
		Map<String, BigDecimal> returnMap = new HashMap<String, BigDecimal>();
		//本次理赔相关金额=接口中的理赔金额-历史通过的核赔金额-进行中理赔的核赔金额
		//成功理赔相关金额+进行中理赔相关金额=总申请理赔相关金额-核赔失败相关金额
		//本次理赔相关金额=接口中的理赔金额-(总申请理赔相关金额-核赔失败相关金额)
		
		BigDecimal prinAmt = new BigDecimal("0");//本次理赔本金
		BigDecimal intAmt = new BigDecimal("0");//本次理赔利息
		BigDecimal lcAmt = new BigDecimal("0");//本次理赔罚息

		Map<String,BigDecimal> allClaimAmt = pspClaimListMapper.getAllClaimAmt(String.valueOf(map.get("lnAcct")));
		Map<String,BigDecimal> failClaimAmt = pspClaimListMapper.getFailClaimAmt(String.valueOf(map.get("lnAcct"))); 
		
		//获取免赔率
		AccLoan accLoan = accLoanMapper.selectByPrimaryKey(String.valueOf(map.get("lnAcct")));
		LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByPrimaryKey(accLoan.getIqpLoanSerno());
		PrjCopAcc prjCopAcc = prjCopAccMapper.selectByCopCusName(lstIqpInfo.getReceiveCusName());
		PrjChnPrdInfo prjChnPrdInfo = prjChnPrdInfoMapper.selectByPrjAndPrd(prjCopAcc.getCopNo(), lstIqpInfo.getPrdId());
		BigDecimal oweRate = new BigDecimal("1").subtract(prjChnPrdInfo.getPreventRate());
		
		//总申请理赔相关金额-核赔失败相关金额
		prinAmt = new BigDecimal(String.valueOf(map.get("prinAmt"))).subtract(allClaimAmt.get("PRINAMT").subtract(failClaimAmt.get("PRINAMT")));
		intAmt = new BigDecimal(String.valueOf(map.get("intAmt"))).subtract(allClaimAmt.get("INTAMT").subtract(failClaimAmt.get("INTAMT")));
		lcAmt = new BigDecimal(String.valueOf(map.get("lcAmt"))).subtract(allClaimAmt.get("LCAMT").subtract(failClaimAmt.get("LCAMT")));
		
		returnMap.put("prinAmt", prinAmt);
		returnMap.put("intAmt", intAmt);
		returnMap.put("lcAmt", lcAmt);
		returnMap.put("hisprinAmt", allClaimAmt.get("PRINAMT").subtract(failClaimAmt.get("PRINAMT")));
		returnMap.put("hisintAmt", allClaimAmt.get("INTAMT").subtract(failClaimAmt.get("INTAMT")));
		returnMap.put("hislcAmt", allClaimAmt.get("LCAMT").subtract(failClaimAmt.get("LCAMT")));
		
		return returnMap;
	}

	/**  
	 * <p>Title: pspClaimApproveHis</p>  
	 * <p>Description: 查询是否之前有过核赔记录</p>  
	 * @param paramMap
	 * @return  
	 */
	private boolean pspClaimApproveHis(Map<String, Object> paramMap) {
		boolean flag = false;
		String lnAcct = String.valueOf(paramMap.get("lnAcct"));
		int num = pspClaimLoanMapper.selectByBillNo(lnAcct);
		
		if (num>0) {
			flag =  true;
		}
		return flag;
	}
}
