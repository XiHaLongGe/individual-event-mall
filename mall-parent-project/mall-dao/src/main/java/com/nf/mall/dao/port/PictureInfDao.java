package com.nf.mall.dao.port;

import com.nf.mall.entity.PictureInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PictureInfDao
 * @Date: 2019-12-06 15:21
 * @Description:
 */
public interface PictureInfDao {
    List<PictureInfEntity> getAll();
    List<PictureInfEntity> getByType(Integer pictureTypeId);
    List<PictureInfEntity> getByTypeAndPro(@Param("pictureTypeId") Integer pictureTypeId, @Param("productId") Integer productId);
}
