package org.dog.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 书籍
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo extends User {

    private String deptName;

    private String tel;

    public UserVo(User user) {
        super(user);
    }

    /**
     * 注入属性
     */
    public void addDeptInfo(Dept dept) {
        this.deptName = dept.getDeptName();
        this.tel = dept.getTel();
    }
}
