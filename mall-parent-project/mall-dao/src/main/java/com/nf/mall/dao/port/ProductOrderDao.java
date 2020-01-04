package com.nf.mall.dao.port;

import com.nf.mall.entity.ProductOrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductOrderDao
 * @Date: 2019-12-20 23:43
 * @Description:
 */
public interface ProductOrderDao {
    List<ProductOrderEntity> getByCustomerId(@Param("productOrderEntity") ProductOrderEntity productOrderEntity);
    List<ProductOrderEntity> getByProductOrderNumber(@Param("productOrderNumber") String productOrderNumber, @Param("customerInfId") Integer customerInfId);
    List<ProductOrderEntity> getPageList(@Param("customerInfId") Integer customerInfId,@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    Integer productOrderInsert(@Param("productOrderEntity") ProductOrderEntity productOrderEntity);
    Integer productOrderBatchInsert(@Param("productOrderEntity") List<ProductOrderEntity> productOrderEntity);
    Integer submitOrderUpdate(@Param("productOrderEntity") ProductOrderEntity productOrderEntity);
    Integer paidOrderUpdate(@Param("productOrderNumber") String productOrderNumber);
    Integer submitOrderDelete(@Param("productOrderEntity") ProductOrderEntity productOrderEntity);
}
