package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PrjCopAcc;

import java.util.Map;

public interface PrjCopAccMapper {
    int deleteByPrimaryKey(String copNo);

    int insert(PrjCopAcc record);

    int insertSelective(PrjCopAcc record);

    PrjCopAcc selectByPrimaryKey(String copNo);

    int updateByPrimaryKeySelective(PrjCopAcc record);

    int updateByPrimaryKey(PrjCopAcc record);

    PrjCopAcc selectByCopCusName(String copCusName);

    Map<String ,String> getByPrdIdAndCopNo(Map<String ,String> map);

    Map<String ,String> getByPrdIdAndCopNoAndPartnerNo(Map<String ,String> map);
}