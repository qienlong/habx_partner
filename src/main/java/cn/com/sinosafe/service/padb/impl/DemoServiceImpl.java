package cn.com.sinosafe.service.padb.impl;

import java.util.Map;
import cn.com.sinosafe.service.padb.PaPhService;

/**
 * TODO
 * @Project	: haxb_partner
 * @Desc	: TODO
 * @Author	: hesong
 * @Date	: 2019年6月3日 下午7:47:21
 * @Version	: 1.0
 */
public class DemoServiceImpl implements PaPhService {

	@Override
	public String service(Map<String, Object> paramMap) {
		System.out.println(paramMap.size());
		return null;
	}

}
