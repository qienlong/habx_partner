package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.CusIndiv;

public interface CusIndivMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int deleteByPrimaryKey(String cusId);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insert(CusIndiv record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insertSelective(CusIndiv record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    CusIndiv selectByPrimaryKey(String cusId);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKeySelective(CusIndiv record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int updateByPrimaryKey(CusIndiv record);
}