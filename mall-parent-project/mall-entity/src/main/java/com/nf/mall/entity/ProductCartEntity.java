package com.nf.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: LJP
 * @Classname ProductCartEntity
 * @Date: 2019-12-17 10:15
 * @Description:
 */
@Data
@AllArgsConstructor
public class ProductCartEntity {
    private Integer productCartId;
    private Integer customerInfId;
    private Integer productId;
    private Integer productCartNum;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date addTime;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-扩展字段=-=-==-=-=-=-=-=-=-=-=-=-=-=-=*/

    private Integer[] productIds;
    private Integer brandId;
    private String brandName;
    private String productName;
    private BigDecimal productPrice;
    private String productDescribe;
    private String pictureInfUrl;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public ProductCartEntity(){}

    private ProductCartEntity(Builder builder) {
        productCartId = builder.productCartId;
        customerInfId = builder.customerInfId;
        productId = builder.productId;
        productCartNum = builder.productCartNum;
        addTime = builder.addTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ProductCartEntity copy) {
        Builder builder = new Builder();
        builder.productCartId = copy.getProductCartId();
        builder.customerInfId = copy.getCustomerInfId();
        builder.productId = copy.getProductId();
        builder.productCartNum = copy.getProductCartNum();
        builder.addTime = copy.getAddTime();
        return builder;
    }


    public static final class Builder {
        private Integer productCartId;
        private Integer customerInfId;
        private Integer productId;
        private Integer productCartNum;
        private Date addTime;

        private Builder() {
        }

        public Builder productCartId(Integer val) {
            productCartId = val;
            return this;
        }

        public Builder customerInfId(Integer val) {
            customerInfId = val;
            return this;
        }

        public Builder productId(Integer val) {
            productId = val;
            return this;
        }

        public Builder productCartNum(Integer val) {
            productCartNum = val;
            return this;
        }

        public Builder addTime(Date val) {
            addTime = val;
            return this;
        }

        public ProductCartEntity build() {
            return new ProductCartEntity(this);
        }
    }
}
