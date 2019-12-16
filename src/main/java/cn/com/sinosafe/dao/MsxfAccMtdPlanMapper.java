package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.MsxfAccMtdPlan;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface MsxfAccMtdPlanMapper {
    int deleteByPrimaryKey(String msxfAccMtdPlanId);

    int insert(MsxfAccMtdPlan record);

    int insertSelective(MsxfAccMtdPlan record);

    MsxfAccMtdPlan selectByPrimaryKey(String msxfAccMtdPlanId);

    int updateByPrimaryKeySelective(MsxfAccMtdPlan record);

    int updateByPrimaryKey(MsxfAccMtdPlan record);

    void batchInsert(ArrayList<MsxfAccMtdPlan> accMtdPlanList);

    List<MsxfAccMtdPlan> selectByContNoAndDate(@Param("contrNbr")String contrNbr, @Param("businessDate")String businessDate, @Param("syncStatus")String syncStatus);
}