package com.wl.service.impl;

import com.github.pagehelper.PageHelper;
import com.wl.dao.BookMapper;
import com.wl.mod.Book;
import com.wl.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;
    /**
     * 查询所有书籍
     *
     * @return
     */
    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    /**
     * 删除书籍
     *
     * @param id
     */
    @Override
    public void deleteBook(Integer id) {
        bookMapper.deleteBook(id);
    }

    /**
     * 新增书籍
     *
     * @param book
     */
    @Override
    public void saveBook(Book book) {
        bookMapper.saveBook(book);
    }

    @Override
    public List<Book> queryBookByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> books = bookMapper.findAll();
        return  books;
    }
}
