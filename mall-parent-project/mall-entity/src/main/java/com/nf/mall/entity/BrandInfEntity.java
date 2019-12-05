package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LJP
 * @Classname BrandInfEntity
 * @Date: 2019-12-05 09:32
 * @Description:
 */
@Data
@AllArgsConstructor
public class BrandInfEntity {
    private Integer brandId;
    private String brandName;
    private Integer categoryId;
    private BrandInfEntity(){}

    private BrandInfEntity(Builder builder) {
        brandId = builder.brandId;
        brandName = builder.brandName;
        categoryId = builder.categoryId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(BrandInfEntity copy) {
        Builder builder = new Builder();
        builder.brandId = copy.getBrandId();
        builder.brandName = copy.getBrandName();
        builder.categoryId = copy.getCategoryId();
        return builder;
    }

    public static final class Builder {
        private Integer brandId;
        private String brandName;
        private Integer categoryId;

        private Builder() {
        }

        public Builder brandId(Integer val) {
            brandId = val;
            return this;
        }

        public Builder brandName(String val) {
            brandName = val;
            return this;
        }

        public Builder categoryId(Integer val) {
            categoryId = val;
            return this;
        }

        public BrandInfEntity build() {
            return new BrandInfEntity(this);
        }
    }
}
