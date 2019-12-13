package com.nf.mall.dao.port;

import com.nf.mall.entity.CustomerInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname CustomerInfDao
 * @Date: 2019-12-11 21:29
 * @Description:
 */
public interface CustomerInfDao {
    List<CustomerInfEntity> getAll();
    Integer getCount();
}
