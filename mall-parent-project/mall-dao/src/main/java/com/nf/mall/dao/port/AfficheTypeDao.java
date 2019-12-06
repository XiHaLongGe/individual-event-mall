package com.nf.mall.dao.port;

import com.nf.mall.entity.AfficheTypeEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname AfficheTypeDao
 * @Date: 2019-12-06 09:39
 * @Description:
 */
public interface AfficheTypeDao {
    List<AfficheTypeEntity> getAll();
}
