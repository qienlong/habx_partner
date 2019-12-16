package cn.com.sinosafe.service.padb.impl;

import cn.com.sinosafe.dao.IapsMapper;
import cn.com.sinosafe.service.padb.IapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author xiehanchun
 * @Time 2019/8/19 10:51
 * @Version 1.0
 */
@Service
public class IapsServiceImpl implements IapsService {

    @Autowired
    private IapsMapper iapsMapper;

    @Override
    public void insertIapsEntity(Map<String, Object> map) {
        iapsMapper.insertIapsEntity(map);
    }
}
