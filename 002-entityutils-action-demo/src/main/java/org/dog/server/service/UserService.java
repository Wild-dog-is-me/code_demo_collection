package org.dog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Odin
 * @Date: 2023/2/27 00:12
 * @Description:
 */

public interface UserService extends IService<User> {

    public void test1();

    public void test2();

}
