package com.wl.service;

import com.wl.mod.Book;

import java.util.List;

public interface BookService {

    /**
     * 查询所有书籍
     * @return
     */
    public List<Book> findAll();
}
