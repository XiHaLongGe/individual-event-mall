package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.ReceivingInfEntity;
import com.nf.mall.service.port.ReceivingInfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ReceivingInfServiceImplTest {
    @Autowired
    private ReceivingInfService service;
    @Test
    public void getByCustomerInfId() {
        for (ReceivingInfEntity receivingInfEntity : service.getByCustomerInfId(1)) {
            System.out.println(receivingInfEntity);
        }
    }
}