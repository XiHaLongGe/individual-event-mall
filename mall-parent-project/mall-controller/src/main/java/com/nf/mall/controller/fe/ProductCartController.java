package com.nf.mall.controller.fe;

import com.nf.mall.entity.ProductCartEntity;
import com.nf.mall.service.port.ProductCartService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/update")
    @ResponseBody
    public ResponseVO productCartUpdate(ProductCartEntity productCartEntity){
        System.out.println(productCartEntity);
        return ResponseVO.newBuilder().code("200").msg("根据商品id，修改数据").data(productCartService.productCartUpdate(productCartEntity)).build();
    }


}
