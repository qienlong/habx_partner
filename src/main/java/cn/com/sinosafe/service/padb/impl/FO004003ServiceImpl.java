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
import cn.com.sinosafe.service.padb.PaPhService;
import cn.com.sinosafe.service.padb.PspClaimNoticeService;

/** 
 * @ClassName:：FO004003ServiceImpl 
 * @Description： 外部保险理赔交易报盘接口
 * @author ：longxiaoqiang
 * @date ：2019年9月3日 下午12:13:56  
 */
@Service("FCFPBX4003")
public class FO004003ServiceImpl  implements PaPhService{
	
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PspClaimNoticeService pspClaimNoticeService;
	@Autowired
	private AsyncDealService asyncDealService;
	
	
	@Override
	public String service(Map<String, Object> paramMap) {
		String resultMsg=null;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			resultMsg=pspClaimNoticeService.pspClaimNotice(paramMap);
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
			asyncDealService.insertBizLog((String)paramMap.get("claimBatchNo"), "FO004003", paramMap, resultMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
