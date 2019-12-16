package com.nf.mall.service.port;

import com.nf.mall.entity.ProductInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductInfService
 * @Date: 2019-12-09 15:36
 * @Description:
 */
public interface ProductInfService {
    List<ProductInfEntity> getAll();
    List<ProductInfEntity> getHotProduct();
    ProductInfEntity getById(Integer id);
    List<ProductInfEntity> getBySidebarCategoryId(Integer sidebarCategoryId);
    List<ProductInfEntity> getByBrandId(Integer brandId);
    List<ProductInfEntity> getByCategoryId(Integer categoryId);
    List<ProductInfEntity> getCategorySale(Integer picTypeId, Integer proCategoryId);
    List<ProductInfEntity> getSidebarCategorySale(Integer picTypeId);
}
