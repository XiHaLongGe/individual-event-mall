package com.nf.mall.controller.fe;

import com.github.pagehelper.PageInfo;
import com.nf.mall.entity.ProductOrderEntity;
import com.nf.mall.service.port.ProductOrderService;
import com.nf.mall.util.RandomCodeUtil;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductOrderController
 * @Date: 2019-12-20 23:56
 * @Description:
 */

@Controller
@RequestMapping("/foreground/product/order")
public class ProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;


    @RequestMapping("")
    public String home(String productOrderNumber, Model model){
        model.addAttribute("productOrderNumber", productOrderNumber);
        return "foreground/submitOrder";
    }

    @RequestMapping("/list")
    public String home(){
        return "foreground/orderInf";
    }

    @RequestMapping("/success/submit")
    public String successSubmit(String productOrderNumber, Model model){
        model.addAttribute("productOrderNumber", productOrderNumber);
        return "foreground/successOrder";
    }

    @RequestMapping("/customer/list")
    @ResponseBody
    public ResponseVO productOrderList(@RequestBody ProductOrderEntity productOrderEntity){
        return ResponseVO.newBuilder().code("200").msg("根据用户id查询订单表数据").data(productOrderService.getByCustomerId(productOrderEntity)).build();
    }

    @RequestMapping("/customer/page/list")
    @ResponseBody
    public ResponseVO productOrderPagList(Integer customerInfId, Integer pageNum, Integer pageSize){
        return ResponseVO.newBuilder().code("200").msg("根据用户id查询订单表数据,并返回分页后的数据").data(new PageInfo(productOrderService.getPageList(customerInfId, pageNum, pageSize))).build();
    }

    @RequestMapping("/productOrderNumber/list")
    @ResponseBody
    public ResponseVO productOrderList(String productOrderNumber, HttpServletRequest request){
        Integer customerInfId =  Integer.valueOf(request.getSession().getAttribute("customerInfId").toString());
        return ResponseVO.newBuilder().code("200").msg("根据订单编号查询订单表数据").data(productOrderService.getByProductOrderNumber(productOrderNumber, customerInfId)).build();
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseVO productOrderInsert(@RequestBody ProductOrderEntity productOrderEntity){
        String randomCode = RandomCodeUtil.randomGenerate(18);
        productOrderEntity.setProductOrderNumber(randomCode);
        randomCode = productOrderService.productOrderInsert(productOrderEntity) ? randomCode : "" ;
        return ResponseVO.newBuilder().code("200").msg("添加订单表数据").data(randomCode).build();
    }

    @RequestMapping("/batch/insert")
    @ResponseBody
    public ResponseVO productOrderBatchInsert(@RequestBody List<ProductOrderEntity> productOrderEntity){
        String productOrderNumber = "";
        productOrderNumber = RandomCodeUtil.randomGenerate(18);
        for (ProductOrderEntity orderEntity : productOrderEntity) {
            orderEntity.setProductOrderNumber(productOrderNumber);
        }
        /*订单添加成功返回订单编号 否则空字符串*/
        productOrderNumber = (productOrderService.productOrderBatchInsert(productOrderEntity)) ? productOrderNumber : "";
        return ResponseVO.newBuilder().code("200").msg("批量添加订单表数据").data(productOrderNumber).build();
    }

    @RequestMapping("/submit/update")
    @ResponseBody
    public ResponseVO submitOrderUpdate(@RequestBody ProductOrderEntity productOrderEntity){
        return ResponseVO.newBuilder().code("200").msg("提交订单对订单表数据进行修改").data(productOrderService.submitOrderUpdate(productOrderEntity)).build();
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseVO submitOrderDelete(@RequestBody ProductOrderEntity productOrderEntity){
        return ResponseVO.newBuilder().code("200").msg("删除订单表数据").data(productOrderService.submitOrderDelete(productOrderEntity)).build();
    }
}
