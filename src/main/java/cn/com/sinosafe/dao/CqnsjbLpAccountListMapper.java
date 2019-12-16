package cn.com.sinosafe.dao;

import java.util.List;

import cn.com.sinosafe.domain.entity.CqnsjbLpAccountList;


public interface CqnsjbLpAccountListMapper {
    int insert(CqnsjbLpAccountList record);

    int insertSelective(CqnsjbLpAccountList record);
    
    int  queryLpAccountList(CqnsjbLpAccountList record);
    
    List<CqnsjbLpAccountList> caleLpAccountList(); 
    
    int updateLpAccountList(CqnsjbLpAccountList record);
}