package cn.com.sinosafe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.IqpMeErrInfo;

public interface IqpMeErrInfoMapper {
    int deleteByPrimaryKey(String pkId);

    int insert(IqpMeErrInfo record);

    int insertSelective(IqpMeErrInfo record);

    IqpMeErrInfo selectByPrimaryKey(String pkId);

    int updateByPrimaryKeySelective(IqpMeErrInfo record);

    int updateByPrimaryKey(IqpMeErrInfo record);

	void insertBatch(@Param("errInfos")List<IqpMeErrInfo> errors);

	List<IqpMeErrInfo> selectExceptions(String sentType);
}