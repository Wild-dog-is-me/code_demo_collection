package org.dog.server.entity;

import org.dog.server.domain.User;

/**
 * @Author: Odin
 * @Date: 2023/3/8 11:32
 * @Description:
 */
public class UserVo extends User {

    private String deptName;

    public UserVo(User user) {
        super(user);
    }
}
