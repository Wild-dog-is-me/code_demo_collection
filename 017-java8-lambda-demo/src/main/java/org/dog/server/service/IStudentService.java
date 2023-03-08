package org.dog.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.Student;
import org.dog.server.entity.StudentVo;

import java.util.List;
import java.util.Map;

public interface IStudentService extends IService<Student> {

    /**
     * 横向筛选数据
     */
    public List<Student> listStudent1();

    /**
     * 纵向筛选切片数据
     */
    public List<Integer> listStudent2();

    /**
     * 纵向切片筛选多列数据
     */
    public List<StudentVo> listStudent3();

    /**
     * 先纵向筛选，再横向筛选
     */
    public List<StudentVo> listStudent4();

    /**
     * 按照条件分组
     */
    public Map<String, List<Student>> listStudent5();

    /**
     * 求最值操作
     */
    public Student listStudent6();

    /**
     * 分组求最值
     */
    public Map<String,Student> listStudent7();
}
