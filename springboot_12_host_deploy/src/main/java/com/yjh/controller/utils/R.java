package com.yjh.controller.utils;

import lombok.Data;

// 这个是为了统一返回数据写的类，和django中的自定义response一样
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;

    public R() {

    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
        this.msg = "success";
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    // 异常了才用的构造函数
    public R(String msg) {
        this.flag = false;
        this.msg = msg;
    }
}
