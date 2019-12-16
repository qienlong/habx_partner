package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PartnerBusiImportList;

public interface PartnerBusiImportListMapper {
    int deleteByPrimaryKey(String batchNo);

    int insert(PartnerBusiImportList record);

    int insertSelective(PartnerBusiImportList record);

    PartnerBusiImportList selectByPrimaryKey(String batchNo);

    int updateByPrimaryKeySelective(PartnerBusiImportList record);

    int updateByPrimaryKey(PartnerBusiImportList record);

	PartnerBusiImportList selectByContNo(String contNo);
}