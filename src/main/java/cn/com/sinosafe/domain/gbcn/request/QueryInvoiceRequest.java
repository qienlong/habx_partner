package cn.com.sinosafe.domain.gbcn.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cn.com.sinosafe.domain.gbcn.request.RequestHead;

@XmlRootElement(name = "queryInvoiceRequest")
@XmlType(name = "queryInvoiceRequest",propOrder = {"requestHead","requestBody"})
public class QueryInvoiceRequest{

    private RequestHead requestHead;

    private QueryInvoiceRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public QueryInvoiceRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(QueryInvoiceRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public QueryInvoiceRequest() {
    }

    public QueryInvoiceRequest(RequestHead requestHead, QueryInvoiceRequestBody requestBody) {
        this.requestHead = requestHead;
        this.requestBody = requestBody;
    }
    
    @XmlRootElement(name = "requestBody")
    @XmlType(name = "requestBody",propOrder = {"policyNo","downLoadUrl","expressName","expressNo","insuranceCode"})
    public static class QueryInvoiceRequestBody{

        /**
         * 保单号
         */
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

        public QueryInvoiceRequestBody(String policyNo, String downLoadUrl, String expressName, String expressNo, @NotNull String insuranceCode) {
            this.policyNo = policyNo;
            this.downLoadUrl = downLoadUrl;
            this.expressName = expressName;
            this.expressNo = expressNo;
            this.insuranceCode = insuranceCode;
        }
    }

}
