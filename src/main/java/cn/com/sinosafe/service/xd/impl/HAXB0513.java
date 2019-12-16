package cn.com.sinosafe.service.xd.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.entity.AccLoan;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PartnerBusiImportDetail;
import cn.com.sinosafe.domain.entity.PartnerBusiImportList;
import cn.com.sinosafe.domain.entity.SentStatus;
import cn.com.sinosafe.domain.xd.XdLoanInfoRequest;
import cn.com.sinosafe.domain.xd.XdRequest;
import cn.com.sinosafe.service.xd.XdBaseService;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * Copy Right Information : SINOSAFE <br>
 * Project : Java EE 开发平台 <br>
 * Description : 网商小贷查询接口 <br>
 * Author : ChenLiang <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2018年4月23日<br>
 */
@Service("HAXB0513")
public class HAXB0513 extends XdBaseService {
	
	private final static Logger logger = LoggerFactory.getLogger(HAXB0513.class);

	@Override
	public String process(XdRequest xdRequest) throws Exception {
		logger.info("------"+xdRequest.getAccid()+" queryStatusForWSXD ---- start -----");
		
		JSONObject json = new JSONObject();
		XdLoanInfoRequest loanInfo = JSONObject.parseObject(xdRequest.getParams(),XdLoanInfoRequest.class);
		if(ObjectUtils.isEmpty(loanInfo) || StringUtils.isEmpty(loanInfo.getContNO())){
			throw new Exception("参数为空");
		}
		String contNo = loanInfo.getContNO();
		json.put("contNo", contNo);

		PartnerBusiImportList busiImportList = partnerBusiImportListMapper.selectByContNo(contNo);
		if(StringUtils.isNull(busiImportList)){
			json.put("outSts", "00"); // 业务不存在
		}else{
			json.put("serno", busiImportList.getBatchNo());
			IqpMeLoanApp loan = iqpMeLoanAppMapper.selectByPrimaryKey(busiImportList.getBatchNo());
			if(StringUtils.isNull(loan)){
				throw new Exception("业务异常");
			}else{
				String status = busiImportList.getStatus();
				json.put("applyAmt", loan.getAmount());
				PartnerBusiImportDetail detail = partnerBusiImportDetailMapper.selectByPrimaryKey(busiImportList.getBatchNo());
				if("00".equals(status)) {
					json.put("outSts", "01"); // 审批拒绝
					json.put("demo", detail.getNoPassReason());
				}else {
					if("06".equals(status)){
							json.put("outSts", "02"); // 审批通过，待上传合同
					}else if("04".equals(status) || "05".equals(status)){
						if("04".equals(status) && "P95HSXD05".equals(xdRequest.getAccid())){
							//增加待签署状态
							//根据申请单流水号 查询SentStatus表
							SentStatus record = new SentStatus();
							record.setSentSerno(loan.getSerno());
							record.setSentStatus("01");
							record.setSentType(getIqpMeApiCop().getAccid() + "_xd_sign");
							SentStatus sentStatus = sentStatusMapper.selectByPrimaryKey(record);
							if(!ObjectUtils.isEmpty(sentStatus)){
								json.put("outSts", "08"); // 08待签署投保单
							}else{
								json.put("outSts", "03"); // 待放款
							}
						}else{
							json.put("outSts", "03"); // 待放款
						}
					}
					json.put("repayApplAcNam", loan.getRepayAccountName());
					json.put("repayApplCardNo", loan.getRepayAccount());
					json.put("repayAccBankCde", loan.getBankNo());
					json.put("applyDt", loan.getInputDate());
					json.put("apprvTnr", detail.getTerm());
					json.put("mtdCde", loan.getRepaymentMode());
					json.put("loanRate", loan.getUsingIr());
					json.put("loanAccount", loan.getPayeeAccount());
					json.put("purpose", loan.getLoanUse());
					json.put("apprvAmt", new BigDecimal(detail.getAmount()));
					json.put("partnerNo", loan.getPartnerNo());

					// 如果渠道唯一编号和申请表中的合同号不一致，则说明申请表中的合同号为银行合同号
					if(StringUtils.isNotEmpty(loan.getAccAgreeNo()) && !contNo.equals(loan.getAccAgreeNo())) {
						json.put("contractNo", loan.getAccAgreeNo());
					}

					if("1".equals(loan.getIsCancel())){
						json.put("outSts", "05"); // 已注销
					}else{
						// 查询保单
						LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByIqpLoanSerno2(loan.getSerno());
						if(StringUtils.isNotNull(lstIqpInfo) && StringUtils.isNotEmpty(lstIqpInfo.getContNo())
								&& !contNo.equals(lstIqpInfo.getContNo())) {
							json.put("contractNo", lstIqpInfo.getContNo());
						}
						// 查询台帐
						AccLoan accLoan = accLoanMapper.selectByIqpLoanSerno(busiImportList.getBatchNo());
						if(StringUtils.isNotNull(accLoan)){
							// 银行合同号
							json.put("contractNo", StringUtils.isEmpty(accLoan.getContNo())?accLoan.getCnContNo():accLoan.getContNo());
							json.put("loanNo", accLoan.getBillNo());
							json.put("apprvAmt", accLoan.getLoanAmount());
							json.put("loanAmtLow", accLoan.getLoanAmount());
							json.put("loanActvDt", accLoan.getLoanStartDate());
							json.put("dueDay", accLoan.getDueDay());
							json.put("lastDueDay", accLoan.getLoanEndDate());
							json.put("interestDate", accLoan.getLoanStartDate());
							json.put("outSts", "04"); // 已放款
							json.put("partnerNo", accLoan.getPartnerNo());
							if(accLoan.getLoanBalance().compareTo(new BigDecimal("0")) <= 0){
								json.put("outSts", "06"); // 已结清
							}
						}
					}
				}
			}
		}
		logger.info("------"+xdRequest.getAccid()+" queryStatusForWSXD ---- end -----");
		json.put("result", "0000");
		return json.toJSONString();
	}
	
}
