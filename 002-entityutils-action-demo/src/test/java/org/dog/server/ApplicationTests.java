package org.dog.server;

import org.dog.server.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApplicationTests {

    @Resource
    private UserService userService;

    @Test
    public void test1() {
        userService.test2();
    }

}
