package com.nf.mall.dao.port;

import com.nf.mall.entity.CustomerInfEntity;
import com.nf.mall.entity.CustomerLoginEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

    List<CustomerLoginEntity> getPageAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<CustomerLoginEntity> getPageSearch(@Param("startTime")String startTime, @Param("endTime")String endTime, @Param("loginName")String loginName, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    CustomerLoginEntity getById(Integer id);

    Integer getCount();

    CustomerLoginEntity getByAccount(@Param("loginAccount") String loginAccount);

    Integer delete(Integer id);

    Integer batchDelete(@Param("batchId")Integer [] batchId);

    Integer update(@Param("customerLoginEntity")CustomerLoginEntity customerLoginEntity);

    Integer updatePassWord(@Param("customerLoginEntity")CustomerLoginEntity customerLoginEntity);

    Integer updateState(@Param("id")Integer id, @Param("state")Integer state);

    /**
     * 验证账号密码是否正确
     * @param entity 用户登录信息实体类
     * @return返回验证结果
     */
    Integer verifyAndById(CustomerLoginEntity entity);

    /**
     * 用户注册 添加账号信息
     * @param customerLoginEntity 用户登录信息实体类
     * @param customerInfEntity 用户个人信息实体类
     * @return 影响行数
     */
    Integer register(@Param("loginEntity") CustomerLoginEntity customerLoginEntity, @Param("infEntity") CustomerInfEntity customerInfEntity);

    /**
     * 根据激活码来修改用户账号的状态，也就是激活用户账号
     * @param code 激活码
     * @return 激活结果的影响行数
     */
    Integer activate(String code);
}
