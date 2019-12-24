package com.nf.mall.dao.port;

import com.nf.mall.entity.ReceivingInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ReceivingInfDao
 * @Date: 2019-12-18 23:52
 * @Description:
 */
public interface ReceivingInfDao {
    List<ReceivingInfEntity> getByCustomerInfId(@Param("customerInfId") Integer customerInfId);
    ReceivingInfEntity getByReceivingInfId(@Param("receivingInfId") Integer receivingInfId);
    Integer receivingInfInsert(@Param("receivingInfEntity") ReceivingInfEntity receivingInfEntity);
    Integer receivingInfDelete(@Param("receivingInfEntity") ReceivingInfEntity receivingInfEntity);
    Integer receivingInfUpdate(@Param("receivingInfEntity") ReceivingInfEntity receivingInfEntity);
}
