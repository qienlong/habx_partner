package cn.com.sinosafe.dao;

import java.util.List;
import java.util.Map;

import cn.com.sinosafe.domain.entity.PspClaimApproveRecode;

public interface PspClaimApproveRecodeMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(PspClaimApproveRecode record);

    int insertSelective(PspClaimApproveRecode record);

    PspClaimApproveRecode selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(PspClaimApproveRecode record);

    int updateByPrimaryKey(PspClaimApproveRecode record);
    
    List<Map<String, Object>> getPaphData();
}