package com.nf.mall.controller.foreground;

import com.nf.mall.service.port.*;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LJP
 * @Classname HomeListController
 * @Date: 2019-12-05 09:54
 * @Description:
 */
@Controller
@RequestMapping("/foreground/home")
public class HomeController {
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

    @RequestMapping("/category/list")
    @ResponseBody
    public ResponseVO category(Integer levelNum){
        return ResponseVO.newBuilder().code("200").msg("根据分类层次id，获得分类列表数据").data(productCategoryService.getByLevel(levelNum)).build();
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

    @RequestMapping("/category/product")
    @ResponseBody
    public ResponseVO categoryProduct(Integer categoryId, String categoryName, Integer pictureTypeId, String pictureTypeName){
        categoryId = categoryName == null || categoryName.isEmpty() ? categoryId : productCategoryService.getByName(categoryName).getCategoryId();
        pictureTypeId = pictureTypeName == null || pictureTypeName.isEmpty() ? pictureTypeId : pictureTypeService.getByName(pictureTypeName).getPictureTypeId();
        return ResponseVO.newBuilder().code("200").msg("根据分类类型id，获得商品列表数据").data(productInfService.getHotSale(pictureTypeId, categoryId)).build();
    }
}
