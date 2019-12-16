package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class PspClaimLoan {
    private String serno;

    private String claimSerno;

    private String iqpSerno;

    private String borrowerNo;

    private String listSerno;

    private String billNo;

    private String insured;

    private String loanStartDate;

    private String loanEndDate;

    private Short dueDay;

    private String repayplanSt;

    private String lmtContNo;

    private BigDecimal claimAmount;

    private BigDecimal claimedAmount;

    private BigDecimal claimCount;

    private String mainBrId;

    private String custMgr;

    private String claimInputDate;

    private String claimSender;

    private String startOrg;

    private String claimStatus;

    private String approveStatus;

    private String applyType;

    private String borrowerName;

    private String claimCond;

    private String settleType;

    private String claimEndDate;

    private String mainSerno;

    private String certCode;

    private String netPhone;

    private String exportInTime;

    private String overdue;

    private String claimReason;

    private BigDecimal deIr;

    private String lossType;

    private String payeeBankCityCode;

    private String payeeBankCity;

    private String payeeBankCode;

    private String payeeBankName;

    private String bankCode;

    private String bankBranchName;

    private String accountName;

    private String accountNo;

    private String paymentStatus;

    private String pubBanksUrid;

    private String pubStandardareasUrid;

    private String cla;

    private String bankPayType;

    private String payeeType;

    private String bankWatercourseNo;

    private String batchNumber;

    private String payFlag;

    private String adjustmentNo;

    private String negotiationDate;

    private String compensateType;

    private String exportInType;

    private Short psPerdNo;

    private String theLink;

    private String informationid;

    private String haApproveStatus;

    private String haSignNumber;

    private String haApproveRemark;

    private String haApproveUser;

    private String haApproveTime;

    private String haReceiptsPaymentNumber;

    private String paymentAccount;

    private String paymentDay;

    private String paymentBankCode;

    private String paymentAccountName;

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    public String getClaimSerno() {
        return claimSerno;
    }

    public void setClaimSerno(String claimSerno) {
        this.claimSerno = claimSerno == null ? null : claimSerno.trim();
    }

    public String getIqpSerno() {
        return iqpSerno;
    }

    public void setIqpSerno(String iqpSerno) {
        this.iqpSerno = iqpSerno == null ? null : iqpSerno.trim();
    }

    public String getBorrowerNo() {
        return borrowerNo;
    }

    public void setBorrowerNo(String borrowerNo) {
        this.borrowerNo = borrowerNo == null ? null : borrowerNo.trim();
    }

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

    public String getInsured() {
        return insured;
    }

    public void setInsured(String insured) {
        this.insured = insured == null ? null : insured.trim();
    }

    public String getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(String loanStartDate) {
        this.loanStartDate = loanStartDate == null ? null : loanStartDate.trim();
    }

    public String getLoanEndDate() {
        return loanEndDate;
    }

    public void setLoanEndDate(String loanEndDate) {
        this.loanEndDate = loanEndDate == null ? null : loanEndDate.trim();
    }

    public Short getDueDay() {
        return dueDay;
    }

    public void setDueDay(Short dueDay) {
        this.dueDay = dueDay;
    }

    public String getRepayplanSt() {
        return repayplanSt;
    }

    public void setRepayplanSt(String repayplanSt) {
        this.repayplanSt = repayplanSt == null ? null : repayplanSt.trim();
    }

    public String getLmtContNo() {
        return lmtContNo;
    }

    public void setLmtContNo(String lmtContNo) {
        this.lmtContNo = lmtContNo == null ? null : lmtContNo.trim();
    }

    public BigDecimal getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
    }

    public BigDecimal getClaimedAmount() {
        return claimedAmount;
    }

    public void setClaimedAmount(BigDecimal claimedAmount) {
        this.claimedAmount = claimedAmount;
    }

    public BigDecimal getClaimCount() {
        return claimCount;
    }

    public void setClaimCount(BigDecimal claimCount) {
        this.claimCount = claimCount;
    }

    public String getMainBrId() {
        return mainBrId;
    }

    public void setMainBrId(String mainBrId) {
        this.mainBrId = mainBrId == null ? null : mainBrId.trim();
    }

    public String getCustMgr() {
        return custMgr;
    }

    public void setCustMgr(String custMgr) {
        this.custMgr = custMgr == null ? null : custMgr.trim();
    }

    public String getClaimInputDate() {
        return claimInputDate;
    }

    public void setClaimInputDate(String claimInputDate) {
        this.claimInputDate = claimInputDate == null ? null : claimInputDate.trim();
    }

    public String getClaimSender() {
        return claimSender;
    }

    public void setClaimSender(String claimSender) {
        this.claimSender = claimSender == null ? null : claimSender.trim();
    }

    public String getStartOrg() {
        return startOrg;
    }

    public void setStartOrg(String startOrg) {
        this.startOrg = startOrg == null ? null : startOrg.trim();
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus == null ? null : claimStatus.trim();
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus == null ? null : approveStatus.trim();
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName == null ? null : borrowerName.trim();
    }

    public String getClaimCond() {
        return claimCond;
    }

    public void setClaimCond(String claimCond) {
        this.claimCond = claimCond == null ? null : claimCond.trim();
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType == null ? null : settleType.trim();
    }

    public String getClaimEndDate() {
        return claimEndDate;
    }

    public void setClaimEndDate(String claimEndDate) {
        this.claimEndDate = claimEndDate == null ? null : claimEndDate.trim();
    }

    public String getMainSerno() {
        return mainSerno;
    }

    public void setMainSerno(String mainSerno) {
        this.mainSerno = mainSerno == null ? null : mainSerno.trim();
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode == null ? null : certCode.trim();
    }

    public String getNetPhone() {
        return netPhone;
    }

    public void setNetPhone(String netPhone) {
        this.netPhone = netPhone == null ? null : netPhone.trim();
    }

    public String getExportInTime() {
        return exportInTime;
    }

    public void setExportInTime(String exportInTime) {
        this.exportInTime = exportInTime == null ? null : exportInTime.trim();
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue == null ? null : overdue.trim();
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason == null ? null : claimReason.trim();
    }

    public BigDecimal getDeIr() {
        return deIr;
    }

    public void setDeIr(BigDecimal deIr) {
        this.deIr = deIr;
    }

    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType == null ? null : lossType.trim();
    }

    public String getPayeeBankCityCode() {
        return payeeBankCityCode;
    }

    public void setPayeeBankCityCode(String payeeBankCityCode) {
        this.payeeBankCityCode = payeeBankCityCode == null ? null : payeeBankCityCode.trim();
    }

    public String getPayeeBankCity() {
        return payeeBankCity;
    }

    public void setPayeeBankCity(String payeeBankCity) {
        this.payeeBankCity = payeeBankCity == null ? null : payeeBankCity.trim();
    }

    public String getPayeeBankCode() {
        return payeeBankCode;
    }

    public void setPayeeBankCode(String payeeBankCode) {
        this.payeeBankCode = payeeBankCode == null ? null : payeeBankCode.trim();
    }

    public String getPayeeBankName() {
        return payeeBankName;
    }

    public void setPayeeBankName(String payeeBankName) {
        this.payeeBankName = payeeBankName == null ? null : payeeBankName.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName == null ? null : bankBranchName.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus == null ? null : paymentStatus.trim();
    }

    public String getPubBanksUrid() {
        return pubBanksUrid;
    }

    public void setPubBanksUrid(String pubBanksUrid) {
        this.pubBanksUrid = pubBanksUrid == null ? null : pubBanksUrid.trim();
    }

    public String getPubStandardareasUrid() {
        return pubStandardareasUrid;
    }

    public void setPubStandardareasUrid(String pubStandardareasUrid) {
        this.pubStandardareasUrid = pubStandardareasUrid == null ? null : pubStandardareasUrid.trim();
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla == null ? null : cla.trim();
    }

    public String getBankPayType() {
        return bankPayType;
    }

    public void setBankPayType(String bankPayType) {
        this.bankPayType = bankPayType == null ? null : bankPayType.trim();
    }

    public String getPayeeType() {
        return payeeType;
    }

    public void setPayeeType(String payeeType) {
        this.payeeType = payeeType == null ? null : payeeType.trim();
    }

    public String getBankWatercourseNo() {
        return bankWatercourseNo;
    }

    public void setBankWatercourseNo(String bankWatercourseNo) {
        this.bankWatercourseNo = bankWatercourseNo == null ? null : bankWatercourseNo.trim();
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public String getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(String payFlag) {
        this.payFlag = payFlag == null ? null : payFlag.trim();
    }

    public String getAdjustmentNo() {
        return adjustmentNo;
    }

    public void setAdjustmentNo(String adjustmentNo) {
        this.adjustmentNo = adjustmentNo == null ? null : adjustmentNo.trim();
    }

    public String getNegotiationDate() {
        return negotiationDate;
    }

    public void setNegotiationDate(String negotiationDate) {
        this.negotiationDate = negotiationDate == null ? null : negotiationDate.trim();
    }

    public String getCompensateType() {
        return compensateType;
    }

    public void setCompensateType(String compensateType) {
        this.compensateType = compensateType == null ? null : compensateType.trim();
    }

    public String getExportInType() {
        return exportInType;
    }

    public void setExportInType(String exportInType) {
        this.exportInType = exportInType == null ? null : exportInType.trim();
    }

    public Short getPsPerdNo() {
        return psPerdNo;
    }

    public void setPsPerdNo(Short psPerdNo) {
        this.psPerdNo = psPerdNo;
    }

    public String getTheLink() {
        return theLink;
    }

    public void setTheLink(String theLink) {
        this.theLink = theLink == null ? null : theLink.trim();
    }

    public String getInformationid() {
        return informationid;
    }

    public void setInformationid(String informationid) {
        this.informationid = informationid == null ? null : informationid.trim();
    }

    public String getHaApproveStatus() {
        return haApproveStatus;
    }

    public void setHaApproveStatus(String haApproveStatus) {
        this.haApproveStatus = haApproveStatus == null ? null : haApproveStatus.trim();
    }

    public String getHaSignNumber() {
        return haSignNumber;
    }

    public void setHaSignNumber(String haSignNumber) {
        this.haSignNumber = haSignNumber == null ? null : haSignNumber.trim();
    }

    public String getHaApproveRemark() {
        return haApproveRemark;
    }

    public void setHaApproveRemark(String haApproveRemark) {
        this.haApproveRemark = haApproveRemark == null ? null : haApproveRemark.trim();
    }

    public String getHaApproveUser() {
        return haApproveUser;
    }

    public void setHaApproveUser(String haApproveUser) {
        this.haApproveUser = haApproveUser == null ? null : haApproveUser.trim();
    }

    public String getHaApproveTime() {
        return haApproveTime;
    }

    public void setHaApproveTime(String haApproveTime) {
        this.haApproveTime = haApproveTime == null ? null : haApproveTime.trim();
    }

    public String getHaReceiptsPaymentNumber() {
        return haReceiptsPaymentNumber;
    }

    public void setHaReceiptsPaymentNumber(String haReceiptsPaymentNumber) {
        this.haReceiptsPaymentNumber = haReceiptsPaymentNumber == null ? null : haReceiptsPaymentNumber.trim();
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount == null ? null : paymentAccount.trim();
    }

    public String getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(String paymentDay) {
        this.paymentDay = paymentDay == null ? null : paymentDay.trim();
    }

    public String getPaymentBankCode() {
        return paymentBankCode;
    }

    public void setPaymentBankCode(String paymentBankCode) {
        this.paymentBankCode = paymentBankCode == null ? null : paymentBankCode.trim();
    }

    public String getPaymentAccountName() {
        return paymentAccountName;
    }

    public void setPaymentAccountName(String paymentAccountName) {
        this.paymentAccountName = paymentAccountName == null ? null : paymentAccountName.trim();
    }
}