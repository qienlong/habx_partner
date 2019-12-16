package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.BizLog;
import cn.com.sinosafe.domain.entity.BizLogWithBLOBs;

public interface BizLogMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-05
     */
    int deleteByPrimaryKey(String pkId);

    /**
     *
     * 方法说明：
     * @time 2019-06-05
     */
    int insert(BizLogWithBLOBs record);

    /**
     *
     * 方法说明：
     * @time 2019-06-05
     */
    int insertSelective(BizLogWithBLOBs record);

    /**
     *
     * 方法说明：
     * @time 2019-06-05
     */
    BizLogWithBLOBs selectByPrimaryKey(String pkId);

    /**
     *
     * 方法说明：
     * @time 2019-06-05
     */
    int updateByPrimaryKeySelective(BizLogWithBLOBs record);

    /**
     *
     * 方法说明：
     * @time 2019-06-05
     */
    int updateByPrimaryKeyWithBLOBs(BizLogWithBLOBs record);

    /**
     *
     * 方法说明：
     * @time 2019-06-05
     */
    int updateByPrimaryKey(BizLog record);
}