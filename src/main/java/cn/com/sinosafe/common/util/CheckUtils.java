package cn.com.sinosafe.common.util;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 常见编号字符串规则校验
 * @Project	: Rest_HAXB_Service
 * @Desc	: 例如手机号、身份证号等
 * @Author	: hesong
 * @Date	: 2019年1月11日 下午3:36:05
 * @Version	: 1.0
 */
public final class CheckUtils {

	/**
	 * 验证手机格式
	 * @author	: hirson
	 * @date	: 2019年1月11日 下午3:57:40
	 * @param mobiles 手机号码
	 * @return	:
	 */
	public static boolean isMobileNo(String mobiles) {
		if(mobiles.length() != 11){return false;}
		//手机号码: 以1开头，共11位数字
		String regex = "^1[\\d]{10}";
		return mobiles.matches(regex);
	}
	
	/**
	 * 判断字符串中是否包含字母
	 * @author fenggaopan 2015年7月21日 上午9:49:40
	 * @param str 被校验的字符串
	 * @return 返回是否包含
	 */
	public static boolean judgeContainsStr(String str) {
		String regex = ".*[a-zA-Z]+.*";
		Matcher m = Pattern.compile(regex).matcher(str);
		return m.matches();
	}
	
	/**
	 * 校验身份证号格式
	 * @author Hirson
	 * @param idNum 身份证号
	 * @return
	 */
	public static boolean matcher18IDnum(String idNum) {
		String pattern = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
		return idNum.matches(pattern);
	}
	
	/**
	 * 去除特殊特殊字符：[`!@#$%^&*()+=|{}':;',//[//].<>/?！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-]
	 * @author	: hirson
	 * @date	: 2019年1月11日 下午3:59:51
	 * @param oldString
	 * @return	:
	 */
	public static String charReplacement(String oldString) {
		if (StringUtils.isNotEmpty(oldString)) {
			String regEx="[`!@#$%^&*()+=|{}':;',//[//].<>/?！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-]";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(oldString);
			return matcher.replaceAll("").trim().replace(" ", "");
		}
		return oldString;
	}
	
	/**
    *
    * 方法说明：检验传入参数必输
    * @author xiechong
    * @param keyStrs 
    * @param paramMap
    * @param needField
    * @time 2019-06-03
    */
	public static boolean checkFieldDefect(Set<String> keyStrs, Map<String, Object> paramMap, String[] needField) {
		boolean boo = false;
		for (String str : keyStrs) {
			for (String string : needField) {
				if (str.equals(string)) {
					if (StringUtils.isEmpty(String.valueOf(paramMap.get(str)))) {
						boo = true;
						break;
					}
				}
			}
		}
		return boo;
	}
}
