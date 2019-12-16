/**
 * 
 */
package cn.com.sinosafe.common.config.constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.domain.entity.AccLoan;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PrjChnPrdInfo;
import cn.com.sinosafe.domain.entity.PrjCopAcc;
import cn.com.sinosafe.domain.entity.PrjCopTrustPlan;
import cn.com.sinosafe.domain.entity.PspClaimApprove;
import cn.com.sinosafe.domain.entity.PspClaimApproveRecode;
import cn.com.sinosafe.domain.entity.PspClaimList;
import cn.com.sinosafe.domain.entity.PspClaimLoan;
import cn.com.sinosafe.domain.entity.PspClaimPaphRecode;

/**  
* <p>Title: PspClaimConstant</p>  
* <p>Description: 理赔常用工具类</p>  
* @author longxiaoqiang  
* @date 2019年8月28日  
*/
public class PspClaimConstant {

	@SuppressWarnings("unchecked")
	public static List<PspClaimApproveRecode> convertPspClaimApproveRecode (Map<String,Object> paramMap) {
		List<Map<String, Object>> listMap = (List<Map<String,Object>>)paramMap.get("claimsApplyList");
		List<PspClaimApproveRecode> list = new ArrayList<PspClaimApproveRecode>();
		for (Map<String, Object> map : listMap) {
			PspClaimApproveRecode pspClaimApproveRecode = new PspClaimApproveRecode();
			pspClaimApproveRecode.setPkId(UUID.randomUUID().toString().replace("-", ""));
			pspClaimApproveRecode.setBatchNo(String.valueOf(paramMap.get("premBatchNo")));
			pspClaimApproveRecode.setCount(Short.parseShort(String.valueOf(paramMap.get("premCount"))));
			pspClaimApproveRecode.setIsHoliday(String.valueOf(paramMap.get("IsHoliday")));
			pspClaimApproveRecode.setLnAcct(String.valueOf(map.get("lnAcct")));
			pspClaimApproveRecode.setApplNo(String.valueOf(map.get("applNo")));
			pspClaimApproveRecode.setClaimType(String.valueOf(map.get("claimType")));
			pspClaimApproveRecode.setLnAmt(new BigDecimal(String.valueOf(map.get("lnAmt"))));
			pspClaimApproveRecode.setLnTerm(Short.parseShort(String.valueOf(map.get("lnTerm"))));
			pspClaimApproveRecode.setClaimAmt(new BigDecimal(String.valueOf(map.get("claimAmt"))));
			pspClaimApproveRecode.setPrinAmt(new BigDecimal(String.valueOf(map.get("prinAmt"))));
			pspClaimApproveRecode.setIntAmt(new BigDecimal(String.valueOf(map.get("intAmt"))));
			pspClaimApproveRecode.setLcAmt(new BigDecimal(String.valueOf(map.get("lcAmt"))));
			pspClaimApproveRecode.setPremDate(String.valueOf(map.get("premDate")));
			pspClaimApproveRecode.setInsuCompany(String.valueOf(paramMap.get("insuCompany")));
			
			list.add(pspClaimApproveRecode);
		}
		
		return list;
	}
	public static PspClaimLoan convertPspClaimLoan (Map<String,Object> paramMap,String serno,AccLoan accLoan,LstIqpInfo lstIqpInfo,PrjCopAcc prjCopAcc,boolean approveHis,PrjCopTrustPlan prjCopTrustPlan,PrjChnPrdInfo prjChnPrdInfo) {
		
		//获取免赔率
		BigDecimal oweRate = new BigDecimal("1").subtract(new BigDecimal(String.valueOf(lstIqpInfo.getExcuseRate())).divide(new BigDecimal("100")));
				
		PspClaimLoan pspClaimLoan = new PspClaimLoan();
		pspClaimLoan.setSerno(serno);
		pspClaimLoan.setBillNo(String.valueOf(paramMap.get("lnAcct")));
		pspClaimLoan.setPsPerdNo(Short.parseShort(String.valueOf(paramMap.get("lnTerm"))));
		pspClaimLoan.setListSerno(accLoan.getListSerno());
		pspClaimLoan.setIqpSerno(accLoan.getIqpLoanSerno());
		pspClaimLoan.setBorrowerNo(accLoan.getCusId());
		pspClaimLoan.setInsured(prjCopAcc.getCopNo());
		pspClaimLoan.setLoanStartDate(accLoan.getLoanStartDate());
		pspClaimLoan.setLoanEndDate(accLoan.getLoanEndDate());
		BigDecimal amountLp = null;
		if (approveHis) {
			amountLp = new BigDecimal(String.valueOf(paramMap.get("thisprinAmt"))).add(new BigDecimal(String.valueOf(paramMap.get("thisintAmt")))).add(new BigDecimal(String.valueOf(paramMap.get("thislcAmt"))));
		} else {
			amountLp = new BigDecimal(String.valueOf(paramMap.get("prinAmt"))).add(new BigDecimal(String.valueOf(paramMap.get("intAmt")))).add(new BigDecimal(String.valueOf(paramMap.get("lcAmt"))));
		}
		
		pspClaimLoan.setClaimCond("02");//赔付方式 STD_ZB_CLAIM_COND
		pspClaimLoan.setClaimAmount(amountLp);
		pspClaimLoan.setClaimedAmount(amountLp);
		pspClaimLoan.setMainBrId(accLoan.getMainBrId());
		pspClaimLoan.setCustMgr(accLoan.getCusManager());
		pspClaimLoan.setClaimSender(accLoan.getInputId());
		pspClaimLoan.setStartOrg(accLoan.getInputBrId());
		pspClaimLoan.setClaimStatus("05");
		pspClaimLoan.setApproveStatus("997");
		pspClaimLoan.setBorrowerName(accLoan.getCusName());
		//TODO
		pspClaimLoan.setApplyType("01");//预付
		pspClaimLoan.setSettleType("02");//理赔方式
		pspClaimLoan.setRepayplanSt("4"); //还款状态
		pspClaimLoan.setLossType("compen"); //损失类型：代偿
		
		pspClaimLoan.setDueDay(accLoan.getDueDay().shortValue());
		pspClaimLoan.setClaimReason("borrower");//理赔原因
		
		//账户
		pspClaimLoan.setAccountNo(prjCopTrustPlan.getSettleAcountNo());
		//账户名称
		pspClaimLoan.setAccountName(prjCopTrustPlan.getSettleAcountName());
		//开户银行名称
		pspClaimLoan.setBankBranchName(prjCopTrustPlan.getSettleBankName());
		pspClaimLoan.setBankPayType("2");//2对公3对私
		
		/*pspClaimLoan.setPayeeType(prjCopAcc.getPayeeType());*/
		//开户行代码
		pspClaimLoan.setBankCode(prjCopTrustPlan.getSettleBankCode());
		//收款方银行
		pspClaimLoan.setPayeeBankName(prjCopTrustPlan.getSettleAtBankName());
		//收款方银行编码
		pspClaimLoan.setPayeeBankCode(prjCopTrustPlan.getSettleAtBankCode());
		pspClaimLoan.setPayeeBankCity(prjCopTrustPlan.getSettleBankCity());
		pspClaimLoan.setPayeeBankCityCode(prjCopTrustPlan.getSettleBankCityCode());
		pspClaimLoan.setLmtContNo(prjChnPrdInfo.getPkId());
		pspClaimLoan.setHaApproveRemark("PAPH");
		/*//账户
		pspClaimLoan.setAccountNo(prjCopTrustPlan.getSettleAcountNo());
		//账户名称
		pspClaimLoan.setAccountName(prjCopTrustPlan.getSettleAcountName());
		//开户银行名称
		pspClaimLoan.setBankBranchName(prjCopTrustPlan.getSettleBankName());
		//pspClaimLoan.setBankPayType(prjCopAcc.getBankPayType());
		
		//pspClaimLoan.setPayeeType(prjCopAcc.getPayeeType());
		//开户行代码
		//pspClaimLoan.setBankCode(prjCopAcc.getBankCode());
		//收款方银行
		pspClaimLoan.setPayeeBankName(prjCopTrustPlan.getSettleAtBankName());
		//收款方银行编码
		//pspClaimLoan.setPayeeBankCode(prjCopAcc.getPayeeBankCode());
		//pspClaimLoan.setPayeeBankCity(prjCopAcc.getPayeeBankCity());
		//pspClaimLoan.setPayeeBankCityCode(prjCopAcc.getPayeeBankCityCode());
*/		
		pspClaimLoan.setClaimInputDate(DateUtils.getDate("yyyy-MM-dd"));
		
		
		
		return pspClaimLoan;
	}
	public static PspClaimList converPspClaimList (Map<String,Object> paramMap,String serno,boolean approveHis,PrjChnPrdInfo prjChnPrdInfo) {
		PspClaimList pspClaimList = new PspClaimList();
		pspClaimList.setBillNo(String.valueOf(paramMap.get("lnAcct")));
		pspClaimList.setPsPerdNo(Integer.parseInt(String.valueOf(paramMap.get("lnTerm"))));
		pspClaimList.setDeIr(prjChnPrdInfo.getPreventRate()); //免赔率
					
		//理赔金额
		BigDecimal amountLp = null;
		if (approveHis) {
			amountLp = new BigDecimal(String.valueOf(paramMap.get("thisprinAmt"))).add(new BigDecimal(String.valueOf(paramMap.get("thisintAmt")))).add(new BigDecimal(String.valueOf(paramMap.get("thislcAmt"))));
			pspClaimList.setUnsetPsPrcpAmt(new BigDecimal(String.valueOf(paramMap.get("thisprinAmt"))));
			pspClaimList.setUnsetPsOdIntAmt(new BigDecimal(String.valueOf(paramMap.get("thislcAmt"))));
			pspClaimList.setUnsetPsNormIntAmt(new BigDecimal(String.valueOf(paramMap.get("thisintAmt"))));
		} else {
			amountLp = new BigDecimal(String.valueOf(paramMap.get("prinAmt"))).add(new BigDecimal(String.valueOf(paramMap.get("intAmt")))).add(new BigDecimal(String.valueOf(paramMap.get("lcAmt"))));
			pspClaimList.setUnsetPsPrcpAmt(new BigDecimal(String.valueOf(paramMap.get("prinAmt"))));
			pspClaimList.setUnsetPsOdIntAmt(new BigDecimal(String.valueOf(paramMap.get("lcAmt"))));
			pspClaimList.setUnsetPsNormIntAmt(new BigDecimal(String.valueOf(paramMap.get("intAmt"))));
		}
		pspClaimList.setUnsetPsCommOdInt(new BigDecimal("0"));
		pspClaimList.setEstOdCommAmt(new BigDecimal("0"));
		pspClaimList.setThisClaimAmount(amountLp);
		pspClaimList.setThisClaimAmountSum(amountLp);
		
		pspClaimList.setPerdStatus("1");//STD_ZB_STATUS
		pspClaimList.setSerno(serno);
		
		return pspClaimList;
	}
	public static PspClaimApprove convertPspClaimApprove (Map<String,Object> paramMap,String serno,String pkid,PspClaimLoan pspClaimLoan) {
		PspClaimApprove pspClaimApprove = new PspClaimApprove();
		
		pspClaimApprove.setPkId(pkid);
		pspClaimApprove.setClaimType("01");//STD_ZB_CLAIM_TYPE
		pspClaimApprove.setClaimApplyAmount(pspClaimLoan.getClaimAmount());
		pspClaimApprove.setIsGuar("0");//STD_HA_YES_NO
		pspClaimApprove.setClaimDate(DateUtils.getDate());
		pspClaimApprove.setClaimOrg("00");
		pspClaimApprove.setApprover("xwadmin");
		pspClaimApprove.setClaimApplyType("02");//STD_ZB_CLAIM_APPLY_TYPE
		pspClaimApprove.setClaimEndAmount(pspClaimLoan.getClaimAmount());
		pspClaimApprove.setClaimOpinion("同意");
		pspClaimApprove.setClaimResult("01");//ZB_WFI_APPR_RSLT
		pspClaimApprove.setSerno(pspClaimLoan.getSerno());
		
		return pspClaimApprove;
	}
	@SuppressWarnings("unchecked")
	public static List<PspClaimPaphRecode> convertPspClaimPaphRecode (Map<String,Object> paramMap) {
		List<PspClaimPaphRecode> pspClaimPaphRecodeList = new ArrayList<PspClaimPaphRecode>();
		List<Map<String, Object>> listMap = (List<Map<String,Object>>)paramMap.get("claimsApplyList");
		for (Map<String, Object> map : listMap) {
			PspClaimPaphRecode pspClaimPaphRecode = new PspClaimPaphRecode();
			pspClaimPaphRecode.setPkId(UUID.randomUUID().toString().replace("-", ""));
			pspClaimPaphRecode.setClaimBatchNo(String.valueOf(paramMap.get("claimBatchNo")));
			pspClaimPaphRecode.setClaimCount(Short.parseShort(String.valueOf(paramMap.get("claimCount"))));
			pspClaimPaphRecode.setLnAcct(String.valueOf(map.get("lnAcct")));
			pspClaimPaphRecode.setApplNo(String.valueOf(map.get("applNo")));
			pspClaimPaphRecode.setClaimAmt(new BigDecimal(String.valueOf(map.get("claimAmt"))));
			pspClaimPaphRecode.setClaimDate(String.valueOf(map.get("claimDate")));
			pspClaimPaphRecode.setInsuCompany(String.valueOf(paramMap.get("insuCompany")));
			pspClaimPaphRecode.setNoticeResult("00");
			pspClaimPaphRecodeList.add(pspClaimPaphRecode);
		}
		return pspClaimPaphRecodeList;
	}
	
	
}
