package cn.com.sinosafe.service.common;


/**
 * 短信推送服务
 * @Project	: ruoyi-push
 * @Author	: hesong
 * @Date	: 2019年1月16日 上午8:55:34
 * @Version	: 1.0
 */
public interface SmsPushService {

	/**
	 * 短信推送服务
	 * @author	: hirson
	 * @date	: 2019年1月16日 上午9:02:47
	 * @param smsContent	短信内容
	 * @param mobiles		手机号码
	 * @return	:
	 */
	public String pushMessage(String smsContent, String[] mobiles);

	/**TODO
	 * @author	: hirson
	 * @date	: 2019年6月5日 下午7:02:02
	 * @param smsContent
	 * @param mobiles
	 * @return	: 
	 */
	String pushMessage(String smsContent, String mobiles);
}
