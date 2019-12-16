package cn.com.sinosafe.service.msxf.postloan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.bean.MsxfLoanStatus;
import cn.com.sinosafe.domain.bean.MsxfStatus;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.domain.msxf.MsxfMqMsg;
import cn.com.sinosafe.service.msxf.MsxfAsynDealService;
import cn.com.sinosafe.service.msxf.MsxfService;
import cn.com.sinosafe.service.msxf.common.MsxfAccFeePsNoteService;
import cn.com.sinosafe.service.msxf.common.MsxfAccMtdPsNoteService;

/**
 * 
 * 借据 正常 或 结清 状态处理 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月18日<br>
 */
@Service(MsxfConstant.MSXF_AL100201)
public class MsxfAL100201Service implements MsxfService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MsxfAccMtdPsNoteService msxfAccMtdPsNoteService;
	@Autowired
	private MsxfAccFeePsNoteService msxfAccFeePsNoteService;
	@Autowired
	private MsxfAsynDealService msxfAsynDealService;

	/**
	 * 1、正常：有还款就插入还款明细，有保费还款就插入保费明细<br>
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public MsxfResponse busiDeal(String param) throws Exception {
		logger.info("{}借据 正常 或 结清 状态处理开始",MsxfConstant.MSXF_AL100201);
		//参数解析
		MsxfMqMsg msxfMqMsg = JSON.parseObject(param, MsxfMqMsg.class);
		MsxfAccLoanInfo msxfAccLoanInfo = JSON.parseObject(msxfMqMsg.getData(), MsxfAccLoanInfo.class);
		
		// 处理保费明细
		msxfAccFeePsNoteService.doFeeRepayDetails(msxfAccLoanInfo);
		
		// 处理还款明细
		msxfAccMtdPsNoteService.doAccMtdPsNote(msxfAccLoanInfo);
		
		if(StringUtils.equals(MsxfLoanStatus.结清.getMsStatus(), msxfAccLoanInfo.getTxnStatus())) {
			//4、 插入轨迹
			msxfAsynDealService.insertLstOperDetailsStatus(msxfAccLoanInfo.getIqpLoanSerno(), MsxfStatus.正常结清, null);
		}

		logger.info("{}借据 正常 或 结清 状态处理结束",MsxfConstant.MSXF_AL100201);
		return MsxfResponse.CODE_0000;
	}

}
