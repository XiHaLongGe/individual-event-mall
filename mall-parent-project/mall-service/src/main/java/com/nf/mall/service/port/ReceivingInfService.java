package com.nf.mall.service.port;

import com.nf.mall.entity.ReceivingInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ReceivingInfService
 * @Date: 2019-12-19 08:06
 * @Description:
 */
public interface ReceivingInfService {
    List<ReceivingInfEntity> getByCustomerInfId(Integer customerInfId);
    ReceivingInfEntity getByReceivingInfId(Integer receivingInfId);
    boolean receivingInfInsert(ReceivingInfEntity receivingInfEntity);
    boolean receivingInfDelete(ReceivingInfEntity receivingInfEntity);
    boolean receivingInfUpdate(ReceivingInfEntity receivingInfEntity);
}
