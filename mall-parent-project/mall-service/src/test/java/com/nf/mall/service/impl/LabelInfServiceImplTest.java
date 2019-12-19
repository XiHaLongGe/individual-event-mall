package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.LabelInfEntity;
import com.nf.mall.service.port.LabelInfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class LabelInfServiceImplTest {
    @Autowired
    private LabelInfService labelInfService;
    @Test
    public void getAll() {
        for (LabelInfEntity labelInfEntity : labelInfService.getAll()) {
            System.out.println(labelInfEntity);
        }
    }

    @Test
    public void labelInfInsert() {
        System.out.println(labelInfService.labelInfInsert(LabelInfEntity.newBuilder().customerInfId(1).labelInfName("学校").build()));
    }
}