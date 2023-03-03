package org.dog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.domain.UserAggr;
import org.dog.server.entity.UserAggrVo;
import org.dog.server.mapper.DeptMapper;
import org.dog.server.mapper.UserAggrMapper;
import org.dog.server.service.IUserAggrService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;

import javax.annotation.Resource;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserAggrServiceImpl extends ServiceImpl<UserAggrMapper, UserAggr> implements IUserAggrService {

    @Resource
    private UserAggrMapper userAggrMapper;

    @Resource
    private DeptMapper deptMapper;

    public List<UserAggr> selectUserList1() {
        LambdaQueryWrapper<UserAggr> wrapper = Wrappers.lambdaQuery(UserAggr.class).groupBy(UserAggr::getDeptId);
        return this.list(wrapper);
    }

    public List<UserAggrVo> selectUserList2() {
        LambdaQueryWrapper<UserAggr> wrapper = Wrappers.lambdaQuery(UserAggr.class).groupBy(UserAggr::getDeptId);
        List<UserAggr> userList = this.list(wrapper);
        List<UserAggrVo> userAggrVos = EntityUtils.toList(userList, UserAggrVo::new);
        if (userAggrVos.size() > 0) {
            Set<Long> deptIds = EntityUtils.toSet(userList, UserAggr::getDeptId);
            List<Dept> deptList = deptMapper.selectList(Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds));
            Map<Long, String> map = EntityUtils.toMap(deptList, Dept::getDeptId, Dept::getDeptName);
            userAggrVos.forEach(e -> e.setDeptName(map.get(e.getDeptId())));
        }
        return userAggrVos;
    }
}
