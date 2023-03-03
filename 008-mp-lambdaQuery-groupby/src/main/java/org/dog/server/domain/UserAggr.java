package org.dog.server.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_user")
public class UserAggr {

    private Long deptId;

    /**
     * 新增一列数据 用于存储count字段
     * 注解很关键
     */
    @TableField(value = "count(*)", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Long count;

    @TableField(value = "sum(age)", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Long sumAge;

    @TableField(value = "max(age)", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Long maxAge;

    @TableField(value = "min(age)", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Long minAge;

    @TableField(value = "avg(age)", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Double avgAge;

    public UserAggr(UserAggr user) {
        if (Objects.nonNull(user)) {
            this.deptId = user.deptId;
            this.count = user.count;
            this.sumAge = user.sumAge;
            this.maxAge = user.maxAge;
            this.minAge = user.minAge;
            this.avgAge = user.avgAge;
        }
    }
}
