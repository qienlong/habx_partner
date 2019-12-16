package cn.com.sinosafe.service.padb.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.sinosafe.common.config.SystemConfig;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.constant.PadbConstant;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.dao.FeeRateMapper;
import cn.com.sinosafe.domain.dto.FeeRateInfo;
import cn.com.sinosafe.domain.entity.FeeRate;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import cn.com.sinosafe.service.padb.IssuedRateService;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import net.sf.json.JSONObject;

/**
 * @ClassName:：IssuedRateServiceImpl
 * @Description：保费费率下发
 * @author ：pengll
 * @date ：2019年6月3日 下午2:41:16
 */
@Service
public class IssuedRateServiceImpl implements IssuedRateService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@Autowired
//	private FeeRateMapper feeRateMapper;

	@Autowired
	private PaPhCommonService paPhCommonService;

	/**
	 *
	 * 方法说明：保费费率下发
	 * 
	 * @author pengll
	 * @param paramMap
	 *            费率编码
	 * @return
	 * @time 2019-06-01
	 */
	@Override
	public String IssueFeeRateInfo(Map<String, Object> paramMap) {

		logger.info("---------根据条件开始查询费率表信息---------");
		logger.info("param:{}",paramMap);
		String responsemessage = "";
		HashMap<String,Object> hashMap=new HashMap<>();
		try {
			String parentProductNo = paramMap.get("parentProductNo").toString();
			List<FeeRateInfo> list = new ArrayList<FeeRateInfo>();
			FeeRateInfo feeRateInfo1 = new FeeRateInfo();
			feeRateInfo1.setFeeBase("LOAN_AMT");// 平安-基于本金
			feeRateInfo1.setFeeRateUnit(paramMap.get("rateUnit").toString());// Y:年 M:月 D:日 默认为月
			feeRateInfo1.setFeeRate(paramMap.get("paFeeRate").toString());// 平安费率
			feeRateInfo1.setFeeCode(paramMap.get("feeCode").toString());
			feeRateInfo1.setIncreaseCreditCode(paramMap.get("increaseCreditCode").toString());
			feeRateInfo1.setInsuCompany(paramMap.get("insuCompany").toString());
			list.add(feeRateInfo1);

			FeeRateInfo feeRateInfo2 = new FeeRateInfo();
			feeRateInfo2.setFeeBase("INS_AMT");// 华安-基于保额
			feeRateInfo2.setFeeRateUnit(paramMap.get("rateUnit").toString());// Y:年 M:月 D:日 默认为月
			feeRateInfo2.setFeeRate(paramMap.get("haFeeRate").toString());// 华安费率
			feeRateInfo2.setFeeCode(paramMap.get("feeCode").toString());
			feeRateInfo2.setIncreaseCreditCode(paramMap.get("increaseCreditCode").toString());
			feeRateInfo2.setInsuCompany(paramMap.get("insuCompany").toString());
			list.add(feeRateInfo2);

			hashMap.put("parentProductNo", parentProductNo);
			hashMap.put("increaseCreditFeeRateList", list);

			String requestmessage = JSONObject.fromObject(hashMap).toString();
			// 通过HTTPClient调用平安接口
			logger.info("---------请求报文" + requestmessage);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("param", PaEncryptUtil.encryptByRSA(requestmessage));
			responsemessage = sendPost(jsonObject.toString());// 平安普惠请求ras公钥加密
			logger.info("---------响应报文" + responsemessage);
			// 插入请求响应日志
			paPhCommonService.insertBizLog("", "FCFPBX1000", requestmessage, responsemessage);
		} catch (Exception e) {
			logger.error("保费费率下发异常" + e.getMessage());
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
			resultMsg = HttpClientUtil.httpPost(SystemConfig.cacheMap.get("FCFPBX1000"), jsonParam);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMsg;
	}
}
