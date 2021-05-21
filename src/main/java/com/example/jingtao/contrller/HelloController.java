package com.example.jingtao.contrller;

import com.example.jingtao.entity.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }


    @RequestMapping("/notlogin")
    public ResultEntity notlogin() {
        return ResultEntity.login("请登录", null);
    }
}
