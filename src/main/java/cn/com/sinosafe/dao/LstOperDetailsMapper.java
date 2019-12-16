package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.LstOperDetails;

public interface LstOperDetailsMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-04
     */
    int deleteByPrimaryKey(String pkId);

    /**
     *
     * 方法说明：
     * @time 2019-06-04
     */
    int insert(LstOperDetails record);

    /**
     *
     * 方法说明：
     * @time 2019-06-04
     */
    int insertSelective(LstOperDetails record);

    /**
     *
     * 方法说明：
     * @time 2019-06-04
     */
    LstOperDetails selectByPrimaryKey(String pkId);

    /**
     *
     * 方法说明：
     * @time 2019-06-04
     */
    int updateByPrimaryKeySelective(LstOperDetails record);

    /**
     *
     * 方法说明：
     * @time 2019-06-04
     */
    int updateByPrimaryKey(LstOperDetails record);
}