package cn.com.sinosafe.domain.entity;

public class IqpMeInsured {
    private String insuredName;

    private String insuredAddress;

    private String insuredPhone;

    private String insuredCertCode;

    private String insuredId;
    
    private Long pNo;

    private String serno;

    public Long getpNo() {
		return pNo;
	}

	public void setpNo(Long pNo) {
		this.pNo = pNo;
	}

	public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno == null ? null : serno.trim();
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName == null ? null : insuredName.trim();
    }

    public String getInsuredAddress() {
        return insuredAddress;
    }

    public void setInsuredAddress(String insuredAddress) {
        this.insuredAddress = insuredAddress == null ? null : insuredAddress.trim();
    }

    public String getInsuredPhone() {
        return insuredPhone;
    }

    public void setInsuredPhone(String insuredPhone) {
        this.insuredPhone = insuredPhone == null ? null : insuredPhone.trim();
    }

    public String getInsuredCertCode() {
        return insuredCertCode;
    }

    public void setInsuredCertCode(String insuredCertCode) {
        this.insuredCertCode = insuredCertCode == null ? null : insuredCertCode.trim();
    }

    public String getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(String insuredId) {
        this.insuredId = insuredId == null ? null : insuredId.trim();
    }
}