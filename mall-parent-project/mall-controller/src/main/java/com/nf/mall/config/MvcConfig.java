package com.nf.mall.config;

import com.nf.mall.interceptor.EncodingInterceptor;
import com.nf.mall.interceptor.LoginCustomerInterceptor;
import org.springframework.context.annotation.*;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Author: LJP
 * @Classname MvcConfig
 * @Date: 2019-12-02 10:05
 * @Description:
 */
@Configuration
@ComponentScan("com.nf.mall.controller")
@EnableWebMvc
@Import(AppConfig.class)
public class MvcConfig implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB-INF/");
        return viewResolver;
    }

    /**
     * 添加自己创建的拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new EncodingInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoginCustomerInterceptor()).addPathPatterns("/foreground/**", "/backend/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration registration  = registry.addResourceHandler("/static/**");
        String [] resourceLocations = new String [] {
                "classpath:/static/",
                "classpath:/static/toosTips/",
                "classpath:/static/home/",
                "classpath:/static/home/product-inf-list/",
                "classpath:/static/home/shopping-cart/",
                "classpath:/static/home/submit-order/",
                "classpath:/static/login/assets/",
                "classpath:/static/backend/home/"
        };
        registration.addResourceLocations(resourceLocations);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/foreground/product/hot/sale/list");
    }*/
}
