package com.wl.controller;

import com.wl.mod.Book;
import com.wl.service.impl.BookServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LearnController {

    @Resource
    private BookServiceImpl bookService;

    @RequestMapping("hello")
    @ResponseBody
    public String getHelloWorld(){
        return "Hello World";
    }

    @RequestMapping("date")
    public String date(){
        return "date";
    }


    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public String getAllBook(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "list";
    }

}
