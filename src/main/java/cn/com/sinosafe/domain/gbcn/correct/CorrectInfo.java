package cn.com.sinosafe.domain.gbcn.correct;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 批改信息
 * @auther 林良
 * @Date 2019-09-02
 */
@XmlRootElement(name = "correctInfo")
@XmlType(name = "correctInfo",propOrder = {"dateInfo","insuredInfo","baqRequiredInfo"})
public class CorrectInfo implements Serializable {

    @Valid
    private CorrectDateInfo dateInfo;

    @Valid
    private CorrectInsuredInfo insuredInfo;

    @Valid
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
