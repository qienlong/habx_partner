package cn.com.sinosafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.MsxfFeeRepayDetails;

public interface MsxfFeeRepayDetailsMapper {
    int deleteByPrimaryKey(String bfId);

    int insert(MsxfFeeRepayDetails record);

    int insertSelective(MsxfFeeRepayDetails record);

    MsxfFeeRepayDetails selectByPrimaryKey(String bfId);

    int updateByPrimaryKeySelective(MsxfFeeRepayDetails record);

    int updateByPrimaryKey(MsxfFeeRepayDetails record);

	void insertAll(List<MsxfFeeRepayDetails> list);

	List<MsxfFeeRepayDetails> selectByContNoAndDate(@Param("contrNbr")String contrNbr, @Param("businessDate")String businessDate, @Param("syncStatus")String syncStatus);

   // List<MsxfFeeRepayDetails> selectByDate(String beforeDate);

    List<Map<String, String>>selectByDate(String beforeDate);
}