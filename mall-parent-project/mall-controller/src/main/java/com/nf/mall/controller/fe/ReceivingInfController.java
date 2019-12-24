package com.nf.mall.controller.fe;

import com.nf.mall.entity.ReceivingInfEntity;
import com.nf.mall.service.port.ReceivingInfService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LJP
 * @Classname ReceivingInfController
 * @Date: 2019-12-19 08:48
 * @Description:
 */

@Controller
@RequestMapping("/foreground/receivingInf")
public class ReceivingInfController {
    @Autowired
    private ReceivingInfService receivingInfService;

    @RequestMapping("")
    public String home(){
        return "foreground/submitOrder";
    }

    @RequestMapping("/customerInfId/list")
    @ResponseBody
    public ResponseVO customerInfIdList(Integer customerInfId){
        return ResponseVO.newBuilder().code("200").msg("根据用户Id，获得收货信息数据").data(receivingInfService.getByCustomerInfId(customerInfId)).build();
    }

    @RequestMapping("/receivingInfId/list")
    @ResponseBody
    public ResponseVO receivingInfIdList(@RequestBody ReceivingInfEntity receivingInfEntity){
        return ResponseVO.newBuilder().code("200").msg("根据收货信息Id，获得收货信息数据 用于修改").data(receivingInfService.getByReceivingInfId(receivingInfEntity.getReceivingInfId())).build();
    }

    @PostMapping("/insert")
    @ResponseBody
    public ResponseVO ReceivingInfInsert(@RequestBody ReceivingInfEntity receivingInfEntity){
        return ResponseVO.newBuilder().code("200").msg("添加收货信息数据").data(receivingInfService.receivingInfInsert(receivingInfEntity)).build();
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseVO ReceivingInfDelete(@RequestBody ReceivingInfEntity receivingInfEntity){
        return ResponseVO.newBuilder().code("200").msg("删除收货信息数据").data(receivingInfService.receivingInfDelete(receivingInfEntity)).build();
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseVO ReceivingInfUpdate(@RequestBody ReceivingInfEntity receivingInfEntity){
        return ResponseVO.newBuilder().code("200").msg("修改收货信息数据").data(receivingInfService.receivingInfUpdate(receivingInfEntity)).build();
    }
}
