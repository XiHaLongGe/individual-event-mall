package com.nf.mall.controller.fe;

import com.nf.mall.service.port.*;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LJP
 * @Classname HomeListController
 * @Date: 2019-12-05 09:54
 * @Description:
 */
@Controller
@RequestMapping("/foreground/home")
public class FeHomeController {
    @RequestMapping("/")
    public String home(){return "foreground/home";}
}
