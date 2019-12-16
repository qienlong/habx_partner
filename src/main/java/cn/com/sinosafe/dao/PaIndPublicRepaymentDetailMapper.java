package cn.com.sinosafe.dao;

import java.util.List;

import cn.com.sinosafe.domain.entity.PaIndPublicRepaymentDetail;


public interface PaIndPublicRepaymentDetailMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(PaIndPublicRepaymentDetail record);

    int insertSelective(PaIndPublicRepaymentDetail record);

    PaIndPublicRepaymentDetail selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(PaIndPublicRepaymentDetail record);

    int updateByPrimaryKey(PaIndPublicRepaymentDetail record);
    
    List<PaIndPublicRepaymentDetail> selectNeedNotice();
    
    List<String> selectBatchNo();
    
    int updateByBatchNo(PaIndPublicRepaymentDetail paIndPublicRepaymentDetail);
}