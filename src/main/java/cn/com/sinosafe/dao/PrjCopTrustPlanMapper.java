package cn.com.sinosafe.dao;


import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.PrjCopTrustPlan;

public interface PrjCopTrustPlanMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(PrjCopTrustPlan record);

    int insertSelective(PrjCopTrustPlan record);

    PrjCopTrustPlan selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(PrjCopTrustPlan record);

    int updateByPrimaryKey(PrjCopTrustPlan record);
    
    PrjCopTrustPlan selectAcountByFunderId(@Param("billNo") String billNo,@Param("copNo")String copNo);
}