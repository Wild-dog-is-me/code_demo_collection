package org.dog.server.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dog.server.domain.User;
import org.dog.server.enums.GenderEnum;
import org.dog.server.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Odin
 * @Date: 2023/3/15 12:38
 * @Description:
 */

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> select(User user) {
        List<User> users = userMapper.selectList(new QueryWrapper<>(user));
        users.forEach(System.out::println);
        return users;
    }

    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }

    public void update() {
        User user = new User().setSex(GenderEnum.FEMALE);
        userMapper.update(user, new QueryWrapper<User>().eq("age", GenderEnum.UNKNOWN));
    }

    public void delete() {
        userMapper.delete(new QueryWrapper<User>().lambda().eq(User::getSex, GenderEnum.FEMALE));
    }

}
