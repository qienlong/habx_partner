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
import cn.com.sinosafe.service.padb.PspClaimApproveService;

/** 
 * @ClassName:：FO004001ServiceImpl 
 * @Description： 核赔申请服务接口
 * @author ：longxiaoqiang
 * @date ：2019年8月27日 下午12:13:56  
 */
@Service("FCFPBX4001")
public class FO004001ServiceImpl  implements PaPhService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PspClaimApproveService pspClaimApproveService;
	@Autowired
	private AsyncDealService asyncDealService;
	
	
	@Override
	public String service(Map<String, Object> paramMap) {
		String resultMsg=null;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			resultMsg=pspClaimApproveService.pspClaimApprove(paramMap);
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
			asyncDealService.insertBizLog((String)paramMap.get("premBatchNo"), "FO004001", paramMap, resultMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
