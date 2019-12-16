/**   
* @Title:：PaLstIqpApplyServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月5日 下午2:32:13 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSON;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.config.constant.SentStatusConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.AccImportRecordsMapper;
import cn.com.sinosafe.dao.CusBaseMapper;
import cn.com.sinosafe.dao.CusIndivMapper;
import cn.com.sinosafe.dao.IqpMeApiCopMapper;
import cn.com.sinosafe.dao.IqpMeAuditOpinionMapper;
import cn.com.sinosafe.dao.IqpMeCusAppMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.IqpMePrjCopDao;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.PrjCopAccMapper;
import cn.com.sinosafe.dao.SentStatusMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.bean.SentStatusCode;
import cn.com.sinosafe.domain.entity.AccImportRecords;
import cn.com.sinosafe.domain.entity.CusBase;
import cn.com.sinosafe.domain.entity.CusIndiv;
import cn.com.sinosafe.domain.entity.IqpMeApiCop;
import cn.com.sinosafe.domain.entity.IqpMeAuditOpinion;
import cn.com.sinosafe.domain.entity.IqpMeCusApp;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.IqpMePrjCop;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PrjCopAcc;
import cn.com.sinosafe.domain.entity.SentStatus;
import cn.com.sinosafe.service.padb.PaLstIqpApplyService;
import cn.com.sinosafe.service.padb.PaPhCommonService;

/** 
 * @ClassName:：PaLstIqpApplyServiceImpl 
 * @Description： 投保申请接口
 * @author ：xiewei
 * @date ：2019年6月5日 下午2:32:13  
 */
