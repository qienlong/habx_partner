package cn.com.sinosafe.dao;

import java.util.List;

import cn.com.sinosafe.domain.entity.CqnsjbBfAccountInfo;

public interface CqnsjbBfAccountInfoMapper {
    int insert(CqnsjbBfAccountInfo record);

    int insertSelective(CqnsjbBfAccountInfo record);

	/**
	 * @Description  根据保单编号查询保单对账明细数据
	 * @date 2019年10月16日  
	 * @param listSerno
	 * @return
	 */
	List<CqnsjbBfAccountInfo> queryBfAccountInfoByListSerno(String listSerno);
	
	/**
	 * 批量插入对账信息记录
	 * @Description
	 * @date 2019年10月17日  
	 * @param cqnsjbBfAccountInfos
	 * @return
	 */
	int insertBfAccountInfoBatch(List<CqnsjbBfAccountInfo> cqnsjbBfAccountInfos);
}