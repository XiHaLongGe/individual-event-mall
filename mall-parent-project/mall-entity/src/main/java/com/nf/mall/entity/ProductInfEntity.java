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
    private Byte hotSale;
    private Integer sidebarCategoryId;
    private String productName;
    private String productDescribe;
    private BigDecimal productPrice;
    private Integer productSales;
    private Byte productStatus;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-扩展字段=-=-==-=-=-=-=-=-=-=-=-=-=-=-=*/

    private String pictureInfUrl;
    private Integer productNum;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    public ProductInfEntity(){}

    private ProductInfEntity(Builder builder) {
        productId = builder.productId;
        brandId = builder.brandId;
        categoryId = builder.categoryId;
        hotSale = builder.hotSale;
        sidebarCategoryId = builder.sidebarCategoryId;
        productName = builder.productName;
        productDescribe = builder.productDescribe;
        productPrice = builder.productPrice;
        productSales = builder.productSales;
        productStatus = builder.productStatus;
        pictureInfUrl = builder.pictureInfUrl;
        productNum = builder.productNum;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ProductInfEntity copy) {
        Builder builder = new Builder();
        builder.productId = copy.getProductId();
        builder.brandId = copy.getBrandId();
        builder.categoryId = copy.getCategoryId();
        builder.hotSale = copy.getHotSale();
        builder.sidebarCategoryId = copy.getSidebarCategoryId();
        builder.productName = copy.getProductName();
        builder.productDescribe = copy.getProductDescribe();
        builder.productPrice = copy.getProductPrice();
        builder.productSales = copy.getProductSales();
        builder.productStatus = copy.getProductStatus();
        builder.pictureInfUrl = copy.getPictureInfUrl();
        builder.productNum = copy.getProductNum();
        return builder;
    }

    public static final class Builder {
        private Integer productId;
        private Integer brandId;
        private Integer categoryId;
        private Byte hotSale;
        private Integer sidebarCategoryId;
        private String productName;
        private String productDescribe;
        private BigDecimal productPrice;
        private Integer productSales;
        private Byte productStatus;
        private String pictureInfUrl;
        private Integer productNum;

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

        public Builder hotSale(Byte val) {
            hotSale = val;
            return this;
        }

        public Builder sidebarCategoryId(Integer val) {
            sidebarCategoryId = val;
            return this;
        }

        public Builder productName(String val) {
            productName = val;
            return this;
        }

        public Builder productDescribe(String val) {
            productDescribe = val;
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

        public Builder pictureInfUrl(String val) {
            pictureInfUrl = val;
            return this;
        }

        public Builder productNum(Integer val) {
            productNum = val;
            return this;
        }

        public ProductInfEntity build() {
            return new ProductInfEntity(this);
        }
    }
}
