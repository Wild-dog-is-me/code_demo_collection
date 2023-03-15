package org.dog.server.service;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.dog.server.domain.User;
import org.dog.server.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class IUserService{

    @Resource
    private UserMapper userMapper;

    /**
     * 保存
     */
    public User test1() {
        User user = new User(null, "Tom", 1, "tom@qq.com");
        userMapper.insert(user);
        User arg = userMapper.selectById(user.getId());
        log.info("query user:{}", arg);
        return arg;
    }

    /**
     * 更新
     */
    public User test2(Integer id) {
        User beforeUser = userMapper.selectById(id);
        log.info("before user:{}", beforeUser);
        beforeUser.setAge(12);
        userMapper.updateById(beforeUser);
        User arg = userMapper.selectById(id);
        log.info("query user:{}", arg);
        return arg;
    }
}
