package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LJP
 * @Classname SidebarCategoryEntity
 * @Date: 2019-12-15 16:37
 * @Description:
 */

@Data
@AllArgsConstructor
public class SidebarCategoryEntity {
    private Integer sidebarCategoryId;
    private String sidebarCategoryName;
    private String sidebarCategoryDescribe;
    private Integer sidebarCategoryLevel;
    private Integer parentId;

    public SidebarCategoryEntity(){}

    private SidebarCategoryEntity(Builder builder) {
        sidebarCategoryId = builder.sidebarCategoryId;
        sidebarCategoryName = builder.sidebarCategoryName;
        sidebarCategoryDescribe = builder.sidebarCategoryDescribe;
        sidebarCategoryLevel = builder.sidebarCategoryLevel;
        parentId = builder.parentId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(SidebarCategoryEntity copy) {
        Builder builder = new Builder();
        builder.sidebarCategoryId = copy.getSidebarCategoryId();
        builder.sidebarCategoryName = copy.getSidebarCategoryName();
        builder.sidebarCategoryDescribe = copy.getSidebarCategoryDescribe();
        builder.sidebarCategoryLevel = copy.getSidebarCategoryLevel();
        builder.parentId = copy.getParentId();
        return builder;
    }


    public static final class Builder {
        private Integer sidebarCategoryId;
        private String sidebarCategoryName;
        private String sidebarCategoryDescribe;
        private Integer sidebarCategoryLevel;
        private Integer parentId;

        private Builder() {
        }

        public Builder sidebarCategoryId(Integer val) {
            sidebarCategoryId = val;
            return this;
        }

        public Builder sidebarCategoryName(String val) {
            sidebarCategoryName = val;
            return this;
        }

        public Builder sidebarCategoryDescribe(String val) {
            sidebarCategoryDescribe = val;
            return this;
        }

        public Builder sidebarCategoryLevel(Integer val) {
            sidebarCategoryLevel = val;
            return this;
        }

        public Builder parentId(Integer val) {
            parentId = val;
            return this;
        }

        public SidebarCategoryEntity build() {
            return new SidebarCategoryEntity(this);
        }
    }
}

