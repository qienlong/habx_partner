/**
 * 
 */
package cn.com.sinosafe.service.cqnsjb.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.dao.CqnsjbBfAccountListMapper;
import cn.com.sinosafe.domain.entity.CqnsjbBfAccountList;
import cn.com.sinosafe.service.cqnsjb.CqnsjbService;

/**
 * @description 重庆农商行借呗 -- 保费结算单
 * @author fengxiaoyu
 * @date 2019-07-12
 *
 */
@Service("insuranAccountList")
public class CqnsjbInsuranAccountListService extends CqnsjbService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CqnsjbBfAccountListMapper  cqnsjbBfAccountListMapper;
	
	@Override
	public String busiDeal(String param) throws Exception {
		logger.info("==============重庆农商借呗，保费结算单开始");
		//查询保费结算单列表数据
		List<CqnsjbBfAccountList> bfAccountList = cqnsjbBfAccountListMapper.caleBfAccountList();
		
		//查询明细数据
		List<Map<String,Object>> recePremAmountList = cqnsjbBfAccountListMapper.queryDetailInfo();
		
		//插入保费结算单中
		if(null != bfAccountList && bfAccountList.size() >0){
			logger.info("保费结算单 计算的保费金额为："+bfAccountList.toString());
			for(CqnsjbBfAccountList accountList :bfAccountList){
				accountList.setInsureAmount(new BigDecimal("0.00"));
				for(Map<String,Object> map:recePremAmountList){
					if(accountList.getAccountMonth().equals(Convert.toStr(map.get("ACCOUNT_MONTH")))){
						accountList.setInsureAmount(Convert.toBigDecimal(map.get("ACCRUED_INT_AMT")).add(accountList.getInsureAmount()));
					}
				}
				
				//查询是否存在
				int bfAccount = cqnsjbBfAccountListMapper.selectByPrimaryKey(accountList.getAccountMonth());
				//存在就更新，否则插入
				if(bfAccount >0){
					cqnsjbBfAccountListMapper.updateByPrimaryKeySelective(accountList);
				}else{
					accountList.setInsureInt(new BigDecimal("0.2"));
					accountList.setStatus("0");
					cqnsjbBfAccountListMapper.insert(accountList);
				}
			}
		}
		logger.info("==============重庆农商借呗，保费结算单结束");
		return null;
	}
}
