package com.nf.mall.util;

import java.util.UUID;

/**
 * @Author: LJP
 * @Classname CodeUtil
 * @Date: 2019-12-04 08:16
 * @Description:
 */
public final class CodeUtil {
    /**
     * 生成唯一的激活码
     * @return 激活码
     */
    public static String generateUniqueCode(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
