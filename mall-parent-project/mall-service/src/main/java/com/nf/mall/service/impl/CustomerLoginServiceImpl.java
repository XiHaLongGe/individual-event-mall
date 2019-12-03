package com.nf.mall.service.impl;

import com.nf.mall.dao.port.CustomerLoginDao;
import com.nf.mall.entity.CustomerInfEntity;
import com.nf.mall.entity.CustomerLoginEntity;
import com.nf.mall.service.port.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname CustomerLoginServiceImpl
 * @Date: 2019-12-01 21:47
 * @Description:
 */
@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {
    @Autowired
    private CustomerLoginDao dao;
    /**
     * @return 返回customer_login表的所有数据
     */
    @Override
    public List<CustomerLoginEntity> getAll() {
        return dao.getAll();
    }

    /**
     * 验证账号密码是否正确
     * @param entity 用户登录信息实体类
     * @return返回验证结果
     */
    @Override
    public boolean verify(CustomerLoginEntity entity) {
        Integer result = dao.verifyAndById(entity);
        return result != null && result > 0;
    }

    /**
     * 用户注册 添加账号信息
     * @param customerLoginEntity 用户登录信息实体类
     * @param customerInfEntity 用户个人信息实体类
     * @return 影响行数
     */
    @Override
    public boolean register(CustomerLoginEntity customerLoginEntity, CustomerInfEntity customerInfEntity) {
        return dao.register(customerLoginEntity, customerInfEntity) > 0;
    }
}
