package cn.com.sinosafe.extend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import cn.com.sinosafe.lina.rabbitmq.AbstractRabbitConsumer;
import cn.com.sinosafe.lina.rabbitmq.annotations.Consumer;
import cn.com.sinosafe.lina.rabbitmq.message.Message;
import cn.com.sinosafe.lina.rabbitmq.message.MessageChannel;

/**
 * MQ消费者
 * @Project	: haxb_partner
 * @Desc	: 各个业务之间需要约定好格式，在消息体中定义消息类型，便于正确分发到各个消息处理service
 * @Author	: hesong
 * @Date	: 2019年6月8日 下午5:52:16
 * @Version	: 1.0
 */
//@Service("messageConsumer")
//@Consumer(connection="connection1", queues = "ha.queue_order_xb_partner_padb", concurency = 10, maxConcurrency = 10)
public class MessageConsumer extends AbstractRabbitConsumer {
	private final static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	
	public void consume(Message messageObject,MessageChannel channel) throws Exception {
		logger.info("消费消息 .doing "); 
		logger.info("消费消息 .messageObject : " + messageObject); 
		logger.info("消费消息 .msgId : " + messageObject.getMessageId());  
		logger.info("消费消息 .Body : " + messageObject.getBody()); 
		
		try {
			//do something else

			channel.sendAck();
		} catch (Exception e) {
			channel.sendNack(true);
		}

	}

}
