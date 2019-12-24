package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.ProductInfEntity;
import com.nf.mall.entity.ProductOrderEntity;
import com.nf.mall.service.port.ProductInfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ProductInfServiceImplTest {
    @Autowired
    private ProductInfService service;
    @Test
    public void getCategorySale() {
        for (ProductInfEntity productInfEntity : service.getCategorySale(4, 15)) {
            System.out.println(productInfEntity);
        }
    }

    @Test
    public void getBySidebarCategoryId() {
        for (ProductInfEntity productInfEntity : service.getBySidebarCategoryId(8)) {
            System.out.println(productInfEntity);
        }
    }

}