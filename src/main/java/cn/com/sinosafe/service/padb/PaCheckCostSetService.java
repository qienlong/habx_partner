/**   
* @Title:：PaCheckCostSetService.java 
* @Package ：cn.com.sinosafe.service.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 上午11:54:19 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb;

import java.util.Map;

/** 
 * @ClassName:：PaCheckCostSetService 
 * @Description： 对公费用确认接口			
 * @author ：xiewei
 * @date ：2019年6月8日 上午11:54:19  
 */
public interface PaCheckCostSetService {
	String checkCostSet(Map<String,Object> paramMap) ;
}
