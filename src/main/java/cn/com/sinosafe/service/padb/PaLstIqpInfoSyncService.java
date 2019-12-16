/**   
* @Title:：LstIqpInfoSyncService.java 
* @Package ：cn.com.sinosafe.service.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月4日 下午2:38:55 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb;

import cn.com.sinosafe.domain.entity.LstIqpInfo;

/** 
 * @ClassName:：LstIqpInfoSyncService 
 * @Description： 保单信息同步接口			
 * @author ：xiewei
 * @date ：2019年6月4日 下午2:38:55  
 */
public interface PaLstIqpInfoSyncService {
	
	/**
	 * 
	* @Title：infoSync 
	* @Description：推送保单信息同步给平安
	* @param ：@param liInfo
	* @param ：@return 
	* @return ：String 
	* @throws
	 */
	String infoSync(LstIqpInfo liInfo);

}
