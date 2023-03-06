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

    /**
     * 无筛选条件分页查询用户表关联数据（对部门表中的空属性完成赋值）
     */
    public IPage<UserVo> selectUserPage1();

    /**
     * 主表（用户表）中添加查询条件 筛选条件分页查询用户表关联数据（对部门表中对空属性完成赋值）
     */
    public IPage<UserVo> selectUserPage2();

    /**
     * 从表（部门表）中添加查询条件 筛选条件分页查询用户表关联数据（对部门表中对空属性完成赋值）
     */
    public IPage<UserVo> selectUserPage3();



}
