package cn.com.sinosafe.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.AccFeeMtdPlan;

public interface AccFeeMtdPlanMapper {
    int deleteByPrimaryKey(AccFeeMtdPlan key);

    int insert(AccFeeMtdPlan record);

    int insertSelective(AccFeeMtdPlan record);

    AccFeeMtdPlan selectByPrimaryKey(AccFeeMtdPlan key);

    int updateByPrimaryKeySelective(AccFeeMtdPlan record);

    int updateByPrimaryKey(AccFeeMtdPlan record);
    /**提前结清：删除当期后的所有保费计划*/
	int deleteAllByPrimaryKey(AccFeeMtdPlan accFeeMtdPlan);
	
	/**更新保费计划金额*/
	void updateAccFeeMtdPlanByPrimaryKey(@Param("lstSerno")String lstSerno, @Param("psPerdNo")String psPerdNo);
	
	/**更新保费计划状态*/
	void updateAccFeeMtdPlanStateByPrimaryKey(@Param("lstSerno")String lstSerno, @Param("psPerdNo")String psPerdNo);

	/**根据投保单流水号查询所有应收保费之和*/
	BigDecimal selectTotalFeeByPlanLstSerno(String lstSerno);

}