package com.yjh.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yjh.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {    // 查
//        System.out.println(bookDao.getById(1));   // 这是用的自己写的方法
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testAdd() {    // 增
        Book book = new Book();
        book.setType("计算机导论");
        book.setName("C++进阶之路");
        book.setDescription("让你从此不走弯路，平步青云扶摇直上");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {     // 改
        Book book = new Book();
        book.setId(2);
        book.setName("C++进阶之路666");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {     // 删
        Book book = new Book();
        book.setId(2);
        bookDao.deleteById(book);
    }

    // 分页
    @Test
    void testGetPage() {
        // 分页是拦截器做的
        IPage<Book> page = new Page<>(2, 5);
        bookDao.selectPage(page, null);
        long total = page.getTotal();   // 共多少条数据
        long pages = page.getPages();   // 共多少页
        long current = page.getCurrent();   // 当前那一页
        List<Book> records = page.getRecords();// 当前页查出来的数据
        System.out.println("total:" + total);
        System.out.println("pages:" + pages);
        System.out.println("current:" + current);
        System.out.println("records:" + records);
    }

    // 条件查询
    @Test
    void testGetByQuery() {
        QueryWrapper<Book> query = new QueryWrapper<>();
        // 这种写法可能会导致description的拼写错误从而引发程序崩溃
        // 所以采用下面的LambdaQueryWrapper做法
        query.like("description", "入");
        List<Book> books = bookDao.selectList(query);
        System.out.println(books);
    }

    // 条件查询
    @Test
    void testGetByLQuery() {
        String description = "入";
        LambdaQueryWrapper<Book> query = new LambdaQueryWrapper<>();
        // 这种使用对象获取属性的方式就避免了拼写错误。
        // description != null这句话的意思是如果description不空，就写上这个查询条件
        query.like(description != null, Book::getDescription, description);
        List<Book> books = bookDao.selectList(query);
        System.out.println(books);
    }
}
