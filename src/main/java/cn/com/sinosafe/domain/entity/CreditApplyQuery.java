package cn.com.sinosafe.domain.entity;

public class CreditApplyQuery {
    private String pNo;

    private String serno;

    private String isQueryCredit;

    private String cusType;

    private String cusName;

    private String cusId;

    private String certType;

    private String certCode;

    private String isUpCredit;

    private String isGua;

    private String flag;

    private String onlineCache;

    private String businessRelations;

    private String creditCertCode;

    private String qryTime;

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo == null ? null : pNo.trim();
    }

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    public String getIsQueryCredit() {
        return isQueryCredit;
    }

    public void setIsQueryCredit(String isQueryCredit) {
        this.isQueryCredit = isQueryCredit == null ? null : isQueryCredit.trim();
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType == null ? null : cusType.trim();
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId == null ? null : cusId.trim();
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode == null ? null : certCode.trim();
    }

    public String getIsUpCredit() {
        return isUpCredit;
    }

    public void setIsUpCredit(String isUpCredit) {
        this.isUpCredit = isUpCredit == null ? null : isUpCredit.trim();
    }

    public String getIsGua() {
        return isGua;
    }

    public void setIsGua(String isGua) {
        this.isGua = isGua == null ? null : isGua.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getOnlineCache() {
        return onlineCache;
    }

    public void setOnlineCache(String onlineCache) {
        this.onlineCache = onlineCache == null ? null : onlineCache.trim();
    }

    public String getBusinessRelations() {
        return businessRelations;
    }

    public void setBusinessRelations(String businessRelations) {
        this.businessRelations = businessRelations == null ? null : businessRelations.trim();
    }

    public String getCreditCertCode() {
        return creditCertCode;
    }

    public void setCreditCertCode(String creditCertCode) {
        this.creditCertCode = creditCertCode == null ? null : creditCertCode.trim();
    }

    public String getQryTime() {
        return qryTime;
    }

    public void setQryTime(String qryTime) {
        this.qryTime = qryTime == null ? null : qryTime.trim();
    }
}