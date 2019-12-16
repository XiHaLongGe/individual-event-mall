package com.nf.mall.service.port;

import com.nf.mall.entity.ProductInfEntity;
import org.apache.ibatis.annotations.Param;

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
    List<ProductInfEntity> getCategorySale(Integer picTypeId, Integer proCategoryId);
}
