package com.wl.controller;

import com.wl.mod.Book;
import com.wl.service.impl.MailServiceImpl;
import com.wl.service.impl.BookServiceImpl;
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

    @Resource
    private MailServiceImpl mailService;

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

    @RequestMapping("send")
    @ResponseBody
    public String sendMsg(){
        String content ="<html>\n" + "<body>\n" + "<h3>hello world ! 这是一封Html邮件!</h3>\n" + "</body>\n" + "</html>";
        mailService.sendSimpleMail("wul@koal.com", "test simple mail", content);
        return "success";
    };

    @RequestMapping("hello1")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }


}
