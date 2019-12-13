package com.nf.mall.controller.fe;

import com.nf.mall.service.port.*;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LJP
 * @Classname HomeListController
 * @Date: 2019-12-05 09:54
 * @Description:
 */
@Controller
@RequestMapping("/foreground/home")
public class FeHomeController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private BrandInfService brandInfService;
    @Autowired
    private AfficheInfService afficheInfService;
    @Autowired
    private PictureInfService pictureInfService;
    @Autowired
    private ProductInfService productInfService;
    @Autowired
    private PictureTypeService pictureTypeService;

    @RequestMapping("/")
    public String home(){return "foreground/home";}

    @RequestMapping("/category/level/list")
    @ResponseBody
    public ResponseVO categoryLevel(Integer levelNum, @RequestParam(value = "parentId", required = false, defaultValue = "0") Integer parentId){
        return ResponseVO.newBuilder().code("200").msg("根据分类层次id，获得分类层次列表数据").data(productCategoryService.getByLevel(levelNum, parentId)).build();
    }

    @RequestMapping("/category/spread")
    @ResponseBody
    public ResponseVO spread(Integer categoryId){
        return ResponseVO.newBuilder().code("200").msg("分类展开数据").data(brandInfService.getByListName(categoryId)).build();
    }

    @RequestMapping("/affiche/list")
    @ResponseBody
    public ResponseVO affiche(){
        return ResponseVO.newBuilder().code("200").msg("右侧公告数据").data(afficheInfService.getAll()).build();
    }

    @RequestMapping("/picture/push/list")
    @ResponseBody
    public ResponseVO pushPicture(Integer pictureTypeId){
        return ResponseVO.newBuilder().code("200").msg("根据图片类型id，获得图片列表数据").data(pictureInfService.getByType(pictureTypeId)).build();
    }

    @RequestMapping("/picTypeId/proCategoryId/product")
    @ResponseBody
    public ResponseVO picTypeIdCategoryIdProduct(@RequestParam(value = "picTypeId", required = false, defaultValue = "4") Integer picTypeId, Integer proCategoryId){
        return ResponseVO.newBuilder().code("200").msg("根据图片类型和商品类型，获得商品列表数据").data(productInfService.getCategorySale(picTypeId, proCategoryId)).build();
    }
}
