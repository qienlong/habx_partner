package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

/**
 * ACC_FEE_MTD_PLAN
 * @author 
 */
public class AccFeeMtdPlan{
    /**
     * 投保单业务流水号
     */
    private String lstSerno;

    /**
     * 期号
     */
    private Short psPerdNo;

    /**
     * 借据号
     */
    private String billNo;

    /**
     * 费率
     */
    private BigDecimal rate;

    /**
     * 应收保费
     */
    private BigDecimal psCoverageFee;

    /**
     * 应还日期
     */
    private String psDueDt;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 实还日期
     */
    private String psRealDt;

    /**
     * 实还保费
     */
    private BigDecimal psRealPrcpAmt;

    /**
     * 状态(STD_FEE_REPAYPLAN_ST)
     */
    private String repayFlag;

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
     * 更新时间
     */
    private String updateDate;

    /**
     * 投保单编号
     */
    private String coverSerno;

    /**
     * 保单编号
     */
    private String listSerno;

    /**
     * 调查流水号
     */
    private String iqpLoanSerno;

    /**
     * 还款方式(STD_ZB_REPAY_MODE)
     */
    private String repaymentMode;

    /**
     * 支付方式(STD_FEE_REPAY_WAY)
     */
    private String payMode;

    private String inputTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 开票金额
     */
    private BigDecimal invoiceAmount;

    public String getLstSerno() {
        return lstSerno;
    }

    public void setLstSerno(String lstSerno) {
        this.lstSerno = lstSerno;
    }

    public Short getPsPerdNo() {
        return psPerdNo;
    }

    public void setPsPerdNo(Short psPerdNo) {
        this.psPerdNo = psPerdNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getPsCoverageFee() {
        return psCoverageFee;
    }

    public void setPsCoverageFee(BigDecimal psCoverageFee) {
        this.psCoverageFee = psCoverageFee;
    }

    public String getPsDueDt() {
        return psDueDt;
    }

    public void setPsDueDt(String psDueDt) {
        this.psDueDt = psDueDt;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPsRealDt() {
        return psRealDt;
    }

    public void setPsRealDt(String psRealDt) {
        this.psRealDt = psRealDt;
    }

    public BigDecimal getPsRealPrcpAmt() {
        return psRealPrcpAmt;
    }

    public void setPsRealPrcpAmt(BigDecimal psRealPrcpAmt) {
        this.psRealPrcpAmt = psRealPrcpAmt;
    }

    public String getRepayFlag() {
        return repayFlag;
    }

    public void setRepayFlag(String repayFlag) {
        this.repayFlag = repayFlag;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId;
    }

    public String getInputBrId() {
        return inputBrId;
    }

    public void setInputBrId(String inputBrId) {
        this.inputBrId = inputBrId;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCoverSerno() {
        return coverSerno;
    }

    public void setCoverSerno(String coverSerno) {
        this.coverSerno = coverSerno;
    }

    public String getListSerno() {
        return listSerno;
    }

    public void setListSerno(String listSerno) {
        this.listSerno = listSerno;
    }

    public String getIqpLoanSerno() {
        return iqpLoanSerno;
    }

    public void setIqpLoanSerno(String iqpLoanSerno) {
        this.iqpLoanSerno = iqpLoanSerno;
    }

    public String getRepaymentMode() {
        return repaymentMode;
    }

    public void setRepaymentMode(String repaymentMode) {
        this.repaymentMode = repaymentMode;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
}