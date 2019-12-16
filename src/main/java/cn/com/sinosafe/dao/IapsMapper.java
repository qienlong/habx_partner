package cn.com.sinosafe.dao;

import java.util.Map;

/**
 * @Author xiehanchun
 * @Time 2019/8/19 11:08
 * @Version 1.0
 */
public interface IapsMapper {
    /**
     * 记录平安付返回结果
     * @param map
     * @return
     */
    int insertIapsEntity(Map<String, Object> map);
}
