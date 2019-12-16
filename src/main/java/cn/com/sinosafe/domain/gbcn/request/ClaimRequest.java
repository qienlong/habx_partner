package cn.com.sinosafe.domain.gbcn.request;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @version 1.0
 * @Description 工保发起理赔请求
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "claimRequest")
@XmlType(name = "claimRequest",propOrder = {"requestHead","requestBody"})
public class ClaimRequest{

    private RequestHead requestHead;

    private ClaimRequestBody requestBody;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public ClaimRequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(ClaimRequestBody requestBody) {
        this.requestBody = requestBody;
    }
    
    @XmlRootElement
    @XmlType(propOrder = {"policyno","claimName","claimPhone","cliaimReason","pkId","createTime","claimStatus"})
    public static class ClaimRequestBody {
        /**
         * 保单号
         */
        private String policyno;

        /**
         * 理赔人姓名
         */
        private String claimName;

        /**
         * 理赔人联系方式
         */
        private String claimPhone;

        /**
         * 理赔原因
         */
        private String cliaimReason;

        /**
         * uuid
         */
        private String pkId;

        /**
         * 申请时间
         */
        private String createTime;

        /**
         * 受理状态 0未受理 1受理中 2受理成功 3受理失败
         */
        private String claimStatus;

        public String getPolicyno() {
            return policyno;
        }

        public void setPolicyno(String policyno) {
            this.policyno = policyno;
        }

        public String getClaimName() {
            return claimName;
        }

        public void setClaimName(String claimName) {
            this.claimName = claimName;
        }

        public String getClaimPhone() {
            return claimPhone;
        }

        public void setClaimPhone(String claimPhone) {
            this.claimPhone = claimPhone;
        }

        public String getCliaimReason() {
            return cliaimReason;
        }

        public void setCliaimReason(String cliaimReason) {
            this.cliaimReason = cliaimReason;
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

        public String getClaimStatus() {
            return claimStatus;
        }

        public void setClaimStatus(String claimStatus) {
            this.claimStatus = claimStatus;
        }
    }

}
