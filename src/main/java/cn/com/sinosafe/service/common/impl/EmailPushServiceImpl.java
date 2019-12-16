package cn.com.sinosafe.service.common.impl;

import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.properties.MailProperties;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.service.common.EmailPushService;

/**
 * 电子邮件推送
 * @Project	: ruoyi-push
 * @Author	: hesong
 * @Date	: 2019年1月16日 上午9:33:08
 * @Version	: 1.0
 */
@Service
public class EmailPushServiceImpl implements EmailPushService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private MailProperties mailProperties;
	
	@Override
	public void pushMessage(String emailTile, String emailContent, String[] reciverAddress, String[] ccAddress, String[] attachment) {
		try {
			pushMessageService(emailTile, emailContent, reciverAddress, ccAddress, attachment);
			logger.info("【华安邮件推送】标题{},推送成功", emailTile);
		} catch (Exception e) {
			logger.error("【华安邮件推送】异常，异常信息{}", e.toString());
			e.printStackTrace();
		}
	}
	
	@Async
	@Override
	public void pushMessage(String emailTile, String emailContent, String reciverAddress, String ccAddress, String attachment) {
		try {
			pushMessageService(emailTile, emailContent, reciverAddress.split(","), ccAddress.split(","), attachment.split(","));
			logger.info("【华安邮件推送】标题{},推送成功", emailTile);
		} catch (Exception e) {
			logger.error("【华安邮件推送】异常，异常信息{}", e.toString());
			e.printStackTrace();
		}
	}
	
	private void pushMessageService(String emailTile, String emailContent, String[] reciverAddress, String[] ccAddress, String[] attachment) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, attachment.length > 0 ? true : false);
		//发件人
		helper.setFrom(mailProperties.getFrom(),mailProperties.getPersonal());
		
		//收件人
		if (reciverAddress.length < 1 || StringUtils.isEmpty(reciverAddress[0])) {
			throw new Exception("the email reciver is empty...");
		}
		helper.setTo(reciverAddress);
		
		//抄送人
		System.out.println(ccAddress.length);
		if (ccAddress.length > 0 & StringUtils.isNotEmpty(ccAddress[0])) {
			helper.setCc(ccAddress);
		}
		
		//邮件标题
		if (StringUtils.isNotEmpty(emailTile)) {
			helper.setSubject(emailTile);
		}
		
		//内容
		if (StringUtils.isNotEmpty(emailContent)) {
			helper.setText(emailContent, true);
		}
		//添加附件
		if (attachment.length > 0) {
			for (String fileName : attachment) {
				if (StringUtils.isNotEmpty(fileName)) {
					FileSystemResource file = new FileSystemResource(fileName);
					helper.addAttachment(file.getFilename(), file);
				}
			}
		}
		mailSender.send(message);
	}

}
