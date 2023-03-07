package org.dog.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dog.server.domain.Subject;

/**
 * @Author: Odin
 * @Date: 2023/3/7 16:24
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectBo extends Subject {
    private Integer score;

    public SubjectBo(Subject subject) {
        super(subject);
    }
}
