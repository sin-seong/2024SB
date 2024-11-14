package com.sin.sb1101.util;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<JwtAuthFilter> JwtAuthFilter(){
        FilterRegistrationBean<JwtAuthFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new JwtAuthFilter());

        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;

    }
}
