package cn.com.sinosafe.service.padb;

import java.util.Map;

/**
 * 供平安普惠调用的服务接口
 * @Project	: haxb_partner
 * @Author	: hesong
 * @Date	: 2019年6月3日 下午7:44:38
 * @Version	: 1.0
 */
public interface PaPhService {

	/**
	 * 供平安普惠调用的服务接口
	 * 服务提供者需封装好各项异常，避免直接将异常抛给平安普惠
	 * @author	: hirson
	 * @date	: 2019年6月3日 下午9:01:46
	 * @param paramMap
	 * @return	:
	 */
	String service(Map<String, Object> paramMap);
}
