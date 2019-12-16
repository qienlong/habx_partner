package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.CopFiledate;

public interface CopFiledateMapper {
    int deleteByPrimaryKey(String copname);

    int insert(CopFiledate record);

    int insertSelective(CopFiledate record);

    CopFiledate selectByPrimaryKey(String copname);

    int updateByPrimaryKeySelective(CopFiledate record);

    int updateByPrimaryKey(CopFiledate record);
}