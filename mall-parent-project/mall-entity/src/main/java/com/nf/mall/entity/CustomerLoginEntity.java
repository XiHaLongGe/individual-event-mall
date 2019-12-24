package com.nf.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author: LJP
 * @Classname CustomerLoginEntity
 * @Date: 2019-12-01 20:55
 * @Description:用户登录信息实体类
 */
@Data
@AllArgsConstructor
public class CustomerLoginEntity {

    /**
     * customerId 用户登录id
     */
    private Integer customerId;
    /**
     * loginAccount 用户登录账号
     */
    private String loginAccount;
    /**
     * loginName 用户昵称
     */
    private String loginName;
    /**
     * loginPassword 用户登录密码
     */
    private String loginPassword;
    /**
     * activateCode : 账号激活码
     */
    private String activateCode;
    /**
     * userStats 用户账号状态
     */
    private Byte userStats;
    /**
     * creation 用户账号创建日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date creationTime;


    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-扩展字段=-=-==-=-=-=-=-=-=-=-=-=-=-=-=*/

    private String newPassword;
    private String customerInfId;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public CustomerLoginEntity() {
    }

    private CustomerLoginEntity(Builder builder) {
        customerId = builder.customerId;
        loginAccount = builder.loginAccount;
        loginName = builder.loginName;
        loginPassword = builder.loginPassword;
        activateCode = builder.activateCode;
        userStats = builder.userStats;
        creationTime = builder.creationTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CustomerLoginEntity copy) {
        Builder builder = new Builder();
        builder.customerId = copy.getCustomerId();
        builder.loginAccount = copy.getLoginAccount();
        builder.loginName = copy.getLoginName();
        builder.loginPassword = copy.getLoginPassword();
        builder.activateCode = copy.getActivateCode();
        builder.userStats = copy.getUserStats();
        builder.creationTime = copy.getCreationTime();
        return builder;
    }

    public static final class Builder {
        private Integer customerId;
        private String loginAccount;
        private String loginName;
        private String loginPassword;
        private String activateCode;
        private Byte userStats;
        private Date creationTime;

        private Builder() {
        }

        public Builder customerId(Integer val) {
            customerId = val;
            return this;
        }

        public Builder loginAccount(String val) {
            loginAccount = val;
            return this;
        }

        public Builder loginName(String val) {
            loginName = val;
            return this;
        }

        public Builder loginPassword(String val) {
            loginPassword = val;
            return this;
        }

        public Builder activateCode(String val) {
            activateCode = val;
            return this;
        }

        public Builder userStats(Byte val) {
            userStats = val;
            return this;
        }

        public Builder creationTime(Date val) {
            creationTime = val;
            return this;
        }

        public CustomerLoginEntity build() {
            return new CustomerLoginEntity(this);
        }
    }
}
