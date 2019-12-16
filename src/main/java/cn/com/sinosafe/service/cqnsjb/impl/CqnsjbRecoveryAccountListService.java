/**
 * 
 */
package cn.com.sinosafe.service.cqnsjb.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.CqnsjbZcAccountListMapper;
import cn.com.sinosafe.domain.entity.CqnsjbZcAccountList;
import cn.com.sinosafe.service.cqnsjb.CqnsjbService;

/**
 * @description 重庆农商行借呗 -- 追偿结算单
 * @author fengxiaoyu
 * @date 2019-07-11
 *
 */
@Service("recoveryAccountList")
public class CqnsjbRecoveryAccountListService extends CqnsjbService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CqnsjbZcAccountListMapper cqnsjbZcAccountListMapper;

	@Override
	public String busiDeal(String param) throws Exception {
		logger.info("==============重庆农商借呗，追偿结算单开始");
		//计算追偿金额
		List<CqnsjbZcAccountList> zcAccountList = cqnsjbZcAccountListMapper.caleZcAccountList();
		
		//插入追偿结算单中
		if(StringUtils.isNotEmpty(zcAccountList)){
			for(CqnsjbZcAccountList accountList :zcAccountList){
				logger.info("追偿结算单 计算的追偿金额为："+accountList.getRecoveryAmount());
				//查询是否存在
				CqnsjbZcAccountList zcAccount = cqnsjbZcAccountListMapper.selectByPrimaryKey(accountList.getAccountMonth());
				//存在就更新，否则插入
				if(null != zcAccount){
					cqnsjbZcAccountListMapper.updateByPrimaryKeySelective(accountList);
					logger.info("==============重庆农商借呗，追偿结算单更新成功");
				}else{
					accountList.setStatus("0");
					cqnsjbZcAccountListMapper.insert(accountList);
					logger.info("==============重庆农商借呗，追偿结算单插入成功");
				}
			}
		}
		logger.info("==============重庆农商借呗，追偿结算单结束");
		return null;
	}
}
