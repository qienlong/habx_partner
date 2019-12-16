package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PspClaimLoan;

public interface PspClaimLoanMapper {
    int deleteByPrimaryKey(String serno);

    int insert(PspClaimLoan record);

    int insertSelective(PspClaimLoan record);

    PspClaimLoan selectByPrimaryKey(String serno);

    int updateByPrimaryKeySelective(PspClaimLoan record);

    int updateByPrimaryKey(PspClaimLoan record);
    
    int selectByBillNo(String billNo);
}