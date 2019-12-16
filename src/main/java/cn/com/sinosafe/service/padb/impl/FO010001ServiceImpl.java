/**   
* @Title:：FO010001ServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午3:13:37 
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
import cn.com.sinosafe.service.padb.PaCostSettlementService;
import cn.com.sinosafe.service.padb.PaPhService;

/** 
 * @ClassName:：FO010001ServiceImpl 
 * @Description： 对公费费用结算接口调用类
 * @author ：xiewei
 * @date ：2019年6月8日 下午3:13:37  
 */
@Service("FO010001")
public class FO010001ServiceImpl implements PaPhService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PaCostSettlementService paCostSettlementService;
	
	@Autowired
	private AsyncDealService asyncDealService;
	
	/* (non-Javadoc)
	 * @see cn.com.sinosafe.service.padb.PaPhService#service(java.util.Map)
	 */
	@Override
	public String service(Map<String, Object> paramMap) {
		String resultMsg=null;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			resultMsg = paCostSettlementService.infoSync(paramMap);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
			resultMsg=JSON.toJSONString(resultMap);
		}
		//请求响应日志
		asyncDealService.insertBizLog("", "FO010001", paramMap, resultMsg);
		return resultMsg;
	}
	
}
