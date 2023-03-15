package org.dog.server;

import org.dog.server.domain.User;
import org.dog.server.enums.GenderEnum;
import org.dog.server.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test1() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        User user = new User().setName("王武").setSex(GenderEnum.MALE);
        userMapper.insert(user);
    }

}
