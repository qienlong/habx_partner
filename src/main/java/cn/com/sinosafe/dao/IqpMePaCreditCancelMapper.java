package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.IqpMePaCreditCancel;

public interface IqpMePaCreditCancelMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(IqpMePaCreditCancel record);

    int insertSelective(IqpMePaCreditCancel record);

    IqpMePaCreditCancel selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(IqpMePaCreditCancel record);

    int updateByPrimaryKey(IqpMePaCreditCancel record);
}