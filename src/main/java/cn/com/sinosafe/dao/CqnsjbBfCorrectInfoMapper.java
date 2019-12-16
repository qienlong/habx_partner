package cn.com.sinosafe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.CqnsjbBfCorrectInfo;

public interface CqnsjbBfCorrectInfoMapper {
    int deleteByPrimaryKey(String serno);

    int insert(CqnsjbBfCorrectInfo record);

    int insertSelective(CqnsjbBfCorrectInfo record);

    CqnsjbBfCorrectInfo selectByPrimaryKey(String serno);

    int updateByPrimaryKeySelective(CqnsjbBfCorrectInfo record);

    int updateByPrimaryKey(CqnsjbBfCorrectInfo record);
    
    int insertBatch(@Param("correctInfoList")List<CqnsjbBfCorrectInfo> correctInfoList);
    
    CqnsjbBfCorrectInfo selectByListserno(CqnsjbBfCorrectInfo record);
    
    /**
     * 计算出第1个月到i-1个月的每笔保单的保费
     * @Description
     * @date 2019年9月26日  
     * @return
     */
    List<Map<String, Object>>  queryCorrectPremAmount(String currentDay);
    /**
     * 计算当前月的每笔保单的保费，（范围为：当月1号到保险止期-2天）
     * @Description
     * @date 2019年11月6日  
     * @param monthFirstDay
     * @return
     */
    List<Map<String, Object>>  queryCurrentMonthPremAmount(@Param("monthFirstDay") String monthFirstDay,@Param("monthlastDay") String monthlastDay);

    /**
     * 根据保单、日期查询应计利息,日期范围是当月1号到计算日期
     * @param mapParams
     * @return
     */
	Map<String, Object> queryBillAccruedInterestByListSerno(Map<String, String> mapParams);

	/**
	 * 根据借据号查询应还利息
	 * @Description
	 * @date 2019年11月5日  
	 * @param map
	 * @return
	 */
	Map<String, Object> queryPsNormIntAmtByBill(Map<String, String> map);
	
	/**
	 * 查询当月所有的实还
	 * @Description
	 * @date 2019年11月7日  
	 * @return
	 */
	List<Map<String,Object>> queryCurrentMontRealIntAmt(String currentMonth);
}