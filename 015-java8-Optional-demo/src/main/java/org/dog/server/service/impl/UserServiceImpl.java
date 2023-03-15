package org.dog.server.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.Entity.Head;
import org.dog.server.Entity.Human;
import org.dog.server.Entity.Mouth;
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

    /**
     * 从一个复杂对象中取值 （Human->Head->Mouth）-> [通过Human取出口型]
     */
    public void selectUserList3(Human human) {
        String shape = Optional.ofNullable(human)
                .map(Human::getHead)
                .map(Head::getMouth)
                .map(Mouth::getShape)
                .orElseGet(() -> "O型嘴");
    }

    /**
     * 拿到结果之后打印
     */
    public void selectUserList4(User user) {
        Optional.ofNullable(user).ifPresent(System.out::println);

    }

}
