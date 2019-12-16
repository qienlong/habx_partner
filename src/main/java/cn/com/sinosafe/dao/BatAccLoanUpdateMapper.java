package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.BatAccLoanUpdate;

public interface BatAccLoanUpdateMapper {

    int insert(BatAccLoanUpdate record);

    int insertSelective(BatAccLoanUpdate record);
}