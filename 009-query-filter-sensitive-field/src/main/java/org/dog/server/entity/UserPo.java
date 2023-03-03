package org.dog.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.User;

import java.util.Objects;

/**
 * @Author: Odin
 * @Date: 2023/3/3 14:25
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPo {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String userName;
    private Integer age;
    private Long deptId;
    @JsonIgnore
    private String sex;

    public UserPo(UserPo user) {
        if (Objects.nonNull(user)) {
            this.userId = user.userId;
            this.userName = user.userName;
            this.age = user.age;
            this.deptId = user.deptId;
            this.sex = user.sex;
        }
    }

    public UserPo(User user) {
        if (Objects.nonNull(user)) {
            this.userId = user.getUserId();
            this.age = user.getAge();
            this.userName = user.getUserName();
            this.deptId = user.getDeptId();
        }
    }
}
