package com.nf.mall.service.impl;

import com.nf.mall.dao.port.ProductCartDao;
import com.nf.mall.entity.ProductCartEntity;
import com.nf.mall.service.port.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCartServiceImpl
 * @Date: 2019-12-17 10:30
 * @Description:
 */
@Service
public class ProductCartServiceImpl implements ProductCartService{
    @Autowired
    private ProductCartDao dao;
    @Override
    public List<ProductCartEntity> getById(Integer customerInfId) {
        return dao.getById(customerInfId);
    }

    @Override
    public Integer productCartCount(Integer customerInfId) {
        return dao.productCartCount(customerInfId);
    }

    @Override
    public ProductCartEntity productCartVerify(ProductCartEntity productCartEntity) {
        return dao.productCartVerify(productCartEntity);
    }

    @Override
    public boolean productCartUpdate(ProductCartEntity productCartEntity) {
        return dao.productCartUpdate(productCartEntity) > 0;
    }

    @Override
    public boolean productCartDelete(ProductCartEntity productCartEntity) {
        return dao.productCartDelete(productCartEntity) > 0;
    }

    @Override
    public boolean productCartInsert(ProductCartEntity productCartEntity) {
        ProductCartEntity verifyEntity = productCartVerify(productCartEntity);
        if(verifyEntity != null){
            Integer verifyCartNum = verifyEntity.getProductCartNum();
            Integer productCartNum = productCartEntity.getProductCartNum();
            return productCartUpdate(ProductCartEntity.newBuilder(productCartEntity).productCartNum(verifyCartNum + productCartNum).build());
        }
        return dao.productCartInsert(productCartEntity) > 0;
    }
}
