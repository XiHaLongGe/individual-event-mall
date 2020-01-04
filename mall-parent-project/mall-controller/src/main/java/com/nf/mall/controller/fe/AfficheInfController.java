package com.nf.mall.controller.fe;

import com.nf.mall.service.port.AfficheInfService;
import com.nf.mall.vo.ResponseVO;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: LJP
 * @Classname AfficheInfController
 * @Date: 2019-12-15 21:44
 * @Description:
 */
@Controller
@RequestMapping("/foreground/affiche")
public class AfficheInfController {
    @Autowired
    private AfficheInfService afficheInfService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVO afficheList(){
        return ResponseVO.newBuilder().code("200").msg("右侧公告数据").data(afficheInfService.getAll()).build();
    }

}
