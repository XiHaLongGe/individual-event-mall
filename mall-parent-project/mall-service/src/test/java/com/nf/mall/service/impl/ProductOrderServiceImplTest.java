package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.ProductOrderEntity;
import com.nf.mall.service.port.ProductOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ProductOrderServiceImplTest {
    @Autowired
    private ProductOrderService service;
    @Test
    public void getByProductOrderNumber() {
        System.out.println(service.getByProductOrderNumber("575212468560357515", 1));
    }

    @Test
    public void getByCustomerId() {
        for (ProductOrderEntity productOrderEntity : service.getByCustomerId(ProductOrderEntity.newBuilder().customerInfId(1).build())) {
            System.out.println(productOrderEntity);
        }
    }
}