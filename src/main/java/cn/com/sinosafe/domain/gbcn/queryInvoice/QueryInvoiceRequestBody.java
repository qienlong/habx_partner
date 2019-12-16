package cn.com.sinosafe.domain.gbcn.queryInvoice;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 发票信息回执给工保消息体
 * @auther 林良
 * @Date 2019-09-01
 */
@XmlRootElement(name = "requestBody")
@XmlType(name = "requestBody",propOrder = {"policyNo","downLoadUrl","expressName","expressNo","insuranceCode"})
public class QueryInvoiceRequestBody implements Serializable {

    /**
     * 保单号
     */
    @NotNull
    private String policyNo;

    /**
     * 电子发票下载地址 纸质发票无需返回
     */
    private String downLoadUrl;

    /**
     * 快递公司 电子发票无需返回
     */
    private String expressName;

    /**
     * 快递单号 电子发票无需返回
     */
    private String expressNo;

    /**
     * 保险公司代码
     */
    @NotNull
    private String insuranceCode;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getDownLoadUrl() {
        return downLoadUrl;
    }

    public void setDownLoadUrl(String downLoadUrl) {
        this.downLoadUrl = downLoadUrl;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    public QueryInvoiceRequestBody() {
    }

    public QueryInvoiceRequestBody(@NotNull String policyNo, String downLoadUrl, String expressName, String expressNo, @NotNull String insuranceCode) {
        this.policyNo = policyNo;
        this.downLoadUrl = downLoadUrl;
        this.expressName = expressName;
        this.expressNo = expressNo;
        this.insuranceCode = insuranceCode;
    }
}
