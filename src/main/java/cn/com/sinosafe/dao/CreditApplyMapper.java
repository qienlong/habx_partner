package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.CreditApply;

public interface CreditApplyMapper {
    int insert(CreditApply record);

    int insertSelective(CreditApply record);
}