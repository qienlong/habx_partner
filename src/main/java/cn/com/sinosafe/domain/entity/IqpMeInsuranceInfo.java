package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class IqpMeInsuranceInfo {
    private String insuranceId;

    private String iqpSerno;

    private String insuranceType;

    private String insuranceTypeName;

    private BigDecimal insuranceAmount;

    private String insuranceStartTime;

    private String insuranceEndTime;

    private BigDecimal insuranceRate;

    private String insuranceStatus;

    private BigDecimal insuranceFee;

    private BigDecimal insuranceAmountSum;

    private Long insuranceAmountDay;

    private String sourceType;

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId == null ? null : insuranceId.trim();
    }

    public String getIqpSerno() {
        return iqpSerno;
    }

    public void setIqpSerno(String iqpSerno) {
        this.iqpSerno = iqpSerno == null ? null : iqpSerno.trim();
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    public String getInsuranceTypeName() {
        return insuranceTypeName;
    }

    public void setInsuranceTypeName(String insuranceTypeName) {
        this.insuranceTypeName = insuranceTypeName == null ? null : insuranceTypeName.trim();
    }

    public BigDecimal getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(BigDecimal insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public String getInsuranceStartTime() {
        return insuranceStartTime;
    }

    public void setInsuranceStartTime(String insuranceStartTime) {
        this.insuranceStartTime = insuranceStartTime == null ? null : insuranceStartTime.trim();
    }

    public String getInsuranceEndTime() {
        return insuranceEndTime;
    }

    public void setInsuranceEndTime(String insuranceEndTime) {
        this.insuranceEndTime = insuranceEndTime == null ? null : insuranceEndTime.trim();
    }

    public BigDecimal getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(BigDecimal insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    public String getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(String insuranceStatus) {
        this.insuranceStatus = insuranceStatus == null ? null : insuranceStatus.trim();
    }

    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public BigDecimal getInsuranceAmountSum() {
        return insuranceAmountSum;
    }

    public void setInsuranceAmountSum(BigDecimal insuranceAmountSum) {
        this.insuranceAmountSum = insuranceAmountSum;
    }

    public Long getInsuranceAmountDay() {
        return insuranceAmountDay;
    }

    public void setInsuranceAmountDay(Long insuranceAmountDay) {
        this.insuranceAmountDay = insuranceAmountDay;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }
}