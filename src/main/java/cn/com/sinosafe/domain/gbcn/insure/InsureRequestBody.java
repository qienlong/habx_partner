package cn.com.sinosafe.domain.gbcn.insure;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 投保请求内容
 * @auther 林良
 * @Date 2019-08-30
 */
@XmlRootElement(name ="requestBody")
@XmlType(name = "requestBody",propOrder = {"applicantInfo","policyInfo"})
public class InsureRequestBody implements Serializable {

    @Valid
    private InsureApplicantInfo applicantInfo;

    @Valid
    private InsurePolicyInfo policyInfo;

    public InsureApplicantInfo getApplicantInfo() {
        return applicantInfo;
    }

    public void setApplicantInfo(InsureApplicantInfo applicantInfo) {
        this.applicantInfo = applicantInfo;
    }

    public InsurePolicyInfo getPolicyInfo() {
        return policyInfo;
    }

    public void setPolicyInfo(InsurePolicyInfo policyInfo) {
        this.policyInfo = policyInfo;
    }
}
