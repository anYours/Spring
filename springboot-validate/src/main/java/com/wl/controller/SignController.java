package com.wl.controller;

import com.wl.service.YJPopulationService;
import com.wl.util.RequesterCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wul
 * @Description
 * @Date 2019/11/1 13:46
 */
@RestController
public class SignController {


    @GetMapping("/sign")
    public String sign(){
        YJPopulationService.signingKey();
        return RequesterCredentials.gjgxjhpt_sign;
    }

    @GetMapping("/checkUser")
    public String checkUser(@RequestParam("userName")String userName, @RequestParam("userCode")String userCode){
        final boolean b = YJPopulationService.checkUser(userName, userCode);
        return b+"";
    }
}
