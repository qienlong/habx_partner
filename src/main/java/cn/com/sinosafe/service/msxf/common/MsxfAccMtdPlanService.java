package cn.com.sinosafe.service.msxf.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.AccMtdPlanMapper;
import cn.com.sinosafe.dao.MsxfAccMtdPlanMapper;
import cn.com.sinosafe.domain.entity.AccMtdPlan;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.domain.entity.MsxfAccMtdPlan;

/**
 * 
 * 马上消费-还款计划操作服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月23日<br>
 */
@Service
public class MsxfAccMtdPlanService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MsxfAccMtdPlanMapper msxfAccMtdPlanMapper;
	@Autowired
	private AccMtdPlanMapper accMtdPlanMapper;
	@Autowired
	private MsxfAccFeeMtdPlanService msxfAccFeeMtdPlanService;
	
	/**
	 * 处理计划
	 * @param msxfAccLoanInfo
	 * @param needDeletePlan 是否需要删除未到期还款计划
	 * @param needDeleteFeePlan 是否需要删除未到期保费计划
	 * @throws Exception
	 */
	public void doAccMtdPlan(MsxfAccLoanInfo msxfAccLoanInfo,boolean needDeletePlan,boolean needDeleteFeePlan,String feeFlag) throws  Exception{
		
		logger.info("处理计划开始:贷款编号：{},是否删除未到期还款计划{},是否删除未到期保费计划{}",msxfAccLoanInfo.getRefNbr(),needDeletePlan,needDeleteFeePlan);
		
		// 根据贷款编号、业务日期、同步状态（默认未处理）查询还款计划中间表
		List<MsxfAccMtdPlan> msxfAccMtdPlanList = msxfAccMtdPlanMapper.selectByContNoAndDate(msxfAccLoanInfo.getRefNbr(),msxfAccLoanInfo.getBusinessDate(),"0");
		if(StringUtils.isNotEmpty(msxfAccMtdPlanList)) {
			List<AccMtdPlan> accMtdPlans = new ArrayList<AccMtdPlan>();
			Short maxPerdNo = Convert.toShort(msxfAccMtdPlanList.get(0).getTerm());
			for (MsxfAccMtdPlan msxfAccMtdPlan: msxfAccMtdPlanList) {
				
				// 修改还款计划
				AccMtdPlan accMtdPlan = updateAccMtdPlan(msxfAccLoanInfo, msxfAccMtdPlan);
				
				// 更新同步状态
				msxfAccMtdPlan.setSyncStatus("1");
				msxfAccMtdPlanMapper.updateByPrimaryKeySelective(msxfAccMtdPlan);
				
				accMtdPlans.add(accMtdPlan);
			}
			
			// 删除最大期次后的还款计划
			if(needDeletePlan) {
				AccMtdPlan plan = new AccMtdPlan();
				plan.setBillNo(msxfAccLoanInfo.getBillNo());
				plan.setPsPerdNo(maxPerdNo);
				accMtdPlanMapper.deleteAllByPrimaryKey(plan);
			}
			
			// 处理保费计划
			if(needDeleteFeePlan) {
				msxfAccFeeMtdPlanService.doAccFeePlan(msxfAccLoanInfo, accMtdPlans, needDeleteFeePlan,maxPerdNo,feeFlag);
			}
			
		}else {
			logger.info("贷款编号：{}，业务日期：{}没有还款计划数据处理",msxfAccLoanInfo.getRefNbr(),msxfAccLoanInfo.getBusinessDate());
		}
		
		logger.info("处理计划结束:贷款编号：{},是否删除未到期还款计划{},是否删除未到期保费计划{}",msxfAccLoanInfo.getRefNbr(),needDeletePlan,needDeleteFeePlan);
	}

	public AccMtdPlan updateAccMtdPlan(MsxfAccLoanInfo msxfAccLoanInfo, MsxfAccMtdPlan msxfAccMtdPlan) {
		AccMtdPlan accMtdPlan = new AccMtdPlan();
		accMtdPlan.setBillNo(msxfAccLoanInfo.getBillNo());
		accMtdPlan.setPsPerdNo(Convert.toShort(msxfAccMtdPlan.getTerm()));
		accMtdPlan.setPsDueDt(DateUtils.formatDate1(msxfAccMtdPlan.getStmtDate()));//还款日期
		accMtdPlan.setPsPrcpAmt(msxfAccMtdPlan.getPrincipal());//应还本金
		accMtdPlan.setPsNormIntAmt(msxfAccMtdPlan.getInterest()); //应还利息
		accMtdPlan.setPsOdIntAmt(msxfAccMtdPlan.getPenaltyDue()); // 应还罚息
		accMtdPlan.setUpdateDate(DateUtils.getDate());
		accMtdPlan.setUpdateId(MsxfConstant.MSXF_SYSTEM);
		accMtdPlan.setUpdateBrId(MsxfConstant.MSXF_ORG);
		// 更新正式还款计划
		accMtdPlanMapper.updateByPrimaryKeySelective(accMtdPlan);
		return accMtdPlan;
	}
}
