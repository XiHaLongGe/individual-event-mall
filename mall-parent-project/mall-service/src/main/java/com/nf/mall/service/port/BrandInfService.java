package com.nf.mall.service.port;

import com.nf.mall.entity.BrandInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname BrandInfService
 * @Date: 2019-12-05 09:47
 * @Description:
 */
public interface BrandInfService {
    List<BrandInfEntity> getAll();
    List<String> getByListName(Integer categoryId);
}
