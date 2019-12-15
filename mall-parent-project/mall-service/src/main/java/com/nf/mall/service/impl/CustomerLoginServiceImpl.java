package com.nf.mall.service.impl;

import com.nf.mall.dao.port.CustomerLoginDao;
import com.nf.mall.entity.CustomerInfEntity;
import com.nf.mall.entity.CustomerLoginEntity;
import com.nf.mall.service.port.CustomerLoginService;
import com.nf.mall.util.CodeUtil;
import com.nf.mall.util.MailUtil;
import com.nf.mall.util.Md5Util;
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

    @Override
    public List<CustomerLoginEntity> getPageAll(Integer pageNum, Integer pageSize) {
        return dao.getPageAll(pageNum, pageSize);
    }

    @Override
    public List<CustomerLoginEntity> getPageSearch(String startTime, String endTime, String loginName, Integer pageNum, Integer pageSize) {
        return dao.getPageSearch(startTime, endTime, loginName, pageNum, pageSize);
    }

    @Override
    public CustomerLoginEntity getById(Integer id) {
        return dao.getById(id);
    }

    @Override
    public Integer getCount() {
        return dao.getCount();
    }

    @Override
    public boolean update(CustomerLoginEntity customerLoginEntity) {
        return dao.update(customerLoginEntity) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return dao.delete(id) > 0;
    }

    @Override
    public boolean batchDelete(Integer[] batchId) {
        return dao.batchDelete(batchId) == batchId.length;
    }

    @Override
    public boolean updatePassWord(CustomerLoginEntity customerLoginEntity) {
        if(verify(customerLoginEntity)){
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-验证成功");
            String madNewPwd = Md5Util.encodeByMd5(customerLoginEntity.getNewPassword());
            return dao.updatePassWord(CustomerLoginEntity.newBuilder(customerLoginEntity).loginPassword(madNewPwd).build()) > 0;
        }
        return false;
    }

    @Override
    public boolean updateState(Integer id, Integer state) {
        return dao.updateState(id, state) > 0;
    }

    /**
     * 验证账号密码是否正确
     * @param entity 用户登录信息实体类
     * @return返回验证结果
     */
    @Override
    public boolean verify(CustomerLoginEntity entity) {
        //这里对用户登录时输入的密码进行MD5加密，加密后再到数据库进行查找
        //原因：因为注册账号时添加到数据库的密码是经过MD5加密后的格式
        String md5Pwd = Md5Util.encodeByMd5(entity.getLoginPassword());
        //获得一个新的对象，将传过来的对象中的密码字段进行MD5加密
        CustomerLoginEntity customerLoginEntity = CustomerLoginEntity.newBuilder(entity).loginPassword(md5Pwd).build();
        Integer result = dao.verifyAndById(customerLoginEntity);
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
        String md5Pwd = Md5Util.encodeByMd5(customerLoginEntity.getLoginPassword());
        /**
         * CodeUtil.generateUniqueCode() : 获取到激活码
         */
        String code = CodeUtil.generateUniqueCode();
        if(dao.register(CustomerLoginEntity.newBuilder(customerLoginEntity).loginPassword(md5Pwd).activateCode(code).build(), customerInfEntity) > 0){
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
