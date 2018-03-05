package com.ch.services.interf.front;

import com.ch.entity.UserToken;
import com.ch.result.Result;

import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * @Description: 用户管理接口
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
public interface UserInterf {
    /**
    * @Author:小小小阿曦
    * @Date: 15:26-2017/12/22
    * @Description: 通过id获取用户信息
     * @Param id  用户id
    * @Return: UserResponse
    */
    Result getUserById(int id) throws Exception;

    /**
    * @Author:小小小阿曦
    * @Date: 15:28-2017/12/22
    * @Description: 根据用户登录名获取用户信息
     * @Param name  登录名（可以是：登录名、wxOpenId、qqOpenId）
     * @Param passWord  密码
     * @Param type  登录类型
    * @Return: UserResponse
    */
    Result getUserByLoginType(String name, String passWord, Integer type, String headUrl, String nickName, HttpSession session) throws Exception;

    /**
    * @Author:小小小阿曦
    * @Date: 16:11-2017/12/24
    * @Description: 用户注册
     * @Param tel  手机号
     * @Param passWord  密码
     * @Param confirmPassWord  确认密码
    * @Return: UserResponse
    */
    Result addUser(String tel, String NiceName, String passWord, String confirmPassWord) throws Exception;

    /**
    * @Author:小小小阿曦
    * @Date: 13:22-2018/1/1
    * @Description: TOKEN 验证
    * @Param token  用户Token
    * @Return:
    */
    void checkToken(String token) throws Exception;
    /**
    * @Author:小小小阿曦
    * @Date: 10:47-2018/1/23
    * @Description: 获取用户TOKEN
     * @Param null  param desc
    * @Return:
    */
    UserToken getUserToken(String token);

}
