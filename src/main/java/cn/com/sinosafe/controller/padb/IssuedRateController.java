package cn.com.sinosafe.controller.padb;

import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.service.padb.IssuedRateService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchProviderException;
import java.util.Map;

/**
 * 费率下发接口
 * @Author xiehanchun
 * @Time 2019/7/6 14:58
 * @Version 1.0
 */

@Log
@RestController
@RequestMapping("/pa/issue")
public class IssuedRateController {
    @Autowired
    private IssuedRateService issuedRateService;

    /**
     * 费率下发接口
     * @author	: xiehanchun
     * @date	: 2019/7/6 14:58
     * @throws NoSuchProviderException    :
     */
	@RequestMapping(value="/issuedRate" , method= RequestMethod.POST)
	public String queryIssue(@RequestBody  Map<String, Object> paramMap) throws NoSuchProviderException{
        String result = issuedRateService.IssueFeeRateInfo(paramMap);
        return result;
	}

}
