package cn.com.sinosafe.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface QueryIqpTemplateDetailMapper {
	
    List<HashMap<String,Object>> queryIqpTemplateDetailMapper(@Param("serno")String serno);

	
}