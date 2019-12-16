package cn.com.sinosafe.controller.padb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.domain.entity.PAHAReq;
import cn.com.sinosafe.service.padb.PaphDispatcherService;

/**
 * 平安普惠独立承保相关接口
 * @Author	: hesong
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
@Log
@RestController
@RequestMapping("/cop/paph")
public class PaPhController {
	@Autowired
	private PaphDispatcherService dispatcherService;
	
	/**
	 * 平安普惠控制器总线
	 * @author	: hirson
	 * @date	: 2019年6月3日 下午8:00:00
	 * @param request	请求体
	 * @param id		参数
	 * @return			平安指定的参数格式
	 */
	@PostMapping(value="/dispatcher/{id}")
	public JSONObject requestDispatcher(@RequestBody PAHAReq pahaReq, @PathVariable() String id) {
		return dispatcherService.requestDispatcher(pahaReq, id);
	}

}
