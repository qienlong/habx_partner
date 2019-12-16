package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class CqnsjbBfDetailInfo {
    private String listSerno;  //保单号

    private String billNo;//借据号

    private String cusName;//客户姓名

    private String certCode;//身份证

    private String psPerdNo; //期次

    private BigDecimal psNormIntAmt;//应还利息

    private BigDecimal psRealIntAmt;//实还利息

    private BigDecimal accruedIntAmt;//应计利息

    private String repayFlag;//是否理赔

    private String psDueDt;//还款/理赔日期
    
    private String inputDate ;// 录入日期 
    
    private String accountMonth; //结算月份
    
    private String listDueDate; //保单到期日
    
    private String correctDate; //批改日期
    

    public String getListSerno() {
        return listSerno;
    }

    public void setListSerno(String listSerno) {
        this.listSerno = listSerno == null ? null : listSerno.trim();
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode == null ? null : certCode.trim();
    }

    public String getPsPerdNo() {
        return psPerdNo;
    }

    public void setPsPerdNo(String psPerdNo) {
        this.psPerdNo = psPerdNo == null ? null : psPerdNo.trim();
    }

    public BigDecimal getPsNormIntAmt() {
        return psNormIntAmt;
    }

    public void setPsNormIntAmt(BigDecimal psNormIntAmt) {
        this.psNormIntAmt = psNormIntAmt;
    }

    public BigDecimal getPsRealIntAmt() {
        return psRealIntAmt;
    }

    public void setPsRealIntAmt(BigDecimal psRealIntAmt) {
        this.psRealIntAmt = psRealIntAmt;
    }

    public BigDecimal getAccruedIntAmt() {
        return accruedIntAmt;
    }

    public void setAccruedIntAmt(BigDecimal accruedIntAmt) {
        this.accruedIntAmt = accruedIntAmt;
    }

    public String getRepayFlag() {
        return repayFlag;
    }

    public void setRepayFlag(String repayFlag) {
        this.repayFlag = repayFlag == null ? null : repayFlag.trim();
    }

    public String getPsDueDt() {
        return psDueDt;
    }

    public void setPsDueDt(String psDueDt) {
        this.psDueDt = psDueDt == null ? null : psDueDt.trim();
    }

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getAccountMonth() {
		return accountMonth;
	}

	public void setAccountMonth(String accountMonth) {
		this.accountMonth = accountMonth;
	}
	public String getListDueDate() {
		return listDueDate;
	}
	public void setListDueDate(String listDueDate) {
		this.listDueDate = listDueDate;
	}

	public String getCorrectDate() {
		return correctDate;
	}
	public void setCorrectDate(String correctDate) {
		this.correctDate = correctDate;
	}
    
    
}