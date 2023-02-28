package org.dog.server.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 书籍
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String sex;
    private Integer regionId;
    private Integer postId;

    public User(User user) {
        if (Objects.nonNull(user)) {
            this.userId = user.userId;
            this.userName = user.userName;
            this.age = user.age;
            this.deptId = user.deptId;
            this.gmtCreate = user.gmtCreate;
            this.gmtModified = user.gmtModified;
            this.sex = user.sex;
            this.regionId = user.regionId;
            this.postId = user.postId;
        }
    }

    /**
     * 添加按照定序排序作为参数的构造器
     * @param userId
     */
    public User(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserId().equals(user.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
}
