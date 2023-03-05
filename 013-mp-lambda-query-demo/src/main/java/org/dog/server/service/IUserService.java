package org.dog.server.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.dog.server.domain.User;
import org.dog.server.entity.vo.UserVo;

import java.util.List;

public interface IUserService extends IService<User>{

    /**
     * 查询单个信息
     */
    UserVo getOneUser(Integer userId);

    /**
     * 带条件查询用户表与部门表连接后的数据（条件在主表user表中筛选）
     */
    public List<UserVo> findUserByAge();

    /**
     * 带条件查询用户表与部门表连接后的数据（条件在副表dept表中筛选）
     */
    public List<UserVo> findUserByDeptName();

}
