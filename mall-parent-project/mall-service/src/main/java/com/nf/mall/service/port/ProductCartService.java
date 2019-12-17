package com.nf.mall.service.port;

import com.nf.mall.entity.ProductCartEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCartService
 * @Date: 2019-12-17 10:29
 * @Description:
 */
public interface ProductCartService {
    List<ProductCartEntity> getById(Integer customerInfId);
    boolean productCartUpdate(ProductCartEntity productCartEntity);
}
