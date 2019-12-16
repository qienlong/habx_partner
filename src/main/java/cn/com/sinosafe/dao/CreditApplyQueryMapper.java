package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.CreditApplyQuery;

public interface CreditApplyQueryMapper {
    int deleteByPrimaryKey(CreditApplyQuery record);

    int insert(CreditApplyQuery record);

    int insertSelective(CreditApplyQuery record);

    CreditApplyQuery selectByPrimaryKey(CreditApplyQuery record);

    int updateByPrimaryKeySelective(CreditApplyQuery record);

    int updateByPrimaryKey(CreditApplyQuery record);
}