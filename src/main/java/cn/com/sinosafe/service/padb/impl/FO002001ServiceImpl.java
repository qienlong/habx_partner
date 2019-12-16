/**   
* @Title:：FO002001ServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月4日 下午3:16:12 
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
import cn.com.sinosafe.service.padb.PaLstIqpApplyService;
import cn.com.sinosafe.service.padb.PaPhService;

/** 
 * @ClassName:：FO002001ServiceImpl 
 * @Description： 投保申请接口调用类
 * @author ：xiewei
 * @date ：2019年6月4日 下午3:16:12  
 */
@Service("FO002001")
public class FO002001ServiceImpl implements PaPhService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PaLstIqpApplyService paLstIqpApplyService;
	
	@Autowired
	private AsyncDealService asyncDealService;
	
	@Override
	public String service(Map<String, Object> paramMap) {
		String resultMsg=null;
		Map<String, String> resultMap=new HashMap<String, String>();
		 try {
			 resultMsg=paLstIqpApplyService.lstIqpApplyNoSign(paramMap);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
			resultMsg=JSON.toJSONString(resultMap);
		}
		businessHandle(paramMap, resultMsg);
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
	public void businessHandle(Map<String, Object> paramMap,String resultMsg){
		try {
			//asyncDealService.statusUpdateService(String.valueOf(paramMap.get("applNo")), SentStatusCode.PA_01.code(), "投保申请");
			asyncDealService.insertBizLog(String.valueOf(paramMap.get("applNo")), "FO002001", paramMap, resultMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
