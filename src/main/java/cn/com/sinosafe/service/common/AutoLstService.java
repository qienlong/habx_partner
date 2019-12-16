package cn.com.sinosafe.service.common;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.httpclient.HttpUtil;


/**
 * 
 * 出投保单号或保单号服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年5月30日<br>
 */
@Service
public class AutoLstService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private SystemConfig systemConfig;
	
	/**
	 * 01出投保单
	 * @param serno
	 * @param coverageFee
	 * @return
	 */
	public boolean autoCoverSerno(String serno,BigDecimal coverageFee) {
		String xml = getXml(serno,coverageFee,"01");
		return doCall(serno, xml);
	}

	
	/**
	 * 02出保单
	 * @param serno
	 * @param coverageFee
	 * @return
	 */
	public boolean autoListSerno(String serno,BigDecimal coverageFee) {
		String xml = getXml(serno,coverageFee,"02");
		return doCall(serno, xml);
	}
	
	/**
	 * 调用
	 * @param serno
	 * @param xml
	 * @return
	 */
	private boolean doCall(String serno, String xml) {
		String url = systemConfig.getValue("CMIS_MAIN_URL");
		logger.info("【"+serno+"】【自动生成投保单编号】url："+ url +"，请求：" + xml);
		String result = HttpUtil.sendPostWithXml(url, xml);
		logger.info("【"+serno+"】【自动生成投保单编号】result："+ result);
		return StringUtils.isNotEmpty(result) && result.contains("<BusinessNo>0000</BusinessNo>");
	}
	
	/**
	 * 获取请求参数xml
	 * @param serno
	 * @param coverageFee
	 * @param sendType
	 * @return
	 */
	private String getXml(String serno,BigDecimal coverageFee,String sendType) {
		String randomNum = StringUtils.getRandomNumeric(16);
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
				"<Packet type=\"REQUEST\" version=\"1.0\">" + 
				" <Head>" + 
				"  <RequestType>B04S010004</RequestType>" + 
				"  <RequestUser>xb_app</RequestUser>" + 
				"  <TransactionCode>"+randomNum+"</TransactionCode>" + 
				"  <TransDate>"+DateUtils.getDate()+"</TransDate>" + 
				"  <TransTime>"+DateUtils.getTime()+"</TransTime>" + 
				"  <BusinessNo>"+randomNum+"</BusinessNo>" + 
				" </Head>" + 
				" <Body>" + 
				"  <trans_no>"+randomNum+"</trans_no>" + 
				"  <trans_time>"+DateUtils.getTime()+"</trans_time>" + 
				"  <out_account></out_account>" + 
				"  <serno>"+serno+"</serno>" + 
				"  <ins_amount>"+coverageFee+"</ins_amount>" + 
				"  <ins_name></ins_name>" + 
				"  <ins_account></ins_account>" + 
				"  <ins_bank></ins_bank>" + 
				"  <send_type>"+sendType+"</send_type>" + 
				" </Body></Packet>";
	}
}

