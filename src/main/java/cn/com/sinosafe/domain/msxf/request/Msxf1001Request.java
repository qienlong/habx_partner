package cn.com.sinosafe.domain.msxf.request;

import java.math.BigDecimal;

/**
 *
 * 马上消费-核保申请请求实体<br>
 * @Author :ex-tangzhenzhen001<br>
 * @Date : 2019年09月02日<br>
 */
public class Msxf1001Request extends MsxfRequest{

    private Creditdata creditdata;//征信变量
    private String bizRequestNo;//请求流水号
    private String loanNoExt;//外部订单号
    private String loanNoCtr;//三方借据合同协议编号
    private String channelCode;//渠道代码
    private String productCode;//产品编号
    private BigDecimal applyAmount;//申请金额
    private BigDecimal loanRate;//借款利率(年化)
    private BigDecimal loanInterest;//借款利息
    private String bizTime;//业务时间 yyyy-MM-dd HH:mm:ss
    private BizParams bizParams;

    public String getBizRequestNo() { return bizRequestNo; }
    public void setBizRequestNo(String bizRequestNo) { this.bizRequestNo = bizRequestNo; }
    public String getLoanNoExt() { return loanNoExt; }
    public void setLoanNoExt(String loanNoExt) { this.loanNoExt = loanNoExt; }
    public String getLoanNoCtr() { return loanNoCtr; }
    public void setLoanNoCtr(String loanNoCtr) { this.loanNoCtr = loanNoCtr; }
    public String getChannelCode() { return channelCode; }
    public void setChannelCode(String channelCode) { this.channelCode = channelCode; }
    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public BigDecimal getApplyAmount() { return applyAmount; }
    public void setApplyAmount(BigDecimal applyAmount) { this.applyAmount = applyAmount; }
    public BigDecimal getLoanRate() { return loanRate; }
    public void setLoanRate(BigDecimal loanRate) { this.loanRate = loanRate; }
    public BigDecimal getLoanInterest() { return loanInterest; }
    public void setLoanInterest(BigDecimal loanInterest) { this.loanInterest = loanInterest; }
    public String getBizTime() { return bizTime; }
    public void setBizTime(String bizTime) { this.bizTime = bizTime; }
    public Creditdata getCreditdata() { return creditdata; }
    public void setCreditdata(Creditdata creditdata) { this.creditdata = creditdata; }
    public BizParams getBizParams() { return bizParams; }
    public void setBizParams(BizParams bizParams) { this.bizParams = bizParams; }
}
