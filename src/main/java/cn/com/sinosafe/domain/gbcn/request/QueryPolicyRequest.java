package cn.com.sinosafe.domain.gbcn.request;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @version 1.0
 * @Description 华安发起保单缴纳情况回执
 * @auther 林良
 * @Date 2019-08-30
 */
@XmlRootElement(name = "queryPolicyRequest")
@XmlType(name = "queryPolicyRequest",propOrder = {"requestHead","requestBody"})
public class QueryPolicyRequest{

    /**
     * 回执头部
     */
    private RequestHead requestHead;

    /**
     * 回执信息体
     */
    private QueryPolicyRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public QueryPolicyRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(QueryPolicyRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public QueryPolicyRequest(RequestHead requestHead, QueryPolicyRequestBody requestBody) {
        this.requestHead = requestHead;
        this.requestBody = requestBody;
    }
    public QueryPolicyRequest() {
        this.requestHead = new RequestHead();
        this.requestBody = new QueryPolicyRequestBody();
    }
    
    @XmlRootElement(name = "requestBody")
    @XmlType(name = "requestBody",propOrder = {"policyNo","proposalNo","payType","payTime","insuranceCode","downLoadUrl","guaranteeUrl"})
    public static class QueryPolicyRequestBody{

        /**
         *保单号
         */
        private String policyNo;

        /**
         *投保单号
         */
        private String proposalNo;

        /**
         *支付方式 1微信 2支付宝 3网银
         */
        private String payType;

        /**
         *支付时间 yyyy-MM-dd HH:mm:ss
         */
        private String payTime;

        /**
         *保险公司代码
         */
        private String insuranceCode;

        /**
         *电子保单下载地址
         */
        private String downLoadUrl;

        /**
         *电子保函下载地址
         */
        private String guaranteeUrl;
        
        public String getPolicyNo() {
            return policyNo;
        }

        public void setPolicyNo(String policyNo) {
            this.policyNo = policyNo;
        }

        public String getProposalNo() {
            return proposalNo;
        }

        public void setProposalNo(String proposalNo) {
            this.proposalNo = proposalNo;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getPayTime() {
            return payTime;
        }

        public void setPayTime(String payTime) {
            this.payTime = payTime;
        }

        public String getInsuranceCode() {
            return insuranceCode;
        }

        public void setInsuranceCode(String insuranceCode) {
            this.insuranceCode = insuranceCode;
        }

        public String getDownLoadUrl() {
            return downLoadUrl;
        }

        public void setDownLoadUrl(String downLoadUrl) {
            this.downLoadUrl = downLoadUrl;
        }

        public String getGuaranteeUrl() {
            return guaranteeUrl;
        }

        public void setGuaranteeUrl(String guaranteeUrl) {
            this.guaranteeUrl = guaranteeUrl;
        }
        

		public QueryPolicyRequestBody() {
        }

        public QueryPolicyRequestBody( String policyNo,  String proposalNo,  String payType,  String payTime,  String insuranceCode,  String downLoadUrl, String guaranteeUrl) {
            this.policyNo = policyNo;
            this.proposalNo = proposalNo;
            this.payType = payType;
            this.payTime = payTime;
            this.insuranceCode = insuranceCode;
            this.downLoadUrl = downLoadUrl;
            this.guaranteeUrl = guaranteeUrl;
        }
    }
}
