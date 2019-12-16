package cn.com.sinosafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;

public interface MsxfAccLoanInfoMapper {
    int deleteByPrimaryKey(String dkId);

    int insert(MsxfAccLoanInfo record);

    int insertSelective(MsxfAccLoanInfo record);

    MsxfAccLoanInfo selectByPrimaryKey(String dkId);

    int updateByPrimaryKeySelective(MsxfAccLoanInfo record);

    int updateByPrimaryKey(MsxfAccLoanInfo record);
    
    void insertAll(List<MsxfAccLoanInfo> list);
    
    MsxfAccLoanInfo selectByContNoAndDate(@Param("contNo")String contNo,@Param("businessDate")String businessDate);

	List<MsxfAccLoanInfo> selectByStatusAndBusiDate(@Param("syncStatus")String syncStatus, @Param("businessDate")String filedate);
	
	List<MsxfAccLoanInfo> selectByContNoAndTxStatus(@Param("contNo")String contNo,@Param("txStatuss")String[] txStatuss);

	void updateStatusByBusiDate(String businessDate);
}