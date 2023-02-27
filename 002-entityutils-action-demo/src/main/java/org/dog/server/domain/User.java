package org.dog.server.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.entity.UserVO;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_user")
public class User{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String userName;
    private Integer age;
    private String email;
    private Long deptId;
    private String deptName;
    private Boolean deleted;
    private Integer version;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;

    public User(User user) {
        if (Objects.nonNull(user)) {
            this.userId=user.userId;
            this.userName=user.userName;
            this.age=user.age;
            this.email=user.email;
            this.deptId=user.deptId;
            this.deleted=user.deleted;
            this.version=user.version;
            this.gmtCreate=user.gmtCreate;
            this.gmtModified=user.gmtModified;
        }
    }
}
