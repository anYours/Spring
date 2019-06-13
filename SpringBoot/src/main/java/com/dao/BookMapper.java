package com.dao;

import com.mod.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BookMapper extends com.github.abel533.mapper.Mapper<Book> {

    //private Long id;
    //    private String name;
    //    private Date times;
    //    private String des;
    //    private String author;
    //    private Double sal;

    @Results(id = "userResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "times", column = "released"),
            @Result(property = "des", column = "des"),
            @Result(property = "author", column = "author"),
            @Result(property = "sal", column = "sal")
    })
    @Select("SELECT * FROM book")
    public List<Book> findAll();

    @Delete("DELETE FROM book WHERE id = ${id}")
    public void deleteBook(@Param("id") Integer id);

    @Insert("INSERT INTO book(name, released, des, author, sal) VALUES (#{name}, #{times}, #{des}, #{author}, #{sal})")
    public void saveBook(Book book);

    @Results(id = "userResult1", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "times", column = "released"),
            @Result(property = "des", column = "des"),
            @Result(property = "author", column = "author"),
            @Result(property = "sal", column = "sal")
    })
    @Select("select * from book where id = ${id}")
    public Book getBookById(@Param("id") Integer id);
}
