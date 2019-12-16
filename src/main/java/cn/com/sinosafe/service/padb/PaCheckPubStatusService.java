/**   
* @Title:：PaLstIqpOptService.java 
* @Package ：cn.com.sinosafe.service.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月10日 上午10:26:37 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb;

/** 
 * @ClassName:：PaCheckPubStatusService 
 * @Description： TODO
 * @author ：longxiaoqiang
 * @date ：2019年6月10日 上午10:26:37  
 */
public interface PaCheckPubStatusService {
	/**
	* @Title：checkPubStatus 
	* @Description：对公还款核实
	* @param ：@param map 参数
	* @return ：String
	* @throws
	 */
	public String checkPubStatus();
	/**
	 * @Title：claimResultNotice 
	 * @Description：理赔结果通知
	 * @param ：@param map 参数
	 * @return ：String
	 * @throws
	 */
	public String claimResultNotice();
	/**
	 * @Title：claimFailNotice 
	 * @Description：理赔支付失败邮件预警
	 * @param ：@param map 参数
	 * @return ：String
	 * @throws
	 */
	public String claimFailNotice();
	
}
