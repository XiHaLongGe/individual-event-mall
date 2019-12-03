package com.nf.mall.service.port;

import com.nf.mall.entity.CustomerLoginEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname CustomerLoginService
 * @Date: 2019-12-01 21:38
 * @Description:
 */
public interface CustomerLoginService {
    /**
     * @return 返回customer_login表的所有数据
     */
    List<CustomerLoginEntity> getAll();

    /**
     * 验证账号密码是否正确
     * @param account 账号
     * @param password 密码
     * @return 返回验证结果
     */
    boolean verify(String account, String password);

    /**
     * 判断用户注册信息是否添加成功
     * @param entity 用户登录信息实体类
     * @return 用户注册结果
     */
    boolean insert(CustomerLoginEntity entity);
}
