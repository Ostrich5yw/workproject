package com.example.workproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler(mappingUrl + "/**").addResourceLocations("file:" + uploadUrl + File.separator);
        //阿里云(映射路径去除盘符)
        registry.addResourceHandler("/D/**").addResourceLocations("file:///D:/");
        registry.addResourceHandler("/**").addResourceLocations("file:///D:/AllProject/JavaProjects/workproject/src/main/resources/static/");
        super.addResourceHandlers(registry);
    }
}

