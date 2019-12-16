package cn.com.sinosafe.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cn.com.sinosafe.bigdata.other.ylm.YlmRequest;
import cn.com.sinosafe.common.config.constant.SystemConstant;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;

/**
 * 
 * 大数据相关服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年6月20日<br>
 */
@FeignClient(name = SystemConstant.BIGDATA)
public interface BigDataService {
	
	@PostMapping("other/ylmPy1362Query")
	public JsonProtocol ylmPy1362Query(@RequestBody YlmRequest request) throws Exception;
	
	/**
	  * 亚联和鹏元接口调用，如果设置了默认查鹏元且鹏元有该接口，则去查鹏元，否则查询亚联
	  * @return 
	  * @throws Exception
	  */
	 @PostMapping("other/ylmPyQuery")
	 public JsonProtocol ylmPyQuery(@RequestBody YlmRequest request) throws Exception;
}
