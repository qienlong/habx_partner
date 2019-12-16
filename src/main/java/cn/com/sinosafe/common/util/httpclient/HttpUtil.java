package cn.com.sinosafe.common.util.httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @Author xiehanchun
 * @Time 2019/8/6 9:47
 * @Version 1.0
 */
public class HttpUtil {
    private static final int READ_TIME_MS = 10000;
    private static final int CONNECT_TIME_MS = 10000;
    private static final String CHARSET = Constants.CHARSET;
    private static HttpClient HTTPCLIENT;
    private static final Object LOCK = new Object();

    // 连接主机超时（30s）
    public static final int HTTP_CONNECT_TIMEOUT_30S = 30 * 1000;

    // 从主机读取数据超时（3min）
    public static final int HTTP_READ_TIMEOUT_3MIN = 180 * 1000;

    /**
	 * POST请求的方式数据放入请求体，以application/xml的方式
	 * MQ调用方法
	 * @param url
	 * @param params
	 * @return
	 */
	public static String sendPostWithXml(String url, String params) {
		// 响应结果
		String responseContent = null;

		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = HttpClients.createDefault();
			httpPost = new HttpPost(url);
			// 解决中文乱码问题 httpPost.setEntity(entity);
			StringEntity entity = new StringEntity(params, CHARSET);
			httpPost.setEntity(entity);
			httpPost.setHeader("Content-Type", "application/xml");
			org.apache.http.HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, CHARSET);
					responseContent = result;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseContent;
	}



    public static String doPost(String url, Map<String, String> param) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        if (param != null && !param.isEmpty()) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(parameters, CHARSET);
        httpPost.setEntity(postEntity);
        //请求头设置 表单提交
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");

        // 超时时间设置
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(HTTP_READ_TIMEOUT_3MIN).setConnectTimeout(HTTP_CONNECT_TIMEOUT_30S).build();
        httpPost.setConfig(requestConfig);

//        HttpResponse httpResponse = getHttpClient().execute(httpPost);
//        HttpEntity httpEntity = httpResponse.getEntity();

        // 发送请求
        CloseableHttpResponse response = httpclient.execute(httpPost);

        // 获取返回内容
        try {
            HttpEntity entity = response.getEntity();
//            String str = EntityUtils.toString(entity);
            String str = EntityUtils.toString(entity, CHARSET);
            EntityUtils.consume(entity); // 此句关闭了流
            return str;
        }finally {
            response.close();
        }
    }


    private static HttpClient getHttpClient() {
        if (HTTPCLIENT == null) {
            synchronized (LOCK) {
                if (HTTPCLIENT == null) {
                    initHttpClient();
                }
            }
        }
        return HTTPCLIENT;
    }


    private static void initHttpClient() {

        BasicHttpClientConnectionManager connManager =
                new BasicHttpClientConnectionManager(RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.getSocketFactory())
                        .register("https", SSLConnectionSocketFactory.getSocketFactory()).build(), null, null, null);
        RequestConfig.Builder rBuilder = RequestConfig.custom();
        rBuilder.setSocketTimeout(READ_TIME_MS).setConnectTimeout(CONNECT_TIME_MS).build();
        if (Constants.PROXY) {
            // 代理设置
            HttpHost proxy = new HttpHost("10.189.6.187", 8080, "http");
            rBuilder.setProxy(proxy);
        }

        RequestConfig requestConfig = rBuilder.build();
        HTTPCLIENT = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).disableAutomaticRetries().setConnectionManager(connManager).build();
    }

}
