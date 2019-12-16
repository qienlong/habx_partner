package cn.com.sinosafe.service.msxf.common;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.AccFeeMtdPlanMapper;
import cn.com.sinosafe.domain.entity.AccFeeMtdPlan;
import cn.com.sinosafe.domain.entity.AccMtdPlan;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.service.msxf.MsxfAsynDealService;

/**
 * 
 * 马上消费-保费计划操作服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月23日<br>
 */
@Service
public class MsxfAccFeeMtdPlanService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AccFeeMtdPlanMapper accFeeMtdPlanMapper;
	@Autowired
	private MsxfAsynDealService msxfAsynDealService;

	/**
	 * 处理保费计划  更新保费计划应还日（未到期计划删掉），批改保单保费、保费计划、保单止期
	 * @param msxfAccLoanInfo
	 * @param accMtdPlans
	 * @param needDelete 是否需要删除保费计划
	 * @param maxPerdNo 改期后面的计划删除
	 * @param feeFlag 1退保 2批改
	 * @throws Exception 
	 */
	public void doAccFeePlan(MsxfAccLoanInfo msxfAccLoanInfo,List<AccMtdPlan> accMtdPlans,boolean needDelete, Short maxPerdNo,String feeFlag) throws Exception {
		
		logger.info("处理保费计划开始：{}",msxfAccLoanInfo.getBillNo());
		
		// 更新保费计划应还日
		if(StringUtils.isNotEmpty(accMtdPlans)) {
			for (AccMtdPlan accMtdPlan : accMtdPlans) {
				AccFeeMtdPlan accFeeMtdPlan = new AccFeeMtdPlan();
				accFeeMtdPlan.setLstSerno(msxfAccLoanInfo.getSerno());
				accFeeMtdPlan.setPsPerdNo(accMtdPlan.getPsPerdNo());
				accFeeMtdPlan.setPsDueDt(accMtdPlan.getPsDueDt());//还款日期
				accFeeMtdPlan.setUpdateDate(DateUtils.getDate());
				// 更新保费计划应还日
				accFeeMtdPlanMapper.updateByPrimaryKeySelective(accFeeMtdPlan);
			}
		}
		
		// 删除当期保费计划（不含本期）之后所有保费计划
		if(needDelete) {
			logger.info("删除当期保费计划（不含本期）之后所有保费计划开始：{}，期次号：{}",msxfAccLoanInfo.getBillNo(),maxPerdNo);
			AccFeeMtdPlan accFeeMtdPlan = new AccFeeMtdPlan();
			accFeeMtdPlan.setLstSerno(msxfAccLoanInfo.getSerno());
			accFeeMtdPlan.setPsPerdNo(maxPerdNo);
			accFeeMtdPlanMapper.deleteAllByPrimaryKey(accFeeMtdPlan);
		}
		
		if(StringUtils.equals("1", feeFlag)) {
			
			logger.info("退保开始：{}",msxfAccLoanInfo.getBillNo());
			
			// 获取最新保费计划应还总和
			BigDecimal fee = accFeeMtdPlanMapper.selectTotalFeeByPlanLstSerno(msxfAccLoanInfo.getSerno());
			// 异步退保
			msxfAsynDealService.settleLst(msxfAccLoanInfo.getListSerno(), fee);
			
			logger.info("退保完成：{}",msxfAccLoanInfo.getBillNo());
			
		}else if(StringUtils.equals("2", feeFlag)) {
			logger.info("批改开始：{}",msxfAccLoanInfo.getBillNo());
			//批改保单保费、保费计划、保单止期 TODO
		}
		
	}
}
