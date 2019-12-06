package com.nf.mall.service.impl;

import com.nf.mall.dao.port.AfficheInfDao;
import com.nf.mall.entity.AfficheInfEntity;
import com.nf.mall.service.port.AfficheInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname AfficheInfServiceImpl
 * @Date: 2019-12-06 09:58
 * @Description:
 */
@Service
public class AfficheInfServiceImpl implements AfficheInfService {
    @Autowired
    private AfficheInfDao dao;
    @Override
    public List<AfficheInfEntity> getAll() {
        return dao.getAll();
    }
}
