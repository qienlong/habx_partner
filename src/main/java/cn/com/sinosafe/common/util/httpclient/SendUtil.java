/**   
* @Title:：SendUtil.java 
* @Package ：cn.com.sinosafe.common.util.httpclient 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月3日 下午2:55:45 
* @version ： 1.0   
*/
package cn.com.sinosafe.common.util.httpclient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

/** 
 * @ClassName:：SendUtil 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月3日 下午2:55:45  
 */
public class SendUtil {
	public static class UTF8PostMethod extends PostMethod {
		public UTF8PostMethod(String url) {
			super(url);
		}
		@Override
		public String getRequestCharSet() {
			return "UTF-8";
		}
	}
/**
 * 
 * @param url
 * @param msg
 * @param text  1为华保宗德格式，2为其他
 * @return
 */
	public static String httpSend(String url,String msg,String text) {
		String result = null;
		HttpClient client = new HttpClient();
		PostMethod postMethod = new UTF8PostMethod(url);
		try {
			RequestEntity entity = null;
			if(text.equals("1")){
			entity = new StringRequestEntity(msg, "application/json", "UTF-8");
			postMethod.setRequestEntity(entity);
			}else{
			entity = new StringRequestEntity(msg, "text/xml", "UTF-8");
			postMethod.setRequestEntity(entity);
			}
			int statusCode = client.executeMethod(postMethod);
			StringBuffer resultBuffer = new StringBuffer();
			if (statusCode == HttpStatus.SC_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						postMethod.getResponseBodyAsStream(), postMethod
								.getResponseCharSet()));
				String inputLine = null;
				while ((inputLine = in.readLine()) != null) {
					resultBuffer.append(inputLine);
				}
				in.close();

				try {
					result = new String(resultBuffer.toString().getBytes(
//					postMethod.getResponseCharSet()), "GBK");
					postMethod.getResponseCharSet()), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("statusCode != HttpStatus.SC_OK--------"+statusCode);
			}
		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			postMethod.releaseConnection();
		}
		return result;
	}
}
