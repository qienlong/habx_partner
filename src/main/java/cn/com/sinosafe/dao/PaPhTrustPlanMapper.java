package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PrjCopTrustPlan;
import org.springframework.stereotype.Repository;

@Repository
public interface PaPhTrustPlanMapper {

    int mergePrjCopTrustPlan(PrjCopTrustPlan prjCopTrustPlanp);
}
