package cn.com.sinosafe;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import cn.com.sinosafe.common.config.properties.MsxfProperties;
import cn.com.sinosafe.common.util.RSAUtils;
import cn.com.sinosafe.dao.AccFeeMtdPlanMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.QueryIqpTemplateDetailMapper;
import cn.com.sinosafe.dao.WsxdMapper;
import cn.com.sinosafe.domain.msxf.request.Creditdata;
import cn.com.sinosafe.domain.msxf.request.Msxf1001Request;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sinosafe.service.cmis.HaXbCmisAppApiServiceV2;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HaxbPartnerApplication.class)
public class HaxbPartnerApplicationTest {
	
    private static final Logger logger = LoggerFactory.getLogger(HaxbPartnerApplicationTest.class);
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private MsxfProperties msxfProperties;
	@Autowired
	private AccFeeMtdPlanMapper accFeeMtdPlanMapper;
	
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;
	
    @Reference(retries = 3, timeout = 60000, check = false)
    protected HaXbCmisAppApiServiceV2 haXbCmisAppApiService;
    
    
	@Autowired
	private WsxdMapper wsxdMapper;
    
    
    @Autowired
	private QueryIqpTemplateDetailMapper queryIqpTemplateDetailMapper;
    
	@Test
	public void test2() throws IOException {
		Map<String,Object> aac = wsxdMapper.selectHamiContfun("WXSQ20191210052037");
		if(!CollectionUtils.isEmpty( aac)&&aac.containsKey("CONTNO")){
			String contNo = String.valueOf(aac.get("CONTNO"));
		}
	}
    
	@Test
	public void test() throws IOException {
		JSONObject request = new JSONObject();
	    request.put("appRequestType", "1");
	    request.put("curPage", "1");
	    request.put("pageSize", "10");
	    request.put("terminal_type", "01");
	    Map<String, Object> json = new HashMap<String, Object>();
	    String serno = "WXSQ20191210052033";
	    json.put("serno", serno);
	    //dubbo
	//    queryLoanDetail(String request, String json)
	    String response1 = haXbCmisAppApiService.queryLoanDetail(JSONObject.toJSONString(request),JSONObject.toJSONString(json));
	    System.out.println(response1);
	/*    //http post
	    JSONObject postMap = new JSONObject();
	    postMap.put("request",request);
	    postMap.put("json", json);
	    String response2 = HttpClientUtil.httpPost("http://10.2.108.91:18088/cop/xd/queryIqpTemplateDetail",JSONObject.toJSONString(postMap) );
	    System.out.println(response2);*/
	}
	
	public static void main(String[] args) {
	    Map<String, Object> postMap = new HashMap<String, Object>();
	    postMap.put("json","caonima");
	    String caonima = postMap.toString();
	    JSONObject json = new JSONObject(postMap);

	    System.out.println((json));
	   // JSONObject json1 = JSONObject.parseObject(postMap.getString("json"),JSONObject.class);;
//	   System.out.println( json1.getString("serno"));;

	}
	
	 /**
	    * 
	    * String转map
	    * @param str
	    * @return
	    */
	   public static Map<String,Object> getStringToMap(String str){
	       //根据逗号截取字符串数组
	       String[] str1 = str.split(",");
	       //创建Map对象
	       Map<String,Object> map = new HashMap<>();
	       //循环加入map集合
	       for (int i = 0; i < str1.length; i++) {
	           //根据":"截取字符串数组
	           String[] str2 = str1[i].split(":");
	           //str2[0]为KEY,str2[1]为值
	           map.put(str2[0],str2[1]);
	       }
	       return map;
	   }
	   
	@Test
	public void testMapper() {
		BigDecimal bigDecimal = accFeeMtdPlanMapper.selectTotalFeeByPlanLstSerno("LSTI20171225025497");
		System.out.println(bigDecimal);
	}

