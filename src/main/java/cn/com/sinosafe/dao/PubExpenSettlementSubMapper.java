package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PubExpenSettlementSub;

public interface PubExpenSettlementSubMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(PubExpenSettlementSub record);

    int insertSelective(PubExpenSettlementSub record);

    PubExpenSettlementSub selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(PubExpenSettlementSub record);

    int updateByPrimaryKey(PubExpenSettlementSub record);
}