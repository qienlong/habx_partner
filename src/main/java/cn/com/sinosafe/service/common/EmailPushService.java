package cn.com.sinosafe.service.common;

/**
 * 邮件推送服务
 * @Project	: ruoyi-push
 * @Author	: hesong
 * @Date	: 2019年1月16日 上午8:55:34
 * @Version	: 1.0
 */
public interface EmailPushService {

	/**
	 * 邮件推送服务
	 * @author	: hirson
	 * @date	: 2019年1月16日 上午9:02:47
	 * @param emailTile		邮件标题
	 * @param emailContent	邮件内容
	 * @param reciverAddress邮件接受者列表
	 * @param ccAddress		邮件抄送人列表
	 * @param attachment	附件列表
	 * @return	:
	 */
	public void pushMessage(String emailTile, String emailContent, String[] reciverAddress, String[] ccAddress, String[] attachment);

	/**
	 * 邮件推送服务
	 * @author	: hirson
	 * @date	: 2019年1月22日 下午7:22:04
	 * @param emailTile		邮件标题
	 * @param emailContent	邮件内容
	 * @param reciverAddress邮件接受者列表字符串(多个以英文逗号","隔开)
	 * @param ccAddress		邮件抄送人列表字符串(多个以英文逗号","隔开)
	 * @param attachment	附件列表字符串(多个以英文逗号","隔开)
	 */
	public void pushMessage(String emailTile, String emailContent, String reciverAddress, String ccAddress, String attachment);
}
