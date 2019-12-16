package cn.com.sinosafe.controller.common;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.lina.shortdomain.dubbo.service.ShortDomainDubboService;
import cn.com.sinosafe.lina.shortdomain.model.ShortDomain;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;

/**
 * 短链接服务
 * @author fankun1
 *
 */

@RestController
@RequestMapping("/system")
public class ShortUrlController {
	
    @Reference( timeout = 60000)
    protected ShortDomainDubboService shortDomainDubboService;
	
    @Value("${info.build.name}")
    private String SYSTEM_NAME;

	/**
	 * 获取短链接url
	 * @param url
	 * @return
	 * @throws Exception
	 */
    @Log
	@PostMapping("/shortUrl")
	public JsonProtocol shortUrl(@RequestBody JSONObject json){
		JsonProtocol result = new JsonProtocol();
		String url = json.getString("url");
		if (StringUtils.isEmpty(url)) {
			result.setCode(1);
			result.setMessage("url不能为空");
			return result;
		}
		//正则判断http类型
		String regex = "^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)$";
		Pattern pattern = Pattern.compile(regex);
		if (!pattern.matcher(url).matches()) {
			result.setCode(1);
			result.setMessage("不是正确的网址");
			return result;
		}
		ShortDomain sdRe = new ShortDomain();
		sdRe.setRealDomain(url);
		sdRe.setCreateSystem(SYSTEM_NAME);
		ShortDomain sdRs = shortDomainDubboService.obtainShortDomain(sdRe);
		result.setCode(0);
		result.setMessage("Success");
		result.setData(sdRs.getShortDomain());
		return result;
	}

}
