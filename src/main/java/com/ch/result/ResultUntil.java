package com.ch.result;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 返回数据统一处理
 * @author: 小小小阿曦
 * @Date: 2017/12/28
 * @Time: 7:09
 * To change this template use File | Settings | File Templates.
 */
public class ResultUntil {

    public static Result success(Object object){
        Result<Object> response = new Result<>();
        response.setCode(200);
        response.setMsg("success");
        response.setData(object);
        return response;
    }
    public static Result success(){
        return success(null);
    }
    public static Result error(Integer code, String msg){
        Result<Object> response = new Result<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
