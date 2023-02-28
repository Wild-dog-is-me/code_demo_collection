package org.dog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;

import java.util.Map;

/**
 * @Author: Odin
 * @Date: 2023/2/27 00:12
 * @Description:
 */

public interface UserService extends IService<User> {

    public Map<Long, Long> selectUserList1();

    public Map<Long, Long> selectUserList2();

    public Map<String, Double> selectUserList3();

    public Map<String, Long> selectUserList4();

    public Map<String, Long> selectUserList5();

    public Map<String, Long> selectUserList6();
}
