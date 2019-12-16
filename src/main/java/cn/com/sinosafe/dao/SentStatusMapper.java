package cn.com.sinosafe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.sinosafe.domain.entity.SentStatus;

public interface SentStatusMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insert(SentStatus record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insertSelective(SentStatus record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    SentStatus selectByPrimaryKey(SentStatus record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKeySelective(SentStatus record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKey(SentStatus record);
    
	/**
	 * 批量插入已处理退保数据
	 * @param cancellationList
	 */
	void insertAll(List<Map<String, String>> cancellationList);
	
	
	int updateBySernoAndType(Map<String,Object> hashMap);
}