package com.nf.mall.controller.fe;

import com.nf.mall.service.port.BrandInfService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LJP
 * @Classname BrandInfController
 * @Date: 2019-12-15 21:43
 * @Description:
 */
@Controller
@RequestMapping("/foreground/brand")
public class BrandInfController {
    @Autowired
    private BrandInfService brandInfService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVO brandList(Integer categoryId){
        return ResponseVO.newBuilder().code("200").msg("根据品牌类型id，来获得品牌数据").data(brandInfService.getByListName(categoryId)).build();
    }
}
