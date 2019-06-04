package com.hakurei.configuration;


import com.hakurei.interceptor.ProcessInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfiguration
 * @Description TODO
 * @Author hakurei
 * @Date 2019/4/16
 * @Version 1.0
 */
@Component
@Configuration


public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private ProcessInterceptor processInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(processInterceptor);


    }
}
