package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.BatAccMtdPlan;

public interface BatAccMtdPlanMapper {

    int insert(BatAccMtdPlan record);

    int insertSelective(BatAccMtdPlan record);
}