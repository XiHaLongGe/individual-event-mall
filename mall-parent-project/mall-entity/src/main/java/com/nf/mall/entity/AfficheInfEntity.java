package com.nf.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

/**
 * @Author: LJP
 * @Classname AfficheInfEntity
 * @Date: 2019-12-06 09:36
 * @Description:
 */
@Data
@AllArgsConstructor
public class AfficheInfEntity {
    private Integer afficheInfId;
    private Integer afficheTypeId;
    private Byte afficheState;
    private String afficheInfTitle;
    private String afficheInfContent;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date afficheTime;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-扩展字段=-=-==-=-=-=-=-=-=-=-=-=-=-=-=*/

    private String afficheType;

    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

    private AfficheInfEntity() {}

    private AfficheInfEntity(Builder builder) {
        afficheInfId = builder.afficheInfId;
        afficheTypeId = builder.afficheTypeId;
        afficheState = builder.afficheState;
        afficheInfTitle = builder.afficheInfTitle;
        afficheInfContent = builder.afficheInfContent;
        afficheTime = builder.afficheTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(AfficheInfEntity copy) {
        Builder builder = new Builder();
        builder.afficheInfId = copy.getAfficheInfId();
        builder.afficheTypeId = copy.getAfficheTypeId();
        builder.afficheState = copy.getAfficheState();
        builder.afficheInfTitle = copy.getAfficheInfTitle();
        builder.afficheInfContent = copy.getAfficheInfContent();
        builder.afficheTime = copy.getAfficheTime();
        return builder;
    }


    public static final class Builder {
        private Integer afficheInfId;
        private Integer afficheTypeId;
        private Byte afficheState;
        private String afficheInfTitle;
        private String afficheInfContent;
        private Date afficheTime;

        private Builder() {
        }

        public Builder afficheInfId(Integer val) {
            afficheInfId = val;
            return this;
        }

        public Builder afficheTypeId(Integer val) {
            afficheTypeId = val;
            return this;
        }

        public Builder afficheState(Byte val) {
            afficheState = val;
            return this;
        }

        public Builder afficheInfTitle(String val) {
            afficheInfTitle = val;
            return this;
        }

        public Builder afficheInfContent(String val) {
            afficheInfContent = val;
            return this;
        }

        public Builder afficheTime(Date val) {
            afficheTime = val;
            return this;
        }

        public AfficheInfEntity build() {
            return new AfficheInfEntity(this);
        }
    }
}
