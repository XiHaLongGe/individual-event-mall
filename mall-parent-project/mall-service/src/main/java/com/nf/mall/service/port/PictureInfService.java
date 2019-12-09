package com.nf.mall.service.port;

import com.nf.mall.entity.PictureInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PictureInfService
 * @Date: 2019-12-06 15:23
 * @Description:
 */
public interface PictureInfService {
    List<PictureInfEntity> getAll();
    List<PictureInfEntity> getByType(Integer pictureTypeId);
}
