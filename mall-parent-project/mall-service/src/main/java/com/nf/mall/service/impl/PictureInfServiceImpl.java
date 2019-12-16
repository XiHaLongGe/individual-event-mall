package com.nf.mall.service.impl;

import com.nf.mall.dao.port.PictureInfDao;
import com.nf.mall.entity.PictureInfEntity;
import com.nf.mall.service.port.PictureInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname AfficheImageServiceImpl
 * @Date: 2019-12-06 15:24
 * @Description:
 */
@Service
public class PictureInfServiceImpl implements PictureInfService {
    @Autowired
    private PictureInfDao dao;
    @Override
    public List<PictureInfEntity> getAll() {
        return dao.getAll();
    }

    @Override
    public List<PictureInfEntity> getByType(Integer pictureTypeId) {
        return dao.getByType(pictureTypeId);
    }

    @Override
    public List<PictureInfEntity> getByTypeAndPro(Integer pictureTypeId, Integer productId) {
        return dao.getByTypeAndPro(pictureTypeId, productId);
    }
}
