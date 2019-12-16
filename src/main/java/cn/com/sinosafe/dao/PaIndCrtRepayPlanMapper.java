package cn.com.sinosafe.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import cn.com.sinosafe.domain.entity.PaIndCrtRepayPlan;


@Repository
public interface PaIndCrtRepayPlanMapper {
   
    
    /**数据落入中间表(Pa_Ind_Crt_Repay_Plan)*/
	int mergeIntoPaIndCrtRepayPlan(@Param("PaIndCrtRepayPlanLists") List<PaIndCrtRepayPlan> record);

	/**针对提前还款、代偿还款，还款计划会有合并情况:同步本次数据前有必要删除之前已同步借据的还款计划数据(根据借据号去做删除)*/
	void deleteOldRepayPlanInfo(@Param("specialRepayPlanLists") List<PaIndCrtRepayPlan> record);

	/**数据从中间表到实际还款计划表(ACC_MTD_PLAN)*/
	void mergeRepayPlanInfo(@Param("date") String date);

	/**补录实际还款日期(ACC_MTD_PLAN.PS_REAL_DT)*/
	void mergePsRealDt(@Param("date") String date);

	/**还款记录信息(ACC_MTD_PS_NOTE)*/
	void mergeRepayRecord(@Param("date") String date);

	/**更新数据同步状态*/
	int updateSynStatus(@Param("date") String date);

	/**根据还款计划生成保费计划*/
	void cerateInsuranceRepayPlan(@Param("date") String date);

	/**保费分期基础信息表*/
	void cerateInsuranceBaseInfo(@Param("date") String date);

	/** 根据代偿还款计划更新实际计划ACC_MTD_PLAN*/
	void updateRepayPlanInfo(@Param("date") String date);

	/** 根据代偿还款计划更新保费计划acc_fee_mtd_plan*/
	void updateAccFeeMtdPlan(@Param("date") String date);

	/**删除 还款计划 （代偿）*/
	void deleteOldRepayPlanInfoByBillnoAndPeiod(@Param("billNo") String billNo, @Param("period") String period);

	/**删除 保费计划 （代偿）*/
	void deleteOldaccFeeMtdPlan(@Param("billNo") String billNo, @Param("period") String period);
	
	int deleteByPrimaryKey(String id);

    int insert(PaIndCrtRepayPlan record);

    int insertSelective(PaIndCrtRepayPlan record);

    PaIndCrtRepayPlan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PaIndCrtRepayPlan record);

    int updateByPrimaryKey(PaIndCrtRepayPlan record);
    
    List<PaIndCrtRepayPlan> getBatchOutData();
    
    BigDecimal getXbTotalAmt(String serno);
    
    BigDecimal getSfTotalAmt(String serno);
    
    String getMaxPerdNo(String serno);
    
    String getMinPerno(String serno);
}