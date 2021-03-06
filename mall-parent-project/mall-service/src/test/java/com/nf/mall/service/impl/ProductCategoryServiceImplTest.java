package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.ProductCategoryEntity;
import com.nf.mall.service.port.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryService service;
    @Test
    public void getAll() {
        for (ProductCategoryEntity productCategoryEntity : service.getAll()) {
            System.out.println(productCategoryEntity);
        }
    }

    @Test
    public void getByLevel() {
        for (ProductCategoryEntity productCategoryEntity : service.getByLevel(1, 0)) {
            System.out.println(productCategoryEntity);
        }
    }
}