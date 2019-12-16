package cn.com.sinosafe.common.util;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosafe.other.axsign.AxSignService;
/**   
 * @Title:：MyExecutor.java 
 * @Package ：cn.com.sinosafe.common.util 
 * @Description： 安心签签好的合同异步下载上传到华安影像系统
 * @author：xiewei
 * @date： 2019年6月10日 下午3:06:39 
 * @version ： 1.0   
 */
public class downUpContractListExecutor {
	private final static Logger logger = LoggerFactory.getLogger(downUpContractListExecutor.class);
	
	private ExecutorService executor = Executors.newCachedThreadPool();
	
	public void fun(String contractInfoList) throws Exception {
		executor.submit(new Runnable() {
			@Override
			public void run() {
				logger.info(Thread.currentThread()+"downUpContractListExecutor start*********************");
				try {
					AxSignService axSignService=new AxSignService();
					logger.info(Thread.currentThread()+"param:"+contractInfoList);
					//异步调用合同异步下载上传
					axSignService.downUpContractList(contractInfoList);
				} catch (Exception e) {
					logger.error(Thread.currentThread()+"errorInfo:"+e.getMessage());
//					throw new RuntimeException(e.getMessage());
				}
				logger.info(Thread.currentThread()+"downUpContractListExecutor end*********************");
			}
		});
	}
}
