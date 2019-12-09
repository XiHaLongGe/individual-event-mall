package com.nf.mall.service.impl;

import com.nf.mall.dao.port.PictureTypeDao;
import com.nf.mall.entity.PictureTypeEntity;
import com.nf.mall.service.port.PictureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PictureTypeServiceImpl
 * @Date: 2019-12-09 22:30
 * @Description:
 */
@Service
public class PictureTypeServiceImpl implements PictureTypeService {
    @Autowired
    private PictureTypeDao dao;
    @Override
    public List<PictureTypeEntity> getAll() {
        return dao.getAll();
    }

    @Override
    public PictureTypeEntity getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    public PictureTypeEntity getByName(String name) {
        return dao.getByName(name);
    }
}
