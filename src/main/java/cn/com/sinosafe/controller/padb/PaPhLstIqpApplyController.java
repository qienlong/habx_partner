/**   
* @Title:：PaPhLstIqpApplyController.java 
* @Package ：cn.com.sinosafe.controller.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月10日 上午10:12:05 
* @version ： 1.0   
*/
package cn.com.sinosafe.controller.padb;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.IpAddressUtils;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.service.padb.PaLstIqpOptService;

/**
 * 平安普惠独立承保投保申请相关接口
 * @Author	: hesong
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
@Log
@RestController
@RequestMapping("/pa/lst_apply")
public class PaPhLstIqpApplyController {
	
	@Autowired
	private PaLstIqpOptService paLstIqpOptService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * 平安投保申请页面跳转及数据查询
	 * @author	: 谢威
	 * @date	: 2019年6月10日 下午10:00:00
	 * @param request	请求体
	 * @param id		参数
	 * @return			平安指定的参数格式
	 */
	@RequestMapping(value="/queryInfo" , method=RequestMethod.POST)
	public JSONObject queryInfo(@RequestBody Map<String, String> map) {//@RequestParam Map<String, Object> param
		String obj=paLstIqpOptService.queryLstInfoByApplNo(map.get("applNo"));
		return JSONObject.fromObject(obj);
	}
	
	/**
	 * 平安投保申请发送授权验证码
	 * @author	: 谢威
	 * @date	: 2019年6月10日 下午10:00:00
	 * @param request	请求体
	 * @param id		参数
	 * @return			平安指定的参数格式
	 */
	@RequestMapping(value="/sendSms" , method=RequestMethod.POST)
	public JSONObject sendSms(@RequestBody Map<String, String> map) {
		
		String flag = SystemConfig.cacheMap.get("sign_flag");
		JSONObject jsonDate = new JSONObject();
		jsonDate.put("resultCode", PaResultCode.PA_SUCCESS.code());
		jsonDate.put("resultMsg", PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
		if ("YES".equals(flag)) {
			jsonDate = JSONObject.fromObject(paLstIqpOptService.getSmsCode(map.get("applNo"), map.get("cusId")));
		} 
		return jsonDate;
	}
	
	/**
	 * 平安投保申请确认验证码
	 * @author	: 谢威
	 * @date	: 2019年6月10日 下午10:00:00
	 * @param request	请求体
	 * @param id		参数
	 * @return			平安指定的参数格式
	 */
	@RequestMapping(value="/confirmSign" , method=RequestMethod.POST)
	public JSONObject confirmSign(@RequestBody Map<String, String> map) {
		//通过开关判断确认验证的服务
		String flag = SystemConfig.cacheMap.get("sign_flag");
		String obj = "";
		if ("YES".equals(flag)) {
			obj=paLstIqpOptService.confirmSign(map.get("applNo"), map.get("cusId"), map.get("code"), IpAddressUtils.getIpAddr(request));
		} else {
			obj=paLstIqpOptService.confirmSignNo(map.get("applNo"), map.get("cusId"), map.get("code"), IpAddressUtils.getIpAddr(request));
		}
		return JSONObject.fromObject(obj);
	}
	
}
