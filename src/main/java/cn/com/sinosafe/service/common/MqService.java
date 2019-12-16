package cn.com.sinosafe.service.common;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.lina.rabbitmq.RabbitProducer;
import cn.com.sinosafe.service.msxf.MsxfAsynDealService;

/**
 * 
 * Mq消息队列操作服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年8月7日<br>
 */
@Service
public class MqService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	RabbitProducer rabbitProducer;
	@Resource
	private MsxfAsynDealService msxfAsynDealService;
	
	/**
	 * 发送马上消费贷后数据
	 * @param contNo 合同号
	 * @param busiDate 业务日期
	 */
	public void noticeMsxfPostLoanData(String body) {
		try {
			logger.info("【发送MQ消息】{},params={}",MsxfConstant.MQ_MSXF_QUEUE,body);
			rabbitProducer.send(MsxfConstant.MQ_XB_EXCHANGE, MsxfConstant.MQ_XB_ACT_ROUTINGKEY, body);
			logger.info("【发送MQ消息】{}完成",MsxfConstant.MQ_MSXF_QUEUE);
		} catch (Exception e) {
			logger.error("noticeMsxfPostLoanData",e);
			// 发生邮件
			msxfAsynDealService.pushEmail(MsxfConstant.MQ_MSXF_QUEUE, body, e);
		}
	}
}
