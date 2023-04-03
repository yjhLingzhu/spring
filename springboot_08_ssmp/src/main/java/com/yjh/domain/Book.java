package com.yjh.domain;

import lombok.Data;

// 按Ctrl+F12调出函数框
@Data   // 这个是除了没有覆盖构造方法，其他的都覆盖了，所以构造方法要另外写
public class Book {
    private Integer id;
    private String type;
    private String description;
    private String name;
}
