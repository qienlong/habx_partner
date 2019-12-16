package cn.com.sinosafe.domain.gbcn.request;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "correctRequest")
@XmlType(name = "correctRequest",propOrder = {"requestHead","requestBody"})
public class CorrectRequest{

    private RequestHead requestHead;

    private CorrectRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public CorrectRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(CorrectRequestBody requestBody) {
        this.requestBody = requestBody;
    }
    
    @XmlRootElement(name = "requestBody")
    @XmlType(name = "requestBody",propOrder = {"isPtextFlag","endorseText","policyno","correctInfo"})
    public static class CorrectRequestBody{

        private String isPtextFlag;

        private String endorseText;

        private String policyno;

        private CorrectInfo correctInfo;

        public String getIsPtextFlag() {
            return isPtextFlag;
        }

        public void setIsPtextFlag(String isPtextFlag) {
            this.isPtextFlag = isPtextFlag;
        }

        public String getEndorseText() {
            return endorseText;
        }

        public void setEndorseText(String endorseText) {
            this.endorseText = endorseText;
        }

        public String getPolicyno() {
            return policyno;
        }

        public void setPolicyno(String policyno) {
            this.policyno = policyno;
        }

        public CorrectInfo getCorrectInfo() {
            return correctInfo;
        }

        public void setCorrectInfo(CorrectInfo correctInfo) {
            this.correctInfo = correctInfo;
        }
        
        @XmlRootElement
        @XmlType(propOrder = {"dateInfo","insuredInfo","baqRequiredInfo"})
        public static class CorrectInfo {

            private CorrectDateInfo dateInfo;

            private CorrectInsuredInfo insuredInfo;

            private CorrectBaqRequiredInfo baqRequiredInfo;

            public CorrectDateInfo getDateInfo() {
                return dateInfo;
            }

            public void setDateInfo(CorrectDateInfo dateInfo) {
                this.dateInfo = dateInfo;
            }

            public CorrectInsuredInfo getInsuredInfo() {
                return insuredInfo;
            }

            public void setInsuredInfo(CorrectInsuredInfo insuredInfo) {
                this.insuredInfo = insuredInfo;
            }

            public CorrectBaqRequiredInfo getBaqRequiredInfo() {
                return baqRequiredInfo;
            }

            public void setBaqRequiredInfo(CorrectBaqRequiredInfo baqRequiredInfo) {
                this.baqRequiredInfo = baqRequiredInfo;
            }
        }
        
        
        @XmlRootElement
        @XmlType(propOrder = {"stratDate","endDate","tender"})
        public static class CorrectDateInfo{

            private String stratDate;

            private String endDate;

            private String tender;

            public String getStratDate() {
                return stratDate;
            }

            public void setStratDate(String stratDate) {
                this.stratDate = stratDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public String getTender() {
                return tender;
            }

            public void setTender(String tender) {
                this.tender = tender;
            }
        }
        
        
        @XmlRootElement
        @XmlType(propOrder = {"name","idNumber","mobile"})
        public static class CorrectInsuredInfo{

            /**
             * 被保人姓名
             */
            private String name;

            /**
             * 被保人统一信用社会代码
             */
            private String idNumber;

            /**
             * 被保人手机号码
             */
            private String mobile;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIdNumber() {
                return idNumber;
            }

            public void setIdNumber(String idNumber) {
                this.idNumber = idNumber;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }
        }


        @XmlRootElement
        @XmlType(propOrder = {"projectName","projectNo","tendereeAddress"})
        public static class CorrectBaqRequiredInfo {

            /**
             * 招标项目名称
             */
            private String projectName;

            /**
             * 招标文件编号
             */
            private String projectNo;

            /**
             * 招标人地址
             */
            private String tendereeAddress;

            public String getProjectName() {
                return projectName;
            }

            public void setProjectName(String projectName) {
                this.projectName = projectName;
            }

            public String getProjectNo() {
                return projectNo;
            }

            public void setProjectNo(String projectNo) {
                this.projectNo = projectNo;
            }

            public String getTendereeAddress() {
                return tendereeAddress;
            }

            public void setTendereeAddress(String tendereeAddress) {
                this.tendereeAddress = tendereeAddress;
            }
        }

    }       
}
