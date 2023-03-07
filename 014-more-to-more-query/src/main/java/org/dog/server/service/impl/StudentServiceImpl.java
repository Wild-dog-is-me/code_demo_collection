package org.dog.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Table;
import org.dog.server.domain.StuSubRelation;
import org.dog.server.domain.Student;
import org.dog.server.domain.Subject;
import org.dog.server.entity.StudentVo;
import org.dog.server.entity.SubjectBo;
import org.dog.server.mapper.StuSubRelationMapper;
import org.dog.server.mapper.StudentMapper;
import org.dog.server.mapper.SubjectMapper;
import org.dog.server.service.IStudentService;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.EntityUtils;
import xin.altitude.cms.common.util.TableUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Resource
    private StuSubRelationMapper stuSubRelationMapper;

    @Resource
    private SubjectMapper subjectMapper;

    /**
     * 演示一
     *
     * @param stuId
     * @return
     */
    public StudentVo getStudent1(Integer stuId) {
        Student student = this.getById(stuId);
        if (student != null) {
            return EntityUtils.toObj(student, StudentVo::new);
        }
        return null;
    }

    /**
     * 演示二
     *
     * @param stuId
     * @return
     */
    public StudentVo getStudent2(Integer stuId) {
        Student student = this.getById(stuId);
        if (student != null) {
            StudentVo studentVo = EntityUtils.toObj(student, StudentVo::new);
            LambdaQueryWrapper<StuSubRelation> eq =
                    Wrappers.lambdaQuery(StuSubRelation.class).eq(StuSubRelation::getStuId, student.getStuId());
            List<StuSubRelation> stuSubRelations = stuSubRelationMapper.selectList(eq);
            Set<Integer> subIds = EntityUtils.toSet(stuSubRelations, StuSubRelation::getSubId);
            Table<Integer, Integer, Integer> table = TableUtils.createHashTable(stuSubRelations);
            if (!subIds.isEmpty()) {
                List<Subject> subjectList = subjectMapper.selectBatchIds(subIds);
                List<SubjectBo> subjectBoList = EntityUtils.toList(subjectList, SubjectBo::new);
                studentVo.setSubjectBos(subjectBoList);
                return studentVo;
            }
        }
        return null;
    }


    /**
     * 演示三
     */
    public StudentVo getStudent3(Integer stuId) {
        Student student = this.getById(stuId);
        StudentVo studentVo = EntityUtils.toObj(student, StudentVo::new);
        LambdaQueryWrapper<StuSubRelation> eq =
                Wrappers.lambdaQuery(StuSubRelation.class).eq(StuSubRelation::getStuId, studentVo.getStuId());
        List<StuSubRelation> stuSubRelations = stuSubRelationMapper.selectList(eq);
        Set<Integer> stuIds = EntityUtils.toSet(stuSubRelations, StuSubRelation::getStuId);
        if (!stuIds.isEmpty()) {
            List<Subject> subjects = subjectMapper.selectBatchIds(stuIds);
            Table<Integer, Integer, Integer> hashTable = TableUtils.createHashTable(stuSubRelations);
            List<SubjectBo> subjectBoList = EntityUtils.toList(subjects, SubjectBo::new);
            subjectBoList.forEach(e -> e.setScore(hashTable.get(e.getSubId(), student.getStuId())));
            studentVo.setSubjectBos(subjectBoList);
            return studentVo;
        }
        return null;
    }
}
