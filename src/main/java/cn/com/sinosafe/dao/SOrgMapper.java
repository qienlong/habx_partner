package cn.com.sinosafe.dao;

import cn.com.sinosafe.domain.entity.SOrg;

public interface SOrgMapper {

    SOrg selectByPrimaryKey(String organno);

    SOrg selectByOrganno(String organno);
}