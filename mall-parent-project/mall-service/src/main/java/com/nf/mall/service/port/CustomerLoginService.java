package com.nf.mall.service.port;

import com.nf.mall.entity.CustomerInfEntity;
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
     * @param entity 用户登录信息实体类
     * @return返回验证结果
     */
    boolean verify(CustomerLoginEntity entity);

    /**
     * 用户注册 添加账号信息
     * @param customerLoginEntity 用户登录信息实体类
     * @param customerInfEntity 用户个人信息实体类
     * @return 影响行数
     */
    boolean register(CustomerLoginEntity customerLoginEntity, CustomerInfEntity customerInfEntity);
}
