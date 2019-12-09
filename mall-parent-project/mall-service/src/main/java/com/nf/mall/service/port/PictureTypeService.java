package com.nf.mall.service.port;

import com.nf.mall.entity.PictureTypeEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PictureTypeService
 * @Date: 2019-12-09 22:29
 * @Description:
 */
public interface PictureTypeService {
    List<PictureTypeEntity> getAll();
    PictureTypeEntity getById(Integer id);
    PictureTypeEntity getByName(String name);
}
