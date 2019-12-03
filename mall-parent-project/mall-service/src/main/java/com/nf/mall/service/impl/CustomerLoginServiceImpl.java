package com.nf.mall.service.impl;

import com.nf.mall.dao.port.CustomerLoginDao;
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
     * @param account  账号
     * @param password 密码
     * @return 返回验证结果
     */
    @Override
    public boolean verify(String account, String password) {
        Integer result = dao.verifyAndById(account, password);
        return result != null && result > 0;
    }

    /**
     * 判断用户注册信息是否添加成功
     * @param entity 用户登录信息实体类
     * @return 用户注册结果
     */
    @Override
    public boolean register(CustomerLoginEntity entity) {
        return dao.insert(entity) > 0;
    }
}
