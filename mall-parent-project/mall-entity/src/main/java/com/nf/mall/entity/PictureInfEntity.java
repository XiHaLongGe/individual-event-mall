package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LJP
 * @Classname PictureInfEntity
 * @Date: 2019-12-06 15:17
 * @Description:
 */
@Data
@AllArgsConstructor
public class PictureInfEntity {
    private Integer pictureInfId;
    private Integer productId;
    private Integer pictureTypeId;
    private String pictureInfUrl;
    private Integer pictureInfOrder;
    private Byte pictureInfStatus;

    public PictureInfEntity(){}

    private PictureInfEntity(Builder builder) {
        pictureInfId = builder.pictureInfId;
        productId = builder.productId;
        pictureTypeId = builder.pictureTypeId;
        pictureInfUrl = builder.pictureInfUrl;
        pictureInfOrder = builder.pictureInfOrder;
        pictureInfStatus = builder.pictureInfStatus;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(PictureInfEntity copy) {
        Builder builder = new Builder();
        builder.pictureInfId = copy.getPictureInfId();
        builder.productId = copy.getProductId();
        builder.pictureTypeId = copy.getPictureTypeId();
        builder.pictureInfUrl = copy.getPictureInfUrl();
        builder.pictureInfOrder = copy.getPictureInfOrder();
        builder.pictureInfStatus = copy.getPictureInfStatus();
        return builder;
    }

    public static final class Builder {
        private Integer pictureInfId;
        private Integer productId;
        private Integer pictureTypeId;
        private String pictureInfUrl;
        private Integer pictureInfOrder;
        private Byte pictureInfStatus;

        private Builder() {
        }

        public Builder pictureInfId(Integer val) {
            pictureInfId = val;
            return this;
        }

        public Builder productId(Integer val) {
            productId = val;
            return this;
        }

        public Builder pictureTypeId(Integer val) {
            pictureTypeId = val;
            return this;
        }

        public Builder pictureInfUrl(String val) {
            pictureInfUrl = val;
            return this;
        }

        public Builder pictureInfOrder(Integer val) {
            pictureInfOrder = val;
            return this;
        }

        public Builder pictureInfStatus(Byte val) {
            pictureInfStatus = val;
            return this;
        }

        public PictureInfEntity build() {
            return new PictureInfEntity(this);
        }
    }
}
