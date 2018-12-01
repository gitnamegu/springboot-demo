package com.bong.springbootdemo.configuration;

import com.bong.springbootdemo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author dabing
 * @create 2018/11/12
 * @since 1.0.0
 */
@Configuration
public class MvcExtendConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
    }
}
