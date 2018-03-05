package com.ch.result;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 定义返回数据类
 * @author: 小小小阿曦
 * @Date: 2017/12/28
 * @Time: 7:05
 * To change this template use File | Settings | File Templates.
 */
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
