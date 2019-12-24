package com.nf.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: LJP
 * @Classname ProductOrderEntity
 * @Date: 2019-12-20 22:14
 * @Description:
 */
@Data
@AllArgsConstructor
public class ProductOrderEntity {
    private Integer productOrderId;
    private Integer customerInfId;
    private Integer receivingInfId;
    private Integer productId;
    private Integer productCartId;
    private String  leaveWord;
    private Integer productNum;
    private Integer payment;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date submitTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date paymentTime;
    private Integer productOrderState;
    private String productOrderNumber;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-扩展字段=-=-==-=-=-=-=-=-=-=-=-=-=-=-=*/

    private String productName;
    private BigDecimal productPrice;
    private String pictureInfUrl;
    private Integer[] productOrderIds;
    private String receivingInfName;
    private String receivingInfPhone;
    private String receivingInfProvince;
    private String receivingInfCity;
    private String receivingInfDistrict;
    private String receivingInfAddress;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public ProductOrderEntity(){}

    private ProductOrderEntity(Builder builder) {
        productOrderId = builder.productOrderId;
        customerInfId = builder.customerInfId;
        receivingInfId = builder.receivingInfId;
        productId = builder.productId;
        productCartId = builder.productCartId;
        leaveWord = builder.leaveWord;
        productNum = builder.productNum;
        payment = builder.payment;
        submitTime = builder.submitTime;
        paymentTime = builder.paymentTime;
        productOrderState = builder.productOrderState;
        productOrderNumber = builder.productOrderNumber;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ProductOrderEntity copy) {
        Builder builder = new Builder();
        builder.productOrderId = copy.getProductOrderId();
        builder.customerInfId = copy.getCustomerInfId();
        builder.receivingInfId = copy.getReceivingInfId();
        builder.productId = copy.getProductId();
        builder.productCartId = copy.getProductCartId();
        builder.leaveWord = copy.getLeaveWord();
        builder.productNum = copy.getProductNum();
        builder.payment = copy.getPayment();
        builder.submitTime = copy.getSubmitTime();
        builder.paymentTime = copy.getPaymentTime();
        builder.productOrderState = copy.getProductOrderState();
        builder.productOrderNumber = copy.getProductOrderNumber();
        return builder;
    }

    public static final class Builder {
        private Integer productOrderId;
        private Integer customerInfId;
        private Integer receivingInfId;
        private Integer productId;
        private Integer productCartId;
        private String leaveWord;
        private Integer productNum;
        private Integer payment;
        private Date submitTime;
        private Date paymentTime;
        private Integer productOrderState;
        private String productOrderNumber;

        private Builder() {
        }

        public Builder productOrderId(Integer val) {
            productOrderId = val;
            return this;
        }

        public Builder customerInfId(Integer val) {
            customerInfId = val;
            return this;
        }

        public Builder receivingInfId(Integer val) {
            receivingInfId = val;
            return this;
        }

        public Builder productId(Integer val) {
            productId = val;
            return this;
        }

        public Builder productCartId(Integer val) {
            productCartId = val;
            return this;
        }

        public Builder leaveWord(String val) {
            leaveWord = val;
            return this;
        }

        public Builder productNum(Integer val) {
            productNum = val;
            return this;
        }

        public Builder payment(Integer val) {
            payment = val;
            return this;
        }

        public Builder submitTime(Date val) {
            submitTime = val;
            return this;
        }

        public Builder paymentTime(Date val) {
            paymentTime = val;
            return this;
        }

        public Builder productOrderState(Integer val) {
            productOrderState = val;
            return this;
        }

        public Builder productOrderNumber(String val) {
            productOrderNumber = val;
            return this;
        }

        public ProductOrderEntity build() {
            return new ProductOrderEntity(this);
        }
    }
}
