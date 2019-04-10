package com.wl.dao;

import com.wl.mod.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book")
    public List<Book> findAll();
}
