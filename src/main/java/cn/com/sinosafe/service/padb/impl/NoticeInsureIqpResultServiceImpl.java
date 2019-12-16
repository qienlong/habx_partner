package cn.com.sinosafe.service.padb.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.properties.MailProperties;
import cn.com.sinosafe.common.util.CommonUtils;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.SentStatusCode;
import cn.com.sinosafe.domain.dto.InsureIqpResult;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import cn.com.sinosafe.service.padb.NoticeInsureIqpResultService;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import net.sf.json.JSONObject;

/**
*
* 方法说明：获取投保结果信息
* @author pengll
* @param applNo 申请号
* @param resultCode 投保结果
* @return String类型
* @time 2019-06-06
*/
@Service
public class NoticeInsureIqpResultServiceImpl implements NoticeInsureIqpResultService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;

	@Autowired
	private PaPhCommonService paPhCommonService;
	
	@Autowired
    private CommonUtils commonUtils;
	
	@Autowired
	private MailProperties mailProperties;

	/**
	 *
	 * 方法说明：同步投保结果信息给平安
	 * 
	 * @author pengll
	 * @param applNo
	 *            申请号
	 * @param resultCode
	 *            投保结果
	 * @return String类型
	 * @time 2019-06-06
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String queryInsureIqpResult(String accToken, String applNo, String resultCode) {
		if (resultCode.equals(PaResultCode.PA_SUCCESS.code())) {
			resultCode = "Y";
		} else if (resultCode.equals(PaResultCode.PA_FAIL.code())) {
			resultCode = "N";
		}
		// 根据申请号校验已完成签署投保单行为的保单
		LstIqpInfo lstIqpInfo = new LstIqpInfo();
		String responsemessage = "";
		try {
			lstIqpInfo = lstIqpInfoMapper.selectByIqpLoanSerno(applNo);
			if (lstIqpInfo == null) {
				logger.info("------查询保单信息为空");
				return "";
			}
//			InsureIqpResult insureIqpResult = new InsureIqpResult();
            Map<String, String> paramMaps = new HashMap<String, String>();
//			insureIqpResult.setApplNo(applNo);// 申请号
            paramMaps.put("appl_no",applNo);
//			insureIqpResult.setProductCode("OD");//保单对应贷款产品代码
            paramMaps.put("product_code","OD");
//			insureIqpResult.setCustName(lstIqpInfo.getCusName());// 客户姓名
            paramMaps.put("cust_name",lstIqpInfo.getCusName());
//			insureIqpResult.setMobile(lstIqpInfo.getMobile());// 手机号
            paramMaps.put("mobile",lstIqpInfo.getMobile());
//			insureIqpResult.setIdType("1");//身份类型
            paramMaps.put("id_type","1");
//			insureIqpResult.setId(lstIqpInfo.getCertCode());// 身份证号
            paramMaps.put("id",lstIqpInfo.getCertCode());
//			insureIqpResult.setIsAuthorized(resultCode);// 投保结果
//			insureIqpResult.setPolicyChannel("06");
            paramMaps.put("policy_channel","06");//渠道标示
//			insureIqpResult.setInsuCompany("HABX");// 保险公司合作方
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if ("Y".equals(resultCode)) { // 投保成功
//				insureIqpResult.setCoverNo(lstIqpInfo.getCoverSerno());// 投保单号
                paramMaps.put("cover_no",lstIqpInfo.getSerno());/// 投保单号
//				insureIqpResult.setApplDate(dateFormat.format(new Date()));
                paramMaps.put("appl_date",dateFormat.format(new Date()));
//                insureIqpResult.setIsCompleted(resultCode);//是否完成投保(Y完成投保 N没有)
                paramMaps.put("is_completed",resultCode);
//				insureIqpResult.setSuccessH5Url("success.html");
//				insureIqpResult.setNoticeType("N");//批单标示(投保N/保单批单Y)
//				insureIqpResult.setAntiMoneyLaunderingCode("0000");//反洗钱结果（0000:核保通过，9999：核保不通过0000:投保通过，9999：投保不通过）
                paramMaps.put("anti_money_laundering_code","0000");
//                insureIqpResult.setAntiMoneyLaunderingMsg("通过"); //反洗钱结果通过或不通过
                paramMaps.put("anti_money_laundering_msg ","通过");
//				insureIqpResult.setPolicyStatus("1");//返回保单状态标识(1投保完成，2投保拒绝,3核保通过,4核保拒绝,5保单信息确认完成)
                paramMaps.put("policy_status ","1");
				//更新轨迹
				paPhCommonService.statusUpdateService(applNo, SentStatusCode.PA_02.code(), "投保成功");
			} else if ("N".equals(resultCode)) { // 投保异常
//				insureIqpResult.setFalMsg("投保异常");
//				insureIqpResult.setReason("投保异常");
                paramMaps.put("reason ","投保异常");
				paPhCommonService.statusUpdateService(applNo, SentStatusCode.PA_03.code(), "投保失败");
			}
			// 调用平安接口发送投保结果信息
			String requestMessage = JSONObject.fromObject(paramMaps).toString();
			logger.info("---------请求报文" + requestMessage);
			//拼接请求地址
			String phurl = SystemConfig.cacheMap.get("FCFPBX3006");
			phurl = phurl + "?access_token=" + accToken + "&request_id=" + DateUtils.getTimestamp();
			logger.info("请求地址phurl{}" + phurl);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("param", PaEncryptUtil.encryptByRSA(requestMessage));
			logger.info("請求參數{}：" + jsonObject);
			responsemessage = HttpClientUtil.httpPostPh(phurl, requestMessage);
			
			logger.info("---------响应报文" + responsemessage);
			try {
				Map<String, Object> map = JSONUtils.getSingleInstance().readMapValue(responsemessage);
				String ret = (String)map.get("ret");
				if ("0".equals(ret)) {
					Map<String, Object> dataMap = (Map<String, Object>)map.get("data");
					String rc = (String)dataMap.get("result_code");
					if (!"1".equals(rc)) {
						//邮件预警
						commonUtils.commomMail("华安-普惠投保结果通知失败！", requestMessage, mailProperties.getReciverAddress(), mailProperties.getCcAddress());
					} else {
						Thread.sleep(1000);//岔开投保成功，便于标识
						//添加接口状态流程
						paPhCommonService.statusUpdateService(applNo, SentStatusCode.PA_04.code(), "已投保通知");
					}
				} else {
					//邮件预警
					commonUtils.commomMail("华安-普惠投保结果通知失败！", requestMessage, mailProperties.getReciverAddress(), mailProperties.getCcAddress());
				}
			} catch (Exception e) {
				//邮件预警
				commonUtils.commomMail("华安-普惠投保结果通知失败！", requestMessage, mailProperties.getReciverAddress(), mailProperties.getCcAddress());
				logger.error("华安-普惠投保结果通知失败!" + e.getMessage());
				e.printStackTrace();
			}
			
			/*//添加接口状态流程
			paPhCommonService.statusUpdateService(applNo, SentStatusCode.PA_04.code(), "已投保通知");*/
			// 插入请求响应日志
			paPhCommonService.insertBizLog(applNo, "FCFPBX1000", requestMessage, responsemessage);
		} catch (Exception e) {
			logger.error("同步投保结果信息给平安" + e.getMessage());
			e.printStackTrace();
		}
		return responsemessage;
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
			resultMsg=HttpClientUtil.httpPost(SystemConfig.cacheMap.get("FCFPBX1001B"), jsonParam);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMsg;
	}
}
