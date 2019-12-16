package cn.com.sinosafe.domain.gbcn.request;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cn.com.sinosafe.domain.gbcn.request.RequestHead;

@XmlRootElement(name = "invoiceRequest")
@XmlType(name = "invoiceRequest",propOrder = {"requestHead","requestBody"})
public class InvoiceRequest{

    private RequestHead requestHead;

    private InvoiceRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public InvoiceRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(InvoiceRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public InvoiceRequest() {
    }

    public InvoiceRequest(RequestHead requestHead, InvoiceRequestBody requestBody) {
        this.requestHead = requestHead;
        this.requestBody = requestBody;
    }
    
    
    @XmlRootElement(name = "requestBody")
    @XmlType(name = "requestBody",propOrder = {"policyno","invoiceType","invoiceHead","cuscCode","email","addressee",
                    "addresseePhone","address","addInfo","bankInfo","bankAcc","phoneNo","pkId","createTime","invoiceStatus"})
    public static class InvoiceRequestBody{

        /**
         *保单号
         */
        private String policyno;

        /**
         *发票类型 1 电子（普票） 2 纸质（普票） 3 纸质（专票）
         */
        private String invoiceType;

        /**
         *发票抬头
         */
        private String invoiceHead;

        /**
         *纳税人识别号
         */
        private String cuscCode;

        /**
         *电子邮箱 电子发票用字段
         */
        private String email;

        /**
         *收件人 纸质发票用字段
         */
        private String addressee;

        /**
         *收件人手机号 纸质发票用字段
         */
        private String addresseePhone;

        /**
         *收件地址 纸质发票用字段
         */
        private String address;

        /**
         *注册地址 专票用字段
         */
        private String addInfo;

        /**
         *开户行 专票用字段
         */
        private String bankInfo;

        /**
         *开户帐号 专票用字段
         */
        private String bankAcc;

        /**
         *联系电话 专票用字段
         */
        private String phoneNo;

        /**
         * uuid主键
         */
        private String pkId;

        /**
         * 申请时间
         */
        private String createTime;

        /**
         * 申请状态 0代办 1开票成功 2开票失败
         */
        private String invoiceStatus;

        @XmlElement(name = "policyno")
        public void setPolicyno(String policyno) {
            this.policyno = policyno;
        }

        @XmlElement(name = "InvoiceType")
        public void setInvoiceType(String invoiceType) {
            this.invoiceType = invoiceType;
        }

        @XmlElement(name = "InvoiceHead")
        public void setInvoiceHead(String invoiceHead) {
            this.invoiceHead = invoiceHead;
        }

        @XmlElement(name = "cuscCode")
        public void setCuscCode(String cuscCode) {
            this.cuscCode = cuscCode;
        }

        @XmlElement(name = "email")
        public void setEmail(String email) {
            this.email = email;
        }

        @XmlElement(name = "addressee")
        public void setAddressee(String addressee) {
            this.addressee = addressee;
        }

        @XmlElement(name = "addresseePhone")
        public void setAddresseePhone(String addresseePhone) {
            this.addresseePhone = addresseePhone;
        }

        @XmlElement(name = "address")
        public void setAddress(String address) {
            this.address = address;
        }

        @XmlElement(name = "addInfo")
        public void setAddInfo(String addInfo) {
            this.addInfo = addInfo;
        }

        @XmlElement(name = "bankInfo")
        public void setBankInfo(String bankInfo) {
            this.bankInfo = bankInfo;
        }

        @XmlElement(name = "bankAcc")
        public void setBankAcc(String bankAcc) {
            this.bankAcc = bankAcc;
        }

        @XmlElement(name = "phoneNo")
        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }


        public String getPolicyno() {
            return policyno;
        }

        public String getInvoiceType() {
            return invoiceType;
        }

        public String getInvoiceHead() {
            return invoiceHead;
        }

        public String getCuscCode() {
            return cuscCode;
        }

        public String getEmail() {
            return email;
        }

        public String getAddressee() {
            return addressee;
        }

        public String getAddresseePhone() {
            return addresseePhone;
        }

        public String getAddress() {
            return address;
        }

        public String getAddInfo() {
            return addInfo;
        }

        public String getBankInfo() {
            return bankInfo;
        }

        public String getBankAcc() {
            return bankAcc;
        }

        public String getPhoneNo() {
            return phoneNo;
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

        public String getInvoiceStatus() {
            return invoiceStatus;
        }

        public void setInvoiceStatus(String invoiceStatus) {
            this.invoiceStatus = invoiceStatus;
        }
    }

}
