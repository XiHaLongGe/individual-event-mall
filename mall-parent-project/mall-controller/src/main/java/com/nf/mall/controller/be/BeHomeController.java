package com.nf.mall.controller.be;

import com.nf.mall.service.port.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("/customer/login/list")
    public String customerLoginEList(){return "backend/home/customer-login-list";}
    @RequestMapping("/customer/login/add")
    public String customerLoginEAdd(){
        return "backend/home/customer-login-add";
    }
}
