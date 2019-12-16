package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.BatRepayDetails;

public interface BatRepayDetailsMapper {
    int insert(BatRepayDetails record);

    int insertSelective(BatRepayDetails record);
}