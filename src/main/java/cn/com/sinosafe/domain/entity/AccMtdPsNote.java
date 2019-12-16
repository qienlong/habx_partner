package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class AccMtdPsNote {
    /**
     * 主键
     */
    private String pkId;

    /**
     * 银行/冲账流水号
     */
    private String bankSerno;

    /**
     * 借据号
     */
    private String billNo;

    /**
     * 期号
     */
    private Short psPerdNo;

    /**
     * 实际还款日期
     */
    private String psRealDt;

    /**
     * 应还罚息
     */
    private BigDecimal psOdIntAmt;

    /**
     * 应还复利
     */
    private BigDecimal psCommOdInt;

    /**
     * 实际还款本金
     */
    private BigDecimal psRealPrcpAmt;

    /**
     * 实际还款利息
     */
    private BigDecimal psRealIntAmt;

    /**
     * 实还罚息
     */
    private BigDecimal setlOdIncTaken;

    /**
     * 实还复利
     */
    private BigDecimal setlCommOdInt;

    /**
     * 摘要
     */
    private String abstract_;

    /**
     * 更新方式
     */
    private String updateWay;

    /**
     * 录入时间
     */
    private String inputDate;

    /**
     * 录入人
     */
    private String inputId;

    /**
     * 录入机构
     */
    private String inputBrId;

    /**
     * null
     */
    private String remark;

    /**
     * null
     */
    private String psRealSource;

    /**
     * 冲减日期
     */
    private String downsDate;

    /**
     * null
     */
    private String inputDate1;

    /**
     * 主键
     * @return PK_ID 主键
     */
    public String getPkId() {
        return pkId;
    }

    /**
     * 主键
     * @param pkId 主键
     */
    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    /**
     * 银行/冲账流水号
     * @return BANK_SERNO 银行/冲账流水号
     */
    public String getBankSerno() {
        return bankSerno;
    }

    /**
     * 银行/冲账流水号
     * @param bankSerno 银行/冲账流水号
     */
    public void setBankSerno(String bankSerno) {
        this.bankSerno = bankSerno == null ? null : bankSerno.trim();
    }

    /**
     * 借据号
     * @return BILL_NO 借据号
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * 借据号
     * @param billNo 借据号
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    /**
     * 期号
     * @return PS_PERD_NO 期号
     */
    public Short getPsPerdNo() {
        return psPerdNo;
    }

    /**
     * 期号
     * @param psPerdNo 期号
     */
    public void setPsPerdNo(Short psPerdNo) {
        this.psPerdNo = psPerdNo;
    }

    /**
     * 实际还款日期
     * @return PS_REAL_DT 实际还款日期
     */
    public String getPsRealDt() {
        return psRealDt;
    }

    /**
     * 实际还款日期
     * @param psRealDt 实际还款日期
     */
    public void setPsRealDt(String psRealDt) {
        this.psRealDt = psRealDt == null ? null : psRealDt.trim();
    }

    /**
     * 应还罚息
     * @return PS_OD_INT_AMT 应还罚息
     */
    public BigDecimal getPsOdIntAmt() {
        return psOdIntAmt;
    }

    /**
     * 应还罚息
     * @param psOdIntAmt 应还罚息
     */
    public void setPsOdIntAmt(BigDecimal psOdIntAmt) {
        this.psOdIntAmt = psOdIntAmt;
    }

    /**
     * 应还复利
     * @return PS_COMM_OD_INT 应还复利
     */
    public BigDecimal getPsCommOdInt() {
        return psCommOdInt;
    }

    /**
     * 应还复利
     * @param psCommOdInt 应还复利
     */
    public void setPsCommOdInt(BigDecimal psCommOdInt) {
        this.psCommOdInt = psCommOdInt;
    }

    /**
     * 实际还款本金
     * @return PS_REAL_PRCP_AMT 实际还款本金
     */
    public BigDecimal getPsRealPrcpAmt() {
        return psRealPrcpAmt;
    }

    /**
     * 实际还款本金
     * @param psRealPrcpAmt 实际还款本金
     */
    public void setPsRealPrcpAmt(BigDecimal psRealPrcpAmt) {
        this.psRealPrcpAmt = psRealPrcpAmt;
    }

    /**
     * 实际还款利息
     * @return PS_REAL_INT_AMT 实际还款利息
     */
    public BigDecimal getPsRealIntAmt() {
        return psRealIntAmt;
    }

    /**
     * 实际还款利息
     * @param psRealIntAmt 实际还款利息
     */
    public void setPsRealIntAmt(BigDecimal psRealIntAmt) {
        this.psRealIntAmt = psRealIntAmt;
    }

    /**
     * 实还罚息
     * @return SETL_OD_INC_TAKEN 实还罚息
     */
    public BigDecimal getSetlOdIncTaken() {
        return setlOdIncTaken;
    }

    /**
     * 实还罚息
     * @param setlOdIncTaken 实还罚息
     */
    public void setSetlOdIncTaken(BigDecimal setlOdIncTaken) {
        this.setlOdIncTaken = setlOdIncTaken;
    }

    /**
     * 实还复利
     * @return SETL_COMM_OD_INT 实还复利
     */
    public BigDecimal getSetlCommOdInt() {
        return setlCommOdInt;
    }

    /**
     * 实还复利
     * @param setlCommOdInt 实还复利
     */
    public void setSetlCommOdInt(BigDecimal setlCommOdInt) {
        this.setlCommOdInt = setlCommOdInt;
    }

    /**
     * 摘要
     * @return ABSTRACT 摘要
     */
    public String getAbstract_() {
        return abstract_;
    }

    /**
     * 摘要
     * @param abstract 摘要
     */
    public void setAbstract_(String abstract_) {
        this.abstract_ = abstract_;
    }

    /**
     * 更新方式
     * @return UPDATE_WAY 更新方式
     */
    public String getUpdateWay() {
        return updateWay;
    }

    /**
     * 更新方式
     * @param updateWay 更新方式
     */
    public void setUpdateWay(String updateWay) {
        this.updateWay = updateWay == null ? null : updateWay.trim();
    }

    /**
     * 录入时间
     * @return INPUT_DATE 录入时间
     */
    public String getInputDate() {
        return inputDate;
    }

    /**
     * 录入时间
     * @param inputDate 录入时间
     */
    public void setInputDate(String inputDate) {
        this.inputDate = inputDate == null ? null : inputDate.trim();
    }

    /**
     * 录入人
     * @return INPUT_ID 录入人
     */
    public String getInputId() {
        return inputId;
    }

    /**
     * 录入人
     * @param inputId 录入人
     */
    public void setInputId(String inputId) {
        this.inputId = inputId == null ? null : inputId.trim();
    }

    /**
     * 录入机构
     * @return INPUT_BR_ID 录入机构
     */
    public String getInputBrId() {
        return inputBrId;
    }

    /**
     * 录入机构
     * @param inputBrId 录入机构
     */
    public void setInputBrId(String inputBrId) {
        this.inputBrId = inputBrId == null ? null : inputBrId.trim();
    }

    /**
     * null
     * @return REMARK null
     */
    public String getRemark() {
        return remark;
    }

    /**
     * null
     * @param remark null
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * null
     * @return PS_REAL_SOURCE null
     */
    public String getPsRealSource() {
        return psRealSource;
    }

    /**
     * null
     * @param psRealSource null
     */
    public void setPsRealSource(String psRealSource) {
        this.psRealSource = psRealSource == null ? null : psRealSource.trim();
    }

    /**
     * 冲减日期
     * @return DOWNS_DATE 冲减日期
     */
    public String getDownsDate() {
        return downsDate;
    }

    /**
     * 冲减日期
     * @param downsDate 冲减日期
     */
    public void setDownsDate(String downsDate) {
        this.downsDate = downsDate == null ? null : downsDate.trim();
    }

    /**
     * null
     * @return INPUT_DATE1 null
     */
    public String getInputDate1() {
        return inputDate1;
    }

    /**
     * null
     * @param inputDate1 null
     */
    public void setInputDate1(String inputDate1) {
        this.inputDate1 = inputDate1 == null ? null : inputDate1.trim();
    }
}