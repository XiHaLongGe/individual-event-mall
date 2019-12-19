package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LJP
 * @Classname LabelInfEntity
 * @Date: 2019-12-19 12:05
 * @Description:
 */
@Data
@AllArgsConstructor
public class LabelInfEntity {
    private Integer labelInfId;
    private Integer customerInfId;
    private String labelInfName;
    public LabelInfEntity(){}

    private LabelInfEntity(Builder builder) {
        labelInfId = builder.labelInfId;
        customerInfId = builder.customerInfId;
        labelInfName = builder.labelInfName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(LabelInfEntity copy) {
        Builder builder = new Builder();
        builder.labelInfId = copy.getLabelInfId();
        builder.customerInfId = copy.getCustomerInfId();
        builder.labelInfName = copy.getLabelInfName();
        return builder;
    }


    public static final class Builder {
        private Integer labelInfId;
        private Integer customerInfId;
        private String labelInfName;

        private Builder() {
        }

        public Builder labelInfId(Integer val) {
            labelInfId = val;
            return this;
        }

        public Builder customerInfId(Integer val) {
            customerInfId = val;
            return this;
        }

        public Builder labelInfName(String val) {
            labelInfName = val;
            return this;
        }

        public LabelInfEntity build() {
            return new LabelInfEntity(this);
        }
    }
}
