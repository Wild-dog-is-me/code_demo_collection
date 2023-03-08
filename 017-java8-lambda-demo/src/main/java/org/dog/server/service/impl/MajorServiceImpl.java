package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Major;
import org.dog.server.domain.Student;
import org.dog.server.entity.StudentVo;
import org.dog.server.mapper.MajorMapper;
import org.dog.server.service.IMajorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements IMajorService {
    @Override
    public Map<Long,String> selectMajor() {
        return list().stream().collect(Collectors.toMap(Major::getMajorId, Major::getMajorName));
    }

}
