package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.TReconPaRepaymentDetail;

public interface TReconPaRepaymentDetailMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(TReconPaRepaymentDetail record);

    int insertSelective(TReconPaRepaymentDetail record);

    TReconPaRepaymentDetail selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(TReconPaRepaymentDetail record);

    int updateByPrimaryKey(TReconPaRepaymentDetail record);
    
    int updateByBatchNo(TReconPaRepaymentDetail tReconPaRepaymentDetail);
}