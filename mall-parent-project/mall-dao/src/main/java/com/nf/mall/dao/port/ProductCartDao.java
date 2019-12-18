package com.nf.mall.dao.port;

import com.nf.mall.entity.ProductCartEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCartDao
 * @Date: 2019-12-17 10:22
 * @Description:
 */
public interface ProductCartDao {
    List<ProductCartEntity> getById(@Param("customerInfId") Integer customerInfId);
    Integer productCartCount(@Param("customerInfId") Integer customerInfId);
    ProductCartEntity productCartVerify(@Param("productCartEntity") ProductCartEntity productCartEntity);
    Integer productCartUpdate(@Param("productCartEntity") ProductCartEntity productCartEntity);
    Integer productCartDelete(@Param("productCartEntity") ProductCartEntity productCartEntity);
    Integer productCartInsert(@Param("productCartEntity") ProductCartEntity productCartEntity);
}
