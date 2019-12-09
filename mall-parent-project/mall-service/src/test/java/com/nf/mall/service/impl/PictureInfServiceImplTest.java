package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.PictureInfEntity;
import com.nf.mall.service.port.PictureInfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class PictureInfServiceImplTest {
    @Autowired
    private PictureInfService service;
    @Test
    public void getAll() {
        for (PictureInfEntity afficheImageEntity : service.getAll()) {
            System.out.println(afficheImageEntity);
        }
    }

    @Test
    public void getByType() {
        for (PictureInfEntity afficheImageEntity : service.getByType(1)) {
            System.out.println(afficheImageEntity);
        }
    }
}