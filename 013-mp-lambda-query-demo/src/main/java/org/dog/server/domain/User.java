package org.dog.server.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 书籍
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_user")
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String userName;
    private Long deptId;
    private Integer age;

    public User(User user) {
        if (Objects.nonNull(user)) {
            this.userId = user.userId;
            this.userName = user.userName;
            this.deptId = user.deptId;
        }
    }
}
