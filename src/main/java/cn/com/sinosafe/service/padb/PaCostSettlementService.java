/**   
* @Title:：PaCostSettlementService.java 
* @Package ：cn.com.sinosafe.service.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 上午11:45:05 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb;

import java.util.Map;

/** 
 * @ClassName:：PaCostSettlementService 
 * @Description： 对公费用结算接口（供平安调用）
 * @author ：xiewei
 * @date ：2019年6月8日 上午11:45:05  
 */
public interface PaCostSettlementService {
	String infoSync(Map<String, Object> paramMap) throws Exception;
}
