package org.dog.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.User;

/**
 * @Author: Odin
 * @Date: 2023/2/27 12:51
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserPo {

    private Long userId;
    private String userName;
    private Long deptId;
    /**
     * 实现User转化为UserPO
     */
    public NewUserPo(NewUserPo user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.deptId = user.getDeptId();
    }

    public NewUserPo(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.deptId = user.getDeptId();
    }
}
