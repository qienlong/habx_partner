/**
 * 
 */
package cn.com.sinosafe.service.padb;

import java.util.Map;

/**  
* <p>Title: PspClaimApproveService</p>  
* <p>Description: 核赔申请服务</p>  
* @author longxiaoqiang  
* @date 2019年8月27日  
*/
public interface PspClaimApproveService {

	/**
	 * <p>Title: pspClaimApprove</p>  
	 * <p>Description: 核赔申请</p>  
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	String pspClaimApprove (Map<String, Object> paramMap) throws Exception;
}
