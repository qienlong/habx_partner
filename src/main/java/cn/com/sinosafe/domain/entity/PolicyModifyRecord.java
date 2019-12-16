package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
  * @ClassName PolicyModifyRecord
  * @Description   保单批改登记表
  * @auther  林良
  * @version 1.0
  * @Date 2019/9/3 16:24
  */
public class PolicyModifyRecord {
    /**
     * 批改流水号
     */
    private String pmrSerno;

    /**
     * 投保单编号
     */
    private String coverSerno;

    /**
     * 保单编号
     */
    private String listSerno;

    /**
     * 借款合同编号
     */
    private String contNo;

    /**
     * 保险起期
     */
    private String coverStartDate;

    /**
     * 保险止期
     */
    private String coverEndDate;

    /**
     * 保单金额
     */
    private BigDecimal coverAmount;

    /**
     * 贷款金额
     */
    private BigDecimal amount;

    /**
     * 贷款期限
     */
    private BigDecimal term;

    /**
     * 批改日期(生效日期)
     */
    private String modfDate;

    /**
     * 批改后金额
     */
    private BigDecimal modfAmount;

    /**
     * 保险起始日期
     */
    private String polStartDate;

    /**
     * 修改人
     */
    private String upUsId;

    /**
     * 修改人机构
     */
    private String upBrId;

    /**
     * 修改时间
     */
    private String upTime;

    /**
     * 信保业务流水号
     */
    private String iqpLoanSerno;

    /**
     * 原保费合计
     */
    private BigDecimal coverageFee;

    private BigDecimal modfCoverageFee;

    private String coverCreateStatus;

    private String modfCoverCreateStatus;

    private String effectStatus;

    private String endorsementSerno;

    private String pkIdOrig;

    private String pkIdCurr;

    private BigDecimal rateOrig;

    private BigDecimal rateCurr;

    private BigDecimal excuseRateOrig;

    private BigDecimal excuseRateCurr;

    private String cAppntOrig;

    private String cAppntCurr;

    private BigDecimal coverAmountDiff;

    private BigDecimal coverageFeeDiff;

    private String endorsementReason;

    private String endorsementContent;

    private String bizMode;

    private String receiveCusName;

    private String receiverCusId;

    private String belongBrId;

    private String prdId;

    private String prdName;

    private String applyUserId;

    private String applyDate;

    private String cusType;

    private String lstiqpSerno;

    private String foreignKey;

    private String checkUserId;

    private String checkTime;

    private String modType;

    private String inputBrId;

    /**
     * 审批状态 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
     */
    private String approveStatus;

    private String modfContNo;

    private BigDecimal newAmount;

    private String modfReceiveCusName;

    private String cusName;

    private String modfCusName;

    private String coreAppSerno;

    private String certCode;

    private String modfCertCode;

    private String indivSex;

    private String modfIndivSex;

    private String mobile;

    private String modfMobile;

    private String address;

    private String modfAddress;

    private String receiveCusCertCode;

    private String modfReceiveCusCertCode;

    private String receiveCusPhone;

    private String modfReceiveCusPhone;

    private String receiveCusCertType;

    private String modfReceiveCusCertType;

    private String receiverCusAddress;

    private String modfReceiverCusAddress;

    private String legalName;

    private String modfLegalName;

    private String legalCertCode;

    private String modfLegalCertCode;

    private String modfLegalHomeAddr;

    private String insuranceType;

    private String modfInsuranceType;

    private String legalHomeAddr;

    private String cUniversityAdd;

    private String cUniversityName;

    private String cDepartmentName;

    private String cClassName;

    private String cTgtFld8;

    private BigDecimal nTgtFld3Fld8;

    private BigDecimal cPcurCnm;

    private Integer personCount;

    private String modfCUniversityAdd;

    private String modfCUniversityName;

    private String modfCDepartmentName;

    private String modfCClassName;

    private Integer modfPersonCount;

    private BigDecimal modfCPcurCnm;

    private String modfCTgtFld8;

    private String modfCoverEndDate;

    private BigDecimal nTgtFld3;

    private String resolveWay;

    private String modfResolveWay;

    private String accountName;

    private String accountNo;

    private String payeeBankCityCode;

    private String payeeBankCity;

    private String payeeBankCode;

