package com.doublev.security.springmvc.interceptor;

import com.doublev.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * @ Project: security-springmvc
 * @ Package: com.doublev.security.springmvc.interceptor
 * @ Title 标题（要求能简洁地表达出类的功能和职责）
 * @ Description: 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @ author : qw
 * @ CreateDate: 2020/10/19 15:03
 * @ Version: 1.0
 * @ Copyright: Copyright (c) 2020
 * @ History: 修订历史（历次修订内容、修订人、修订时间等）
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 校验用户请求的url 是否在所拥有的权限内
        Object attribute = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (Objects.isNull(attribute)) {
            // 未登陆
            writeContents(response,"请登录");
        }
        // 判断权限
        UserDto userDto = (UserDto)attribute;
        // 用户请求的url
        String requestURI = request.getRequestURI();
        if (userDto.getAuthorities().contains("p1") && requestURI.contains("/r/r1")) {
            return true;
        }
        if (userDto.getAuthorities().contains("p2") && requestURI.contains("/r/r2")) {
            return true;
        }
        return false;
    }

    /**
     * 响应信息给前端
     * @param response
     * @param value
     */
    private void writeContents(HttpServletResponse response,String value) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(value);
        writer.close();
        response.resetBuffer();
    }
}
