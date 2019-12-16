package com.nf.mall.controller.fe;

import com.nf.mall.service.port.ProductCategoryService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LJP
 * @Classname ProductCategoryController
 * @Date: 2019-12-15 21:42
 * @Description:
 */
@Controller
@RequestMapping("/foreground/product/category")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVO productList(Integer levelNum, @RequestParam(value = "parentId", required = false, defaultValue = "0") Integer parentId){
        return ResponseVO.newBuilder().code("200").msg("根据分类层次id，获得分类层次列表数据").data(productCategoryService.getByLevel(levelNum, parentId)).build();
    }
}
