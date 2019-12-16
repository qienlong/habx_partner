package cn.com.sinosafe.common.exception;

import cn.com.sinosafe.lina.common.protocol.ResultCode;

/**
 * 业务异常
 * 
 * @author ruoyi
 */
public class BusinessException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    protected final String message;
    private int code;

    public BusinessException(String message)
    {
        this.message = message;
    }
    
    public BusinessException(ResultCode resultCode) {
    	this.message = resultCode.getMessage();
        this.code = resultCode.getCode();
    }

    public BusinessException(int code,String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public int getCode() {
		return code;
	}
}
