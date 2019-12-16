package cn.com.sinosafe.service.padb;

import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.domain.entity.PAHAReq;

/**
 * 平安普惠控制器总线service
 * @Project	: haxb_partner
 * @Author	: hesong
 * @Date	: 2019年6月3日 下午8:02:49
 * @Version	: 1.0
 */
public interface PaphDispatcherService {

	JSONObject requestDispatcher(PAHAReq pahaReq, String id);
}
