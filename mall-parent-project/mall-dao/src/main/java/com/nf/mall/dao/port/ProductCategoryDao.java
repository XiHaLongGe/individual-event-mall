package com.nf.mall.dao.port;

import com.nf.mall.entity.ProductCategoryEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCategoryDao
 * @Date: 2019-12-05 09:37
 * @Description:
 */
public interface ProductCategoryDao {
    List<ProductCategoryEntity> getAll();
    List<ProductCategoryEntity> getByLevel(Integer levelNum);
    ProductCategoryEntity getById(Integer id);
    ProductCategoryEntity getByName(String categoryName);
}
