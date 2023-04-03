package com.yjh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yjh.domain.Book;

// 这是MP给我们写好的业务层IService，我们直接继承就行了，里面很多方法
// 我们在其基础上追加自己的业务就行

public interface IBookService extends IService<Book> {
    // 这里面还可以继续添加自己需要的业务接口
    public Boolean saveBook(Book book);
    public Boolean updateBook(Book book);
    public Boolean delete(Integer id);
    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
