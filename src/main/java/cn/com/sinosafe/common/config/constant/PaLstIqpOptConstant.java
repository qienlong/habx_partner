/**   
* @Title:：PaLstIqpOptConstant.java 
* @Package ：cn.com.sinosafe.common.config.constant 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月10日 下午2:40:33 
* @version ： 1.0   
*/
package cn.com.sinosafe.common.config.constant;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.domain.entity.CusIndiv;
import cn.com.sinosafe.domain.entity.LstIqpInfo;

/** 
 * @ClassName:：PaLstIqpOptConstant 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月10日 下午2:40:33  
 */
public class PaLstIqpOptConstant {
	
	public static Map<String, Object> getTempInfo(Calendar calendar,CusIndiv cusInfo,LstIqpInfo lstIqpInfo){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		Map<String,String> infoMap=new HashMap<String,String>();
		infoMap.put("1", DateUtils.getDateCalStr(calendar));
		resultMap.put("infoMap", infoMap);
		Map<String,String> lstInfoMap=new HashMap<String,String>();
		lstInfoMap.put("1", cusInfo.getCusName());
		lstInfoMap.put("2", cusInfo.getCertCode());
		lstInfoMap.put("3", cusInfo.getMobile());
		lstInfoMap.put("4", lstIqpInfo.getcAppnt().replaceAll("\\r\\n", ""));
		lstInfoMap.put("5","签署年月日："+DateUtils.getDateCalStr(calendar));
		lstInfoMap.put("6", SystemConfig.cacheMap.get("HA_PAPH_PAY_ABILITY").split(";")[0]);
		lstInfoMap.put("7", SystemConfig.cacheMap.get("HA_PAPH_PAY_ABILITY").split(";")[1]);
		lstInfoMap.put("8", SystemConfig.cacheMap.get("HA_PAPH_PAY_ABILITY").split(";")[2]+"%");
		lstInfoMap.put("9", SystemConfig.cacheMap.get("HA_PAPH_PAY_ABILITY").split(";")[3]);
		resultMap.put("lstInfoMap", lstInfoMap);
		return resultMap;
	}
}
