package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LJP
 * @Classname CustomerInfEntity
 * @Date: 2019-12-02 08:13
 * @Description:
 */
@Data
@AllArgsConstructor
public class CustomerInfEntity {
    /**
     * customerInfId 用户个人信息ID
     */
    private Integer customerInfId;
    /**
     * customerId 用户登录ID
     */
    private Integer customerId;
    /**
     * customerName
     */
    private String customerInfName;
    /**
     * customerGender
     */
    private Byte customerInfGender;
    /**
     * customerCard
     */
    private String customerInfCard;
    /**
     * customerPhone
     */
    private String customerInfPhone;
    /**
     * customerEmail
     */
    private String customerInfEmail;

    public CustomerInfEntity() {
    }

    private CustomerInfEntity(Builder builder) {
        customerInfId = builder.customerInfId;
        customerId = builder.customerId;
        customerInfName = builder.customerInfName;
        customerInfGender = builder.customerInfGender;
        customerInfCard = builder.customerInfCard;
        customerInfPhone = builder.customerInfPhone;
        customerInfEmail = builder.customerInfEmail;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CustomerInfEntity copy) {
        Builder builder = new Builder();
        builder.customerInfId = copy.getCustomerInfId();
        builder.customerId = copy.getCustomerId();
        builder.customerInfName = copy.getCustomerInfName();
        builder.customerInfGender = copy.getCustomerInfGender();
        builder.customerInfCard = copy.getCustomerInfCard();
        builder.customerInfPhone = copy.getCustomerInfPhone();
        builder.customerInfEmail = copy.getCustomerInfEmail();
        return builder;
    }

    public static final class Builder {
        private Integer customerInfId;
        private Integer customerId;
        private String customerInfName;
        private Byte customerInfGender;
        private String customerInfCard;
        private String customerInfPhone;
        private String customerInfEmail;

        private Builder() {
        }

        public Builder customerInfId(Integer val) {
            customerInfId = val;
            return this;
        }

        public Builder customerId(Integer val) {
            customerId = val;
            return this;
        }

        public Builder customerInfName(String val) {
            customerInfName = val;
            return this;
        }

        public Builder customerInfGender(Byte val) {
            customerInfGender = val;
            return this;
        }

        public Builder customerInfCard(String val) {
            customerInfCard = val;
            return this;
        }

        public Builder customerInfPhone(String val) {
            customerInfPhone = val;
            return this;
        }

        public Builder customerInfEmail(String val) {
            customerInfEmail = val;
            return this;
        }

        public CustomerInfEntity build() {
            return new CustomerInfEntity(this);
        }
    }
}
