package com.wl.controller;

import com.wl.bean.User;
import com.wl.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("login")
    public String login(User user, Model model){
        boolean b = userService.loginIsSuccess(user);
        int time = 3;
        String message = "";
        if(b){
            message = "登录成功";
        }else{
            message = "登录失败";
        }
        model.addAttribute("message", message);
        model.addAttribute("time", time);
        return "user/result";
    }

    @RequestMapping("index")
    public String jumpLogin(){
        return "user/login";
    }

    @RequestMapping("jumpRegist")
    public String jumpRegist(){
        return "user/regist";
    }

    @PostMapping("regist")
    public String regist(User user){
        System.out.println("user = [" + user.toString() + "]");
        userService.registUser(user);
        return "redirect:/user/index";
    }
}
