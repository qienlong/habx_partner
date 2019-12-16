package cn.com.sinosafe.dao;

import java.util.List;
import java.util.Map;

import cn.com.sinosafe.domain.entity.SysConfig;

/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 系统配置dao
 * @Author	: hesong
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
public interface SysConfigMapper {
    /**
     *
     * 方法说明：
     * @time 2018-12-25
     */
    int deleteByPrimaryKey(Integer configId);

    /**
     *
     * 方法说明：
     * @time 2018-12-25
     */
    int insert(SysConfig record);

    /**
     *
     * 方法说明：
     * @time 2018-12-25
     */
    int insertSelective(SysConfig record);

    /**
     *
     * 方法说明：
     * @time 2018-12-25
     */
    SysConfig selectByPrimaryKey(Integer configId);

    /**
     *
     * 方法说明：
     * @time 2018-12-25
     */
    int updateByPrimaryKeySelective(SysConfig record);

    /**
     *
     * 方法说明：
     * @time 2018-12-25
     */
    int updateByPrimaryKey(SysConfig record);
    
    /**
     * 加载全部配置项
     * @return
     */
    List<Map<String, String>> listSystemConfig();
}