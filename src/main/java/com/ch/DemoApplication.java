package com.ch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2018/1/25
 * @Time: 1:10
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@EnableCaching
@EnableTransactionManagement
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
    * @Author:小小小阿曦
    * @Date: 2:09-2018/1/25
    * @Description: 外置tomcat 需要修改的启动方式
     * @Param null  param desc
    * @Return:
    */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }


}
