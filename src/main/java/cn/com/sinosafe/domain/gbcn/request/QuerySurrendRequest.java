package cn.com.sinosafe.domain.gbcn.request;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cn.com.sinosafe.domain.gbcn.request.RequestHead;

@XmlRootElement(name = "querySurrendRequest")
@XmlType(name = "querySurrendRequest",propOrder = {"requestHead","requestBody"})
public class QuerySurrendRequest{

    private RequestHead requestHead;

    private QuerySurrendRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public QuerySurrendRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(QuerySurrendRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public QuerySurrendRequest() {
    }

    public QuerySurrendRequest(RequestHead requestHead, QuerySurrendRequestBody requestBody) {
        this.requestHead = requestHead;
        this.requestBody = requestBody;
    }
    
    
    @XmlRootElement(name = "requestBody")
    @XmlType(name = "requestBody",propOrder = {"policyNo","resultFlag","resultMessage","insuranceCode"})
    public static class QuerySurrendRequestBody{

        /**
         * 保单号
         */
        private String policyNo;

        /**
         * true成功 false失败
         */
        private boolean resultFlag;

        /**
         * 已退款至原账户/失败原因
         */
        private String resultMessage;

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

        public boolean isResultFlag() {
            return resultFlag;
        }

        public void setResultFlag(boolean resultFlag) {
            this.resultFlag = resultFlag;
        }

        public String getResultMessage() {
            return resultMessage;
        }

        public void setResultMessage(String resultMessage) {
            this.resultMessage = resultMessage;
        }

        public String getInsuranceCode() {
            return insuranceCode;
        }

        public void setInsuranceCode(String insuranceCode) {
            this.insuranceCode = insuranceCode;
        }

        public QuerySurrendRequestBody() {
        }

        public QuerySurrendRequestBody( String policyNo,  boolean resultFlag,  String resultMessage,  String insuranceCode) {
            this.policyNo = policyNo;
            this.resultFlag = resultFlag;
            this.resultMessage = resultMessage;
            this.insuranceCode = insuranceCode;
        }
}
}
