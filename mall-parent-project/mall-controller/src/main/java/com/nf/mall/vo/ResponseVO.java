package com.nf.mall.vo;

import lombok.Data;

/**
 * @Author: LJP
 * @Classname ResponseVO
 * @Date: 2019-12-02 19:04
 * @Description:
 */
@Data
public class ResponseVO {
    /**
     * code 状态码
     */
    private String code;
    /**
     * msg 状态信息
     */
    private String msg;
    /**
     * data 数据对象
     */
    private Object data;

    private ResponseVO(Builder builder) {
        code = builder.code;
        msg = builder.msg;
        data = builder.data;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ResponseVO copy) {
        Builder builder = new Builder();
        builder.code = copy.getCode();
        builder.msg = copy.getMsg();
        builder.data = copy.getData();
        return builder;
    }

    public static final class Builder {
        private String code;
        private String msg;
        private Object data;

        private Builder() {
        }

        public Builder code(String val) {
            code = val;
            return this;
        }

        public Builder msg(String val) {
            msg = val;
            return this;
        }

        public Builder data(Object val) {
            data = val;
            return this;
        }

        public ResponseVO build() {
            return new ResponseVO(this);
        }
    }
}
