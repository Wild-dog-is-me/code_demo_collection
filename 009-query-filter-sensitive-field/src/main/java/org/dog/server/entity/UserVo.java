package org.dog.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.User;

/**
 * @Author: Odin
 * @Date: 2023/3/3 12:53
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo extends User {

    private String deptName;

    private String tel;

    public UserVo(User user) {
        super(user);
    }
}
