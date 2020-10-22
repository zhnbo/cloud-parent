package com.woniuxy.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * @author zh_o
 * @date 2020-10-23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String currentPort;

    @GetMapping
    public String test() {
        return "Test GET: " + currentPort;
    }

}
