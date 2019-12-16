package com.nf.mall.service.impl;

import com.nf.mall.dao.port.ProductInfDao;
import com.nf.mall.entity.ProductInfEntity;
import com.nf.mall.service.port.ProductInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductInfServiceImpl
 * @Date: 2019-12-09 15:38
 * @Description:
 */
@Service
public class ProductInfServiceImpl implements ProductInfService {
    @Autowired
    private ProductInfDao dao;
    @Override
    public List<ProductInfEntity> getAll() {
        return dao.getAll();
    }

    @Override
    public List<ProductInfEntity> getHotProduct() {
        return dao.getHotProduct();
    }

    @Override
    public ProductInfEntity getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    public List<ProductInfEntity> getBySidebarCategoryId(Integer sidebarCategoryId) {
        return dao.getBySidebarCategoryId(sidebarCategoryId);
    }

    @Override
    public List<ProductInfEntity> getByBrandId(Integer brandId) {
        return dao.getByBrandId(brandId);
    }

    @Override
    public List<ProductInfEntity> getByCategoryId(Integer categoryId) {
        return dao.getByCategoryId(categoryId);
    }

    @Override
    public List<ProductInfEntity> getCategorySale(Integer picTypeId, Integer proCategoryId) {
        return dao.getCategorySale(picTypeId, proCategoryId);
    }

    @Override
    public List<ProductInfEntity> getSidebarCategorySale(Integer picTypeId) {
        return dao.getSidebarCategorySale(picTypeId);
    }
}
