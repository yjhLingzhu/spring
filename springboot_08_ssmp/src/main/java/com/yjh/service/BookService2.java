package com.yjh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yjh.domain.Book;

import java.util.List;

// 这种是自己写的业务层
// 其实MP（mybatis-plus）也帮我们做了业务层，提供了很多业务层的接口
// 后面的IBookService就是体验一下MP给我们写好了的业务层接口

public interface BookService2 {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Book book);
    Book getById(Integer id);
    List<Book> selectAll();
    IPage<Book> getPage(Integer currentPage, Integer pageSize);
}
