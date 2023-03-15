package org.dog.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dog.server.domain.User;

/**
 * @Author: Odin
 * @Date: 2023/3/15 12:38
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
