package cn.com.sinosafe.domain.xd;

import java.io.Serializable;

/**
 * 
 * 小贷响应参数 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年11月6日<br>
 */
public class XdResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -719281017472926340L;

	private String result;

    private String serno;

    private String errorMsg;
    
    
    public XdResponse() {
    }
    
    public XdResponse(String result, String errorMsg) {
        this.result = result;
        this.errorMsg = errorMsg;
    }

    public XdResponse(String result, String serno, String errorMsg) {
        this.result = result;
        this.serno = serno;
        this.errorMsg = errorMsg;
    }
    

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
