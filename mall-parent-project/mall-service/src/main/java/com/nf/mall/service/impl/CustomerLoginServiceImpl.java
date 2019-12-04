package com.nf.mall.service.impl;

import com.nf.mall.dao.port.CustomerLoginDao;
import com.nf.mall.entity.CustomerInfEntity;
import com.nf.mall.entity.CustomerLoginEntity;
import com.nf.mall.service.port.CustomerLoginService;
import com.nf.mall.util.CodeUtil;
import com.nf.mall.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Throwable.class)
    public boolean register(CustomerLoginEntity customerLoginEntity, CustomerInfEntity customerInfEntity) {
        /**
         * CodeUtil.generateUniqueCode() : 获取到激活码
         */
        String code = CodeUtil.generateUniqueCode();
        if(dao.register(CustomerLoginEntity.newBuilder(customerLoginEntity).activateCode(code).build(), customerInfEntity) > 0){
            new Thread(new MailUtil(customerInfEntity.getCustomerEmail(), code)).start();
            return true;
        }
        return false;
    }

    /**
     * 根据激活码来修改用户账号的状态，也就是激活用户账号
     * @param code 激活码
     * @return 激活结果的影响行数
     */
    @Override
    public boolean activate(String code) {
        return dao.activate(code) > 0;
    }
}
