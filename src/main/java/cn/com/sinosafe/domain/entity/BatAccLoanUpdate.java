package cn.com.sinosafe.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * BAT_ACC_LOAN_UPDATE
 * @author 
 */
public class BatAccLoanUpdate implements Serializable {
    /**
     * 借据号
     */
    private String billNo;

    /**
     * 贷款余额
     */
    private BigDecimal normalBalance;

    /**
     * 贷款五级分类
     */
    private String cla;

    /**
     * 贷款结清日期
     */
    private String settlDate;

    /**
     * 累计逾期次数
     */
    private Short overTimesTotal;

    /**
     * 连续逾期次数
     */
    private Short overTimesCurrent;

    /**
     * 连续逾期天数
     */
    private Short overTimesDays;

    /**
     * 逾期本金
     */
    private BigDecimal overdueCap;

    /**
     * 逾期利息
     */
    private BigDecimal overdueInt;

    /**
     * 逾期罚息
     */
    private BigDecimal overdueFineInt;

    private BigDecimal comInt;

    private BigDecimal baseRate;

    private BigDecimal exeRate;

    private String sources;

    private String synStatus;

    private String businessDate;

    private static final long serialVersionUID = 1L;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public BigDecimal getNormalBalance() {
        return normalBalance;
    }

    public void setNormalBalance(BigDecimal normalBalance) {
        this.normalBalance = normalBalance;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public String getSettlDate() {
        return settlDate;
    }

    public void setSettlDate(String settlDate) {
        this.settlDate = settlDate;
    }

    public Short getOverTimesTotal() {
        return overTimesTotal;
    }

    public void setOverTimesTotal(Short overTimesTotal) {
        this.overTimesTotal = overTimesTotal;
    }

    public Short getOverTimesCurrent() {
        return overTimesCurrent;
    }

    public void setOverTimesCurrent(Short overTimesCurrent) {
        this.overTimesCurrent = overTimesCurrent;
    }

    public Short getOverTimesDays() {
        return overTimesDays;
    }

    public void setOverTimesDays(Short overTimesDays) {
        this.overTimesDays = overTimesDays;
    }

    public BigDecimal getOverdueCap() {
        return overdueCap;
    }

    public void setOverdueCap(BigDecimal overdueCap) {
        this.overdueCap = overdueCap;
    }

    public BigDecimal getOverdueInt() {
        return overdueInt;
    }

    public void setOverdueInt(BigDecimal overdueInt) {
        this.overdueInt = overdueInt;
    }

    public BigDecimal getOverdueFineInt() {
        return overdueFineInt;
    }

    public void setOverdueFineInt(BigDecimal overdueFineInt) {
        this.overdueFineInt = overdueFineInt;
    }

    public BigDecimal getComInt() {
        return comInt;
    }

    public void setComInt(BigDecimal comInt) {
        this.comInt = comInt;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    public BigDecimal getExeRate() {
        return exeRate;
    }

    public void setExeRate(BigDecimal exeRate) {
        this.exeRate = exeRate;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getSynStatus() {
        return synStatus;
    }

    public void setSynStatus(String synStatus) {
        this.synStatus = synStatus;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }
}