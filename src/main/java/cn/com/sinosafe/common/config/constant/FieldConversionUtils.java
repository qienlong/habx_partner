package cn.com.sinosafe.common.config.constant;

import cn.com.sinosafe.domain.entity.CusIndiv;
import cn.com.sinosafe.domain.entity.LstIqpInfo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiehanchun
 * @Time 2019/6/27 9:59
 * @Version 1.0
 */
public class FieldConversionUtils {
    public static Map<String, String> getTempInfo(){
        Map<String,String> lstInfoMap=new HashMap<String,String>();
            lstInfoMap.put("60","0007");
            lstInfoMap.put("61","0001");
            lstInfoMap.put("62","0002");
            lstInfoMap.put("63","0005");
            lstInfoMap.put("64","0004");
            lstInfoMap.put("65","0003");
            lstInfoMap.put("66","0008");
            lstInfoMap.put("67","0011");
            lstInfoMap.put("68","0006");
            lstInfoMap.put("14","0008");
            lstInfoMap.put("69","0006");
        return lstInfoMap;
    }

    public static Map<String, String> getPaymentMethod(){
        Map<String,String> lstInfoMap=new HashMap<String,String>();
        lstInfoMap.put("EQ_CI","3");
        return lstInfoMap;
    }

    public static Map<String, String> getIdType(){
        Map<String,String> lstInfoMap=new HashMap<String,String>();
        lstInfoMap.put("0","10");
        return lstInfoMap;
    }
}
