package com.nf.mall.controller.fe;

import com.nf.mall.entity.CustomerInfEntity;
import com.nf.mall.entity.CustomerLoginEntity;
import com.nf.mall.service.port.CustomerLoginService;
import com.nf.mall.util.RandomCodeUtil;
import com.nf.mall.util.Md5Util;
import com.nf.mall.vo.RegisterVO;
import com.nf.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Contended;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author: LJP
 * @Classname CustomerLoginController
 * @Date: 2019-12-02 08:23
 * @Description:
 */
@Controller
@RequestMapping("/customer/login")
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
    @PostMapping("/verify")
    @ResponseBody
    public ResponseVO verify(@RequestBody CustomerLoginEntity entity, HttpServletRequest request){
        HttpSession session = request.getSession();
        boolean yn = service.verify(entity);
        if(yn){
            CustomerLoginEntity customerLoginEntity = service.getByAccount(entity.getLoginAccount());
            session.setAttribute("loginName", customerLoginEntity.getLoginName());
            session.setAttribute("customerInfId", customerLoginEntity.getCustomerInfId());
        }
        return yn ?
                ResponseVO.newBuilder().code("200").msg("登录成功").data(true).build() :
                ResponseVO.newBuilder().code("400").msg("登录失败").data(false).build();
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("loginName", "");
        session.setAttribute("customerInfId", "");
        return "redirect:/customer/login/index";
    }


    @PostMapping("/register")
    @ResponseBody
    public ResponseVO register(@RequestBody RegisterVO registerVO){
        /**
         * 将密码进行Md5加密
         */
        String password = Md5Util.encodeByMd5(registerVO.getLoginPassword());
        /**
         * RandomCodeUtil.randomGenerate(11) : 获取到一个11位的随机账号
         */
        CustomerLoginEntity customerLoginEntity = CustomerLoginEntity.newBuilder().loginAccount(RandomCodeUtil.randomGenerate(11)).loginName(registerVO.getLoginName()).loginPassword(password).creationTime(new Date()).build();
        CustomerInfEntity customerInfEntity = CustomerInfEntity.newBuilder().customerInfPhone(registerVO.getCustomerPhone()).customerInfEmail(registerVO.getCustomerEmail()).build();
        return service.register(customerLoginEntity, customerInfEntity) ?
                ResponseVO.newBuilder().code("200").msg("注册成功").data(true).build():
                ResponseVO.newBuilder().code("400").msg("注册失败").data(false).build();
    }
    @GetMapping("/activate")
    public ModelAndView activate(String code){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("foreground/login/activate");
        modelAndView.addObject("activate",service.activate(code));
        return modelAndView;
    }
}
