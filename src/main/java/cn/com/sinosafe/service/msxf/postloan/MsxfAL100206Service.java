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
import cn.com.sinosafe.service.msxf.MsxfAsynDealService;
import cn.com.sinosafe.service.msxf.MsxfService;
import cn.com.sinosafe.service.msxf.common.MsxfAccFeePsNoteService;
import cn.com.sinosafe.service.msxf.common.MsxfAccMtdPlanService;
import cn.com.sinosafe.service.msxf.common.MsxfAccMtdPsNoteService;

/**
 * 
 * 正常终止或逾期终止状态处理 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月24日<br>
 */
@Service(MsxfConstant.MSXF_AL100206)
public class MsxfAL100206Service implements MsxfService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MsxfAccMtdPlanService msxfAccMtdPlanService;
	@Autowired
	private MsxfAccMtdPsNoteService msxfAccMtdPsNoteService;
	@Autowired
	private MsxfAccFeePsNoteService msxfAccFeePsNoteService;
	@Autowired
	private MsxfAsynDealService msxfAsynDealService;

	/**
	 * 正常终止、逾期终止：
	 1、处理还款计划  更新计划应还和应还日（未到期计划删掉）
	 2、处理还款明细  ### 等还清本金利息，保费收到当期，做退保
	 3、处理保费明细  <br>
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		
		logger.info("{}正常终止或逾期终止状态处理开始",MsxfConstant.MSXF_AL100206);

		MsxfMqMsg msxfMqMsg = JSON.parseObject(param, MsxfMqMsg.class);
		MsxfAccLoanInfo msxfAccLoanInfo = JSON.parseObject(msxfMqMsg.getData(), MsxfAccLoanInfo.class);
		
		//1、处理还款计划和保费计划
		msxfAccMtdPlanService.doAccMtdPlan(msxfAccLoanInfo,true,false,null);
		//2、 处理保费明细acc_fee_ps_note
		msxfAccFeePsNoteService.doFeeRepayDetails(msxfAccLoanInfo);
		//3、 处理还款明细
		msxfAccMtdPsNoteService.doAccMtdPsNote(msxfAccLoanInfo);
		//4、记录需要发送提前结清
		msxfAsynDealService.insertLstSettleInfo(msxfAccLoanInfo.getBillNo(), msxfAccLoanInfo.getListSerno(), msxfAccLoanInfo.getTxnStatus());
		
		logger.info("{}正常终止或逾期终止状态处理结束",MsxfConstant.MSXF_AL100206);

		return MsxfResponse.CODE_0000;
	}

}
