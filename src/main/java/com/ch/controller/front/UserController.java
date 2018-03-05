package com.ch.controller.front;

import com.ch.services.interf.front.UserInterf;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * @Description: 用户管理模块
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 15:30
 * To change this template use File | Settings | File Templates.
 */

@Api(value="用户管理controller",tags={"用户操作接口"})
@RestController
public class UserController {
    @Autowired
    UserInterf userInterf;

    /**
     * @Author:小小小阿曦
     * @Date: 15:35-2017/12/22
     * @Description: 用户登录
     * @Param loginName  param desc
     * @Return: java.lang.Object
     */
    @ApiOperation(value="用户登录", notes="根据不同的登录类type来判断登录方式 type:1 普通登录 2：QQ登录 3：微信登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "loginName", value = "用户 登录名 或 wxOpenId 或 qqOpenId", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "用户密码",  required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "loginType", value = "登录类型", required = true, dataType = "Long"),
            @ApiImplicitParam(paramType = "query", name = "headUrl", value = "微信头像",  dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "nickName", value = "微信昵称",  dataType = "String"),
    })
//
    @PostMapping(value = "/login")
    Object login(@RequestParam("loginName") String loginName, @RequestParam("password") String password, @RequestParam("loginType") Long loginType,
                 HttpServletResponse response, HttpServletRequest request, HttpSession session) throws Exception {
        String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        response.addHeader("host", host);
        response.addHeader("Access-Control-Expose-Headers","Roleplay-Error-Code");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Headers",
                "Origin, Content-Type, Accept, Authorization, x-requested-with, cache-control, Access-Control-Allow-Origin, Access-Control-Allow-Credentials, uuid");
        return   userInterf.getUserByLoginType(loginName, password, loginType.intValue(), null, null, session);
    }
    /**
     * @Author:小小小阿曦
     * @Date: 15:35-2017/12/22
     * @Description: 用户微信登录
     * @Param loginName  param desc
     * @Return: java.lang.Object
     */
    @ApiOperation(value="用户微信登录", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "loginName", value = "用户 登录名 或 wxOpenId 或 qqOpenId", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "loginType", value = "登录类型", required = true, dataType = "Long"),
            @ApiImplicitParam(paramType = "query", name = "headUrl", value = "微信头像", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "nickName", value = "微信昵称", required = true, dataType = "String"),
    })
    @PostMapping(value = "/wxLogin")
    Object wxLogin(@RequestParam("loginName") String loginName, @RequestParam("loginType") Long loginType, @RequestParam("headUrl") String headUrl, @RequestParam("nickName") String nickName,
                   HttpServletResponse response, HttpServletRequest request, HttpSession session) throws Exception {
        System.out.println("loginName = " + loginName);
        System.out.println("loginType = " + loginType);
        System.out.println("headUrl = " + headUrl);
        System.out.println("nickName = " + nickName);
        String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        response.addHeader("host", host);
        response.addHeader("Access-Control-Expose-Headers","Roleplay-Error-Code");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Headers",
                "Origin, Content-Type, Accept, Authorization, x-requested-with, cache-control, Access-Control-Allow-Origin, Access-Control-Allow-Credentials, uuid");
        return   userInterf.getUserByLoginType(loginName, null, loginType.intValue(), headUrl, nickName, session);
    }
    /**
     * @Author:小小小阿曦
     * @Date: 15:35-2017/12/22
     * @Description: 用户注册
     * @Param loginName  param desc
     * @Return: java.lang.Object
     */
    @ApiOperation(value="用户注册", notes="使用手机号注册")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "tel", value = "手机号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "niceName", value = "昵称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "repeatPassword", value = "确认密码", required = true, dataType = "String")
    })
    @PostMapping(value = "/reg")
    Object reg(@RequestParam("tel") String tel, @RequestParam("niceName") String niceName, @RequestParam("password") String password, @RequestParam("repeatPassword") String repeatPassword, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        response.addHeader("host", host);
        response.addHeader("Access-Control-Expose-Headers","Roleplay-Error-Code");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Headers",
                "Origin, Content-Type, Accept, Authorization, x-requested-with, cache-control, Access-Control-Allow-Origin, Access-Control-Allow-Credentials, uuid");
        return userInterf.addUser(tel, niceName, password, repeatPassword);
    }

}
