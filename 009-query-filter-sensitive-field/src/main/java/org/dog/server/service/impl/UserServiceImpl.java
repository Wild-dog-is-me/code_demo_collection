package org.dog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;
import org.dog.server.entity.NewUserVo;
import org.dog.server.entity.UserPo;
import org.dog.server.entity.UserVo;
import org.dog.server.mapper.DeptMapper;
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

    /**
     * 方法一：在实体类字段上添加 JsonIgnore 注解
     * 注意：它会与JsonFormat冲突（导致JsonIgnore注解不生效）
     */
    public List<UserVo> selectUserList1() {
        List<User> userList = this.list();
        List<UserVo> userVoList = EntityUtils.toList(userList, UserVo::new);
        Set<Long> deptIds = EntityUtils.toSet(userVoList, UserVo::getDeptId);
        if (userVoList.size() > 0) {
            LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds)
                    .select(Dept::getDeptId, Dept::getDeptName, Dept::getTel);
            List<Dept> deptList = deptMapper.selectList(wrapper);
            Map<Long, Dept> map = EntityUtils.toMap(deptList, Dept::getDeptId, e -> e);
            for (UserVo userVo : userVoList) {
                Dept dept = map.get(userVo.getDeptId());
                userVo.setDeptName(dept.getDeptName());
                userVo.setTel(dept.getTel());
            }
        }
        return userVoList;
    }

    /**
     * 方法二：三层转换过滤属性
     * @return
     */
    public List<NewUserVo> selectUserList2() {
        List<User> userList = this.list();
        List<UserPo> userPos = EntityUtils.toList(userList, UserPo::new);
        List<NewUserVo> userVos = EntityUtils.toList(userPos, NewUserVo::new);
        Set<Long> deptIds = EntityUtils.toSet(userVos, NewUserVo::getDeptId);
        if (deptIds.size() > 0) {
            LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds)
                    .select(Dept::getDeptId, Dept::getDeptName, Dept::getTel);
            List<Dept> deptList = deptMapper.selectList(wrapper);
            Map<Long, Dept> map = EntityUtils.toMap(deptList, Dept::getDeptId);
            for (NewUserVo userVo : userVos) {
                Dept dept = map.get(userVo.getDeptId());
                userVo.setDeptName(dept.getDeptName());
                userVo.setTel(dept.getTel());
            }
        }
        return userVos;
    }

    /**
     * 方法三：设置为null
     */
    public List<UserVo> selectUserList3() {
        List<User> userList = this.list();
        List<UserVo> userVoList = EntityUtils.toList(userList, UserVo::new);
        Set<Long> deptIds = EntityUtils.toSet(userVoList, UserVo::getDeptId);
        if (userVoList.size() > 0) {
            LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds)
                    .select(Dept::getDeptId, Dept::getDeptName, Dept::getTel);
            List<Dept> deptList = deptMapper.selectList(wrapper);
            Map<Long, Dept> map = EntityUtils.toMap(deptList, Dept::getDeptId, e -> e);
            for (UserVo userVo : userVoList) {
                Dept dept = map.get(userVo.getDeptId());
                userVo.setDeptName(dept.getDeptName());
                userVo.setTel(dept.getTel());
                // 直接设置为空
//                userVo.setGmtCreate(null);
//                userVo.setGmtModified(null);
            }
        }
        return userVoList;
    }

}
