package com.wl.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author wul
 * @Description
 * @Date 2019/8/22 16:12
 */
@RestController
public class PushController {

    @PostMapping("/test/{type}")
    public Map<String, Object> push(@RequestBody String body, HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println(s+":"+request.getHeader(s));
        }
        System.out.println("body = [" + body + "]");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resultCode", 200);
        map.put("resultMessage", "rewrqwrqwe");
        return map;
    }


    @PostMapping("/test1/{type}")
    public Map<String, Object> push1(@RequestBody String body, HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println(s+":"+request.getHeader(s));
        }
        System.out.println("body = [" + body + "]");
        Map<String, Object> map = new HashMap<String, Object>();

        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("ID", "e5d373f6322444daa762f08ff9ee4ec4");
        map1.put("errorMessage", "测试");
        listMap.add(map1);
        map.put("resultCode", 500);
        map.put("resultMessage", "rewrqwrqwe");
        map.put("errors",listMap);
        return map;
    }

    @DeleteMapping("/test1")
    public String delete(@RequestBody Map<String, Object> map){
        return map.toString();
    }
}
