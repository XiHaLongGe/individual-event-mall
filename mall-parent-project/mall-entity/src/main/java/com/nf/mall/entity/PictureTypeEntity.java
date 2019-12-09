package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LJP
 * @Classname PictureTypeEntity
 * @Date: 2019-12-09 22:21
 * @Description:
 */
@Data
@AllArgsConstructor
public class PictureTypeEntity {
    private Integer pictureTypeId;
    private String pictureTypeName;

    public PictureTypeEntity(){}

    private PictureTypeEntity(Builder builder) {
        pictureTypeId = builder.pictureTypeId;
        pictureTypeName = builder.pictureTypeName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(PictureTypeEntity copy) {
        Builder builder = new Builder();
        builder.pictureTypeId = copy.getPictureTypeId();
        builder.pictureTypeName = copy.getPictureTypeName();
        return builder;
    }


    public static final class Builder {
        private Integer pictureTypeId;
        private String pictureTypeName;

        private Builder() {
        }

        public Builder pictureTypeId(Integer val) {
            pictureTypeId = val;
            return this;
        }

        public Builder pictureTypeName(String val) {
            pictureTypeName = val;
            return this;
        }

        public PictureTypeEntity build() {
            return new PictureTypeEntity(this);
        }
    }
}
