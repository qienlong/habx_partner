package cn.com.sinosafe.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.IqpMeChannelPrd;

public interface IqpMeChannelPrdMapper {
    int deleteByPrimaryKey(String jrnNo);

    int insert(IqpMeChannelPrd record);

    int insertSelective(IqpMeChannelPrd record);

    IqpMeChannelPrd selectByPrimaryKey(String jrnNo);

    int updateByPrimaryKeySelective(IqpMeChannelPrd record);

    int updateByPrimaryKey(IqpMeChannelPrd record);
    
    IqpMeChannelPrd selectByCopNoAndPrd(@Param("copNo")String copNo,@Param("prdId")String prdId);

	IqpMeChannelPrd selectByFields(@Param("copNo")String copNo, @Param("prdId")String productCode, @Param("partnerNo")String partnerNo);
}