package com.service;

import com.mod.Book;

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

    /**
     * 根据ID查询书籍
     * @param id
     * @return
     */
    public Book getBookById(Integer id);
}