@Service
public class PaLstIqpApplyServiceImpl implements PaLstIqpApplyService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;
	
	@Autowired
	private IqpMeCusAppMapper iqpMeCusAppMapper;
	
	@Autowired
	private IqpMeApiCopMapper iqpMeApiCopMapper;
	
	@Autowired
	private PrjCopAccMapper prjCopAccMapper;
	
	@Autowired
	private IqpMePrjCopDao iqpMePrjCopDao;
	
	@Autowired
	private AccImportRecordsMapper accImportRecordsDao;
	
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	
	@Autowired
	private CusBaseMapper cusBaseMapper;
	
	@Autowired
	private CusIndivMapper cusIndivMapper;
	
	@Autowired
	private SentStatusMapper sentStatusMapper;
	
	@Autowired
	private AsyncDealService asyncDealService;
	
	@Autowired
	private PaPhCommonService paPhCommonService;
	
	@Autowired
	private IqpMeAuditOpinionMapper iqpMeAuditOpinionMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String lstIqpApplyNoSign(Map<String, Object> paramMap) throws Exception{
		logger.info("*****************************投保申请接口通知 start*****************************");
		logger.info("param:{}",paramMap);
		String resultCode = "";
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			//校验字段
			//,"applAmt","applNosInst","bankNo","bnMobile","sucH5Url","facH5Url"
			if(LstIqpApplyConstant.checkFieldDefect(paramMap,new String[]{"applNo","id","custName","applDate","mobile","insuCompany","source","cidNo","applAmt","applNosInst","bankNo","bnMobile","sucH5Url","facH5Url"})){
				resultCode=PaResultCode.PA_FIELD_DELETION.code();
				resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE);
			}else{
				logger.info("paramMap info:"+paramMap.toString());
				//查询是否已注销，支持已注销的重复申请
				int num = iqpMeLoanAppMapper.getCancelBySerno(String.valueOf(paramMap.get("applNo")));
				if(num>0){
					int n = iqpMeLoanAppMapper.getIqpSucBySerno(String.valueOf(paramMap.get("applNo")));
					if (n<1) {
						//更新申请历史数据
						logger.info("该笔申请已注销，进入重新申请："+String.valueOf(paramMap.get("applNo")));
						updateIqpInfoHis(paramMap);
						resultCode=PaResultCode.PA_SUCCESS.code();
						resultMap.put("resultMsg", PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
						resultMap.put("h5Url", SystemConfig.cacheMap.get("PADB_ISSUED_H5URL")+SystemConfig.cacheMap.get("h5Url")+"?applNo="+String.valueOf(paramMap.get("applNo")));
					} else {
						int m = iqpMeLoanAppMapper.getIqpSucSignBySerno(String.valueOf(paramMap.get("applNo")));
						if (m>0) {
							logger.info("重复投保！");
							resultCode=PaResultCode.PA_FAIL.code();
							resultMap.put("resultMsg", LstIqpApplyConstant.DATA_REPEAT_MSG);
						} else {
							resultCode=PaResultCode.PA_SUCCESS.code();
							resultMap.put("resultMsg", PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
							resultMap.put("h5Url", SystemConfig.cacheMap.get("PADB_ISSUED_H5URL")+SystemConfig.cacheMap.get("h5Url")+"?applNo="+String.valueOf(paramMap.get("applNo")));
						}
					}
				}else{
					//校验申请号存并已完成投保
					int count=iqpMeLoanAppMapper.getCountBySerno(String.valueOf(paramMap.get("applNo")));
					if(count>0){
						resultCode=PaResultCode.PA_FAIL.code();
						resultMap.put("resultMsg", LstIqpApplyConstant.DATA_REPEAT_MSG);
					}else{
						//增加校验申请号存在但没有完成投保
						count = iqpMeLoanAppMapper.getCountById(String.valueOf(paramMap.get("applNo")));
						if (count>0) {
							resultCode=PaResultCode.PA_SUCCESS.code();
							resultMap.put("resultMsg", PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
							resultMap.put("h5Url", SystemConfig.cacheMap.get("PADB_ISSUED_H5URL")+SystemConfig.cacheMap.get("h5Url")+"?applNo="+String.valueOf(paramMap.get("applNo")));
						} else {
							String param = SystemConfig.cacheMap.get("Check_Card_4Param");
							if("0".equals(param)) {
								//华安四要素校验，仅做记录 调错接口需要集成dubbo接口
								asyncDealService.checkCard4Param(String.valueOf(paramMap.get("applNo")), String.valueOf(paramMap.get("custName")), String.valueOf(paramMap.get("id")), String.valueOf(paramMap.get("bankNo")), String.valueOf(paramMap.get("bnMobile")));
							}else if("1".equals(param)) {
								//平安付四要素
								asyncDealService.paCheckCard4Param(String.valueOf(paramMap.get("applNo")), String.valueOf(paramMap.get("custName")), String.valueOf(paramMap.get("id")), String.valueOf(paramMap.get("bankNo")), String.valueOf(paramMap.get("bnMobile")), String.valueOf(paramMap.get("cidNo")));
							}
								//校验通过，写入申请表及客户表信息
							try {
								//合作方申请信息表
								IqpMeApiCop iqpMeApiCop=iqpMeApiCopMapper.selectByAccid(String.valueOf(paramMap.get("source")));
								//合作方信息
								PrjCopAcc prjCopAcc = prjCopAccMapper.selectByPrimaryKey(iqpMeApiCop.getCopNo());
								//产品信息
								Map<String, Object> prdInfo = lstIqpInfoMapper.queryCAppnt(iqpMeApiCop.getPrdId());
								//客戶信息 
								//生成客户编号
								String cusId = cusBaseMapper.createCusId();
								CusBase cusBase=LstIqpApplyConstant.mapConvertCusBase(paramMap,iqpMeApiCop,cusId);
								//校验客户是否已开户
								CusBase cusInfo = checkCusInfo(cusBase);
								CusIndiv cusIndiv = null;
								if(null==cusInfo||"".equals(cusInfo.getCusId())) {
									cusBaseMapper.insertSelective(cusBase);
									//客户信息对私
									cusIndiv=LstIqpApplyConstant.mapConvertCusIndiv(paramMap,cusBase,iqpMeApiCop);
									cusIndivMapper.insertSelective(cusIndiv);
								}else {
									cusBaseMapper.updateByPrimaryKey(cusInfo);
									cusIndiv=LstIqpApplyConstant.mapConvertCusIndiv(paramMap,cusInfo,iqpMeApiCop);
									cusIndivMapper.updateByPrimaryKey(cusIndiv);
									cusBase=cusInfo;
								}
								//记录申请信息
								AccImportRecords importData=LstIqpApplyConstant.mapConvertAccImportRecords(paramMap,iqpMeApiCop);
								accImportRecordsDao.insert(importData);
								//申請記錄表
								IqpMeLoanApp imLoan=LstIqpApplyConstant.mapConvertIqpMeLoan(paramMap,cusBase,iqpMeApiCop,prjCopAcc);
								iqpMeLoanAppMapper.insertSelective(imLoan);
								//小額貸申請記錄表 
								IqpMeCusApp imCus=LstIqpApplyConstant.mapConvertIqpMeCus(paramMap,cusBase);
								iqpMeCusAppMapper.insertSelective(imCus);
								//推荐机构业务申请表
								IqpMePrjCop iqpPrj=LstIqpApplyConstant.mapConvertIqpPrj(paramMap,prjCopAcc);
								iqpMePrjCopDao.insertSelective(iqpPrj);
								//增加审批决议表
								IqpMeAuditOpinion lqpMeAuditOpinion=LstIqpApplyConstant.mapConvertIqpMeAuditOpinion(imLoan,cusBase);
								iqpMeAuditOpinionMapper.insertSelective(lqpMeAuditOpinion);
								//保单数据未签署状态
								LstIqpInfo lstIqpInfo=LstIqpApplyConstant.mapConvertLstIqpInfo(paramMap,imLoan,prjCopAcc,iqpMeApiCop,cusIndiv,lqpMeAuditOpinion,prdInfo);
								lstIqpInfoMapper.insertSelective(lstIqpInfo);
								
								//添加接口状态流程
								sentStatusMapper.insertSelective(new SentStatus(SentStatusConstant.SENTTYPE,imLoan.getSerno(), SentStatusCode.PA_01.code()));
								paPhCommonService.statusUpdateService(imLoan.getSerno(), SentStatusCode.PA_01.code(), "投保申请");
	
							} catch (Exception e) {
								throw new BusinessException(e.getMessage());
							}
						}
						resultCode=PaResultCode.PA_SUCCESS.code();
						resultMap.put("resultMsg", PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
						//投保页面
						resultMap.put("h5Url", SystemConfig.cacheMap.get("PADB_ISSUED_H5URL")+SystemConfig.cacheMap.get("h5Url")+"?applNo="+String.valueOf(paramMap.get("applNo")));
					}
				}
			}
		} catch (Exception e) {
			logger.error("errorInfo:"+e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		resultMap.put("resultCode",String.valueOf(resultCode));
		logger.info("*****************************投保申请接口通知 end*****************************");
		return JSON.toJSONString(resultMap);
	}
	
	
	/**
	 * 
	 * @Title：checkCusInfo 
	 * @Description：校验客户信息
	 * @param ：@param paramMap
	 * @param ：@return 
	 * @return ：CusBase 
	 * @throws
	 */
	public CusBase checkCusInfo(CusBase cusBase){
		String cusName = cusBase.getCusName();
		String certCode = cusBase.getCertCode();
		
		CusBase cusInfo = cusBaseMapper.selectCusInfoByNameId(cusName, certCode);
		
		return cusInfo;
	}

	public void updateIqpInfoHis (Map<String, Object> paramMap) {
		
		//更新客户申请表
		IqpMeLoanApp iqpMeLoanApp = iqpMeLoanAppMapper.selectByPrimaryKey(String.valueOf(paramMap.get("applNo")));
		iqpMeLoanApp.setIsCancel("2");
		iqpMeLoanApp.setAppStatus("");
		iqpMeLoanApp.setApproveStatus("");
		iqpMeLoanApp.setNewApproveStatus("01");
		
		iqpMeLoanApp.setApplyDate(String.valueOf(paramMap.get("applDate")));
		iqpMeLoanApp.setPhone(String.valueOf(paramMap.get("bnMobile")));
		iqpMeLoanApp.setAmount(new BigDecimal(StringUtils.isEmpty(String.valueOf(paramMap.get("applAmt")))?"0":String.valueOf(paramMap.get("applAmt"))));
		iqpMeLoanApp.setTerm(new BigDecimal(StringUtils.isEmpty(String.valueOf(paramMap.get("applNosInst")))?"0":String.valueOf(paramMap.get("applNosInst"))));
		iqpMeLoanApp.setBankCardNo(String.valueOf(paramMap.get("bankNo")));
		iqpMeLoanApp.setBusiArea(String.valueOf(paramMap.get("cityName")));
		
		// 账户 
		iqpMeLoanApp.setBankCardNo(String.valueOf(paramMap.get("bankNo")));
		iqpMeLoanApp.setPayeeAccount(String.valueOf(paramMap.get("bankNo")));
		iqpMeLoanApp.setRepayAccount(String.valueOf(paramMap.get("bankNo")));
		
		iqpMeLoanApp.setInputDate(DateUtils.getDateTime());
		iqpMeLoanApp.setAlipayRoleId(String.valueOf(paramMap.get("cidNo")));
		iqpMeLoanAppMapper.updateByPrimaryKeySelective(iqpMeLoanApp);
		logger.info("更新完申请号为：{}的IqpMeLoanApp", String.valueOf(paramMap.get("applNo")));
		
		//更新申请信息表
		IqpMeCusApp iqpMeCusApp = iqpMeCusAppMapper.selectByPrimaryKey(String.valueOf(paramMap.get("applNo")));
		iqpMeCusApp.setMobile(String.valueOf(paramMap.get("bnMobile")));
		iqpMeCusApp.setReturnurl(String.valueOf(paramMap.get("sucH5Url")));
		iqpMeCusApp.setCertType(LstIqpApplyConstant.CERT_TYPE);
		iqpMeCusApp.setCertCode(String.valueOf(paramMap.get("id")));
		iqpMeCusApp.setCusName(String.valueOf(paramMap.get("custName")));
		iqpMeCusAppMapper.updateByPrimaryKeySelective(iqpMeCusApp);
		logger.info("更新完申请号为：{}的IqpMeCusApp", String.valueOf(paramMap.get("applNo")));
		
		//插入一条新的投保单信息表
		LstIqpInfo lstIqpInfoOld = lstIqpInfoMapper.selectByPrimaryKey(String.valueOf(paramMap.get("applNo")));
		LstIqpInfo lstIqpInfoNew=LstIqpApplyConstant.mapConvertLstIqpInfo(lstIqpInfoOld);
		lstIqpInfoMapper.insertSelective(lstIqpInfoNew);
		logger.info("插入完申请号为：{}的新LstIqpInfo", String.valueOf(paramMap.get("applNo")));
		
		//添加接口状态流程
		paPhCommonService.statusUpdateService(String.valueOf(paramMap.get("applNo")), SentStatusCode.PA_01.code(), "投保申请");
	}
}
