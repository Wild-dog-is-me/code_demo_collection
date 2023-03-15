package org.dog.server.domain;
import com.baomidou.mybatisplus.annotation.*;

import lombok.*;
import org.dog.server.entity.base.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "org_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String email;

}
