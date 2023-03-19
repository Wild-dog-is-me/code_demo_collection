package org.dog.server.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.JacksonUtils;

import javax.annotation.Resource;
import java.lang.ref.PhantomReference;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{

    @Resource
    private StringRedisTemplate redisTemplate;

    @Override
    public User selectUser1(Long id) {
        String key = String.valueOf(id);
        User user = getById(id);
        String valueAsString = JacksonUtils.writeValueAsString(user);
        redisTemplate.opsForValue().set(key, valueAsString);
        return JacksonUtils.readObjectValue(redisTemplate.opsForValue().get(key),User.class);
    }

    @Override
    public List<User> selectUser2(Long id) {
        return null;
    }

    @Override
    public User selectUser3(Long id) {
        return null;
    }

    @Override
    public List<User> selectUser4(Long id) {
        return null;
    }

    @Override
    public User selectUser5(Long id) {
        return null;
    }
}
