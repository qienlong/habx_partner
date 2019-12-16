package cn.com.sinosafe.service.common.impl;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.constant.CommonConstant;
import cn.com.sinosafe.common.config.properties.SmsProperties;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.service.common.SmsPushService;

/**
 * 短信推送
 * @Project	: ruoyi-push
 * @Author	: hesong
 * @Date	: 2019年1月16日 上午9:32:31
 * @Version	: 1.0
 */
@Service
public class SmsPushServiceImpl implements SmsPushService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SmsProperties smsConfig;
	
	@Override
	public String pushMessage(String smsContent, String[] mobiles) {
		for (String phone : mobiles) {
			executeSent(smsContent, phone);
		}
		return null;
	}
	
	@Override
	public String pushMessage(String smsContent, String mobiles) {
		return executeSent(smsContent, mobiles);
	}

	private String executeSent(String smsContent, String mobiles) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("MessageContent", smsContent);
		params.put("SpCode", "200097");
		params.put("LoginName", smsConfig.getUser());
		params.put("Password", smsConfig.getPwd());
		params.put("UserNumber", mobiles);
		params.put("SerialNumber", "");
		params.put("ScheduleTime", "");
		params.put("f", "1");
		params.put("busynessCode", "04");
		String sendResult = HttpClientUtil.sendPost_(smsConfig.getUrl(), params, CommonConstant.CHARSET_GBK);
		logger.info("【华安短信推送】当前号码{}，短信内容{}，发送结果{}", mobiles, smsContent, sendResult);
		return sendResult;
	}
}
