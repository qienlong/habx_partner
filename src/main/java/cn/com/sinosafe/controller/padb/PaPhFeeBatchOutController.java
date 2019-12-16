/**
 * 
 */
package cn.com.sinosafe.controller.padb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.service.padb.PaFeeBatchOutService;

/**  
* <p>Title: PaPhFeeBatchOutController</p>  
* <p>Description: 独立承保批减保费</p>  
* @author longxiaoqiang  
* @date 2019年11月13日  
*/
@Log
@RestController
@RequestMapping("/cop/paph")
public class PaPhFeeBatchOutController {

	@Autowired
	PaFeeBatchOutService paFeeBatchOutService;
	/**
	 * 独保批减保费
	 * @author	: longxiaoqiang
	 * @date	: 2019年6月10日 下午10:00:00
	 * @param request	请求体
	 * @param id		参数
	 * @return			String
	 */
	@RequestMapping(value="/batchOut" , method=RequestMethod.POST)
	public String claimFailNotice() {
		String resultData=paFeeBatchOutService.feeBatchOut();
		return resultData;
	}
}
