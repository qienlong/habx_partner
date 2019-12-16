package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.AccFeePsNote;

public interface AccFeePsNoteMapper {
    int insert(AccFeePsNote record);

    int insertSelective(AccFeePsNote record);
}