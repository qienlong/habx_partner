package cn.com.sinosafe.dao;

import java.util.List;

import cn.com.sinosafe.domain.entity.IqpMePrdPrjPayway;

public interface IqpMePrdPrjPaywayMapper {
    int insert(IqpMePrdPrjPayway record);

    int insertSelective(IqpMePrdPrjPayway record);

    List<IqpMePrdPrjPayway> queryIqpMePrdPrjPaywayByBean(IqpMePrdPrjPayway record);
}