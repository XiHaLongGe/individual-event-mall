package com.nf.mall.dao.port;

import com.nf.mall.entity.AfficheInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname AfficheInfDao
 * @Date: 2019-12-06 09:39
 * @Description:
 */
public interface AfficheInfDao {
    List<AfficheInfEntity> getAll();
}
