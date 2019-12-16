package cn.com.sinosafe.common.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.RandomStringUtils;

/**
 * 字符串操作工具
 * @author cnmobi_db
 */
public final class StringUtils extends org.apache.commons.lang3.StringUtils{
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 中文字符转化
	 * @author liansonghui
	 * @param content
	 * @throws UnsupportedEncodingException
	 */
	public static String chineseToUTF8(String content) throws UnsupportedEncodingException {
		if(StringUtils.isNotEmpty(content)) {
			content = new String(content.getBytes("iso-8859-1"), "UTF-8");
		}
		return content;
	}
	
	/**
	 * 中文字符转化
	 * @author liansonghui
	 * @param content
	 * @throws UnsupportedEncodingException
	 */
	public static String chineseToUTF8WithoutCharset(String content) throws UnsupportedEncodingException {
		if(StringUtils.isNotEmpty(content)) {
			content = new String(content.getBytes(), "UTF-8");
		}
		return content;
	}

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty (String str) {
        if (str == null)
            return true;

        if ("".equals(str.trim()))
            return true;

        return false;
    }

    /**
     * 判断字符串是否不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty (String str) {
        return !isEmpty(str);
    }
    
    /**
     * * 判断一个Collection是否为空， 包含List，Set，Queue
     * 
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll)
    {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个Collection是否非空，包含List，Set，Queue
     * 
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll)
    {
        return !isEmpty(coll);
    }

    /**
     * 判断字符串是否为空字符串
     * @param str
     * @return
     */
    public static boolean isBlank (String str) {
        return "".equals(str.trim());
    }

    /**
     * 判断字符串是否为非空字符串
     * @param str
     * @return
     */
    public static boolean isNotBlank (String str) {
        return !isBlank(str);
    }

