package cn.com.sinosafe.dao;

import java.util.Map;

import cn.com.sinosafe.domain.entity.CopFileBatchDeal;

public interface CopFileBatchDealMapper {
    int deleteByPrimaryKey(String copName);

    int insert(CopFileBatchDeal record);

    int insertSelective(CopFileBatchDeal record);

    CopFileBatchDeal selectByPrimaryKey(String copName);

    int updateByPrimaryKeySelective(CopFileBatchDeal record);

    int updateByPrimaryKey(CopFileBatchDeal record);
    
    String selectBusiDate(String copName);
    
    int updateCopfiledateByCopname(Map<String, String> map);
}