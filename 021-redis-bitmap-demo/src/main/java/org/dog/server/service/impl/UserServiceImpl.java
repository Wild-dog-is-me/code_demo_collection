package org.dog.server.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.RedisBitMapUtils;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{

    public final static String USER_BITMAP_KEY = "USER_BITMAP_KEY";

    @Override
    public User selectUser1(Long userId) {
        return this.getById(userId);
    }

    @Override
    public User selectUser2(Long userId) {
        return RedisBitMapUtils.ifPresent(USER_BITMAP_KEY, userId, this::getById);
    }

    @Override
    public User selectUser3(Long userId) {
        return RedisBitMapUtils.ifPresent(USER_BITMAP_KEY, userId, e -> this.getById(e, 30000));
    }
}
