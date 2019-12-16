package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.IqpMeInsuranceInfo;

public interface IqpMeInsuranceInfoMapper {
    int deleteByPrimaryKey(String insuranceId);

    int insert(IqpMeInsuranceInfo record);

    int insertSelective(IqpMeInsuranceInfo record);

    IqpMeInsuranceInfo selectByPrimaryKey(String insuranceId);

    int updateByPrimaryKeySelective(IqpMeInsuranceInfo record);

    int updateByPrimaryKey(IqpMeInsuranceInfo record);
    
    int updateByPrimarySerno(IqpMeInsuranceInfo record);

}