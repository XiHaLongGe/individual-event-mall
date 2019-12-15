package com.nf.mall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author: LJP
 * @Classname LoginPageSearchVO
 * @Date: 2019-12-12 19:40
 * @Description:
 */

@Data
@AllArgsConstructor
public class LoginPageSearchVO {
    private String startTime;
    private String endTime;
    private String loginName;
    private Integer id;
    private Integer state;

    public LoginPageSearchVO(){}

    private LoginPageSearchVO(Builder builder) {
        startTime = builder.startTime;
        endTime = builder.endTime;
        loginName = builder.loginName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(LoginPageSearchVO copy) {
        Builder builder = new Builder();
        builder.startTime = copy.getStartTime();
        builder.endTime = copy.getEndTime();
        builder.loginName = copy.getLoginName();
        return builder;
    }

    public static final class Builder {
        private String startTime;
        private String endTime;
        private String loginName;

        private Builder() {
        }

        public Builder startTime(String val) {
            startTime = val;
            return this;
        }

        public Builder endTime(String val) {
            endTime = val;
            return this;
        }

        public Builder loginName(String val) {
            loginName = val;
            return this;
        }

        public LoginPageSearchVO build() {
            return new LoginPageSearchVO(this);
        }
    }
}

