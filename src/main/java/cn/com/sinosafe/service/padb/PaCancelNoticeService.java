/**   
* @Title:：CancelNoticeService.java 
* @Package ：cn.com.sinosafe.service.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午7:52:27 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb;

import java.util.Map;

/** 
 * @ClassName:：CancelNoticeService 
 * @Description： 退汇取消通知接口			
 * @author ：xiewei
 * @date ：2019年6月8日 下午7:52:27  
 */
public interface PaCancelNoticeService {
	//注销保单，冲销掉全部应收费用科目
	String cancelRemitAll(Map<String, Object> paramMap) throws Exception;
}
