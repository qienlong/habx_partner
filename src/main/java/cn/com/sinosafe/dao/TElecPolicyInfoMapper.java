package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.TElecPolicyInfo;

public interface TElecPolicyInfoMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(TElecPolicyInfo record);

    int insertSelective(TElecPolicyInfo record);

    TElecPolicyInfo selectByPrimaryKey(String pkId);
    
    TElecPolicyInfo selectByPolicyNo(String policyNo);

    int updateByPrimaryKeySelective(TElecPolicyInfo record);

    int updateByPrimaryKeyWithBLOBs(TElecPolicyInfo record);

    int updateByPrimaryKey(TElecPolicyInfo record);
}