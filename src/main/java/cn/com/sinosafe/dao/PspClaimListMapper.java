package cn.com.sinosafe.dao;

import java.math.BigDecimal;
import java.util.Map;

import cn.com.sinosafe.domain.entity.PspClaimList;

public interface PspClaimListMapper {
    int deleteByPrimaryKey(PspClaimList key);

    int insert(PspClaimList record);

    int insertSelective(PspClaimList record);

    PspClaimList selectByPrimaryKey(PspClaimList key);

    int updateByPrimaryKeySelective(PspClaimList record);

    int updateByPrimaryKey(PspClaimList record);
    
    Map<String, BigDecimal> getAllClaimAmt(String billNo);
    
    Map<String, BigDecimal> getFailClaimAmt(String billNo);
}