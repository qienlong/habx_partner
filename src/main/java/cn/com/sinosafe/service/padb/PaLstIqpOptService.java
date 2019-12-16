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
 * @ClassName:：PaLstIqpOptService 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月10日 上午10:26:37  
 */
public interface PaLstIqpOptService {
	/**
	* @Title：queryLstInfoByApplNo 
	* @Description：页面跳转数据查询接口
	* @param ：@param applNo 申请号
	* @param ：@return
	* @param ：@throws Exception 
	* @return ：Map<String,Object> 
	* @throws
	 */
	public String queryLstInfoByApplNo(String applNo);
	
	/**
	* getSmsCode 
	* @Description：获取短信验证码
	* @param ：@param applNo 申请号
	* @param ：@param cusId 客户id
	* @param ：@return
	* @param ：@throws Exception 
	* @return ：Map<String,Object> 
	* @throws
	 */
	public String getSmsCode(String applNo,String cusId);
	
	/**
	* confirmSign 
	* @Description：确认签署
	* @param ：@param applNo 申请号
	* @param ：@param cusId 客户id
	* @param ：@param code 验证码
	* @param ：@return
	* @param ：@throws Exception 
	* @return ：Map<String,Object> 
	* @throws
	 */
	public String confirmSign(String applNo,String cusId,String code,String ipAddr);
	/**
	 * confirmSignNo 
	 * @Description：确认签署
	 * @param ：@param applNo 申请号
	 * @param ：@param cusId 客户id
	 * @param ：@param code 验证码
	 * @param ：@return
	 * @param ：@throws Exception 
	 * @return ：Map<String,Object> 
	 * @throws
	 */
	public String confirmSignNo(String applNo,String cusId,String code,String ipAddr);
}
