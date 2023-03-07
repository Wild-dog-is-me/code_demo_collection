package org.dog.server.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Subject;
import org.dog.server.mapper.SubjectMapper;
import org.dog.server.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper,Subject> implements ISubjectService{
}
