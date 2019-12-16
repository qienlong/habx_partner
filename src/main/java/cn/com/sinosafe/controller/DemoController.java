package cn.com.sinosafe.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.sinosafe.service.padb.*;
import cn.com.sinosafe.service.padb.impl.PaPhTrustPlanServiceImpl;
import cn.com.sinosafe.service.padb.impl.PublicRepaymentServiceImpl;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.sinosafe.service.cmis.HaXbCmisAppApiServiceV2;
import cn.com.sinosafe.api.BigDataService;
import cn.com.sinosafe.bigdata.other.ylm.YlmRequest;
import cn.com.sinosafe.common.config.constant.SystemConstant;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.domain.bean.PaResult;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.extend.padb.PaEncryptUtil;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.other.axsign.AxSignService;
import cn.com.sinosafe.service.common.EmailPushService;
import cn.com.sinosafe.service.common.SmsPushService;
import cn.com.sinosafe.service.padb.CheckInsureNoticeService;
import cn.com.sinosafe.service.padb.CheckRateService;
import cn.com.sinosafe.service.padb.IssuedMsgService;
import cn.com.sinosafe.service.padb.IssuedRateService;
import cn.com.sinosafe.service.padb.NoticeInsureIqpResultService;
import cn.com.sinosafe.service.padb.PaCancelNoticeService;
import cn.com.sinosafe.service.padb.PaCostSettlementService;
import cn.com.sinosafe.service.padb.PaCreditCancelService;
import cn.com.sinosafe.service.padb.PaLstIqpApplyService;
import cn.com.sinosafe.service.padb.PspClaimApproveService;
import cn.com.sinosafe.service.padb.ReloadCacheService;
import cn.com.sinosafe.service.padb.impl.FO002003ServiceImpl;
import cn.com.sinosafe.service.padb.impl.FO004003ServiceImpl;

