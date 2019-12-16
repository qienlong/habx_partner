package cn.com.sinosafe.domain.gbcn.claim;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "requestBody")
@XmlType(name = "requestBody",propOrder = {"policyno","claimName","claimPhone","cliaimReason","pkId","createTime","claimStatus"})
public class ClaimRequestBody implements Serializable {

    /**
     * 保单号
     */
    @NotBlank
    private String policyno;

    /**
     * 理赔人姓名
     */
    @NotBlank
    private String claimName;

    /**
     * 理赔人联系方式
     */
    @NotBlank
    private String claimPhone;

    /**
     * 理赔原因
     */
    @NotBlank
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
