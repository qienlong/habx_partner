package cn.com.sinosafe.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Description
 * @auther 林良
 * @Date 2019-09-02
 */
@Component
public class SignVerifyUtil {

    private static String signKey;

    public static String getSignKey() {
        return signKey;
    }

    @Value("${gbcn.signKey}")
    public void setSignKey(String signKey) {
        SignVerifyUtil.signKey = signKey;
    }

    /**
     * @Description 验签
     * @Date 2019/9/2 17:11
     * @param sign 签名
     * @param obj 未签名
     * @return boolean
     */
    public static boolean verify(String sign,Object obj){
        String xml = XMLUtil.convertToXml(obj, true);
        //去除xml标签
        Pattern pxml = Pattern.compile("<[^>]*>", Pattern.CASE_INSENSITIVE);
        Matcher mxml = pxml.matcher(xml);
        xml = mxml.replaceAll("");
        // 过滤空格回车标签
        Pattern pspace = Pattern.compile("\\s*|\t|\r|\n", Pattern.CASE_INSENSITIVE);
        Matcher mspace = pspace.matcher(xml);
        xml = mspace.replaceAll("");
        //报文加密
        xml = xml + signKey;
        String hash = Md5Util.hash(xml);
        System.out.println(xml+"=========="+hash);
        return hash.equals(sign);
    }

    /**
     * @Description 加密
     * @Date 2019/9/3 14:58
     * @param obj
     * @return java.lang.String
     */
    public static String tosign(Object obj){
        String xml = XMLUtil.convertToXml(obj, true);
        //去除xml标签
        Pattern pxml = Pattern.compile("<[^>]*>", Pattern.CASE_INSENSITIVE);
        Matcher mxml = pxml.matcher(xml);
        xml = mxml.replaceAll("");
        // 过滤空格回车标签
        Pattern pspace = Pattern.compile("\\s*|\t|\r|\n", Pattern.CASE_INSENSITIVE);
        Matcher mspace = pspace.matcher(xml);
        xml = mspace.replaceAll("");
        //报文加密
        xml = xml + signKey;
        String hash = Md5Util.hash(xml);
        System.out.println(xml+"=========="+hash);
        return hash;
    }
}
