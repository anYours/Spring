package com.wl.controller;


import com.annotation.MyAnnotation;
import com.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试校验错误信息
 */
@RestController
public class ValidateController {

    static Map<String, User> users = Collections.synchronizedMap(new HashMap<String, User>());

    @MyAnnotation
    @PostMapping("/postUser")
    public String postUser(@RequestBody @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getModel().toString());
            //用于获取所有的错误信息（不带Field）
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            //用于获取带Field的错误信息
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            StringBuilder errorMessage = new StringBuilder();
            StringBuilder fieldErrorsMessage = new StringBuilder();
            for(FieldError error : fieldErrors){
                //循环添加
                fieldErrorsMessage.append(error.getField()).append(error.getDefaultMessage()).append('\n');
            }

            for(ObjectError error : allErrors){
                errorMessage.append(error.getDefaultMessage());
            }
            return  fieldErrorsMessage.toString();
        }else{
            String name = user.getName();
            users.put(name, user);
            return "success";
        }
    }

    @GetMapping("/getUser/{name}")
    public String getUser(@PathVariable String name){
        User user = users.get(name);
        return user.toString();
    }

}
