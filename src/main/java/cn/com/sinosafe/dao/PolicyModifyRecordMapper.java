package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PolicyModifyRecord;


public interface PolicyModifyRecordMapper {
    int deleteByPrimaryKey(String pmrSerno);

    int insertSelective(PolicyModifyRecord record);

    PolicyModifyRecord selectByPrimaryKey(String pmrSerno);

    int updateByPrimaryKeySelective(PolicyModifyRecord record);

    PolicyModifyRecord querySurrend(String listSerno);

}