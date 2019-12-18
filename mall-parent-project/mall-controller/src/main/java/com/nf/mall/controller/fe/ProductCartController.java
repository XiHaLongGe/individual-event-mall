package com.nf.mall.controller.fe;

import com.nf.mall.entity.ProductCartEntity;
import com.nf.mall.service.port.ProductCartService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LJP
 * @Classname ProductCartController
 * @Date: 2019-12-17 10:31
 * @Description:
 */
@Controller
@RequestMapping("/foreground/product/cart")
public class ProductCartController {
    @Autowired
    private ProductCartService productCartService;

    @RequestMapping("")
    public String home(Integer customerInfId, Model model){
        model.addAttribute("customerInfId", customerInfId);
        return "foreground/shoppingCart";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVO productCartList(Integer customerInfId){
        return ResponseVO.newBuilder().code("200").msg("根据用户id，获得购物车表数据").data(productCartService.getById(customerInfId)).build();
    }

    @RequestMapping("/count")
    @ResponseBody
    public ResponseVO productCartCount(Integer customerInfId){
        return ResponseVO.newBuilder().code("200").msg("根据用户id，获得该用户的购物车里商品的数量").data(productCartService.productCartCount(customerInfId)).build();
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseVO productCartUpdate(@RequestBody ProductCartEntity productCartEntity){
        return ResponseVO.newBuilder().code("200").msg("根据商品id和用户id，修改数据").data(productCartService.productCartUpdate(productCartEntity)).build();
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseVO productCartDelete(@RequestBody ProductCartEntity productCartEntity){
        return ResponseVO.newBuilder().code("200").msg("根据商品id和用户id，删除数据").data(productCartService.productCartDelete(productCartEntity)).build();
    }

    @PostMapping("/insert")
    @ResponseBody
    public ResponseVO productCartInsert(@RequestBody ProductCartEntity productCartEntity){
        return ResponseVO.newBuilder().code("200").msg("根据商品id和用户id，添加数据").data(productCartService.productCartInsert(productCartEntity)).build();
    }

}
