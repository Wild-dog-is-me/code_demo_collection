package org.dog.server.entity;

/**
 * @author <a href="http://www.altitude.xin" target="_blank">Java知识图谱</a>
 * @author <a href="https://gitee.com/decsa/ucode-cms-vue" target="_blank">UCode CMS</a>
 * @author <a href="https://space.bilibili.com/1936685014" target="_blank">B站视频</a>
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.User;

/**
 * 用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO extends User {
    private String deptName;

    public UserVO(User user) {
        super(user);
    }
}
