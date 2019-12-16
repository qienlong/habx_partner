package cn.com.sinosafe.domain.msxf.request;

import java.util.List;

/**
 * 
 * 分期计划请求参数 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月5日<br>
 */
@Deprecated
public class Msxf2001CreateFeeLoan {
	private String LST_SERNO;
	private String BILL_NO;
	private String RATE;
	private String PS_COVERAGE_FEE;
	private String PERD_TOTAL;
	private String PS_DUE_DT;
	private String INPUT_ID;
	private String INPUT_BR_ID;
	private String COVER_SERNO;
	private String LIST_SERNO;
	private String IQP_LOAN_SERNO;
	private String REPAYMENT_MODE;
	private String PAY_MODE;
	private String PRE_CAL_WAY;
	private String VIEW_FLAG;
	private List<String> PRE_WEIGHT_ARR;
	private String REPAYMENT_DAY;
	private List<PsFeeInfoArr> PS_FEE_INFO_ARR;
	public String getLST_SERNO() {
		return LST_SERNO;
	}
	public void setLST_SERNO(String lST_SERNO) {
		LST_SERNO = lST_SERNO;
	}
	public String getBILL_NO() {
		return BILL_NO;
	}
	public void setBILL_NO(String bILL_NO) {
		BILL_NO = bILL_NO;
	}
	public String getRATE() {
		return RATE;
	}
	public void setRATE(String rATE) {
		RATE = rATE;
	}
	public String getPS_COVERAGE_FEE() {
		return PS_COVERAGE_FEE;
	}
	public void setPS_COVERAGE_FEE(String pS_COVERAGE_FEE) {
		PS_COVERAGE_FEE = pS_COVERAGE_FEE;
	}
	public String getPERD_TOTAL() {
		return PERD_TOTAL;
	}
	public void setPERD_TOTAL(String pERD_TOTAL) {
		PERD_TOTAL = pERD_TOTAL;
	}
	public String getPS_DUE_DT() {
		return PS_DUE_DT;
	}
	public void setPS_DUE_DT(String pS_DUE_DT) {
		PS_DUE_DT = pS_DUE_DT;
	}
	public String getINPUT_ID() {
		return INPUT_ID;
	}
	public void setINPUT_ID(String iNPUT_ID) {
		INPUT_ID = iNPUT_ID;
	}
	public String getINPUT_BR_ID() {
		return INPUT_BR_ID;
	}
	public void setINPUT_BR_ID(String iNPUT_BR_ID) {
		INPUT_BR_ID = iNPUT_BR_ID;
	}
	public String getCOVER_SERNO() {
		return COVER_SERNO;
	}
	public void setCOVER_SERNO(String cOVER_SERNO) {
		COVER_SERNO = cOVER_SERNO;
	}
	public String getLIST_SERNO() {
		return LIST_SERNO;
	}
	public void setLIST_SERNO(String lIST_SERNO) {
		LIST_SERNO = lIST_SERNO;
	}
	public String getIQP_LOAN_SERNO() {
		return IQP_LOAN_SERNO;
	}
	public void setIQP_LOAN_SERNO(String iQP_LOAN_SERNO) {
		IQP_LOAN_SERNO = iQP_LOAN_SERNO;
	}
	public String getREPAYMENT_MODE() {
		return REPAYMENT_MODE;
	}
	public void setREPAYMENT_MODE(String rEPAYMENT_MODE) {
		REPAYMENT_MODE = rEPAYMENT_MODE;
	}
	public String getPAY_MODE() {
		return PAY_MODE;
	}
	public void setPAY_MODE(String pAY_MODE) {
		PAY_MODE = pAY_MODE;
	}
	public String getPRE_CAL_WAY() {
		return PRE_CAL_WAY;
	}
	public void setPRE_CAL_WAY(String pRE_CAL_WAY) {
		PRE_CAL_WAY = pRE_CAL_WAY;
	}
	public String getVIEW_FLAG() {
		return VIEW_FLAG;
	}
	public void setVIEW_FLAG(String vIEW_FLAG) {
		VIEW_FLAG = vIEW_FLAG;
	}
	public List<String> getPRE_WEIGHT_ARR() {
		return PRE_WEIGHT_ARR;
	}
	public void setPRE_WEIGHT_ARR(List<String> pRE_WEIGHT_ARR) {
		PRE_WEIGHT_ARR = pRE_WEIGHT_ARR;
	}
	public String getREPAYMENT_DAY() {
		return REPAYMENT_DAY;
	}
	public void setREPAYMENT_DAY(String rEPAYMENT_DAY) {
		REPAYMENT_DAY = rEPAYMENT_DAY;
	}
	public List<PsFeeInfoArr> getPS_FEE_INFO_ARR() {
		return PS_FEE_INFO_ARR;
	}
	public void setPS_FEE_INFO_ARR(List<PsFeeInfoArr> pS_FEE_INFO_ARR) {
		PS_FEE_INFO_ARR = pS_FEE_INFO_ARR;
	}

}
