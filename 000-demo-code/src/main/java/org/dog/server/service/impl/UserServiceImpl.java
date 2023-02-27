package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.User;
import org.dog.server.entity.UserVO;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.UserService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;

import java.util.*;

/**
 * @Author: Odin
 * @Date: 2023/2/27 00:13
 * @Description:
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 使用EntityUtils将对象类型转化成另一种类型
     */
    public void selectUser1() {
        User user = this.getById(3);
        Long userId = EntityUtils.toObj(user, User::getUserId);
    }

    /**
     * 传统写法
     */
    public void selectUser2() {
        User user = this.getById(3);
        if (user != null) {
            Long userId = user.getUserId();
        }
    }

    /**
     * 数据模型转换 PO 转 VO
     */
    public UserVO selectUser3() {
        User user = this.getById(3);
        return EntityUtils.toObj(user, UserVO::new);
    }

    /**
     * 查询User所有数据，返回主键组成的集合
     */
    public List<Long> selectUser4() {
        List<User> userList = this.list();
        return EntityUtils.toList(userList, User::getUserId);
    }

    /**
     * 传统方法
     */
    public List<Long> selectUser5() {
        List<User> userList = this.list();
        List<Long> res = new ArrayList<>();
        for (User user : userList) {
            if (Objects.nonNull(user)) {
                res.add(user.getUserId());
            }
        }
        return res;
    }

    public List<UserVO> selectUser6() {
        List<User> userList = this.list();
        // 方式一（需要在Vo中添加构造器）-> 若无构造器，在使用此方法在编写代码时会提示错误
        List<UserVO> userVOList = EntityUtils.toList(userList, UserVO::new);
        // 方式二（需要在Vo中添加构造器）-> 若无构造器，在使用此方法在运行代码时会提示错误
        List<UserVO> userVOS = EntityUtils.toList(userList, UserVO.class);
        return userVOS;
    }

    public Map selectUser7() {
        List<User> userList = this.list();
        // 以id为键,user信息为值
        Map<Long, User> userMap = EntityUtils.toMap(userList, User::getUserId);
        // 以id为键，username为值
        Map<Long, String> stringMap = EntityUtils.toMap(userList, User::getUserId, User::getUserName);
        return stringMap;
    }

    /**
     * toSet和toList有很多相似之处，但Set可以实现去重
     */
    public Set<Long> selectUser8() {
        List<User> userList = this.list();
        return EntityUtils.toSet(userList, User::getUserId);
        // 批查询
    }

    /**
     * 使用groupBy进行分组，一般使用外键进行分组
     * @return
     */
    public Map<Long, List<String>> selectUser9() {
        List<User> userList = this.list();
        Map<Long, List<User>> longListMap = EntityUtils.groupBy(userList, User::getDeptId);
        Map<Long, List<String>> longListMap1 = EntityUtils.groupBy(userList, User::getDeptId, User::getUserName);
        return longListMap1;
    }

}
