package cn.com.sinosafe.domain.entity;

import java.util.Date;

/**
 * 电子发票表
 * @author FanKun
 * @date   2019年11月11日 下午3:11:04
 */
public class TElecPolicyInfo {
    private String pkId;

    private String policyNo;

    private String shortUrl;

    private Date inputTime;

    private String jsonBody;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId == null ? null : pkId.trim();
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo == null ? null : policyNo.trim();
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl == null ? null : shortUrl.trim();
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public String getJsonBody() {
        return jsonBody;
    }

    public void setJsonBody(String jsonBody) {
        this.jsonBody = jsonBody == null ? null : jsonBody.trim();
    }
}