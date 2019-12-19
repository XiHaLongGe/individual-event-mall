package com.nf.mall.controller.fe;

import com.nf.mall.service.port.LabelInfService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LJP
 * @Classname LabelInfServiceController
 * @Date: 2019-12-19 15:22
 * @Description:
 */
@Controller
@RequestMapping("/foreground/labelInf")
public class LabelInfController {
    @Autowired
    private LabelInfService labelInfService;
    @RequestMapping("/customerInfId/list")
    @ResponseBody
    public ResponseVO ReceivingInfList(Integer customerInfId){
        return ResponseVO.newBuilder().code("200").msg("根据用户Id，获得收货标签信息数据").data(labelInfService.labelInfByCustomerInfId(customerInfId)).build();
    }
}
