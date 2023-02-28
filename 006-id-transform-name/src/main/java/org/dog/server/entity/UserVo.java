package org.dog.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.User;

/**
 * @Author: Odin
 * @Date: 2023/2/28 15:26
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo extends User {

    // 部门名称
    private String deptName;

    // 职位名称
    private String postName;

    // 地区名称
    private String regionName;

    /**
     * 特定构造方法
     */
    public UserVo(User user) {
        super(user);
    }
}
