package org.dog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;
import org.dog.server.entity.vo.DeptVo;
import org.dog.server.mapper.DeptMapper;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IDeptService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.ColUtils;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.MapUtils;

import javax.annotation.Resource;
import javax.swing.text.html.parser.Entity;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Resource
    private UserMapper userMapper;

    @Override
    public DeptVo selectDeptList1(Long deptId) {
        Dept dept = this.getById(deptId);
        DeptVo deptVo = EntityUtils.toObj(dept, DeptVo::new);
        List<User> userList = userMapper.selectList(Wrappers.lambdaQuery(User.class).eq(User::getDeptId, deptVo.getDeptId()));
        deptVo.setUserList(userList);
        return deptVo;
    }

    @Override
    public List<DeptVo> selectDeptList2() {
        List<Dept> deptList = this.list();
        List<DeptVo> deptVos = EntityUtils.toList(deptList, DeptVo::new);
        Set<Long> deptIds = EntityUtils.toSet(deptVos, DeptVo::getDeptId);
        if (deptIds.size() > 0) {
            LambdaQueryWrapper<User> in = Wrappers.lambdaQuery(User.class).in(User::getDeptId, deptIds);
            List<User> userList = userMapper.selectList(in);
            Map<Long, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getDeptId));
            deptVos.forEach(e -> e.setUserList(collect.get(e.getDeptId())));
        }
        return deptVos;
    }

    @Override
    public List<DeptVo> selectDeptList3() {
        List<Dept> list = this.list();
        List<DeptVo> deptVos = EntityUtils.toList(list, DeptVo::new);
        Set<Long> deptIds = EntityUtils.toSet(deptVos, DeptVo::getDeptId);
        if (deptIds.size() > 0) {
            LambdaQueryWrapper<User> in = Wrappers.lambdaQuery(User.class).in(User::getDeptId, deptIds);
            List<User> userList = userMapper.selectList(in);
            Map<Long, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getDeptId));
            Map<Long, User> transMap = MapUtils.transMap(collect, e -> e.stream().max(Comparator.comparingInt(User::getAge)).orElse(null));
            System.out.println(transMap);
            deptVos.forEach(e -> e.setUserList(ColUtils.toCol(transMap.get(e.getDeptId()))));
        }
        return deptVos;
    }
}
