package com.nf.mall.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration registration  = registry.addResourceHandler("/static/**");
        registration.addResourceLocations("classpath:/static/login/hint/", "classpath:/static/login/assets/", "classpath:/static/");
    }

}
