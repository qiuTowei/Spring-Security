package com.doublev.security.springmvc.service;

import com.doublev.security.springmvc.model.AuthenticationRequest;
import com.doublev.security.springmvc.model.UserDto;

/**
 * @ Project: security-springmvc
 * @ Package: com.doublev.security.springmvc.service
 * @ Title 标题（要求能简洁地表达出类的功能和职责）
 * @ Description: 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @ author : qw
 * @ CreateDate: 2020/10/19 14:27
 * @ Version: 1.0
 * @ Copyright: Copyright (c) 2020
 * @ History: 修订历史（历次修订内容、修订人、修订时间等）
 */
public interface AuthenticationService {

    UserDto authentication(AuthenticationRequest request);
}
