/**   
* @Title:：PaCheckSettlementConstant.java 
* @Package ：cn.com.sinosafe.common.config.constant 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午3:24:01 
* @version ： 1.0   
*/
package cn.com.sinosafe.common.config.constant;

import java.util.Map;

import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.dto.CheckCostSetResult;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/** 
 * @ClassName:：PaCheckSettlementConstant 
 * @Description： 公费确认辅助类
 * @author ：xiewei
 * @date ：2019年6月8日 下午3:24:01  
 */
public class PaCheckSettlementConstant {
	
	public static CheckCostSetResult mapConvertDto(Map<String, Object> paramMap) throws Exception{
		CheckCostSetResult dto=null;
		try {
			dto=JSONObject.parseObject(JSON.toJSONString(paramMap),CheckCostSetResult.class);
			dto.setAccountMonth(StringUtils.isEmpty(dto.getAccountMonth())?"":dto.getAccountMonth().replaceAll("-", ""));
			dto.setSinglefeedate(StringUtils.isEmpty(dto.getSinglefeedate())?"":dto.getSinglefeedate().replaceAll("-", ""));
			//推送公费确认结果给平安
		} catch (Exception e) {
			throw new BusinessException("转换错误！,paramMap is :"+paramMap.toString());
		}
		return dto;
	}
}
