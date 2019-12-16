package cn.com.sinosafe.dao;

import java.util.List;

import cn.com.sinosafe.domain.entity.CqnsjbZcAccountList;

public interface CqnsjbZcAccountListMapper {
    int deleteByPrimaryKey(String accountMonth);

    int insert(CqnsjbZcAccountList record);

    int insertSelective(CqnsjbZcAccountList record);

    CqnsjbZcAccountList selectByPrimaryKey(String accountMonth);

    int updateByPrimaryKeySelective(CqnsjbZcAccountList record);

    int updateByPrimaryKey(CqnsjbZcAccountList record);
    
    List<CqnsjbZcAccountList> caleZcAccountList(); 
    
}