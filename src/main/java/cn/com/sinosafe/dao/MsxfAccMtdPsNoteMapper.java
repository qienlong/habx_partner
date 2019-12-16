package cn.com.sinosafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sinosafe.domain.entity.MsxfAccMtdPsNote;

public interface MsxfAccMtdPsNoteMapper {
    int deleteByPrimaryKey(String msxfAccMtdPsNoteId);

    int insert(MsxfAccMtdPsNote record);

    int insertSelective(MsxfAccMtdPsNote record);

    MsxfAccMtdPsNote selectByPrimaryKey(String msxfAccMtdPsNoteId);

    int updateByPrimaryKeySelective(MsxfAccMtdPsNote record);

    int updateByPrimaryKey(MsxfAccMtdPsNote record);

    void batchInsert(ArrayList<MsxfAccMtdPsNote> accMtdPsNoteList);

    List<MsxfAccMtdPsNote> selectByContNoAndDate(@Param("contrNbr")String contrNbr, @Param("businessDate")String businessDate, @Param("syncStatus")String syncStatus);
}