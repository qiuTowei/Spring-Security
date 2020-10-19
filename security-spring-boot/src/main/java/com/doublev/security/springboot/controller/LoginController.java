package com.doublev.security.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ Project: security-springmvc
 * @ Package: com.doublev.security.springmvc.controller
 * @ Title 标题（要求能简洁地表达出类的功能和职责）
 * @ Description: 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @ author : qw
 * @ CreateDate: 2020/10/19 14:36
 * @ Version: 1.0
 * @ Copyright: Copyright (c) 2020
 * @ History: 修订历史（历次修订内容、修订人、修订时间等）
 */
@RestController
public class LoginController {
    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=utf-8"})
    public String login() {
        return "登录成功";
    }
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=utf-8"})
    public String getSessionR1(HttpSession session) {
        return getName(session) + "访问资源r1";
    }
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=utf-8"})
    public String getSessionR2(HttpSession session) {
        return getName(session) + "访问资源r2";
    }
    private String getName(HttpSession session) {
        return "用户名";
    }

}


