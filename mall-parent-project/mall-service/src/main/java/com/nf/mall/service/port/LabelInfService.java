package com.nf.mall.service.port;

import com.nf.mall.entity.LabelInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname LabelInfService
 * @Date: 2019-12-19 14:42
 * @Description:
 */
public interface LabelInfService {
    List<LabelInfEntity> getAll();
    List<LabelInfEntity> labelInfByCustomerInfId(Integer customerInfId);
    Integer labelInfInsert(LabelInfEntity labelInfEntity);
}
