package cn.com.sinosafe.service.padb.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.httpclient.HttpUtil;
import cn.com.sinosafe.service.padb.IapsService;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.constant.CheckIssueResultEnum;
import cn.com.sinosafe.common.config.constant.CommonConstant;
import cn.com.sinosafe.common.config.constant.PadbConstant;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.dao.AccLoanMapper;
import cn.com.sinosafe.dao.CusBlkListMapper;
import cn.com.sinosafe.domain.entity.CusBlkList;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import cn.com.sinosafe.service.padb.CheckInsureConFirmService;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import net.sf.json.JSONObject;

/**
 * @ClassName:：CheckInsureNoticeServiceImpl @Description： 平安核保确认
 * @author ：pengll
 * @date ：2019年6月3日 下午2:41:16
 */
@Service
public class CheckInsureConFirmServiceImpl implements CheckInsureConFirmService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AccLoanMapper accLoanMapper;

	@Autowired
	private CusBlkListMapper cusBlkListMapper;
	
	@Autowired
	private PaPhCommonService paPhCommonService;

	@Autowired
	private IapsService iapsService;

	/**
	 *
	 * 方法说明：根据校验规则进行核保确认
	 * 
	 * @author pengll
	 * @param amount
	 *            金额
	 * @param certCode
	 *            身份证号
	 * @return String类型
	 * @time 2019-06-04
	 */
	@Override
	public String checkIqpInfo(BigDecimal amount, String certCode,String approveResult) {

		logger.info("------根据校验规则进行核保确认------");
		if(CheckIssueResultEnum.PA_APPROVE_REJECT.code().equals(approveResult)) {
			return CheckIssueResultEnum.PINGAN_REJECT.code();
		}
		// 查询金额是否大于100万
		String balance = accLoanMapper.getBalanceByCertCode(certCode);
		if (!StringUtils.isEmpty(balance)) {
			amount = amount.add(new BigDecimal(balance));
		}
		if (amount.compareTo(new BigDecimal(CommonConstant.LimitAmt)) == 1) {
			return CheckIssueResultEnum.AMOUNT_REJECT.code();
		}
		// 查询华安内部黑名单
		CusBlkList cusBlkList = cusBlkListMapper.selectByCertCode(certCode);
		if (cusBlkList != null) {
			logger.info("命中黑名单");
			return CheckIssueResultEnum.BLK_REJECT.code();
		}
		// 根据身份证查询存在已出单、未结清个金的贷款
		//客户存在两笔已出单、未结清的05210306贷款记录
		int count = accLoanMapper.getCountByCertCode(certCode);
		int accLoancount = accLoanMapper.getAccLoanCountByCertCode(certCode);
		if (count > 0 || accLoancount>1) {
			return CheckIssueResultEnum.LOAN_STATUS_REJECT.code();
		}
		return CommonConstant.HUAAN_APPROVE;
	}

	/**
	 *
	 * 方法说明：发送核保确认信息
	 * 
	 * @author pengll
	 * @param map对象
	 * @param
	 * @return
	 * @time 2019-06-04
	 */
	@Override
	public String sendInsureConfirmInfo(Map<String, Object> paramMap) {
		// 调用平安接口发送投保结果信息
		try {
			logger.info("--------调用平安接口发送核保确认结果信息---------");
			// 通过HTTPClient调用平安接口
			String responsemessage ="";
			String requestmessage = JSONObject.fromObject(paramMap).toString();
			logger.info("---------请求报文" + requestmessage);
			//调用调用平安核保通知接口
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("param", PaEncryptUtil.encryptByRSA(requestmessage));
			Thread.sleep(2000);
			responsemessage = sendPost(jsonObject.toString());// 平安普惠请求ras公钥加密
			logger.info("---------响应报文" + responsemessage);
			// 插入请求响应日志
			
			paPhCommonService.insertBizLog("", "FCFPBX1000", requestmessage, responsemessage);
			return responsemessage;
		} catch (Exception e) {
			logger.error("--------调用平安接口发送核保确认结果异常---------" + e.getMessage());
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String sendPaCheckCard4Param(Map<String, String> requestmap) {
		// 调用平安付接口发送平安四要素
		try {
			String requestmessage = JSONObject.fromObject(requestmap).toString();
			logger.info("---------请求报文" + requestmessage);
            // 发送请求
			String iaps=SystemConfig.cacheMap.get("IAPS")+"/ffastpay";
            String rep = HttpUtil.doPost(iaps,requestmap);
          	if(rep!=null || rep!=""){
				Map<String,Object> map=new HashMap<String,Object>();
				String[] str=rep.split("&");
				for(int i=0;i<str.length;i++){
					String[] strings = str[i].split("=");
					map.put(strings[0],strings[1]);
				}
				//平安付四要素鉴定结果入库
				iapsService.insertIapsEntity(map);
			}
			// 插入请求响应日志
			paPhCommonService.insertBizLog("", "FCFPBX1000", requestmessage, rep);
			return rep;
		} catch (Exception e) {
			logger.error("--------调用平安付接口异常---------",e.getMessage());
			return "";
		}
	}

	/**
	 *
	 * 方法说明：通过HTTPClient调用平安接口
	 * 
	 * @author xiewei
	 * @param jsonParam
	 *            发送json字符串
	 * @return String类型
	 * @time 2019-06-06
	 */
	private String sendPost(String jsonParam) throws Exception {
		String resultMsg = null;
		try {
			resultMsg = HttpClientUtil.httpPost(SystemConfig.cacheMap.get("FCFPBX1001B"), jsonParam);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMsg;
	}

}
