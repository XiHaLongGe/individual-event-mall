package com.nf.mall.entity;

import lombok.Data;

/**
 * @Author: LJP
 * @Classname CustomerInfEntity
 * @Date: 2019-12-02 08:13
 * @Description:
 */
@Data
public class CustomerInfEntity {
    /**
     * customerInfId 用户个人信息ID
     */
    private Integer customerInfId;
    /**
     * customerId 用户登录ID
     */
    private Integer customerId;
    /**
     * customerName
     */
    private String customerName;
    /**
     * customerGender
     */
    private Byte customerGender;
    /**
     * customerCard
     */
    private String customerCard;
    /**
     * customerPhone
     */
    private String customerPhone;
    /**
     * customerEmail
     */
    private String customerEmail;
    /**
     * customerRegion
     */
    private String customerRegion;

}
