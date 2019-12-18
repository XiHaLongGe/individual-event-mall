package com.nf.mall.service.port;

import com.nf.mall.entity.ProductCartEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCartService
 * @Date: 2019-12-17 10:29
 * @Description:
 */
public interface ProductCartService {
    List<ProductCartEntity> getById(Integer customerInfId);
    Integer productCartCount(Integer customerInfId);
    ProductCartEntity productCartVerify(ProductCartEntity productCartEntity);
    boolean productCartUpdate(ProductCartEntity productCartEntity);
    boolean productCartDelete(ProductCartEntity productCartEntity);
    boolean productCartInsert(ProductCartEntity productCartEntity);
}
