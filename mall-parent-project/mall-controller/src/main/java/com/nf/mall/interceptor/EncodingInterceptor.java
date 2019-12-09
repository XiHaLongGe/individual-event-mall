package com.nf.mall.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: LJP
 * @Classname EncodingInterceptor
 * @Date: 2019-12-06 22:12
 * @Description:
 */
public class EncodingInterceptor implements HandlerInterceptor {
    private final String ENCODING = "UTF-8";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("字符拦截器");
        System.out.println("diyici-=-=-=-=-=" + request.getCharacterEncoding());
        request.setCharacterEncoding(ENCODING);
        System.out.println("dierci-=-=-=-=-=" + request.getCharacterEncoding());
        response.setContentType("text/html;charset=" + ENCODING);
        return true;
    }
}
