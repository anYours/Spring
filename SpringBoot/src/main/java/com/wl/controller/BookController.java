package com.wl.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.wl.mod.Book;
import com.wl.service.impl.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    
    @Resource
    private BookServiceImpl bookService;
    
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public String getAllBook(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "list";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return "redirect:/book/queryBookByPage";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveBook(Book book){
        bookService.saveBook(book);
        return "redirect:/book/findAll";
    }

    @GetMapping("/queryBookByPage")
    public String queryBookByPage(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model){
        int pageSize = 5;
        List<Book> books = bookService.queryBookByPage(pageNum, pageSize);
        PageInfo<Book> bookPageInfo = new PageInfo<Book>(books);
        model.addAttribute("ss", bookPageInfo);
        logger.info("查询成功");
        return "list";
    }
}
