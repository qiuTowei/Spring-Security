package com.doublev.security.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ Project: security-springmvc
 * @ Package: com.doublev.security.springmvc.model
 * @ Title 标题（要求能简洁地表达出类的功能和职责）
 * @ Description: 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @ author : qw
 * @ CreateDate: 2020/10/19 14:28
 * @ Version: 1.0
 * @ Copyright: Copyright (c) 2020
 * @ History: 修订历史（历次修订内容、修订人、修订时间等）
 */
@Data
@AllArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;

}
