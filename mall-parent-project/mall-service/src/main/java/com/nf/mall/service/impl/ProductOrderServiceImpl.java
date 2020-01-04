package com.nf.mall.service.impl;

import com.nf.mall.dao.port.ProductOrderDao;
import com.nf.mall.entity.ProductOrderEntity;
import com.nf.mall.service.port.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductOrderServiceImpl
 * @Date: 2019-12-20 23:55
 * @Description:
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    private ProductOrderDao dao;

    @Override
    public List<ProductOrderEntity> getByCustomerId(ProductOrderEntity productOrderEntity) {
        return dao.getByCustomerId(productOrderEntity);
    }

    @Override
    public List<ProductOrderEntity> getByProductOrderNumber(String productOrderNumber, Integer customerInfId) {
        return dao.getByProductOrderNumber(productOrderNumber, customerInfId);
    }

    @Override
    public List<ProductOrderEntity> getPageList(Integer customerInfId, Integer pageNum, Integer pageSize) {
        return dao.getPageList(customerInfId, pageNum, pageSize);
    }

    @Override
    public boolean productOrderInsert(ProductOrderEntity productOrderEntity) {
        return dao.productOrderInsert(productOrderEntity) > 0;
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public boolean productOrderBatchInsert(List<ProductOrderEntity> productOrderEntity) {
        return dao.productOrderBatchInsert(productOrderEntity) == productOrderEntity.size();
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public boolean submitOrderUpdate(ProductOrderEntity productOrderEntity) {
        return dao.submitOrderUpdate(productOrderEntity) > 0;
    }

    @Override
    public boolean paidOrderUpdate(String productOrderNumber) {
        return dao.paidOrderUpdate(productOrderNumber) > 0;
    }

    @Override
    public boolean submitOrderDelete(ProductOrderEntity productOrderEntity) {
        return dao.submitOrderDelete(productOrderEntity) > 0;
    }
}
