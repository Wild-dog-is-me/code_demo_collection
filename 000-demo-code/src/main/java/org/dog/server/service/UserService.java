package org.dog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;
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

    public UserVO selectUser3();

    public List<UserVO> selectUser6();

    public Map selectUser7();

    public Set<Long> selectUser8();

    public Map<Long, List<String>> selectUser9();
}
