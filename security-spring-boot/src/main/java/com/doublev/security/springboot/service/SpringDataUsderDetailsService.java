package com.doublev.security.springboot.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // TODO 后续通过数据库进行查询
        UserDetails userDetails = User.withUsername("zhangsan")
                // BCrypt 加密
                .password("$2a$10$QGPOw259ClnQIK4RP8Ds8O7v.RrywPWAxh2Xv8y/JaE8n9zYRoLgW")
                .authorities("p1")
                .build();
        return userDetails;
    }
}
