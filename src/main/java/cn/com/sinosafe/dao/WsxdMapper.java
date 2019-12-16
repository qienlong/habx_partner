package cn.com.sinosafe.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface WsxdMapper {

	/**获取哈密合同号*/
	Map<String,Object> selectHamiContfun(@Param("serno") String serno);

}