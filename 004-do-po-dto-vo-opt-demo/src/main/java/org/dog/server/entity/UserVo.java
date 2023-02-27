package org.dog.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.User;

/**
 * @Author: Odin
 * @Date: 2023/2/27 20:09
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
