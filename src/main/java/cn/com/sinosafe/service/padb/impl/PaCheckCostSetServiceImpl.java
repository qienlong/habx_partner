/**   
* @Title:：PaCheckCostSetServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午12:07:51 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.config.constant.PaCheckSettlementConstant;
import cn.com.sinosafe.common.config.constant.PadbConstant;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.domain.dto.CheckCostSetResult;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import cn.com.sinosafe.service.padb.PaCheckCostSetService;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import net.sf.json.JSONObject;

/** 
 * @ClassName:：PaCheckCostSetServiceImpl 
 * @Description： 对公费用确认接口
 * @author ：xiewei
 * @date ：2019年6月8日 下午12:07:51  
 */
@Service
public class PaCheckCostSetServiceImpl implements PaCheckCostSetService{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PaPhCommonService paPhCommonService;
	
	
	@Override
	public String checkCostSet(Map<String, Object> paramMap){
		logger.info("*****************************对公费用确认接口 start*****************************");
		logger.info("param:{}",paramMap);
		CheckCostSetResult dto=null;
		String resultMsg = null;
		try {
			dto=PaCheckSettlementConstant.mapConvertDto(paramMap);
			//发请求至平安，给到封装好的确认结果
			logger.info("请求报文:{}",dto.toString());
			String responsemessage = JSON.toJSONString(dto);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("param", PaEncryptUtil.encryptByRSA(responsemessage));
			resultMsg = HttpClientUtil.sendPosts(SystemConfig.cacheMap.get("FCFPBX2004"),jsonObject.toString());// 平安普惠请求ras公钥加密
			
			logger.info("响应报文:{}",resultMsg);
			//请求响应日志
			paPhCommonService.insertBizLog("", "FCFPBX2004", JSON.toJSONString(paramMap), resultMsg);
		} catch (Exception e) {
			logger.error("error:{}",e.getMessage());
			e.printStackTrace();
		}
		logger.info("*****************************对公费用确认接口 end*****************************");
		return resultMsg;
	}

}
