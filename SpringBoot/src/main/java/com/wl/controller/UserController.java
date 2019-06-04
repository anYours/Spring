package com.wl.controller;

import com.wl.bean.User;
import com.wl.service.UserService;
import com.wl.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("login")
    public void login(User user){
        System.out.println("user = [" + user.toString() + "]");
        boolean b = userService.loginIsSuccess(user);
        if(b){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
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
