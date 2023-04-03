package com.yjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjh.dao.BookDao;
import com.yjh.domain.Book;
import com.yjh.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 继承了ServiceImpl<BookDao, Book>，这里需要提供两个泛型
// 第一个是数据层的实现类，这里数据层没有实现类，直接上了抽象接口，
// spring是会自动生成实现这个接口的类的，然后自动装配。第二个是
// 模型类。

// 之所以要继承，是因为抽象接口IBookService继承了抽象接口IService，
// IService里面很多方法，我们不可能在BookServiceImpl里面实现这些方法，
// 这些方法都是MP提供的，我们也不知道怎么实现，所以要继承已经实现了这些方法
// 的类（ServiceImpl），然后我们实现我们自己在IBookService的抽象接口就好。

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean saveBook(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean updateBook(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        // 创建一个查询器
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage<Book> page = new Page<>(currentPage, pageSize);
        bookDao.selectPage(page, lqw);
        return page;
    }
}
