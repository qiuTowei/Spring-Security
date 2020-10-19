package com.doublev.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @ Project: security-springmvc
 * @ Package: com.doublev.security.springmvc.config
 * @ Title 标题（要求能简洁地表达出类的功能和职责）
 * @ Description: 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @ author : qw
 * @ CreateDate: 2020/10/19 10:53
 * @ Version: 1.0
 * @ Copyright: Copyright (c) 2020
 * @ History: 修订历史（历次修订内容、修订人、修订时间等）
 */
@Configuration
@ComponentScan(basePackages = "com.doublev.security.springmvc",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value= Controller.class)})
public class ApplicationConfig {
    // 在此配置除了Controller的其它bean，比如数据库连接池，事务管理器，业务bean等


}
