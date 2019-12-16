/**   
* @Title:：PaCostSettlementConstant.java 
* @Package ：cn.com.sinosafe.common.config.constant 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午2:00:01 
* @version ： 1.0   
*/
package cn.com.sinosafe.common.config.constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.dto.PaCostSettlementDto;
import cn.com.sinosafe.domain.entity.PubExpenSettlement;
import cn.com.sinosafe.domain.entity.PubExpenSettlementSub;
import cn.com.sinosafe.lina.common.utils.UUIDUtils;

/** 
 * @ClassName:：PaCostSettlementConstant 
 * @Description： 对公费用结算接口常用工具类
 * @author ：xiewei
 * @date ：2019年6月8日 下午2:00:01  
 */
public class PaCostSettlementConstant {
	
	public static final String DEFBIGDECIMAL="0.0";
	
	public static PaCostSettlementDto mapConvertDto(Map<String, Object> paramMap) throws Exception{
		PaCostSettlementDto dto=null;
		try {
			dto=JSONObject.parseObject(JSON.toJSONString(paramMap),PaCostSettlementDto.class);
		} catch (Exception e) {
			throw new BusinessException("转换错误！,paramMap is :"+paramMap.toString());
		}
		return dto;
	}
	
	public static PubExpenSettlement dtoToBo(Map<String, Object> paramMap){
		PubExpenSettlement bo=null;
		try {
			bo=new PubExpenSettlement();
			bo.setInsuCompany(LstIqpSyncConstant.insuCompany);
			bo.setUuid(UUIDUtils.generate());
			bo.setAccountMonth(String.valueOf(paramMap.get("accountMonth")).trim().substring(0, 4)+"-"+String.valueOf(paramMap.get("accountMonth")).trim().substring(String.valueOf(paramMap.get("accountMonth")).trim().length()-2));
			bo.setAccountTotal(StringUtils.isEmpty(String.valueOf(paramMap.get("accountTotal")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("accountTotal"))));
			bo.setBasePrice(StringUtils.isEmpty(String.valueOf(paramMap.get("basePrice")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("basePrice"))));
			bo.setAccountNum(String.valueOf(paramMap.get("accountNum")));
			bo.setBasePriceTotal(StringUtils.isEmpty(String.valueOf(paramMap.get("basePriceTotal")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("basePriceTotal"))));
			bo.setFloatingMonth(String.valueOf(paramMap.get("floatingMonth")));
			bo.setAssetPoolPa(StringUtils.isEmpty(String.valueOf(paramMap.get("assetPoolPa")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("assetPoolPa"))));
			bo.setAssetPoolInsur(StringUtils.isEmpty(String.valueOf(paramMap.get("assetPoolInsur")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("assetPoolInsur"))));
			bo.setAssetPoolOdds(StringUtils.isEmpty(String.valueOf(paramMap.get("assetPoolOdds")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("assetPoolOdds"))));
			bo.setFloatingPrice(StringUtils.isEmpty(String.valueOf(paramMap.get("floatingPrice")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("floatingPrice"))));
			bo.setFloatingTotal(StringUtils.isEmpty(String.valueOf(paramMap.get("floatingTotal")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("floatingTotal"))));
			bo.setSingleFeeRate(StringUtils.isEmpty(String.valueOf(paramMap.get("singlefeerate")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("singlefeerate"))));
			bo.setSingleFeeDate(String.valueOf(paramMap.get("singlefeedate")).trim().substring(0, 4)+"-"+String.valueOf(paramMap.get("singlefeedate")).trim().substring(String.valueOf(paramMap.get("singlefeedate")).trim().length()-2));
			bo.setCoverFiAmt(StringUtils.isEmpty(String.valueOf(paramMap.get("coverFiAmt")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("coverFiAmt"))));
			bo.setSingleFeeTotal(StringUtils.isEmpty(String.valueOf(paramMap.get("singlefeetotal")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("singlefeetotal"))));
			bo.setFloatingAge(String.valueOf(paramMap.get("floatingAge")));
			bo.setCopNo(SystemConfig.cacheMap.get("PAHA_INDCRT_COP_NO"));
			bo.setCopName("平安普惠");	
			bo.setOverdueTotal(StringUtils.isEmpty(String.valueOf(paramMap.get("overdueTotal")))?new BigDecimal(0):new BigDecimal(String.valueOf(paramMap.get("overdueTotal"))));
			bo.setOverdueFeeList(UUIDUtils.generate());
		} catch (Exception e) {
			throw new BusinessException("转换错误");
		}
		
		return bo;
	}
	@SuppressWarnings("unchecked")
	public static List<PubExpenSettlementSub> dtoToSub(Map<String, Object> paramMap,PubExpenSettlement pubExpenSettlement){
		List<PubExpenSettlementSub> bo=null;
		try {
			List<Map<String, Object>> list = (List<Map<String, Object>>)paramMap.get("overdueFeeList");
			if (list!=null && list.size()>0) {
				bo = new ArrayList<PubExpenSettlementSub>();
				for (Map<String, Object> map:list) {
					PubExpenSettlementSub pub = new PubExpenSettlementSub();
					pub.setPkId(UUIDUtils.generate());
					pub.setOverdueAmount(StringUtils.isEmpty(String.valueOf(map.get("overdueAmount")))?new BigDecimal(0):new BigDecimal(String.valueOf(map.get("overdueAmount"))));
					pub.setOverdueFee(StringUtils.isEmpty(String.valueOf(map.get("overdueFee")))?new BigDecimal(0):new BigDecimal(String.valueOf(map.get("overdueFee"))));
					pub.setOverdueRate(StringUtils.isEmpty(String.valueOf(map.get("overdueRate")))?new BigDecimal(0):new BigDecimal(String.valueOf(map.get("overdueRate"))));
					pub.setOverdueStage(String.valueOf(map.get("overdueStage")));
					pub.setUuid(pubExpenSettlement.getOverdueFeeList());
					bo.add(pub);
				}
			}
			
		} catch (Exception e) {
			throw new BusinessException("转换错误！");
		}
		
		return bo;
	}
	
}
