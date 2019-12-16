package cn.com.sinosafe.service.padb;

import java.util.Map;

/**
 * 保费率一致性通知service
 * 
 * @Project : haxb_partner
 * @Author : pengll
 * @Date : 2019年6月5日 下午3:04:32
 * @Version : 1.0
 */
public interface CheckRateService {

	
	
	/**
	* 
	* checkInsureNotice
	* @Description：保费费率一致性检查
	* @param ：平安请求参数paramMap
	* @return ：String 
	* @throws
	*/
	String CheckFeeRate(Map<String, Object> paramMap) throws Exception;
	
	
}
