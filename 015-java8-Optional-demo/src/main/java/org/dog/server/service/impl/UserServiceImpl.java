package org.dog.server.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 创建Optional包装器
     */
    public void selectUserList1(User user) {
        Optional<User> optional = Optional.ofNullable(user);
        if (optional.isPresent()) {
            User optionalUser = optional.get();
            Long userId = optionalUser.getUserId();
        }
    }

    /**
     *
     */
    public void selectUserList2(User user) {
        Optional<User> optional = Optional.ofNullable(user);
        // 如果userId为空，则传入默认值null
        Long userId = optional.map(User::getUserId).orElse(null);


    }
}
