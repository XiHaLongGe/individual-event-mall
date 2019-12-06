package com.nf.mall.controller.foreground;

import com.nf.mall.service.port.AfficheInfService;
import com.nf.mall.service.port.BrandInfService;
import com.nf.mall.service.port.ProductCategoryService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/")
    public String home(){return "foreground/home";}

    @GetMapping("/category/list")
    @ResponseBody
    public ResponseVO category(){
        return ResponseVO.newBuilder().code("200").msg("分类列表数据").data(productCategoryService.getAll()).build();
    }

    @GetMapping("/category/spread")
    @ResponseBody
    public ResponseVO spread(Integer categoryId){
        return ResponseVO.newBuilder().code("200").msg("分类展开数据").data(brandInfService.getByListName(categoryId)).build();
    }

    @RequestMapping("/affiche/list")
    @ResponseBody
    public ResponseVO affiche(){
        return ResponseVO.newBuilder().code("200").msg("右侧公告数据").data(afficheInfService.getAll()).build();
    }
}
