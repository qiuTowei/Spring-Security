package com.doublev.security.springmvc.service.impl;

import com.doublev.security.springmvc.model.AuthenticationRequest;
import com.doublev.security.springmvc.model.UserDto;
import com.doublev.security.springmvc.service.AuthenticationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ Project: security-springmvc
 * @ Package: com.doublev.security.springmvc.service.impl
 * @ Title 标题（要求能简洁地表达出类的功能和职责）
 * @ Description: 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @ author : qw
 * @ CreateDate: 2020/10/19 14:30
 * @ Version: 1.0
 * @ Copyright: Copyright (c) 2020
 * @ History: 修订历史（历次修订内容、修订人、修订时间等）
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public UserDto authentication(AuthenticationRequest request) {

        return getUserDto(request.getUsername());
    }
    private UserDto getUserDto(String username) {
        return userDtoMap.get(username);
    }

    private Map<String,UserDto> userDtoMap = new HashMap<>();
    {
        Set<String> authorities1 = new HashSet<>();
        authorities1.add("p1");
        Set<String> authorities2 = new HashSet<>();
        authorities2.add("p2");
        userDtoMap.put("zs", new UserDto("1", "张三", "123", "zzz", "bj",authorities1));
        userDtoMap.put("ls", new UserDto("2", "李四", "123", "lll", "bj",authorities2));

    }


}

