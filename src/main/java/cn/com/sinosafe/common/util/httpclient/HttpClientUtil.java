/**   
* @Title:：HttpClientUtil.java 
* @Package ：cn.com.sinosafe.common.util.httpclient 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月3日 下午2:35:30 
* @version ： 1.0   
*/
package cn.com.sinosafe.common.util.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosafe.common.util.StringUtils;
/** 
 * @ClassName:：HttpClientUtil 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月3日 下午2:35:30  
 */
public class HttpClientUtil extends SendUtil{
	private static final Logger log = LoggerFactory.getLogger(HttpClientUtil.class);
	
	// 连接主机超时（30s）
		public static final int HTTP_CONNECT_TIMEOUT_30S = 30 * 1000;

		// 从主机读取数据超时（3min）
		public static final int HTTP_READ_TIMEOUT_3MIN = 180 * 1000;

		/**
		 * httpPost
		 */
		public static String httpPost(String url, String jsonParam) throws ClientProtocolException, IOException {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			// 设置请求头和请求参数
			if (null != jsonParam && !jsonParam.isEmpty()) {
				StringEntity entity = new StringEntity(jsonParam, "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				httpPost.setEntity(entity);
			}//AuthorizationPair authorization 
			httpPost.setHeader("AuthorizationPair", "Basic SEFCWDo5bjZTNVV3Wg==");

			// 超时时间设置
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_READ_TIMEOUT_3MIN).setConnectTimeout(HTTP_CONNECT_TIMEOUT_30S).build();
			httpPost.setConfig(requestConfig);

			// 发送请求
			CloseableHttpResponse response = httpclient.execute(httpPost);

			// 获取返回内容
			try {
				HttpEntity entity = response.getEntity();
				String str = EntityUtils.toString(entity);
				EntityUtils.consume(entity); // 此句关闭了流
				return str;
			}finally {
				response.close();
			}
		}
		/**
		 * httpPostPh
		 */
		public static String httpPostPh(String url, String jsonParam) throws ClientProtocolException, IOException {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			// 设置请求头和请求参数
			if (null != jsonParam && !jsonParam.isEmpty()) {
				StringEntity entity = new StringEntity(jsonParam, "utf-8");
				entity.setContentEncoding("UTF-8");
				httpPost.setEntity(entity);
				entity.setContentType("application/json");
			}
			httpPost.addHeader("Accept", "application/json");
			// 超时时间设置
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_READ_TIMEOUT_3MIN).setConnectTimeout(HTTP_CONNECT_TIMEOUT_30S).build();
			httpPost.setConfig(requestConfig);
			
			// 发送请求
			CloseableHttpResponse response = httpclient.execute(httpPost);
			
