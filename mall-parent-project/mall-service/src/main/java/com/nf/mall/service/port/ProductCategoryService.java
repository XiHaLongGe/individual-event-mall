package com.nf.mall.service.port;

import com.nf.mall.entity.ProductCategoryEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCategoryService
 * @Date: 2019-12-05 09:47
 * @Description:
 */
public interface ProductCategoryService {
    List<ProductCategoryEntity> getAll();
}
