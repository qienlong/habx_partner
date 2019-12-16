package cn.com.sinosafe.domain.gbcn.insure;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @version 1.0
 * @Description 保单信息
 * @auther 林良
 * @Date 2019-08-30
 */
@XmlRootElement(name ="policyInfo")
@XmlType(name = "policyInfo",propOrder = {"sumPremium","sumAmount","endorseText"})
public class InsurePolicyInfo implements Serializable {

    /**
     * 保单保费
     */
    @Digits(integer = 10,fraction = 2)
    private BigDecimal sumPremium;

    /**
     * 保单保额
     */
    @Digits(integer = 18,fraction = 2)
    private BigDecimal sumAmount;

    /**
     * 特别约定内容
     */
    @NotBlank
    private String endorseText;

    public BigDecimal getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(BigDecimal sumPremium) {
        this.sumPremium = sumPremium;
    }

    public BigDecimal getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(BigDecimal sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getEndorseText() {
        return endorseText;
    }

    public void setEndorseText(String endorseText) {
        this.endorseText = endorseText;
    }
}
