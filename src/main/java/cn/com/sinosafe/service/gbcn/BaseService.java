package cn.com.sinosafe.service.gbcn;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.dom.DOMSource;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.SpringUtils;
import cn.com.sinosafe.common.util.ThreadLocalUtil;
import cn.com.sinosafe.common.util.XmlUtil;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.TElecPolicyInfo;
import cn.com.sinosafe.domain.gbcn.response.BaseResponse.ResponseBody;
import cn.com.sinosafe.domain.gbcn.response.BaseResponse.ResponseHead;
import cn.com.sinosafe.domain.gbcn.response.GBResponse;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.lina.common.protocol.ResultCode;

import com.alibaba.fastjson.JSONObject;

@Service
public class BaseService extends CommonService{
	
    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);
    
	@SuppressWarnings("unchecked")
	public String invoke(DOMSource domsource, String type){
		String sessionID = "gbcn"+DateUtils.getMillisecond();
		MDC.put("sessionID",sessionID);
		ThreadLocalUtil.set("sessionID", sessionID);
		ResponseBody responseBody = null;
		Object resultObj = null;
		String result = null;
		GBResponse<?> gbResult = null;
		try {
			String requestXml = XmlUtil.parseDOMSource(domsource);
			Map<String, String> map = getInputInfo(ThreadLocalUtil.get("request"));
			logger.info("【请求自IP：{}】 ====>>>>【{}】请求参数：{}", map.get("ip"), map.get("url"), requestXml);
			GbcnService<ResponseBody, String> gbcnService = (GbcnService<ResponseBody, String>) 
					SpringUtils.getBean(type);
			Method method = gbcnService.getClass().getMethod("getResultObj");
			gbResult =  (GBResponse<?>) method.invoke(gbcnService);
			// 验签
			doAuth(requestXml);
			responseBody = gbcnService.process(requestXml);
		} catch (BusinessException e) {
			responseBody = new ResponseBody(DateUtils.getDateTime(), false,
					e.getMessage());
		} catch (Exception e) {
			logger.info(e.getMessage());
			responseBody = new ResponseBody(DateUtils.getDateTime(), false,
					"处理异常，请联系系统管理员！");
		} finally {
			ResponseHead responseHead = new ResponseHead(UUID.randomUUID().toString().
					replaceAll("-", "").toUpperCase(),tosign(responseBody));
			try {
			Constructor<?> constructor = gbResult.getObj().getClass()
						.getConstructor(ResponseHead.class,ResponseBody.class);
			 resultObj = constructor.newInstance(responseHead,responseBody);
			  result = XmlUtil.toXML(resultObj);
			} catch (Exception e){}
			  finally {
			logger.info("发送给工保网-->方法-->"+type+":"+ result);
			MDC.clear();
			ThreadLocalUtil.remove();
			}
		}
		return result;
	}
	
	public JsonProtocol callBank(JSONObject requestJson,String type){
		try {
			@SuppressWarnings("unchecked")
			GbcnService<JsonProtocol, JSONObject> gbcnService = 
					(GbcnService<JsonProtocol, JSONObject>) SpringUtils.getBean(type);
			Map<String, String> map = getInputInfo(ThreadLocalUtil.get("request"));
			ThreadLocalUtil.set("ip",map.get("ip"));
			ThreadLocalUtil.set("url",map.get("url"));
			return gbcnService.process(requestJson);
		} catch (Exception e) {
			logger.error("处理异常，请联系系统管理员！", e);
			JsonProtocol jsonProtocol = new JsonProtocol();
			return jsonProtocol.setup(ResultCode.SERVER_ERROR);
		} finally {
			ThreadLocalUtil.remove();
			MDC.clear();
		}
	}

	public JsonProtocol query(JSONObject requestJson) {
		JsonProtocol jsonProtocol = new JsonProtocol();
		JSONObject data = new JSONObject();
		String listSerno = requestJson.getString("listSerno");
		String iqpLoanSerno = requestJson.getString("iqpLoanSerno");
		if(!StringUtils.hasText(listSerno)&&StringUtils.hasText(iqpLoanSerno)){
			LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByIqpLoanSerno1(iqpLoanSerno);
			if (ObjectUtils.isEmpty(lstIqpInfo)) {
				jsonProtocol.setMessage("根据业务流水找不到对应的保单");
				return jsonProtocol;
			}
			if (!StringUtils.hasText(lstIqpInfo.getListSerno())) {
				jsonProtocol.setMessage("该业务流水没有生成保单，请检查支付是否已完成");
				return jsonProtocol;
			}
			listSerno = lstIqpInfo.getListSerno();
		}
        //查询电子保单、再查询电子保函
		Map<String,String> params = new HashMap<String, String>();
		params.put("listSerno", listSerno);
		params.put("projectType", "gcbh");
        String gcbhResult = HttpClientUtil.doGet(SystemConfig.cacheMap.get("GBCN_SEAL_URL")+"/querySealResult", params);
        JSONObject jsonGcbh = JSONObject.parseObject(gcbhResult);
        //保函
        if("0".equals(jsonGcbh.getString("code"))){
        	String pdfUrl = jsonGcbh.getString("data");
        	pdfUrl = pdfUrl.replaceAll("http://(\\d+\\.\\d+\\.\\d+\\.\\d+)\\:(\\d+)",  SystemConfig.cacheMap.get("GBCN_INSURE_DOWNLOAD_URL"));
            pdfUrl = getQueryUrl(pdfUrl);
            data.put("gcbhUrl", pdfUrl);
        }
		params.put("projectType", "gcbd");
		//保单
        String gcbdResult = HttpClientUtil.doGet(SystemConfig.cacheMap.get("GBCN_SEAL_URL")+"/querySealResult", params);
        JSONObject jsonGcbd = JSONObject.parseObject(gcbdResult);
        if("0".equals(jsonGcbd.getString("code"))){
        	String pdfUrl = jsonGcbd.getString("data");
        	pdfUrl = pdfUrl.replaceAll("http://(\\d+\\.\\d+\\.\\d+\\.\\d+)\\:(\\d+)", SystemConfig.cacheMap.get("GBCN_INSURE_DOWNLOAD_URL"));
            pdfUrl = getQueryUrl(pdfUrl);
            data.put("gcbdUrl", pdfUrl);
        }
        //发票
        TElecPolicyInfo telcPolicyInfo = tElecPolicyInfoMapper.selectByPolicyNo(listSerno);
        if(telcPolicyInfo!=null&&StringUtils.hasText(telcPolicyInfo.getShortUrl())){
            data.put("invoice", telcPolicyInfo.getShortUrl());
        }
        jsonProtocol.setup(1,data);
		return jsonProtocol;
	}

	public String downloadFile(HttpServletResponse response, String applNo) throws Exception{
		if(!StringUtils.hasText(applNo)||applNo.length()<3){
			 return "下载失败";  
        }
		String flag = applNo.substring(applNo.length() -2,applNo.length());
		String download = applNo.substring(0,applNo.length() -2);
		// 被下载文件的名称 
		String fileName = null;
	      if("bd".equals(flag)){
		  		 fileName = "sinosafe_bd_"+download + ".pdf";
	      }else if("bh".equals(flag)){
		  		 fileName = "sinosafe_bh_"+download + ".pdf";
		  }else{
			  return "下载失败";  
		  }
       String surl = (String) redisUtils.getValue(applNo);
       if(!StringUtils.hasText(surl)){
       	 return "下载失败";  
       }
	   response.setContentType("application/x-msdownload");
       response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
       byte[] buffer = new byte[ 1024 * 8];
       BufferedInputStream bis = null;
	   CloseableHttpClient httpClient = HttpClients.createDefault();
       HttpGet httpGet = new HttpGet();
       httpGet.setURI(URI.create(surl));
       CloseableHttpResponse response2 = httpClient.execute(httpGet);
       // 获得响应的实体对象
       HttpEntity entity = response2.getEntity();
       // 获取到响应信息的流
       InputStream fis = entity.getContent();
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
	
}
