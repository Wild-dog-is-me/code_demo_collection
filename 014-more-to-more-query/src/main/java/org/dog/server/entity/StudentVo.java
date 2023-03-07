package org.dog.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.Student;

import java.util.List;

/**
 * @Author: Odin
 * @Date: 2023/3/7 16:24
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo extends Student {

    List<SubjectBo> subjectBos;

    public StudentVo(Student student) {
        super(student);
    }
}
