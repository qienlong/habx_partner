package cn.com.sinosafe.dao;

import java.util.List;

import cn.com.sinosafe.domain.entity.PspClaimPaphRecode;

public interface PspClaimPaphRecodeMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(PspClaimPaphRecode record);

    int insertSelective(PspClaimPaphRecode record);

    PspClaimPaphRecode selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(PspClaimPaphRecode record);

    int updateByPrimaryKey(PspClaimPaphRecode record);
    
    List<PspClaimPaphRecode> selectNoticeRecode();
    
    List<String> selectNoticeBatchNo();
    
    int updateByBatchNo(PspClaimPaphRecode record);

}