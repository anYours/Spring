package com.wl.service.impl;

import com.wl.dao.BookRepository;
import com.wl.model.Book;
import com.wl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 书籍业务层实现
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * 获取所有 Book
     */
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * 新增 Book
     *
     * @param book {@link Book}
     */
    @Override
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * 更新 Book
     *
     * @param book {@link Book}
     */
    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    /**
     * 删除 Book
     *
     * @param id 编号
     */
    @Override
    public Book delete(Long id) {
        Book book = bookRepository.findBookById(id);
        bookRepository.delete(book);
        return book;
    }

    /**
     * 获取 Book
     *
     * @param id 编号
     */
    @Override
    public Book findById(Long id) {
        return bookRepository.findBookById(id);
    }
}
