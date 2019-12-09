package com.nf.mall.dao.port;

import com.nf.mall.entity.PictureTypeEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PictureTypeDao
 * @Date: 2019-12-09 22:23
 * @Description:
 */
public interface PictureTypeDao {
    List<PictureTypeEntity> getAll();
    PictureTypeEntity getById(Integer id);
    PictureTypeEntity getByName(String name);
}
