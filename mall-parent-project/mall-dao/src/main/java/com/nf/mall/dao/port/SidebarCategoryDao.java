package com.nf.mall.dao.port;

import com.nf.mall.entity.SidebarCategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname SidebarCategoryDao
 * @Date: 2019-12-15 16:41
 * @Description:
 */
public interface SidebarCategoryDao {
    List<SidebarCategoryEntity> getAll();
    List<SidebarCategoryEntity> getByLevel(@Param("levelNum") Integer levelNum, @Param("parentId") Integer parentId);
    SidebarCategoryEntity getById(Integer id);
    SidebarCategoryEntity getByName(String sidebarCategoryName);
}
