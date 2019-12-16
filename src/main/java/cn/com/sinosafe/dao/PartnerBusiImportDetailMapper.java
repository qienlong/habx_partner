package cn.com.sinosafe.dao;
import cn.com.sinosafe.domain.entity.PartnerBusiImportDetail;

import java.util.List;

public interface PartnerBusiImportDetailMapper {
    int deleteByPrimaryKey(String serno);

    int insert(PartnerBusiImportDetail record);

    int insertSelective(PartnerBusiImportDetail record);

    PartnerBusiImportDetail selectByPrimaryKey(String serno);
    
    PartnerBusiImportDetail selectByByFileds(PartnerBusiImportDetail key);

    int updateByPrimaryKeySelective(PartnerBusiImportDetail record);

    int updateByPrimaryKey(PartnerBusiImportDetail record);

    PartnerBusiImportDetail selectByReqListSerno(String reqListSerno);

    String selectPartnerContNoByLoanContNo(String loanContNo);

    PartnerBusiImportDetail selectByBill(PartnerBusiImportDetail record);

    List<String> selectBusiBillNos4HaoSen(String copNo);
}