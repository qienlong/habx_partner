package cn.com.sinosafe.domain.gbcn.insure;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 投保人信息
 * @auther 林良
 * @Date 2019-08-30
 */
@XmlRootElement(name ="applicantInfo")
@XmlType(name = "applicantInfo",propOrder = {"name","mobile","idNumber","projectName","bidSectionCode",
        "tendereeName","tendereeCode","tendereeAddress","tendereePhoneNu"})
public class InsureApplicantInfo implements Serializable {

    /**
     * 投保人姓名
     */
    @NotBlank
    private String name;

    /**
     *投保人手机号码
     */
    @NotBlank
    private String mobile;

    /**
     * 投保人同意社会信用代码
     */
    @NotBlank
    private String idNumber;

    /**
     * 项目名称
     */
    @NotBlank
    private String projectName;

    /**
     * 项目标段编号
     */
    @NotBlank
    private String bidSectionCode;

    /**
     * 招标人名称
     */
    @NotBlank
    private String tendereeName;

    /**
     * 招标人统一社会信用证代码
     */
    @NotBlank
    private String tendereeCode;

    /**
     * 招标人地址
     */
    private String tendereeAddress;

    /**
     * 招标人联系电话
     */
    private String tendereePhoneNu;


    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    @XmlElement(name = "idNumber")
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    @XmlElement(name = "ProjectName")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    @XmlElement(name = "BidSectionCode")
    public void setBidSectionCode(String bidSectionCode) {
        this.bidSectionCode = bidSectionCode;
    }
    @XmlElement(name = "TendereeName")
    public void setTendereeName(String tendereeName) {
        this.tendereeName = tendereeName;
    }
    @XmlElement(name = "TendereeCode")
    public void setTendereeCode(String tendereeCode) {
        this.tendereeCode = tendereeCode;
    }
    @XmlElement(name = "TendereeAddress")
    public void setTendereeAddress(String tendereeAddress) {
        this.tendereeAddress = tendereeAddress;
    }
    @XmlElement(name = "TendereeContactPhoneNumber")
    public void setTendereePhoneNu(String tendereePhoneNu) {
        this.tendereePhoneNu = tendereePhoneNu;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getBidSectionCode() {
        return bidSectionCode;
    }

    public String getTendereeName() {
        return tendereeName;
    }

    public String getTendereeCode() {
        return tendereeCode;
    }

    public String getTendereeAddress() {
        return tendereeAddress;
    }

    public String getTendereePhoneNu() {
        return tendereePhoneNu;
    }
}
