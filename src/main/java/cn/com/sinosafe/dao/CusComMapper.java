package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.CusCom;

public interface CusComMapper {
    int deleteByPrimaryKey(String cusId);

    int insert(CusCom record);

    int insertSelective(CusCom record);

    CusCom selectByPrimaryKey(String cusId);

    int updateByPrimaryKeySelective(CusCom record);

    int updateByPrimaryKey(CusCom record);
}