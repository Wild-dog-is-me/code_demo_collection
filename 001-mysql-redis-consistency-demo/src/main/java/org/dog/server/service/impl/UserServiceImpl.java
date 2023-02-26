package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.altitude.cms.common.constant.RedisConstants;
import xin.altitude.cms.common.util.RedisUtils;

/**
 * @Author: Odin
 * @Date: 2023/2/26 23:07
 * @Description:
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    /**
     * 普通更新
     * @param user
     * @return
     */
    @Override
    public boolean updateUser1(User user) {
        // 先更新数据库
        boolean result = this.updateById(user);
        Long userId = user.getUserId();
        // 更新Redis缓存
        RedisUtils.save(RedisConstants.createCacheKey(User.class, userId), getById(userId));
        return result;
    }

    /**
     * 二、Mysql与缓存一致性更新
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser2(User user) {
        // 先更新数据库
        boolean result = this.updateById(user);
        Long userId = user.getUserId();
        // 更新Redis缓存
        RedisUtils.save(RedisConstants.createCacheKey(User.class, userId), getById(userId));
        return result;
    }

    /**
     * 三、调用自定义框架更新
     *
     * @return
     */
    public boolean updateUser3(User user) {
        return this.updateById(user, User.class);
    }
}
