package com.nf.mall.service.port;

import com.nf.mall.entity.ProductOrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductOrderService
 * @Date: 2019-12-20 23:54
 * @Description:
 */
public interface ProductOrderService {
    List<ProductOrderEntity> getByCustomerId(ProductOrderEntity productOrderEntity);
    List<ProductOrderEntity> getByProductOrderNumber(String productOrderNumber, Integer customerInfId);
    boolean productOrderInsert(ProductOrderEntity productOrderEntity);
    boolean productOrderBatchInsert(List<ProductOrderEntity> productOrderEntity);
    boolean submitOrderUpdate(ProductOrderEntity productOrderEntity);
    boolean paidOrderUpdate(String productOrderEntity);
    boolean submitOrderDelete(ProductOrderEntity productOrderEntity);
}
