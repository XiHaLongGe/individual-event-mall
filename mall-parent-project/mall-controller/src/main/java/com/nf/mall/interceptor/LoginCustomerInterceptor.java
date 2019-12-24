package com.nf.mall.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: LJP
 * @Classname LoginCustomerInterceptor
 * @Date: 2019-12-22 13:21
 * @Description:
 */
public class LoginCustomerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object loginName = session.getAttribute("loginName");
        if(loginName != null && !loginName.toString().isEmpty()){
            return true;
        }else{
            request.getRequestDispatcher("/customer/login/index").forward(request, response);
        }
        return false;
    }
}