			// 获取返回内容
			try {
				HttpEntity entity = response.getEntity();
				String str = EntityUtils.toString(entity);
				EntityUtils.consume(entity); // 此句关闭了流
				return str;
			}finally {
				response.close();
			}
		}

		/**
		 * httpPost get Cookies
		 */
		public static Map<String, Object> httpPostGetCookies(String url, String jsonParam) throws ClientProtocolException, IOException {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);

			// 设置请求头和请求参数
			if (null != jsonParam && !jsonParam.isEmpty()) {
				StringEntity entity = new StringEntity(jsonParam, "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				httpPost.setEntity(entity);
			}

			// 超时时间设置
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_READ_TIMEOUT_3MIN).setConnectTimeout(HTTP_CONNECT_TIMEOUT_30S).build();
			httpPost.setConfig(requestConfig);

			// 发送请求
			CloseableHttpResponse response = httpclient.execute(httpPost);

			// 获取返回内容
			try {
				HttpEntity entity = response.getEntity();
				String str = EntityUtils.toString(entity);
				EntityUtils.consume(entity); // 此句关闭了流

				// 获取数据内容
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("result", str);

				// 获取返回到额Cookies
				Header[] headers = response.getHeaders("Set-Cookie");
				map.put("cookies", headers);

				return map;
			} finally {
				response.close();
			}
		}

		/**
		 * httpGet
		 */
		public static String httpGet(String url) throws ClientProtocolException, IOException {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);

			// 超时时间设置
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_READ_TIMEOUT_3MIN).setConnectTimeout(HTTP_CONNECT_TIMEOUT_30S).build();
			httpGet.setConfig(requestConfig);

			// 发送请求
			CloseableHttpResponse response = httpclient.execute(httpGet);

			// 获取返回内容
			try {
				HttpEntity entity = response.getEntity();
				String strResult = EntityUtils.toString(entity);
				return strResult;
			} finally {
				response.close();
			}
		}

		/**
		 * httpGet with Cookies
		 */
		public static String httpGetWithCookies(String url, Header[] headers) throws ClientProtocolException, IOException {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);

			// 超时时间设置
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_READ_TIMEOUT_3MIN).setConnectTimeout(HTTP_CONNECT_TIMEOUT_30S).build();
			httpGet.setConfig(requestConfig);

			// 设置请求头
			if (headers != null && headers.length > 0) {
				httpGet.setHeaders(headers);
			}

			// 发送请求
			CloseableHttpResponse response = httpclient.execute(httpGet);

			// 获取返回内容
			try {
				HttpEntity entity = response.getEntity();
				String strResult = EntityUtils.toString(entity);
				return strResult;
			} finally {
				response.close();
			}
		}
		
		
		/**
	     * 向指定 URL 发送POST方法的请求
	     *
	     * @param url 发送请求的 URL
	     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	     * @return 所代表远程资源的响应结果
	     */
	    public static String sendPost(String url, String param)
	    {
	        PrintWriter out = null;
	        BufferedReader in = null;
	        StringBuilder result = new StringBuilder();
	        try
	        {
	            String urlNameString = url + "?" + param;
	            log.info("sendPost - {}", urlNameString);
	            URL realUrl = new URL(urlNameString);
	            URLConnection conn = realUrl.openConnection();
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            conn.setRequestProperty("Accept-Charset", "utf-8");
	            conn.setRequestProperty("contentType", "utf-8");
	            conn.setRequestProperty("AuthorizationPair", "Basic SEFCWDo5bjZTNVV3Wg==");
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            out = new PrintWriter(conn.getOutputStream());
	            out.print(param);
	            out.flush();
	            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	            String line;
	            while ((line = in.readLine()) != null)
	            {
	                result.append(line);
	            }
	            log.info("recv - {}", result);
	        }
	        catch (ConnectException e)
	        {
	            log.error("调用HttpUtils.sendPost ConnectException, url=" + url + ",param=" + param, e);
	        }
	        catch (SocketTimeoutException e)
	        {
	            log.error("调用HttpUtils.sendPost SocketTimeoutException, url=" + url + ",param=" + param, e);
	        }
	        catch (IOException e)
	        {
	            log.error("调用HttpUtils.sendPost IOException, url=" + url + ",param=" + param, e);
	        }
	        catch (Exception e)
	        {
	            log.error("调用HttpsUtil.sendPost Exception, url=" + url + ",param=" + param, e);
	        }
	        finally
	        {
	            try
	            {
	                if (out != null)
	                {
	                    out.close();
	                }
	                if (in != null)
	                {
	                    in.close();
	                }
	            }
	            catch (IOException ex)
	            {
	                log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
	            }
	        }
	        return result.toString();
	    }

	    public static String sendSSLPost(String url, String param)
	    {
	        StringBuilder result = new StringBuilder();
	        String urlNameString = url + "?" + param;
	        try
	        {
	            log.info("sendSSLPost - {}", urlNameString);
	            SSLContext sc = SSLContext.getInstance("SSL");
	            sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
	            URL console = new URL(urlNameString);
	            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            conn.setRequestProperty("Accept-Charset", "utf-8");
	            conn.setRequestProperty("contentType", "utf-8");
	            conn.setDoOutput(true);
	            conn.setDoInput(true);

	            conn.setSSLSocketFactory(sc.getSocketFactory());
	            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
	            conn.connect();
	            InputStream is = conn.getInputStream();
	            BufferedReader br = new BufferedReader(new InputStreamReader(is));
	            String ret = "";
	            while ((ret = br.readLine()) != null)
	            {
	                if (ret != null && !ret.trim().equals(""))
	                {
	                    result.append(new String(ret.getBytes("ISO-8859-1"), "utf-8"));
	                }
	            }
	            log.info("recv - {}", result);
	            conn.disconnect();
	            br.close();
	        }
	        catch (ConnectException e)
	        {
	            log.error("调用HttpUtils.sendSSLPost ConnectException, url=" + url + ",param=" + param, e);
	        }
	        catch (SocketTimeoutException e)
	        {
	            log.error("调用HttpUtils.sendSSLPost SocketTimeoutException, url=" + url + ",param=" + param, e);
	        }
	        catch (IOException e)
	        {
	            log.error("调用HttpUtils.sendSSLPost IOException, url=" + url + ",param=" + param, e);
	        }
	        catch (Exception e)
	        {
	            log.error("调用HttpsUtil.sendSSLPost Exception, url=" + url + ",param=" + param, e);
	        }
	        return result.toString();
	    }

	    private static class TrustAnyTrustManager implements X509TrustManager
	    {
	        @Override
	        public void checkClientTrusted(X509Certificate[] chain, String authType)
	        {
	        }

	        @Override
	        public void checkServerTrusted(X509Certificate[] chain, String authType)
	        {
	        }

	        @Override
	        public X509Certificate[] getAcceptedIssuers()
	        {
	            return new X509Certificate[] {};
	        }
	    }

	    private static class TrustAnyHostnameVerifier implements HostnameVerifier
	    {
	        @Override
	        public boolean verify(String hostname, SSLSession session)
	        {
	            return true;
	        }
	    }
	    
	    /**
	     * Map参数转&连接符形式的http请求参数
	     * @author	: hirson
	     * @date	: 2019年1月16日 上午9:52:20
	     * @param method	http请求类型：get、post、put、delete
	     * @param paramMap	参数map
	     * @return	:
	     */
	    public static String httpParamConver(Map<String, String> paramMap) {
			StringBuffer param = new StringBuffer();
			for (String key : paramMap.keySet()) {
			    param.append("&");
				Object value = paramMap.get(key);
				if (value == null) continue;
				
				//如果是数据，说明需要拼接一个参数多个值
				if (value.getClass().isArray())
				    param.append(concatParams(key, (Object[]) value));
				else
				    param.append(key).append("=").append(value);
			}
			return param.toString();
	    }
	    
	    /**
	     * 拼接一个参数多个值情况
	     * @param key
	     * @param values
	     * @return
	     */
	    private static String concatParams(String key, Object[] values) {
	        StringBuffer buffer = new StringBuffer();
	        int i = 0;
	        for (Object value: values) {
	            if (i != 0)
	                buffer.append("&");
	            buffer.append(key).append("=").append(value);
	            i++;
	        }
	        return buffer.toString();
	    }
	    
	    @SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
		public static String sendPost(String url, Map<String, Object> params) {
	    	String result = null;  
	        try{  
	        	HttpClient httpClient = null;  
	        	HttpPost httpPost = null;  
	        	
	            httpClient = new DefaultHttpClient();  
	            httpPost = new HttpPost(url);  
	            //设置参数  
	            List<NameValuePair> list = new ArrayList<NameValuePair>();  
	            Iterator iterator = params.entrySet().iterator();  
	            while(iterator.hasNext()){  
	                Entry<String,String> elem = (Entry<String, String>) iterator.next();  
	                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
	            }  
	            if(list.size() > 0){  
	                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");  
	                httpPost.setEntity(entity);  
	            }
	           long t = System.currentTimeMillis();
	            HttpResponse response = httpClient.execute(httpPost);  
	            if(response != null){  
	                HttpEntity resEntity = response.getEntity();  
	                if(resEntity != null){  
	                    result = EntityUtils.toString(resEntity,"GBK");
	                }  
	            }  
	        }catch(Exception ex){  
	            ex.printStackTrace();  
	        }
			return result;
		}
	    
	    @SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
		public static String sendPost_(String url, Map<String, Object> params, String charset) {
	    	String result = null;
	        try{  
	        	HttpClient httpClient = null;  
	        	HttpPost httpPost = null;  
	        	
	            httpClient = new DefaultHttpClient();  
	            httpPost = new HttpPost(url);  
	            //设置参数  
	            List<NameValuePair> list = new ArrayList<NameValuePair>();  
	            Iterator iterator = params.entrySet().iterator();  
	            while(iterator.hasNext()){  
	                Entry<String,String> elem = (Entry<String, String>) iterator.next();  
	                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
	            }  
	            if(list.size() > 0){  
	                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);  
	                httpPost.setEntity(entity);  
	            }
	           long t = System.currentTimeMillis();
	            HttpResponse response = httpClient.execute(httpPost);  
	            if(response != null){  
	                HttpEntity resEntity = response.getEntity();  
	                if(resEntity != null){  
	                    result = EntityUtils.toString(resEntity, charset);
	                }  
	            }  
	        }catch(Exception ex){  
	            ex.printStackTrace();  
	        }
			return result;
		}
	  
	    /**
	     * 向指定 URL 发送GET方法的请求
	     *
	     * @param url 发送请求的 URL
	     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	     * @return 所代表远程资源的响应结果
	     */
	    public static String sendGet(String url, String param)
	    {
	        StringBuilder result = new StringBuilder();
	        BufferedReader in = null;
	        try
	        {
	            String urlNameString = url + "?" + param;
	            log.info("sendGet - {}", urlNameString);
	            URL realUrl = new URL(urlNameString);
	            URLConnection connection = realUrl.openConnection();
	            connection.setRequestProperty("accept", "*/*");
	            connection.setRequestProperty("connection", "Keep-Alive");
	            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            connection.connect();
	            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null)
	            {
	                result.append(line);
	            }
	            log.info("recv - {}", result);
	        }
	        catch (ConnectException e)
	        {
	            log.error("调用HttpUtils.sendGet ConnectException, url=" + url + ",param=" + param, e);
	        }
	        catch (SocketTimeoutException e)
	        {
	            log.error("调用HttpUtils.sendGet SocketTimeoutException, url=" + url + ",param=" + param, e);
	        }
	        catch (IOException e)
	        {
	            log.error("调用HttpUtils.sendGet IOException, url=" + url + ",param=" + param, e);
	        }
	        catch (Exception e)
	        {
	            log.error("调用HttpsUtil.sendGet Exception, url=" + url + ",param=" + param, e);
	        }
	        finally
	        {
	            try
	            {
	                if (in != null)
	                {
	                    in.close();
	                }
	            }
	            catch (Exception ex)
	            {
	                log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
	            }
	        }
	        return result.toString();
	    }
	    
	public static String getIpaddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}

	public static String sendPosts(String url, String jsonParam) throws Exception {
		String resultMsg = null;
		try {
			resultMsg = HttpClientUtil.httpPost(url, jsonParam);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMsg;
	}

	/**
	 * @Description 发送xml post请求
	 * @Date 2019/9/6 9:51
	 * @param url
	 * @param xml
	 * @return java.lang.String
	 */
	public static String doPostXML(String url,String xml){
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try{
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Content-Type", "application/xml; charset=UTF-8");
			httpClient = HttpClients.createDefault();
			StringEntity entityParams = new StringEntity(xml,"utf-8");
			httpPost.setEntity(entityParams);
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpPost);
			String resultMsg = EntityUtils.toString(response.getEntity(),"utf-8");
			return resultMsg;
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(response!=null){
					response.close();
				}
				if(httpClient != null){
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 携带请求参数的GET请求
	 *
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doGet(String url, Map<String, String> params) {
		//
		String result = "";
		// 1.创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			// 2.创建uri对象
			URIBuilder builder = new URIBuilder(url);
			if (params != null) {
				Set<Entry<String, String>> entrySet = params.entrySet();
				for (Map.Entry<String, String> entry : entrySet) {
					builder.addParameter(entry.getKey(),entry.getValue());
				}
			}
			URI uri = builder.build();
			// 3.创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			// 4.执行请求
			response = httpclient.execute(httpGet);
			// 5.判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				// 6.进行UTF-8编码处理
				result = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
				result = "error";
			}
		}
		return result;
	}
}
