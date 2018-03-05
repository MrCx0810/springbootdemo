package com.ch;

import com.ch.interceptor.AdminInterceptor;
import com.ch.interceptor.UserInterceptor;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by IntelliJ IDEA.
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/26
 * @Time: 10:25
 * To change this template use File | Settings | File Templates.
 */

@Configuration
public class AppWebMvcConfigurer extends WebMvcConfigurerAdapter {
    private final static Logger logger = Logger.getLogger(AppWebMvcConfigurer.class);

    @Bean
    public UserInterceptor userInterceptor(){
        return new UserInterceptor();
    }
    @Bean
    public AdminInterceptor adminInterceptor(){
        return new AdminInterceptor();
    }




    /**
     * 配置过滤器启动
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//         addPathPatterns 用于添加拦截规则
//         excludePathPatterns 用户排除拦截
        registry.addInterceptor(userInterceptor()).addPathPatterns("/user/**");
        registry.addInterceptor(adminInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin/adminLogin","/reg","/login");
        super.addInterceptors(registry);

    }
    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }


















// logger.info("**********进入,拦截器*********");

//    /**
//     * 跨域设置
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean corsFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(corsFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("corsFilter");
//        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return registration;
//    }
//
//    /**
//     * 跨域过滤器
//     * @return
//     */
//    @Bean
//    public Filter corsFilter() {
//        return new CorsFilter();
//    }


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static").addResourceLocations("classpath:/static");
//        //registry.addResourceHandler("*.css").addResourceLocations("classpath:/static/css/");
//    }
}
