package cn.com.sinosafe.service.padb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.dao.SysConfigMapper;
import cn.com.sinosafe.service.padb.ReloadCacheService;

/**
 * @ClassName:：CheckInsureNoticeServiceImpl @Description： 平安核保确认
 * @author ：pengll
 * @date ：2019年6月3日 下午2:41:16
 */
@Service
public class ReloadCacheServiceImpl implements ReloadCacheService {

	public static Map<String, String> cacheMap = new HashMap<String, String>();
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	SystemConfig systemConfig;
	@Override
	public String reloadCache() {
		String flag = "0000";
		String msg = "重载成功";
		Map<String, String> resultMap=new HashMap<String, String>();
		try {
			List<Map<String, String>> list = sysConfigMapper.listSystemConfig();
			for (Map<String, String> map : list) {
				cacheMap.put(map.get("SC_KEY"), map.get("SC_VALUE"));
			}
			SystemConfig.cacheMap=cacheMap;
		} catch (Exception e) {
			flag = "9999";
			msg = "重载失败";
			e.printStackTrace();
		} finally {
			resultMap.put("code", flag);
			resultMap.put("msg", msg);
		}
		return JSON.toJSONString(resultMap);
	}

}
