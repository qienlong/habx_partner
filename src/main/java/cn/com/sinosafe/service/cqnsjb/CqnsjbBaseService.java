/**
 * 
 */
package cn.com.sinosafe.service.cqnsjb;

/**
 * 
 * 重庆农商借呗服务父类 <br>
 * @Author : fengxiaoyu <br>
 * @Date : 2019年9月26日<br>
 */
public interface CqnsjbBaseService {
	/**
	 * 业务逻辑执行方法
	 * @param param 请求参数
	 * @return
	 * @throws Exception
	 */
	public String busiDeal(String param) throws Exception;
}
