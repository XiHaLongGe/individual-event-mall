package com.nf.mall.service.impl;

import com.nf.mall.config.AppConfig;
import com.nf.mall.entity.SidebarCategoryEntity;
import com.nf.mall.service.port.SidebarCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SidebarCategoryServiceImplTest {
    @Autowired
    private SidebarCategoryService sidebarCategoryService;

    @Test
    public void getAll() {
    }

    @Test
    public void getByLevel() {
        for (SidebarCategoryEntity sidebarCategoryEntity : sidebarCategoryService.getByLevel(2, 1)) {
            System.out.println(sidebarCategoryEntity);
        }
    }
}