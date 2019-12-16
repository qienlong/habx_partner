package cn.com.sinosafe.service.padb;

import java.util.Map;

/**
 * @Author xiehanchun
 * @Time 2019/8/19 10:50
 * @Version 1.0
 */
public interface IapsService {
    /**
     * 记录平安付返回结果
     * @param map
     */
    void insertIapsEntity(Map<String, Object> map);
}
