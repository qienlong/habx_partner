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
import cn.com.sinosafe.service.padb.PaCheckPubStatusService;

/**
 * 平安普惠独立承保同步对公核实、理赔结果
 * @Author	: longxiaoqiang
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
@Log
@RestController
@RequestMapping("/pa")
public class PaPhCkeckPubController {
	
	@Autowired
	private PaCheckPubStatusService paCheckPubStatusService;
	
	/**
	 * 对公还款核实
	 * @author	: longxiaoqiang
	 * @date	: 2019年6月10日 下午10:00:00
	 * @param request	请求体
	 * @param id		参数
	 * @return			String
	 */
	@RequestMapping(value="/checkPubStaStus" , method=RequestMethod.POST)
	public String queryInfo() {
		String resultData=paCheckPubStatusService.checkPubStatus();
		return resultData;
	}
	
	/**
	 * 理赔结果通知
	 * @author	: longxiaoqiang
	 * @date	: 2019年6月10日 下午10:00:00
	 * @param request	请求体
	 * @param id		参数
	 * @return			String
	 */
	@RequestMapping(value="/claimResultNotice" , method=RequestMethod.POST)
	public String claimResultNotice() {
		String resultData=paCheckPubStatusService.claimResultNotice();
		return resultData;
	}
	/**
	 * 理赔支付失败邮件预警
	 * @author	: longxiaoqiang
	 * @date	: 2019年6月10日 下午10:00:00
	 * @param request	请求体
	 * @param id		参数
	 * @return			String
	 */
	@RequestMapping(value="/claimFailNotice" , method=RequestMethod.POST)
	public String claimFailNotice() {
		String resultData=paCheckPubStatusService.claimFailNotice();
		return resultData;
	}
}
