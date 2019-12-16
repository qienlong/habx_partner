package cn.com.sinosafe.service.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;

/**
 * 
 * 正负赔案号生成 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年6月19日<br>
 */
@Service
public class AutoClaimService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 正赔案号
	 * @param serno
	 * @param coverageFee
	 * @return
	 */
	public boolean autoClaimLoanSerno(String serno) {
		String xml = getXml(serno,"1");
		return doCall(serno, xml);
	}

	
	/**
	 * 负赔案号
	 * @param serno
	 * @return
	 */
	public boolean autoNegtClaimSerno(String serno) {
		String xml = getXml(serno,"2");
		return doCall(serno, xml);
	}
	
	/**
	 * 调用
	 * @param serno
	 * @param xml
	 * @return
	 */
	private boolean doCall(String serno, String xml) {
		String url = SystemConfig.cacheMap.get("CMIS_MAIN_URL");
		logger.info("【"+serno+"】【自动生成赔案号】url："+ url +"，请求：" + xml);
		String result = HttpClientUtil.httpSend(url, xml, "XML");
		logger.info("【"+serno+"】【自动生成赔案号】result："+ result);
		return !StringUtils.isEmpty(result) && result.contains("<BusinessNo>0000</BusinessNo>");
	}
	
	/**
	 * 获取请求参数xml
	 * @param serno
	 * @param type  1正赔 2负赔
	 * @return
	 */
	private static String getXml(String serno, String type) {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
				"<Packet type=\"REQUEST\" version=\"1.0\">"+
					"<Head>"+
						"<RequestType>B04S010004</RequestType>"+
						"<RequestUser>xb_claim</RequestUser>"+
						"<TransactionCode></TransactionCode>"+
						"<TransDate></TransDate>"+
						"<TransTime></TransTime>"+
						"<BusinessNo></BusinessNo>"+
					"</Head>"+
					"<Body>"+
						"<claimType>"+type+"</claimType>"+
						"<serno>"+serno+"</serno>"+
						"<send_type>09</send_type>"+
					"</Body>"+
				"</Packet>";
		return xml;
	}

	

}
