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
 * @Author: Odin
 * @Date: 2023/2/27 09:43
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_dept")
public class Dept {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long deptId;
    private String deptName;
    private String tel;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;

    public Dept(Dept dept) {
        if (Objects.nonNull(dept)) {
            this.deptId = dept.deptId;
            this.deptName = dept.deptName;
            this.gmtCreate = dept.gmtCreate;
            this.gmtModified = dept.gmtModified;
            this.tel = dept.tel;
        }
    }

}
