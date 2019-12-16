package cn.com.sinosafe.service.msxf;

import cn.com.sinosafe.domain.dto.MsxfResponse;

/**
 * 
 * 马上消费父接口 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年8月30日<br>
 */
public interface MsxfService {
	
	/**
	 * 业务逻辑执行方法
	 * @param param 请求参数
	 * @return
	 * @throws Exception
	 */
	public MsxfResponse busiDeal(String param) throws Exception;

}
