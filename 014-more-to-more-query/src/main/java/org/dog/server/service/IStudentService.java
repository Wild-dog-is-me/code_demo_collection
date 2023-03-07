package org.dog.server.service;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.Student;
import org.dog.server.entity.StudentVo;

public interface IStudentService extends IService<Student>{
    public StudentVo getStudent3(Integer stuId);
}
