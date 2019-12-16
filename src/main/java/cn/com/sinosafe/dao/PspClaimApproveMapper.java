package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PspClaimApprove;

public interface PspClaimApproveMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(PspClaimApprove record);

    int insertSelective(PspClaimApprove record);

    PspClaimApprove selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(PspClaimApprove record);

    int updateByPrimaryKey(PspClaimApprove record);
}