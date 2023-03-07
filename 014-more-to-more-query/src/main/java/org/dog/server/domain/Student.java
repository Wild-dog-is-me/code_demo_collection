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
/** 学生表 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_student")
public class Student{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer stuId;
    private String stuName;
    
    public Student(Student student) {
        if (Objects.nonNull(student)) {
            this.stuId=student.stuId;
            this.stuName=student.stuName;
        }
    }
}
