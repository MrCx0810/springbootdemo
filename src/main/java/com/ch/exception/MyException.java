package com.ch.exception;

import com.ch.enums.ResultEnum;

/**
 * 
 * @author JayZhou
 *
 */
public class MyException extends RuntimeException{
    private Integer code;

    public MyException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code =resultEnum.getCode();
    }
    public MyException(String msg){
        super(msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
