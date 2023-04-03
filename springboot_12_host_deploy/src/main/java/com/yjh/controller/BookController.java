package com.yjh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yjh.controller.utils.R;
import com.yjh.domain.Book;
import com.yjh.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

// 表现层(控制层)  表现层调业务层，业务层调数据层
// 这个和BookController2不用，这里是将返回值封装到自己定义的一个Response中了

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    // @RequestBody 是从请求体中获取数据（json），它里面的字段和
    // Book的字段对应，这样实现自动匹配。这个请求体是postman中的raw
    @PostMapping
    public R save(@RequestBody Book book) throws Exception {
        if (true) throw new IOException();
        Boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功":"添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new R(flag, flag ? "更新成功":"更新失败");
    }

    // PathVariable说明参数是从路径中自动匹配来
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        Boolean flag = bookService.delete(id);
        return new R(flag, flag ? "删除成功":"删除失败");
    }

    // PathVariable说明参数是从路径中自动匹配来
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    // 分页
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {  // 这个book默认是在RequestParams拿的
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        long maxPage = page.getPages();     // 总页码
        // 防止删除最后一页最后一条数据时出现报错问题
        if (maxPage < currentPage) {    // 当前页码大于总页码，那么返回总页码值的数据
            page = bookService.getPage((int)maxPage, pageSize, book);
        }
        return new R(true, page);
    }
}
