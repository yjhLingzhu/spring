package com.yjh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yjh.domain.Book;
import com.yjh.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 表现层(控制层)  表现层调业务层，业务层调数据层

//@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }

    // @RequestBody 是从请求体中获取数据（json），它里面的字段和
    // Book的字段对应，这样实现自动匹配。这个请求体是postman中的raw
    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    // PathVariable说明参数是从路径中自动匹配来
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }

    // PathVariable说明参数是从路径中自动匹配来
    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    // 分页
    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        return bookService.getPage(currentPage, pageSize, book);
    }
}
