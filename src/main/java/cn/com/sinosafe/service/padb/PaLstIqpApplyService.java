/**   
* @Title:：PaLstIqpApplyService.java 
* @Package ：cn.com.sinosafe.service.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月5日 下午2:30:08 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb;

import java.util.Map;

/** 
 * @ClassName:：PaLstIqpApplyService 
 * @Description： 投保申请接口
 * @author ：xiewei
 * @date ：2019年6月5日 下午2:30:08  
 */
public interface PaLstIqpApplyService {
	/**
	 * 
	* @Title：lstIqpApplyNoSign 
	* @Description：投保申请未签署处理接口
	* @param ：@param paramMap 
	* @return ：void 
	* @throws
	 */
	String lstIqpApplyNoSign(Map<String, Object> paramMap) throws Exception;
}
