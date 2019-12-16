package cn.com.sinosafe.domain.gbcn.queryInvoice;

import java.math.BigDecimal;
import java.util.Date;

public class InvoiceInfo {
    private String pkId;

    private String policyNo;

    private String appName;

    private String appEmail;

    private String appMobile;

    private String imgId;

    private String invoiceCode;

    private BigDecimal invoiceMoney;

    private String invoiceNumber;

    private String shorurl;

    private Date inputTime;

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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppEmail() {
        return appEmail;
    }

    public void setAppEmail(String appEmail) {
        this.appEmail = appEmail == null ? null : appEmail.trim();
    }

    public String getAppMobile() {
        return appMobile;
    }

    public void setAppMobile(String appMobile) {
        this.appMobile = appMobile == null ? null : appMobile.trim();
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    public BigDecimal getInvoiceMoney() {
        return invoiceMoney;
    }

    public void setInvoiceMoney(BigDecimal invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
    }

    public String getShorurl() {
        return shorurl;
    }

    public void setShorurl(String shorurl) {
        this.shorurl = shorurl == null ? null : shorurl.trim();
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }
}