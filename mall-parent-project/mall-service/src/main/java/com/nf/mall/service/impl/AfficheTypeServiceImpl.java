package com.nf.mall.service.impl;

import com.nf.mall.dao.port.AfficheTypeDao;
import com.nf.mall.entity.AfficheTypeEntity;
import com.nf.mall.service.port.AfficheTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname AfficheTypeServiceImpl
 * @Date: 2019-12-06 09:58
 * @Description:
 */
@Service
public class AfficheTypeServiceImpl implements AfficheTypeService {
    @Autowired
    private AfficheTypeDao dao;
    @Override
    public List<AfficheTypeEntity> getAll() {
        return dao.getAll();
    }
}
