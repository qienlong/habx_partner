package cn.com.sinosafe.domain.gbcn.correct;

import javax.validation.Valid;
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
@XmlType(name = "requestBody",propOrder = {"isPtextFlag","endorseText","policyno","correctInfo"})
public class CorrectRequestBody implements Serializable {

    /**
     * 自定义特别约定标识
     * 1代表自定义特别约定
     * 0代表无操作
     */
    @NotBlank
    private String isPtextFlag;

    /**
     * 特别约定内容
     */
    @NotBlank
    private String endorseText;

    /**
     * 保单号
     */
    @NotBlank
    private String policyno;

    @Valid
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
}
