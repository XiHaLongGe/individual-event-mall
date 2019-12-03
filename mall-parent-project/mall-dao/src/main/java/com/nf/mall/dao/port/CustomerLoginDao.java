package com.nf.mall.dao.port;

import com.nf.mall.entity.CustomerLoginEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname CustomerLoginDao
 * @Date: 2019-12-01 20:54
 * @Description:
 */
public interface CustomerLoginDao {
    /**
     * 返回customer_login表的所有数据
     * @return
     */
    List<CustomerLoginEntity> getAll();

    /**
     * 通过账号和密码来获得用户ID
     * @param account 账号
     * @param password 密码
     * @return 返回用户ID
     */
    Integer verifyAndById(String account, String password);

    /**
     * 用户注册 添加账号信息
     * @param entity 用户登录信息实体类
     * @return 影响行数
     */
    Integer insert(CustomerLoginEntity entity);
}
