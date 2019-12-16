package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.AccImportRecords;

public interface AccImportRecordsMapper {
	
    int insert(AccImportRecords record);

    int insertSelective(AccImportRecords record);
}