package org.dog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IUserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.comparator.FixedOrderComparator;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    public List<User> selectUserList1() {
        return this.list();
    }

    /**
     * 根据userId正序排序
     */
    @Override
    public List<User> selectUserList2() {
        LambdaQueryWrapper<User> wrapper =
                Wrappers.lambdaQuery(User.class).orderBy(true, true, User::getUserId);
        return this.list(wrapper);
    }

    /**
     * 根据userId逆序排序
     */
    @Override
    public List<User> selectUserList3() {
        LambdaQueryWrapper<User> wrapper =
                Wrappers.lambdaQuery(User.class).orderBy(true, false, User::getUserId);
        return this.list(wrapper);
    }

    /**
     * 定序排序：按照userId 321654排序
     */
    @Override
    public List<User> selectUserList4() {
        List<User> users = this.list();

        FixedOrderComparator<User> comparator = new FixedOrderComparator<>();
        // 按照指定顺序的排序比较器构建完成
        Arrays.asList(3L, 2L, 1L, 6L, 5L, 4L).forEach(e -> comparator.add(new User(e)));
        // 应用排序器进行排序
        users.sort(comparator);
        return users;
    }
}
