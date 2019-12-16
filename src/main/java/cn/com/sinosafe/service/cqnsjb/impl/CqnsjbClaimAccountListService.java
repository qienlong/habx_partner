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
import cn.com.sinosafe.dao.CqnsjbLpAccountListMapper;
import cn.com.sinosafe.domain.entity.CqnsjbLpAccountList;
import cn.com.sinosafe.service.cqnsjb.CqnsjbService;

/**
 * @description 重庆农商行借呗 -- 理赔结算单
 * @author fengxiaoyu
 * @date 2019-07-09
 *
 */
@Service("claimAccountList")
public class CqnsjbClaimAccountListService extends CqnsjbService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CqnsjbLpAccountListMapper cqnsjbLpAccountListMapper;

	@Override
	public String busiDeal(String param) throws Exception {
		logger.info("==========重庆农商借呗，理赔结算单开始");
		//计算理赔金额
		List<CqnsjbLpAccountList> lpAccountList = cqnsjbLpAccountListMapper.caleLpAccountList();
		
		//插入理赔结算单中
		if(StringUtils.isNotEmpty(lpAccountList)){
			for(CqnsjbLpAccountList accountList :lpAccountList){
				logger.info("理赔结算单 计算的理赔金额为："+accountList.getClaimAmount());
				//查询是否存在
				int count = cqnsjbLpAccountListMapper.queryLpAccountList(accountList);
				//存在就更新，否则插入
				if(count > 0){
					cqnsjbLpAccountListMapper.updateLpAccountList(accountList);
					logger.info("==========重庆农商借呗，理赔结算单更新成功");
				}else{
					accountList.setStatus("1");
					cqnsjbLpAccountListMapper.insert(accountList);
					logger.info("==========重庆农商借呗，理赔结算单插入成功");
				}
			}
		}
		logger.info("==========重庆农商借呗，理赔结算单结束");
		return null;
	}
}
