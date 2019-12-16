/**
 * 
 */
package cn.com.sinosafe.service.padb.impl;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.properties.ClaimProperties;
import cn.com.sinosafe.common.util.CommonUtils;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.dao.HaPaymentRecordMapper;
import cn.com.sinosafe.dao.PaIndPublicRepaymentDetailMapper;
import cn.com.sinosafe.dao.PspClaimPaphRecodeMapper;
import cn.com.sinosafe.dao.SentStatusMapper;
import cn.com.sinosafe.dao.TReconPaRepaymentDetailMapper;
import cn.com.sinosafe.domain.bean.ClaimStatusEnum;
import cn.com.sinosafe.domain.bean.EmailTemplateEnum;
import cn.com.sinosafe.domain.bean.SentStatusCode;
import cn.com.sinosafe.domain.entity.HaPaymentRecord;
import cn.com.sinosafe.domain.entity.PaIndPublicRepaymentDetail;
import cn.com.sinosafe.domain.entity.PspClaimPaphRecode;
import cn.com.sinosafe.domain.entity.SentStatus;
import cn.com.sinosafe.domain.entity.TReconPaRepaymentDetail;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import cn.com.sinosafe.service.padb.PaCheckPubStatusService;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import net.sf.json.JSONObject;

/**  
* <p>Title: PaCheckPubStatusServiceImpl</p>  
* <p>Description: </p>  
* @author longxiaoqiang  
* @date 2019年9月27日  
*/
@Service
public class PaCheckPubStatusServiceImpl implements PaCheckPubStatusService {
	@Autowired
	PspClaimPaphRecodeMapper pspClaimPaphRecodeMapper;
	@Autowired
	HaPaymentRecordMapper haPaymentRecordMapper;
	@Autowired
	PaIndPublicRepaymentDetailMapper paIndPublicRepaymentDetailMapper;
	@Autowired
	PaPhCommonService paPhCommonService;
	Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
    private CommonUtils commonUtils;
	@Autowired
	private ClaimProperties claimProperties;
	@Autowired
	private SentStatusMapper sentStatusMapper;
	@Autowired
	private TReconPaRepaymentDetailMapper tReconPaRepaymentDetailMapper;
	@Override
	public String checkPubStatus() {
		log.info("-----------------核实对公还款start-------------------");
		try {
			//1、获取核实对公还款待通知的记录
			List<PaIndPublicRepaymentDetail> paIndPublicRepaymentDetails = paIndPublicRepaymentDetailMapper.selectNeedNotice();
			log.info("------PaIndClaimNoticeServiceImpl获取核实对公还款待通知的记录完成------");
			
			//2、获取核实对公还款待通知的批次号
			List<String> batchNos= paIndPublicRepaymentDetailMapper.selectBatchNo();
			log.info("获取理赔结果待通知的批次号={}",JSONUtils.getSingleInstance().toJSon(batchNos));
			log.info("------PaIndClaimNoticeServiceImpl获取核实对公还款待通知的批次号完成-------");
			
			//3、数据组装：每个批次记录放在一个list中
			Map<String, List<PaIndPublicRepaymentDetail>> noticeMap = getNeedNoticeMap(batchNos,paIndPublicRepaymentDetails);
			log.info("数据组装（每个批次记录放在一个list中）={}",JSONUtils.getSingleInstance().toJSon(noticeMap));
			log.info("------PaIndClaimNoticeServiceImpl数据组装完成：每个批次记录放在一个list中-------");
			
			//4、筛选需要推送的批次记录
			List<Map<String, Object>> sendData = getNeedSendData(noticeMap);
			log.info("------PaIndClaimNoticeServiceImpl数据筛选完成-------");
			
			//5、发送数据
			if (sendData!=null&&sendData.size()>0) {
				
				String sendParam = JSONUtils.getSingleInstance().toJSon(sendData);
				log.info("PaIndClaimNoticeServiceImpl筛选之后发送给平安的核实对公还款结果为={}",sendParam);
				
				for (Map<String, Object> map : sendData) {
					log.info("PaIndClaimNoticeServiceImpl本次发送给平安的核实对公还款数据为={}",map);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("param", PaEncryptUtil.encryptByRSA(JSONUtils.getSingleInstance().toJSon(map)));
					
					log.info("加密后发送给平安的数据为：{}",jsonObject.toString());
					String resultData = HttpClientUtil.sendPosts(SystemConfig.cacheMap.get("FCFPBX6002"), jsonObject.toString());
					log.info("PaIndClaimNoticeServiceImpl平安返回的结果为={}",resultData);
					
					//6、更新发送状态
					updateSendStatus(resultData,map,"check");
				}
				
			} else {
				log.info("没有可通知的记录！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("PaIndClaimNoticeServiceImpl发送给平安核实对公还款失败");
		}
		log.info("-----------------核实对公还款end-------------------");
		
		return "";
	}

	/**  
	 * <p>Title: getNoticeMap</p>  
	 * <p>Description: </p>  
	 * @param batchNos
	 * @param pspClaimPaphRecodes
	 * @return  
	 */
	private Map<String, List<PspClaimPaphRecode>> getNoticeMap(List<String> batchNos,
			List<PspClaimPaphRecode> pspClaimPaphRecodes) {
		//以批次分类放入map中
		Map<String, List<PspClaimPaphRecode>> noticeMap= new HashMap<String, List<PspClaimPaphRecode>>();
		for (String batchNo:batchNos) {
			List<PspClaimPaphRecode> list = new ArrayList<PspClaimPaphRecode>();
			for (PspClaimPaphRecode pspClaimPaphRecode:pspClaimPaphRecodes) {
				if (batchNo.equals(pspClaimPaphRecode.getClaimBatchNo())) {
					list.add(pspClaimPaphRecode);
				}
			}
			noticeMap.put(batchNo, list);
		}
		return noticeMap;
	}
	/**  
	 * <p>Title: getSendData</p>  
	 * <p>Description: 筛选需要发送的数据</p>  
	 * @param noticeMap
	 * @return  
	 */
	private List<Map<String, Object>> getSendData(Map<String, List<PspClaimPaphRecode>> noticeMap) {
		
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
		Set<String> keySet = noticeMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			Map<String, Object> map = new HashMap<String,Object>();
			String next = iterator.next();
			List<PspClaimPaphRecode> paList = noticeMap.get(next);
			boolean flag = false;
			String claimCount = "";
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (PspClaimPaphRecode pspClaimPaphRecode:paList) {
				Map<String, Object> claimMap = new HashMap<String, Object>();
				HaPaymentRecord haPaymentRecord = haPaymentRecordMapper.selectPaySucRecode(pspClaimPaphRecode.getLnAcct(),String.valueOf(pspClaimPaphRecode.getClaimAmt()));
				if (!StringUtils.isNull(haPaymentRecord) && !StringUtils.isEmpty(haPaymentRecord.getPaymentStatus())) {
					claimCount = String.valueOf(pspClaimPaphRecode.getClaimCount());
					claimMap.put("lnAcct", pspClaimPaphRecode.getLnAcct());
					claimMap.put("applNo", pspClaimPaphRecode.getApplNo());
					claimMap.put("indemnityNo", haPaymentRecord.getBusinessId());
					claimMap.put("clmAmtResult", ClaimStatusEnum.getMsg(ClaimStatusEnum.getMsg(haPaymentRecord.getPaymentStatus())));
					claimMap.put("failReason", ClaimStatusEnum.getMsg(haPaymentRecord.getPaymentStatus()));
					claimMap.put("claimAmt", haPaymentRecord.getPaymentAmount());
					claimMap.put("claimDate", haPaymentRecord.getTransactionTime());
					
				} else {
					flag = true;
					break;
				}
				list.add(claimMap);
			}
			if (!flag) {
				map.put("claimBatchNo", next);
				map.put("claimCount", new BigDecimal(claimCount));
				map.put("claimsApplyList", list);
				map.put("insuCompany", "HABX");
			}
			if (map.size()>0) {
				listData.add(map);
			}
		}
		
		return listData;
	}
	/**  
	 * <p>Title: updateSendStatus</p>  
	 * <p>Description: 更新发送状态</p>  
	 * @param resultData
	 * @param sendParam  
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@SuppressWarnings("unchecked")
	private void updateSendStatus(String resultData, Map<String, Object> sendData, String flag) throws JsonParseException, JsonMappingException, IOException {
		
		Map<String, Object> resultMap = JSONUtils.getSingleInstance().readMapValue(resultData);
		if ("0000".equals(String.valueOf(resultMap.get("resultCode")))) {
			String batchNo = (String)sendData.get("batchNo");
			if ("check".equals(flag)) {
				PaIndPublicRepaymentDetail paIndPublicRepaymentDetail = new PaIndPublicRepaymentDetail();
				paIndPublicRepaymentDetail.setBatchNo(batchNo);
				paIndPublicRepaymentDetail.setNoticeResult("01");
				paIndPublicRepaymentDetailMapper.updateByBatchNo(paIndPublicRepaymentDetail);
				
				//更新财务系统已通知状态
				TReconPaRepaymentDetail tReconPaRepaymentDetail = new TReconPaRepaymentDetail();
				tReconPaRepaymentDetail.setNoticeResult("01");
				tReconPaRepaymentDetail.setNoticeTime(DateUtils.getDate());
				tReconPaRepaymentDetail.setBatchNo(batchNo);
				tReconPaRepaymentDetailMapper.updateByBatchNo(tReconPaRepaymentDetail);
			} else {
				PspClaimPaphRecode pspClaimPaphRecode = new PspClaimPaphRecode();
				pspClaimPaphRecode.setClaimBatchNo(batchNo);
				pspClaimPaphRecode.setNoticeResult("01");
				pspClaimPaphRecodeMapper.updateByBatchNo(pspClaimPaphRecode);
				
				List<PaIndPublicRepaymentDetail> list = (List<PaIndPublicRepaymentDetail>)sendData.get("batchNo");
				for (PaIndPublicRepaymentDetail paIndPublicRepaymentDetail : list) {
					paPhCommonService.statusUpdateService(paIndPublicRepaymentDetail.getApplNo(), SentStatusCode.PA_20.code(), "理赔交易完成通知");
				}
			}
				
		}
	}
	/**  
	 * <p>Title: updateSendStatus</p>  
	 * <p>Description: 更新发送状态</p>  
	 * @param resultData
	 * @param sendParam  
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@SuppressWarnings("unchecked")
	private void updateSendStatusTow(String resultData, Map<String, Object> sendData, String flag) throws JsonParseException, JsonMappingException, IOException {
		
		Map<String, Object> resultMap = JSONUtils.getSingleInstance().readMapValue(resultData);
		if ("0000".equals(String.valueOf(resultMap.get("retCode")))) {
			String batchNo = (String)sendData.get("claimBatchNo");
			if ("check".equals(flag)) {
				PaIndPublicRepaymentDetail paIndPublicRepaymentDetail = new PaIndPublicRepaymentDetail();
				paIndPublicRepaymentDetail.setBatchNo(batchNo);
				paIndPublicRepaymentDetail.setNoticeResult("01");
				paIndPublicRepaymentDetailMapper.updateByBatchNo(paIndPublicRepaymentDetail);
				
				//更新财务系统已通知状态
				TReconPaRepaymentDetail tReconPaRepaymentDetail = new TReconPaRepaymentDetail();
				tReconPaRepaymentDetail.setNoticeResult("01");
				tReconPaRepaymentDetail.setNoticeTime(DateUtils.getDate());
				tReconPaRepaymentDetail.setBatchNo(batchNo);
				tReconPaRepaymentDetailMapper.updateByBatchNo(tReconPaRepaymentDetail);
			} else {
				PspClaimPaphRecode pspClaimPaphRecode = new PspClaimPaphRecode();
				pspClaimPaphRecode.setClaimBatchNo(batchNo);
				pspClaimPaphRecode.setNoticeResult("01");
				pspClaimPaphRecodeMapper.updateByBatchNo(pspClaimPaphRecode);
				
				List<PaIndPublicRepaymentDetail> list = (List<PaIndPublicRepaymentDetail>)sendData.get("claimBatchNo");
				for (PaIndPublicRepaymentDetail paIndPublicRepaymentDetail : list) {
					paPhCommonService.statusUpdateService(paIndPublicRepaymentDetail.getApplNo(), SentStatusCode.PA_20.code(), "理赔交易完成通知");
				}
			}
			
		}
	}

	
	@Override
	public String claimResultNotice() {
		try {
			//1、获取理赔结果待通知的记录
			List<PspClaimPaphRecode> pspClaimPaphRecodes = pspClaimPaphRecodeMapper.selectNoticeRecode();
			log.info("------PaIndClaimNoticeServiceImpl获取理赔结果待通知的记录完成------");
			if (StringUtils.isEmpty(pspClaimPaphRecodes)) {
				log.info("无理赔结果待通知的记录");
				return "";
			}
			
			//2、获取理赔结果待通知的批次号
			List<String> batchNos= pspClaimPaphRecodeMapper.selectNoticeBatchNo();
			log.info("获取理赔结果待通知的批次号={}",JSONUtils.getSingleInstance().toJSon(batchNos));
			log.info("------PaIndClaimNoticeServiceImpl获取理赔结果待通知的批次号完成-------");
			
			//3、数据组装：每个批次记录放在一个list中
			Map<String, List<PspClaimPaphRecode>> noticeMap = getNoticeMap(batchNos,pspClaimPaphRecodes);
			log.info("数据组装（每个批次记录放在一个list中）={}",JSONUtils.getSingleInstance().toJSon(noticeMap));
			log.info("------PaIndClaimNoticeServiceImpl数据组装完成：每个批次记录放在一个list中-------");
			
			//4、筛选需要推送的批次记录
			List<Map<String, Object>> sendData = getSendData(noticeMap);
			log.info("------PaIndClaimNoticeServiceImpl数据筛选完成-------");
			
			if (sendData!=null&&sendData.size()>0) {
				
				String sendParam = JSONUtils.getSingleInstance().toJSon(sendData);
				log.info("PaIndClaimNoticeServiceImpl筛选之后发送给平安的理赔结果为={}",sendParam);
				
				for (Map<String, Object> map : sendData) {
					log.info("PaIndClaimNoticeServiceImpl本次发送给平安的理赔结果数据为={}",JSONUtils.getSingleInstance().toJSon(map));
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("param", PaEncryptUtil.encryptByRSA(JSONUtils.getSingleInstance().toJSon(map)));
					log.info("加密后发送给平安的数据为：{}",jsonObject.toString());
					//5、发送数据
					String resultData = HttpClientUtil.sendPosts(SystemConfig.cacheMap.get("FCFPBX4004"), jsonObject.toString());
					log.info("PaIndClaimNoticeServiceImpl平安返回的结果为={}",resultData);
					
					//6、更新发送状态
					updateSendStatusTow(resultData,map,"claim");
				}
			} else {
				log.info("没有可通知的记录！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("PaIndClaimNoticeServiceImpl发送给平安理赔结果失败");
		}
		
		return null;
	}
	/**  
	 * <p>Title: getSendData</p>  
	 * <p>Description: 筛选需要发送的数据</p>  
	 * @param noticeMap
	 * @return  
	 */
	private List<Map<String, Object>> getNeedSendData(Map<String, List<PaIndPublicRepaymentDetail>> noticeMap) {
		
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		
		Set<String> keySet = noticeMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			Map<String, Object> map = new HashMap<String,Object>();
			String next = iterator.next();
			List<PaIndPublicRepaymentDetail> paList = noticeMap.get(next);
			boolean flag = false;
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (PaIndPublicRepaymentDetail paIndPublicRepaymentDetail:paList) {
				Map<String, Object> claimMap = new HashMap<String, Object>();
				String checkStatus = paIndPublicRepaymentDetail.getReBurStatus();
				if (!StringUtils.isEmpty(checkStatus) && !"1".equals(checkStatus)) {
					claimMap.put("serNo", paIndPublicRepaymentDetail.getSreNo());
					claimMap.put("policyNo", paIndPublicRepaymentDetail.getPolicyNo());
					claimMap.put("applNo", paIndPublicRepaymentDetail.getApplNo());
					claimMap.put("custName", paIndPublicRepaymentDetail.getCustName());
					claimMap.put("reBurAmt", paIndPublicRepaymentDetail.getReBurAmt());
					claimMap.put("reBurDate", paIndPublicRepaymentDetail.getReBurDate());
					claimMap.put("reBurStatus", paIndPublicRepaymentDetail.getReBurStatus());
					
				} else {
					flag = true;
					break;
				}
				list.add(claimMap);
			}
			if (!flag) {
				map.put("batchNo", next);
				map.put("claimsApplyList", list);
				map.put("insuCompany", "HABX");
			}
			if (map.size()>0) {
				listMap.add(map);
			}
		}
		
		return listMap;
	}
	/**  
	 * <p>Title: getNoticeMap</p>  
	 * <p>Description: </p>  
	 * @param batchNos
	 * @param pspClaimPaphRecodes
	 * @return  
	 */
	private Map<String, List<PaIndPublicRepaymentDetail>> getNeedNoticeMap(List<String> batchNos,
			List<PaIndPublicRepaymentDetail> paIndPublicRepaymentDetails) {
		//以批次分类放入map中
		Map<String, List<PaIndPublicRepaymentDetail>> noticeMap= new HashMap<String, List<PaIndPublicRepaymentDetail>>();
		for (String batchNo:batchNos) {
			List<PaIndPublicRepaymentDetail> list = new ArrayList<PaIndPublicRepaymentDetail>();
			for (PaIndPublicRepaymentDetail paIndPublicRepaymentDetail:paIndPublicRepaymentDetails) {
				if (batchNo.equals(paIndPublicRepaymentDetail.getBatchNo())) {
					list.add(paIndPublicRepaymentDetail);
				}
			}
			noticeMap.put(batchNo, list);
		}
		return noticeMap;
	}
	
