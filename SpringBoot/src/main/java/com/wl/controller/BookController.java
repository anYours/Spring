package com.wl.controller;

import com.wl.mod.Book;
import com.wl.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    
    @Resource
    private BookServiceImpl bookService;
    
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public String getAllBook(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "list";
    }
}
