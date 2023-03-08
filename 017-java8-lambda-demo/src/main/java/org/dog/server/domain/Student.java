package org.dog.server.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 学生表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_student")
public class Student {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer stuId;
    private String stuName;
    private String stuSex;
    private Integer stuAge;
    private String province;
    private Integer classId;
    private Integer stuScore;

    public Student(Student student) {
        if (Objects.nonNull(student)) {
            this.stuId = student.stuId;
            this.stuName = student.stuName;
            this.stuSex = student.stuSex;
            this.stuAge = student.stuAge;
            this.province = student.province;
            this.classId = student.classId;
            this.stuScore = student.stuScore;
        }
    }
}
