package com.ch.handle;

import com.ch.exception.MyException;
import com.ch.result.Result;
import com.ch.result.ResultUntil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 *
 * @Description: 异常捕获
 * @author: 小小小阿曦
 * @Date: 2017/12/28
 * @Time: 7:48
 * To change this template use File | Settings | File Templates.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = Logger.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            return ResultUntil.error(myException.getCode(), myException.getMessage());
        }else{
            logger.error("【系统错误】 {}", e);
            return ResultUntil.error(-1,e.getMessage());

        }
    }
}
