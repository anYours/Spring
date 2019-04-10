package com.wl.service.impl;

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
}
