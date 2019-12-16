package cn.com.sinosafe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.AccMtdPlan;
import cn.com.sinosafe.domain.entity.AccMtdPlanKey;

public interface AccMtdPlanMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int deleteByPrimaryKey(AccMtdPlanKey key);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insert(AccMtdPlan record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insertSelective(AccMtdPlan record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    AccMtdPlan selectByPrimaryKey(AccMtdPlanKey key);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKeySelective(AccMtdPlan record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKey(AccMtdPlan record);
    /**提前结清：删除当期后的所有还款计划*/
	int deleteAllByPrimaryKey(AccMtdPlan accMtdPlan);
	
	/**更新还款计划金额*/
	void updateAccMtdPlanByPrimaryKey(@Param("billNo")String billNo, @Param("psPerdNo")String psPerdNo);
	
	/**更新还款计划状态*/
	void updateAccMtdPlanStateByPrimaryKey(@Param("billNo")String billNo, @Param("psPerdNo")String psPerdNo);

	/**批量插入**/
	void insertBatch(@Param("accMtdPlans")List<AccMtdPlan> accMtdPlans);

}