	@Test
	public void contextLoads() throws SQLException {
		
		String s = "{\n" + 
				" \"applyAmount\":800,\n" + 
				" \"bizRequestNo\": \"8382353bkjhgfckjjdyuiiw78942d06111\",\n" + 
				" \"bizParams\": {\n" + 
				"  \"useful\": \"PL01\",\n" + 
				"  \"repaymentMode\": \"C05Assure001\",\n" + 
				"  \"repaymentSource\": \"1\",\n" + 
				"  \"totalInstallmentNo\": \"6\",\n" + 
				"  \"depAcctNbr\": \"6214830111554486\",\n" + 
				"  \"rcvAcctType\": \"1\",\n" + 
				"  \"rcvAcctName\": \"张三三\",\n" + 
				"  \"wthAcctNbr\": \"6214830111554486\",\n" + 
				"  \"depBankName\":\"中国银行\",\n" + 
				"  \"payAcctName\": \"张三\",\n" + 
				"  \"payAcctType\": \"1\",\n" + 
				"  \"custName\": \"蒙奇奇\",\n" + 
				"  \"idType\": \"120001\",\n" + 
				"  \"idNo\": \"520188199411131234\",\n" + 
				"  \"dueDate\": \"2099-12-31\",\n" + 
				"  \"nationality\": \"CHN\",\n" + 
				"  \"sex\": \"1\",\n" + 
				"  \"homeAddress\": \"北京市\",\n" + 
				"  \"phone\": \"13888888888\",\n" + 
				"  \"occupation\": \"01\"\n" + 
				" },\n" + 
				" \"bizTime\": \"2019-09-11 00:00:00\",\n" + 
				" \"channelCode\": \"PRJ20190903092634\",\n" + 
				" \"loanInterest\": 96,\n" + 
				" \"loanNoCtr\": \"SHZZX15S1202015100001\",\n" + 
				" \"loanNoExt\": \"DLAyh0823155825CJd7TC8wRHMBANK\",\n" + 
				" \"loanRate\": 0.12,\n" + 
				" \"productCode\": \"05210303\"\n" + 
				"}";
		
		Msxf1001Request request = JSON.parseObject(s, Msxf1001Request.class);
		
		Creditdata creditdata = new Creditdata();
		creditdata.setHtyhAllCscacct12mContinueMaxPdNum(0);
		creditdata.setHtyhAllCscacct12mTotalMaxPdNum(0);
		creditdata.setHtyhAllLoan12mMaxContinuePdNum(0);
		creditdata.setHtyhAllLoan12mTotalContinuePdNum(0);
		creditdata.setHtyhExistsCurrentCacctPdBdDjZf(0);
		creditdata.setHtyhExistsCurrentLpd(0);
		creditdata.setHtyhExistsCurrentScacctPdBdDjZf(0);
		creditdata.setHtyhExistsLoanCurrentStatusBd(0);
		creditdata.setHtyhExistsScacctOverdraft180dNoRepayRecord(0);
		creditdata.setHtyhExistsZcczBbrdcInLoanRecords(0);
		creditdata.setHtyhLoanCreditCard1mApplyNum(0);
		request.setCreditdata(creditdata );
		RSAUtils rsaUtils = new RSAUtils(msxfProperties.getHaPublicKey(), msxfProperties.getHaPrivateKey());
		
		String encrypt = rsaUtils.encrypt(JSON.toJSONString(request));
		
		System.out.println(encrypt);
		
		String decrypt = rsaUtils.decrypt(encrypt);
		System.out.println(decrypt);
//		Connection connection = dataSource.getConnection();
//		System.out.println(SequenceUtil.getWXSerno(connection));
//		connection.close();
		
//		String json = "{\"name\":\"农金玲\",\"idcard\":\"452622198702081646\",\"serno\":\"APPSQ20190612938088\",\"mobile\":\"15878477120\",\"bankcard\":\"6217003450000338283\",\"creditType\":\"pyzx\"}";
//		String postForObject = restTemplate.postForObject("http://" + SystemConstant.BIGDATA + "/other/ylmPy1362Query", json, String.class);
//		System.out.println(postForObject);
	}

}
