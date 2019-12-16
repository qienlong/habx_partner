/**   
* @Title:：PaLstIqpInfoDowloadMsg.java 
* @Package ：cn.com.sinosafe.service.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月5日 下午2:09:13 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb;

import java.util.List;
import java.util.Map;

/** 
 * @ClassName:：PaLstIqpInfoDowloadMsg 
 * @Description： 华安生成保单pdf格式后上传平安sftp然后通知平安并返回文件信息
 * @author ：xiewei
 * @date ：2019年6月5日 下午2:09:13  
 */
public interface PaLstIqpDowloadMsgService {
	/**
	 * 
	* @Title：lstDowloadMsg 
	* @Description：调用平安接口，通知平安下载保单
	* @param ：@param paramMap
	* @param ：@return 
	* @return ：String 
	* @throws
	 */
	void lstDowloadMsg(List<String> sernos);
	
}
