package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.AccImportRecords;

public interface AccImportRecordsDao {
	
    int insert(AccImportRecords record);

    int insertSelective(AccImportRecords record);
}