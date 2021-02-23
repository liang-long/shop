package cn.kgc.product.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Tiler on 2020/5/22
 */
//配置类，用于替代xml文件配置方式
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    //LoginInterceptor的创建托管给spring，否则对象中的注解不起作用
    @Bean
    public LoginInterceptor newInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求
        registry.addInterceptor(newInterceptor()).addPathPatterns("/**");
    }
}
