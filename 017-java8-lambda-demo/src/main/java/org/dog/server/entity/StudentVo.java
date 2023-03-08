package org.dog.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.Student;

/**
 * @Author: Odin
 * @Date: 2023/3/8 16:18
 * @Description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo {

    private Integer studentId;
    private String studentName;
    private String studentSex;

    public StudentVo(Student student) {
        this.studentId = student.getStuId();
        this.studentName = student.getStuName();
        this.studentSex = student.getStuSex();
    }
}
