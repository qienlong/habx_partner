package cn.com.sinosafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.LstSettleInfo;

/**
 * 
 * 保单提前结清退保记录表 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年10月23日<br>
 */
public interface LstSettleInfoMapper {
    int deleteByPrimaryKey(String billNo);

    int insert(LstSettleInfo record);

    int insertSelective(LstSettleInfo record);

    LstSettleInfo selectByPrimaryKey(String billNo);

    int updateByPrimaryKeySelective(LstSettleInfo record);

    int updateByPrimaryKey(LstSettleInfo record);
    
	/**
	 * 查询未处理的退保保单 sent_status 0
	 * @param msxf 
	 * @return
	 */
	List<Map<String, String>> selectBySentStatusAndSource(@Param("sources")String sources,@Param("partner")String partner);

	/**
	 * 对处理过的退保保单批量更改状态 sent_status 1
	 * @param cancellationList
	 */
	void updateAll(List<Map<String, String>> list);
}