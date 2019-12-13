package com.nf.mall.controller.be;

import com.github.pagehelper.PageInfo;
import com.nf.mall.entity.CustomerLoginEntity;
import com.nf.mall.service.port.CustomerLoginService;
import com.nf.mall.vo.LoginPageSearchVO;
import com.nf.mall.vo.ResponseVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/login/count")
    @ResponseBody
    public ResponseVO loginCount(){
        return ResponseVO.newBuilder().code("200").msg("获取到用户总数量").data(customerLoginService.getCount()).build();
    }
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
}
