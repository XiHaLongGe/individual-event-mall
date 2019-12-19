package com.nf.mall.service.impl;

import com.nf.mall.dao.port.LabelInfDao;
import com.nf.mall.entity.LabelInfEntity;
import com.nf.mall.service.port.LabelInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname LabelInfServiceImpl
 * @Date: 2019-12-19 14:42
 * @Description:
 */
@Service
public class LabelInfServiceImpl implements LabelInfService {
    @Autowired
    private LabelInfDao dao;
    @Override
    public List<LabelInfEntity> getAll() {
        return dao.getAll();
    }

    @Override
    public List<LabelInfEntity> labelInfByCustomerInfId(Integer customerInfId) {
        return dao.labelInfByCustomerInfId(customerInfId);
    }

    @Override
    public Integer labelInfInsert(LabelInfEntity labelInfEntity) {
        return dao.labelInfInsert(labelInfEntity);
    }
}
