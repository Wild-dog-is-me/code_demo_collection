package org.dog.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.dog.server.domain.User;

/**
 * @Author: Odin
 * @Date: 2023/2/27 12:51
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPo {

    private Long userId;
    private String userName;

    /**
     * 实现User转化为UserPO
     */
    public UserPo(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
    }
}
