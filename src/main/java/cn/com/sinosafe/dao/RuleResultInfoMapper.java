package cn.com.sinosafe.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.RuleResultInfo;

public interface RuleResultInfoMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(RuleResultInfo record);

    int insertSelective(RuleResultInfo record);

    RuleResultInfo selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(RuleResultInfo record);

    int updateByPrimaryKey(RuleResultInfo record);

	void deleteBySernoAndFlag(@Param("serno")String serno, @Param("flag")String flag);
}