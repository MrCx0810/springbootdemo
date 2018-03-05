package com.ch.interceptor;

import com.ch.entity.Admin;
import com.ch.entity.Power;
import com.ch.services.interf.admin.AdminPublicInter;
import com.ch.services.interf.admin.PowerInter;
import com.ch.until.power.PowerUntil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * @Description: 管理员过滤器
 * @author: 小小小阿曦
 * @Date: 2017/12/25
 * @Time: 22:30
 * To change this template use File | Settings | File Templates.
 */

public class AdminInterceptor extends HandlerInterceptorAdapter {
    private final static Logger logger = Logger.getLogger(AdminInterceptor.class);

    @Autowired
    PowerInter powerInter;
    @Autowired
    AdminPublicInter adminPublicInter;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("**************后台拦截器，进入了**************");


        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        HttpSession session = request.getSession();
//        if(session.getAttribute("adminId")==null){
//            response.sendRedirect("../login");
//            return false;
//        }

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

        if(response.getStatus()==500){
            response.sendRedirect(request.getContextPath()+"/errors");
        }
        if (method.equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        }else {

            HttpSession session = request.getSession();
            Integer adminId = (Integer) session.getAttribute("adminId");
            Integer roleId = (Integer) session.getAttribute("roleId");
            if(adminId==null||roleId==null){
                response.sendRedirect(request.getContextPath()+"/admin/adminLogin");
                return false;
            }
            String url = request.getServletPath();
            List<Power> powers = powerInter.getPowerByRoleId(roleId);
            List<Power> resPowers = PowerUntil.getPowerData(powers,url);
            session.setAttribute("powers", resPowers);
            Admin admin = adminPublicInter.getAdminById(adminId);
            if(admin==null){
                response.sendRedirect(request.getContextPath()+"/admin/adminLogin");
                return false;
            }
            session.setAttribute("name", admin.getLoginName());
        }
        return true;
    }
}
