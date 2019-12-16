package cn.com.sinosafe;

import static org.junit.Assert.assertEquals;
import java.security.NoSuchProviderException;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.sinosafe.service.cmis.HaXbCmisAppApiServiceV2;
import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import net.sf.json.JSONObject;

/**
 * 单元测试类
 * @Author	: hesong
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
@Log
@RestController
@RequestMapping("/test")
public class TestController {
	@Reference(retries = 3, timeout = 60000, check = false)
	private HaXbCmisAppApiServiceV2 haXbCmisAppApiService;
	
	/**
	 * @return
	 */
	@RequestMapping(value="/ping" , method=RequestMethod.GET)
	public void ping(){
		System.out.println("success.......");
	}
	
	/**
	 * 平安普惠请求加解密工具类测试
	 * @author	: hirson
	 * @date	: 2019年5月30日 下午8:06:21
	 * @throws NoSuchProviderException	:
	 */
	@Test
	public void paEncryptUtil() throws NoSuchProviderException{
		JSONObject json = new JSONObject();
		json.put("applNo","申请号");
		json.put("coverNo","核保单号");
		String rawData = json.toString();
		String rsaStr = PaEncryptUtil.encryptByRSA(rawData);
		System.out.println(rsaStr);
		System.out.println("---------------------------------------------------");
		
		System.out.println(PaEncryptUtil.decryptByRSA(rsaStr));
		
		assertEquals(rawData, PaEncryptUtil.decryptByRSA(rsaStr));
	}
	
	/**
	 * 平安普惠请求加解密工具类测试
	 * @author	: hirson
	 * @date	: 2019年5月30日 下午8:06:21
	 * @throws NoSuchProviderException	:
	 */
	@Test
	@RequestMapping(value="/dubboTest" , method=RequestMethod.GET)
	public void dubboTest() throws NoSuchProviderException{
		JSONObject type_page = new JSONObject();
		type_page.put("appRequestType", "1");
		type_page.put("curPage", "1");
		type_page.put("pageSize", "10");
		type_page.put("terminal_type", "01");
		JSONObject json = new JSONObject();
		json.put("test", "1");
		String result = haXbCmisAppApiService.collectClientCallRecord(type_page.toString(), json.toString());
		System.out.println(result);
	}
	
	
	
}
