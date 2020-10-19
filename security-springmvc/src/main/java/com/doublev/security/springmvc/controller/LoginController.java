package com.doublev.security.springmvc.controller;

import com.doublev.security.springmvc.model.AuthenticationRequest;
import com.doublev.security.springmvc.model.UserDto;
import com.doublev.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Objects;

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
    @Autowired
    private AuthenticationService authenticationService;
    @RequestMapping(value = "/login",produces = {"text/plain;charset=utf-8"})
    public String login(AuthenticationRequest request, HttpSession session) {
        UserDto authentication = authenticationService.authentication(request);
        // 存入session
        session.setAttribute(UserDto.SESSION_USER_KEY, authentication);
        return authentication.getUsername() + "登录成功";
    }
    @GetMapping(value = "/logout",produces = {"text/plain;charset=utf-8"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "退出成功";
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
        String username;
        Object attribute = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (Objects.isNull(attribute)) {
            username = "匿名";
        }else {
            UserDto user = (UserDto)attribute;
            username = user.getUsername();
        }
        return username;
    }

}


