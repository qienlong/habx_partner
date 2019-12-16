/**   
* @Title:：PaLstIqpDowloadMsgServiceImpl.java 
* @Package ：cn.com.sinosafe.service.padb.impl 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月5日 下午2:13:09 
* @version ： 1.0   
*/
package cn.com.sinosafe.service.padb.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.service.padb.PaLstIqpDowloadMsgService;

/** 
 * @ClassName:：PaLstIqpDowloadMsgServiceImpl 
 * @Description： 保单上传到sftp通知平安下载
 * @author ：xiewei
 * @date ：2019年6月5日 下午2:13:09  
 */
@Service
public class PaLstIqpDowloadMsgServiceImpl implements PaLstIqpDowloadMsgService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AsyncDealService asyncDealService;

	
	@Override
	public void lstDowloadMsg(List<String> sernos) {
		logger.info("*****************定时任务 start********************");
		logger.info("sernos is {}",sernos);
		try {
			if(null == sernos||sernos.isEmpty()){
				throw new BusinessException("param is null");
			}
			asyncDealService.asyncInfoMsg(sernos);
		} catch (Exception e) {
			logger.error("error:{}",e.getMessage());
			e.printStackTrace();
		}
		logger.info("*****************定时任务 end********************");
	}

	
}
