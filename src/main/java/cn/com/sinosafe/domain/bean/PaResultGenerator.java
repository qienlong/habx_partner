package cn.com.sinosafe.domain.bean;

import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.util.StringUtils;

/**
 * @Desc   : 响应结果生成工具 <br>
 * @Author : XieWei <br>
 * @Date   : 2019年5月30日<br>
 */
public class PaResultGenerator {
    public static final String DEFAULT_SUCCESS_MESSAGE = "调用成功";
    
    public static final String DEFAULT_FAIL_MESSAGE = "调用失败";
    
    public static final String DEFAULT_FIELD_DEL_MESSAGE = "字段缺失";
    
    public static final String DEFAULT_LIST_FAIL_MESSAGE = "出单失败";

	public static PaResult getResultByCode(PaResultCode code,String message) {
        return new PaResult(code,message);
    }
	
	public static PaResult getDefSuccResult() {
        return new PaResult(PaResultCode.PA_SUCCESS,DEFAULT_SUCCESS_MESSAGE);
    }
	
	public static PaResult getDefFailResult() {
        return new PaResult(PaResultCode.PA_FAIL,DEFAULT_FAIL_MESSAGE);
    }
	
	public static PaResult getDefFieldDelResult() {
        return new PaResult(PaResultCode.PA_FIELD_DELETION,DEFAULT_FIELD_DEL_MESSAGE);
    }
	
	public static PaResult getDefMsgByCode(PaResultCode code,String msg) {
		PaResult result=null;
		if(code.code()==PaResultCode.PA_SUCCESS.code()){
			result=new PaResult(PaResultCode.PA_SUCCESS,StringUtils.isEmpty(msg)?DEFAULT_SUCCESS_MESSAGE:msg);
		}else if(code.code()==PaResultCode.PA_FAIL.code()){
			result=new PaResult(PaResultCode.PA_FAIL,StringUtils.isEmpty(msg)?DEFAULT_FAIL_MESSAGE:msg);
		}else if(code.code()==PaResultCode.PA_FIELD_DELETION.code()){
			result=new PaResult(PaResultCode.PA_FIELD_DELETION,StringUtils.isEmpty(msg)?DEFAULT_FIELD_DEL_MESSAGE:msg);
		}else{
			result=new PaResult(PaResultCode.PA_FAIL,StringUtils.isEmpty(msg)?DEFAULT_FAIL_MESSAGE:msg);
		}
        return result;
    }
	
	public static JSONObject getDefMsgByCode(String msg, String code) {
		JSONObject result = new JSONObject();
		result.put("resultCode", code);
		result.put("resultMsg", msg);
        return result;
    }
	
}
