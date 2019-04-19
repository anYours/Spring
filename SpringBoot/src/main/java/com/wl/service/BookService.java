package com.wl.service;

import com.wl.mod.Book;

import java.util.List;

public interface BookService {

    /**
     * 查询所有书籍
     * @return
     */
    public List<Book> findAll();

    /**
     * 删除书籍
     * @param id
     */
    public void deleteBook(Integer id);

    /**
     * 新增书籍
     * @param book
     */
    public void saveBook(Book book);

    public List<Book> queryBookByPage(Integer pageNum, Integer pageSize);
}
