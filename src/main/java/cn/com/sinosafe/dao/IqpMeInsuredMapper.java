package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.IqpMeInsured;

public interface IqpMeInsuredMapper {

    int insertSelective(IqpMeInsured record);

    int updateByPrimaryKey(IqpMeInsured record);

}