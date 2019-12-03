package com.nf.mall.vo;

import com.nf.mall.entity.CustomerLoginEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LJP
 * @Classname RegisterVO
 * @Date: 2019-12-03 21:37
 * @Description:
 */
@Data
@AllArgsConstructor
public class RegisterVO {
    private String loginName;
    private String loginPassword;
    private String customerPhone;
    private String customerEmail;

    public RegisterVO() {
    }

    private RegisterVO(Builder builder) {
        loginName = builder.loginName;
        loginPassword = builder.loginPassword;
        customerPhone = builder.customerPhone;
        customerEmail = builder.customerEmail;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(RegisterVO copy) {
        Builder builder = new Builder();
        builder.loginName = copy.getLoginName();
        builder.loginPassword = copy.getLoginPassword();
        builder.customerPhone = copy.getCustomerPhone();
        builder.customerEmail = copy.getCustomerEmail();
        return builder;
    }


    public static final class Builder {
        private String loginName;
        private String loginPassword;
        private String customerPhone;
        private String customerEmail;

        private Builder() {
        }

        public Builder loginName(String val) {
            loginName = val;
            return this;
        }

        public Builder loginPassword(String val) {
            loginPassword = val;
            return this;
        }

        public Builder customerPhone(String val) {
            customerPhone = val;
            return this;
        }

        public Builder customerEmail(String val) {
            customerEmail = val;
            return this;
        }

        public RegisterVO build() {
            return new RegisterVO(this);
        }
    }
}
