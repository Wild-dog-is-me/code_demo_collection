package org.dog.server.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.entity.UserDTO;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: Odin
 * @Date: 2023/2/26 22:39
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_user")
public class User {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String userName;
    private Integer age;
    private Long deptId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;

    public User(User user) {
        if (Objects.nonNull(user)) {
            this.userId = user.userId;
            this.userName = user.userName;
            this.age = user.age;
            this.deptId = user.deptId;
            this.gmtCreate = user.gmtCreate;
            this.gmtModified = user.gmtModified;
        }
    }

    /**
     * 实现UserDTO转User
     */
    public User(UserDTO userDTO) {
        if (Objects.nonNull(userDTO)) {
            this.userId = userDTO.getUserId();
            this.age = userDTO.getAge();
        }
    }

}
