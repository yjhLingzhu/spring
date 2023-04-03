package com.yjh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yjh.domain.Book;
import com.yjh.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {
    // 这个是测试MP给我们弄的业务层接口，因为
    @Autowired
    private BookServiceImpl bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(1));
    }

    @Test
    void testSave() {    // 增
        Book book = new Book();
        book.setType("计算机导论");
        book.setName("C++进阶之路");
        book.setDescription("让你从此不走弯路，平步青云扶摇直上");
        System.out.println(bookService.save(book));;
    }

    @Test
    void testUpdate() {     // 改
        Book book = new Book();
        book.setId(28);
        book.setName("C++进阶之路9999");
        System.out.println(bookService.updateById(book));;
    }

    @Test
    void testDelete() {     // 删
        Book book = new Book();
        book.setId(28);
        System.out.println(bookService.removeById(book));;
    }

    // 条件查询
    @Test
    void testSelectAll() {
        List<Book> books = bookService.list();
        System.out.println(books);
    }

    // 分页
    @Test
    void testGetPage() {
        // 分页是拦截器做的
        IPage<Book> page = new Page<Book>(2, 5);
        bookService.page(page);
        long total = page.getTotal();   // 共多少条数据
        long pages = page.getPages();   // 共多少页
        long current = page.getCurrent();   // 当前那一页
        List<Book> records = page.getRecords();// 当前页查出来的数据
        System.out.println("total:" + total);
        System.out.println("pages:" + pages);
        System.out.println("current:" + current);
        System.out.println("records:" + records);
    }
}
