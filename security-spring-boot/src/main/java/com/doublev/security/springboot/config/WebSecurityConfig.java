package com.doublev.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ Project: security-spring
 * @ Package: com.doublev.security.springmvc.config
 * @ Title 标题（要求能简洁地表达出类的功能和职责）
 * @ Description: 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @ author : qw
 * @ CreateDate: 2020/10/19 15:49
 * @ Version: 1.0
 * @ Copyright: Copyright (c) 2020
 * @ History: 修订历史（历次修订内容、修订人、修订时间等）
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    // 密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 定义安全拦截机制

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                // 鉴权
                //.antMatchers("/r/r1").hasAnyAuthority("p1")
                //.antMatchers("/r/r2").hasAnyAuthority("p2")
                //.antMatchers("/r/**")
                //.authenticated()
                .anyRequest().permitAll()
                .and()
                // 页面跳转
                .formLogin()
                .loginPage("/login-view")
                .loginProcessingUrl("/login")
                .successForwardUrl("/login-success")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login-view?logout")
                .and()
                // session管理
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }
}
