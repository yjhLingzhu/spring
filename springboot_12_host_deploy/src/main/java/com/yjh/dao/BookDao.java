package com.yjh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjh.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {

    // 不用mybatis-plus（即不用ORM的形式）
    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);

    //  上面写了继承，就是说可以用mybatis-plus中提供的ORM
}
