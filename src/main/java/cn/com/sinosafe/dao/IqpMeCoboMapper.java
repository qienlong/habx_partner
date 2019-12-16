package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.IqpMeCobo;

public interface IqpMeCoboMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(IqpMeCobo record);

    int insertSelective(IqpMeCobo record);

    IqpMeCobo selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(IqpMeCobo record);

    int updateByPrimaryKey(IqpMeCobo record);
}