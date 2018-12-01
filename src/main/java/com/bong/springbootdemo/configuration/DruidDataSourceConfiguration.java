package com.bong.springbootdemo.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.ResourceServlet;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dabing
 * @create 2018/11/14
 * @since 1.0.0
 */
@Configuration
public class DruidDataSourceConfiguration {

    /**
     * 配置druid数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置druid监控
     * 1. 配置后台管理的servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> statViewServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initMap = new HashMap<>();
        initMap.put(ResourceServlet.PARAM_NAME_USERNAME, "admin");
        initMap.put(ResourceServlet.PARAM_NAME_PASSWORD, "123456");
        statViewServletRegistrationBean.setInitParameters(initMap);
        return statViewServletRegistrationBean;
    }
    /**
     * 配置druid监控
     * 12. 配置web监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean WebStatFilter() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initMap = new HashMap<>();
        initMap.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(initMap);
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        return filterRegistrationBean;
    }
}
