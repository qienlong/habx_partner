package cn.com.sinosafe.service.padb.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosafe.common.config.constant.CommonConstant;
import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.dao.FeeRateMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.bean.PaResult;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.bean.SentStatusCode;
import cn.com.sinosafe.domain.entity.FeeRate;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.service.padb.CheckRateService;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import net.sf.json.JSONObject;

/**
 * 保费率一致性通知service
 * 
 * @Project : haxb_partner
 * @Author : pengll
 * @Date : 2019年6月5日 下午3:04:32
 * @Version : 1.0
 */
@Service
public class CheckRateServiceImpl implements CheckRateService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;

	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;

	@Autowired
	private PaPhCommonService paPhCommonService;
	
	@Autowired
	private FeeRateMapper feeRateMapper;

	
	/**
	* 
	* checkInsureNotice
	* @Description：保费费率一致性检查
	* @param ：平安请求参数paramMap
	* @return ：String 
	* @throws
	*/
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String CheckFeeRate(Map<String, Object> paramMap) throws Exception {

		logger.info("-------开始调用保费率一致性通知接口--------");
		// 默认返回成功
		String code = PaResultCode.PA_SUCCESS.code();// 返回状态码
		String message =PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
		Map<String, String> resultMap=new HashMap<String, String>();
		// 检验字段必输
		try {
				String[] needField = { "applNo", "checkNo", "resultSign", "isSendMsg", "insuCompany", "source" };
				boolean flag = LstIqpApplyConstant.checkFieldDefect(paramMap, needField);
		
				if (flag == true) { // 字段缺失
					code = PaResultCode.PA_FIELD_DELETION.code();
					message = PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE;
				} else {
					// 根据申请号校验存在该笔数据，且华安核保通过
					logger.info("------根据申请号校验存在该笔数据-------");
					String applNo = paramMap.get("applNo").toString();// 申请号
					IqpMeLoanApp iqpMeLoanApp = new IqpMeLoanApp();
					iqpMeLoanApp.setSerno(applNo);
					iqpMeLoanApp.setApproveStatus(CommonConstant.NEW_APPROVAL_SUCCESS);
					IqpMeLoanApp iqpMeLoanApps = new IqpMeLoanApp();
					iqpMeLoanApps = iqpMeLoanAppMapper.getBySernoAndSatus(iqpMeLoanApp);
					if(iqpMeLoanApps == null) {
						logger.info("该申请号对应投保单申请信息不存在或未核保通过");
						code = PaResultCode.PA_FAIL.code();
						message = "该申请号对应投保单申请信息不存在或未核保通过";
					}else {
						// 申请号和核保单号匹配一致校验
						logger.info("------申请号和核保单号匹配一致校验-------");
						LstIqpInfo lstIqpInfo = new LstIqpInfo();
						lstIqpInfo = lstIqpInfoMapper.selectByIqpLoanSerno(applNo);
						if (lstIqpInfo != null) {
							if (!paramMap.get("checkNo").toString().equals(lstIqpInfo.getContNo())) { //校验核保单号是否一致
								logger.info("申请号和核保单号匹配不一致");
								code = PaResultCode.PA_FAIL.code();
								message = "申请号和核保单号匹配不一致";
							} else {
								String resultSign = paramMap.get("resultSign").toString();// 费率一致性标识
								if ("N".equals(resultSign)) {
									Map<String, String> paramMaps = new HashMap<String, String>();
									paramMaps.put("{paserno}",applNo);//平安申请号
									paramMaps.put("{haserno}", lstIqpInfo.getSerno());//华安业务流水号
									paramMaps.put("{painsureRateCode}", iqpMeLoanApps.getInsureRateCode());//平安保费费率码值
									
									//查询费率
									FeeRate feeRate1 = new FeeRate();
									feeRate1.setFeeCode(iqpMeLoanApps.getInsureRateCode());
									FeeRate feeRate2 = new FeeRate();
									feeRate2 = feeRateMapper.queryFeeRateInfo(feeRate1);// 查询费率信息
									String feeRate = "";// 保费费率
									String feeCode = "";// 保费费率码值
									if (feeRate2 != null) {
										feeRate = feeRate2.getFeeRate()+"%";
										feeCode = feeRate2.getFeeCode();
									}
									paramMaps.put("{hainsureRateCode}", feeCode);//华安保费费率码值
									paramMaps.put("{insureRate}", feeRate);//费率
		
									//费率不一致更新投保单申请表
									IqpMeLoanApp iqpMeLoanApp1 = new IqpMeLoanApp();
									iqpMeLoanApp1.setSerno(applNo);// 申请号
									iqpMeLoanApp1.setApproveStatus(CommonConstant.APPROVAL_REJECT);// 审批状态
									iqpMeLoanApp1.setRefuseReason("保费费率不一致");// 拒绝原因
									iqpMeLoanApp1.setNewApproveStatus(CommonConstant.NEW_RATE_REJECT);// 审批状态(NewApproveStatus)
									iqpMeLoanAppMapper.updateByPrimaryKeySelective(iqpMeLoanApp1);
									
									//费率不一致更新保单信息表
									LstIqpInfo lstIqpInfo2 = new LstIqpInfo();
									lstIqpInfo2.setSerno(lstIqpInfo.getSerno());// 信保业务流水号
									lstIqpInfo2.setStatus(CommonConstant.APPROVAL_REJECT);// 保单状态
									lstIqpInfo2.setApplyStatus(CommonConstant.APPROVAL_REJECT);//投保单申请状态
									lstIqpInfo2.setLastUpdId("admin");//更新人
									lstIqpInfo2.setLastUpdDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//更新时间
									lstIqpInfoMapper.updateByPrimaryKeySelective(lstIqpInfo2);
									// 发送邮件
									paPhCommonService.pushMail("平安独立承保保费率不一致", 1, "huangshaobo<huangshaobo@sinosafe.com.cn>,leiyu<leiyu@sinosafe.com.cn>,hesong<hesong@sinosafe.com.cn>,pandeqiang<pandeqiang@sinosafe.com.cn>", paramMaps);
									paPhCommonService.statusUpdateService(applNo, SentStatusCode.PA_07.code(), "保费校验拒绝");
								}else{
									IqpMeLoanApp iqp = new IqpMeLoanApp();
									iqp.setSerno(applNo);// 申请号
									iqp.setNewApproveStatus(CommonConstant.NEW_RATE_SUCCESS);// 审批状态(NewApproveStatus)
									iqpMeLoanAppMapper.updateByPrimaryKeySelective(iqp);
									paPhCommonService.statusUpdateService(applNo, SentStatusCode.PA_08.code(), "保费校验通过");
								}
							}
		
						} else {
							logger.info("该申请号对应投保单不存在或未签署");
							code = PaResultCode.PA_FAIL.code();
							message = "该申请号对应投保单不存在或未签署";
						}
					}
				}
		}catch (Exception e) {
			logger.error("errorInfo:"+e.getMessage());
			throw new BusinessException(e.getMessage());
		}
//		PaResult paResult = PaResultGenerator.getDefMsgByCode(code, message);
		resultMap.put("resultCode",code);
		resultMap.put("resultMsg", message);
		String result= JSON.toJSONString(resultMap);
//		String result = JSONObject.fromObject(paResult).toString();
		// 插入请求响应日志
		paPhCommonService.insertBizLog("", "FCFPBX1002", JSONObject.fromObject(paramMap).toString(), result);
		return result;
	}

}
