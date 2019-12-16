package cn.com.sinosafe.domain.gbcn.correct;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 批改时间
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "dateInfo")
@XmlType(name = "dateInfo",propOrder = {"stratDate","endDate","tender"})
public class CorrectDateInfo implements Serializable {

    /**
     * 起保日期
     */
    @NotBlank
    private String stratDate;

    /**
     * 终保日期
     */
    @NotBlank
    private String endDate;

    /**
     * 保险期限
     */
    @NotBlank
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
