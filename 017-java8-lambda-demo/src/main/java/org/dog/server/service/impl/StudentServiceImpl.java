package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Student;
import org.dog.server.entity.StudentVo;
import org.dog.server.mapper.StudentMapper;
import org.dog.server.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Override
    public List<Student> listStudent1() {
        return list().stream().filter(e -> e.getStuSex().equals("男")).collect(Collectors.toList());
    }

    @Override
    public List<Integer> listStudent2() {
        return list().stream().map(Student::getStuId).collect(Collectors.toList());
    }

    @Override
    public List<StudentVo> listStudent3() {
        return list().stream().map(StudentVo::new).collect(Collectors.toList());
    }

    @Override
    public List<StudentVo> listStudent4() {
        return list().stream().filter(e -> e.getStuSex().equals("男")).map(StudentVo::new).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Student>> listStudent5() {
        return list().stream().collect(Collectors.groupingBy(Student::getStuSex));
    }

    @Override
    public Student listStudent6() {
        return list().stream().max(Comparator.comparingInt(Student::getStuScore)).orElse(null);
    }

    @Override
    public Map<String, Student> listStudent7() {
        return list().stream()
                .collect(Collectors.toMap(Student::getStuSex,
                        Function.identity(),
                        (c1, c2) -> c1.getStuScore() > c2.getStuScore() ? c1 : c2));
    }
}
