package cn.com.sinosafe.service.padb;

import java.util.Map;

/** 
 * @ClassName:：CheckInsureNoticeService 
 * @Description： 平安核保通知
 * @author ：pengll
 * @date ：2019年6月3日 下午2:41:16  
 */
public interface CheckInsureNoticeService {

	
	/**
	 * 
	* @Title：CheckInsureNotice
	* @Description：核保通知
	* @param ：平安请求参数paramMap
	* @return ：String 
	* @throws
	 */
	String checkInsureNotice(Map<String, Object> paramMap) throws Exception;
	
	
}
