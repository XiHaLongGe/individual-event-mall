package com.nf.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.CustomerInfEntity;
import com.nf.mall.entity.CustomerLoginEntity;
import com.nf.mall.service.port.CustomerLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;


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
        System.out.println(service.register(CustomerLoginEntity.newBuilder().loginName("123123").loginAccount("123123").loginPassword("123123").creationTime(new Date()).build(), CustomerInfEntity.newBuilder().customerPhone("13523423434").customerEmail("1738475867@qq.com").build()));
    }

    @Test
    public void getCount() {
        System.out.println(service.getCount());
    }

    @Test
    public void getPageAll() {
        PageInfo<CustomerLoginEntity> pageInfo = new PageInfo(service.getPageAll(3, 2));
        for (CustomerLoginEntity customerLoginEntity : pageInfo.getList()) {
            System.out.println(customerLoginEntity);
        }
    }

    @Test
    public void getPageSearch() {
        for (CustomerLoginEntity pageSearch : service.getPageSearch("2019-10-11", "2019-12-12", "6",2,4)) {
            System.out.println(pageSearch);
        }
    }

    @Test
    public void updateState() {
        System.out.println(service.updateState(1,1));
    }

    @Test
    public void update() {
        System.out.println(service.update(CustomerLoginEntity.newBuilder().loginAccount("22871102780").loginName("xiha2").loginPassword("12121212").build()));
    }
}