    private String payeeBankName;

    private String bankCode;

    private String bankBranchName;

    private BigDecimal modfNTgtFld3;

    private String endorNo;

    private String billNo;

    private String modfBillNo;

    private String pubBanksUrid;

    private String lossType;

    private String pubStandardareasUrid;

    private String cla;

    private String bankPayType;

    private String payeeType;

    private String feeDescription;

    private String payee;

    private String haApproveStatus;

    private Date haApproveTime;

    private String haApproveUser;

    private String haApproveRemark;

    private String haReceiptsPaymentNumber;

    //退保原因
    private String surrendReason;

    public String getSurrendReason() {
        return surrendReason;
    }

    public void setSurrendReason(String surrendReason) {
        this.surrendReason = surrendReason;
    }

    public String getPmrSerno() {
        return pmrSerno;
    }

    public void setPmrSerno(String pmrSerno) {
        this.pmrSerno = pmrSerno == null ? null : pmrSerno.trim();
    }

    public String getCoverSerno() {
        return coverSerno;
    }

    public void setCoverSerno(String coverSerno) {
        this.coverSerno = coverSerno == null ? null : coverSerno.trim();
    }

    public String getListSerno() {
        return listSerno;
    }

    public void setListSerno(String listSerno) {
        this.listSerno = listSerno == null ? null : listSerno.trim();
    }

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo == null ? null : contNo.trim();
    }

    public String getCoverStartDate() {
        return coverStartDate;
    }

    public void setCoverStartDate(String coverStartDate) {
        this.coverStartDate = coverStartDate == null ? null : coverStartDate.trim();
    }

    public String getCoverEndDate() {
        return coverEndDate;
    }

    public void setCoverEndDate(String coverEndDate) {
        this.coverEndDate = coverEndDate == null ? null : coverEndDate.trim();
    }

    public BigDecimal getCoverAmount() {
        return coverAmount;
    }

    public void setCoverAmount(BigDecimal coverAmount) {
        this.coverAmount = coverAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTerm() {
        return term;
    }

    public void setTerm(BigDecimal term) {
        this.term = term;
    }

    public String getModfDate() {
        return modfDate;
    }

    public void setModfDate(String modfDate) {
        this.modfDate = modfDate == null ? null : modfDate.trim();
    }

    public BigDecimal getModfAmount() {
        return modfAmount;
    }

    public void setModfAmount(BigDecimal modfAmount) {
        this.modfAmount = modfAmount;
    }

    public String getPolStartDate() {
        return polStartDate;
    }

    public void setPolStartDate(String polStartDate) {
        this.polStartDate = polStartDate == null ? null : polStartDate.trim();
    }

    public String getUpUsId() {
        return upUsId;
    }

    public void setUpUsId(String upUsId) {
        this.upUsId = upUsId == null ? null : upUsId.trim();
    }

    public String getUpBrId() {
        return upBrId;
    }

    public void setUpBrId(String upBrId) {
        this.upBrId = upBrId == null ? null : upBrId.trim();
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime == null ? null : upTime.trim();
    }

    public String getIqpLoanSerno() {
        return iqpLoanSerno;
    }

    public void setIqpLoanSerno(String iqpLoanSerno) {
        this.iqpLoanSerno = iqpLoanSerno == null ? null : iqpLoanSerno.trim();
    }

    public BigDecimal getCoverageFee() {
        return coverageFee;
    }

    public void setCoverageFee(BigDecimal coverageFee) {
        this.coverageFee = coverageFee;
    }

    public BigDecimal getModfCoverageFee() {
        return modfCoverageFee;
    }

    public void setModfCoverageFee(BigDecimal modfCoverageFee) {
        this.modfCoverageFee = modfCoverageFee;
    }

    public String getCoverCreateStatus() {
        return coverCreateStatus;
    }

    public void setCoverCreateStatus(String coverCreateStatus) {
        this.coverCreateStatus = coverCreateStatus == null ? null : coverCreateStatus.trim();
    }

    public String getModfCoverCreateStatus() {
        return modfCoverCreateStatus;
    }

    public void setModfCoverCreateStatus(String modfCoverCreateStatus) {
        this.modfCoverCreateStatus = modfCoverCreateStatus == null ? null : modfCoverCreateStatus.trim();
    }

    public String getEffectStatus() {
        return effectStatus;
    }

    public void setEffectStatus(String effectStatus) {
        this.effectStatus = effectStatus == null ? null : effectStatus.trim();
    }

    public String getEndorsementSerno() {
        return endorsementSerno;
    }

    public void setEndorsementSerno(String endorsementSerno) {
        this.endorsementSerno = endorsementSerno == null ? null : endorsementSerno.trim();
    }

    public String getPkIdOrig() {
        return pkIdOrig;
    }

    public void setPkIdOrig(String pkIdOrig) {
        this.pkIdOrig = pkIdOrig == null ? null : pkIdOrig.trim();
    }

    public String getPkIdCurr() {
        return pkIdCurr;
    }

    public void setPkIdCurr(String pkIdCurr) {
        this.pkIdCurr = pkIdCurr == null ? null : pkIdCurr.trim();
    }

    public BigDecimal getRateOrig() {
        return rateOrig;
    }

    public void setRateOrig(BigDecimal rateOrig) {
        this.rateOrig = rateOrig;
    }

    public BigDecimal getRateCurr() {
        return rateCurr;
    }

    public void setRateCurr(BigDecimal rateCurr) {
        this.rateCurr = rateCurr;
    }

    public BigDecimal getExcuseRateOrig() {
        return excuseRateOrig;
    }

    public void setExcuseRateOrig(BigDecimal excuseRateOrig) {
        this.excuseRateOrig = excuseRateOrig;
    }

    public BigDecimal getExcuseRateCurr() {
        return excuseRateCurr;
    }

    public void setExcuseRateCurr(BigDecimal excuseRateCurr) {
        this.excuseRateCurr = excuseRateCurr;
    }

    public String getcAppntOrig() {
        return cAppntOrig;
    }

    public void setcAppntOrig(String cAppntOrig) {
        this.cAppntOrig = cAppntOrig == null ? null : cAppntOrig.trim();
    }

    public String getcAppntCurr() {
        return cAppntCurr;
    }

    public void setcAppntCurr(String cAppntCurr) {
        this.cAppntCurr = cAppntCurr == null ? null : cAppntCurr.trim();
    }

    public BigDecimal getCoverAmountDiff() {
        return coverAmountDiff;
    }

    public void setCoverAmountDiff(BigDecimal coverAmountDiff) {
        this.coverAmountDiff = coverAmountDiff;
    }

    public BigDecimal getCoverageFeeDiff() {
        return coverageFeeDiff;
    }

    public void setCoverageFeeDiff(BigDecimal coverageFeeDiff) {
        this.coverageFeeDiff = coverageFeeDiff;
    }

    public String getEndorsementReason() {
        return endorsementReason;
    }

    public void setEndorsementReason(String endorsementReason) {
        this.endorsementReason = endorsementReason == null ? null : endorsementReason.trim();
    }

    public String getEndorsementContent() {
        return endorsementContent;
    }

    public void setEndorsementContent(String endorsementContent) {
        this.endorsementContent = endorsementContent == null ? null : endorsementContent.trim();
    }

    public String getBizMode() {
        return bizMode;
    }

    public void setBizMode(String bizMode) {
        this.bizMode = bizMode == null ? null : bizMode.trim();
    }

    public String getReceiveCusName() {
        return receiveCusName;
    }

    public void setReceiveCusName(String receiveCusName) {
        this.receiveCusName = receiveCusName == null ? null : receiveCusName.trim();
    }

    public String getReceiverCusId() {
        return receiverCusId;
    }

    public void setReceiverCusId(String receiverCusId) {
        this.receiverCusId = receiverCusId == null ? null : receiverCusId.trim();
    }

    public String getBelongBrId() {
        return belongBrId;
    }

    public void setBelongBrId(String belongBrId) {
        this.belongBrId = belongBrId == null ? null : belongBrId.trim();
    }

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId == null ? null : prdId.trim();
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName == null ? null : prdName.trim();
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId == null ? null : applyUserId.trim();
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate == null ? null : applyDate.trim();
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType == null ? null : cusType.trim();
    }

    public String getLstiqpSerno() {
        return lstiqpSerno;
    }

    public void setLstiqpSerno(String lstiqpSerno) {
        this.lstiqpSerno = lstiqpSerno == null ? null : lstiqpSerno.trim();
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey == null ? null : foreignKey.trim();
    }

    public String getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId == null ? null : checkUserId.trim();
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime == null ? null : checkTime.trim();
    }

    public String getModType() {
        return modType;
    }

    public void setModType(String modType) {
        this.modType = modType == null ? null : modType.trim();
    }

    public String getInputBrId() {
        return inputBrId;
    }

    public void setInputBrId(String inputBrId) {
        this.inputBrId = inputBrId == null ? null : inputBrId.trim();
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus == null ? null : approveStatus.trim();
    }

    public String getModfContNo() {
        return modfContNo;
    }

    public void setModfContNo(String modfContNo) {
        this.modfContNo = modfContNo == null ? null : modfContNo.trim();
    }

    public BigDecimal getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(BigDecimal newAmount) {
        this.newAmount = newAmount;
    }

    public String getModfReceiveCusName() {
        return modfReceiveCusName;
    }

    public void setModfReceiveCusName(String modfReceiveCusName) {
        this.modfReceiveCusName = modfReceiveCusName == null ? null : modfReceiveCusName.trim();
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    public String getModfCusName() {
        return modfCusName;
    }

    public void setModfCusName(String modfCusName) {
        this.modfCusName = modfCusName == null ? null : modfCusName.trim();
    }

    public String getCoreAppSerno() {
        return coreAppSerno;
    }

    public void setCoreAppSerno(String coreAppSerno) {
        this.coreAppSerno = coreAppSerno == null ? null : coreAppSerno.trim();
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode == null ? null : certCode.trim();
    }

    public String getModfCertCode() {
        return modfCertCode;
    }

    public void setModfCertCode(String modfCertCode) {
        this.modfCertCode = modfCertCode == null ? null : modfCertCode.trim();
    }

    public String getIndivSex() {
        return indivSex;
    }

    public void setIndivSex(String indivSex) {
        this.indivSex = indivSex == null ? null : indivSex.trim();
    }

    public String getModfIndivSex() {
        return modfIndivSex;
    }

    public void setModfIndivSex(String modfIndivSex) {
        this.modfIndivSex = modfIndivSex == null ? null : modfIndivSex.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getModfMobile() {
        return modfMobile;
    }

    public void setModfMobile(String modfMobile) {
        this.modfMobile = modfMobile == null ? null : modfMobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getModfAddress() {
        return modfAddress;
    }

    public void setModfAddress(String modfAddress) {
        this.modfAddress = modfAddress == null ? null : modfAddress.trim();
    }

    public String getReceiveCusCertCode() {
        return receiveCusCertCode;
    }

    public void setReceiveCusCertCode(String receiveCusCertCode) {
        this.receiveCusCertCode = receiveCusCertCode == null ? null : receiveCusCertCode.trim();
    }

    public String getModfReceiveCusCertCode() {
        return modfReceiveCusCertCode;
    }

    public void setModfReceiveCusCertCode(String modfReceiveCusCertCode) {
        this.modfReceiveCusCertCode = modfReceiveCusCertCode == null ? null : modfReceiveCusCertCode.trim();
    }

    public String getReceiveCusPhone() {
        return receiveCusPhone;
    }

    public void setReceiveCusPhone(String receiveCusPhone) {
        this.receiveCusPhone = receiveCusPhone == null ? null : receiveCusPhone.trim();
    }

    public String getModfReceiveCusPhone() {
        return modfReceiveCusPhone;
    }

    public void setModfReceiveCusPhone(String modfReceiveCusPhone) {
        this.modfReceiveCusPhone = modfReceiveCusPhone == null ? null : modfReceiveCusPhone.trim();
    }

    public String getReceiveCusCertType() {
        return receiveCusCertType;
    }

    public void setReceiveCusCertType(String receiveCusCertType) {
        this.receiveCusCertType = receiveCusCertType == null ? null : receiveCusCertType.trim();
    }

    public String getModfReceiveCusCertType() {
        return modfReceiveCusCertType;
    }

    public void setModfReceiveCusCertType(String modfReceiveCusCertType) {
        this.modfReceiveCusCertType = modfReceiveCusCertType == null ? null : modfReceiveCusCertType.trim();
    }

    public String getReceiverCusAddress() {
        return receiverCusAddress;
    }

    public void setReceiverCusAddress(String receiverCusAddress) {
        this.receiverCusAddress = receiverCusAddress == null ? null : receiverCusAddress.trim();
    }

    public String getModfReceiverCusAddress() {
        return modfReceiverCusAddress;
    }

    public void setModfReceiverCusAddress(String modfReceiverCusAddress) {
        this.modfReceiverCusAddress = modfReceiverCusAddress == null ? null : modfReceiverCusAddress.trim();
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    public String getModfLegalName() {
        return modfLegalName;
    }

    public void setModfLegalName(String modfLegalName) {
        this.modfLegalName = modfLegalName == null ? null : modfLegalName.trim();
    }

    public String getLegalCertCode() {
        return legalCertCode;
    }

    public void setLegalCertCode(String legalCertCode) {
        this.legalCertCode = legalCertCode == null ? null : legalCertCode.trim();
    }

    public String getModfLegalCertCode() {
        return modfLegalCertCode;
    }

    public void setModfLegalCertCode(String modfLegalCertCode) {
        this.modfLegalCertCode = modfLegalCertCode == null ? null : modfLegalCertCode.trim();
    }

    public String getModfLegalHomeAddr() {
        return modfLegalHomeAddr;
    }

    public void setModfLegalHomeAddr(String modfLegalHomeAddr) {
        this.modfLegalHomeAddr = modfLegalHomeAddr == null ? null : modfLegalHomeAddr.trim();
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    public String getModfInsuranceType() {
        return modfInsuranceType;
    }

    public void setModfInsuranceType(String modfInsuranceType) {
        this.modfInsuranceType = modfInsuranceType == null ? null : modfInsuranceType.trim();
    }

    public String getLegalHomeAddr() {
        return legalHomeAddr;
    }

    public void setLegalHomeAddr(String legalHomeAddr) {
        this.legalHomeAddr = legalHomeAddr == null ? null : legalHomeAddr.trim();
    }

    public String getcUniversityAdd() {
        return cUniversityAdd;
    }

    public void setcUniversityAdd(String cUniversityAdd) {
        this.cUniversityAdd = cUniversityAdd == null ? null : cUniversityAdd.trim();
    }

    public String getcUniversityName() {
        return cUniversityName;
    }

    public void setcUniversityName(String cUniversityName) {
        this.cUniversityName = cUniversityName == null ? null : cUniversityName.trim();
    }

    public String getcDepartmentName() {
        return cDepartmentName;
    }

    public void setcDepartmentName(String cDepartmentName) {
        this.cDepartmentName = cDepartmentName == null ? null : cDepartmentName.trim();
    }

    public String getcClassName() {
        return cClassName;
    }

    public void setcClassName(String cClassName) {
        this.cClassName = cClassName == null ? null : cClassName.trim();
    }

    public String getcTgtFld8() {
        return cTgtFld8;
    }

    public void setcTgtFld8(String cTgtFld8) {
        this.cTgtFld8 = cTgtFld8 == null ? null : cTgtFld8.trim();
    }

    public BigDecimal getnTgtFld3Fld8() {
        return nTgtFld3Fld8;
    }

    public void setnTgtFld3Fld8(BigDecimal nTgtFld3Fld8) {
        this.nTgtFld3Fld8 = nTgtFld3Fld8;
    }

    public BigDecimal getcPcurCnm() {
        return cPcurCnm;
    }

    public void setcPcurCnm(BigDecimal cPcurCnm) {
        this.cPcurCnm = cPcurCnm;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public String getModfCUniversityAdd() {
        return modfCUniversityAdd;
    }

    public void setModfCUniversityAdd(String modfCUniversityAdd) {
        this.modfCUniversityAdd = modfCUniversityAdd == null ? null : modfCUniversityAdd.trim();
    }

    public String getModfCUniversityName() {
        return modfCUniversityName;
    }

    public void setModfCUniversityName(String modfCUniversityName) {
        this.modfCUniversityName = modfCUniversityName == null ? null : modfCUniversityName.trim();
    }

    public String getModfCDepartmentName() {
        return modfCDepartmentName;
    }

    public void setModfCDepartmentName(String modfCDepartmentName) {
        this.modfCDepartmentName = modfCDepartmentName == null ? null : modfCDepartmentName.trim();
    }

    public String getModfCClassName() {
        return modfCClassName;
    }

    public void setModfCClassName(String modfCClassName) {
        this.modfCClassName = modfCClassName == null ? null : modfCClassName.trim();
    }

    public Integer getModfPersonCount() {
        return modfPersonCount;
    }

    public void setModfPersonCount(Integer modfPersonCount) {
        this.modfPersonCount = modfPersonCount;
    }

    public BigDecimal getModfCPcurCnm() {
        return modfCPcurCnm;
    }

    public void setModfCPcurCnm(BigDecimal modfCPcurCnm) {
        this.modfCPcurCnm = modfCPcurCnm;
    }

    public String getModfCTgtFld8() {
        return modfCTgtFld8;
    }

    public void setModfCTgtFld8(String modfCTgtFld8) {
        this.modfCTgtFld8 = modfCTgtFld8 == null ? null : modfCTgtFld8.trim();
    }

    public String getModfCoverEndDate() {
        return modfCoverEndDate;
    }

    public void setModfCoverEndDate(String modfCoverEndDate) {
        this.modfCoverEndDate = modfCoverEndDate == null ? null : modfCoverEndDate.trim();
    }

    public BigDecimal getnTgtFld3() {
        return nTgtFld3;
    }

    public void setnTgtFld3(BigDecimal nTgtFld3) {
        this.nTgtFld3 = nTgtFld3;
    }

    public String getResolveWay() {
        return resolveWay;
    }

    public void setResolveWay(String resolveWay) {
        this.resolveWay = resolveWay == null ? null : resolveWay.trim();
    }

    public String getModfResolveWay() {
        return modfResolveWay;
    }

    public void setModfResolveWay(String modfResolveWay) {
        this.modfResolveWay = modfResolveWay == null ? null : modfResolveWay.trim();
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

    public BigDecimal getModfNTgtFld3() {
        return modfNTgtFld3;
    }

    public void setModfNTgtFld3(BigDecimal modfNTgtFld3) {
        this.modfNTgtFld3 = modfNTgtFld3;
    }

    public String getEndorNo() {
        return endorNo;
    }

    public void setEndorNo(String endorNo) {
        this.endorNo = endorNo == null ? null : endorNo.trim();
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getModfBillNo() {
        return modfBillNo;
    }

    public void setModfBillNo(String modfBillNo) {
        this.modfBillNo = modfBillNo == null ? null : modfBillNo.trim();
    }

    public String getPubBanksUrid() {
        return pubBanksUrid;
    }

    public void setPubBanksUrid(String pubBanksUrid) {
        this.pubBanksUrid = pubBanksUrid == null ? null : pubBanksUrid.trim();
    }

    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType == null ? null : lossType.trim();
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

    public String getFeeDescription() {
        return feeDescription;
    }

    public void setFeeDescription(String feeDescription) {
        this.feeDescription = feeDescription == null ? null : feeDescription.trim();
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee == null ? null : payee.trim();
    }

    public String getHaApproveStatus() {
        return haApproveStatus;
    }

    public void setHaApproveStatus(String haApproveStatus) {
        this.haApproveStatus = haApproveStatus == null ? null : haApproveStatus.trim();
    }

    public Date getHaApproveTime() {
        return haApproveTime;
    }

    public void setHaApproveTime(Date haApproveTime) {
        this.haApproveTime = haApproveTime;
    }

    public String getHaApproveUser() {
        return haApproveUser;
    }

    public void setHaApproveUser(String haApproveUser) {
        this.haApproveUser = haApproveUser == null ? null : haApproveUser.trim();
    }

    public String getHaApproveRemark() {
        return haApproveRemark;
    }

    public void setHaApproveRemark(String haApproveRemark) {
        this.haApproveRemark = haApproveRemark == null ? null : haApproveRemark.trim();
    }

    public String getHaReceiptsPaymentNumber() {
        return haReceiptsPaymentNumber;
    }

    public void setHaReceiptsPaymentNumber(String haReceiptsPaymentNumber) {
        this.haReceiptsPaymentNumber = haReceiptsPaymentNumber == null ? null : haReceiptsPaymentNumber.trim();
    }
}