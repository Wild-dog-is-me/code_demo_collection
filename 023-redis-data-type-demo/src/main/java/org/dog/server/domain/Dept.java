package org.dog.server.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
/** 部门 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_dept")
public class Dept{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long deptId;
    private String deptName;
    private String tel;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;
    private Integer sort;
    
    public Dept(Dept dept) {
        if (Objects.nonNull(dept)) {
            this.deptId=dept.deptId;
            this.deptName=dept.deptName;
            this.tel=dept.tel;
            this.gmtCreate=dept.gmtCreate;
            this.gmtModified=dept.gmtModified;
            this.sort=dept.sort;
        }
    }
}
