package cn.com.sinosafe.extend.padb;

import java.security.NoSuchProviderException;

import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.config.constant.CommonConstant;
import cn.com.sinosafe.domain.bean.PaResultCode;

/**
 * 针对于平安业务的通用工具
 * @Project	: haxb_partner
 * @Author	: hesong
 * @Date	: 2019年6月3日 下午8:47:44
 * @Version	: 1.0
 */
public class PaCommonUtil {

	/**
	 * 构造加密后的平安独保业务的响应体
	 * @author	: hirson
	 * @date	: 2019年6月3日 下午8:48:45
	 * @param param	  明文参数
	 * @return	:
	 * @throws NoSuchProviderException 
	 */
	public static JSONObject getReturnJsonOnEncrypt(String param) throws NoSuchProviderException {
		JSONObject json = new JSONObject();
		json.put("param", param);
		return json;
	}
	
	/**
	 * 构造统一的成功或者失败响应
	 * @author	: hirson
	 * @date	: 2019年6月3日 下午9:26:20
	 * @param type		结果类型
	 * @param message	消息内容
	 * @return
	 * @throws NoSuchProviderException	:
	 */
	public static JSONObject getReturnByType(String type, String message){
		JSONObject jsResult = new JSONObject();
		if (CommonConstant.SUCCESS.equals(type)) {
			jsResult.put("resultCode", PaResultCode.PA_SUCCESS.code());
			jsResult.put("resultMsg", "调用成功");
		}
		
		if (CommonConstant.FAIL.equals(type)) {
			jsResult.put("resultCode", PaResultCode.PA_FAIL.code());
			jsResult.put("resultMsg", "调用失败");
		}
		if (CommonConstant.DELETION.equals(type)) {
			jsResult.put("resultCode", PaResultCode.PA_FIELD_DELETION.code());
			jsResult.put("resultMsg", "字段缺失");
		}
		return jsResult;
	}
	
	/**
	 * 获取自定义申请状态描述
	 * @author	: hirson
	 * @date	: 2019年6月4日 下午8:38:26
	 * @param status
	 * @return	:
	 */
	public static String getStatusEname(String status) {
		String cnname = null;
		switch (status) {
			case "01":
				cnname = "投保申请";
			    break;
			case "02":
				cnname = "投保成功";
			    break;
			case "03":
				cnname = "投保失败";
			    break;
			case "04":
				cnname = "已投保通知";
			    break;
			case "05":
				cnname = "平安已核保通知";
			    break;
			case "06":
				cnname = "华安核保通过";
			    break;
			case "07":
				cnname = "华安核保拒绝";
			    break;
			case "08":
				cnname = "保费校验通过";
			    break;
			case "09":
				cnname = "保费校验拒绝";
			    break;
			case "10":
				cnname = "已通知出单";
			    break;
			case "11":
				cnname = "已出单";
			    break;
			case "12":
				cnname = "保单已推送";
			    break;
			case "13":
				cnname = "授信制回退";
				break;
			case "14":
				cnname = "已放款";
				break;
			case "15":
				cnname = "已退票";
				break;
			case "16":
				cnname = "已取消";
				break;
			case "17":
				cnname = "核赔申请";
				break;
			case "18":
				cnname = "核赔通过/核赔拒绝";
				break;
			case "19":
				cnname = "理赔交易报盘";
				break;
			case "20":
				cnname = "理赔交易完成通知";
				break;
			case "21":
				cnname = "代偿结清（银行理赔核销后的状态）";
				break;
			case "22":
				cnname = "正常结清";
				break;
			case "23":
				cnname = "提前结清";
				break;
			case "24":
				cnname = "追偿结清";
				break;
		}
		return cnname;
	}
	
	/**
	 * 获取自定义申请状态第二描述
	 * @author	: hirson
	 * @date	: 2019年6月4日 下午8:38:26
	 * @param status
	 * @return	:
	 */
	public static String getNewStatusEname(String status) {
		String cnname = null;
		switch (status) {
			case "01":
				cnname = "待投保";
			    break;
			case "02":
				cnname = "待投保通知";
			    break;
			case "03":
				cnname = "待投保通知";
			    break;
			case "04":
				cnname = "待平安核保通知";
			    break;
			case "05":
				cnname = "待华安核保通知";
			    break;
			case "06":
				cnname = "待保费校验";
			    break;
			case "07":
				cnname = "待保费校验";
			    break;
			case "08":
				cnname = "待通知出单";
			    break;
			case "09":
				cnname = "待通知出单";
			    break;
			case "10":
				cnname = "待出单";
			    break;
			case "11":
				cnname = "保单待推送";
			    break;
			case "12":
				cnname = "待放款";
			    break;
			case "14":
				cnname = "待还款";
				break;
			case "17":
				cnname = "待核赔";
				break;
			case "18":
				cnname = "待理赔交易报盘";
				break;
			case "19":
				cnname = "待理赔交易完成通知";
				break;
			case "20":
				cnname = "待理赔核销";
				break;
			case "21":
				cnname = "待追偿";
				break;
		}
		return cnname;
	}
	
	/**
	 * 获取审批状态
	 * @author	: hirson
	 * @date	: 2019年6月4日 下午8:38:26
	 * @param status
	 * @return	:
	 */
	public static String getApproveStatus(String status) {
		String approveStatus = null;
		if ("02".equals(status) || "03".equals(status) || "04".equals(status) || "05".equals(status)) {
			approveStatus = "111";
		}
		if ("06".equals(status)) {
			approveStatus = "997";
		}
		if ("07".equals(status)) {
			approveStatus = "998";
		}
		return approveStatus;
	}
	/**
	 * 获取审批状态
	 * @author	: longxiaoqiang
	 * @date	: 2019年6月4日 下午8:38:26
	 * @param status
	 * @return	:
	 */
	public static String getLstStatus(String status) {
		String approveStatus = null;
		if ("06".equals(status)) {
			approveStatus = "997";
		}
		return approveStatus;
	}
	
}
