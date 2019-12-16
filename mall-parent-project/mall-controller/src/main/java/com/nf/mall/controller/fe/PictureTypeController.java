package com.nf.mall.controller.fe;

import com.nf.mall.service.port.PictureInfService;
import com.nf.mall.service.port.ProductInfService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LJP
 * @Classname PictureTypeController
 * @Date: 2019-12-15 21:33
 * @Description:
 */
@Controller
@RequestMapping("/foreground/picture")
public class PictureTypeController {
    @Autowired
    private PictureInfService pictureInfService;

    @RequestMapping("/type/list")
    @ResponseBody
    public ResponseVO pictureList(Integer pictureTypeId){
        return ResponseVO.newBuilder().code("200").msg("根据图片类型id，获得图片表数据").data(pictureInfService.getByType(pictureTypeId)).build();
    }

    @RequestMapping("/type/main/list")
    @ResponseBody
    public ResponseVO pictureList(Integer pictureTypeId, Integer productId){
        return ResponseVO.newBuilder().code("200").msg("根据图片类型id和商品id，获得图片表数据").data(pictureInfService.getByTypeAndPro(pictureTypeId, productId)).build();
    }

}
