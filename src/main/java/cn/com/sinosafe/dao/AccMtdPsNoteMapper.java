package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.AccMtdPsNote;

public interface AccMtdPsNoteMapper {
    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insert(AccMtdPsNote record);

    /**
     *
     * 方法说明：
     * @time 2019-06-01
     */
    int insertSelective(AccMtdPsNote record);
}