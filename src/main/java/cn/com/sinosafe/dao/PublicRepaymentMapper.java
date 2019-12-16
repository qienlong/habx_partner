package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.PublicRepayment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicRepaymentMapper {

    int insertPublicRepayment(@Param("publicRepaymentList") List<PublicRepayment> publicRepaymentList);
}
