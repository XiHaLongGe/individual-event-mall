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
    private String customerName;
    /**
     * customerGender
     */
    private Byte customerGender;
    /**
     * customerCard
     */
    private String customerCard;
    /**
     * customerPhone
     */
    private String customerPhone;
    /**
     * customerEmail
     */
    private String customerEmail;
    /**
     * customerRegion
     */
    private String customerRegion;

    public CustomerInfEntity() {
    }

    public CustomerInfEntity(String customerPhone, String customerEmail) {
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
    }


    private CustomerInfEntity(Builder builder) {
        customerInfId = builder.customerInfId;
        customerId = builder.customerId;
        customerName = builder.customerName;
        customerGender = builder.customerGender;
        customerCard = builder.customerCard;
        customerPhone = builder.customerPhone;
        customerEmail = builder.customerEmail;
        customerRegion = builder.customerRegion;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CustomerInfEntity copy) {
        Builder builder = new Builder();
        builder.customerInfId = copy.getCustomerInfId();
        builder.customerId = copy.getCustomerId();
        builder.customerName = copy.getCustomerName();
        builder.customerGender = copy.getCustomerGender();
        builder.customerCard = copy.getCustomerCard();
        builder.customerPhone = copy.getCustomerPhone();
        builder.customerEmail = copy.getCustomerEmail();
        builder.customerRegion = copy.getCustomerRegion();
        return builder;
    }


    public static final class Builder {
        private Integer customerInfId;
        private Integer customerId;
        private String customerName;
        private Byte customerGender;
        private String customerCard;
        private String customerPhone;
        private String customerEmail;
        private String customerRegion;

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

        public Builder customerName(String val) {
            customerName = val;
            return this;
        }

        public Builder customerGender(Byte val) {
            customerGender = val;
            return this;
        }

        public Builder customerCard(String val) {
            customerCard = val;
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

        public Builder customerRegion(String val) {
            customerRegion = val;
            return this;
        }

        public CustomerInfEntity build() {
            return new CustomerInfEntity(this);
        }
    }
}
