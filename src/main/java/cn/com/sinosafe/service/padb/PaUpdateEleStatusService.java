/**   
* @Title:：PaLstIqpOptService.java 
* @Package ：cn.com.sinosafe.service.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月10日 上午10:26:37 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb;

import java.util.Map;

/** 
 * @ClassName:：PaUpdateEleStatusService 
 * @Description： TODO
 * @author ：longxiaoqiang
 * @date ：2019年6月10日 上午10:26:37  
 */
public interface PaUpdateEleStatusService {
	/**
	* @Title：updateEleStatus 
	* @Description：电子保单生成成功更新状态
	* @param ：@param listSerno 保单号
	* @return ：String
	* @throws
	 */
	public String updateEleStatus(Map<String, Object> map);
	
}
