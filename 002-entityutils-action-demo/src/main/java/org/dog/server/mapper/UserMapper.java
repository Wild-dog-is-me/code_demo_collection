package org.dog.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dog.server.domain.User;

/**
 * @Author: Odin
 * @Date: 2023/2/27 00:14
 * @Description:
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {


}
