package cn.com.sinosafe.extend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.SpringUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.AccLoanMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.MsxfAccLoanInfoMapper;
import cn.com.sinosafe.domain.bean.MsxfLoanStatus;
import cn.com.sinosafe.domain.entity.AccLoan;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.MsxfAccLoanInfo;
import cn.com.sinosafe.domain.msxf.MsxfMqMsg;
import cn.com.sinosafe.lina.rabbitmq.AbstractRabbitConsumer;
import cn.com.sinosafe.lina.rabbitmq.annotations.Consumer;
import cn.com.sinosafe.lina.rabbitmq.message.Message;
import cn.com.sinosafe.lina.rabbitmq.message.MessageChannel;
import cn.com.sinosafe.service.msxf.MsxfAsynDealService;
import cn.com.sinosafe.service.msxf.MsxfService;

/**
 * 
 * 马上消费MQ消费者 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月18日<br>
 */
@Service("msxfMessageConsumer")
@Consumer(connection="connection1", queues = MsxfConstant.MQ_MSXF_QUEUE, concurency = 10, maxConcurrency = 10)
public class MsxfMessageConsumer extends AbstractRabbitConsumer {
	
	private final static Logger logger = LoggerFactory.getLogger(MsxfMessageConsumer.class);
	
	@Autowired
	private AccLoanMapper accLoanMapper;
	@Autowired
	private MsxfAccLoanInfoMapper msxfAccLoanInfoMapper;
	@Autowired
	private LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private MsxfAsynDealService msxfAsynDealService;
	
	public void consume(Message messageObject,MessageChannel channel) throws Exception {
		logger.info("消费消息 .doing "); 
		logger.info("消费消息 .messageObject : " + messageObject); 
		logger.info("消费消息 .msgId : " + messageObject.getMessageId());  
		logger.info("消费消息 .Body : " + messageObject.getBody()); 
		try {
			//do something else
			String body = (String)messageObject.getBody();
			
			MsxfMqMsg msxfMqMsg = JSON.parseObject(body, MsxfMqMsg.class);
			// type判断处理服务名
			String interfaceName = null;
			
			// 影像处理
			if(StringUtils.equals(msxfMqMsg.getType(), "image")) {
				interfaceName = MsxfConstant.MSXF_PL3001;
			}
			// 贷后文件处理
			else if(StringUtils.equals(msxfMqMsg.getType(), "file")) {
				interfaceName = MsxfConstant.MSXF_AL100101;
			}
			// 贷后数据处理
			else if(StringUtils.equals(msxfMqMsg.getType(), "data")) {
				interfaceName = doDataDeal(msxfMqMsg); 
				body = JSON.toJSONString(msxfMqMsg);
			}else {
				logger.info("{}消息类型不合法，不处理",msxfMqMsg.getType()); 
				return;
			}
			
			if(StringUtils.isEmpty(interfaceName)) {
				throw new Exception(msxfMqMsg.getType() + "获取interfaceName为空，请检查");
			}
			
			MsxfService msxfService = (MsxfService) SpringUtils.getBean(interfaceName);
			msxfService.busiDeal(body);
			

			channel.sendAck();
		} catch (Exception e) {
			logger.error("msxfMessageConsumer",e);
			// 记录异常
			msxfAsynDealService.insertErrorInfo("MSXF-MQ", "error", Convert.toStr(messageObject.getBody()), e.getMessage());
			// 不放回队列
			channel.sendNack(false);
			
		}

	}

	public String doDataDeal(MsxfMqMsg msxfMqMsg) {
		String interfaceName = null;
		MsxfAccLoanInfo msxfAccLoanInfo = JSON.parseObject(msxfMqMsg.getData(), MsxfAccLoanInfo.class);
		// 查询台账表
		AccLoan accLoan = accLoanMapper.selectByPrimaryKey(msxfAccLoanInfo.getRefNbr());
		if(StringUtils.isNull(accLoan)) {
			throw new BusinessException(msxfAccLoanInfo.getRefNbr() + "查询台账表为空");
		}
		msxfAccLoanInfo.setBillNo(accLoan.getBillNo());
		msxfAccLoanInfo.setListSerno(accLoan.getListSerno());
		
		// 查询保单表
		LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(accLoan.getListSerno());
		if(StringUtils.isNull(lstIqpInfo)) {
			throw new BusinessException(msxfAccLoanInfo.getRefNbr() + "查询保单表为空");
		}
		msxfAccLoanInfo.setSerno(lstIqpInfo.getSerno());
		msxfAccLoanInfo.setIqpLoanSerno(lstIqpInfo.getIqpLoanSerno());
		// 判断借据状态
		String txnStatus = msxfAccLoanInfo.getTxnStatus();
		
		// 判断马上状态和信保状态是否对应，对于双方借据状态不一致的贷款申请展示在“同业合作借据状态差异报表”中。逻辑为马上金融贷款状态和华安贷款状态不一致或者马上金融逾期天数和华安逾期天数不一致 
		msxfAsynDealService.compareStatus(accLoan,msxfAccLoanInfo);
		
		// 更新同步状态
		msxfAccLoanInfo.setSyncStatus("1");
		msxfMqMsg.setData(JSON.toJSONString(msxfAccLoanInfo));
		msxfAccLoanInfoMapper.updateByPrimaryKeySelective(msxfAccLoanInfo);
		
		// 根据状态去找对应服务处理数据
		interfaceName = MsxfLoanStatus.getInterfaceName(txnStatus);
		logger.info("消费消息 .refNbr：{}，txnStatus：{}，intefaceName：{} ",msxfAccLoanInfo.getRefNbr(),msxfAccLoanInfo.getTxnStatus(),interfaceName);
		return interfaceName;
	}

	

}
