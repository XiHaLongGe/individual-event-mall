package com.nf.mall.service.impl;

import com.nf.mall.dao.port.SidebarCategoryDao;
import com.nf.mall.entity.SidebarCategoryEntity;
import com.nf.mall.service.port.SidebarCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname SidebarCategoryServiceImpl
 * @Date: 2019-12-15 22:59
 * @Description:
 */
@Service
public class SidebarCategoryServiceImpl implements SidebarCategoryService {
    @Autowired
    private SidebarCategoryDao dao;
    @Override
    public List<SidebarCategoryEntity> getAll() {
        return dao.getAll();
    }

    @Override
    public List<SidebarCategoryEntity> getByLevel(Integer levelNum, Integer parentId) {
        return dao.getByLevel(levelNum, parentId);
    }

    @Override
    public SidebarCategoryEntity getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    public SidebarCategoryEntity getByName(String sidebarCategoryName) {
        return dao.getByName(sidebarCategoryName);
    }
}
