package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PrdBasicinfo;

public interface PrdBasicinfoMapper {
    int deleteByPrimaryKey(String prdPk);

    int insert(PrdBasicinfo record);

    int insertSelective(PrdBasicinfo record);

    PrdBasicinfo selectByPrimaryKey(String prdPk);

    int updateByPrimaryKeySelective(PrdBasicinfo record);

    int updateByPrimaryKey(PrdBasicinfo record);

    PrdBasicinfo selectByPrdId(String prdId);
}