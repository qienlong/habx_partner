/**   
* @Title:：FO004002ServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午12:13:56 
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
import cn.com.sinosafe.service.padb.IssuedMsgService;
import cn.com.sinosafe.service.padb.PaPhService;

/** 
 * @ClassName:：FO004002ServiceImpl 
 * @Description： 投保生成通知接口调用类
 * @author ：xiewei
 * @date ：2019年6月8日 下午12:13:56  
 */
@Service("FO004002")
public class FO004002ServiceImpl  implements PaPhService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IssuedMsgService issuedMsgService;
	@Autowired
	private AsyncDealService asyncDealService;
	
	
	@Override
	public String service(Map<String, Object> paramMap) {
		String resultMsg=null;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			resultMsg=issuedMsgService.issuePolicy(paramMap);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
			resultMsg=JSON.toJSONString(resultMap);
		}
		//平安调用接口日志记录
		insertBizLog(paramMap,resultMsg);
		return resultMsg;
	}
	
   /**
     * 
    * @Title：insertBizLog 
    * @Description：异步日志记录
    * @param ：@param paramMap 
    * @return ：void 
    * @throws
     */
	public void insertBizLog(Map<String, Object> paramMap,String resultMsg){
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) paramMap.get("policyInfo");
			asyncDealService.insertBizLog((String)map.get("applNo"), "FO004002", paramMap, resultMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
