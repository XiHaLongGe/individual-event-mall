package com.nf.mall.service.impl;

import com.nf.mall.dao.port.BrandInfDao;
import com.nf.mall.entity.BrandInfEntity;
import com.nf.mall.service.port.BrandInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname BrandInfServiceImpl
 * @Date: 2019-12-05 09:48
 * @Description:
 */
@Service
public class BrandInfServiceImpl implements BrandInfService {
    @Autowired
    private BrandInfDao dao;
    @Override
    public List<BrandInfEntity> getAll() {
        return dao.getAll();
    }
    @Override
    public List<String> getByListName(Integer categoryId) {
        return dao.getByListName(categoryId);
    }
}
