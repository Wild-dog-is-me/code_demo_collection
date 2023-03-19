package org.dog.server.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dog.server.domain.User;
import org.springframework.transaction.annotation.Transactional;
import xin.altitude.cms.common.support.CacheBaseMapper;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface UserMapper extends CacheBaseMapper<User> {
}