    /**
     * * 判断一个对象是否为空
     * 
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object)
    {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     * 
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object)
    {
        return !isNull(object);
    }
    
    /**
     * 将字符串转为boolean类型
     * @param value
     * @param defaultValue  设置默认值，默认使用false
     * @return
     */
    public static Boolean toBoolean(String value, boolean defaultValue) {
        if (isEmpty(value))
            return defaultValue;

        try {
            return Boolean.parseBoolean(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 将字符串转为boolean类型
     * @param value
     * @return
     */
    public static Boolean toBoolean(String value) {
        return toBoolean(value, false);
    }

    /**
     * 将字符串转为long类型
     * @param value
     * @param defaultValue 设置默认值
     * @return
     */
    public static Long toLong(String value, Long defaultValue) {
        if (isEmpty(value))
            return defaultValue;
        try {
            return Long.parseLong(value);
        }catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 将字符串转为int类型
     * @param value
     * @param defaultValue 设置默认值
     * @return
     */
    public static Integer toInt(String value, Integer defaultValue) {
        if (isEmpty(value))
            return defaultValue;
        try {
            return Integer.parseInt(value);
        }catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 将字符串转为double类型
     * @param value
     * @param defaultValue
     * @return
     */
    public static Double toDouble(String value, Double defaultValue) {
        if (isEmpty(value))
            return defaultValue;
        try {
            return Double.parseDouble(value);
        }catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 将字符串转为float类型
     * @param value
     * @param defaultValue
     * @return
     */
    public static Float toFloat(String value, Float defaultValue) {
        if (isEmpty(value))
            return defaultValue;
        try {
            return Float.parseFloat(value);
        }catch (Exception e) {
            return defaultValue;
        }
    }
    /**
     * 将数组值按英文逗号拼接成字符串
     * @param array
     * @return
     */
    public static String join(Object[] array) {
        return join(array, ",","");
    }
    
    /**
     * 将数组值按指定分隔符拼接成字符串
     * @param array
     * @param delimiter 分割符，默认使用英文逗号
     * @return
     */
    public static String join(Object[] array, String delimiter) {

        return join(array, delimiter,"");
    }

    /**
     *  将数组值按指定分隔符拼接成字符串
     *       <br></br>
     *      <b>示例</b>： <br></br>
     *      array等于new String[]{"a","b"} <br></br>
     *      delimiter等于, <br></br>
     *      surround等于' <br></br>
     *      转换结果为：'a','b'
     * @param array
     * @param delimiter 分割符，默认使用英文逗号
     * @param surround 每个值左右符号，默认无
     * @return
     */
    public static String join(Object[] array, String delimiter, String surround) {
        if (array == null)
            throw new IllegalArgumentException("Array can not be null");

        if (array.length == 0) return "";

        if (surround == null) surround = "";

        if (delimiter == null) surround = ",";

        StringBuffer buffer = new StringBuffer();

        for (Object item : array) {
           buffer.append(surround).append(item.toString()).append(surround).append(delimiter);
        }

        buffer.delete(buffer.length() - delimiter.length(), buffer.length());

        return buffer.toString();
    }

    /**
     * 用分隔符连接列表中的??
     * @param list
     * @param separator
     * @return
     */
    public static String join(List<?> list, String separator){
        if(null == list || list.isEmpty()){
            return null;
        }
        if(null == separator){
            separator = "";
        }
        StringBuffer sb = new StringBuffer();
        for(Object obj : list){
            if(null != obj){
                sb.append(separator).append(obj.toString());
            }
        }
        return sb.substring(separator.length());
    }

    /**
     * Encode a string using algorithm specified in web.xml and return the
     * resulting encrypted password. If exception, the plain credentials
     * string is returned
     *
     * @param password Password or other credentials to use in authenticating
     *        this username
     * @param algorithm Algorithm used to do the digest
     *
     * @return encypted password based on the algorithm.
     */
    public static String encodePassword(String password, String algorithm) {
        byte[] unencodedPassword = password.getBytes();

        MessageDigest md = null;

        try {
            // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            return password;
        }

        md.reset();

        // call the update method one or more times
        // (useful when you don't know the size of your data, eg. stream)
        md.update(unencodedPassword);

        // now calculate the hash
        byte[] encodedPassword = md.digest();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < encodedPassword.length; i++) {
            if ((encodedPassword[i] & 0xff) < 0x10) {
                buf.append("0");
            }

            buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
        }

        return buf.toString();
    }
    
    /**
	 * 判断是否需求转码
	 * @param params
	 * @param request
	 * @return
	 */
	public static String convertEncoding(String params,HttpServletRequest request){
		String encoding = request.getCharacterEncoding();
		if (!encoding.equalsIgnoreCase("UTF-8")) {
			try {
				params = new String(params.getBytes("ISO8859-1"), "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return params;
	}
	
	/**
	 * 处理空格、横线等
	 * @author Hirson
	 * @param content
	 * @return
	 */
	public static String replaceSpace(String content) {
		if(isNotEmpty(content)) {
			content = content.replace(" ","").replace("-", "");
			//+8613763311011 手机格式的
			if(content.length() == 14 && content.startsWith("+86")) {
				content = content.replace("+86", "");
			}
		}
		return content;
	}
	
	public static String getStartSign(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append("*");
		}
		return sb.toString();
	}
	
	/**
	 * 该方法主要使用正则表达式来判断字符串中是否包含字母
	 * @author fenggaopan 2015年7月21日 上午9:49:40
	 * @param str 被教育的字符串
	 * @return 返回是否包含
	 */
	public static boolean judgeContainsStr(String str) {
		String regex = ".*[a-zA-Z]+.*";
		Matcher m = Pattern.compile(regex).matcher(str);
		return m.matches();
	}
	
	/**
     * 是否包含字符串
     * 
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs)
    {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 去空格
     */
    public static String trim(String str)
    {
        return (str == null ? "" : str.trim());
    }
    
    /**
	 * 获取随机ID，长度为count
	 * @param count
	 * @return
	 */
	public static String getRandomId(int count){
		return RandomStringUtils.randomAlphanumeric(count);
	}
	
	/**
	 * 获取随机数字，长度为count
	 * @param count
	 * @return
	 */
	public static String getRandomNumeric(int count){
		return RandomStringUtils.randomNumeric(count);
	}

    /**
     * 根据身份证获取性别
     * @param certNo
     * @return
     */
    public static String getSexByCertNo (String certNo){
        if(certNo.length()==18) {
            char sex = certNo.charAt(16);
            return Integer.valueOf(sex)%2==1 ? "1" : "2";
        }
        return null;
    }

    /**
     * 根据身份证获取生日
     * @param certNo
     * @return
     */
    public static String getBirthdayByCertNo (String certNo){
        String birthdayYear = certNo.substring(6,10);
        String birthdayMonth = certNo.substring(10,12);
        String birthdayDay = certNo.substring(12,14);
        return birthdayYear+"-"+birthdayMonth+"-"+birthdayDay;
    }

    public static BigDecimal compute_interest(String payType, double capital, double year_rate, Integer term) {
        double interest = -1;
       try {
           if(payType.equals("3")){
               // 按月等额本息，利息=本金×月利率×期限月×（1+月利率）^期限月/(（1+月利率）^期限月-1)
               interest = capital*year_rate/12*term*Math.pow(1+year_rate/12, term)/(Math.pow(1+year_rate/12, term)-1)-capital;
           }else{
               // 一次性还本付息、按月付息一次性还本、按月付息+部分本，到期还本,利息=本金×日利率×期限天
               interest = capital * year_rate / 360 * (DateUtils.getDays(DateUtils.getDate1(), DateUtils.getAddMonthDate$1(DateUtils.getDate1(), term)));
           }
           return new BigDecimal(interest).setScale(2, BigDecimal.ROUND_HALF_UP);
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }
}
