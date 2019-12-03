package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.CustomerInfEntity;
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
        System.out.println(service.verify(CustomerLoginEntity.newBuilder().loginAccount("admin1").loginPassword("admin1").build()));
    }

    @Test
    public void register() {
        System.out.println(service.register(CustomerLoginEntity.newBuilder().loginName("admin3").loginAccount("admin3").loginPassword("admin3").build(), CustomerInfEntity.newBuilder().customerPhone("13523423434").customerEmail("1738475867@qq.com").build()));
    }
}
