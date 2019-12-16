package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PaIndCrtRepayDetail;

public interface PaIndCrtRepayDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(PaIndCrtRepayDetail record);

    int insertSelective(PaIndCrtRepayDetail record);

    PaIndCrtRepayDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PaIndCrtRepayDetail record);

    int updateByPrimaryKey(PaIndCrtRepayDetail record);
}