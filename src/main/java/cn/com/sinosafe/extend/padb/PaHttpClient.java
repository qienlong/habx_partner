package cn.com.sinosafe.extend.padb;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

/**
 * 平安普惠的http请求，带basic请求头
 * @author cnmobi_db
 */
@SuppressWarnings("deprecation")
@Component
public class PaHttpClient {

	/**
	 * 可添加一个请求头参数的POST请求
	 * @author	: hirson
	 * @date	: 2019年5月30日 下午4:55:21
	 * @param url		请求接口地址
	 * @param params	请求参数
	 * @return	:
	 */
	public String sendPostWithHeader(String url, Map<String,Object> params) {
	   	String responseContent = null;
	   	HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			if (url.startsWith("https")) {
				httpClient = createSSLClientDefault();
			}else {
				httpClient = new DefaultHttpClient();  
			} 

			httpPost = new HttpPost(url);
			List <NameValuePair> paramrs = new ArrayList<NameValuePair>();  
			if(params != null) {
				for(Entry<String, Object> entry : params.entrySet()) {
					paramrs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
				}
			}
	        httpPost.setEntity(new UrlEncodedFormEntity(paramrs,HTTP.UTF_8));
	        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
	        // 平安普惠的BASIC请求头
	        httpPost.setHeader("Authorization", "Basic SEFCWDo5bjZTNVV3Wg==");
			org.apache.http.HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "UTF-8");
					responseContent = result;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	   	return responseContent;
   }
    
    
	private  static CloseableHttpClient createSSLClientDefault(){
	  try {
	    SSLContext sslContext = new SSLContextBuilder().useProtocol("TLSv1.2").loadTrustMaterial(null, new TrustStrategy() {
			 @Override
			 public boolean isTrusted(X509Certificate[] chain,String authType) throws CertificateException {
    	            return true;
    	        }
	       
	    }).build();
	    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
	    return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	   } catch (KeyManagementException e) {
	       e.printStackTrace();
	   } catch (NoSuchAlgorithmException e) {
	       e.printStackTrace();
	   } catch (KeyStoreException e) {
	       e.printStackTrace();
	   }
	   return  HttpClients.createDefault();
	}
    
}