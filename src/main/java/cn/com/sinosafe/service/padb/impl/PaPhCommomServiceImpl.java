package cn.com.sinosafe.service.padb.impl;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.sinosafe.common.config.constant.PadbConstant;
import cn.com.sinosafe.common.config.constant.SentStatusConstant;
import cn.com.sinosafe.common.exception.ParamException;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.RedisUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.BizLogMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.LstOperDetailsMapper;
import cn.com.sinosafe.dao.SentStatusMapper;
import cn.com.sinosafe.domain.bean.EmailTemplateEnum;
import cn.com.sinosafe.domain.bean.SmsTemplateEnum;
import cn.com.sinosafe.domain.entity.BizLogWithBLOBs;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.LstOperDetails;
import cn.com.sinosafe.domain.entity.SentStatus;
import cn.com.sinosafe.extend.padb.PaCommonUtil;
import cn.com.sinosafe.service.common.EmailPushService;
import cn.com.sinosafe.service.common.SmsPushService;
import cn.com.sinosafe.service.padb.PaPhCommonService;

/**
 * 平安独立承保通用service
 * @Project	: haxb_partner
 * @Author	: hesong
 * @Date	: 2019年6月4日 下午5:14:37
 * @Version	: 1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PaPhCommomServiceImpl implements PaPhCommonService {
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppDao;
	@Autowired
	private LstOperDetailsMapper lstOperDetailsDao;
	@Autowired
	private BizLogMapper bizLogDao;
	@Autowired
	private EmailPushService emailPushService;
	@Autowired
	private SmsPushService smsPushService;
	@Autowired
	private SentStatusMapper sentStatusDao;
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private RedisUtils redisUtils;

	@Override
	public void statusUpdateService(String serno, String status, String remark) {
		// 更新状态表 SENT_STATUS
		updateSentStatus(serno, status);
		// 更新申请表 IQP_ME_LOAN_APP
		updateIqpMeLoanAppStatus(serno, status);
		// 更新申请表 LST_IQP_INFO
		updateLstIqpInfoStatus(serno, status);
		// 插入轨迹表 BIZ_LOG
		insertLstOperDetailsStatus(serno, status, remark);
	}
	
	@Override
	public void insertBizLog(String serno, String interfaceNo, String requestReport, String responseReport) {
		BizLogWithBLOBs bizLog = new BizLogWithBLOBs();
		bizLog.setPkId(StringUtils.uuid());
		bizLog.setExtEnterpriseCode(PadbConstant.PAPH_ENTERPRISECODE);
		bizLog.setTransSerialNo(serno);
		bizLog.setProcessNo(interfaceNo);
		bizLog.setOutputReport(requestReport);
		bizLog.setInputReport(responseReport);
		bizLog.setCreatedBy(PadbConstant.PADB_SYSTEM);
		bizLog.setCreatedDate(DateUtils.getDateTime());
		bizLog.setUpdatedBy(PadbConstant.PADB_SYSTEM);
		bizLog.setUpdatedBy(DateUtils.getDateTime());
		bizLogDao.insertSelective(bizLog);
	}
	
	@Override
	public  void pushSms(int templateId, Map<String, String> paramMap, String mobiles) {
		String smsTemp = SmsTemplateEnum.getTemplate(templateId);
		if (StringUtils.isEmpty(smsTemp)) {
			throw new ParamException("没有该模板！");
		}
		if (paramMap.size() > 0) {
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				smsTemp=smsTemp.replace(key, paramMap.get(key));
			}
		}
		smsPushService.pushMessage(smsTemp, mobiles);
	}
	
	@Override
	public void pushMail(String emailTile, int templateId, String reciverAddress, Map<String, String> paramMap) {
		String emailTemp = EmailTemplateEnum.getTemplate(templateId);
		if (StringUtils.isEmpty(emailTemp)) {
			throw new ParamException("没有该模板！");
		}
		if (paramMap.size() > 0) {
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				emailTemp=emailTemp.replace(key, paramMap.get(key));
			}
		}
		emailPushService.pushMessage(emailTile, emailTemp, reciverAddress, "", "");
	}
	
	/**
	 * 更新申请状态表
	 * @author	: hirson
	 * @date	: 2019年6月9日 上午12:42:02
	 * @param serno
	 * @param status
	 * @return	:
	 */
	private boolean updateSentStatus(String serno, String status) {
		SentStatus sentStatus = new SentStatus();
		sentStatus.setSentSerno(serno);
		sentStatus.setSentType(SentStatusConstant.SENTTYPE);
		sentStatus.setSentStatus(status);
		sentStatus.setRunTime(new Date());
		int update = sentStatusDao.updateByPrimaryKeySelective(sentStatus);
		return update != 0 ? true : false;
	}
	
	/**
	 * 更新申请表状态
	 * @author	: hirson
	 * @date	: 2019年6月4日 下午8:58:22
	 * @param serno		申请流水号
	 * @param status	状态码
	 * @return	:
	 */
	private boolean updateIqpMeLoanAppStatus(String serno, String status) {
		IqpMeLoanApp iqpMeLoanApp = new IqpMeLoanApp();
		iqpMeLoanApp.setSerno(serno);
		// 自定义的业务状态
		if (StringUtils.isNotEmpty(status)) {
			iqpMeLoanApp.setNewApproveStatus(status);
		}
		// 对应信保系统的审批状态
		String approveStatus = PaCommonUtil.getApproveStatus(status);
		if (StringUtils.isNotEmpty(approveStatus)) {
			iqpMeLoanApp.setApproveStatus(approveStatus);
		}
		int update = iqpMeLoanAppDao.updateByPrimaryKeySelective(iqpMeLoanApp);
		return update != 0 ? true : false;
	}
	/**
	 * 更新投保单表状态
	 * @author	: longxiaoqiang
	 * @date	: 2019年6月4日 下午8:58:22
	 * @param serno		申请流水号
	 * @param status	状态码
	 * @return	:
	 */
	private boolean updateLstIqpInfoStatus(String serno, String status) {
		IqpMeLoanApp iqpMeLoanApp = new IqpMeLoanApp();
		iqpMeLoanApp.setSerno(serno);
		// 自定义的业务状态
		if (StringUtils.isNotEmpty(status)) {
			iqpMeLoanApp.setNewApproveStatus(status);
		}
		// 对应信保系统的审批状态
		String approveStatus = PaCommonUtil.getApproveStatus(status);
		if (StringUtils.isNotEmpty(approveStatus)) {
			iqpMeLoanApp.setApproveStatus(approveStatus);
		}
		int update = iqpMeLoanAppDao.updateByPrimaryKeySelective(iqpMeLoanApp);
		
		LstIqpInfo lstIqpInfo = new LstIqpInfo();
		lstIqpInfo.setIqpLoanSerno(serno);
		// 对应信保系统的审批状态
		/*String lstStatus = PaCommonUtil.getLstStatus(status);
		if (StringUtils.isNotEmpty(lstStatus)) {
			lstIqpInfo.setApplyStatus(lstStatus);
			lstIqpInfo.setStatus(lstStatus);
			//lstIqpInfo.setCoverCreateStatus("00");
			lstIqpInfoMapper.updateByIqpSerno(lstIqpInfo);
		}*/
		return update != 0 ? true : false;
	}
	
	/**
	 * 插入轨迹表
	 * @author	: hirson
	 * @date	: 2019年6月5日 下午7:41:40
	 * @param serno		业务流水号
	 * @param status	状态
	 * @param remark	备注
	 * @return	:
	 */
	private boolean insertLstOperDetailsStatus(String serno, String status, String remark) {
		LstOperDetails operDetails = new LstOperDetails();
		operDetails.setIqpSerno(serno);
		operDetails.setPkId(StringUtils.getRandomNumeric(30));
		operDetails.setOperTime(DateUtils.getDateTime());
		
		// 获取当前状态描述
		String statusEname = PaCommonUtil.getStatusEname(status);
		if (StringUtils.isNotEmpty(statusEname)) {
			operDetails.setNodename(statusEname);
		}
		
		// 获取当前状态第二描述（下一状态描述）
		String newStatusEname = PaCommonUtil.getNewStatusEname(status);
		if (StringUtils.isNotEmpty(newStatusEname)) {
			operDetails.setNodenameTwo(newStatusEname);
		}
		if (StringUtils.isNotEmpty(remark)) {
			operDetails.setRemark(remark);
		}
		
		int update = lstOperDetailsDao.insertSelective(operDetails);
		return update != 0 ? true : false;
	}
	
	
	/**
	 * 获取电子保单影像系统原始地址
	 * @author	: hirson
	 * @date	: 2019年7月25日 下午7:18:11
	 * @param applNo
	 * @return	:
	 */
	public String getPolicyUrl(String applNo) {
		String policyUrl = null;
		Object urlCache = redisUtils.getValue(applNo);
		// 缓存有取缓存的
		if (urlCache != null) {
			policyUrl = (String) urlCache;
		}
		
		// 缓存没有取库里面的，再加入缓存
		if (urlCache == null) {
			Map<String,Object> eleStatus = lstIqpInfoMapper.selectEleStatus(applNo);
			if ("2".equals((String)eleStatus.get("SEAL_STATUS"))) {
				policyUrl = (String)eleStatus.get("SIGNED_PDF_URL");
				redisUtils.setValue(applNo, policyUrl, 60 * 60 * 24 * 7);
			}
		}
		
		return policyUrl;
	}
	
}
