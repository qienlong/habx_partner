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
import cn.com.sinosafe.service.padb.CheckInsureNoticeService;
import cn.com.sinosafe.service.padb.PaPhService;

/**
 * 核保通知接口service
 * 
 * @Project : haxb_partner
 * @Author : pengll
 * @Date : 2019年6月4日 下午9:04:32
 * @Version : 1.0
 */
@Service("FO003001")
public class FO003001ServiceImpl implements PaPhService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CheckInsureNoticeService noticeService;
	

	/**
	* 
	* service
	* @Description：核保通知接口
	* @param ：平安请求参数paramMap
	* @return ：String 
	* @throws
	*/
	@Override
	public String service(Map<String, Object> paramMap) {
		logger.info("-----调用CheckInsureNoticeService.CheckInsureNotice方法进行接收核保通知------");
		Map<String, String> resultMap=new HashMap<String, String>();
		String result = "";
		try {
			result = noticeService.checkInsureNotice(paramMap);
		} catch (Exception e) {
			logger.error("核保通知异常："+e.getMessage(),e);
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
			result=JSON.toJSONString(resultMap);
		}
		return result;
	}

}
