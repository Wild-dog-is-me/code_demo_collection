package org.dog.server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;
import org.dog.server.entity.NewUserPo;
import org.dog.server.entity.NewUserVo;
import org.dog.server.entity.UserPo;
import org.dog.server.entity.UserVO;
import org.dog.server.mapper.DeptMapper;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.UserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author: Odin
 * @Date: 2023/2/27 00:13
 * @Description:
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private DeptMapper deptMapper;

    /**
     * DO转PO返回
     */
    public List<UserPo> selectUser1() {
        List<User> userList = this.list();
        return EntityUtils.toList(userList, UserPo::new);
    }

    /**
     * DO转VO返回
     */
    public List<UserVO> selectUser2() {
        List<User> userList = this.list();
        return EntityUtils.toList(userList, UserVO::new);
    }

    /**
     * DO转PO转VO返回
     */
    public List<UserVO> selectUser3() {
        List<User> userList = this.list();
        List<UserVO> userVOList = EntityUtils.toList(userList, UserVO::new);
        if (userVOList.size() > 0) {
            Set<Long> deptIds = EntityUtils.toSet(userVOList, UserVO::getDeptId);
            System.out.println(deptIds);
            List<Dept> deptList = deptMapper.selectList(Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds));
            Map<Long, String> map = EntityUtils.toMap(deptList, Dept::getDeptId, Dept::getDeptName);
            for (UserVO userVO : userVOList) {
                userVO.setDeptName(map.get(userVO.getDeptId()));
            }
        }
        return userVOList;
    }

    public List<NewUserVo> selectUserList4() {
        // DO
        List<User> userList = this.list();
        // PO
        List<NewUserPo> newUserPoList = EntityUtils.toList(userList, NewUserPo::new);
        // VO
        List<NewUserVo> newUserVoList = EntityUtils.toList(newUserPoList, NewUserVo::new);

        if (newUserVoList.size() > 0) {
            Set<Long> deptIds = EntityUtils.toSet(newUserVoList, NewUserVo::getDeptId);
            List<Dept> deptList = deptMapper.selectList(Wrappers.lambdaQuery(Dept.class).in(Dept::getDeptId, deptIds));
            Map<Long, String> map = EntityUtils.toMap(deptList, Dept::getDeptId, Dept::getDeptName);
            for (NewUserVo newUserVo : newUserVoList) {
                newUserVo.setDeptName(map.get(newUserVo.getDeptId()));
            }
        }
        return newUserVoList;
    }
}
