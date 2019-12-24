package com.nf.mall.service.impl;

import com.nf.mall.dao.port.ReceivingInfDao;
import com.nf.mall.entity.ReceivingInfEntity;
import com.nf.mall.service.port.ReceivingInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ReceivingInfServiceImpl
 * @Date: 2019-12-19 08:07
 * @Description:
 */
@Service
public class ReceivingInfServiceImpl implements ReceivingInfService {
    @Autowired
    private ReceivingInfDao dao;
    @Override
    public List<ReceivingInfEntity> getByCustomerInfId(Integer customerInfId) {
        return dao.getByCustomerInfId(customerInfId);
    }

    @Override
    public ReceivingInfEntity getByReceivingInfId(Integer receivingInfId) {
        return dao.getByReceivingInfId(receivingInfId);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public boolean receivingInfInsert(ReceivingInfEntity receivingInfEntity) {
        return dao.receivingInfInsert(receivingInfEntity) > 0;
    }

    @Override
    public boolean receivingInfDelete(ReceivingInfEntity receivingInfEntity) {
        return dao.receivingInfDelete(receivingInfEntity) > 0;
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public boolean receivingInfUpdate(ReceivingInfEntity receivingInfEntity) {
        return dao.receivingInfUpdate(receivingInfEntity) > 0;
    }
}
