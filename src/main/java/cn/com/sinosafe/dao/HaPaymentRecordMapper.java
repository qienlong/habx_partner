package cn.com.sinosafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.HaPaymentRecord;

public interface HaPaymentRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(HaPaymentRecord record);

    int insertSelective(HaPaymentRecord record);

    HaPaymentRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HaPaymentRecord record);

    int updateByPrimaryKey(HaPaymentRecord record);
    
    HaPaymentRecord selectPaySucRecode(@Param("billNo")String billNo,@Param("paymentAmount")String paymentAmount);
    
    List<Map<String,String>> getPaphClaimFail();
}