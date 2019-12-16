package com.nf.mall.controller.fe;

import com.nf.mall.service.port.SidebarCategoryService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LJP
 * @Classname SidebarCategoryController
 * @Date: 2019-12-15 23:01
 * @Description:
 */
@Controller
@RequestMapping("/foreground/sidebar")
public class SidebarCategoryController {
    @Autowired
    private SidebarCategoryService sidebarCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVO sidebarCategoryList(){
        return ResponseVO.newBuilder().code("200").msg("获得侧边栏分类数据").data(sidebarCategoryService.getAll()).build();
    }

    @RequestMapping("/category/list")
    @ResponseBody
    public ResponseVO sidebarCategoryList(Integer levelNum, @RequestParam(value = "parentId", required = false, defaultValue = "0") Integer parentId){
        return ResponseVO.newBuilder().code("200").msg("根据分类层次和父层次id，获得侧边栏分类数据").data(sidebarCategoryService.getByLevel(levelNum, parentId)).build();
    }
}
