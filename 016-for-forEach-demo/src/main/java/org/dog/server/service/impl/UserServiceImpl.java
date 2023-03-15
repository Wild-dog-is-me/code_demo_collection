package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.entity.UserVo;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 循环方式一：通过下标循环（面向过程）
     */
    public List<User> selectUserList1() {
        List<User> userList = list();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
        return userList;
    }

    /**
     * 循环方式二：外循环（面向过程）
     */
    public List<User> selectUserList2() {
        List<User> userList = list();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    /**
     * 循环方式三：内循环（函数式编程）
     */
    public List<User> selectUserList3() {
        List<User> userList = list();
        userList.forEach(System.out::println);
        return userList;
    }

    /**
     * 手写实现forEach
     */
    public <T> void forEach(List<T> data, Consumer<? super T> consumer) {
        for (T t : data) {
            consumer.accept(t);
        }
    }

    /**
     * 解析Consumer函数式接口的本质
     */
    public void selectUserLst4() {
        List<User> userList = list();
        userList.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });
    }

    /**
     * lambda实现
     */
    public void selectUserList5() {
        List<User> userList = list();
        userList.forEach(e -> System.out.println(e));
    }

    /**
     * 常见的函数式接口使用
     */
    public void selectUserLst6() {
        List<User> userList = list();
        Collection<UserVo> collect = userList.stream().filter(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getAge() > 10;  // 过滤年龄大于10的字段
            }
        }).map(new Function<User, UserVo>() {
            @Override
            public UserVo apply(User user) {
                return new UserVo(user);    // 将输入的User转化为UserVo
            }
        }).collect(Collectors.toCollection(new Supplier<Collection<UserVo>>() {
            @Override
            public Collection<UserVo> get() {
                return new ArrayList<>();
            }
        }));
    }

    public void selectUserLst7() {
        List<User> userList = list();
        Collection<UserVo> collect = userList.stream().filter(user -> user.getAge() > 10)
                .map(UserVo::new)
                .collect(Collectors.toList());
    }
}
