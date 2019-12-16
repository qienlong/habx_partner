/**   
* @Title:：PaCostSettlementServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 上午11:49:20 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.config.constant.PaCostSettlementConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.PubExpenSettlementMapper;
import cn.com.sinosafe.dao.PubExpenSettlementSubMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.dto.PaCostSettlementDto;
import cn.com.sinosafe.domain.entity.PubExpenSettlement;
import cn.com.sinosafe.domain.entity.PubExpenSettlementSub;
import cn.com.sinosafe.service.padb.PaCostSettlementService;

import com.alibaba.fastjson.JSON;

/** 
 * @ClassName:：PaCostSettlementServiceImpl 
 * @Description： 对公费用结算接口（供平安调用）
 * @author ：xiewei
 * @date ：2019年6月8日 上午11:49:20  
 */
@Service
public class PaCostSettlementServiceImpl implements PaCostSettlementService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PubExpenSettlementMapper pubExpenSettlementMapper;
	@Autowired
	private PubExpenSettlementSubMapper pubExpenSettlementSubMapper;

	/* 
	 * @see cn.com.sinosafe.service.padb.PaCostSettlementService#infoSync()
	 */
	@Override
	public String infoSync(Map<String, Object> paramMap) throws Exception{
		logger.info("*****************************对公费用结算接口 start*****************************");
		logger.info("param:{}",paramMap);
		String resultCode=null;
		String resultMsg=null;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			//校验字段
			if(LstIqpApplyConstant.checkFieldDefect(paramMap, new String[]{"accountMonth","singlefeedate"})){
				resultCode=PaResultCode.PA_FIELD_DELETION.code();
				resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE);
			}else{
				try {
					//校验成功,转换对象接受类
					//PaCostSettlementDto dto=PaCostSettlementConstant.mapConvertDto(paramMap);
					//接受类转数据持久类
					PubExpenSettlement bo=PaCostSettlementConstant.dtoToBo(paramMap);
					//接受类转数据持久类
					List<PubExpenSettlementSub> sub=PaCostSettlementConstant.dtoToSub(paramMap,bo);
					//新增数据
					pubExpenSettlementMapper.insertSelective(bo);
					
					if (!StringUtils.isNull(sub)&&sub.size()>0) {
						for (PubExpenSettlementSub pubExpenSettlementSub:sub) {
							pubExpenSettlementSubMapper.insertSelective(pubExpenSettlementSub);
						}
					}
					/*//数据是否已存在
					int i = pubExpenSettlementMapper.selectCountByMonth(bo);
					if (i>0) {
						logger.error("errorInfo:{}","数据重复");
						throw new BusinessException("数据重复");
					} else {
					}*/
				} catch (Exception e) {
					throw new BusinessException(e.getMessage());
				}
				resultCode=PaResultCode.PA_SUCCESS.code();
				resultMsg=PaResultGenerator.DEFAULT_SUCCESS_MESSAGE;
			}
		} catch (Exception e) {
			logger.error("errorInfo:{}",e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		resultMap.put("resultCode",String.valueOf(resultCode));
		resultMap.put("resultMsg",String.valueOf(resultMsg));
		logger.info("*****************************对公费用结算接口 end*****************************");
		return JSON.toJSONString(resultMap);
	}

}
