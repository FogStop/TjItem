package cn.fog;

import cn.fog.tj.entity.User;
import cn.fog.tj.mapper.UserMapper;
import cn.fog.tj.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

}
