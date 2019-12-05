package com.nf.mall.dao.port;

import com.nf.mall.entity.BrandInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname BrandInfDao
 * @Date: 2019-12-05 09:38
 * @Description:
 */
public interface BrandInfDao {
    List<BrandInfEntity> getAll();
    List<String> getByListName(Integer categoryId);
}
