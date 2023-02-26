package org.dog.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dog.server.domain.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Odin
 * @Date: 2023/2/26 23:05
 * @Description:
 */

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface UserMapper extends BaseMapper<User> {
}
