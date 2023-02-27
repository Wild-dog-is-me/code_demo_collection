package org.dog.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dog.server.domain.Dept;
import org.dog.server.domain.User;
import org.dog.server.mapper.DeptMapper;
import org.dog.server.mapper.UserMapper;
import org.dog.server.service.DeptService;
import org.dog.server.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: Odin
 * @Date: 2023/2/27 18:49
 * @Description:
 */

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
