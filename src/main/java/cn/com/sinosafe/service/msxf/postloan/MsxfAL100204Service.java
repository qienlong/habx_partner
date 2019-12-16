package cn.com.sinosafe.service.msxf.postloan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.domain.msxf.MsxfMqMsg;
import cn.com.sinosafe.service.msxf.MsxfService;
import cn.com.sinosafe.service.msxf.common.MsxfAccFeePsNoteService;
import cn.com.sinosafe.service.msxf.common.MsxfAccMtdPlanService;
import cn.com.sinosafe.service.msxf.common.MsxfAccMtdPsNoteService;

/**
 * 
 * 借据逾期状态处理 <br>
 * @Author : ex-tangzhenzhen001 <br>
 * @Date : 2019年9月23日<br>
 */
@Service(MsxfConstant.MSXF_AL100204)
public class MsxfAL100204Service implements MsxfService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MsxfAccMtdPlanService msxfAccMtdPlanService;
	@Autowired
	private MsxfAccMtdPsNoteService msxfAccMtdPsNoteService;
	@Autowired
	private MsxfAccFeePsNoteService msxfAccFeePsNoteService;

	/**
	 * 1 逾期
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		
		logger.info("{}借据逾期状态处理开始",MsxfConstant.MSXF_AL100204);
		
		MsxfMqMsg msxfMqMsg = JSON.parseObject(param, MsxfMqMsg.class);
		MsxfAccLoanInfo msxfAccLoanInfo = JSON.parseObject(msxfMqMsg.getData(), MsxfAccLoanInfo.class);
		
		//1、还款计划 更新应还
		msxfAccMtdPlanService.doAccMtdPlan(msxfAccLoanInfo,false,false,null);
		
		//2、 处理保费明细
		msxfAccFeePsNoteService.doFeeRepayDetails(msxfAccLoanInfo);
		
		//3、 处理还款明细
		msxfAccMtdPsNoteService.doAccMtdPsNote(msxfAccLoanInfo);

		logger.info("{}借据逾期状态处理结束",MsxfConstant.MSXF_AL100204);
		return  MsxfResponse.CODE_0000;
	}


}
