package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.JacksonUtils;
import xin.altitude.cms.common.util.RedisUtils;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public User selectUser1(Long id) {
        String key = String.valueOf(id);
        User user = this.getById(id);
        String valueAsString = JacksonUtils.writeValueAsString(user);
        redisTemplate.opsForValue().set(key, valueAsString);
        return JacksonUtils.readValue(redisTemplate.opsForValue().get(key), User.class);
    }

    @Override
    public List<User> selectUser2(Long id) {
        String key = String.valueOf(id) + "0";
        List<User> users = list();
        String valueAsString = JacksonUtils.writeValueAsString(users);
        redisTemplate.opsForValue().set(key, valueAsString);
        return JacksonUtils.readListValue(redisTemplate.opsForValue().get(key), User.class);
    }

//  ************封装使用

    @Override
    public User selectUser3(Long id) {
        String key = String.valueOf(id);
        User user = getById(id);
        RedisUtils.save(key, user);

        return RedisUtils.getObject(key, User.class);
    }

    @Override
    public List<User> selectUser4(Long id) {
        String key = String.valueOf(id);
        List<User> list = list();
        RedisUtils.save(key, list);
        return RedisUtils.getList(key, User.class);
    }

    @Override
    public User selectUser5(Long id) {
        return getById(id, User.class);
    }
}
