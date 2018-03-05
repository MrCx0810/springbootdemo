package com.ch.enums;

/**
 * Created by IntelliJ IDEA.
 * @Description: 消息码
 * @author: 小小小阿曦
 * @Date: 2017/12/28
 * @Time: 6:52
 * To change this template use File | Settings | File Templates.
 */
public enum ResultEnum {
    TYPE_EMPTY(400, "请传入登录类型"),
    TYPE_ERROR(400, "登录类型参数错误"),
    LOGINNAME_EMPTY ( 400, "请传入登录名参数"),
    USER_NOT_EXIST ( 400, "用户不存在"),
    PSW_ERROR ( 400, "密码错误"),
    ID_ERROR ( 400, "用户ID不合法"),
    USER_IS_EXIST ( 400, "该用户不存在"),
    TEL_EMPTY ( 400, "请输入手机号注册"),
    TEL_ERROR ( 400, "请输入合法的手机号"),
    NICENAME_ERROR ( 400, "请输入昵称"),
    PSW_NOT_EQUAL ( 400, "密码不一致"),
    USER_ALREADY_EXIST ( 400, "该登录名已存在"),
    ACCOUNT_DISABLE(400, "您的账号已被禁用,请联系管理员"),
    PSW_EMPTY ( 400, "请输入密码"),
    OLD_PSW_ERROR ( 400, "旧密码错误"),
    MD5_ERROR(400, "加密错误"),
    TOKEN_EMPTY(500, "请传入用户TOKEN值"),
    TOKEN_NOT_EXIST(500, "TOKEN错误"),
    TOKEN_INVALID(500, "TOKEN失效");



    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
