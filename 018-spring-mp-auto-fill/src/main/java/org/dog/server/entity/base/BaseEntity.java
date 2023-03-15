package org.dog.server.entity.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Odin
 * @Date: 2023/3/14 18:47
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @TableField(value = "create_by", fill = FieldFill.INSERT, update = "admin")
    private String createBy;

    @TableField(value = "update_by", fill = FieldFill.UPDATE, update = "admin")
    private String updateBy;

}
