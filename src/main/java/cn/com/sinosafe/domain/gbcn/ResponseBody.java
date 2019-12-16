package cn.com.sinosafe.domain.gbcn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description
 * @auther 林良
 * @Date 2019-09-01
 */
@XmlRootElement(name = "responseBody")
@XmlType(name = "responseBody",propOrder = {"responseTime","resultFlag","resultMessage"})
public class ResponseBody implements Serializable {

    /**
     * 处理状态 true成功 false失败
     */
    @NotNull
    private boolean resultFlag;

    /**
     * 处理结果 受理申请/受理失败
     */
    @NotBlank
    private String resultMessage;

    /**
     * 处理成功后返回
     */
    private String responseTime;

    public boolean isResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(boolean resultFlag) {
        this.resultFlag = resultFlag;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public ResponseBody() {
    }

    public ResponseBody(String responseTime, @NotNull boolean resultFlag, @NotBlank String resultMessage) {
        this.resultFlag = resultFlag;
        this.resultMessage = resultMessage;
        this.responseTime = responseTime;
    }
}
