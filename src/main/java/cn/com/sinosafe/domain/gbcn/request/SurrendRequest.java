package cn.com.sinosafe.domain.gbcn.request;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @version 1.0
 * @Description 工保发起退保请求
 * @auther 林良
 * @Date 2019-09-01
 */
@XmlRootElement(name = "surrendRequest")
@XmlType(name = "surrendRequest",propOrder = {"requestHead","requestBody"})
public class SurrendRequest {

    @Valid
    private RequestHead requestHead;

    @Valid
    private SurrendRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public SurrendRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(SurrendRequestBody requestBody) {
        this.requestBody = requestBody;
    }
    
    @XmlType(name = "requestBody",propOrder = {"policyno","policyReason",
            "accountNo","bankName","bankNo","pkId","createTime","surrendStatus"})
    public static class SurrendRequestBody{

        /**
         * 保单号
         */
        private String policyno;

        /**
         * 退保原因
         */
        private String policyReason;

        /**
         * 账户名
         */
        private String accountNo;

        /**
         * 退款账号开户行
         */
        private String bankName;

        /**
         * 退款账号
         */
        private String bankNo;

        /**
         * uuid主键
         */
        private String pkId;

        /**
         * 申请时间
         */
        private String createTime;

        /**
         * 退保状态 0代办 1已退保成功 2退保失败
         */
        private String surrendStatus;

        public String getPolicyno() {
            return policyno;
        }

        public void setPolicyno(String policyno) {
            this.policyno = policyno;
        }

        public String getPolicyReason() {
            return policyReason;
        }

        public void setPolicyReason(String policyReason) {
            this.policyReason = policyReason;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBankNo() {
            return bankNo;
        }

        public void setBankNo(String bankNo) {
            this.bankNo = bankNo;
        }

        public String getPkId() {
            return pkId;
        }

        public void setPkId(String pkId) {
            this.pkId = pkId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getSurrendStatus() {
            return surrendStatus;
        }

        public void setSurrendStatus(String surrendStatus) {
            this.surrendStatus = surrendStatus;
        }

        public SurrendRequestBody() {
        }

        public SurrendRequestBody(String policyno, String policyReason, String pkId, String createTime, String surrendStatus) {
            this.policyno = policyno;
            this.policyReason = policyReason;
            this.pkId = pkId;
            this.createTime = createTime;
            this.surrendStatus = surrendStatus;
        }
    }

}
