package com.nf.mall.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.mall.entity.CustomerLoginEntity;
import com.nf.mall.service.port.CustomerLoginService;
import com.nf.mall.vo.LoginPageSearchVO;
import com.nf.mall.vo.ResponseVO;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: LJP
 * @Classname CustomerController
 * @Date: 2019-12-11 20:06
 * @Description:
 */
@Controller
@RequestMapping("/backend/customer")
public class CustomerController {
    @Autowired
    private CustomerLoginService customerLoginService;
    @Autowired

    @RequestMapping("/login/list")
    @ResponseBody
    public ResponseVO loginList(){
        return ResponseVO.newBuilder().code("200").msg("获取到用户对象的列表").data(customerLoginService.getAll()).build();
    }

    @RequestMapping("/login/page/list")
    @ResponseBody
    public ResponseVO loginPageList(@RequestParam(value = "pageNum", required = false, defaultValue = "1")Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        PageInfo pageInfo = new PageInfo(customerLoginService.getPageAll(pageNum, pageSize), 7);
        return ResponseVO.newBuilder().code("200").msg("获取到用户对象的分页列表").data(pageInfo).build();
    }

    @RequestMapping("/login/page/search")
    @ResponseBody
    public ResponseVO loginPageSearch(@RequestBody LoginPageSearchVO loginPageSearchVO, @RequestParam(value = "pageNum", required = false, defaultValue = "1")Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize){
        String startTime = loginPageSearchVO.getStartTime();
        String endTime = loginPageSearchVO.getEndTime();
        String loginName = loginPageSearchVO.getLoginName();
        PageInfo pageInfo = new PageInfo(customerLoginService.getPageSearch(startTime, endTime, loginName, pageNum, pageSize));
        return ResponseVO.newBuilder().code("200").msg("根据条件查询，获取到用户对象的分页列表").data(pageInfo).build();
    }

    @RequestMapping("/login/edit")
    public String customerLoginEdit(Integer id, Model model){
        model.addAttribute("customerLoginEntity", customerLoginService.getById(id));
        return "backend/home/customer-login-edit";
    }

    @RequestMapping("/login/edit/password")
    public String updatePassWord(Integer id, Model model){
        model.addAttribute("customerLoginEntity", customerLoginService.getById(id));
        return "backend/home/customer-login-edit-password";
    }

    @RequestMapping("/login/add")
    public String customerLoginAdd(){
        return "backend/home/customer-login-add";
    }

    @PostMapping("/login/delete")
    @ResponseBody
    public ResponseVO delete(@RequestBody LoginPageSearchVO loginPageSearchVO){
        return ResponseVO.newBuilder().code("200").msg("删除用户账号信息").data(customerLoginService.delete(loginPageSearchVO.getId())).build();
    }

    @PostMapping("/login/batch/delete")
    @ResponseBody
    public ResponseVO delete(@RequestBody String [] batchId){
        Integer [] batchIds = new Integer[batchId.length];
        for (int i = 0; i < batchId.length; i++) {
            batchIds[i] = Integer.valueOf(batchId[i]);
        }
        return ResponseVO.newBuilder().code("200").msg("批量删除用户账号信息").data(customerLoginService.batchDelete(batchIds)).build();
    }

    @PostMapping("/login/update")
    @ResponseBody
    public ResponseVO update(@RequestBody CustomerLoginEntity customerLoginEntity){
        return ResponseVO.newBuilder().code("200").msg("修改用户账号信息").data(customerLoginService.update(customerLoginEntity)).build();
    }

    @PostMapping("/login/update/password")
    @ResponseBody
    public ResponseVO updatePassWord(@RequestBody CustomerLoginEntity customerLoginEntity){
        return ResponseVO.newBuilder().code("200").msg("修改用户密码信息").data(customerLoginService.updatePassWord(customerLoginEntity)).build();
    }

    @PostMapping("/login/update/state")
    @ResponseBody
    public ResponseVO updateState(@RequestBody LoginPageSearchVO loginPageSearchVO){
        Integer id = loginPageSearchVO.getId();
        Integer state = loginPageSearchVO.getState();
        return ResponseVO.newBuilder().code("200").msg("根据id修改用户账号状态").data(customerLoginService.updateState(id,state)).build();
    }
}
