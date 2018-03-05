package com.ch.interceptor;

import com.ch.services.interf.front.UserInterf;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * @Description: 用户过滤器
 * @author: 小小小阿曦
 * @Date: 2017/12/25
 * @Time: 22:29
 * To change this template use File | Settings | File Templates.
 */
public class UserInterceptor extends HandlerInterceptorAdapter {
    private final static Logger logger = Logger.getLogger(UserInterceptor.class);

    @Autowired
    UserInterf userInterf;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("**************拦截器，进入了**************");
        String method = request.getMethod();
        String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        response.addHeader("host", host);
        response.addHeader("Access-Control-Expose-Headers","Roleplay-Error-Code");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Headers",
                "Origin, Content-Type, Accept, Authorization, x-requested-with, cache-control, Access-Control-Allow-Origin, Access-Control-Allow-Credentials, uuid");

        logger.info(method);
        if (method.equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            String servletPath = request.getServletPath();
            logger.info(servletPath);
            String token = request.getParameter("token");

            /**
             * Token验证
             */
            userInterf.checkToken(token);
        }

        return true;
    }


}
