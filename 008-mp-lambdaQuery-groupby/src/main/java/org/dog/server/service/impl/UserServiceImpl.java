package org.dog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;
import org.dog.server.domain.UserAggr;
import org.dog.server.entity.UserAggrVo;
import org.dog.server.mapper.DeptMapper;
import org.dog.server.mapper.UserAggrMapper;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.IUserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private DeptMapper deptMapper;

    @Resource
    private UserAggrMapper userAggrMapper;

    /**
     * 场景1：统计每个部门下的用户数
     */
    public List<UserAggr> selectList1() {
        LambdaQueryWrapper<UserAggr> wrapper
                = Wrappers.lambdaQuery(UserAggr.class)
                .select(UserAggr::getDeptId, UserAggr::getCount)
                .groupBy(UserAggr::getDeptId);
        return userAggrMapper.selectList(wrapper);
    }

    /**
     * 场景二：统计 部门ID-部门名称-部门人数
     */
    public List<UserAggrVo> selectList2() {
        LambdaQueryWrapper<UserAggr> wrapper  =Wrappers.lambdaQuery(UserAggr.class)
                .select(UserAggr ::getDeptId,UserAggr ::getCount)
                .groupBy(UserAggr::getDeptId);
        List<UserAggr> userAggrs = userAggrMapper.selectList(wrapper);
        List<UserAggrVo> userAggrVos = EntityUtils.toList(userAggrs, UserAggrVo::new);
        if (userAggrVos.size() > 0) {
            Set<Long> deptIds = EntityUtils.toSet(userAggrVos, UserAggrVo::getDeptId);
            List<Dept> deptList = deptMapper.selectList(Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds));
            Map<Long, String> map = EntityUtils.toMap(deptList, Dept::getDeptId, Dept::getDeptName);
            userAggrVos.forEach(e -> e.setDeptName(map.get(e.getDeptId())));
        }
        return userAggrVos;
    }
}
