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
    ProductInfEntity getById(Integer id);
    List<ProductInfEntity> getByBrandId(Integer brandId);
    List<ProductInfEntity> getByCategoryId(Integer categoryId);
    List<ProductInfEntity> getHotSale(@Param("pictureTypeId") Integer pictureTypeId, @Param("categoryId")Integer categoryId);
}
