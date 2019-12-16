package cn.com.sinosafe.domain.entity;

public class IqpMeChannelPrd {
    private String jrnNo;

    private String copNo;

    private String copNm;

    private String prdId;

    private String prdNm;

    private String status;

    private String begTm;

    private String endTm;

    private String creDt;

    private String uptDt;

    private String tmSmp;

    private String partnerNo;

    private String partnerNm;

    private String cAppnt;

    public String getJrnNo() {
        return jrnNo;
    }

    public void setJrnNo(String jrnNo) {
        this.jrnNo = jrnNo == null ? null : jrnNo.trim();
    }

    public String getCopNo() {
        return copNo;
    }

    public void setCopNo(String copNo) {
        this.copNo = copNo == null ? null : copNo.trim();
    }

    public String getCopNm() {
        return copNm;
    }

    public void setCopNm(String copNm) {
        this.copNm = copNm == null ? null : copNm.trim();
    }

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId == null ? null : prdId.trim();
    }

    public String getPrdNm() {
        return prdNm;
    }

    public void setPrdNm(String prdNm) {
        this.prdNm = prdNm == null ? null : prdNm.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBegTm() {
        return begTm;
    }

    public void setBegTm(String begTm) {
        this.begTm = begTm == null ? null : begTm.trim();
    }

    public String getEndTm() {
        return endTm;
    }

    public void setEndTm(String endTm) {
        this.endTm = endTm == null ? null : endTm.trim();
    }

    public String getCreDt() {
        return creDt;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt == null ? null : creDt.trim();
    }

    public String getUptDt() {
        return uptDt;
    }

    public void setUptDt(String uptDt) {
        this.uptDt = uptDt == null ? null : uptDt.trim();
    }

    public String getTmSmp() {
        return tmSmp;
    }

    public void setTmSmp(String tmSmp) {
        this.tmSmp = tmSmp == null ? null : tmSmp.trim();
    }

    public String getPartnerNo() {
        return partnerNo;
    }

    public void setPartnerNo(String partnerNo) {
        this.partnerNo = partnerNo == null ? null : partnerNo.trim();
    }

    public String getPartnerNm() {
        return partnerNm;
    }

    public void setPartnerNm(String partnerNm) {
        this.partnerNm = partnerNm == null ? null : partnerNm.trim();
    }

    public String getcAppnt() {
        return cAppnt;
    }

    public void setcAppnt(String cAppnt) {
        this.cAppnt = cAppnt == null ? null : cAppnt.trim();
    }
}