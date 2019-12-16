package cn.com.sinosafe.domain.gbcn.correct;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description BAQ险种
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "baqRequiredInfo")
@XmlType(name = "baqRequiredInfo",propOrder = {"projectName","projectNo","tendereeAddress"})
public class CorrectBaqRequiredInfo implements Serializable {

    /**
     * 招标项目名称
     */
    @NotBlank
    private String projectName;

    /**
     * 招标文件编号
     */
    @NotBlank
    private String projectNo;

    /**
     * 招标人地址
     */
    @NotBlank
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
