package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.AfficheInfEntity;
import com.nf.mall.service.port.AfficheInfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AfficheInfServiceImplTest {
    @Autowired
    private AfficheInfService service;
    @Test
    public void getAll() {
        for (AfficheInfEntity afficheInfEntity : service.getAll()) {
            System.out.println(afficheInfEntity);
        }
    }
}