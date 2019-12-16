package cn.com.sinosafe.controller.common;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.lina.common.protocol.ResultCode;

/**
 * 
 * 该微服务共用服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年7月9日<br>
 */
@Log
@RestController
@RequestMapping("/cop/system")
public class SystemController {
	
	@Resource
	private SystemConfig systemConfig;
	
	/**
	 * systemConfig表刷新
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/systemConfigCache")
	public JsonProtocol systemConfigCache() throws Exception {
		systemConfig.run(new String[] {});
		return new JsonProtocol().setup(ResultCode.SUCCESS);
	}

}
