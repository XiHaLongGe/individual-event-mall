package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.BrandInfEntity;
import com.nf.mall.service.port.BrandInfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BrandInfServiceImplTest {
    @Autowired
    private BrandInfService service;
    @Test
    public void getAll() {
        for (BrandInfEntity brandInfEntity : service.getAll()) {
            System.out.println(brandInfEntity);
        }
    }
}