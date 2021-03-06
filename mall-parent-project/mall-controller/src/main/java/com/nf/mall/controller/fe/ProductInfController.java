package com.nf.mall.controller.fe;

import com.nf.mall.entity.ProductInfEntity;
import com.nf.mall.service.port.ProductInfService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductInfController
 * @Date: 2019-12-15 21:34
 * @Description:
 */
@Controller
@RequestMapping("/foreground/product")
public class ProductInfController {
    @Autowired
    private ProductInfService productInfService;

    @RequestMapping("")
    public String home(Integer productId, Model model){
        model.addAttribute("productId", productId);
        return "foreground/productInfList";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVO productList(Integer productId){
        return ResponseVO.newBuilder().code("200").msg("根据商品id获得商品表数据").data(productInfService.getById(productId)).build();
    }


    @RequestMapping("/hot/sale/list")
    @ResponseBody
    public ResponseVO productList(){
        return ResponseVO.newBuilder().code("200").msg("获得热销商品表数据").data(productInfService.getHotProduct()).build();
    }

    @RequestMapping("/sidebar/category/list")
    @ResponseBody
    public ResponseVO sidebarCategoryProductList(Integer sidebarCategoryId){
        return ResponseVO.newBuilder().code("200").msg("根据商品信息中的侧边分类栏ID，获得商品表数据").data(productInfService.getBySidebarCategoryId(sidebarCategoryId)).build();
    }


}
