package cn.com.sinosafe.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * MSXF_ACC_LOAN_INFO
 * @author 
 */
public class MsxfAccLoanInfo implements Serializable {
    /**
     * 主键
     */
    private String dkId;

    /**
     * 业务日期
     */
    private String bizDate;

    /**
     * 客户编号
     */
    private String uuid;

    /**
     * 合同号
     */
    private String contrNbr;

    /**
     * 产品编号
     */
    private String productCd;

    /**
     * 贷款编号
     */
    private String refNbr;

    /**
     * 币种
     */
    private String currency;

    /**
     * 贷款状态
     */
    private String txnStatus;

    /**
     * 放款日期
     */
    private String txnDate;

    /**
     * 放款金额
     */
    private BigDecimal txnAmt;

    /**
     * 放款总期数
     */
    private String initTerm;

    /**
     * 当前期数
     */
    private String currTerm;

    /**
     * 逾期天数
     */
    private Short overdueDays;

    /**
     * 逾期起始日
     */
    private String overdueDate;

    /**
     * 贷款本金余额
     */
    private BigDecimal principalBal;

    /**
     * 贷款利息余额
     */
    private BigDecimal interestBal;

    /**
     * 逾期贷款本金余额
     */
    private BigDecimal overduePrin;

    /**
     * 逾期利息
     */
    private BigDecimal overdueInt;

    /**
     * 罚息余额
     */
    private BigDecimal penaltyBal;

    /**
     * 利率类型
     */
    private String intType;

    /**
     * 计息标志
     */
    private String intFlag;

    /**
     * 贷款入帐账号
     */
    private String cardNo;

    /**
     * 贷款担保方式
     */
    private String guaranteeFlag;

    /**
     * 还款方式
     */
    private String pmtType;

    /**
     * 借款利率
     */
    private BigDecimal interestRate;

    /**
     * 客户定价
     */
    private BigDecimal loanrate;

    /**
     * 罚息利率
     */
    private BigDecimal penaltyRate;

    /**
     * 借款利率类型
     */
    private String intRateType;

    /**
     * 罚息利率类型
     */
    private String penRateType;

    /**
     * 保单号
     */
    private String policyNumber;

    /**
     * 承贷比
     */
    private String loanRatio;

    /**
     * 合作方编码
     */
    private String coopId;

    /**
     * 录入日期
     */
    private String inputDate;

    /**
     * 同步状态
     */
    private String syncStatus;

    /**
     * 资金方
     */
    private String copNo;

    /**
     * 华安业务日期
     */
    private String businessDate;
    
    /********非表字段*******/
    /**
     * 借据号
     */
    private String billNo;
    /**
     * 保单号
     */
    private String listSerno;
    /**
     * 投保单流水号
     */
    private String serno;

    /**
     * 业务流水号
     */
    private String iqpLoanSerno;

    
    private static final long serialVersionUID = 1L;

    public String getDkId() {
        return dkId;
    }

    public void setDkId(String dkId) {
        this.dkId = dkId;
    }

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getContrNbr() {
        return contrNbr;
    }

    public void setContrNbr(String contrNbr) {
        this.contrNbr = contrNbr;
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }

    public String getRefNbr() {
        return refNbr;
    }

    public void setRefNbr(String refNbr) {
        this.refNbr = refNbr;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTxnStatus() {
        return txnStatus;
    }

    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus;
    }

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public BigDecimal getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(BigDecimal txnAmt) {
        this.txnAmt = txnAmt;
    }

    public String getInitTerm() {
        return initTerm;
    }

    public void setInitTerm(String initTerm) {
        this.initTerm = initTerm;
    }

    public String getCurrTerm() {
        return currTerm;
    }

    public void setCurrTerm(String currTerm) {
        this.currTerm = currTerm;
    }

    public Short getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Short overdueDays) {
        this.overdueDays = overdueDays;
    }

    public String getOverdueDate() {
        return overdueDate;
    }

    public void setOverdueDate(String overdueDate) {
        this.overdueDate = overdueDate;
    }

    public BigDecimal getPrincipalBal() {
        return principalBal;
    }

    public void setPrincipalBal(BigDecimal principalBal) {
        this.principalBal = principalBal;
    }

    public BigDecimal getInterestBal() {
        return interestBal;
    }

    public void setInterestBal(BigDecimal interestBal) {
        this.interestBal = interestBal;
    }

    public BigDecimal getOverduePrin() {
        return overduePrin;
    }

    public void setOverduePrin(BigDecimal overduePrin) {
        this.overduePrin = overduePrin;
    }

    public BigDecimal getOverdueInt() {
        return overdueInt;
    }

    public void setOverdueInt(BigDecimal overdueInt) {
        this.overdueInt = overdueInt;
    }

    public BigDecimal getPenaltyBal() {
        return penaltyBal;
    }

    public void setPenaltyBal(BigDecimal penaltyBal) {
        this.penaltyBal = penaltyBal;
    }

    public String getIntType() {
        return intType;
    }

    public void setIntType(String intType) {
        this.intType = intType;
    }

    public String getIntFlag() {
        return intFlag;
    }

    public void setIntFlag(String intFlag) {
        this.intFlag = intFlag;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getGuaranteeFlag() {
        return guaranteeFlag;
    }

    public void setGuaranteeFlag(String guaranteeFlag) {
        this.guaranteeFlag = guaranteeFlag;
    }

    public String getPmtType() {
        return pmtType;
    }

    public void setPmtType(String pmtType) {
        this.pmtType = pmtType;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getLoanrate() {
        return loanrate;
    }

    public void setLoanrate(BigDecimal loanrate) {
        this.loanrate = loanrate;
    }

    public BigDecimal getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(BigDecimal penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    public String getIntRateType() {
        return intRateType;
    }

    public void setIntRateType(String intRateType) {
        this.intRateType = intRateType;
    }

    public String getPenRateType() {
        return penRateType;
    }

    public void setPenRateType(String penRateType) {
        this.penRateType = penRateType;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getLoanRatio() {
        return loanRatio;
    }

    public void setLoanRatio(String loanRatio) {
        this.loanRatio = loanRatio;
    }

    public String getCoopId() {
        return coopId;
    }

    public void setCoopId(String coopId) {
        this.coopId = coopId;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getCopNo() {
        return copNo;
    }

    public void setCopNo(String copNo) {
        this.copNo = copNo;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getListSerno() {
		return listSerno;
	}

	public void setListSerno(String listSerno) {
		this.listSerno = listSerno;
	}

	public String getSerno() {
		return serno;
	}

	public void setSerno(String serno) {
		this.serno = serno;
	}

    public String getIqpLoanSerno() { return iqpLoanSerno; }

    public void setIqpLoanSerno(String iqpLoanSerno) { this.iqpLoanSerno = iqpLoanSerno; }
}