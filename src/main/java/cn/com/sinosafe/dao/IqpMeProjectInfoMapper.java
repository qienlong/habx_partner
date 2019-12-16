package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.IqpMeProjectInfo;


public interface IqpMeProjectInfoMapper {
    int deleteByPrimaryKey(String projectId);

    int insertSelective(IqpMeProjectInfo record);

    IqpMeProjectInfo selectByPrimaryKey(String projectId);

    int updateByPrimaryKeySelective(IqpMeProjectInfo record);

    IqpMeProjectInfo selectByIqpSerno(String iqpSerno);
}