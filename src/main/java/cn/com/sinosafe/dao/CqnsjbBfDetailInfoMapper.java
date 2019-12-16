package cn.com.sinosafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.CqnsjbBfDetailInfo;

public interface CqnsjbBfDetailInfoMapper {
    int insert(CqnsjbBfDetailInfo record);

    int insertSelective(CqnsjbBfDetailInfo record);
    
    List<Map<String, String>> queryInsuranceInfo();
    
    List<String> queryDetailInfo(String psRealDat);
    /**
     * 删除当月所有的保单明细数据
     * @Description
     * @date 2019年10月16日  
     * @param month
     * @return
     */
    int deleteDetailInfoByMonth(String month);
    /**
     * 批量插入明细数据
     * @Description
     * @date 2019年10月16日  
     * @param cqnsjbBfDetailInfos
     * @return
     */
    int insertBatchDetailInfo(@Param("cqnsjbBfDetailInfos") List<CqnsjbBfDetailInfo> cqnsjbBfDetailInfos);

	/**
	 * @Description 查询业务归属部门代码(10位出单机构代码)
	 * @date 2019年10月16日  
	 * @param cqrcbjb
	 * @return
	 */
	String querySOrgInfo(String accid);
}