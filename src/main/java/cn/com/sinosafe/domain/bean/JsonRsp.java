package cn.com.sinosafe.domain.bean;

import cn.com.sinosafe.common.config.constant.RspMsgConstant;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;

/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 基本响应信息
 * @Author	: hesong
 * @Date	: 2018年12月29日 下午4:17:18
 * @Version	: 1.0
 */
public class JsonRsp extends JsonProtocol {

	public JsonRsp () {
		super();
	}
	public JsonRsp (int code) {
		super.setCode(code);
	}
	
	public JsonRsp (int code, Object data) {
		super.setCode(code);
		super.setData(data);
    }
	
	public JsonRsp (int code, String message) {
		super.setCode(code);
		super.setMessage(message);
	}
	
	public JsonRsp (int code, String message, Object data) {
		super.setCode(code);
		super.setMessage(message);
		super.setData(data);
	}
	
	public static JsonRsp successRsp() {
		return new JsonRsp(RspMsgConstant.SUCCESS, RspMsgConstant.SUCCESS_MSG);
	}
	
	public static JsonRsp successRsp(Object data) {
		return new JsonRsp(RspMsgConstant.SUCCESS, RspMsgConstant.SUCCESS_MSG, data);
	}
	
	public static JsonRsp successRsp(String message) {
		return new JsonRsp(RspMsgConstant.SUCCESS, message);
	}
	
	public static JsonRsp successRsp(String message, Object data) {
		return new JsonRsp(RspMsgConstant.SUCCESS, message, data);
	}
	
	public static JsonRsp faleRsp() {
		return new JsonRsp(RspMsgConstant.FAIL, RspMsgConstant.FAIL_MSG);
	}
	
	public static JsonRsp faleRsp(String message) {
		return new JsonRsp(RspMsgConstant.FAIL,message);
	}
	
	public static JsonRsp faleRsp(Object data) {
		return new JsonRsp(RspMsgConstant.FAIL,RspMsgConstant.FAIL_MSG, data);
	}
	
	public static JsonRsp faleRsp(String message, Object data) {
		return new JsonRsp(RspMsgConstant.FAIL, message, data);
	}
	
	/**
	 * 参数异常响应对象
	 * @param message 消息
	 */
	public static JsonRsp arguRsp(String message) {
		return new JsonRsp(RspMsgConstant.ARGUMENT_ERROR, message);
	}

	@Override
	public String toString() {
		return "{\"code\": " + getCode() + ",\"message\": \"" + getMessage() + "\",\"data\": " + getData() + ",\"timestamp\": " + getTimestamp() + "}";
	}
	
}
