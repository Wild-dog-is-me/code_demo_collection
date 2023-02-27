package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;
import org.dog.server.entity.UserVo;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.UserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.FieldInjectUtils;

import java.util.List;

/**
 * @Author: Odin
 * @Date: 2023/2/27 00:13
 * @Description:
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * DO 返回到控制器
     */
    public List<User> selectUserList1() {
        return this.list();
    }

    public List<UserVo> selectUserList2() {
        List<User> userList = this.list();
        List<UserVo> userVoList = EntityUtils.toList(userList, UserVo::new);

        // 新型的属性注入过程
        FieldInjectUtils.injectField(userVoList,
                UserVo::getDeptId,
                DeptServiceImpl.class,
                Dept::getDeptId,
                UserVo::getTel,
                UserVo::getDeptName);
        return userVoList;
    }
}
