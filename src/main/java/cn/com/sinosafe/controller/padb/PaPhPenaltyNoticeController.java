/**   
* @Package ：cn.com.sinosafe.controller.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月10日 上午10:12:05 
* @version ： 1.0   
*/
package cn.com.sinosafe.controller.padb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.service.padb.PaPenaltyNoticeService;

/**
 * 平安普惠独立承保违约金率通知
 * @Author	: longxiaoqiang
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
@Log
@RestController
@RequestMapping("/pa")
public class PaPhPenaltyNoticeController {
	
	@Autowired
	private PaPenaltyNoticeService paPenaltyNoticeService;
	
	/**
	 * 违约金率通知
	 * @author	: longxiaoqiang
	 * @date	: 2019年6月10日 下午10:00:00
	 * @param request	请求体
	 * @param id		参数
	 * @return			String
	 */
	@RequestMapping(value="/penaltyNotice" , method=RequestMethod.POST)
	public String queryInfo() {
		String resultData=paPenaltyNoticeService.penaltyNotice();
		return resultData;
	}
}
