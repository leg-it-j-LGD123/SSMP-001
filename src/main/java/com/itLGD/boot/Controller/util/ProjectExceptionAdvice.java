package com.itLGD.boot.Controller.util;

import com.itLGD.boot.bean.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R DoException(Exception e){
        e.printStackTrace();
        return new R(false,null,"系统错误,稍后再试");
    }

}
