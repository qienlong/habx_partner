package cn.com.sinosafe.dao;

import java.util.List;
import java.util.Map;

import cn.com.sinosafe.domain.entity.CqnsjbBfAccountList;

public interface CqnsjbBfAccountListMapper {
    int insert(CqnsjbBfAccountList record);

    int insertSelective(CqnsjbBfAccountList record);
    
    int selectByPrimaryKey(String accountMonth);
    
    List<CqnsjbBfAccountList> caleBfAccountList();
    
    int updateByPrimaryKeySelective(CqnsjbBfAccountList record);
    
    List<Map<String,Object>> queryDetailInfo();
}