package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.entity.UserVO;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.UserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * @Author: Odin
 * @Date: 2023/2/27 00:13
 * @Description:
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public void test1() {
        List<User> userList = this.list();
        System.out.println("userList"+userList);
        // 1.实体类转换
        List<UserVO> userVoList = EntityUtils.toList(userList, UserVO::new);
        System.out.println("实体类转换" + userVoList);
        // 2.取出某列数据
        List<String> userNames = EntityUtils.toList(userList, User::getUserName);
        System.out.println("取出某列数据(userName)"+userNames);
    }

    public void test2() {
        List<User> userList = this.list();
        // 1. 实体类转换
        List<UserVO> userVoList = EntityUtils.toList(userList, UserVO::new);
        System.out.println(userVoList);
        // 2. 取出某列数据
        List<String> userNames = EntityUtils.toList(userList, User::getUserName);
        System.out.println(userNames);
    }

    public void test3() {
        Integer[] arrays = {1, 2, 3, 4, 5, 6};
        // 1. 不改变元素类型
        List<Integer> integerList = EntityUtils.toList(arrays);
        // 2. 改变元素类型
        List<String> stringList = EntityUtils.toList(arrays, String::valueOf);
    }

    public void test4() {
        User user = this.getById(1);
        Map<String, Object> map = EntityUtils.toMap(user);
    }

    public void test5() {
        List<User> userList = this.list();
        Map<Long, String> map = EntityUtils.toMap(userList, User::getUserId, User::getUserName);

        Map<Long, User> map2 = EntityUtils.toMap(userList, User::getUserId);
    }

    public void test6() {
        List<User> userList = this.list();
        // User实体类equalts方法得重写
        Set<User> userSet = EntityUtils.toSet(userList);
        // 改变元素类型
        Set<String> userSets = EntityUtils.toSet(userList, User::getUserName);
    }

    public void test7() {
        Integer[] arrays = {1, 2, 3, 4, 5, 6};
        List<Integer> integerList = Arrays.asList(arrays);
        List<Integer> newList = EntityUtils.toList(integerList, Function.identity());
        List<String> newList2 = EntityUtils.toList(integerList, String::valueOf);
    }

}
