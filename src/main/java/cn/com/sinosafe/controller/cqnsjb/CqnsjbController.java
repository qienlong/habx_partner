/**
 * 
 */
package cn.com.sinosafe.controller.cqnsjb;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.common.util.SpringUtils;
import cn.com.sinosafe.service.cqnsjb.CqnsjbService;

/**
 * 
 * 重庆农商借呗接口 <br>
 * @Author : fengxiaoyu <br>
 * @Date : 2019年9月25日<br>
 */
@Log
@RestController
@RequestMapping("/cqnsjb")
public class CqnsjbController {
	
	@PostMapping(value="/dispatcher/{type}")
	public String requestDispatcher(@RequestBody String params, @PathVariable("type") String type) throws Exception {
		CqnsjbService cqnsjbService = SpringUtils.getBean(type,CqnsjbService.class);
		return cqnsjbService.busiDeal(params);
	}
}
