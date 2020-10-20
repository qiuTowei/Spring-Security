package com.doublev.security.springboot.service;

import com.doublev.security.springboot.dao.UserDao;
import com.doublev.security.springboot.model.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @ Project: security-spring-boot
 * @ Package: com.doublev.security.springboot.service
 * @ Title 标题（要求能简洁地表达出类的功能和职责）
 * @ Description: 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @ author : qw
 * @ CreateDate: 2020/10/19 17:59
 * @ Version: 1.0
 * @ Copyright: Copyright (c) 2020
 * @ History: 修订历史（历次修订内容、修订人、修订时间等）
 */
@Service
public class SpringDataUsderDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDto dto = userDao.getUserByUsername(s);
        if (Objects.isNull(dto)) {
            return null;
        }
        List<String> list = userDao.findPermissionByUserId(dto.getId());
        return User.withUsername(dto.getUsername())
                // BCrypt 加密
                .password(dto.getPassword())
                .authorities(list.toArray(new String[0]))
                .build();
    }
}
