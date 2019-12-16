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

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.service.padb.PaCheckCostSetService;

/**
 * 平安普惠独立对公费用确认相关接口
 * @Author	: hesong
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
@Log
@RestController
@RequestMapping("/pa/costset")
public class PaPhCheckCostSetController {
	
	@Autowired
	private PaCheckCostSetService paCheckCostSetService;
	
	/**
	 * 平安普惠独立对公费用确认相关接口
	 * @author	: 谢威
	 * @date	: 2019年6月10日 下午10:00:00
	 * @param request	请求体
	 * @param id		参数
	 * @return			平安指定的参数格式
	 */
	@RequestMapping(value="/check" , method=RequestMethod.POST)
	public String queryInfo(@RequestBody Map<String, Object> map) {//@RequestParam Map<String, Object> param
		String result = paCheckCostSetService.checkCostSet(map);
		return result;
	}
	
}
