package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LJP
 * @Classname CustomerLoginEntity
 * @Date: 2019-12-01 20:55
 * @Description:用户登录信息实体类
 */
@Data
@AllArgsConstructor
public class CustomerLoginEntity {
    public CustomerLoginEntity() {
    }
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
     * userStats 用户账号状态
     */
    private Byte userStats;

    private CustomerLoginEntity(Builder builder) {
        customerId = builder.customerId;
        loginAccount = builder.loginAccount;
        loginName = builder.loginName;
        loginPassword = builder.loginPassword;
        userStats = builder.userStats;
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
        builder.userStats = copy.getUserStats();
        return builder;
    }


    public static final class Builder {
        private Integer customerId;
        private String loginAccount;
        private String loginName;
        private String loginPassword;
        private Byte userStats;

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

        public Builder userStats(Byte val) {
            userStats = val;
            return this;
        }

        public CustomerLoginEntity build() {
            return new CustomerLoginEntity(this);
        }
    }
}
