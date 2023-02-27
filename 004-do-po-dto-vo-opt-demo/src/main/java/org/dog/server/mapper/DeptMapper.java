package org.dog.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dog.server.domain.Dept;

/**
 * @Author: Odin
 * @Date: 2023/2/27 14:48
 * @Description:
 */

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}
