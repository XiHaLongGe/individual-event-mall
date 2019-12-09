package com.nf.mall.service.impl;

import com.nf.mall.dao.port.ProductCategoryDao;
import com.nf.mall.entity.ProductCategoryEntity;
import com.nf.mall.service.port.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCategoryServiceImpl
 * @Date: 2019-12-05 09:48
 * @Description:
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao dao;
    @Override
    public List<ProductCategoryEntity> getAll() {
        return dao.getAll();
    }

    @Override
    public List<ProductCategoryEntity> getByLevel(Integer levelNum) {
        return dao.getByLevel(levelNum);
    }
}
