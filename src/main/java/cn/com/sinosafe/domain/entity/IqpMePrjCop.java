package cn.com.sinosafe.domain.entity;

public class IqpMePrjCop {
    private String copNo;

    private String copCusId;

    private String copCusName;

    private String copCertType;

    private String copCertCode;

    private String copCusType;

    private String bizCopType;
    
    private String pkId;

    private String serno;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    public String getCopNo() {
        return copNo;
    }

    public void setCopNo(String copNo) {
        this.copNo = copNo == null ? null : copNo.trim();
    }

    public String getCopCusId() {
        return copCusId;
    }

    public void setCopCusId(String copCusId) {
        this.copCusId = copCusId == null ? null : copCusId.trim();
    }

    public String getCopCusName() {
        return copCusName;
    }

    public void setCopCusName(String copCusName) {
        this.copCusName = copCusName == null ? null : copCusName.trim();
    }

    public String getCopCertType() {
        return copCertType;
    }

    public void setCopCertType(String copCertType) {
        this.copCertType = copCertType == null ? null : copCertType.trim();
    }

    public String getCopCertCode() {
        return copCertCode;
    }

    public void setCopCertCode(String copCertCode) {
        this.copCertCode = copCertCode == null ? null : copCertCode.trim();
    }

    public String getCopCusType() {
        return copCusType;
    }

    public void setCopCusType(String copCusType) {
        this.copCusType = copCusType == null ? null : copCusType.trim();
    }

    public String getBizCopType() {
        return bizCopType;
    }

    public void setBizCopType(String bizCopType) {
        this.bizCopType = bizCopType == null ? null : bizCopType.trim();
    }
}