	@Override
	public String claimFailNotice() {
		log.info("-----------------理赔支付失败邮件预警start-------------------");
		try {
			String sendType = "PAPH_CLAIM_FAIL";
			
			//1、获取独保理赔支付失败数据
			List<Map<String,String>> list = haPaymentRecordMapper.getPaphClaimFail();
			
			//2、邮件通知
			String msg = "";
			String emailmsg = EmailTemplateEnum.getTemplate(3);
			for (Map<String, String> map:list) {
				emailmsg = emailmsg.replace("{申请号}", String.valueOf(map.get("IQP_LOAN_SERNO"))).replace("{华安业务流水号}", String.valueOf(map.get("IQP_LOAN_SERNO"))).replace("{content}", StringUtils.isNull(map.get("PAYMENT_FAIL_REASON"))?"":map.get("PAYMENT_FAIL_REASON"));
				msg += emailmsg;
				//3、记录已通知的数据
				insertSendRecord(String.valueOf(map.get("IQP_LOAN_SERNO")),sendType);
			}
			commonUtils.commomMail("平安独立承保理赔支付失败邮件预警", msg, claimProperties.getReciverAddress(), claimProperties.getCcAddress());
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("PaIndClaimNoticeServiceImpl理赔支付失败邮件预警失败");
		}
		log.info("-----------------理赔支付失败邮件预警end-------------------");
		return "";
	}

	/**  
	 * <p>Title: insertSendRecord</p>  
	 * <p>Description: </p>  
	 * @param valueOf  
	 */
	private void insertSendRecord(String valueOf,String sendType) {
		SentStatus sentStatus = new SentStatus();
		
		sentStatus.setSentSerno(valueOf);
		sentStatus.setSentType(sendType);
		sentStatus.setSentStatus("01");
		sentStatusMapper.insertSelective(sentStatus);
	}
	
}
