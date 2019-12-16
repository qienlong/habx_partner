package cn.com.sinosafe.service.padb;

import java.util.Map;

/**
 * 平安独立承保通用service
 * @Project	: haxb_partner
 * @Author	: hesong
 * @Date	: 2019年6月9日 上午12:29:56
 * @Version	: 1.0
 */
public interface PaPhCommonService {

	/**
	 * 更新状态信息
	 * @author	: hirson
	 * @date	: 2019年6月9日 上午12:30:30
	 * @param serno		申请流水号
	 * @param status	状态码
	 * @param remark	备注
	 */
	void statusUpdateService(String serno, String status, String remark);

	/**
	 * 插入请求响应日志
	 * @author	: hirson
	 * @date	: 2019年6月9日 上午12:30:37
	 * @param serno				申请流水号
	 * @param interfaceNo		接口名称
	 * @param requestReport		响应信息
	 * @param responseReport	响应信息
	 */
	void insertBizLog(String serno, String interfaceNo, String requestReport, String responseReport);

	/**
	 * 发送短信
	 * @author	: hirson
	 * @date	: 2019年6月9日 上午12:30:46
	 * @param templateId	短息模板ID
	 * @param paramMap		参数集合
	 * @param mobiles	: 	手机号码
	 */
	void pushSms(int templateId, Map<String, String> paramMap, String mobiles);

	/**
	 * 发送邮件
	 * @author	: hirson
	 * @date	: 2019年6月9日 上午12:30:53
	 * @param emailTile			邮件标题
	 * @param templateId		邮件内容模板编号
	 * @param reciverAddress	收集人列表，多个以英文逗号隔开
	 * @param paramMap	: 		正文参数
	 */
	void pushMail(String emailTile, int templateId, String reciverAddress, Map<String, String> paramMap);

	
	String getPolicyUrl(String applNo);
}
