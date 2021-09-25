package com.ice.blog.controller;

import com.ice.blog.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("email")
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("send")
    public Map send(){
        emailService.sendMessage("icecheering@163.com","测试", "【龙玄博客】您的用户名为cheering的账号已激", false);
        return new HashMap(){{put("status", 200);}};
    }

}
