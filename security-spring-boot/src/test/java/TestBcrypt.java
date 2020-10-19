import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Project: security-spring-boot
 * @ Package: PACKAGE_NAME
 * @ Title 标题（要求能简洁地表达出类的功能和职责）
 * @ Description: 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @ author : qw
 * @ CreateDate: 2020/10/19 18:12
 * @ Version: 1.0
 * @ Copyright: Copyright (c) 2020
 * @ History: 修订历史（历次修订内容、修订人、修订时间等）
 */
@RunWith(SpringRunner.class)
public class TestBcrypt {
    @Test
    public void test1() {
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$1vdfPR44BQXUuMA0cO91pOn7dSLlQralO6vCJmMbQSvarqk3ATbTC");
        System.out.println("校验结果" + checkpw);
    }
}
