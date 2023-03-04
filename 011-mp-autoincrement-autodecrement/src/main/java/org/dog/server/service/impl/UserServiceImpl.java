package org.dog.server.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IUserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.support.CustomLambdaUpdateWrapper;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{

    /**
     * 通过主键自增更新某个字段
     */
    public boolean updateUserAge1(Long userId) {
        CustomLambdaUpdateWrapper<User> wrapper = new CustomLambdaUpdateWrapper<>();
        wrapper.incr(User::getAge, 5).eq(User::getUserId, userId);
        return update(wrapper);
    }

    /**
     * 通过主键自减更新某个字段
     */
    @Override
    public boolean updateUserAge2(Long userId) {
        CustomLambdaUpdateWrapper<User> wrapper = new CustomLambdaUpdateWrapper<>();
        wrapper.desc(User::getAge, 1).eq(User::getUserId, userId);
        return update(wrapper);
    }
}
