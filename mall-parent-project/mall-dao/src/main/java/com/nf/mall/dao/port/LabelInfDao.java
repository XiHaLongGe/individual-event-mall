package com.nf.mall.dao.port;

import com.nf.mall.entity.LabelInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname LabelInfDao
 * @Date: 2019-12-19 12:08
 * @Description:
 */
public interface LabelInfDao {
    List<LabelInfEntity> getAll();
    List<LabelInfEntity> labelInfByCustomerInfId(@Param("customerInfId") Integer customerInfId);
    Integer labelInfInsert(@Param("labelInfEntity") LabelInfEntity labelInfEntity);
}
