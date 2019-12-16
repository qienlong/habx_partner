package cn.com.sinosafe.common.exception;

/**
 * 参数异常
 * @Project	: Rest_HAXB_Service
 * @Author	: hesong
 * @Date	: 2018年12月29日 下午2:24:36
 * @Version	: 1.0
 */
public class ParamException extends RuntimeException{
	
	private static final long serialVersionUID = 3323552849882316934L;

	public ParamException(String message) {
		super(message);
	}
	 
	public ParamException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public ParamException(Throwable cause) {
        super(cause);
    }
}
