package cn.com.sinosafe.domain.msxf.request;

/**
 *
 * 马上消费-核保申请结果查询<br>
 * @Author :ex-tangzhenzhen001<br>
 * @Date : 2019年09月04日<br>
 */
public class Msxf1002Request extends MsxfRequest{

    private String bizRequestNo;//请求流水号

    private String loanNoExt;//外部订单号

    public String getBizRequestNo() { return bizRequestNo; }

    public void setBizRequestNo(String bizRequestNo) { this.bizRequestNo = bizRequestNo; }

    public String getLoanNoExt() { return loanNoExt; }

    public void setLoanNoExt(String loanNoExt) { this.loanNoExt = loanNoExt; }
}
