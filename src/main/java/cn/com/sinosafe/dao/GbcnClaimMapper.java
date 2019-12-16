package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.gbcn.request.ClaimRequest.ClaimRequestBody;

public interface GbcnClaimMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(ClaimRequestBody record);

    int insertSelective(ClaimRequestBody record);

    ClaimRequestBody selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(ClaimRequestBody record);

    int updateByPrimaryKey(ClaimRequestBody record);
}