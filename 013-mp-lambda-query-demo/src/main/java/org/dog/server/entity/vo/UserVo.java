package org.dog.server.entity.vo;

import lombok.*;
import lombok.experimental.Accessors;
import org.dog.server.domain.User;

/**
 * @Author: Odin
 * @Date: 2023/3/5 16:23
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ToString(callSuper = true)
public class UserVo extends User {

    private String deptName;

    public UserVo(User user) {
        super(user);
    }

}