/**
 * 测试类
 * @Author	: hesong
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
//@Log
@RestController
@RequestMapping("/patest")
public class DemoController {
	@Reference(retries = 3, timeout = 60000, check = false)
	private HaXbCmisAppApiServiceV2 haXbCmisAppApiService;
	@Autowired
	private IssuedRateService issuedRateService;
	@Autowired
	private EmailPushService emailPushService;
	@Autowired
	private SmsPushService smsPushService;
	@Autowired
	private AxSignService axSignService;
	@Autowired
	private PaLstIqpApplyService paLstIqpApplyService;
	@Autowired
	private IssuedMsgService issuedMsgService;
	
	@Autowired
	private NoticeInsureIqpResultService noticeInsureIqpResultService;
	
	@Autowired
	private CheckInsureNoticeService checkInsureNoticeService;
	
	@Autowired
	private CheckRateService checkRateService;
	
	@Autowired
	private PaCostSettlementService paCostSettlementService;
	
	@Autowired
	private PaCancelNoticeService paCancelNoticeService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private BigDataService bigDataService;
	@Autowired
	private FO002003ServiceImpl fO002003Service;
    @Autowired
	private PaCreditCancelService paCreditCancelService;
	@Autowired
	private ReloadCacheService reloadCacheService;
	@Autowired
	private PspClaimApproveService pspClaimApproveService;
	@Autowired
	private FO004003ServiceImpl fO004003Service;
	@Autowired
    private PaPhTrustPlanServiceImpl paPhTrustPlanService;
	@Autowired
    private PublicRepaymentServiceImpl publicRepaymentService;
	
	@PostMapping("/test2")
	public void testFeign() throws Exception {
		YlmRequest request = new YlmRequest();
		request.setName("周宇");
		request.setBankcard("6228480462709272514");
		request.setIdcard("421083199504152843");
		request.setMobile("18628178213");
		request.setSerno("APPSQ20190612938088");
		JsonProtocol jsonProtocol = bigDataService.ylmPy1362Query(request);
		System.out.println(JSON.toJSONString(jsonProtocol));
	}

	@PostMapping("/test")
	public void contextLoads() {
		String json = "{\"name\":\"周宇\",\"idcard\":\"421083199504152843\",\"serno\":\"APPSQ20190612938088\",\"mobile\":\"18628178213\",\"bankcard\":\"6228480462709272514\",\"creditType\":\"ylm\"}";
		HttpHeaders httpHeaders = new HttpHeaders();
        //设置header
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        HttpEntity<String> requestEntity = new HttpEntity<String>(json, httpHeaders);
        ResponseEntity<JsonProtocol> resp = restTemplate.exchange("http://" + SystemConstant.BIGDATA + "/other/ylmPy1362Query" ,HttpMethod.POST,requestEntity, JsonProtocol.class);
//		String postForObject = restTemplate.postForObject("http://" + SystemConstant.BIGDATA + "/other/ylmPy1362Query", requestEntity, String.class);
        ResponseEntity<String> rsp1 = restTemplate.postForEntity("http://" + SystemConstant.BIGDATA + "/other/ylmPy1362Query", requestEntity , String.class );
        System.out.println(JSON.toJSONString(resp.getBody()));
        System.out.println(rsp1.getBody());
	}
	
	/**
	 * @return
	 */
	@PostMapping(value="/ping")
	public void ping(){
		System.out.println("success.......");
	}
	
	/**
	 * dubbo集成测试
	 * @author	: hirson
	 * @date	: 2019年5月30日 下午8:06:21
	 * @throws NoSuchProviderException	:
	 */
	@RequestMapping(value="/dubboTest" , method=RequestMethod.GET)
	public void dubboTest() throws NoSuchProviderException{
		/*JSONObject type_page = new JSONObject();
		type_page.put("appRequestType", "1");
		type_page.put("curPage", "1");
		type_page.put("pageSize", "10");
		type_page.put("terminal_type", "01");
		JSONObject json = new JSONObject();
		json.put("test", "1");
		String result = haXbCmisAppApiService.collectClientCallRecord(type_page.toString(), json.toString());
		System.out.println(result);*/
		Map<String, Object> policyInfo=new HashMap<String, Object>();
		policyInfo.put("applNo", "LSTI20150415000593");
		try {
			issuedMsgService.issuePolicy(policyInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		paLstIqpDowloadMsgService.lstDowloadMsg(policyInfo);
	}
	
	/**
	 * 费率下发接口
	 * @author	: pengll
	 * @date	: 2019年5月30日 下午8:06:21
	 * @throws NoSuchProviderException	:
	 */
//	@RequestMapping(value="/issuedRate" , method=RequestMethod.POST)
//	public String queryIssue(Map<String, Object> paramMap) throws NoSuchProviderException{
//
//        String message = issuedRateService.IssueFeeRateInfo(paramMap);
//        System.out.println(message);
//		return message;
//	}
	
	@RequestMapping(value="/testPush" , method=RequestMethod.GET)
	public void testPush() {
		//发送短信测试
		smsPushService.pushMessage("测试内容", "13682439683");
		// 发送短信
//		smsPushService.pushMessage("测试内容", "15658654664");
		// 发送邮件
//		emailPushService.pushMessage("平安独立承保保费率不一致", "起飞起飞", "hesong@sinosafe.com.cn,leiyu1@sinosafe.com.cn", "", "");
	}
	
	
	@RequestMapping(value="/testYlm" , method=RequestMethod.GET)
	public void testYlmQuery() throws Exception {
		YlmRequest request = new YlmRequest();
		request.setName("周宇");
		request.setBankcard("6228480462709272514");
		request.setIdcard("421083199504152843");
		request.setMobile("18628178213");
		request.setSerno("APPSQ20190612938088");
		JsonProtocol jsonProtocol = bigDataService.ylmPy1362Query(request);
		System.out.println(JSON.toJSONString(jsonProtocol));
	}
	
	@RequestMapping(value="/testAxSign" , method=RequestMethod.GET)
	public String testAxSign() throws Exception {
		String name = "段小露";
		String identNo = "341222198910272115";
//		String mobile = "15658654664";
		String mobile = "";
		String register = axSignService.registerOnAxSign(name, identNo, mobile);
		System.out.println(register);
		return register;
	}

	//投保申请
	@RequestMapping(value="/paLstIqpApply" , method=RequestMethod.POST)
	public String paLstIqpApply(@RequestBody Map<String, Object> param) throws Exception {
		String result=null;
		try {
			result=paLstIqpApplyService.lstIqpApplyNoSign(param);
		} catch (Exception e) {
			PaResult obj=PaResultGenerator.getDefMsgByCode(PaResultCode.PA_FAIL,null);
			result=JSON.toJSONString(obj);
		}
		return result;
	}

	/**
	 * 信托计划信息同步
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/trustPlanInfoSyn" , method=RequestMethod.POST)
	public String TrustPlanInfoSyn(@RequestBody Map<String,Object> param) throws RuntimeException{
		String result=null;
		try {
            result=paPhTrustPlanService.service(param);
		} catch (Exception e) {
			PaResult obj=PaResultGenerator.getDefMsgByCode(PaResultCode.PA_FAIL,null);
			result=JSON.toJSONString(obj);
		}
		return result;
	}

	/**
	 * 对公还款存入通知接口
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/publicRepayment" , method=RequestMethod.POST)
	public String PublicRepaymentNotice(@RequestBody Map<String, Object> param) throws RuntimeException{
		String result=null;
		try {
			result=publicRepaymentService.service(param);
		} catch (Exception e) {
			PaResult obj=PaResultGenerator.getDefMsgByCode(PaResultCode.PA_FAIL,null);
			result=JSON.toJSONString(obj);
		}
		return result;
	}



	//退汇业务
	@RequestMapping(value="/cancelNotice" , method=RequestMethod.POST)
	public String CancelNotice(@RequestBody Map<String, Object> params) throws Exception {
		String result = null;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			result = paCancelNoticeService.cancelRemitAll(params);
		} catch (Exception e) {
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
			result=JSON.toJSONString(resultMap);
		}
        return result;	
	}
	@RequestMapping(value="/creditCancelNotice" , method=RequestMethod.POST)
	public String creditCancelNotice(@RequestBody Map<String, Object> params) throws Exception {
		String result = null;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			result = paCreditCancelService.creditCancel(params);
		} catch (Exception e) {
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
			result=JSON.toJSONString(resultMap);
		}
		return result;
	}

	//公费结算
	@RequestMapping(value="/checkCostSet" , method=RequestMethod.POST)
	public String checkCostSet(@RequestBody Map<String, Object> params) throws Exception {
		String result = null;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			result = paCostSettlementService.infoSync(params);
		} catch (Exception e) {
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
			result=JSON.toJSONString(resultMap);
		}
        return result;	
	}
	
	//投保生成通知
	@RequestMapping(value="/issuedMsg" , method=RequestMethod.POST)
	public String issuedMsg(@RequestBody Map<String, Object> params) throws Exception {
		String result = null;
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			result = issuedMsgService.issuePolicy(params);
		} catch (Exception e) {
			resultMap.put("resultCode",PaResultCode.PA_FAIL.code());
			resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
			result=JSON.toJSONString(resultMap);
		}
        return result;	
	}
	
	@PostMapping("/testIssedMsg")
	public String testIssedMsg(@RequestParam Map<String, String> params) throws Exception {
		String no = params.get("applNo");
		System.out.println(no);
		
//		String name = "段小露";
//		String identNo = "341222198910272115";
////		String mobile = "15658654664";
//		String mobile = "";
//		String register = axSignService.registerOnAxSign(name, identNo, mobile);
//		System.out.println(register);
		return "success";
		
		
	}
	
	//测试投保确认通知接口
	@PostMapping("/sendMessage")
	@ResponseBody
	public String sendMessage(String token, String applNo,String resultCode) throws Exception {
		String result = noticeInsureIqpResultService.queryInsureIqpResult(token,applNo, resultCode);
		return result;
	}
	
	//测试核保通知接口
	@RequestMapping(value="/confirmissue" , method=RequestMethod.POST)
	public String checkIssue(@RequestBody Map<String, Object> params) throws Exception {
		String result = checkInsureNoticeService.checkInsureNotice(params);
        return result;	
	}
	
	//重载缓存
	@RequestMapping(value="/reloadCache" , method=RequestMethod.POST)
	public String checkIssue() throws Exception {
		String result = reloadCacheService.reloadCache();
        return result;
	}
	
	//测试费率一致性接口
	@PostMapping("/checkreate")
	@ResponseBody
	public String checkreate(@RequestParam Map<String, Object> params) throws Exception {
		String result = checkRateService.CheckFeeRate(params);
        return result;	
	}
	
	@PostMapping(value="/getLstUrl")
	public String getLstUrl(@RequestParam Map<String, Object> params){
		 return fO002003Service.service(params);
	}
	
	@GetMapping(value="/imgRes")
	public InputStream getYCFile(String urlPath) throws Exception {  
	  urlPath = "http://proxytest.sinosafe.com.cn/xbapp/store_down_new/download?Type=1&SystemCode=DZBDSYS&BusinessCode=WXNEW0000015335873&FileId=ECONTRACTPDFUPTOIMAGESYSTEM_WXNEW0000015335873.pdf";
	  InputStream is = null;
	  try {
		   // 构造URL
		   URL url = new URL(urlPath);
		   // 打开连接
		   HttpURLConnection con = (HttpURLConnection) url.openConnection();  
		   //设置请求超时为5s
		   con.setConnectTimeout(5*1000);
		   // 输入流
		   is = con.getInputStream();
		   return is;
	  } catch(Exception e) {
		  throw e;
	  } finally {
		   // 完毕，关闭所有链接
		   if(is != null) {
		    is.close();
		   }
	  }
    }  
	
	@GetMapping(value="/imgRes2")
	public void getImage(String path, HttpServletRequest request, HttpServletResponse response) {
        try {
           String surl = "http://proxytest.sinosafe.com.cn/xbapp/store_down_new/download?Type=1&SystemCode=DZBDSYS&BusinessCode=WXNEW0000015335873&FileId=ECONTRACTPDFUPTOIMAGESYSTEM_WXNEW0000015335873.pdf";
            // 构造URL
 		   URL url = new URL(surl);
 		   // 打开连接
 		   HttpURLConnection con = (HttpURLConnection) url.openConnection();  
 		   //设置请求超时为5s
 		   con.setConnectTimeout(5*1000);
 		   // 输入流
            InputStream fis = con.getInputStream();
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
//            response.reset();
            // 设置response的Header
//            response.setContentType("application/pdf");
            response.setContentType("application/force-download");

            OutputStream toClient = response.getOutputStream();
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            toClient = null;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        return response;
    }

	@GetMapping(value="/imgRes3")
	 private String downloadFile(HttpServletResponse response) throws IOException{
         String fileName = "demo.pdf";//被下载文件的名称
         String surl = "http://proxytest.sinosafe.com.cn/xbapp/store_down_new/download?Type=1&SystemCode=DZBDSYS&BusinessCode=WXNEW0000015335873&FileId=ECONTRACTPDFUPTOIMAGESYSTEM_WXNEW0000015335873.pdf";
         response.setContentType("application/force-download");// 设置强制下载不打开            
         response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
         byte[] buffer = new byte[1024];
         BufferedInputStream bis = null;
         
         URL url = new URL(surl);
		 HttpURLConnection con = (HttpURLConnection) url.openConnection();  
		 con.setConnectTimeout(5*1000);
         InputStream fis = con.getInputStream();
         
         try {
             bis = new BufferedInputStream(fis);
             OutputStream outputStream = response.getOutputStream();
             int i = bis.read(buffer);
             while (i != -1) {
                 outputStream.write(buffer, 0, i);
                 i = bis.read(buffer);
             }
             return "下载成功";
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             if (bis != null) {
                 try {
                     bis.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             if (fis != null) {
                 try {
                     fis.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
        return "下载失败";    
     }
	@RequestMapping(value="/claimIqpApply" , method=RequestMethod.POST)
	public String claimIqpApply(@RequestBody Map<String, Object> param) throws Exception {
		String result=null;
		try {
			result=pspClaimApproveService.pspClaimApprove(param);
		} catch (Exception e) {
			PaResult obj=PaResultGenerator.getDefMsgByCode(PaResultCode.PA_FAIL,null);
			result=JSON.toJSONString(obj);
		}
		return result;
	}
	@RequestMapping(value="/getPaphData" , method=RequestMethod.POST)
	public String getPaphData(@RequestBody Map<String, Object> param) throws Exception {
		String result=null;
		try {
			result=pspClaimApproveService.pspClaimApprove(param);
		} catch (Exception e) {
			e.printStackTrace();
			PaResult obj=PaResultGenerator.getDefMsgByCode(PaResultCode.PA_FAIL,null);
			result=JSON.toJSONString(obj);
		}
		return result;
	}
	@RequestMapping(value="/claimNotice" , method=RequestMethod.POST)
	public String claimNotice(@RequestBody Map<String, Object> param) throws Exception {
		String result=null;
		try {
			result=fO004003Service.service(param);
		} catch (Exception e) {
			e.printStackTrace();
			PaResult obj=PaResultGenerator.getDefMsgByCode(PaResultCode.PA_FAIL,null);
			result=JSON.toJSONString(obj);
		}
		return result;
	}
	@RequestMapping(value="/addSign" , method=RequestMethod.POST)
	public String addSign(@RequestBody Map<String, Object> param) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("param", PaEncryptUtil.encryptByRSA(JSONUtils.getSingleInstance().toJSon(param)));
		
		return jsonObject.toString();
	}
}
