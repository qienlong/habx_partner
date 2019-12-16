package cn.com.sinosafe.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.PrjChnPrdInfo;

public interface PrjChnPrdInfoMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(PrjChnPrdInfo record);

    int insertSelective(PrjChnPrdInfo record);

    PrjChnPrdInfo selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(PrjChnPrdInfo record);

    int updateByPrimaryKey(PrjChnPrdInfo record);
    
    PrjChnPrdInfo selectByPrjAndPrd(@Param("copNo")String copNo,@Param("prdCode")String prdCode);
}