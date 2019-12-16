package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCategoryEntity
 * @Date: 2019-12-05 09:30
 * @Description:
 */
@Data
@AllArgsConstructor
public class ProductCategoryEntity {
    private Integer categoryId;
    private String categoryName;
    private Integer categoryLevel;
    private Integer parentId;

    private ProductCategoryEntity(){};

    private ProductCategoryEntity(Builder builder) {
        categoryId = builder.categoryId;
        categoryName = builder.categoryName;
        categoryLevel = builder.categoryLevel;
        parentId = builder.parentId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ProductCategoryEntity copy) {
        Builder builder = new Builder();
        builder.categoryId = copy.getCategoryId();
        builder.categoryName = copy.getCategoryName();
        builder.categoryLevel = copy.getCategoryLevel();
        builder.parentId = copy.getParentId();
        return builder;
    }

    public static final class Builder {
        private Integer categoryId;
        private String categoryName;
        private Integer categoryLevel;
        private Integer parentId;

        private Builder() {
        }

        public Builder categoryId(Integer val) {
            categoryId = val;
            return this;
        }

        public Builder categoryName(String val) {
            categoryName = val;
            return this;
        }

        public Builder categoryLevel(Integer val) {
            categoryLevel = val;
            return this;
        }

        public Builder parentId(Integer val) {
            parentId = val;
            return this;
        }

        public ProductCategoryEntity build() {
            return new ProductCategoryEntity(this);
        }
    }



}
