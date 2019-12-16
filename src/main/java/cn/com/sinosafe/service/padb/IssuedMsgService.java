/**   
* @Title:：PolicyGenerationMsgService.java 
* @Package ：cn.com.sinosafe.service.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月3日 上午11:41:39 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb;

import java.util.Map;


/** 
 * @ClassName:：PolicyGenerationMsgService 
 * @Description： 保单生成通知
 * @author ：xiewei
 * @date ：2019年6月3日 上午11:41:39  
 */
public interface IssuedMsgService {
	/**
	 * 
	* @Title：issuePolicy 
	* @Description：保单出单通知接口
	* @param ：@param policyInfo 保单信息
	* @param ：@param extendList 保单扩展信息
	* @param ：@param insuCompany 保险公司
	* @param ：@param source 来源方
	* @param ：@param json
	* @param ：@return 
	* @return ：int 
	* @throws
	 */
	String issuePolicy(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 
	* @Title：getpolicyDataByTemplate 
	* @Description：根据模板类型返回模板数据
	* @param ：@param templateType
	* @param ：@param serNo
	* @param ：@return 
	* @return ：Map<String,Object> 
	* @throws
	 */
	Map<String, Object> getpolicyDataByTemplate(String templateType,String serNo) throws Exception;
}
