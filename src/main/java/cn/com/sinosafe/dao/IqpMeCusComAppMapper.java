package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.IqpMeCusComApp;

public interface IqpMeCusComAppMapper {
    int insert(IqpMeCusComApp record);

    int insertSelective(IqpMeCusComApp record);
}