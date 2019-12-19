package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LJP
 * @Classname ReceivingInfEntity
 * @Date: 2019-12-18 23:47
 * @Description:
 */

@Data
@AllArgsConstructor
public class ReceivingInfEntity {
    private Integer receivingInfId;
    private Integer customerInfId;
    private String receivingInfName;
    private String receivingInfPhone;
    private String receivingInfProvince;
    private String receivingInfCity;
    private String receivingInfDistrict;
    private String receivingInfAddress;
    private String postalCode;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-扩展字段=-=-==-=-=-=-=-=-=-=-=-=-=-=-=*/

    private String labelInfName;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public ReceivingInfEntity(){}

    private ReceivingInfEntity(Builder builder) {
        receivingInfId = builder.receivingInfId;
        customerInfId = builder.customerInfId;
        receivingInfName = builder.receivingInfName;
        receivingInfPhone = builder.receivingInfPhone;
        receivingInfProvince = builder.receivingInfProvince;
        receivingInfCity = builder.receivingInfCity;
        receivingInfDistrict = builder.receivingInfDistrict;
        receivingInfAddress = builder.receivingInfAddress;
        postalCode = builder.postalCode;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ReceivingInfEntity copy) {
        Builder builder = new Builder();
        builder.receivingInfId = copy.getReceivingInfId();
        builder.customerInfId = copy.getCustomerInfId();
        builder.receivingInfName = copy.getReceivingInfName();
        builder.receivingInfPhone = copy.getReceivingInfPhone();
        builder.receivingInfProvince = copy.getReceivingInfProvince();
        builder.receivingInfCity = copy.getReceivingInfCity();
        builder.receivingInfDistrict = copy.getReceivingInfDistrict();
        builder.receivingInfAddress = copy.getReceivingInfAddress();
        builder.postalCode = copy.getPostalCode();
        return builder;
    }


    public static final class Builder {
        private Integer receivingInfId;
        private Integer customerInfId;
        private String receivingInfName;
        private String receivingInfPhone;
        private String receivingInfProvince;
        private String receivingInfCity;
        private String receivingInfDistrict;
        private String receivingInfAddress;
        private String postalCode;

        private Builder() {
        }

        public Builder receivingInfId(Integer val) {
            receivingInfId = val;
            return this;
        }

        public Builder customerInfId(Integer val) {
            customerInfId = val;
            return this;
        }

        public Builder receivingInfName(String val) {
            receivingInfName = val;
            return this;
        }

        public Builder receivingInfPhone(String val) {
            receivingInfPhone = val;
            return this;
        }

        public Builder receivingInfProvince(String val) {
            receivingInfProvince = val;
            return this;
        }

        public Builder receivingInfCity(String val) {
            receivingInfCity = val;
            return this;
        }

        public Builder receivingInfDistrict(String val) {
            receivingInfDistrict = val;
            return this;
        }

        public Builder receivingInfAddress(String val) {
            receivingInfAddress = val;
            return this;
        }

        public Builder postalCode(String val) {
            postalCode = val;
            return this;
        }


        public ReceivingInfEntity build() {
            return new ReceivingInfEntity(this);
        }
    }
}
