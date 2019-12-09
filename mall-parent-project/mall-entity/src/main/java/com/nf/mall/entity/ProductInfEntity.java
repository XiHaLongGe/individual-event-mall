package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: LJP
 * @Classname ProductInfEntity
 * @Date: 2019-12-09 15:23
 * @Description:
 */
@Data
@AllArgsConstructor
public class ProductInfEntity {
    private Integer productId;
    private Integer brandId;
    private Integer categoryId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productSales;
    private Byte productStatus;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-扩展字段=-=-==-=-=-=-=-=-=-=-=-=-=-=-=*/

    private String pictureInfUrl;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public ProductInfEntity(){}

    private ProductInfEntity(Builder builder) {
        productId = builder.productId;
        brandId = builder.brandId;
        categoryId = builder.categoryId;
        productName = builder.productName;
        productPrice = builder.productPrice;
        productSales = builder.productSales;
        productStatus = builder.productStatus;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ProductInfEntity copy) {
        Builder builder = new Builder();
        builder.productId = copy.getProductId();
        builder.brandId = copy.getBrandId();
        builder.categoryId = copy.getCategoryId();
        builder.productName = copy.getProductName();
        builder.productPrice = copy.getProductPrice();
        builder.productSales = copy.getProductSales();
        builder.productStatus = copy.getProductStatus();
        return builder;
    }

    public static final class Builder {
        private Integer productId;
        private Integer brandId;
        private Integer categoryId;
        private String productName;
        private BigDecimal productPrice;
        private Integer productSales;
        private Byte productStatus;

        private Builder() {
        }

        public Builder productId(Integer val) {
            productId = val;
            return this;
        }

        public Builder brandId(Integer val) {
            brandId = val;
            return this;
        }

        public Builder categoryId(Integer val) {
            categoryId = val;
            return this;
        }

        public Builder productName(String val) {
            productName = val;
            return this;
        }

        public Builder productPrice(BigDecimal val) {
            productPrice = val;
            return this;
        }

        public Builder productSales(Integer val) {
            productSales = val;
            return this;
        }

        public Builder productStatus(Byte val) {
            productStatus = val;
            return this;
        }

        public ProductInfEntity build() {
            return new ProductInfEntity(this);
        }
    }
}
