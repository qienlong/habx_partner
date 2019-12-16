package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.IqpMeApiCop;

public interface IqpMeApiCopMapper {
    int insert(IqpMeApiCop record);

    int insertSelective(IqpMeApiCop record);
    
    IqpMeApiCop selectByAccid(String accid);

    IqpMeApiCop getIqpMeApiCopByAccid(String accid);
}