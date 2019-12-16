/**
 * 
 */
package cn.com.sinosafe.service.padb;

import java.util.Map;

/**  
* <p>Title: PspClaimNoticeService</p>  
* <p>Description: 理赔交易报盘接口服务</p>  
* @author longxiaoqiang  
* @date 2019年8月27日  
*/
public interface PspClaimNoticeService {

	/**
	 * <p>Title: pspClaimNotice</p>  
	 * <p>Description: 理赔交易报盘</p>  
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	String pspClaimNotice (Map<String, Object> paramMap) throws Exception;
}
