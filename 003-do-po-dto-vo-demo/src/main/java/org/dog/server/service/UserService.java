package org.dog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;
import org.dog.server.entity.NewUserVo;
import org.dog.server.entity.UserPo;
import org.dog.server.entity.UserVO;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Odin
 * @Date: 2023/2/27 00:12
 * @Description:
 */

public interface UserService extends IService<User> {

    public List<UserPo> selectUser1();

    public List<UserVO> selectUser2();

    public List<UserVO> selectUser3();

    public List<NewUserVo> selectUserList4();

}
