package cn.com.sinosafe.service.padb.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.service.padb.CheckRateService;
import cn.com.sinosafe.service.padb.PaPhService;

/**
 * 保费率一致性通知接口service
 * 
 * @Project : haxb_partner
 * @Author : pengll
 * @Date : 2019年6月5日 下午3:04:32
 * @Version : 1.0
 */
@Service("FO003003")
public class FO003003ServiceImpl implements PaPhService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CheckRateService checkRateService;

	
	/**
	* 
	* service
	* @Description：保费率一致性通知接口
	* @param ：平安请求参数paramMap
	* @return ：String 
	* @throws
	*/
	@Override
	public String service(Map<String, Object> paramMap) {

		logger.info("-----调用CheckRateService.checkRateService方法进行保费率一致性检查------");
		Map<String, String> resultMap=new HashMap<String, String>();
		String result = "";
		try {
			result = checkRateService.CheckFeeRate(paramMap);
		} catch (Exception e) {
			logger.error("保费率一致性检查异常：" + e.getMessage(),e);
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
			result=JSON.toJSONString(resultMap);
		}
		return result;

	}

}
