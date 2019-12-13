package com.nf.mall.controller.be;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: LJP
 * @Classname HomeController
 * @Date: 2019-12-11 14:50
 * @Description:
 */
@Controller
@RequestMapping("/backend/home")
public class BeHomeController {
    @RequestMapping("/")
    public String home(){return "backend/home";}
    @RequestMapping("/member/list")
    public String memberList(){return "backend/home/customer-login-list";}
    @RequestMapping("/member/add")
    public String memberAdd(){
        return "backend/home/member-add";
    }
}
