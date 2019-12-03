package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.CustomerLoginEntity;
import com.nf.mall.service.port.CustomerLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CustomerLoginServiceImplTest {
    @Autowired
    private CustomerLoginService service;
    @Test
    public void getAll() {
        for (CustomerLoginEntity customerLoginEntity : service.getAll()) {
            System.out.println(customerLoginEntity);
        }
    }

    @Test
    public void verify() {
        System.out.println(service.verify("admin","admin"));
    }

    @Test
    public void insert() {
        System.out.println(service.register(CustomerLoginEntity.newBuilder().loginName("admin1").loginAccount("admin1").loginPassword("admin1").build()));
    }
}
