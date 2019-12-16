package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;

public class IqpMeProjectInfo {
    private String projectId;

    private String iqpSerno;

    private String ownerDetails;

    private String projectSubject;

    private String projectProperty;

    private String capitalSource;

    private String timeLimit;

    private String projectAddress;

    private String projectType;

    private String bidEvaluation;

    private String bidMode;

    private BigDecimal upperLimitPrice;

    private BigDecimal getBidPrice;

    private String getBidMode;

    private String getBidDate;

    private String bidNoticeNumber;

    private String contractNumber;

    private String guaranteeNumber;

    private String contractSignDate;

    private BigDecimal contraceTagPrice;

    private String pApproveName;

    private String pBidName;

    private String pBidValidDate;

    private BigDecimal pBidAssureAmount;

    private String projectOpenDate;

    private String projectProfile;

    private BigDecimal floatedRate;

    private String pUrl;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getIqpSerno() {
        return iqpSerno;
    }

    public void setIqpSerno(String iqpSerno) {
        this.iqpSerno = iqpSerno == null ? null : iqpSerno.trim();
    }

    public String getOwnerDetails() {
        return ownerDetails;
    }

    public void setOwnerDetails(String ownerDetails) {
        this.ownerDetails = ownerDetails == null ? null : ownerDetails.trim();
    }

    public String getProjectSubject() {
        return projectSubject;
    }

    public void setProjectSubject(String projectSubject) {
        this.projectSubject = projectSubject == null ? null : projectSubject.trim();
    }

    public String getProjectProperty() {
        return projectProperty;
    }

    public void setProjectProperty(String projectProperty) {
        this.projectProperty = projectProperty == null ? null : projectProperty.trim();
    }

    public String getCapitalSource() {
        return capitalSource;
    }

    public void setCapitalSource(String capitalSource) {
        this.capitalSource = capitalSource == null ? null : capitalSource.trim();
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit == null ? null : timeLimit.trim();
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getBidEvaluation() {
        return bidEvaluation;
    }

    public void setBidEvaluation(String bidEvaluation) {
        this.bidEvaluation = bidEvaluation == null ? null : bidEvaluation.trim();
    }

    public String getBidMode() {
        return bidMode;
    }

    public void setBidMode(String bidMode) {
        this.bidMode = bidMode == null ? null : bidMode.trim();
    }

    public BigDecimal getUpperLimitPrice() {
        return upperLimitPrice;
    }

    public void setUpperLimitPrice(BigDecimal upperLimitPrice) {
        this.upperLimitPrice = upperLimitPrice;
    }

    public BigDecimal getGetBidPrice() {
        return getBidPrice;
    }

    public void setGetBidPrice(BigDecimal getBidPrice) {
        this.getBidPrice = getBidPrice;
    }

    public String getGetBidMode() {
        return getBidMode;
    }

    public void setGetBidMode(String getBidMode) {
        this.getBidMode = getBidMode == null ? null : getBidMode.trim();
    }

    public String getGetBidDate() {
        return getBidDate;
    }

    public void setGetBidDate(String getBidDate) {
        this.getBidDate = getBidDate == null ? null : getBidDate.trim();
    }

    public String getBidNoticeNumber() {
        return bidNoticeNumber;
    }

    public void setBidNoticeNumber(String bidNoticeNumber) {
        this.bidNoticeNumber = bidNoticeNumber == null ? null : bidNoticeNumber.trim();
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public String getGuaranteeNumber() {
        return guaranteeNumber;
    }

    public void setGuaranteeNumber(String guaranteeNumber) {
        this.guaranteeNumber = guaranteeNumber == null ? null : guaranteeNumber.trim();
    }

    public String getContractSignDate() {
        return contractSignDate;
    }

    public void setContractSignDate(String contractSignDate) {
        this.contractSignDate = contractSignDate == null ? null : contractSignDate.trim();
    }

    public BigDecimal getContraceTagPrice() {
        return contraceTagPrice;
    }

    public void setContraceTagPrice(BigDecimal contraceTagPrice) {
        this.contraceTagPrice = contraceTagPrice;
    }

    public String getpApproveName() {
        return pApproveName;
    }

    public void setpApproveName(String pApproveName) {
        this.pApproveName = pApproveName == null ? null : pApproveName.trim();
    }

    public String getpBidName() {
        return pBidName;
    }

    public void setpBidName(String pBidName) {
        this.pBidName = pBidName == null ? null : pBidName.trim();
    }

    public String getpBidValidDate() {
        return pBidValidDate;
    }

    public void setpBidValidDate(String pBidValidDate) {
        this.pBidValidDate = pBidValidDate == null ? null : pBidValidDate.trim();
    }

    public BigDecimal getpBidAssureAmount() {
        return pBidAssureAmount;
    }

    public void setpBidAssureAmount(BigDecimal pBidAssureAmount) {
        this.pBidAssureAmount = pBidAssureAmount;
    }

    public String getProjectOpenDate() {
        return projectOpenDate;
    }

    public void setProjectOpenDate(String projectOpenDate) {
        this.projectOpenDate = projectOpenDate == null ? null : projectOpenDate.trim();
    }

    public String getProjectProfile() {
        return projectProfile;
    }

    public void setProjectProfile(String projectProfile) {
        this.projectProfile = projectProfile == null ? null : projectProfile.trim();
    }

    public BigDecimal getFloatedRate() {
        return floatedRate;
    }

    public void setFloatedRate(BigDecimal floatedRate) {
        this.floatedRate = floatedRate;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl == null ? null : pUrl.trim();
    }
}