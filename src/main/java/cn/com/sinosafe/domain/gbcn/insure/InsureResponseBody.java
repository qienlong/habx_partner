package cn.com.sinosafe.domain.gbcn.insure;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description 投保返回信息
 * @auther 林良
 * @Date 2019-08-30
 */
@XmlRootElement(name ="responseBody")
@XmlType(name = "responseBody",propOrder = {"responseTime","resultFlag","resultMessage","proposalNo","yeepayurl"})
public class InsureResponseBody implements Serializable {

    /**
     *处理时间
     */
    private String responseTime;

    /**
     * 处理状态  true成功 false失败
     */
    @NotNull
    private Boolean resultFlag;

    /**
     * 处理结果 投保成功/失败原因
     */
    @NotNull
    private String resultMessage;

    /**
     * 投保单号 处理成功后返回
     */
    private String proposalNo;

    /**
     *支付链接
     */
    private String yeepayurl;

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public Boolean getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(Boolean resultFlag) {
        this.resultFlag = resultFlag;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getYeepayurl() {
        return yeepayurl;
    }

    public void setYeepayurl(String yeepayurl) {
        this.yeepayurl = yeepayurl;
    }

    public InsureResponseBody() {
    }

    public InsureResponseBody(String responseTime, @NotNull Boolean resultFlag, @NotNull String resultMessage, String proposalNo, String yeepayurl) {
        this.responseTime = responseTime;
        this.resultFlag = resultFlag;
        this.resultMessage = resultMessage;
        this.proposalNo = proposalNo;
        this.yeepayurl = yeepayurl;
    }
}
