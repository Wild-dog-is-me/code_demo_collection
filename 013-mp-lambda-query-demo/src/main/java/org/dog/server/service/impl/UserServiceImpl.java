package org.dog.server.service.impl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;
import org.dog.server.entity.vo.UserVo;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IDeptService;
import org.dog.server.service.IUserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService{

    @Resource
    private IDeptService deptService;

    @Override
    public UserVo getOneUser(Integer userId) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).
                eq(User::getUserId, userId);
        UserVo userVo = EntityUtils.toObj(getOne(wrapper), UserVo::new);
        Optional.ofNullable(userVo).ifPresent(this::addDeptInfo);
        return userVo;
    }

    private void addDeptInfo(UserVo userVo) {
        LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class).eq(Dept::getDeptId, userVo.getDeptId());
        Dept deptInfo = deptService.getOne(wrapper);
        Optional.ofNullable(deptInfo).ifPresent(e -> userVo.setDeptName(e.getDeptName()));
    }

    @Override
    public List<UserVo> findUserByAge() {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).gt(User::getAge, 10);
        List<User> list = this.list(wrapper);
        List<UserVo> userVos = EntityUtils.toList(list, UserVo::new);

        if (userVos.size() > 0) {
            Set<Long> deptIds = EntityUtils.toSet(userVos, UserVo::getDeptId);
            LambdaQueryWrapper<Dept> wrapper1 = Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds).select(Dept::getDeptId, Dept::getDeptName);
            List<Dept> deptList = deptService.list(wrapper1);
            Map<Long, String> map = EntityUtils.toMap(deptList, Dept::getDeptId, Dept::getDeptName);
            userVos.forEach(e -> e.setDeptName(map.get(e.getDeptId())));
        }
        return userVos;
    }

    @Override
    public List<UserVo> findUserByDeptName() {
        LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class).eq(Dept::getDeptName, "Tomcat");
        List<Dept> depts = deptService.list(wrapper);
        Map<Long, Dept> map = EntityUtils.toMap(depts, Dept::getDeptId, e -> e);
        Set<Long> deptIds = EntityUtils.toSet(depts, Dept::getDeptId);
        LambdaQueryWrapper<User> wrapper1 = Wrappers.lambdaQuery(User.class).in(User::getDeptId, deptIds);
        List<User> users = this.list(wrapper1);
        List<UserVo> userVos = EntityUtils.toList(users, UserVo::new);
        userVos.forEach(e -> e.setDeptName(map.get(e.getDeptId()).getDeptName()));
        return userVos;
    }
}
