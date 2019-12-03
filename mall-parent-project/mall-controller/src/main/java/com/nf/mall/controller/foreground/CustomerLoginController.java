package com.nf.mall.controller.foreground;

import com.nf.mall.entity.CustomerLoginEntity;
import com.nf.mall.service.port.CustomerLoginService;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LJP
 * @Classname CustomerLoginController
 * @Date: 2019-12-02 08:23
 * @Description:
 */
@Controller
@RequestMapping("/foreground/customer/login")
public class CustomerLoginController {
    @Autowired
    private CustomerLoginService service;
    /**
     * 访问登录界面
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "foreground/login/index";
    }
    @RequestMapping("/verify")
    @ResponseBody
    public ResponseVO verify(@RequestBody CustomerLoginEntity entity){
        return service.verify(entity.getLoginAccount(), entity.getLoginPassword()) ?
                ResponseVO.newBuilder().code("200").msg("登录成功").data(true).build() :
                ResponseVO.newBuilder().code("400").msg("登录失败").data(false).build();
    }
    @RequestMapping("/register")
    @ResponseBody
    public ResponseVO register(@RequestBody CustomerLoginEntity entity){

        return ResponseVO.newBuilder().build();
    }
}
