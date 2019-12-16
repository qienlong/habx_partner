package cn.com.sinosafe.common.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cn.com.sinosafe.dao.SysConfigMapper;

/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 加载微服务系统配置
 * @Author	: hesong
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
@Component 
public class SystemConfig implements CommandLineRunner {
	
	public static Map<String, String> cacheMap = new HashMap<String, String>();
	@Autowired
	private SysConfigMapper sysConfigMapper;
	
	@Override
	public void run(String... args) throws Exception {
		List<Map<String, String>> list = sysConfigMapper.listSystemConfig();
		cacheMap = new HashMap<String, String>();
		for (Map<String, String> map : list) {
			cacheMap.put(map.get("SC_KEY"), map.get("SC_VALUE"));
		}
	}

	public String getValue(String key) {
		return cacheMap.get(key);
	}
}
