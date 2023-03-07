package org.dog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;
import org.dog.server.entity.vo.DeptVo;
import org.dog.server.entity.vo.UserVo;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IDeptService;
import org.dog.server.service.IUserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;

import javax.annotation.Resource;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private IDeptService deptService;

    @Override
    public UserVo getOneUser(Integer userId) {
        LambdaQueryWrapper<User> wrapper
                = Wrappers.lambdaQuery(User.class).eq(User::getUserId, userId);
        UserVo userVo = EntityUtils.toObj(getOne(wrapper), UserVo::new);
        Optional.ofNullable(userVo).ifPresent(this::addDeptInfo);
        return userVo;
    }

    private void addDeptInfo(UserVo userVo) {
        LambdaQueryWrapper<Dept> wrapper =
                Wrappers.lambdaQuery(Dept.class).eq(Dept::getDeptId, userVo.getDeptId());
        Dept deptInfo = deptService.getOne(wrapper);
        Optional.ofNullable(deptInfo).ifPresent(e -> userVo.setDeptName(e.getDeptName()));
    }

    @Override
    public List<UserVo> findUserByAge() {
        LambdaQueryWrapper<User> gt = Wrappers.lambdaQuery(User.class).gt(User::getAge, 10);
        List<User> list = this.list(gt);
        List<UserVo> userVos = EntityUtils.toList(list, UserVo::new);
        if (userVos.size() > 0) {
            Set<Long> deptIds = EntityUtils.toSet(userVos, UserVo::getDeptId);
            LambdaQueryWrapper<Dept> in =
                    Wrappers.lambdaQuery(Dept.class)
                            .in(Dept::getDeptId, deptIds)
                            .select(Dept::getDeptId, Dept::getDeptName);
            List<Dept> deptList = deptService.list(in);
            Map<Long, String> map = EntityUtils.toMap(deptList, Dept::getDeptId, Dept::getDeptName);
            userVos.forEach(e -> e.setDeptName(map.get(e.getDeptId())));
        }
        return userVos;
    }

    @Override
    public List<UserVo> findUserByDeptName() {
        LambdaQueryWrapper<Dept> eq = Wrappers.lambdaQuery(Dept.class).eq(Dept::getDeptName, "Tomcat");
        List<Dept> deptList = deptService.list(eq);
        List<DeptVo> deptVos = EntityUtils.toList(deptList, DeptVo::new);
        Set<Long> deptIds = EntityUtils.toSet(deptVos, DeptVo::getDeptId);
        LambdaQueryWrapper<User> in = Wrappers.lambdaQuery(User.class).in(User::getDeptId, deptIds);
        List<User> list = this.list(in);
        List<UserVo> userVos = EntityUtils.toList(list, UserVo::new);
        Map<Long, DeptVo> map = EntityUtils.toMap(deptVos, DeptVo::getDeptId, e -> e);
        userVos.forEach(e -> e.setDeptName(map.get(e.getDeptId()).getDeptName()));
        return userVos;
    }

    @Override
    public IPage<UserVo> selectUserPage1() {
        Page<User> page = new Page<>(1, 5);
        Page<User> userPage = this.page(page);
        IPage<UserVo> userVoIPage = EntityUtils.toPage(userPage, UserVo::new);
        Set<Long> deptIds = EntityUtils.toSet(userVoIPage.getRecords(), UserVo::getDeptId);
        if (deptIds.size() > 0) {
            LambdaQueryWrapper<Dept> in =
                    Wrappers.lambdaQuery(Dept.class)
                            .in(Dept::getDeptId, deptIds)
                            .select(Dept::getDeptId, Dept::getDeptName);
            List<Dept> deptList = deptService.list(in);
            Map<Long, Dept> map = EntityUtils.toMap(deptList, Dept::getDeptId, e -> e);
            userVoIPage.getRecords().forEach(e -> e.setDeptName(map.get(e.getDeptId()).getDeptName()));
        }
        return userVoIPage;
    }

    @Override
    public IPage<UserVo> selectUserPage2() {
        Page<User> page = new Page<>(1, 5);
        LambdaQueryWrapper<User> gt = Wrappers.lambdaQuery(User.class).gt(User::getAge, 20);
        Page<User> userPage = this.page(page, gt);
        IPage<UserVo> userVoIPage = EntityUtils.toPage(userPage, UserVo::new);
        Set<Long> deptIds = EntityUtils.toSet(userVoIPage.getRecords(), User::getDeptId);
        if (deptIds.size() > 0) {
            LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class)
                    .in(Dept::getDeptId, deptIds)
                    .select(Dept::getDeptId, Dept::getDeptName);
            List<Dept> deptList = deptService.list(wrapper);
            Map<Long, Dept> map = EntityUtils.toMap(deptList, Dept::getDeptId, e -> e);
            userVoIPage.getRecords().forEach(e -> e.setDeptName(map.get(e.getDeptId()).getDeptName()));
        }
        return userVoIPage;
    }

    @Override
    public IPage<UserVo> selectUserPage3() {
        Page<User> page = new Page<>(1, 5);
        LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class).eq(Dept::getDeptName, "Tomcat");
        List<Dept> deptList = deptService.list(wrapper);
        Set<Long> deptIds = EntityUtils.toSet(deptList, Dept::getDeptId);
        LambdaQueryWrapper<User> in = Wrappers.lambdaQuery(User.class).in(User::getDeptId, deptIds);
        Page<User> userPage = this.page(page, in);
        Map<Long, Dept> map = EntityUtils.toMap(deptList, Dept::getDeptId, e -> e);
        IPage<UserVo> userVoIPage = EntityUtils.toPage(userPage, UserVo::new);
        userVoIPage.getRecords().forEach(e -> e.addDeptInfo(map.get(e.getDeptId())));
        return userVoIPage;
    }

    /**
     * 代码优化
     */
    public IPage<UserVo> selectUserPage5() {
        Page<User> page = new Page<>(1, 5);
        LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class).eq(Dept::getDeptName, "Tomcat");
        List<Dept> deptList = deptService.list(wrapper);
        Set<Long> deptIds = EntityUtils.toSet(deptList, Dept::getDeptId);
        LambdaQueryWrapper<User> in = Wrappers.lambdaQuery(User.class).in(User::getDeptId, deptIds);
        Page<User> userPage = this.page(page, in);
        Map<Long, Dept> map = EntityUtils.toMap(deptList, Dept::getDeptId, e -> e);
        IPage<UserVo> userVoIPage = EntityUtils.toPage(userPage, UserVo::new);
        userVoIPage.getRecords().forEach(e -> e.addDeptInfo(map.get(e.getDeptId())));
        return userVoIPage;
    }


}
