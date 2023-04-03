package com.yjh.controller.utils;

// 作为springmvc的异常处理器

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 这两个一样的
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 这样写的话就会拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception e) {
        // 记录日志
        // 通知运维
        // 通知开发
        e.printStackTrace();
        return new R("服务器故障，请稍后重试。");
    }
}
