package com.example.jingtao.config;

import com.example.jingtao.intereptor.MyIntereptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebIntereptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyIntereptor()).addPathPatterns("/**").excludePathPatterns("/login", "/notlogin", "/post/getImg", "/news/addASchoolNews", "/favicon.ico", "/news/getImg");
    }
}
