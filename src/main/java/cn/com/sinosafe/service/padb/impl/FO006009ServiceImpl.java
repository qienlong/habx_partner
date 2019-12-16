/**   
* @Title:：FO006009ServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午9:09:55 
* @version ： 1.0   
*/
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
import cn.com.sinosafe.service.padb.PaCancelNoticeService;
import cn.com.sinosafe.service.padb.PaPhService;

/** 
 * @ClassName:：FO006009ServiceImpl 
 * @Description： 退汇取消通知接口调用类
 * @author ：xiewei
 * @date ：2019年6月8日 下午9:09:55  
 */
@Service("FO006009")
public class FO006009ServiceImpl implements PaPhService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PaCancelNoticeService paCancelNoticeService;
	
	@Autowired
	private AsyncDealService asyncDealService;

	/* 
	 * @see cn.com.sinosafe.service.padb.PaPhService#service(java.util.Map)
	 */
	@Override
	public String service(Map<String, Object> paramMap) {
		String resultMsg=null;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			resultMsg = paCancelNoticeService.cancelRemitAll(paramMap);
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
			resultMsg=JSON.toJSONString(resultMap);
			e.printStackTrace();
		}
		//请求响应日志
		asyncDealService.insertBizLog(String.valueOf(paramMap.get("applNo")), "FO006009", paramMap, resultMsg);
		return resultMsg;
	}

}
