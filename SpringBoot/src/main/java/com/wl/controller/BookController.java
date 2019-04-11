package com.wl.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.wl.mod.Book;
import com.wl.service.impl.BookServiceImpl;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.lang.reflect.Type;
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

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return "redirect:/book/findAll";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveBook(Book book){
        bookService.saveBook(book);
        return "redirect:/book/findAll";
    }
}
