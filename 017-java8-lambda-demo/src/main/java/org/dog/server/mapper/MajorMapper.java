package org.dog.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dog.server.domain.Major;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface MajorMapper extends BaseMapper<Major> {
}
