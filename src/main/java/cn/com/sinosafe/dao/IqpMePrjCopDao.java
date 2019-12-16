package cn.com.sinosafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.com.sinosafe.domain.entity.IqpMePrjCop;


public interface IqpMePrjCopDao {
    int deleteByPrimaryKey(IqpMePrjCop key);

    int insert(IqpMePrjCop record);

    int insertSelective(IqpMePrjCop record);

    IqpMePrjCop selectByPrimaryKey(IqpMePrjCop key);

    int updateByPrimaryKeySelective(IqpMePrjCop record);

    int updateByPrimaryKey(IqpMePrjCop record);

	List<IqpMePrjCop> queryIqpMePrjCopBySerno(String serno);
	
	int insertIqpMePrjCop(@Param("iqpMePrjCops")List<IqpMePrjCop> iqpMePrjCopList);

	int insertIqpMePrjCopBySerno(Map<String, String> map);
}