package com.nf.mall.dao.port;

import com.nf.mall.entity.ProductInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductInfDao
 * @Date: 2019-12-09 15:27
 * @Description:
 */
public interface ProductInfDao {
    List<ProductInfEntity> getAll();
    List<ProductInfEntity> getHotProduct();
    List<ProductInfEntity> getBySidebarCategoryId(@Param("sidebarCategoryId")Integer sidebarCategoryId);
    ProductInfEntity getById(Integer id);
    List<ProductInfEntity> getCategorySale(@Param("picTypeId") Integer picTypeId, @Param("proCategoryId") Integer proCategoryId);
}
