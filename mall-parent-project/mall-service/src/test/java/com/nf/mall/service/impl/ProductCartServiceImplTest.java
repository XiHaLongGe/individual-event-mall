package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.ProductCartEntity;
import com.nf.mall.service.port.ProductCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ProductCartServiceImplTest {
    @Autowired
    private ProductCartService productCartService;
    @Test
    public void getById() {
        for (ProductCartEntity productCartEntity : productCartService.getById(1)) {
            System.out.println(productCartEntity);
        }
    }
}