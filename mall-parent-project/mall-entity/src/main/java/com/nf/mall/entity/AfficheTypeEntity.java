package com.nf.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: LJP
 * @Classname AfficheTypeEntity
 * @Date: 2019-12-06 09:31
 * @Description:
 */
@Data
@AllArgsConstructor
public class AfficheTypeEntity {
    private Integer afficheTypeId;
    private String afficheTypeName;

    private AfficheTypeEntity(){}

    private AfficheTypeEntity(Builder builder) {
        afficheTypeId = builder.afficheTypeId;
        afficheTypeName = builder.afficheTypeName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(AfficheTypeEntity copy) {
        Builder builder = new Builder();
        builder.afficheTypeId = copy.getAfficheTypeId();
        builder.afficheTypeName = copy.getAfficheTypeName();
        return builder;
    }

    public static final class Builder {
        private Integer afficheTypeId;
        private String afficheTypeName;

        private Builder() {
        }

        public Builder afficheTypeId(Integer val) {
            afficheTypeId = val;
            return this;
        }

        public Builder afficheTypeName(String val) {
            afficheTypeName = val;
            return this;
        }

        public AfficheTypeEntity build() {
            return new AfficheTypeEntity(this);
        }
    }
}
